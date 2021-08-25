package com.richard.controller;

import com.richard.domain.PromotionSpace;
import com.richard.domain.ResponseResult;
import com.richard.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;


    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace() {
        try {

            List<PromotionSpace> spaceList = promotionSpaceService.findAllPromotionSpace();
            return new ResponseResult(true,200,"查询成功",spaceList);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace) {
        try {

            if (promotionSpace.getId() == null) {
                promotionSpaceService.savePromotionSpace(promotionSpace);
                return new ResponseResult(true,200,"添加成功",null);
            } else {
                promotionSpaceService.updatePromotionSpace(promotionSpace);
                return new ResponseResult(true,200,"更新成功",null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(@RequestParam Integer id) {
        try {

            PromotionSpace promotionSpace = promotionSpaceService.findPromotionSpaceById(id);
            return new ResponseResult(true,200,"查询成功",promotionSpace);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
