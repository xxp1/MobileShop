package com.edu.huatec.mobileshop.controller;


import com.edu.huatec.mobileshop.entity.Admin;
import com.edu.huatec.mobileshop.service.serviceImpl.AdminService;
import com.edu.huatec.mobileshop.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by 86182 on 2019/12/5.
 */

@Controller
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AdminService adminService;

    @RequestMapping("/searchOne")
    public String searchOne(String name, String password, HttpSession session,String code){
        //通过name查找某个登陆者，通过getPassword()判断密码是否是否一致
        Admin admin1 = adminService.findByName(name);
        //加密后的password
        String password1 = MD5Util.MD5Encode(password, "UTF-8'");
        //用户不等于null的前提下判断密码是否相等
        if(admin1.getName()!=null){
            if(admin1.getPassword()!=null && admin1.getPassword().equals(password1)){
                Admin admin2 = adminService.findById(name, password);
                Object attribute = session.getAttribute("yzm");
                if(admin2!=null&& attribute.equals(code)){
                    logger.info("这是一个测试");
                    return "redirect:back/main.jsp";
                }else {
                    return "redirect:back/login.jsp";
                }
            }else {
                //将新的用户名与密码存到数据库
                adminService.addAdmin(name,password1);
                //用新密码登陆
                Admin admin2 = adminService.findById(name, password1);
                Object attribute = session.getAttribute("yzm");
                    if(admin2!=null&& attribute.equals(code)){
                        return "redirect:back/main.jsp";
                    }else {
                        return "redirect:back/login.jsp";
                    }
            }
        }else {
            return "redirect:back/error.jsp";
        }
    }
}
