package com.zjw.sy.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 用户
 *
 * @author ZhengJiawei
 * @create 2019-02-13 11:13
 */
@Table(name="user")
public class User {

    @Column(name = "userId")
    private int userId;

    @Column(name = "userName")
    private int userName;

    @Column(name = "pwd")
    private int pwd;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }
}
