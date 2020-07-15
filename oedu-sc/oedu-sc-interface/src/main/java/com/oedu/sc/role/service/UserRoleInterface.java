package com.oedu.sc.role.service;

import com.oedu.sc.role.dto.UserRoleDto;
import com.oedu.sc.role.po.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRoleInterface {

    int addUserRole(UserRole req);

    void deleteUserRole(Long id);

    void updateUserRole(UserRole req);

    List<UserRoleDto> getEffectiveList();
}
