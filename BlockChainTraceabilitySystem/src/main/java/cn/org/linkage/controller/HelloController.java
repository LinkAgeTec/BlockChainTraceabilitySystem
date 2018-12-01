package cn.org.linkage.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    测试controller
* @Author:         ACtangle
* @CreateDate:     2018/11/22 11:13
* @UpdateUser:     ACtangle
* @UpdateDate:     2018/11/22 11:13
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

@RestController
@EnableAutoConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HelloController {


    @RequestMapping(value="/")
    public String index() {
        return "index";
    }

    @RequestMapping(value="/hello")
    public String hello() {
        return "hello world";
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @RequestMapping(value = "/admin")
//    public String roles_admin() {
//        /**
//         *功能描述
//         * 只有管理员才能访问该路径，ROLE_为前缀，ADMIN为Spring Security 配置文件中添加Roles的String内容
//                * @author ACtangle
//                * @date 2018/11/22
//                * @param []
//                * @return java.lang.String
//                */
//
//        return "admin's page";
//    }
}
