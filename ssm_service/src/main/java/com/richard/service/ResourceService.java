package com.richard.service;

import com.github.pagehelper.PageInfo;
import com.richard.domain.Resource;
import com.richard.domain.ResourceVO;

public interface ResourceService {

    /**
     * 分页多条件组合查询
     * @param resourceVO
     * @return
     */
    public PageInfo<Resource> findAllResource(ResourceVO resourceVO);

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
