package cn.org.linkage.mapper;

import cn.org.linkage.entity.SysProductchain;

public interface SysProductchainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysProductchain record);

    int insertSelective(SysProductchain record);

    SysProductchain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysProductchain record);

    int updateByPrimaryKey(SysProductchain record);
}