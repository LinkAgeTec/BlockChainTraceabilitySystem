package cn.org.linkage.mapper;

import cn.org.linkage.entity.SysBatch;

public interface SysBatchMapper {
    int deleteByPrimaryKey(String batchId);

    int insert(SysBatch record);

    int insertSelective(SysBatch record);

    SysBatch selectByPrimaryKey(String batchId);

    int updateByPrimaryKeySelective(SysBatch record);

    int updateByPrimaryKey(SysBatch record);
}