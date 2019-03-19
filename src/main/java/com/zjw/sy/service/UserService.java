package com.zjw.sy.service;

import com.zjw.sy.entity.User;

/**
 * 用户
 *
 * @author ZhengJiawei
 * @create 2019-02-13 11:25
 */
public interface UserService {

    /**
     * Description 用户登录
     *
     * @param user 用户
     * @return User
     * @author ZhengJiawei
     * @date 2019-03-19 09:36:37
     */
    User login(User user);

}
