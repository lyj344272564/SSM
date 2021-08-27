package com.richard.service;

import com.github.pagehelper.PageInfo;
import com.richard.domain.Menu;
import com.richard.domain.MenuVO;

import java.util.List;

public interface MenuService {

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
    PageInfo findAllMenu(MenuVO menuVO);

    /**
     * 根据菜单ID 查询菜单信息
     * @param id
     */
    Menu findMenuById(Integer id);

    /**
     *  添加菜单
     * @param menu
     */
    void saveMenu(Menu menu);

    /**
     * 更新菜单
     * @param menu
     */
    void updateMenu(Menu menu);
}
