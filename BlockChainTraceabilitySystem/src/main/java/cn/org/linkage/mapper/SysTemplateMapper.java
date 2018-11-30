package cn.org.linkage.mapper;

import cn.org.linkage.entity.SysTemplate;

public interface SysTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysTemplate record);

    int insertSelective(SysTemplate record);

    SysTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysTemplate record);

    int updateByPrimaryKey(SysTemplate record);
}