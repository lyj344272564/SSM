package com.richard.controller;

import com.github.pagehelper.PageInfo;
import com.richard.domain.Menu;
import com.richard.domain.MenuVO;
import com.richard.domain.ResponseResult;
import com.richard.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(@RequestBody MenuVO menuVO) {

        try {
            PageInfo pageInfo = menuService.findAllMenu(menuVO);
            return new ResponseResult(true,200,"查询成功",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(@RequestParam Integer id) {

        try {
            //如果是新增菜单,则id值为 -1, 修改菜单 则为当前选择的id值
            if (id == -1) {
                // 添加 不需要回显menu
                List<Menu> menuList = menuService.findSubMenuListByPid(-1);
                HashMap<Object, Object> map = new HashMap<>();
                map.put("menuInfo",null);
                map.put("parentMenuList",menuList);
                return new ResponseResult(true,200,"添加回显成功",map);
            } else {
                Menu menu = menuService.findMenuById(id);
                List<Menu> menuList = menuService.findSubMenuListByPid(-1);
                HashMap<Object, Object> map = new HashMap<>();
                map.put("menuInfo",menu);
                map.put("parentMenuList",menuList);
                return new ResponseResult(true,200,"查询成功",map);
            }


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
