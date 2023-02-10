package SpringBoot_Demo_02.service.impl;

import SpringBoot_Demo_02.dao.SlideMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class SlideServiceImpl {
    private SlideMapper mapper;

    public SlideServiceImpl(){
        InputStream in= null;
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        SlideMapper mapper=session.getMapper(SlideMapper.class);
    }
}
