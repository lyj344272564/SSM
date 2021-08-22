package com.richard.controller;

import com.richard.domain.Course;
import com.richard.domain.CourseVO;
import com.richard.domain.ResponseResult;
import com.richard.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findCourseByConditioinn")
    public ResponseResult findCourseByConditioinn(@RequestBody CourseVO courseVO) {

        List<Course> courseList = courseService.findCourseByConditioin(courseVO);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", courseList);

        System.out.println(courseList);

        return responseResult;

    }

}
