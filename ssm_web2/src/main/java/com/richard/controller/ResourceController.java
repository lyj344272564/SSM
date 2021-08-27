package com.richard.controller;

import com.github.pagehelper.PageInfo;
import com.richard.domain.Resource;
import com.richard.domain.ResourceVO;
import com.richard.domain.ResponseResult;
import com.richard.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVO resourceVO) {

        try {

            PageInfo<Resource> pageInfo = resourceService.findAllResource(resourceVO);
            return new ResponseResult(true,200,"查询成功",pageInfo);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/saveOrUpdateResource")
    public ResponseResult saveOrUpdateResource(@RequestBody Resource resource) {
        try {

            if (resource.getId() == null) {

                resourceService.saveResource(resource);
                return new ResponseResult(true,200,"添加成功",null);

            } else {

                resourceService.updateResource(resource);
                return new ResponseResult(true,200,"更新成功",null);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/deleteResource")
    public ResponseResult deleteResource(Integer id) {
        try {

            resourceService.deleteResource(id);
            return new ResponseResult(true,200,"删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
