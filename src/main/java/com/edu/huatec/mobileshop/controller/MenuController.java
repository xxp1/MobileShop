package com.edu.huatec.mobileshop.controller;

import com.edu.huatec.mobileshop.entity.Menu;
import com.edu.huatec.mobileshop.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 86182 on 2019/12/6.
 */

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;



    @RequestMapping("/searchOne")
    @ResponseBody
    public List<Menu> searchOne(){
        //先找到一级目录
        List<Menu> menus = menuService.findOne(0);
        //二级目录
        ArrayList<Menu> list = new ArrayList<>();
        for(Menu m:menus){
            List<Menu> list1 = menuService.findOne(m.getId());
            m.setList(list1);
            list.add(m);
        }
        return  list;
    }
}
