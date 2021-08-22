package com.richard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseVO {

    /**
     * 课程名
     */
    private String courseName;
    /**
     * 状态
     */
    private Integer status;

}
