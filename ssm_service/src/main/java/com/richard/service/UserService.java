package com.richard.service;

import com.github.pagehelper.PageInfo;
import com.richard.domain.*;

import java.util.List;

public interface UserService {

    /**
     *  查询所有用户
     * @param userVO
     * @return
     */
    public PageInfo findAllUserByPage(UserVO userVO);


    /**
     * 修改用户状态
     * @param id
     * @param status
     */
    public void updateUserStatus(Integer id, String status);


    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 根据ID查询用户当前角色
     * @param id
     * @return
     */
    public List<Role> findUserRelationRoleById(Integer id);

    /**
     * 用户关联角色
     * @param userVO
     */
    void userContextRole(UserVO userVO);

    /**
     *  获取用户权限
     * @param id
     * @return
     */
    ResponseResult getUserPermissions(Integer id);

}
