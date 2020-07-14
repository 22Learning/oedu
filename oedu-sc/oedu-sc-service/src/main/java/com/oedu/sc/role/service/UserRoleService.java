package com.oedu.sc.role.service;

import com.oedu.common.entities.LogicException;
import com.oedu.common.tools.StringUtils;
import com.oedu.common.tools.UserUtil;
import com.oedu.sc.feign.service.UserFeignService;
import com.oedu.sc.role.dao.UserRoleMapper;
import com.oedu.sc.role.dto.UserRoleDto;
import com.oedu.sc.role.po.UserRole;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRoleService implements UserRoleInterface {

    @Autowired
    private UserFeignService userFeignService;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public int addUserRole(UserRole req) {
        req.setOeduUserRoleId(null);
        req.setStatus(1);
        req.setCreateTime(new Date());
        req.setCreateUser(UserUtil.getUserId());
        req.setUpdateTime(new Date());
        req.setUpdateUser(UserUtil.getUserId());
        return userRoleMapper.insert(req);
    }

    @Override
    public void deleteUserRole(Long id) {
        if (StringUtils.isEmpty(id)) {
            throw new LogicException("参数缺失，无法删除");
        }
        UserRole req = new UserRole();
        req.setUpdateTime(new Date());
        req.setUpdateUser(UserUtil.getUserId());
        req.setStatus(0);
        req.setOeduUserRoleId(id);
        userRoleMapper.updateByPrimaryKeySelective(req);
    }

    @Override
    public void updateUserRole(UserRole req) {
        deleteUserRole(req.getOeduUserRoleId());
        addUserRole(req);
    }

    @Override
    public List<UserRoleDto> getEffectiveList() {
        List<UserRoleDto> effectiveList = userRoleMapper.getEffectiveList();
        Map<String, String> userMap = userFeignService.getNameByIds(effectiveList.stream().map(UserRoleDto::getUserId).collect(Collectors.toList()));
        effectiveList.stream()
                .filter(user -> {
                    if (userMap.containsKey(user.getUserId())) {
                        user.setUserName(userMap.get(user.getUserId()));
                        return true;
                    } else {
                        return false;
                    }
                }).collect(Collectors.toList());
        return effectiveList;
    }
}
