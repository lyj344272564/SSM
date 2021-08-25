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

    /**
     * 保存课程信息
     * @param courseVO
     */
    public void saveCourseOrTeacher(CourseVO courseVO);

    /**
     * 根据id获取课程信息
     * @param id
     * @return
     */
    public CourseVO findCourseById(int id);

    /**
     * 修改课程信息
     * @param courseVO
     */
    public void updateCourseOrTeacher(CourseVO courseVO);

    /**
     * 修改课程状态
     * @param id
     * @param status
     */
    public void updateCourseStatus(int id,int status);

}
