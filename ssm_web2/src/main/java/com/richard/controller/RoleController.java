package com.richard.controller;

import com.richard.domain.Menu;
import com.richard.domain.ResponseResult;
import com.richard.domain.Role;
import com.richard.domain.RoleMenuVO;
import com.richard.service.MenuService;
import com.richard.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role) {

        try {

            List<Role> roleList = roleService.findAllRole(role);
            return new ResponseResult(true,200,"条件组合查询成功",roleList);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListByPid() {

        try {
            //-1 表示查询所有菜单数据
            List<Menu> menuList = menuService.findSubMenuListByPid(-1);
            HashMap<String, Object> map = new HashMap<>();
            map.put("parentMenuList",menuList);
            return new ResponseResult(true,200,"查询所有父子集合成功",map);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(@RequestParam Integer roleId) {

        try {
            List<Integer> menuByRoleId = roleService.findMenuByRoleId(roleId);
            return new ResponseResult(true,200,"查询成功",menuByRoleId);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/roleContextMenu")
    public ResponseResult roleContextMenu(@RequestBody RoleMenuVO roleMenuVO) {
        try {

            roleService.roleContextMenu(roleMenuVO);
            return new ResponseResult(true,200,"为角色分配菜单成功",null);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(@RequestParam Integer rid) {
        try {

            roleService.deleteRole(rid);
            return new ResponseResult(true,200,"删除角色成功",null);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
