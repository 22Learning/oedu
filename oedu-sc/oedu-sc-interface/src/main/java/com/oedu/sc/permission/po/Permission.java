package com.oedu.sc.permission.po;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * oedu_permission
 * @author 
 */
public class Permission implements Serializable {
    /**
     * 主键
     */
    private Long oeduPermissionId;

    /**
     * 菜单id
     */
    private String permissionId;

    /**
     * 菜单名称
     */
    private String permissionName;

    /**
     * 父菜单id
     */
    private String parentPermissionId;

    /**
     * 状态 1：有效，0：无效
     */
    private int status;

    private Date updateTime;

    private String updateUser;

    private Date createTime;

    private String createUser;

    private static final long serialVersionUID = 1L;

    public Long getOeduPermissionId() {
        return oeduPermissionId;
    }

    public void setOeduPermissionId(Long oeduPermissionId) {
        this.oeduPermissionId = oeduPermissionId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getParentPermissionId() {
        return parentPermissionId;
    }

    public void setParentPermissionId(String parentPermissionId) {
        this.parentPermissionId = parentPermissionId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        return new EqualsBuilder()
                .append(status, that.status)
                .append(oeduPermissionId, that.oeduPermissionId)
                .append(permissionId, that.permissionId)
                .append(permissionName, that.permissionName)
                .append(parentPermissionId, that.parentPermissionId)
                .append(updateTime, that.updateTime)
                .append(updateUser, that.updateUser)
                .append(createTime, that.createTime)
                .append(createUser, that.createUser)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(oeduPermissionId)
                .append(permissionId)
                .append(permissionName)
                .append(parentPermissionId)
                .append(status)
                .append(updateTime)
                .append(updateUser)
                .append(createTime)
                .append(createUser)
                .toHashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oeduPermissionId=").append(oeduPermissionId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", permissionName=").append(permissionName);
        sb.append(", parentPermissionId=").append(parentPermissionId);
        sb.append(", status=").append(status);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}