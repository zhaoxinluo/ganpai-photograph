package com.ganpai.controller;

import com.ganpai.VO.OpusVO;
import com.ganpai.VO.UserVO;
import com.ganpai.common.ResponseResult;
import com.ganpai.dto.UpvoteDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 用户点赞
 * Created by Administrator on 2017/7/15 0015.
 */
@RequestMapping("/upvote")
@ResponseBody
public class UpvoteController {

    @Autowired
    private UpvoteService upvoteService;

    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult<String> add(UserVO userVO, OpusVO opusVO){
        try{
            UpvoteDTO upvoteDTO = new UpvoteDTO();
            upvoteDTO.setOpusId(opusVO.getId());
            upvoteDTO.setUpvoteUserId(userVO.getId());
            upvoteDTO.setUpvoteLoginName(userVO.getLoginName());
            upvoteDTO.setUpvoteHeadSculptureAddress(userVO.getHeadSculptureAddress());
            upvoteDTO.setHeadSculptureAddress(opusVO.getHeadSculptureAddress());
            upvoteDTO.setLoginName(opusVO.getLoginName());
            upvoteDTO.setUserId(opusVO.getUserId());
            upvoteDTO.setIsDel(DelEnum.NO_DEL.getCode());
            upvoteDTO.setCreateTime(new Date());

            upvoteService.create(upvoteDTO);

            UpvoteDTO requestUpvoteDTO = new UpvoteDTO();
            requestUpvoteDTO.setOpusId(opusVO.getId());
            Long upvoteCount = upvoteService.count(requestUpvoteDTO);

            return ResponseResult.success(upvoteCount);
        }catch (Exception e){
            return ResponseResult.failed("点赞失败");
        }
    }
}
