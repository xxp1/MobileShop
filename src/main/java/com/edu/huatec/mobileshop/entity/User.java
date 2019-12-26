package com.edu.huatec.mobileshop.entity;

/**
 * Created by 86182 on 2019/12/5.
 */
public class User {
    private int id;
    private int iphone;
    private String password;
    private String image;
    private String username;
    private int sex;
    private String address;
    private String qianming;
    private int status;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", iphone=" + iphone +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", qianming='" + qianming + '\'' +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIphone() {
        return iphone;
    }

    public void setIphone(int iphone) {
        this.iphone = iphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQianming() {
        return qianming;
    }

    public void setQianming(String qianming) {
        this.qianming = qianming;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
