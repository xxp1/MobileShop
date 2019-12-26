package com.edu.huatec.mobileshop.service;

import com.edu.huatec.mobileshop.advice.Detail;
import com.edu.huatec.mobileshop.dao.MenuDao;
import com.edu.huatec.mobileshop.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 86182 on 2019/12/6.
 */
@Service
@Transactional
public class MenuService {

    @Autowired
    private MenuDao menuDao;


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Detail(value = "查找菜单")
    public List<Menu> findOne(int id){

        return menuDao.selectOne(id);

    }
}
