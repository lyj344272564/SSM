package com.richard.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.richard.Md5;
import com.richard.dao.UserMapper;
import com.richard.domain.*;
import com.richard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(UserVO userVO) {
        PageHelper.startPage(userVO.getCurrentPage(),userVO.getPageSize());
        List<User> userList = userMapper.findAllUserByPage(userVO);
        PageInfo<User> userPageInfo = new PageInfo<>(userList);

        System.out.println("总条数："+userPageInfo.getTotal());
        System.out.println("总页数："+userPageInfo.getPages());
        System.out.println("当前页："+userPageInfo.getPageNum());
        System.out.println("每页显示长度："+userPageInfo.getPageSize());
        System.out.println("是否第一页："+userPageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+userPageInfo.isIsLastPage());
        return userPageInfo;
    }

    @Override
    public void updateUserStatus(Integer id, String status) {
        User user = new User();

        Date date = new Date();
        user.setUpdate_time(date);
        user.setStatus(status);
        user.setId(id);

        userMapper.updateUserStatus(user);
    }

    @Override
    public User login(User user) {

        try {
            User user2 = userMapper.login(user);

            if (user2 != null && Md5.verify(user.getPassword(),"richard",user2.getPassword())) {
                return user2;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Role> findUserRelationRoleById(Integer id) {
        return userMapper.findUserRelationRoleById(id);
    }

    @Override
    public void userContextRole(UserVO userVO) {

        userMapper.deleteUserContextRole(userVO.getUserId());
        List<Integer> roleIdList = userVO.getRoleIdList();
        for (Integer integer : roleIdList) {
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(userVO.getUserId());
            user_role_relation.setRoleId(integer);

            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);

            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedby("system");

            userMapper.userContextRole(user_role_relation);
        }

    }

    @Override
    public ResponseResult getUserPermissions(Integer id) {

        //1.获取当前用户拥有的角色
        List<Role> roleList = userMapper.findUserRelationRoleById(id);

        //2.获取角色ID,保存到 list
        List<Integer> list = new ArrayList<>();

        for (Role role : roleList) {
            list.add(role.getId());
        }

        //3.根据角色id查询 父菜单
        List<Menu> parentMenu = userMapper.findParentMenuByRoleId(list);

        //4.封装父菜单下的子菜单
        for (Menu menu : parentMenu) {
            List<Menu> subMenu = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenu);
        }

        //5.获取资源权限
        List<Resource> resourceList = userMapper.findResourceByRoleId(list);

        //6.封装数据
        Map<String,Object> map = new HashMap<>();
        map.put("menuList",parentMenu); //menuList: 菜单权限数据
        map.put("resourceList",resourceList);//resourceList: 资源权限数据

        ResponseResult result = new ResponseResult(true,200,"success",map);

        return result;
    }
}
