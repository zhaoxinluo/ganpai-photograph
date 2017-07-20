package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.AreasDao;
import com.ganpai.dto.AreasDTO;
import com.ganpai.model.AreasDO;
import com.ganpai.service.AreasService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreasServiceImpl implements AreasService {

    final BeanCopier inCopier = BeanCopier.create(AreasDTO.class, AreasDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( AreasDO.class, AreasDTO.class,false);


    @Autowired
    public AreasDao dao;


    private AreasDO convert(AreasDTO dto) {
        AreasDO result = new AreasDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private AreasDTO convert(AreasDO edo) {
        AreasDTO result = new AreasDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<AreasDTO> convert(List<AreasDO> doList) {
        List<AreasDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Integer create(AreasDTO dto) {
        AreasDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Integer> create(List<AreasDTO> dtos) {
        List<Integer> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(AreasDTO dto:dtos){
                AreasDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(AreasDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<AreasDTO> list(AreasDTO dto, int pageIndex, int pageSize) {

        AreasDO edo = convert(dto);
        List<AreasDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<AreasDTO> result = new PaginationData(pageIndex, pageSize);
        result.setRows(convert(data));
        result.setTotal(total);

        return result;
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        int result = dao.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public AreasDTO queryByPrimaryKey(Integer id) {
        return convert(dao.queryByPrimaryKey(id));
    }
}
