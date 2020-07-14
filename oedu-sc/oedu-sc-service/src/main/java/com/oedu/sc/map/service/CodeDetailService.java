package com.oedu.sc.map.service;

import com.oedu.common.entities.LogicException;
import com.oedu.common.tools.ListUtil;
import com.oedu.common.tools.StringUtils;
import com.oedu.common.tools.UserUtil;
import com.oedu.sc.map.dao.CodeDetailMapper;
import com.oedu.sc.map.po.CodeDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class CodeDetailService implements  CodeDetailInterface{

    @Autowired
    private CodeDetailMapper codeDetailMapper;


    @Override
    public int add(CodeDetail codeDetail) {
        codeDetail.setStatus(1);
        codeDetail.setCreateTime(new Date());
        codeDetail.setCreateUser(UserUtil.getUserId());
        codeDetail.setUpdateTime(new Date());
        codeDetail.setUpdateUser(UserUtil.getUserId());
        return codeDetailMapper.insert(codeDetail);
    }

    @Override
    public int delete(Long id) {
        if (StringUtils.isEmpty(id)) {
            throw new LogicException("参数缺失，无法删除");
        }
        return codeDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(CodeDetail codeDetail) {
        if (StringUtils.isEmpty(codeDetail.getOeduCodeDetailId())) {
            throw new LogicException("参数缺失，无法更新");
        }
        codeDetail.setUpdateTime(new Date());
        codeDetail.setUpdateUser(UserUtil.getUserId());
        return codeDetailMapper.updateByPrimaryKeySelective(codeDetail);
    }

    @Override
    public List<CodeDetail> getList(String codeType) {
        if (StringUtils.isEmpty(codeType)) {
            return new ArrayList<>();
        }
        return codeDetailMapper.selectCodeDetailByType(codeType);
    }

    @Override
    public Map<String, List<CodeDetail>> getCodeDetail(List<String> codeTypes) {
        if (ListUtil.isEmpty(codeTypes)) {
            return new HashMap<>();
        }
        List<CodeDetail> codeDetails = codeDetailMapper.selectCodeDetailByTypeList(codeTypes);
        return codeDetails.stream().collect(Collectors.groupingBy(CodeDetail::getCodeType));
    }

}
