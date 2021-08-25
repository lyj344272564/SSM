package com.richard.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.richard.dao.UserMapper;
import com.richard.domain.User;
import com.richard.domain.UserVO;
import com.richard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(UserVO userVO) {
        PageHelper.startPage(userVO.getCurrentPage(),userVO.getPageSize());
        List<User> userList = userMapper.findAllUserByPage(userVO);
        PageInfo<User> userPageInfo = new PageInfo<>(userList);

        System.out.println("总条数："+userPageInfo.getTotal());
        System.out.println("总页数："+userPageInfo.getPages());
        System.out.println("当前页："+userPageInfo.getPageNum());
        System.out.println("每页显示长度："+userPageInfo.getPageSize());
        System.out.println("是否第一页："+userPageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+userPageInfo.isIsLastPage());
        return userPageInfo;
    }

    @Override
    public void updateUserStatus(Integer id, String status) {
        User user = new User();

        Date date = new Date();
        user.setUpdate_time(date);
        user.setStatus(status);
        user.setId(id);

        userMapper.updateUserStatus(user);
    }
}
