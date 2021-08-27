package com.richard.dao;

import com.richard.domain.Role;
import com.richard.domain.Role_menu_relation;

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


}
