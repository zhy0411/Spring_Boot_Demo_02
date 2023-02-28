package SpringBoot_Demo_02.dao;

import SpringBoot_Demo_02.entity.Admin;
import org.apache.ibatis.annotations.*;

/**
* @author bai
* @description 针对表【Admin】的数据库操作Mapper
* @createDate 2023-02-09 18:52:06
* @Entity SpringBoot_Demo_02.entity.Admin
*/
@Mapper
public interface AdminMapper {

    @Insert(value = "INSERT INTO Admin (id,password) VALUES (#{admin.id},#{admin.password})")
    boolean insert(@Param(value = "admin") Admin admin);

    @Select(value = "select * from Admin where id=#{id}")
    Admin selectByPrimaryKey(@Param("id") String id);

    @Update(value = "UPDATE Admin set password=#{admin.password} where id=#{admin.id}")
    boolean updatePassword(@Param("admin")Admin admin);


}
