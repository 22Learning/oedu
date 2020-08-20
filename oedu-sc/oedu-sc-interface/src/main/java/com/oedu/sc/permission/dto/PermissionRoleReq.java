package com.oedu.sc.permission.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PermissionRoleReq {

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 菜单id列表
     */
    private List<String> permissionIdList = new ArrayList<>();

}
