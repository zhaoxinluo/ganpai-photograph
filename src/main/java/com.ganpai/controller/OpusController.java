package com.ganpai.controller;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.ganpai.VO.OpusVO;
import com.ganpai.VO.UserVO;
import com.ganpai.common.PaginationData;
import com.ganpai.common.ResponseResult;
import com.ganpai.dto.*;
import com.ganpai.dto.OpusDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.service.CollectionService;
import com.ganpai.service.UpvoteService;
import com.ganpai.service.OpusService;
import com.ganpai.service.RecommendService;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@RequestMapping("/opus")
@Controller
public class OpusController {

    final BeanCopier inCopier = BeanCopier.create(OpusVO.class, OpusDTO.class, false);

    final BeanCopier outCopier = BeanCopier.create(OpusDTO.class, OpusVO.class, false);

    private OpusDTO convert(OpusVO vo) {
        OpusDTO result = new OpusDTO();
        inCopier.copy(vo, result, null);
        return result;
    }

    private OpusVO convert(OpusDTO dto) {
        OpusVO result = new OpusVO();
        outCopier.copy(dto, result, null);
        return result;
    }

    private List<OpusVO> convert(List<OpusDTO> doList) {
        List<OpusVO> result = new ArrayList<>();
        if (doList != null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }

    @Autowired
    private OpusService opusService;

    @Autowired
    private UpvoteService likeService;
    @Autowired
    private RecommendService recommendService;
    @Autowired
    private CollectionService collectionService;



    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult<OpusVO> list(OpusVO opusVO,@RequestParam(value = "pageIndex") int pageIndex,
                                       @RequestParam(value = "pageSize") int pageSize){
        OpusDTO opusDTO = convert(opusVO);
        PaginationData<OpusDTO> paginationData = opusService.list(opusDTO,pageIndex,pageSize);
        List<OpusDTO> opusDTOList = paginationData.getRows();

        //return opusVO
        List<OpusVO> opusVOList = new ArrayList<>();
        for (OpusDTO opusDTO1:opusDTOList
             ) {
            OpusVO opusVO1 = convert(opusDTO1);
            setLikeAndRecommendAndCollectionTotalToOpusVO(opusVO1);
            opusVOList.add(opusVO1);
        }

        return ResponseResult.success(opusDTOList);

    }


    @RequestMapping("/{id}/detail")
    @ResponseBody
    public ResponseResult<OpusVO> detail(@PathVariable("id") Long id){
        try{
            OpusDTO opusDTO = new OpusDTO();
            opusDTO.setId(id);
            PaginationData<OpusDTO> paginationData = opusService.list(opusDTO,1,1);
            List<OpusDTO> opusDTOList = paginationData.getRows();
            if(CollectionUtils.isNotEmpty(opusDTOList)){

                OpusVO opusVO = convert(opusDTOList.get(0));

                setLikeAndRecommendAndCollectionTotalToOpusVO(opusVO);
                return ResponseResult.success(opusVO);
            }
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.failed(e.getMessage());
        }
    }

    private void setLikeAndRecommendAndCollectionTotalToOpusVO(OpusVO opusVO) {
        Long id = opusVO.getId();
        //获取商品点赞数,收藏数,推荐数
        UpvoteDTO likeDTO = new UpvoteDTO();
        likeDTO.setOpusId(id);
        PaginationData<UpvoteDTO> likeDTOPaginationData = likeService.list(likeDTO,0,0);
        Long totalLike = likeDTOPaginationData.getTotal();

        //推荐数
        RecommendDTO recommendDTO = new RecommendDTO();
        recommendDTO.setOpusId(id);
        PaginationData<RecommendDTO> recommendDTOPaginationData = recommendService.list(recommendDTO,0,0);
        Long totalRecommend = recommendDTOPaginationData.getTotal();

        //收藏数
        CollectionDTO collectionDTO = new CollectionDTO();
        collectionDTO.setOpusId(id);
        PaginationData<CollectionDTO> collectionDTOPaginationData = collectionService.list(collectionDTO,0,0);
        Long totalCollection = collectionDTOPaginationData.getTotal();

        opusVO.setTotalLike(totalLike);
        opusVO.setTotalCollection(totalCollection);
        opusVO.setTotalRecommend(totalRecommend);
    }



    @RequestMapping("/create")
    @ResponseBody
    public ResponseResult<Long> create(OpusVO opusVO, UserVO userVO) {

        //TODO 上传图片

        OpusDTO entity = convert(opusVO);

        entity.setPublicTime(new Date());
        entity.setUserId(userVO.getId());
        entity.setHeadSculptureAddress(userVO.getHeadSculptureAddress());
        entity.setIsDel(DelEnum.NO_DEL.getCode());
        entity.setLoginName(userVO.getLoginName());
        entity.setUserName(userVO.getUserName());
        try {
            Long response = opusService.create(entity);
            return ResponseResult.success(response);
        } catch (Exception e) {
            return ResponseResult.failed(e.getMessage());
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseResult<Integer> update(OpusVO opusVO) {

        //TODO 上传图片 修改 作品地址

        OpusDTO entity = convert(opusVO);

        try {
            Integer response = opusService.update(entity);
            return ResponseResult.success(response);
        } catch (Exception e) {
            return ResponseResult.failed(e.getMessage());
        }
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseResult<Integer> del(@RequestParam(value = "id") Long id) {

        try {
            Integer response = opusService.deleteByPrimaryKey(id);
            return ResponseResult.success(response);
        } catch (Exception e) {
            return ResponseResult.failed(e.getMessage());
        }
    }
    
    
    @RequestMapping("upload")
    @ResponseBody
    public ResponseResult<String> upload(HttpServletRequest request , OpusVO opusVO,@RequestParam("file") MultipartFile []file){
        System.out.print(file.length);
        List<MultipartFile> files =((MultipartHttpServletRequest)request).getFiles("file");
        Iterator<String> names = ((MultipartHttpServletRequest)request).getFileNames();
//        MultipartFile file = null;
//        BufferedOutputStream stream = null;
//        for (int i =0; i< files.size(); ++i) {
//            file = files.get(i);
//            if (!file.isEmpty()) {
//                try {
//                    byte[] bytes = file.getBytes();
//                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
//                    stream.write(bytes);
//                    stream.close();
//                } catch (Exception e) {
//                    stream =  null;
//                    return ResponseResult.failed("You failed to upload " + i + " =>" + e.getMessage());
//                }
//            } else {
//                return ResponseResult.failed("You failed to upload " + i + " becausethe file was empty.");
//            }
//        }
        return ResponseResult.success("upload successful");

    }

}
