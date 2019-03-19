package com.zjw.sy.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 用户实体类
 *
 * @author ZhengJiawei
 * @create 2019-02-13 11:13
 */
@Table(name="user")
public class User {

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "pwd")
    private String pwd;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
