package com.chaoshike.shop.repository.entity;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private int integral;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", integral=" + integral +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", loginTime=" + loginTime +
                '}';
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public User() {
    }

    private String mobile;

    public User(String password, String mobile) {
        this.password = password;
        this.name = mobile;
        this.mobile = mobile;
        this.status = 0;
        this.email = "";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    private int status;
    private Date createTime = new Date();
    private Date loginTime = new Date();
}
