package cn.org.linkage.service;

import cn.org.linkage.entity.SysAdmin;
import cn.org.linkage.mapper.SysAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    SysAdminMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(SysAdmin record) {
        return 0;
    }

    @Override
    public int insertSelective(SysAdmin record) {
        return 0;
    }

    @Override
    public SysAdmin selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public SysAdmin selectByAdmin(String username, String password) {
        return mapper.selectByAdmin(username,password);
    }

    @Override
    public int updateByPrimaryKeySelective(SysAdmin record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysAdmin record) {
        return 0;
    }
}
