package SpringBoot_Demo_02.service.impl;

import SpringBoot_Demo_02.dao.CorporationMapper;
import SpringBoot_Demo_02.dao.SlideMapper;
import SpringBoot_Demo_02.entity.Corporation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class CorporationServiceImpl {

    @Autowired
    private CorporationMapper mapper;

    public CorporationServiceImpl(){
        InputStream in= null;
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        CorporationMapper mapper=session.getMapper(CorporationMapper.class);
    }

    public Corporation select(){
        return mapper.Select();
    }

    public boolean Delete(String name){
        return mapper.Delete(name);
    }

    public boolean Insert(Corporation corporation){
        System.out.println(corporation.toString());
        return mapper.Insert(corporation);
    }

    public boolean Update(Corporation corporation){
        return mapper.updateCorporation(corporation);
    }
}
