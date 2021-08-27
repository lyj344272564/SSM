package com.richard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_Role_relation {

    private Integer id;
    private Integer userId;
    private Integer roleId;
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedby;

}
