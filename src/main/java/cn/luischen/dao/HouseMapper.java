package cn.luischen.dao;

import cn.luischen.model.House;

public interface HouseMapper {
    int deleteByPrimaryKey(String uid);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
}