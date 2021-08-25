package com.richard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // 用户id
    private Integer id;
    // 用户昵称
    private String name;
    // 用户头像地址
    private String portrait;
    // 注册手机
    private String phone;
    // 用户密码（可以为空，支持只用验证码注册、登录）
    private String password;
    // 注册ip
    private String reg_ip;
    // 是否有效用户
    private Integer account_non_expired;
    // 账号是否未过期
    private Integer credentials_non_expired;
    // 是否未锁定
    private Integer account_non_locked;
    // 用户状态
    private String status;
    // 是否删除
    private Integer is_del;
    // 创建时间
    private Date create_time;
    // 更新时间
    private Date update_time;

}
