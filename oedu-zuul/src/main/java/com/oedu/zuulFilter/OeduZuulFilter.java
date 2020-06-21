package com.oedu.zuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Slf4j
@Component
public class OeduZuulFilter extends ZuulFilter {


    //排除过滤的 uri 地址
    @Value("zuul.filter.path")
    private String filterPath;

    @Value("zuul.reject.url")
    private String rejectUrl;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        log.info("uri:{}", request.getRequestURI());
        //配置的url不拦截，其他接口都要拦截校验 token
        List<String> pathList = Arrays.asList(filterPath.split("@"));
        if (pathList.contains(request.getRequestURI())) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("token");
        boolean flag = verifyToken(request, token);
        if (!flag) {
            try {
                log.info("验证登录失败，重定向到登录页面");
                requestContext.getResponse().sendRedirect(rejectUrl);
            } catch (IOException e) {
                log.error("无法重定向到登录页面");
            }
        }
        return null;
    }

    /**
     * 从Redis中校验token
     */
    private boolean verifyToken(HttpServletRequest request, String token) {
        if (StringUtils.isNotEmpty(token)) {
            String redisUserId = (String) redisTemplate.opsForValue().get(token);
            if (redisUserId != null && StringUtils.equals(redisUserId, request.getHeader("userId"))) {
                return true;
            }
        }
        return false;
    }
}
