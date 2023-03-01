package SpringBoot_Demo_02.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

/**
 * 
 * @TableName slide
 */
@Data
public class Slide implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    @ApiModelProperty("名字")
    private String name;

    /**
     * 
     */
    @ApiModelProperty("节数")
    private String section;

    /**
     * 
     */
    @ApiModelProperty("负载")
    private String loads;

    /**
     * 
     */
    @ApiModelProperty("规格")
    private String specifications;

    /**
     * 
     */
    @ApiModelProperty("材料")
    private String material;

    /**
     * 
     */
    @ApiModelProperty("特点")
    private String characteristic;

    /**
     * 
     */
    @ApiModelProperty("应用")
    private String application;

    /**
     * 
     */
    @ApiModelProperty("型号")
    private String model;

    /**
     * 
     */
    @ApiModelProperty("寿命")
    private String life;

    /**
     * 
     */
    @ApiModelProperty("厚度")
    private String size;

    /**
     * 
     */
    private String url;


    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Slide other = (Slide) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSection() == null ? other.getSection() == null : this.getSection().equals(other.getSection()))
            && (this.getLoads() == null ? other.getLoads() == null : this.getLoads().equals(other.getLoads()))
            && (this.getSpecifications() == null ? other.getSpecifications() == null : this.getSpecifications().equals(other.getSpecifications()))
            && (this.getMaterial() == null ? other.getMaterial() == null : this.getMaterial().equals(other.getMaterial()))
            && (this.getCharacteristic() == null ? other.getCharacteristic() == null : this.getCharacteristic().equals(other.getCharacteristic()))
            && (this.getApplication() == null ? other.getApplication() == null : this.getApplication().equals(other.getApplication()))
            && (this.getModel() == null ? other.getModel() == null : this.getModel().equals(other.getModel()))
            && (this.getLife() == null ? other.getLife() == null : this.getLife().equals(other.getLife()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSection() == null) ? 0 : getSection().hashCode());
        result = prime * result + ((getLoads() == null) ? 0 : getLoads().hashCode());
        result = prime * result + ((getSpecifications() == null) ? 0 : getSpecifications().hashCode());
        result = prime * result + ((getMaterial() == null) ? 0 : getMaterial().hashCode());
        result = prime * result + ((getCharacteristic() == null) ? 0 : getCharacteristic().hashCode());
        result = prime * result + ((getApplication() == null) ? 0 : getApplication().hashCode());
        result = prime * result + ((getModel() == null) ? 0 : getModel().hashCode());
        result = prime * result + ((getLife() == null) ? 0 : getLife().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", section=").append(section);
        sb.append(", loads=").append(loads);
        sb.append(", specifications=").append(specifications);
        sb.append(", material=").append(material);
        sb.append(", characteristic=").append(characteristic);
        sb.append(", application=").append(application);
        sb.append(", model=").append(model);
        sb.append(", life=").append(life);
        sb.append(", size=").append(size);
        sb.append(", url=").append(url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLoads() {
        return loads;
    }

    public void setLoads(String loads) {
        this.loads = loads;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}