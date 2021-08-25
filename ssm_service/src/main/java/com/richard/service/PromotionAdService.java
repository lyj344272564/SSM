package com.richard.service;

import com.github.pagehelper.PageInfo;
import com.richard.domain.PromotionAd;
import com.richard.domain.PromotionAdVO;



public interface PromotionAdService {

    /**
     * 分页获取所有的广告列表
     * @param adVO
     * @return
     */
    public PageInfo findAllAdByPage(PromotionAdVO adVO);

    /**
     * 新建广告
     * @param promotionAd
     */
    public void savePromotionAd(PromotionAd promotionAd);

    /**
     * 更新广告
     * @param promotionAd
     */
    public void updatePromotionAd(PromotionAd promotionAd);

    /**
     * 接收广告ID,返回广告详细信息
     * @param id
     */
    public PromotionAd findPromotionAdById(Integer id);

    /**
     * 修改广告状态
     * @param promotionAd
     */
    public void updatePromotionAdStatus(Integer id, Integer status);
}
