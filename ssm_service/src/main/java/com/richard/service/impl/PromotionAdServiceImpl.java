package com.richard.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.richard.dao.PromotionAdMapper;
import com.richard.domain.PromotionAd;
import com.richard.domain.PromotionAdVO;
import com.richard.service.PromotionAdService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    @Override
    public PageInfo findAllAdByPage(PromotionAdVO adVO) {

        PageHelper.startPage(adVO.getCurrentPage(),adVO.getPageSize());
        List<PromotionAd> promotionAdList = promotionAdMapper.findAllAdByPage();
        PageInfo<PromotionAd> pageInfo = new PageInfo<>(promotionAdList);

        return pageInfo;
    }

    @Override
    public void savePromotionAd(PromotionAd promotionAd) {
        Date date = new Date();
        promotionAd.setCreateTime(date);
        promotionAd.setUpdateTime(date);
        promotionAdMapper.savePromotionAd(promotionAd);
    }

    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {
        Date date = new Date();
        promotionAd.setUpdateTime(date);
        promotionAdMapper.updatePromotionAd(promotionAd);
    }

    @Override
    public PromotionAd findPromotionAdById(Integer id) {
        return promotionAdMapper.findPromotionAdById(id);
    }

    @Override
    public void updatePromotionAdStatus(Integer id, Integer status) {
        PromotionAd promotionAd = new PromotionAd();
        Date date = new Date();

        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(date);

        promotionAdMapper.updatePromotionAdStatus(promotionAd);

    }
}
