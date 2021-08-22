package com.richard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 章节类
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSection {

    //id
    private Integer id;

    //课程id
    private int courseId;

    //章节名
    private String sectionName;

    //章节描述
    private String description;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    //是否删除
    private int isDe;

    //排序
    private int orderNum;

    //状态
    private int status;

    //课时集合
    private List<CourseLesson> lessonList;

}
