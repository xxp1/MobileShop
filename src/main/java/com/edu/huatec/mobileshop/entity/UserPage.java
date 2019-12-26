package com.edu.huatec.mobileshop.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 86182 on 2019/12/10.
 */
public class UserPage implements Serializable{

    private Integer total;
    private List<User> rows;

    @Override
    public String toString() {
        return "UserPage{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<User> getRows() {
        return rows;
    }

    public void setRows(List<User> rows) {
        this.rows = rows;
    }
}
