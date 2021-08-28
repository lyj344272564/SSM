package com.richard.controller;

import com.richard.domain.*;
import com.richard.service.MenuService;
import com.richard.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(@RequestBody Role role) {

        try {

            if (role.getId() == null) {
                roleService.saveRole(role);
                return new ResponseResult(true,200,"添加角色成功",null);
            } else {
                roleService.updateRole(role);
                return new ResponseResult(true,200,"更新角色成功",null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/findResourceCategoryByRoleId")
    public ResponseResult findResourceCategoryByRoleId(Integer id) {
        try {

            List<ResourceCategory> resourceCategoryList = roleService.findResourceCategoryByRoleId(id);
            return new ResponseResult(true,200,"查询成功",resourceCategoryList);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/findResourceByRoleId")
    public ResponseResult findResourceByRoleId(Integer id) {
        try {

            List<Resource> resourceList = roleService.findResourceByRoleId(id);
            return new ResponseResult(true,200,"查询成功",resourceList);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/findResourceListByRoleId")
    public ResponseResult findResourceListByRoleId(Integer id) {
        try {

            List<ResourceCategory> resourceCategoryList = roleService.findResourceCategoryByRoleId(id);


            for (ResourceCategory resourceCategory : resourceCategoryList) {

                resourceCategory.setResourceList(roleService.findResourceByRoleId(resourceCategory.getId()));

            }

            return new ResponseResult(true,200,"查询成功",resourceCategoryList);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/roleContextResource")
    public ResponseResult roleContextResource(@RequestBody RoleResourceVo roleResourceVo) {
        try {
            roleService.roleContextResource(roleResourceVo);
            return new ResponseResult(true,200,"分配成功",null);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
