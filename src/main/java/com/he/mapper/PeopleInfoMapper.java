package com.he.mapper;

import com.he.entity.PeopleInfo;

public interface PeopleInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PeopleInfo record);

    int insertSelective(PeopleInfo record);

    PeopleInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PeopleInfo record);

    int updateByPrimaryKey(PeopleInfo record);
}