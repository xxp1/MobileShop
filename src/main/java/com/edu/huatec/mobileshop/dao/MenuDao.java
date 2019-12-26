package com.edu.huatec.mobileshop.dao;

import com.edu.huatec.mobileshop.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 86182 on 2019/12/6.
 */
@Mapper
@Repository
public interface MenuDao {


    List<Menu> selectOne(int p_id);


}
