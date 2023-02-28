package SpringBoot_Demo_02.service.impl;

import SpringBoot_Demo_02.entity.Admin;
import SpringBoot_Demo_02.dao.AdminMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class AdminServiceImpl {

    @Autowired
    private AdminMapper adminMapper;

    public AdminServiceImpl(){
        InputStream in= null;
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        AdminMapper mapper=session.getMapper(AdminMapper.class);
    }

    public boolean login(String id,String password){
        Admin a=adminMapper.selectByPrimaryKey(id);
        if(a!=null && a.getPassword()==password){
            return true;
        }
        return false;
    }

    public boolean updatePassword(Admin admin){
        return adminMapper.updatePassword(admin);
    }

    public boolean insertAdmin(Admin admin){
        return adminMapper.insert(admin);
    }

}
