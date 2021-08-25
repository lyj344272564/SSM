package com.richard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionSpace {

    private Integer id;
    private String name;
    private String spaceKey;
    private Date createTime;
    private Date updateTime;
    private Integer isDel;

}
