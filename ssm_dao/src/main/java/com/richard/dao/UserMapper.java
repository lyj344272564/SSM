package com.richard.dao;

import com.richard.domain.*;

import java.util.List;

public interface UserMapper {

    /**
     *  查询所有用户
     * @param userVO
     * @return
     */
     List<User> findAllUserByPage(UserVO userVO);

    /**
     * 修改用户状态
     * @param user
     */
    void updateUserStatus(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     *根据用户ID清空中间表
     * @param userId
     */
    void deleteUserContextRole(Integer userId);

    /**
     * 分配角色
     * @param user_role_relation
     */
    void userContextRole(User_Role_relation user_role_relation);

    /**
     * 根据ID查询用户当前角色
     * @param id
     * @return
     */
    List<Role> findUserRelationRoleById(Integer id);

    /**
     * 根据角色id,查询角色拥有的顶级菜单信息
     * @param ids
     * @return
     */
    List<Menu> findParentMenuByRoleId(List<Integer> ids);

    /**
     * 根据PID 查询子菜单信息
     * @param pid
     * @return
     */
    List<Menu> findSubMenuByPid(Integer pid);

    /**
     * 获取用户拥有的资源权限信息
     * @param ids
     * @return
     */
    List<Resource> findResourceByRoleId(List<Integer> ids);

}
