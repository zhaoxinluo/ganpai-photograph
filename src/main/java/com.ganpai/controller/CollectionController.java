package com.ganpai.controller;

import com.ganpai.VO.OpusVO;
import com.ganpai.VO.UserVO;
import com.ganpai.common.PaginationData;
import com.ganpai.common.ResponseResult;
import com.ganpai.dto.CollectionDTO;
import com.ganpai.dto.OpusDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 用户收藏
 * Created by Administrator on 2017/7/15 0015.
 */
@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult<String> add(UserVO userVO, OpusVO opusVO){
        try{
            CollectionDTO collectionDTO = new CollectionDTO();
            collectionDTO.setOpusId(opusVO.getId());
            collectionDTO.setCollectionUserId(userVO.getId());
            collectionDTO.setCollectionLoginName(userVO.getLoginName());
            collectionDTO.setCollectionHeadSculptureAddress(userVO.getHeadSculptureAddress());
            collectionDTO.setHeadSculptureAddress(opusVO.getHeadSculptureAddress());
            collectionDTO.setLoginName(opusVO.getLoginName());
            collectionDTO.setUserId(opusVO.getUserId());
            collectionDTO.setIsDel(DelEnum.NO_DEL.getCode());
            collectionDTO.setCreateTime(new Date());

            collectionService.create(collectionDTO);

            //返回作品总点赞数
            CollectionDTO requestCollectionDTO = new CollectionDTO();
            requestCollectionDTO.setOpusId(opusVO.getId());

            Long collectionCount = collectionService.count(requestCollectionDTO);

            return ResponseResult.success(collectionCount);
        }catch (Exception e){
            return ResponseResult.failed("收藏失败");
        }
    }

}
