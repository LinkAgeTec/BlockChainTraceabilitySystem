package cn.org.linkage.mapper;

import cn.org.linkage.entity.SysFactory;

public interface SysFactoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysFactory record);

    int insertSelective(SysFactory record);

    SysFactory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysFactory record);

    int updateByPrimaryKey(SysFactory record);
}