package com.richard.service;

import com.richard.domain.Role;
import com.richard.domain.RoleMenuVO;

import java.util.List;

public interface RoleService {


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
     *  为角色分配菜单
     * @param roleMenuVO
     */
    void roleContextMenu(RoleMenuVO roleMenuVO);

    /**
     * 删除角色
     * @param rid
     */
    void deleteRole(Integer rid);
}
