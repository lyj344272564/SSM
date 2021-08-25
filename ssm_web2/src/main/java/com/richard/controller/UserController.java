package com.richard.controller;

import com.github.pagehelper.PageInfo;
import com.richard.domain.ResponseResult;
import com.richard.domain.UserVO;
import com.richard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
