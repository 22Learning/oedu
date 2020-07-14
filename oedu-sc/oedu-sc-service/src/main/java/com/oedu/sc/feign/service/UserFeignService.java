package com.oedu.sc.feign.service;

import com.oedu.common.result.SourceEnum;
import com.oedu.sc.feign.client.UserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserFeignService {

    @Autowired
    private UserFeign userFeign;

    public Map<String,String> getNameByIds(List<String> effectiveList) {
       return  userFeign.getNameByIds(effectiveList).getDataThrowException(SourceEnum.OEDU_LOGIN.getName());
    }
}
