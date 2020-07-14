package com.oedu.sc.feign.client;

import com.oedu.common.result.Result;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "${feign.oedu.login.service.name}",fallbackFactory = UserFeign.UserFeignFallbackFactory.class)
public interface UserFeign {

    @PostMapping("/login/user/getNameByIds")
    Result<Map<String,String>> getNameByIds(List<String> userIds);


    @Component
    @Slf4j
    class UserFeignFallbackFactory implements FallbackFactory<UserFeign> {

        @Override
        public UserFeign create(Throwable throwable) {
            log.error("调用用户模块异常",throwable);
            return new UserFeign() {
                @Override
                public Result getNameByIds(List<String> userIds) {
                    return Result.userError();
                }
            };
        }
    }
}
