package com.edu.huatec.mobileshop.service;

import com.edu.huatec.mobileshop.dao.DailyDao;
import com.edu.huatec.mobileshop.entity.Daily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 86182 on 2019/12/9.
 */
@Service
public class DailyService {

    @Autowired
    private DailyDao dailyDao;


    public void addOne(Daily daily){

        dailyDao.insertOne(daily);

    }
















}
