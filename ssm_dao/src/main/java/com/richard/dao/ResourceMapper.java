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

}
