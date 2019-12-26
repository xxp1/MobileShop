package com.edu.huatec.mobileshop.service.serviceImpl;

import com.edu.huatec.mobileshop.advice.Detail;
import com.edu.huatec.mobileshop.dao.AdminDao;
import com.edu.huatec.mobileshop.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 86182 on 2019/12/5.
 */
@Service
@Transactional
public class AdminService {

    @Autowired
    AdminDao adminDao;


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Detail("登陆")
    public Admin findById(String name,String password){
        //得到Request作用域，通过其得到session作用域
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Admin admin = adminDao.selectOne(name,password);
        //将登陆的用户存到session作用域当中
        request.getSession().setAttribute("admin",admin);
        return admin;
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Detail("姓名找密码")
    public Admin findByName(String name){

        return adminDao.selectName(name);


    }
    @Transactional
    @Detail("添加用户")
    public void addAdmin(String name,String password){

        adminDao.insertAdmin(name,password);

    }

}
