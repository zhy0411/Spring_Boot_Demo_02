package SpringBoot_Demo_02.dao;

import SpringBoot_Demo_02.entity.Hinge;
import org.apache.ibatis.annotations.*;

@Mapper
public interface HingeMapper {
    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from HInge where Name=#{name}")
    @Results({
            @Result(property = "Id",column = "Id"),
            @Result(property = "Name",column = "Name"),
            @Result(property = "Model",column = "Model"),
            @Result(property = "HingeCupInstallation",column = "HingeCupInstallation"),
            @Result(property = "InstallationMaterial",column = "InstallationMaterial"),
            @Result(property = "InstallationMethod",column = "InstallationMethod"),
            @Result(property = "ShutDownSystem",column = "ShutDownSystem"),
            @Result(property = "DampingSystem",column = "DampingSystem"),
            @Result(property = "OpeningAngle",column = "OpeningAngle"),
            @Result(property = "LargeAngleHinge",column = "LargeAngleHinge"),
            @Result(property = "DoorPanelAdjustment",column = "DoorPanelAdjustment"),
            @Result(property = "HingeBase",column = "HingeBase"),
            @Result(property = "OptionalEquipment",column = "OptionalEquipment"),
            @Result(property = "Url",column = "Url")
    })
    Hinge FindHingeByName(String name);

    @Insert("insert into Hinge(Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url) values(#{Id},#{Name},#{Model}," +
            "#{HingeCupInstallation},#{InstallationMaterial},#{InstallationMethod},#{ShutDownSystem},#{DampingSystem}," +
            "#{OpeningAngle},#{LargeAngleHinge},#{DoorPanelAdjustment},#{HingeBase},#{OptionalEquipment},#{Url})")
    Boolean AddHinge(Hinge hinge);


}
