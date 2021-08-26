package com.richard.controller;

import com.richard.domain.ResourceCategory;
import com.richard.domain.ResponseResult;
import com.richard.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory() {
        try {

            List<ResourceCategory> resourceCategoryList = resourceCategoryService.findAllResourceCategory();
            return new ResponseResult(true,200,"查询成功",resourceCategoryList);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




}
