package SpringBoot_Demo_02.dao;

import SpringBoot_Demo_02.entity.Slide;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

import java.util.List;

/**
* @author bai
* @description 针对表【slide】的数据库操作Mapper
* @createDate 2023-02-09 19:57:58
* @Entity SpringBoot_Demo_02.entity.Slide
*/
@Mapper
public interface SlideMapper {

    /***
     * 查看所有数据
     * @return
     */
    @Select(value = "select * from slide")
    List<Slide> selectAll();

    /***
     * 通过id查找
     * @param id
     * @return
     */
    @Select(value = "select * from slide where id=#{id}")
    Slide selectByPrimaryKey(@Param("id") String id);

    /***
     * 通过名称查找
     * @param name
     * @return
     */
    @Select(value = "SELECT *from slide where name=#{name}")
    Slide selectByName(@Param("name") String name);

    /***
     * 通过节数进行查询
     * @param section
     * @return
     */
    @Select(value = "select * from slide where section like CONCAT('%',#{section},'%')")
    List<Slide> selectBySection(@Param("section")String section);

    /***
     * 通过负载进行查询
     * @param load
     * @return
     */
    @Select(value = "select * from slide where loads like CONCAT('%',#{load},'%')")
    List<Slide> selectByLoad(@Param("load")String load);

    /***
     * 通过规格进行查询
     * @param specifications
     * @return
     */
    @Select(value = "select * from slide where specifications like CONCAT('%',#{specifications},'%')")
    List<Slide> selectBySpecifications(@Param("specifications") String specifications);

    /***
     * 通过材料进行查询
     * @param material
     * @return
     */
    @Select(value = "select * from slide where material like CONCAT('%',#{material},'%')")
    List<Slide> selectByMaterial(@Param("material")String material);

    @Select(value = "select * from slide where characteristic like CONCAT('%',#{characteristic},'%')")
    List<Slide> selectByCharacteristic(@Param("characteristic")String characteristic);

    /***
     * 通过应用进行查询
     * @param application
     * @return
     */
    @Select(value = "select * from slide where application like CONCAT('%',#{application},'%')")
    List<Slide> selectByApplication(@Param("application")String application);

    /***
     * 插入slide数据
     * @param slide
     * @return
     */
    @Insert(value = "insert into slide(id,name,section,loads,specifications,material,characteristic,application,model,life,size,url) " +
            "values(#{slide.id},#{slide.name},#{slide.section},#{slide.loads},#{slide.specifications},#{slide.material}," +
            "#{slide.characteristic},#{slide.application},#{slide.model},#{slide.life},#{slide.size},#{slide.url})")
    boolean insert(@Param("slide")Slide slide);

    @Delete(value = "delete from slide where id=#{id}")
    boolean deleteById(@Param("id")String id);

    @UpdateProvider(type = SlideSqlBuilder.class,method = "buildUpdateUserSql")
    boolean updateSlide(Slide slide);



    public class SlideSqlBuilder{
        public String buildUpdateUserSql(final Slide slide){
            return new SQL(){{
                UPDATE("slide");
                //条件写法. 判断实体对象属性是否为空 如果不为空则修改
                if(slide.getName()!= null){
                    SET("name=#{name}");
                }
                if(slide.getSection()!= null){
                    SET("section=#{section}");
                }
                if(slide.getLoads()!= null){
                    SET("loads=#{loads}");
                }
                if(slide.getSpecifications()!= null){
                    SET("specifications=#{specifications}");
                }
                if(slide.getMaterial()!= null){
                    SET("material=#{material}");
                }
                if(slide.getCharacteristic()!= null){
                    SET("characteristic=#{characteristic}");
                }
                if(slide.getApplication()!= null){
                    SET("application=#{application}");
                }
                if(slide.getModel()!= null){
                    SET("model=#{model}");
                }
                if(slide.getLife()!= null){
                    SET("life=#{life}");
                }
                if(slide.getSize()!= null){
                    SET("size=#{size}");
                }
                if(slide.getUrl()!= null){
                    SET("url=#{url}");
                }
                WHERE("id=#{id}");
            }}.toString();
        }
    }
}
