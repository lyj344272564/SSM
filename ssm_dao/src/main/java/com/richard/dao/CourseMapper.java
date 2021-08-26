package com.richard.dao;

import com.richard.domain.Course;
import com.richard.domain.CourseVO;
import com.richard.domain.Teacher;


import java.util.List;

public interface CourseMapper {

    /**
     * 多条件查询
     * @param courseVO
     * @return
     */
    public List<Course> findCourseByConditioin(CourseVO courseVO);

    /**
     * 保存课程信息
     * @param course
     * @return
     */
    public void saveCourse(Course course);

    /**
     * 保存讲师信息
     * @param teacher
     */
    public void saveTeacher(Teacher teacher);

    /**
     * 根据id查课程
     * @param id
     * @return
     */
    public CourseVO findCourseById(int id);

    /**
     * 更新课程信息
     * @param course
     */
    public void updateCourse(Course course);

    /**
     * 更新讲师信息
     * @param teacher
     */
    public void updateTeacher(Teacher teacher);

    /**
     * 修改课程状态
     * @param course
     */
    public void updateCourseStatus(Course course);




}
