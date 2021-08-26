package com.richard.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.richard.dao.MenuMapper;
import com.richard.domain.Menu;
import com.richard.domain.MenuVO;
import com.richard.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findSubMenuListByPid(Integer pid) {
        return menuMapper.findSubMenuListByPid(pid);
    }

    @Override
    public PageInfo findAllMenu(MenuVO menuVO) {
        PageHelper.startPage(menuVO.getCurrentPage(),menuVO.getPageSize());
        List<Menu> menuList = menuMapper.findAllMenu();
        PageInfo<Menu> pageInfo = new PageInfo<>(menuList);
        return pageInfo;
    }

    @Override
    public Menu findMenuById(Integer id) {
       return menuMapper.findMenuById(id);
    }
}
