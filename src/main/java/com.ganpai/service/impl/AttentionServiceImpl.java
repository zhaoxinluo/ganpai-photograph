package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.AttentionDao;
import com.ganpai.dto.AttentionDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.model.AttentionDO;
import com.ganpai.service.AttentionService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AttentionServiceImpl implements AttentionService {

    final BeanCopier inCopier = BeanCopier.create(AttentionDTO.class, AttentionDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( AttentionDO.class, AttentionDTO.class,false);


    @Autowired
    public AttentionDao dao;


    private AttentionDO convert(AttentionDTO dto) {
        AttentionDO result = new AttentionDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private AttentionDTO convert(AttentionDO edo) {
        AttentionDTO result = new AttentionDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<AttentionDTO> convert(List<AttentionDO> doList) {
        List<AttentionDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Long create(AttentionDTO dto) {
        AttentionDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Long> create(List<AttentionDTO> dtos) {
        List<Long> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(AttentionDTO dto:dtos){
                AttentionDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(AttentionDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<AttentionDTO> list(AttentionDTO dto, int pageIndex, int pageSize) {

        AttentionDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        List<AttentionDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<AttentionDTO> result = new PaginationData(pageIndex, pageSize);
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
    public AttentionDTO queryByPrimaryKey(Long id) {
        return convert(dao.queryByPrimaryKey(id));
    }
}
