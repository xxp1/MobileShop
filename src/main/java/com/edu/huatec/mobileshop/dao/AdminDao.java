package com.edu.huatec.mobileshop.dao;

import com.edu.huatec.mobileshop.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by 86182 on 2019/12/5.
 */
@Mapper
@Repository
public interface AdminDao {

    //登陆
    Admin selectOne(@Param("name") String name, @Param("password") String password);
    //通过name找到一个登陆者
    Admin selectName(String name);
    //插入登陆者
    void insertAdmin(@Param("name") String name,@Param("password") String password);

}
