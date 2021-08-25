package com.richard.dao;

import com.richard.domain.Course;
import com.richard.domain.CourseLesson;
import com.richard.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {
    /**
     * 查询课程下的章节与课时信息
     * @param courseId
     * @return
     */
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    /**
     * 根据id查询课程信息
     * @param courseId
     * @return
     */
    public Course findCourseByCourseId(Integer courseId);

    /**
     * 新建章节信息
     * @param section
     */
    public void saveSection(CourseSection section);

    /**
     * 修改章节信息
     * @param section
     */
    public void updateSection(CourseSection section);

    /**
     * 修改章节状态
     * @param section
     */
    public void updateSectionStatus(CourseSection section);

    /**
     * 新建课时信息
     * @param lesson
     */
    public void saveLesson(CourseLesson lesson);
}
