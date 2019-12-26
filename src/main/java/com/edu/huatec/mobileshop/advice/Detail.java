package com.edu.huatec.mobileshop.advice;

import java.lang.annotation.*;

/**
 * Created by 86182 on 2019/12/9.
 */
//自定义注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Detail {
    String value();
}
