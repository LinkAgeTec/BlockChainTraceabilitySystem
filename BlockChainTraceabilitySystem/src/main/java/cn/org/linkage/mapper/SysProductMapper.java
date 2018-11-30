package cn.org.linkage.mapper;

import cn.org.linkage.entity.SysProduct;

public interface SysProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysProduct record);

    int insertSelective(SysProduct record);

    SysProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysProduct record);

    int updateByPrimaryKey(SysProduct record);
}