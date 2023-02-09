package generator.mapper;

import generator.domain.Slide;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author bai
* @description 针对表【slide】的数据库操作Mapper
* @createDate 2023-02-09 19:57:58
* @Entity generator.domain.Slide
*/
public interface SlideMapper {

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
    @Select(value = "select * from slide where section like CONCAT('%',#{load},'%')")
    List<Slide> selectByLoad(@Param("load")String load);





}
