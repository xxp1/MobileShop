package com.edu.huatec.mobileshop.controller;

import com.edu.huatec.mobileshop.entity.User;
import com.edu.huatec.mobileshop.entity.UserPage;
import com.edu.huatec.mobileshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 86182 on 2019/12/5.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getAll")
    @ResponseBody
    public void getAll(){
        List<User> user = userService.findList();

    }

    @RequestMapping("/findUser")
    @ResponseBody
    public UserPage findUser(int page,int rows){
        //得到所有User个数
        int i = userService.queryUser();
        //每页有多少行
        List<User> list = userService.queryPage(page, rows);
        UserPage userPage = new UserPage();
        //设置值
        userPage.setTotal(i);
        userPage.setRows(list);
        return userPage;
    }
}
