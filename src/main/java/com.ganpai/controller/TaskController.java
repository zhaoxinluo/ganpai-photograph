package com.ganpai.controller;

import com.ganpai.VO.TaskVO;
import com.ganpai.VO.UserVO;
import com.ganpai.common.PaginationData;
import com.ganpai.common.ResponseResult;
import com.ganpai.dto.DemandDTO;
import com.ganpai.dto.TaskDTO;
import com.ganpai.enmu.AcceptEnum;
import com.ganpai.enmu.DelEnum;
import com.ganpai.service.DemandService;
import com.ganpai.service.TaskService;
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
@RequestMapping("/task")
@Controller
public class TaskController {

    final BeanCopier inCopier = BeanCopier.create(TaskVO.class, TaskDTO.class, false);

    final BeanCopier outCopier = BeanCopier.create(TaskDTO.class, TaskVO.class, false);

    private TaskDTO convert(TaskVO vo) {
        TaskDTO result = new TaskDTO();
        inCopier.copy(vo, result, null);
        return result;
    }

    private TaskVO convert(TaskDTO dto) {
        TaskVO result = new TaskVO();
        outCopier.copy(dto, result, null);
        return result;
    }

    private List<TaskVO> convert(List<TaskDTO> doList) {
        List<TaskVO> result = new ArrayList<>();
        if (doList != null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }

    @Autowired
    private TaskService taskService;
    @Autowired
    private DemandService demandService;




    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult<TaskVO> list(TaskVO TaskVO, @RequestParam(value = "pageIndex") int pageIndex,
                                         @RequestParam(value = "pageSize") int pageSize){
        TaskDTO TaskDTO = convert(TaskVO);
        PaginationData<TaskDTO> paginationData = taskService.list(TaskDTO,pageIndex,pageSize);
        List<TaskDTO> TaskDTOList = paginationData.getRows();

        return ResponseResult.success(convert(TaskDTOList));

    }

    @RequestMapping("/create")
    @ResponseBody
    public ResponseResult<Long> create(@RequestParam(value = "id") Long id, UserVO userVO) {

        TaskDTO entity = new TaskDTO();
        entity.setDemandId(id);
        entity.setCreateTime(new Date());
        entity.setMobile(userVO.getMobile());
        entity.setUserId(userVO.getId());
        entity.setIsDel(DelEnum.NO_DEL.getCode());
        entity.setLoginName(userVO.getLoginName());

        try {
            Long response = taskService.create(entity);

            //修改对应接受的 需求  is_accept =1
            DemandDTO demandDTO = new DemandDTO();
            demandDTO.setId(id);
            demandDTO.setIsAccept(AcceptEnum.ACCEPTED.getCode());
            demandService.update(demandDTO);

            return ResponseResult.success(response);
        } catch (Exception e) {
            return ResponseResult.failed(e.getMessage());
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseResult<Integer> update(TaskVO TaskVO) {

        TaskDTO entity = convert(TaskVO);

        try {
            Integer response = taskService.update(entity);
            return ResponseResult.success(response);
        } catch (Exception e) {
            return ResponseResult.failed(e.getMessage());
        }
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseResult<Integer> del(@RequestParam(value = "id") Long id) {

        try {
            Integer response = taskService.deleteByPrimaryKey(id);
            return ResponseResult.success(response);
        } catch (Exception e) {
            return ResponseResult.failed(e.getMessage());
        }
    }
}
