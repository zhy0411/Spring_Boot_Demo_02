package SpringBoot_Demo_02.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("铰链")
public class Hinge {

    @ApiModelProperty("id用时间戳")
    private String Id;
    @ApiModelProperty("名称")
    private String Name;
    @ApiModelProperty("型号")
    private String Model;
    @ApiModelProperty("铰杯安装")
    private String HingeCupInstallation;
    @ApiModelProperty("门板/门框材质")
    private String InstallationMaterial;
    @ApiModelProperty("安装方式")
    private String InstallationMethod;
    @ApiModelProperty("关闭系统")
    private String ShutDownSystem;
    @ApiModelProperty("阻尼系统")
    private String DampingSystem;
    @ApiModelProperty("开启角度")
    private String OpeningAngle;
    @ApiModelProperty("大角度铰链")
    private String LargeAngleHinge;
    @ApiModelProperty("门板调节")
    private String DoorPanelAdjustment;
    @ApiModelProperty("铰链底座")
    private String HingeBase;
    @ApiModelProperty("可選設備")
    private String OptionalEquipment;
    @ApiModelProperty("url")
    private String url;

}
