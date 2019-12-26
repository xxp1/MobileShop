package com.edu.huatec.mobileshop.entity;

import java.util.Date;

/**
 * Created by 86182 on 2019/12/9.
 */
public class Daily {
        private int id;
        private String name;
        private Date date;
        private String detail;
        private String type;

    @Override
    public String toString() {
        return "Daily{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", detail='" + detail + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
