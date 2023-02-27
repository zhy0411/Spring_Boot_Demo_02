package SpringBoot_Demo_02.dao;

import SpringBoot_Demo_02.entity.Corporation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* @author bai
* @description 针对表【corporation】的数据库操作Mapper
* @createDate 2023-02-27 12:28:22
* @Entity SpringBoot_Demo_02.entity.Corporation
*/
@Mapper
public interface CorporationMapper {

    @Select(value = "SELECT * from corporation")
    Corporation Select();

    @Insert(value = "INSERT into corporation(name,address,juridical,phone,manage,url) values(#{name},#{address}" +
            ",#{juridical},#{phone},#{manage},#{url}))")
    boolean Insert(@Param("corporation")Corporation corporation);


}
