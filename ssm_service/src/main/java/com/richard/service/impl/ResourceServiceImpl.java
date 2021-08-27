package com.richard.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.richard.dao.ResourceMapper;
import com.richard.domain.Resource;
import com.richard.domain.ResourceVO;
import com.richard.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageInfo<Resource> findAllResource(ResourceVO resourceVO) {

        PageHelper.startPage(resourceVO.getCurrentPage(), resourceVO.getPageSize());
        List<Resource> resourceList = resourceMapper.findAllResourceCategory(resourceVO);
        PageInfo<Resource> pageInfo = new PageInfo<>(resourceList);

        return pageInfo;
    }
}
