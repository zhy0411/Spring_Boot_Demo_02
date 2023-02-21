package SpringBoot_Demo_02;


import SpringBoot_Demo_02.entity.Slide;
import SpringBoot_Demo_02.dao.SlideMapper;
import com.google.gson.Gson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;



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

//        File file=new File("img/xx");
//        if(!file.exists()){
//            file.mkdirs();
//        }

        System.out.println(mapper.deleteById("11"));
//        Slide slide= mapper.selectByPrimaryKey("19");
//        if(slide==null){
//            System.out.println("null");
//        }
//        Slide slide=new Slide();
//        slide.setId("2023-02-20T22:03:38.856");
//        slide.setName("2222");
//        slide.setSection("scaxcz");
//        slide.setLoads("dasdawx");
//        slide.setSpecifications("vdvaerx");
//        slide.setMaterial("sdawx");
//        slide.setCharacteristic("shywa");
//        slide.setApplication("k123");
//        slide.setModel("dawasd");
//        slide.setLife("sdhauw");
//        slide.setSize("wsadwdq");
//        slide.setUrl("img/2023-02-20T22:03:38.856");

//        System.out.println(slide.getModel());
//        System.out.println(mapper.insert(slide));

//        List<Slide> list = mapper.selectBySection("5");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
//        }
//        Gson gson=new Gson();
//        System.out.println(gson.toJson(mapper.selectByPrimaryKey("11")));

//        Admin a= mapper.selectByPrimaryKey("11");
//        System.out.println(a.getId()+a.getPassword());
        session.commit();

//        for (int i = 0; i < 10000; i++) {
//            System.out.print(1);
//        }
    }
}
