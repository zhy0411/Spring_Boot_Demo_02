package SpringBoot_Demo_02;


import SpringBoot_Demo_02.entity.Slide;
import SpringBoot_Demo_02.dao.SlideMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import SpringBoot_Demo_02.config.DataConfig;
import SpringBoot_Demo_02.config.JdbcInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataConfig.class, JdbcInfo.class})

public class test {

//    @Autowired
//    private AdminServiceImpl adminMapper;

    @Test
    public void x() throws IOException {
//        Admin admin=new Admin();
//        admin.setPassword("444");
//        admin.setId("44");
//        adminMapper.adminMapper.insert(admin);
        InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
//        AdminMapper mapper=session.getMapper(AdminMapper.class);
//        System.out.println(mapper.insert(admin));
        SlideMapper mapper=session.getMapper(SlideMapper.class);
//        System.out.println(mapper.selectByPrimaryKey("11").getId()+"===========");


        List<Slide> list = mapper.selectBySection("三节");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId()+list.get(i).getName()+list.get(i).getSection());
        }


//        Admin a= mapper.selectByPrimaryKey("11");
//        System.out.println(a.getId()+a.getPassword());
//        session.commit();

//        for (int i = 0; i < 10000; i++) {
//            System.out.print(1);
//        }
    }
}
