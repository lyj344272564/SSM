package com.richard.dao;

import com.richard.domain.ResourceCategory;

import java.util.List;

public interface ResourceCategoryMapper {

    /**
     * 查询资源分类信息列表
     * @return
     */
    List<ResourceCategory> findAllResourceCategory();

}
