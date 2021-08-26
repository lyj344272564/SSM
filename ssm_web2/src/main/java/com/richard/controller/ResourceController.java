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


}
