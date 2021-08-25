package com.richard.dao;

import com.richard.domain.User;
import com.richard.domain.UserVO;

import java.util.List;

public interface UserMapper {

    /**
     *  查询所有用户
     * @param userVO
     * @return
     */
    public List<User> findAllUserByPage(UserVO userVO);

    /**
     * 修改用户状态
     * @param user
     */
    public void updateUserStatus(User user);

}
