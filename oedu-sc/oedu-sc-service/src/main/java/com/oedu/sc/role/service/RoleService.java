package com.oedu.sc.role.service;

import com.github.pagehelper.PageHelper;
import com.oedu.common.entities.LogicException;
import com.oedu.common.entities.PageParamReq;
import com.oedu.common.entities.PageParamRsp;
import com.oedu.common.tools.StringUtils;
import com.oedu.common.tools.UserUtil;
import com.oedu.sc.map.dao.CodeDetailMapper;
import com.oedu.sc.map.dto.CodeType;
import com.oedu.sc.map.po.CodeDetail;
import com.oedu.sc.role.dto.RoleReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Slf4j
public class RoleService implements RoleInterface {
    @Autowired
    private CodeDetailMapper codeDetailMapper;

    @Override
    public int addRole(RoleReq req) {
        CodeDetail codeDetail = new CodeDetail();
        BeanUtils.copyProperties(req, codeDetail);
        codeDetail.setStatus(1);
        codeDetail.setCreateTime(new Date());
        codeDetail.setCreateUser(UserUtil.getUserId());
        codeDetail.setUpdateTime(new Date());
        codeDetail.setUpdateUser(UserUtil.getUserId());
        return codeDetailMapper.insert(codeDetail);
    }
    @Override
    public int deleteRole(RoleReq req) {
        if (StringUtils.isEmpty(req.getId())) {
            throw new LogicException("参数缺失，无法删除");
        }
        return codeDetailMapper.deleteByPrimaryKey(req.getId());
    }

    @Override
    public int updateRole(RoleReq req) {
        if (StringUtils.isEmpty(req.getId())) {
            throw new LogicException("参数缺失，无法更新");
        }
        CodeDetail codeDetail = new CodeDetail();
        BeanUtils.copyProperties(req, codeDetail);
        codeDetail.setOeduCodeDetailId(req.getId());
        codeDetail.setUpdateTime(new Date());
        codeDetail.setUpdateUser(UserUtil.getUserId());
        return codeDetailMapper.updateByPrimaryKeySelective(codeDetail);
    }

    @Override
    public PageParamRsp<CodeDetail> getList(PageParamReq req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        return new PageParamRsp(codeDetailMapper.selectCodeDetailByType(CodeType.ROLE_ENUM));
    }
}
