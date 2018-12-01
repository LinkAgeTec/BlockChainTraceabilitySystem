package cn.org.linkage.controller;

import cn.org.linkage.common.JsonData;
import cn.org.linkage.entity.SysAdmin;
import cn.org.linkage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
* @Description:    登录控制器
* @Author:         ACtangle
* @CreateDate:     2018/12/1 10:43
* @UpdateUser:     ACtangle
* @UpdateDate:     2018/12/1 10:43
* @UpdateRemark:   修改内容
* @Version:        1.0
*/


@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    AdminService adminService;

    //登录界面跳转
    @RequestMapping(value="login.page",method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }
    @RequestMapping(value="addAdmin.page",method = RequestMethod.GET)
    public String addSysAdmin(HttpServletResponse response) {
        return "admin/addSysAdmin";
    }


    //登录处理
    @RequestMapping(value="loginUser.json",method = RequestMethod.POST)
    @ResponseBody
    public JsonData loginUser(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        SysAdmin admin = null;
        try{
            admin = adminService.selectByAdmin(username,password);
            if(adminService.selectByPrimaryKey(admin.getId()) != null) {
                session.setAttribute("admin",admin);
                return JsonData.success(admin);
            }
        }catch (Exception e) {
//            log.info(e.printStackTrace());
        }
        return JsonData.fail("error");
    }


    //退出登录
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpSession session) {
        if (session.getAttribute("admin") != null) {
            session.setAttribute("admin",null);
            return "admin/login";
        }
        return "index";
    }

    //添加系统管理员
    @RequestMapping(value = "addSysAdmin.json",method = RequestMethod.POST)
    @ResponseBody
    public JsonData addAdmin(HttpServletRequest request,HttpServletResponse response,
                             @RequestParam("username")String username,@RequestParam("password") String password
                             ,HttpSession session) {
        SysAdmin admin = new SysAdmin();
//        admin = adminService.selectByAdmin(username,password);
//        if(admin.getId() > 0) {
//            return JsonData.fail("this admin is already register");
//        }else {
            admin.setAdminname(username);
            admin.setAdminpassword(password);
            admin.setLevel(1);
            admin.setTime(new Date());
            adminService.insert(admin);
            return JsonData.success(adminService.selectByAdmin(username,password));
//        }
    }
}
