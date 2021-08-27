package com.richard.dao;

import com.richard.domain.ResourceCategory;

import java.util.List;

public interface ResourceCategoryMapper {

    /**
     * 查询资源分类信息列表
     * @return
     */
    List<ResourceCategory> findAllResourceCategory();

    /**
     * 添加资源分类
     * @param resourceCategory
     */
    void saveResourceCategory(ResourceCategory resourceCategory);

    /**
     * 更新资源分类
     * @param resourceCategory
     */
    void updateResourceCategory(ResourceCategory resourceCategory);

    /**
     * 删除资源分类
     * @param id
     */
    void deleteResourceCategory(Integer id);

}
