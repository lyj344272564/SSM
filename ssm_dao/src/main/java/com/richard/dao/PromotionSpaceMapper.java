package com.richard.dao;

import com.richard.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceMapper {

    /**
     * 查询all广告位
     * @return
     */
    public List<PromotionSpace> findAllPromotionSpace();

    /**
     * 添加广告位
     * @param promotionSpace
     */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 修改广告位
     * @param promotionSpace
     */
    public void updatePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 通过id查询广告位信息
     * @param id
     * @return
     */
    public PromotionSpace findPromotionSpaceById(Integer id);


}
