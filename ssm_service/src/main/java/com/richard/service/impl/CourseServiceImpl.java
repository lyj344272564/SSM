package com.richard.service.impl;

import com.richard.dao.CourseMapper;
import com.richard.domain.Course;
import com.richard.domain.CourseVO;
import com.richard.domain.Teacher;
import com.richard.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourseByConditioin(CourseVO courseVO) {
        return courseMapper.findCourseByConditioin(courseVO);
    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) {


        try {
            // 封装课程信息
            Course course = new Course();

            BeanUtils.copyProperties(course,courseVO);

            // 补全信息
            Date date = new Date();
            course.setCreateTime(date);
            course.setUpdateTime(date);

            // 保存信息
            courseMapper.saveCourse(course);

            // 获取新插入数据的id
            int id = course.getId();

            //封装讲师信息
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacher,courseVO);

            // 补全讲师信息
            teacher.setCreateTime(date);
            teacher.setUpdateTime(date);
            teacher.setIsDel(0);
            teacher.setCourseId(id);

            courseMapper.saveTeacher(teacher);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public CourseVO findCourseById(int id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) {

        try {
            Course course = new Course();
            BeanUtils.copyProperties(course,courseVO);

            Date date = new Date();
            course.setUpdateTime(date);
            courseMapper.updateCourse(course);

            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacher,courseVO);

            teacher.setCourseId(course.getId());
            teacher.setUpdateTime(date);

            courseMapper.updateTeacher(teacher);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateCourseStatus(int id, int status) {
        try {

            Course course = new Course();
            course.setId(id);
            course.setUpdateTime(new Date());
            course.setStatus(status);

            courseMapper.updateCourseStatus(course);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
