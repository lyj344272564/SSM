package com.richard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * 课时类
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseLesson {

    //主键
    private Integer id;

    //课程id
    private int courseId;

    //章节id
    private int sectionId;

    //课时主题
    private String theme;

    //课时时长
    private int duration;

    //是否免费
    private int isFree;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

    //是否删除
    private int isDel;

    //排序
    private int orderNum;

    //状态
    private int status;

}
