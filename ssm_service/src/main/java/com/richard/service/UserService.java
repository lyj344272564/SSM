package com.richard.service;

import com.github.pagehelper.PageInfo;
import com.richard.domain.UserVO;

public interface UserService {

    /**
     *  查询所有用户
     * @param userVO
     * @return
     */
    public PageInfo findAllUserByPage(UserVO userVO);


    /**
     * 修改用户状态
     * @param id
     * @param status
     */
    public void updateUserStatus(Integer id, String status);
}
