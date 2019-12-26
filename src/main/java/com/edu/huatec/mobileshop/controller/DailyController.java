package com.edu.huatec.mobileshop.controller;

import com.edu.huatec.mobileshop.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 86182 on 2019/12/9.
 */
@Controller
public class DailyController {


    @Autowired
    private DailyService dailyService;


}
