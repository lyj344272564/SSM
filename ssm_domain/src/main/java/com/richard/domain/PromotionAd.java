package com.richard.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionAd {

    // 标识
    private Integer id;
    // 广告名
    private String name;
    // 广告位id
    private Integer spaceId;
    // 精确搜索关键词
    private String keyword;
    // 静态广告的内容
    private String htmlContent;
    // 文字一
    private String text;
    // 链接一
    private String link;
    // 开始时间

    private Date startTime;
    // 结束时间
    private Date endTime;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    // 优先级
    private Integer priority;
    private String img;



    // 声明一方关系
    private PromotionSpace promotionSpace;


}
