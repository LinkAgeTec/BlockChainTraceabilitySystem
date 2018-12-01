package cn.org.linkage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* @Description:    web项目启动类
* @Author:         ACtangle
* @CreateDate:     2018/11/22 11:55
* @UpdateUser:     ACtangle
* @UpdateDate:     2018/11/22 11:55
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

@SpringBootApplication
@MapperScan({"cn.org.linkage.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
