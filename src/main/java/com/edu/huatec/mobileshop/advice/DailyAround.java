package com.edu.huatec.mobileshop.advice;


import com.edu.huatec.mobileshop.dao.DailyDao;
import com.edu.huatec.mobileshop.entity.Admin;
import com.edu.huatec.mobileshop.entity.Daily;
import com.edu.huatec.mobileshop.util.SpringUtils;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 86182 on 2019/12/9.
 */
@Component
@Aspect
//@DependsOn("springContextHolder")
public class DailyAround {
    //主要得到什么人在什么时间做了什么事情
    @Around("execution(* com.edu.huatec.mobileshop.service.*.*(..))")
    public Object intercept(ProceedingJoinPoint p) throws Throwable {
        Object proceed = p.proceed();
        //使用sb对象可以拼接字符串
        StringBuilder stringBuilder = new StringBuilder();
        //得到什么人，一般session作用域
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Admin admin = (Admin)request.getSession().getAttribute("admin");

        //通过admin对象得到其中的用户
        stringBuilder.append("用户"+admin.getName());
        //得到当前时间
        String sysdateTime = new SimpleDateFormat("yyyy-MM-dd HH:dd:ss").format(new Date());
        stringBuilder.append("在"+sysdateTime);
        //干了某事件即访问当前方法
        MethodSignature signature = (MethodSignature)p.getSignature();
        Method method = signature.getMethod();
        Detail detail = method.getAnnotation(Detail.class);
        if(detail!=null){
            //使用自定义注解的值
            String value = detail.value();
            String name = method.getName();
            stringBuilder.append("做了"+name+"操作");
            //控制台输出信息
            System.out.println(stringBuilder);
            //存到数据库中（工具类得到applicationContext对象，从而得到实例）
            ApplicationContext context = SpringUtils.getApplicationContext();
            DailyDao dailyDao = (DailyDao)context.getBean("dailyDao");
            Daily daily = new Daily();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:dd:ss");
            Date date = format.parse(sysdateTime);
            //将utilDate转换为Date
            Long dateTime =date.getTime();
            Date date1 = new Date(dateTime);
            daily.setDate(date1);
            daily.setName(admin.getName());
            daily.setDetail(stringBuilder.toString());
            dailyDao.insertOne(daily);
        }
        return proceed;
    }
}
