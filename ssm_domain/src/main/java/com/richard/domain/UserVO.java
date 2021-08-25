package com.richard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private Integer currentPage;
    private Integer pageSize;
    private String username;
    private Date startCreateTime;
    private Date endCreateTime;

}
