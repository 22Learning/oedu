package com.oedu.sc.map.po;

import java.io.Serializable;
import java.util.Date;

/**
 * oedu_code_detail
 * @author 
 */
public class CodeDetail implements Serializable {
    private Long oeduCodeDetailId;

    private String codeType;

    private String codeNo;

    private String codeName;

    private Integer status;

    private String remark;

    private Date updateTime;

    private String updateUser;

    private Date createTime;

    private String createUser;

    private static final long serialVersionUID = 1L;

    public Long getOeduCodeDetailId() {
        return oeduCodeDetailId;
    }

    public void setOeduCodeDetailId(Long oeduCodeDetailId) {
        this.oeduCodeDetailId = oeduCodeDetailId;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

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
        CodeDetail other = (CodeDetail) that;
        return (this.getOeduCodeDetailId() == null ? other.getOeduCodeDetailId() == null : this.getOeduCodeDetailId().equals(other.getOeduCodeDetailId()))
            && (this.getCodeType() == null ? other.getCodeType() == null : this.getCodeType().equals(other.getCodeType()))
            && (this.getCodeNo() == null ? other.getCodeNo() == null : this.getCodeNo().equals(other.getCodeNo()))
            && (this.getCodeName() == null ? other.getCodeName() == null : this.getCodeName().equals(other.getCodeName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOeduCodeDetailId() == null) ? 0 : getOeduCodeDetailId().hashCode());
        result = prime * result + ((getCodeType() == null) ? 0 : getCodeType().hashCode());
        result = prime * result + ((getCodeNo() == null) ? 0 : getCodeNo().hashCode());
        result = prime * result + ((getCodeName() == null) ? 0 : getCodeName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oeduCodeDetailId=").append(oeduCodeDetailId);
        sb.append(", codeType=").append(codeType);
        sb.append(", codeNo=").append(codeNo);
        sb.append(", codeName=").append(codeName);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}