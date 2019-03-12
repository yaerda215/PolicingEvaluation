package com.zjw.sy.mapper;

import com.zjw.sy.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author ZhengJiawei
 * @create 2019-02-13 11:10
 */
@Repository("UserDao")
public interface UserDao {
    User login(User user);
}