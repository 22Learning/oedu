package com.oedu.sc.role.po;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * oedu_user_role
 * @author 
 */
public class UserRole implements Serializable {
    private Long oeduUserRoleId;

    /**
     * 用户账号
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 1：有效，0：失效
     */
    private int status;

    private Date updateTime;

    private String updateUser;

    private Date createTime;

    private String createUser;

    private static final long serialVersionUID = 1L;

    public Long getOeduUserRoleId() {
        return oeduUserRoleId;
    }

    public void setOeduUserRoleId(Long oeduUserRoleId) {
        this.oeduUserRoleId = oeduUserRoleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

        UserRole userRole = (UserRole) o;

        return new EqualsBuilder()
                .append(status, userRole.status)
                .append(oeduUserRoleId, userRole.oeduUserRoleId)
                .append(userId, userRole.userId)
                .append(roleId, userRole.roleId)
                .append(roleName, userRole.roleName)
                .append(updateTime, userRole.updateTime)
                .append(updateUser, userRole.updateUser)
                .append(createTime, userRole.createTime)
                .append(createUser, userRole.createUser)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(oeduUserRoleId)
                .append(userId)
                .append(roleId)
                .append(roleName)
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
        sb.append(", oeduUserRoleId=").append(oeduUserRoleId);
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
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