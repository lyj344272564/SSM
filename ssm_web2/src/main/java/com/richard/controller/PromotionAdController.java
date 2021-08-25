package com.richard.controller;

import com.github.pagehelper.PageInfo;
import com.richard.domain.PromotionAd;
import com.richard.domain.PromotionAdVO;
import com.richard.domain.ResponseResult;
import com.richard.domain.UserVO;
import com.richard.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllAdByPage(PromotionAdVO adVO) {
        try {
            PageInfo pageInfo = promotionAdService.findAllAdByPage(adVO);
            return new ResponseResult(true,200,"分页查询成功",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/PromotionAdUpload")
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

    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd) {
        try {
            if (promotionAd.getId() == null) {
                promotionAdService.savePromotionAd(promotionAd);
                return new ResponseResult(true,200,"添加广告信息成功",null);
            } else {
                promotionAdService.updatePromotionAd(promotionAd);
                return new ResponseResult(true,200,"更新广告信息成功",null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(@RequestParam Integer id) {

        try {

            PromotionAd promotionAd = promotionAdService.findPromotionAdById(id);
            return new ResponseResult(true,200,"查询成功",promotionAd);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(@RequestParam Integer id, @RequestParam Integer status) {

        try {
            if (status == 1) {
                promotionAdService.updatePromotionAdStatus(id,status);
            } else {
                promotionAdService.updatePromotionAdStatus(id,0);
            }
            Map<String,Object> map = new HashMap<>();
            map.put("status",status);
            return new ResponseResult(true,200,"修改状态成功",map);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
