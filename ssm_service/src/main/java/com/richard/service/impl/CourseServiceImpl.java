package com.richard.service.impl;

import com.richard.dao.CourseMapper;
import com.richard.domain.Course;
import com.richard.domain.CourseVO;
import com.richard.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourseByConditioin(CourseVO courseVO) {
        return courseMapper.findCourseByConditioin(courseVO);
    }

}
