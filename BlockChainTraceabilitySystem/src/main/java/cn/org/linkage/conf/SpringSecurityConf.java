package cn.org.linkage.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
* @Description:    Spring Security 配置文件
* @Author:         ACtangle
* @CreateDate:     2018/11/22 11:09
* @UpdateUser:     ACtangle
* @UpdateDate:     2018/11/22 11:09
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Configuration
@EnableWebSecurity
public class SpringSecurityConf extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         *功能描述
         * 登录用户验证
                * @author ACtangle
                * @date 2018/11/22
                * @param [auth]
                * @return void
                */

        //以下为自定义的用于测试登录授权分权限验证的例子，实际上以数据库查询为主
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("ADMIN");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles("USER");


    }

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         *功能描述
         * 按条件进行是否验证，其中路径为/和登出的url请求为方形，其他任何需要验证
                * @author ACtangle
                * @date 2018/11/22
                * @param [http]
                * @return void
                */
        
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll()
                .and()
                .formLogin();
        http.csrf().disable();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        /**
         *对静态资源的路径请求均为放行状态
                * @author ACtangle
                * @date 2018/11/22
                * @param [web]
                * @return void
                */
        
        web.ignoring().antMatchers("/js/**","/css/**","/images/**");
    }
}
