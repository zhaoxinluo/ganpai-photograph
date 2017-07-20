package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.CategoryDao;
import com.ganpai.dto.CategoryDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.model.CategoryDO;
import com.ganpai.service.CategoryService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    final BeanCopier inCopier = BeanCopier.create(CategoryDTO.class, CategoryDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( CategoryDO.class, CategoryDTO.class,false);


    @Autowired
    public CategoryDao dao;


    private CategoryDO convert(CategoryDTO dto) {
        CategoryDO result = new CategoryDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private CategoryDTO convert(CategoryDO edo) {
        CategoryDTO result = new CategoryDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<CategoryDTO> convert(List<CategoryDO> doList) {
        List<CategoryDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Long create(CategoryDTO dto) {
        CategoryDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Long> create(List<CategoryDTO> dtos) {
        List<Long> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(CategoryDTO dto:dtos){
                CategoryDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(CategoryDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<CategoryDTO> list(CategoryDTO dto, int pageIndex, int pageSize) {

        CategoryDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        List<CategoryDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<CategoryDTO> result = new PaginationData(pageIndex, pageSize);
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
    public CategoryDTO queryByPrimaryKey(Long id) {
        return convert(dao.queryByPrimaryKey(id));
    }
}
