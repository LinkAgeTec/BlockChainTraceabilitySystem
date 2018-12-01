package cn.org.linkage.common;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
* @Description:    上下文检索工具
* @Author:         ACtangle
* @CreateDate:     2018/11/30 15:52
* @UpdateUser:     ACtangle
* @UpdateDate:     2018/11/30 15:52
* @UpdateRemark:   修改内容
* @Version:        1.0
*/


@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static <T> T popBean(Class<T> clazz) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(clazz);
    }

    public static <T> T popBean(String name,Class<T> clazz) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(name,clazz);
    }
}
