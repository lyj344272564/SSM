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
}
