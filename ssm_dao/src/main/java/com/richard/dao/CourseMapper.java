package com.richard.dao;

import com.richard.domain.Course;
import com.richard.domain.CourseVO;


import java.util.List;

public interface CourseMapper {

    /**
     * 多条件查询
     * @param courseVO
     * @return
     */
    public List<Course> findCourseByConditioin(CourseVO courseVO);

}
