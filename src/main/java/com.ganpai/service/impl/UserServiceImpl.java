package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.UserDao;
import com.ganpai.dto.UserDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.model.UserDO;
import com.ganpai.service.UserService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final BeanCopier inCopier = BeanCopier.create(UserDTO.class, UserDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( UserDO.class, UserDTO.class,false);


    @Autowired
    public UserDao dao;


    private UserDO convert(UserDTO dto) {
        UserDO result = new UserDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private UserDTO convert(UserDO edo) {
        UserDTO result = new UserDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<UserDTO> convert(List<UserDO> doList) {
        List<UserDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Long create(UserDTO dto) {
        UserDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Long> create(List<UserDTO> dtos) {
        List<Long> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(UserDTO dto:dtos){
                UserDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(UserDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<UserDTO> list(UserDTO dto, int pageIndex, int pageSize) {

        UserDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        List<UserDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<UserDTO> result = new PaginationData(pageIndex, pageSize);
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
    public UserDTO queryByPrimaryKey(Long id) {
        return convert(dao.queryByPrimaryKey(id));
    }
}
