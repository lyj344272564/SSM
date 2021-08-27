package com.richard.dao;

import com.richard.domain.Resource;
import com.richard.domain.ResourceVO;

import java.util.List;

public interface ResourceMapper {

    /**
     * 分页多条件组合查询
     * @param resourceVO
     * @return
     */
    List<Resource> findAllResourceCategory(ResourceVO resourceVO);

    /**
     * 添加咨询
     * @param resource
     */
    void saveResource(Resource resource);

    /**
     * 更新咨询
     * @param resource
     */
    void updateResource(Resource resource);

    /**
     * 删除资源信息
     * @param id
     */
    void deleteResource(Integer id);

}
