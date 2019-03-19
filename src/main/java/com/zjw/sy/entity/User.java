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

    @Column(name = "permissionDegree")
    private String permissionDegree;

    @Column(name = "qdbm")
    private String qdbm;

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

    public String getPermissionDegree() {
        return permissionDegree;
    }

    public void setPermissionDegree(String permissionDegree) {
        this.permissionDegree = permissionDegree;
    }

    public String getQdbm() {
        return qdbm;
    }

    public void setQdbm(String qdbm) {
        this.qdbm = qdbm;
    }

}
