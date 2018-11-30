package cn.org.linkage.service;


import cn.org.linkage.entity.SysAdmin;

public interface AdminService {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAdmin record);

    int insertSelective(SysAdmin record);

    SysAdmin selectByPrimaryKey(Integer id);

    SysAdmin selectByAdmin(String username,String password);

    int updateByPrimaryKeySelective(SysAdmin record);

    int updateByPrimaryKey(SysAdmin record);
}
