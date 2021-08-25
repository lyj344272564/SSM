package com.richard.service.impl;

import com.richard.dao.PromotionSpaceMapper;
import com.richard.domain.PromotionSpace;
import com.richard.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;

    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        return promotionSpaceMapper.findAllPromotionSpace();
    }

    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        Date date = new Date();
        UUID uuid = UUID.randomUUID();
        promotionSpace.setSpaceKey(uuid.toString());
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);
        promotionSpaceMapper.savePromotionSpace(promotionSpace);
    }

    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        Date date = new Date();
        promotionSpace.setUpdateTime(date);
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }

    @Override
    public PromotionSpace findPromotionSpaceById(Integer id) {
        return promotionSpaceMapper.findPromotionSpaceById(id);
    }
}
