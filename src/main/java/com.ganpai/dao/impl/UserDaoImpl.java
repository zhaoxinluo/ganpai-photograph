package com.ganpai.dao.impl;

import com.ganpai.dao.UserDao;
import com.ganpai.mapper.UserDOMapper;
import com.ganpai.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:28
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserDOMapper mapper;

    @Override
    public long create(UserDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(UserDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<UserDO> list(UserDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(UserDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public UserDO queryByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

}
