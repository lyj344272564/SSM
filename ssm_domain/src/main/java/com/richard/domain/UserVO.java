package com.richard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private Integer currentPage;
    private Integer pageSize;
    private String username;
    private Date startCreateTime;
    private Date endCreateTime;

    private Integer userId;
    private List<Integer> roleIdList;

}
