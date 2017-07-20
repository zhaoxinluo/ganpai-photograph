package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.CommentDetailDao;
import com.ganpai.dto.CommentDetailDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.model.CommentDetailDO;
import com.ganpai.service.CommentDetailService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentDetailServiceImpl implements CommentDetailService {

    final BeanCopier inCopier = BeanCopier.create(CommentDetailDTO.class, CommentDetailDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( CommentDetailDO.class, CommentDetailDTO.class,false);


    @Autowired
    public CommentDetailDao dao;


    private CommentDetailDO convert(CommentDetailDTO dto) {
        CommentDetailDO result = new CommentDetailDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private CommentDetailDTO convert(CommentDetailDO edo) {
        CommentDetailDTO result = new CommentDetailDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<CommentDetailDTO> convert(List<CommentDetailDO> doList) {
        List<CommentDetailDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Long create(CommentDetailDTO dto) {
        CommentDetailDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Long> create(List<CommentDetailDTO> dtos) {
        List<Long> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(CommentDetailDTO dto:dtos){
                CommentDetailDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(CommentDetailDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<CommentDetailDTO> list(CommentDetailDTO dto, int pageIndex, int pageSize) {

        CommentDetailDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        List<CommentDetailDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<CommentDetailDTO> result = new PaginationData(pageIndex, pageSize);
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
    public CommentDetailDTO queryByPrimaryKey(Long id) {
        return convert(dao.queryByPrimaryKey(id));
    }
}
