package com.richard.controller;

import com.richard.domain.Course;
import com.richard.domain.CourseVO;
import com.richard.domain.ResponseResult;
import com.richard.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 多条件查询
     * @param courseVO
     * @return
     */
    @RequestMapping("/findCourseByConditioinn")
    public ResponseResult findCourseByConditioinn(@RequestBody CourseVO courseVO) {

        List<Course> courseList = courseService.findCourseByConditioin(courseVO);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", courseList);

        System.out.println(courseList);

        return responseResult;

    }

    /**
     * 文件上传
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        try {
            //1.判断文件是否为空
            if (file.isEmpty()) {
                throw new RuntimeException();
            }
            // 2.获取项目部署路径
            String realPath = request.getServletContext().getRealPath("/");
            String webappsPath = realPath.substring(0,realPath.indexOf("ssm_web"));
            //3.获取原文件名
            String fileName = file.getOriginalFilename();
            //4.新文件名
            String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
            //5.上传文件
            String uploadPath = webappsPath+"upload\\";
            File filePath = new File(uploadPath,newFileName);
            //如果目录不存在就创建目录
            if(!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录: " + filePath);
            }
            file.transferTo(filePath);
            //6.将文件名和文件路径返回
            Map<String,String> map = new HashMap<>();
            map.put("fileName",newFileName);
            map.put("filePath",webappsPath+"/upload/"+newFileName);
            ResponseResult result = new ResponseResult(true,200,"响应成功",map);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

}
