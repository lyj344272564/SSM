package com.richard.service.impl;

import com.alibaba.druid.sql.dialect.oracle.ast.clause.ModelClause;
import com.richard.dao.RoleMapper;
import com.richard.domain.*;
import com.richard.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        Date date = new Date();
        role.setCreatedTime(date);
        role.setUpdatedTime(date);
        return roleMapper.findAllRole(role);
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer roleId) {
        return roleMapper.findMenuByRoleId(roleId);
    }

    @Override
    public void roleContextMenu(RoleMenuVO roleMenuVO) {
        // 1.清空中间表
        roleMapper.deleteRoleContextMenu(roleMenuVO.getRoleId());

        for (Integer mid : roleMenuVO.getMenuIdList()) {
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setRoleId(roleMenuVO.getRoleId());
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setCreatedTime(new Date());
            role_menu_relation.setUpdatedTime(new Date());
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");
            roleMapper.roleContextMenu(role_menu_relation);
        }


    }

    @Override
    public void deleteRole(Integer rid) {
        roleMapper.deleteRoleContextMenu(rid);
        roleMapper.deleteRole(rid);
    }

    @Override
    public void saveRole(Role role) {
        Date date = new Date();

        role.setCreatedTime(date);
        role.setUpdatedTime(date);

        role.setCreatedBy("system");
        role.setUpdatedBy("system");

        roleMapper.saveRole(role);
    }

    @Override
    public void updateRole(Role role) {

        Date date = new Date();

        role.setUpdatedTime(date);

        roleMapper.updateRole(role);
    }

    @Override
    public List<ResourceCategory> findResourceCategoryByRoleId(Integer id) {
        return roleMapper.findResourceCategoryByRoleId(id);
    }

    @Override
    public List<Resource> findResourceByRoleId(Integer id) {
        return roleMapper.findResourceByRoleId(id);
    }

    @Override
    public void roleContextResource(RoleResourceVo roleResourceVo) {
        
        roleMapper.deleteRoleContextResource(roleResourceVo.getRoleId());

        for (Integer resourceId : roleResourceVo.getResourceIdList()) {
            Role_resource_relation role_resource_relation = new Role_resource_relation();
            role_resource_relation.setRoleId(roleResourceVo.getRoleId());
            role_resource_relation.setResourceId(resourceId);
            role_resource_relation.setCreatedTime(new Date());
            role_resource_relation.setUpdatedTime(new Date());
            role_resource_relation.setCreatedBy("system");
            role_resource_relation.setUpdatedBy("system");
            roleMapper.roleContextResource(role_resource_relation);
        }

    }


}
