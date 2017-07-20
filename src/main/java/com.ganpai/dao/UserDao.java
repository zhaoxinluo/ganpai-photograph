package com.ganpai.dao;

import com.ganpai.model.UserDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface UserDao {

    long create(UserDO edo);

    int update(UserDO edo);

    List<UserDO> list(UserDO edo, long pageIndex, int pageSize);

    long count(UserDO edo);

    int deleteByPrimaryKey(Long id);

    UserDO queryByPrimaryKey(Long id);
}
