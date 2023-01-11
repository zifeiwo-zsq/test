package service.impl;

import entity.Admin;
import entity.AdminExample;
import mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin findUserByEmail(String email) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminEmailEqualTo(email);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins==null||admins.size()<1){
            return null;
        }
        return admins.get(0);
    }

    @Override
    public Admin findUserById(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer activeEmail(Admin admin){
        admin.setActive(true);
        return adminMapper.updateByPrimaryKey(admin);
    }
}
