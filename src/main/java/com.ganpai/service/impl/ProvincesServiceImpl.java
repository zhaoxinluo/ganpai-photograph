package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.ProvincesDao;
import com.ganpai.dto.ProvincesDTO;
import com.ganpai.model.ProvincesDO;
import com.ganpai.service.ProvincesService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvincesServiceImpl implements ProvincesService {

    final BeanCopier inCopier = BeanCopier.create(ProvincesDTO.class, ProvincesDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( ProvincesDO.class, ProvincesDTO.class,false);


    @Autowired
    public ProvincesDao dao;


    private ProvincesDO convert(ProvincesDTO dto) {
        ProvincesDO result = new ProvincesDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private ProvincesDTO convert(ProvincesDO edo) {
        ProvincesDTO result = new ProvincesDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<ProvincesDTO> convert(List<ProvincesDO> doList) {
        List<ProvincesDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Integer create(ProvincesDTO dto) {
        ProvincesDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Integer> create(List<ProvincesDTO> dtos) {
        List<Integer> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(ProvincesDTO dto:dtos){
                ProvincesDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(ProvincesDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<ProvincesDTO> list(ProvincesDTO dto, int pageIndex, int pageSize) {

        ProvincesDO edo = convert(dto);
        List<ProvincesDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<ProvincesDTO> result = new PaginationData(pageIndex, pageSize);
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
    public ProvincesDTO queryByPrimaryKey(Integer id) {
        return convert(dao.queryByPrimaryKey(id));
    }
}
