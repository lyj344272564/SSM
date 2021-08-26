package com.richard.dao;

import com.richard.domain.Menu;

import java.util.List;

public interface MenuMapper {

    /**
     * 查询全部的父子菜单信息
     * @param pid
     * @return
     */
    public List<Menu> findSubMenuListByPid(Integer pid);

    /**
     * 查询菜单列表
     * @return
     */
    List<Menu> findAllMenu();

    /**
     * 根据菜单ID 查询菜单信息
     * @param id
     */
    Menu findMenuById(Integer id);
}
