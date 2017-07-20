package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.RecommendDao;
import com.ganpai.dto.RecommendDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.model.RecommendDO;
import com.ganpai.service.RecommendService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

    final BeanCopier inCopier = BeanCopier.create(RecommendDTO.class, RecommendDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( RecommendDO.class, RecommendDTO.class,false);


    @Autowired
    public RecommendDao dao;


    private RecommendDO convert(RecommendDTO dto) {
        RecommendDO result = new RecommendDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private RecommendDTO convert(RecommendDO edo) {
        RecommendDTO result = new RecommendDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<RecommendDTO> convert(List<RecommendDO> doList) {
        List<RecommendDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Long create(RecommendDTO dto) {
        RecommendDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Long> create(List<RecommendDTO> dtos) {
        List<Long> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(RecommendDTO dto:dtos){
                RecommendDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(RecommendDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<RecommendDTO> list(RecommendDTO dto, int pageIndex, int pageSize) {

        RecommendDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        List<RecommendDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<RecommendDTO> result = new PaginationData(pageIndex, pageSize);
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
    public RecommendDTO queryByPrimaryKey(Long id) {
        return convert(dao.queryByPrimaryKey(id));
    }

    @Override
    public Long count(RecommendDTO dto) {
        RecommendDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        long total = dao.count(edo);
        return total;
    }
}
