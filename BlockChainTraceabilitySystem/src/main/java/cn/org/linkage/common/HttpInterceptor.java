package cn.org.linkage.common;


import cn.org.linkage.utils.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
* @Description:    Http拦截器
* @Author:         ACtangle
* @CreateDate:     2018/11/30 15:52
* @UpdateUser:     ACtangle
* @UpdateDate:     2018/11/30 15:52
* @UpdateRemark:   修改内容
* @Version:        1.0
*/




@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static final String START_TIME = "requestStartTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        Map paramterMap = request.getParameterMap();
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME,start);
//        log.info("request start. url:{},params:{}",url, JsonMapper.obj2String(paramterMap));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = request.getRequestURL().toString();
////        Map paramterMap = request.getParameterMap();
        long start = (Long)request.getAttribute(START_TIME);
        long end  = System.currentTimeMillis();
//        log.info("request finished. url:{},cost:{}",url, end - start);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURL().toString();
//        Map paramterMap = request.getParameterMap();
        long start = (Long)request.getAttribute(START_TIME);
        long end  = System.currentTimeMillis();
//        log.info("request completed. url:{},cost:{}",url, end - start);
    }
}
