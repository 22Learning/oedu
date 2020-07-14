package com.oedu.sc.role.dto;

import lombok.Data;

@Data
public class RoleReq {

    /**
     * 枚举类型
     */
    private String codeType="RoleEnum";

    /**
     * 枚举code
     */
    private String codeNo;

    /**
     * 枚举value
     */
    private String codeName;

    /**
     * 主键id
     */
    private Long id;

}
