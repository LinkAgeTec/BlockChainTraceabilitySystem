package cn.org.linkage.common;

import com.mmall.exception.ParamException;
import com.mmall.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @Description:    接口请求全局异常处理
* @Author:         ACtangle
* @CreateDate:     2018/11/29 11:37
* @UpdateUser:     ACtangle
* @UpdateDate:     2018/11/29 11:37
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

@Slf4j
public class SpringExceptionResolver  implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String url = httpServletRequest.getRequestURL().toString();
        ModelAndView modelAndView;
        String defaultMsg = "System error";
        //.json,.page
        //这里要求项目中所有请求json数据，都使用.json结尾
        if (url.endsWith(".json")) {
            if(e instanceof PermissionException || e instanceof ParamException) {
                JsonData result = JsonData.fail(e.getMessage());
                modelAndView = new ModelAndView("jsonView",result.toMap());
            }else {
//                log.error("unknown json exception:" + url,e);
                JsonData result = JsonData.fail(defaultMsg);
                modelAndView = new ModelAndView("jsonView",result.toMap());
            }
        }else if(url.endsWith(".page")){//这里要求项目中所有请求page页面，都使用.page结尾
//            log.error("unknown page exception:" + url,e);
            JsonData result = JsonData.fail(defaultMsg);
            modelAndView = new ModelAndView("exception",result.toMap());
        }else {
//            log.error("unknown exception:" + url,e);
            JsonData result = JsonData.fail(defaultMsg);
            modelAndView = new ModelAndView("jsonView",result.toMap());
        }
        return modelAndView;
    }
}
