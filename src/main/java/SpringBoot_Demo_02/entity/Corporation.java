package SpringBoot_Demo_02.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @TableName corporation
 */
@Data
@Getter
@Setter
public class Corporation implements Serializable {
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private String juridical;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String manage;

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
        Corporation other = (Corporation) that;
        return (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getJuridical() == null ? other.getJuridical() == null : this.getJuridical().equals(other.getJuridical()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getManage() == null ? other.getManage() == null : this.getManage().equals(other.getManage()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getJuridical() == null) ? 0 : getJuridical().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getManage() == null) ? 0 : getManage().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", juridical=").append(juridical);
        sb.append(", phone=").append(phone);
        sb.append(", manage=").append(manage);
        sb.append(", url=").append(url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}