package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.CitiesDao;
import com.ganpai.dto.CitiesDTO;
import com.ganpai.model.CitiesDO;
import com.ganpai.service.CitiesService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitiesServiceImpl implements CitiesService {

    final BeanCopier inCopier = BeanCopier.create(CitiesDTO.class, CitiesDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( CitiesDO.class, CitiesDTO.class,false);


    @Autowired
    public CitiesDao dao;


    private CitiesDO convert(CitiesDTO dto) {
        CitiesDO result = new CitiesDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private CitiesDTO convert(CitiesDO edo) {
        CitiesDTO result = new CitiesDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<CitiesDTO> convert(List<CitiesDO> doList) {
        List<CitiesDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Integer create(CitiesDTO dto) {
        CitiesDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Integer> create(List<CitiesDTO> dtos) {
        List<Integer> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(CitiesDTO dto:dtos){
                CitiesDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(CitiesDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<CitiesDTO> list(CitiesDTO dto, int pageIndex, int pageSize) {

        CitiesDO edo = convert(dto);
        List<CitiesDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<CitiesDTO> result = new PaginationData(pageIndex, pageSize);
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
    public CitiesDTO queryByPrimaryKey(Integer id) {
        return convert(dao.queryByPrimaryKey(id));
    }
}
