package cn.luischen.dao;

import cn.luischen.model.SearchDomain;

public interface SearchDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SearchDomain record);

    int insertSelective(SearchDomain record);

    SearchDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SearchDomain record);

    int updateByPrimaryKey(SearchDomain record);
}