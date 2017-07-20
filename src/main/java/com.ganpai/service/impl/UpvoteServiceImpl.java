package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.UpvoteDao;
import com.ganpai.dto.UpvoteDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.model.UpvoteDO;
import com.ganpai.service.UpvoteService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpvoteServiceImpl implements UpvoteService {

    final BeanCopier inCopier = BeanCopier.create(UpvoteDTO.class, UpvoteDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( UpvoteDO.class, UpvoteDTO.class,false);


    @Autowired
    public UpvoteDao dao;


    private UpvoteDO convert(UpvoteDTO dto) {
        UpvoteDO result = new UpvoteDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private UpvoteDTO convert(UpvoteDO edo) {
        UpvoteDTO result = new UpvoteDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<UpvoteDTO> convert(List<UpvoteDO> doList) {
        List<UpvoteDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Long create(UpvoteDTO dto) {
        UpvoteDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Long> create(List<UpvoteDTO> dtos) {
        List<Long> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(UpvoteDTO dto:dtos){
                UpvoteDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(UpvoteDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<UpvoteDTO> list(UpvoteDTO dto, int pageIndex, int pageSize) {

        UpvoteDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        List<UpvoteDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<UpvoteDTO> result = new PaginationData(pageIndex, pageSize);
        result.setRows(convert(data));
        result.setTotal(total);

        return result;
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        int result = dao.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public UpvoteDTO queryByPrimaryKey(Long id) {
        return convert(dao.queryByPrimaryKey(id));
    }

    @Override
    public Long count(UpvoteDTO dto) {
        UpvoteDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        long total = dao.count(edo);
        return total;
    }
}
