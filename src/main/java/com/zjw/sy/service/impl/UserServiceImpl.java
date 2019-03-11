package com.zjw.sy.service.impl;

import com.zjw.sy.mapper.UserDao;
import com.zjw.sy.entity.User;
import com.zjw.sy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户
 *
 * @author ZhengJiawei
 * @create 2019-02-13 11:26
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
