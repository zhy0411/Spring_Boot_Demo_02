package SpringBoot_Demo_02.dao;

import SpringBoot_Demo_02.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* @author bai
* @description 针对表【Admin】的数据库操作Mapper
* @createDate 2023-02-09 18:52:06
* @Entity SpringBoot_Demo_02.entity.Admin
*/
public interface AdminMapper {

    @Insert(value = "INSERT INTO Admin (id,password) VALUES (#{admin.id},#{admin.password})")
    int insert(@Param(value = "admin") Admin admin);

    @Select(value = "select * from Admin where id=#{id}")
    Admin selectByPrimaryKey(@Param("id") String id);



}
