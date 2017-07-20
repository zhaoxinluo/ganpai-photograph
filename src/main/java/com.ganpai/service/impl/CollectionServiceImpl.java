package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.CollectionDao;
import com.ganpai.dto.CollectionDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.model.CollectionDO;
import com.ganpai.service.CollectionService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    final BeanCopier inCopier = BeanCopier.create(CollectionDTO.class, CollectionDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( CollectionDO.class, CollectionDTO.class,false);


    @Autowired
    public CollectionDao dao;


    private CollectionDO convert(CollectionDTO dto) {
        CollectionDO result = new CollectionDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private CollectionDTO convert(CollectionDO edo) {
        CollectionDTO result = new CollectionDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<CollectionDTO> convert(List<CollectionDO> doList) {
        List<CollectionDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Long create(CollectionDTO dto) {
        CollectionDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Long> create(List<CollectionDTO> dtos) {
        List<Long> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(CollectionDTO dto:dtos){
                CollectionDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(CollectionDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<CollectionDTO> list(CollectionDTO dto, int pageIndex, int pageSize) {

        CollectionDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        List<CollectionDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<CollectionDTO> result = new PaginationData(pageIndex, pageSize);
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
    public CollectionDTO queryByPrimaryKey(Long id) {
        return convert(dao.queryByPrimaryKey(id));
    }

    @Override
    public Long count(CollectionDTO dto) {
        CollectionDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        long total = dao.count(edo);
        return total;
    }
}
