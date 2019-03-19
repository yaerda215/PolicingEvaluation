package com.zjw.sy.mapper;

import com.zjw.sy.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author ZhengJiawei
 * @create 2019-02-13 11:10
 */
@Repository("UserDao")
public interface UserDao {

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
