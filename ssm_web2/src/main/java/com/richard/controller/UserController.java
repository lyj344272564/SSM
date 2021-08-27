package com.richard.controller;

import com.github.pagehelper.PageInfo;
import com.richard.domain.ResponseResult;
import com.richard.domain.Role;
import com.richard.domain.User;
import com.richard.domain.UserVO;
import com.richard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVO userVO) {

        try {

            PageInfo pageInfo = userService.findAllUserByPage(userVO);
            return new ResponseResult(true,200,"查询成功",pageInfo);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(@RequestParam Integer id, @RequestParam String status) {

        try {

            if("ENABLE".equalsIgnoreCase(status)){
                status = "DISABLE";
            } else {
                status = "ENABLE";
            }
            userService.updateUserStatus(id,status);

            return new ResponseResult(true,200,"响应成功",status);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) {
        try {

            User user2 = userService.login(user);
            if (user2 != null) {

                Map<String,Object> map = new HashMap<>();
                String access_token = UUID.randomUUID().toString();
                map.put("access_token",access_token);
                map.put("user_id",user2.getId());

                HttpSession session = request.getSession();
                session.setAttribute("user_id",user2.getId());
                session.setAttribute("access_token",access_token);

                return new ResponseResult(true,200,"登录成功",map);
            } else {
                return new ResponseResult(true,400,"用户名密码错误",null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRelationRoleById(Integer id) {

        try {

            List<Role> roleList = userService.findUserRelationRoleById(id);
            return new ResponseResult(true,200,"分配角色回显成功",roleList);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVO userVO) {
        try {

            userService.userContextRole(userVO);
            return new ResponseResult(true,200,"分配角色成功",null);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request) {


            //获取请求头中的 token
            String header_token = request.getHeader("Authorization");

            //获取session中的access_token
            String access_token = (String) request.getSession().getAttribute("access_token");

            if (header_token.equals(access_token)) {
                int user_id = (Integer)request.getSession().getAttribute("user_id");
                ResponseResult result = userService.getUserPermissions(user_id);
                return  result;
            } else {
                return new ResponseResult(false,400,"获取菜单信息失败",null);
            }

    }



}
