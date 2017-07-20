package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.OpusDao;
import com.ganpai.dto.OpusDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.model.OpusDO;
import com.ganpai.service.OpusService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpusServiceImpl implements OpusService {

    final BeanCopier inCopier = BeanCopier.create(OpusDTO.class, OpusDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( OpusDO.class, OpusDTO.class,false);


    @Autowired
    public OpusDao dao;


    private OpusDO convert(OpusDTO dto) {
        OpusDO result = new OpusDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private OpusDTO convert(OpusDO edo) {
        OpusDTO result = new OpusDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<OpusDTO> convert(List<OpusDO> doList) {
        List<OpusDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Long create(OpusDTO dto) {
        OpusDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Long> create(List<OpusDTO> dtos) {
        List<Long> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(OpusDTO dto:dtos){
                OpusDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(OpusDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<OpusDTO> list(OpusDTO dto, int pageIndex, int pageSize) {

        OpusDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        List<OpusDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<OpusDTO> result = new PaginationData(pageIndex, pageSize);
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
    public OpusDTO queryByPrimaryKey(Long id) {
        return convert(dao.queryByPrimaryKey(id));
    }
}
