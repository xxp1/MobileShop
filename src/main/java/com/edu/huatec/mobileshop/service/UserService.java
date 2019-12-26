package com.edu.huatec.mobileshop.service;

import com.edu.huatec.mobileshop.advice.Detail;
import com.edu.huatec.mobileshop.dao.UserDao;
import com.edu.huatec.mobileshop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 86182 on 2019/12/5.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Detail("查找所有用户")
    public List<User> findList(){

        return userDao.selectList();

    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Detail("分页查询用户")
    public List<User> queryPage(int page,int rows){

        List<User> users = userDao.selectPage(page, rows);

        return users;
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Detail("用户总数")
    public int queryUser(){

        int user = userDao.selectUser();

        return user;
    }
}
