package com.zjw.sy.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.zjw.sy.common.Constants;
import com.zjw.sy.entity.User;
import com.zjw.sy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description 用户controller
 *
 * @author ZhengJiawei
 * @date 2019-03-19 09:28:19
 */
@Controller
@RequestMapping("/user")
public class UserController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    /**
     * Description 登录
     *
     * @param request request
     * @param user    用户
     * @param model   model
     * @return String
     * @author ZhengJiawei
     * @date 2019-03-19 09:26:19
     */
    @RequestMapping("/login")
    public String sign(HttpServletRequest request, User user, Model model) {
        user = userService.login(user);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            model.addAttribute("user", user);
            return "index";
        } else {
            model.addAttribute("msg", "登陆失败，请重新登陆!");
            return "login";
        }
    }

    /**
     * Description 用户退出
     *
     * @param request request
     * @return String
     * @author ZhengJiawei
     * @date 2019-03-19 09:27:17
     */
    @RequestMapping("/out")
    public String out(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return "login";
    }

    /**
     * Description 用户注册
     *
     * @return String
     * @author ZhengJiawei
     * @date 2019-03-19 09:27:51
     */
    @RequestMapping("/reg")
    public String register() {
        return "register";
    }

}