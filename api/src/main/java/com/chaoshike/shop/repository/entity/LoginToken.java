package com.chaoshike.shop.repository.entity;

import java.util.Date;


public class LoginToken {
    private int id;
    private String UUID;
    private String token;
    private int platform;

    @Override
    public String toString() {
        return "LoginToken{" +
                "id=" + id +
                ", UUID='" + UUID + '\'' +
                ", token='" + token + '\'' +
                ", platform=" + platform +
                ", expireTime=" + expireTime +
                ", createTime=" + createTime +
                '}';
    }

    public LoginToken(String UUID, String token, int platform, Date expireTime) {
        this.UUID = UUID;
        this.token = token;
        this.platform = platform;
        this.expireTime = expireTime;
        this.createTime = new Date();
    }

    public LoginToken() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Date expireTime;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date createTime;

}
