package cn.org.linkage.mapper;

import cn.org.linkage.entity.SysAdmin;
import org.apache.ibatis.annotations.Param;

public interface SysAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAdmin record);

    int insertSelective(SysAdmin record);

    SysAdmin selectByPrimaryKey(Integer id);

    SysAdmin selectByAdmin(@Param("username")String username, @Param("password") String password);

    int updateByPrimaryKeySelective(SysAdmin record);

    int updateByPrimaryKey(SysAdmin record);
}