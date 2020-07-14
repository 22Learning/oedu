package com.oedu.sc.role.service;

import com.oedu.sc.map.po.CodeDetail;
import com.oedu.sc.role.dto.RoleReq;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface RoleInterface {

    int addRole(@RequestBody RoleReq req);

    int deleteRole(@RequestBody RoleReq req);

    int updateRole(@RequestBody RoleReq req);

    List<CodeDetail> getList();
}
