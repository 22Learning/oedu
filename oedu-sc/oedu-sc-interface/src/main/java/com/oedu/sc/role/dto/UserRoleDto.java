package com.oedu.sc.role.dto;

import lombok.Data;


@Data
public class UserRoleDto {

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
     * 用户名
     */
    private String userName;

}
