package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.CommentDao;
import com.ganpai.dto.CommentDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.model.CommentDO;
import com.ganpai.service.CommentService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    final BeanCopier inCopier = BeanCopier.create(CommentDTO.class, CommentDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( CommentDO.class, CommentDTO.class,false);


    @Autowired
    public CommentDao dao;


    private CommentDO convert(CommentDTO dto) {
        CommentDO result = new CommentDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private CommentDTO convert(CommentDO edo) {
        CommentDTO result = new CommentDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<CommentDTO> convert(List<CommentDO> doList) {
        List<CommentDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Long create(CommentDTO dto) {
        CommentDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Long> create(List<CommentDTO> dtos) {
        List<Long> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(CommentDTO dto:dtos){
                CommentDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(CommentDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<CommentDTO> list(CommentDTO dto, int pageIndex, int pageSize) {

        CommentDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        List<CommentDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<CommentDTO> result = new PaginationData(pageIndex, pageSize);
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
    public CommentDTO queryByPrimaryKey(Long id) {
        return convert(dao.queryByPrimaryKey(id));
    }
}
