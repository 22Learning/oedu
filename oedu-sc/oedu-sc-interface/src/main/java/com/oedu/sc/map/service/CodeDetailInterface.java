package com.oedu.sc.map.service;

import com.oedu.sc.map.po.CodeDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CodeDetailInterface {

    int add(CodeDetail codeDetail);

    int delete(Long id);

    int update(CodeDetail codeDetail);

    List<CodeDetail> getList(String codeType);

    Map<String, List<CodeDetail>> getCodeDetail(List<String> codeTypes);
}
