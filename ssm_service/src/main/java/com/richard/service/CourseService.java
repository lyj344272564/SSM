package com.richard.service;

import com.richard.domain.Course;
import com.richard.domain.CourseVO;

import java.util.List;

public interface CourseService {

    /**
     * 多条件查询
     * @param courseVO
     * @return
     */
    public List<Course> findCourseByConditioin(CourseVO courseVO);

}
