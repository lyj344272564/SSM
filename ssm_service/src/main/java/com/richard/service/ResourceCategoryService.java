package com.richard.service;

import com.richard.domain.ResourceCategory;

import java.util.List;

public interface ResourceCategoryService {

    /**
     * 查询资源分类信息列表
     * @return
     */
    List<ResourceCategory> findAllResourceCategory();
}
