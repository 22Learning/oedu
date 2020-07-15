package com.oedu.sc.map.web;

import com.oedu.common.result.Result;
import com.oedu.sc.map.po.CodeDetail;
import com.oedu.sc.map.service.CodeDetailInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/sc/codeDetail/")
public class CodeDetailController {

    @Autowired
    private CodeDetailInterface codeDetailInterface;

    /**
     * 添加枚举
     * @param codeDetail
     * @return
     */
    @PostMapping("add")
    public Result add(@RequestBody CodeDetail codeDetail) {
        return new Result(codeDetailInterface.add(codeDetail));
    }

    @PostMapping("delete")
    public Result delete(@RequestBody CodeDetail codeDetail) {
        return new Result(codeDetailInterface.delete(codeDetail.getOeduCodeDetailId()));
    }

    @PostMapping("update")
    public Result update(@RequestBody CodeDetail codeDetail) {
        return new Result(codeDetailInterface.update(codeDetail));
    }

    /**
     * 根据枚举类型获取枚举列表
     * @param codeType
     * @return
     */
    @PostMapping("list")
    public Result getList(@RequestBody String codeType) {
        return new Result(codeDetailInterface.getList(codeType));
    }

    /**
     * 根据枚举类型列表获取列表中所有枚举
     * 用枚举类型分组
     * @param codeTypes
     * @return
     */
    @PostMapping("codeDetail")
    public Result getCodeDetail(@RequestBody List<String> codeTypes) {
        return new Result(codeDetailInterface.getCodeDetail(codeTypes));
    }
}
