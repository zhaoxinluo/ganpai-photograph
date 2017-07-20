package com.ganpai.controller;

import com.ganpai.VO.OpusVO;
import com.ganpai.VO.UserVO;
import com.ganpai.common.ResponseResult;
import com.ganpai.dto.RecommendDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.service.RecommendService;
import com.ganpai.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 用户推荐
 * Created by Administrator on 2017/7/15 0015.
 */
@RequestMapping("/Recommend")
@ResponseBody
public class RecommendController {
    @Autowired
    private RecommendService RecommendService;

    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult<String> add(UserVO userVO, OpusVO opusVO){
        try{
            RecommendDTO RecommendDTO = new RecommendDTO();
            RecommendDTO.setOpusId(opusVO.getId());
            RecommendDTO.setRecommendUserId(userVO.getId());
            RecommendDTO.setRecommendLoginName(userVO.getLoginName());
            RecommendDTO.setRecommendHeadSculptureAddress(userVO.getHeadSculptureAddress());
            RecommendDTO.setHeadSculptureAddress(opusVO.getHeadSculptureAddress());
            RecommendDTO.setLoginName(opusVO.getLoginName());
            RecommendDTO.setUserId(opusVO.getUserId());
            RecommendDTO.setIsDel(DelEnum.NO_DEL.getCode());
            RecommendDTO.setCreateTime(new Date());

            RecommendService.create(RecommendDTO);

            RecommendDTO requestRecommendDTO = new RecommendDTO();
            requestRecommendDTO.setOpusId(opusVO.getId());
            Long RecommendCount = RecommendService.count(RecommendDTO);

            return ResponseResult.success(RecommendCount);
        }catch (Exception e){
            return ResponseResult.failed("点赞失败");
        }
    }
}
