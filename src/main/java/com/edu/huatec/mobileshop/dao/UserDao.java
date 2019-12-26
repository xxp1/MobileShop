package com.edu.huatec.mobileshop.dao;

import com.edu.huatec.mobileshop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 86182 on 2019/12/5.
 */
@Mapper
@Repository
public interface UserDao {

    //查询所有User
    List<User> selectList();
    //分页，每页多少行
    List<User> selectPage(@Param("page")int page,@Param("rows")int rows);

    int selectUser();
}
