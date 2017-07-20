package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.DemandDao;
import com.ganpai.dto.DemandDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.model.DemandDO;
import com.ganpai.service.DemandService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemandServiceImpl implements DemandService {

    final BeanCopier inCopier = BeanCopier.create(DemandDTO.class, DemandDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( DemandDO.class, DemandDTO.class,false);


    @Autowired
    public DemandDao dao;


    private DemandDO convert(DemandDTO dto) {
        DemandDO result = new DemandDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private DemandDTO convert(DemandDO edo) {
        DemandDTO result = new DemandDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<DemandDTO> convert(List<DemandDO> doList) {
        List<DemandDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Long create(DemandDTO dto) {
        DemandDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Long> create(List<DemandDTO> dtos) {
        List<Long> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(DemandDTO dto:dtos){
                DemandDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(DemandDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<DemandDTO> list(DemandDTO dto, int pageIndex, int pageSize) {

        DemandDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        List<DemandDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<DemandDTO> result = new PaginationData(pageIndex, pageSize);
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
    public DemandDTO queryByPrimaryKey(Long id) {
        return convert(dao.queryByPrimaryKey(id));
    }
}
