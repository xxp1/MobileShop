package com.edu.huatec.mobileshop.dao;

import com.edu.huatec.mobileshop.entity.Daily;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by 86182 on 2019/12/9.
 */
@Mapper
@Repository
public interface DailyDao {

    void insertOne(Daily daily);



}
