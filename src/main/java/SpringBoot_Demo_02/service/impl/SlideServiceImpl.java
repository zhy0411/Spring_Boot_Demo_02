package SpringBoot_Demo_02.service.impl;

import SpringBoot_Demo_02.dao.SlideMapper;
import SpringBoot_Demo_02.entity.Slide;
import SpringBoot_Demo_02.dao.SlideMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SlideServiceImpl {

    @Autowired
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

    public List<Slide> SelectAll(){
        return mapper.selectAll();
    }

    public Slide SelectById(String id){
        return mapper.selectByPrimaryKey(id);
    }

    public Slide SelectByName(String name){
        return mapper.selectByName(name);
    }

    public List<Slide> SelectBySection(String section){
        return mapper.selectBySection(section);
    }

    public List<Slide> SelectByLoads(String loads){
        return mapper.selectBySection(loads);
    }

    public List<Slide> SelectBySpecifications(String specifications){
        return mapper.selectBySection(specifications);
    }

    public List<Slide> SelectByMaterial(String material){
        return mapper.selectBySection(material);
    }

    public List<Slide> SelectByCharacteristic(String characteristic){
        return mapper.selectBySection(characteristic);
    }

    public List<Slide> SelectByApplication(String application){
        return mapper.selectBySection(application);
    }

    public boolean InsertSlide(Slide slide){
        if(mapper.insert(slide)){
            return true;
        }else {
            return false;
        }
    }

    public boolean DeleteById(String id){
        if (mapper.deleteById(id)){
            return true;
        }else {
            return false;
        }
    }

}
