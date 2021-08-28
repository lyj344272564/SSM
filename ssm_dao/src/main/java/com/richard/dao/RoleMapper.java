package com.richard.dao;

import com.richard.domain.*;

import java.util.List;

public interface RoleMapper {

    /**
     * 查询所有角色&条件查询
     */
    public List<Role> findAllRole(Role role);

    /**
     * 根据角色ID查询菜单信息
     * @param roleId
     * @return
     */
    List<Integer> findMenuByRoleId(Integer roleId);

    /**
     *角色菜单关联
     * @param role_menu_relation
     */
    void roleContextMenu(Role_menu_relation role_menu_relation);

    /**
     * 根据roleid清空中间表的关联关系
     * @param rid
     */
    void deleteRoleContextMenu(Integer rid);

    /**
     * 删除角色
     * @param rid
     */
    void deleteRole(Integer rid);

    /**
     *  添加角色
     * @param role
     */
    void saveRole(Role role);

    /**
     * 修改角色
     * @param role
     */
    void updateRole(Role role);

    /**
     * 查询当前角色拥有的资源分类信息
     * @param id
     * @return
     */
    List<ResourceCategory> findResourceCategoryByRoleId(Integer id);

    /**
     * 查询当前角色拥有的资源信息
     * @param id
     * @return
     */
    List<Resource> findResourceByRoleId(Integer id);

    /**
     * 根据rolesid清空中间表
     * @param id
     */
    void deleteRoleContextResource(Integer id);

    /**
     * 为角色分配资源
     * @param role_resource_relation
     */
    void roleContextResource(Role_resource_relation role_resource_relation);

}
