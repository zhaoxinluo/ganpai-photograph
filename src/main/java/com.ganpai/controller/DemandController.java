package com.ganpai.controller;

import com.ganpai.VO.DemandVO;
import com.ganpai.VO.UserVO;
import com.ganpai.common.PaginationData;
import com.ganpai.common.ResponseResult;
import com.ganpai.dto.DemandDTO;
import com.ganpai.enmu.AcceptEnum;
import com.ganpai.enmu.DelEnum;
import com.ganpai.service.CollectionService;
import com.ganpai.service.DemandService;
import com.ganpai.service.RecommendService;
import com.ganpai.service.UpvoteService;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
@RequestMapping("/demand")
@Controller
public class DemandController {

    final BeanCopier inCopier = BeanCopier.create(DemandVO.class, DemandDTO.class, false);

    final BeanCopier outCopier = BeanCopier.create(DemandDTO.class, DemandVO.class, false);

    private DemandDTO convert(DemandVO vo) {
        DemandDTO result = new DemandDTO();
        inCopier.copy(vo, result, null);
        return result;
    }

    private DemandVO convert(DemandDTO dto) {
        DemandVO result = new DemandVO();
        outCopier.copy(dto, result, null);
        return result;
    }

    private List<DemandVO> convert(List<DemandDTO> doList) {
        List<DemandVO> result = new ArrayList<>();
        if (doList != null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }

    @Autowired
    private DemandService demandService;




    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult<DemandVO> list(DemandVO DemandVO, @RequestParam(value = "pageIndex") int pageIndex,
                                       @RequestParam(value = "pageSize") int pageSize){
        DemandDTO DemandDTO = convert(DemandVO);
        PaginationData<DemandDTO> paginationData = demandService.list(DemandDTO,pageIndex,pageSize);
        List<DemandDTO> demandDTOList = paginationData.getRows();

        return ResponseResult.success(convert(demandDTOList));

    }

    @RequestMapping("/create")
    @ResponseBody
    public ResponseResult<Long> create(DemandVO DemandVO, UserVO userVO) {

        DemandDTO entity = convert(DemandVO);

        entity.setIsAccept(AcceptEnum.NO_ACCEPT.getCode());
        entity.setUserId(userVO.getId());
        entity.setMobile(userVO.getMobile());
        entity.setIsDel(DelEnum.NO_DEL.getCode());
        entity.setLoginName(userVO.getLoginName());

        try {
            Long response = demandService.create(entity);
            return ResponseResult.success(response);
        } catch (Exception e) {
            return ResponseResult.failed(e.getMessage());
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseResult<Integer> update(DemandVO DemandVO) {


        DemandDTO entity = convert(DemandVO);

        try {
            Integer response = demandService.update(entity);
            return ResponseResult.success(response);
        } catch (Exception e) {
            return ResponseResult.failed(e.getMessage());
        }
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseResult<Integer> del(@RequestParam(value = "id") Long id) {

        try {
            Integer response = demandService.deleteByPrimaryKey(id);
            return ResponseResult.success(response);
        } catch (Exception e) {
            return ResponseResult.failed(e.getMessage());
        }
    }


}
