package SpringBoot_Demo_02.dao;

import SpringBoot_Demo_02.entity.Hinge;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HingeMapper {
    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from HInge where Name like CONCAT('%',#{name},'%')")
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
    List<Hinge> FindHingeByName(String name);

    @Insert("insert into Hinge(Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url) values(#{Id},#{Name},#{Model}," +
            "#{HingeCupInstallation},#{InstallationMaterial},#{InstallationMethod},#{ShutDownSystem},#{DampingSystem}," +
            "#{OpeningAngle},#{LargeAngleHinge},#{DoorPanelAdjustment},#{HingeBase},#{OptionalEquipment},#{Url})")
    Boolean AddHinge(Hinge hinge);

    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from Hinge where Model like CONCAT('%',#{model},'%')")
    List<Hinge> FindHingeByModel(String model);

    @Delete("delete from Hinge where Id=#{id}")
    Boolean DropHinge(String id);

    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from Hinge where HingeCupInstallation " +
            "like CONCAT('%',#{HingeCupInstallation},'%')")
    List<Hinge> FindHingeByHingeCupInstallation(String HingeCupInstallation);

    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from Hinge where InstallationMaterial " +
            "like CONCAT('%',#{InstallationMaterial},'%')")
    List<Hinge> FindHingeByInstallationMaterial(String InstallationMaterial);

    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from Hinge where InstallationMethod " +
            "like CONCAT('%',#{InstallationMethod},'%')")
    List<Hinge> FindHingeByInstallationMethod(String InstallationMethod);

    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from Hinge where ShutDownSystem " +
            "like CONCAT('%',#{ShutDownSystem},'%')")
    List<Hinge> FindHingeByShutDownSystem(String ShutDownSystem);

    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from Hinge where DampingSystem " +
            "like CONCAT('%',#{DampingSystem},'%')")
    List<Hinge> FindHingeBYDampingSystem(String DampingSystem);

    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from Hinge where OpeningAngle " +
            "like CONCAT('%',#{OpeningAngle},'%')")
    List<Hinge> FindHingeBYOpeningAngle(String OpeningAngle);

    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from Hinge where LargeAngleHinge " +
            "like CONCAT('%',#{LargeAngleHinge},'%')")
    List<Hinge> FindHingeBYLargeAngleHinge(String LargeAngleHinge);

    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from Hinge where DoorPanelAdjustment " +
            "like CONCAT('%',#{DoorPanelAdjustment},'%')")
    List<Hinge> FindHingeBYDoorPanelAdjustment(String DoorPanelAdjustment);

    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from Hinge where HingeBase " +
            "like CONCAT('%',#{HingeBase},'%')")
    List<Hinge> FindHingeBYHingeBase(String HingeBase);

    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from Hinge where OptionalEquipment " +
            "like CONCAT('%',#{OptionalEquipment},'%')")
    List<Hinge> FindHingeBYOptionalEquipment(String OptionalEquipment);

    @Select("select Id,Name,Model,HingeCupInstallation,InstallationMaterial,InstallationMethod,ShutDownSystem,DampingSystem," +
            "OpeningAngle,LargeAngleHinge,DoorPanelAdjustment,HingeBase,OptionalEquipment,Url from Hinge where Id " +
            "= #{id}")
    Hinge FindHingeById(String id);
}
