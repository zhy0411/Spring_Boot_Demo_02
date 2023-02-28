package SpringBoot_Demo_02.dao;

import SpringBoot_Demo_02.entity.Corporation;
import SpringBoot_Demo_02.entity.Slide;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

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

    @Insert(value = "INSERT into corporation(name,address,juridical,phone,manage,url) values(#{corporation.name},#{corporation.address}" +
            ",#{corporation.juridical},#{corporation.phone},#{corporation.manage},#{corporation.url})")
    boolean Insert(@Param("corporation")Corporation corporation);

    @Delete(value = "DELETE from corporation where name=#{name}")
    boolean Delete(@Param("name")String name);


    @UpdateProvider(type = CorporationMapper.CorporationSqlBuilder.class,method = "buildUpdateUserSql")
    boolean updateCorporation(Corporation corporation);



    public class CorporationSqlBuilder{
        public String buildUpdateUserSql(final Corporation corporation){
            return new SQL(){{
                UPDATE("corporation");
                //条件写法. 判断实体对象属性是否为空 如果不为空则修改
                if(corporation.getAddress()!= null){
                    SET("address=#{address}");
                }
                if(corporation.getJuridical()!= null){
                    SET("juridical=#{juridical}");
                }
                if(corporation.getPhone()!= null){
                    SET("phone=#{phone}");
                }
                if(corporation.getManage()!= null){
                    SET("manage=#{manage}");
                }
                if(corporation.getUrl()!= null){
                    SET("url=#{url}");
                }
                WHERE("name=#{name}");
            }}.toString();
        }
    }

}
