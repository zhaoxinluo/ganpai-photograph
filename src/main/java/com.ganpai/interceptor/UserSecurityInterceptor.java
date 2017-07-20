package com.ganpai.interceptor;

import com.ganpai.common.CommonParam;
import com.ganpai.redis.RedisClient;
import com.ganpai.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public class UserSecurityInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisClient redisClient;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        //每次请求 校验是否携带cookie 相关验证信息
        Cookie cookie = CookieUtil.getCookieByName(httpServletRequest, CommonParam.COOKIE_KEY);
        if(null == cookie){
            return true;
        }
        String cookieValue = cookie.getValue();

        //redis 查验是否存在对应信息
        String validValue = redisClient.get(cookieValue);
        if(StringUtils.isNotBlank(validValue)){
            //刷新redis 超时时间
            redisClient.expire(cookieValue,CommonParam.REDIS_AGE);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
