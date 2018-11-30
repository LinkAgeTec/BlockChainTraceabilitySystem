package cn.org.linkage.mapper;

import cn.org.linkage.entity.SysData;

public interface SysDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysData record);

    int insertSelective(SysData record);

    SysData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysData record);

    int updateByPrimaryKey(SysData record);
}