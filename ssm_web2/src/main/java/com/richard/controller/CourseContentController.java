package com.richard.controller;

import com.richard.domain.Course;
import com.richard.domain.CourseLesson;
import com.richard.domain.CourseSection;
import com.richard.domain.ResponseResult;
import com.richard.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;


    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(@RequestParam Integer courseId) {

        try {
            List<CourseSection> courseSectionList = courseContentService.findSectionAndLessonByCourseId(courseId);
            ResponseResult result = new ResponseResult(true,200,"响应成功",courseSectionList);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(@RequestParam Integer courseId) {

        try {
            Course course = courseContentService.findCourseByCourseId(courseId);
            ResponseResult result = new ResponseResult(true, 200, "响应成功", course);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection section) {
        try {
            if(section.getId() == null) {
                courseContentService.saveSection(section);
                ResponseResult result = new ResponseResult(true, 200, "新增成功", null);
                return result;
            } else {
                courseContentService.updateSection(section);
                ResponseResult result = new ResponseResult(true, 200, "更新成功", null);
                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 状态，0:隐藏；1：待更新；2：已发布
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(@RequestParam int id,@RequestParam int status) {
        try {
            courseContentService.updateSectionStatus(id,status);
            Map<String,Object> map = new HashMap<>();
            map.put("status",status);
            ResponseResult result = new ResponseResult(true, 200, "修改成功", map);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/saveLesson")
    public ResponseResult saveLesson(@RequestBody CourseLesson lesson) {
        try {
            courseContentService.saveLesson(lesson);
            return new ResponseResult(true,200,"添加成功",null);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
