package SpringBoot_Demo_02.dao;

import SpringBoot_Demo_02.entity.Slide;
import org.apache.ibatis.annotations.*;

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
    Boolean insert(@Param("slide")Slide slide);

    @Delete(value = "delete from slide where id=#{id}")
    Boolean deleteById(@Param("id")String id);


}
