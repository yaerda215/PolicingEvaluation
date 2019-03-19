package com.zjw.sy.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
     * @return ModelAndView
     * @author ZhengJiawei
     * @date 2019-03-19 09:26:19
     */
    @RequestMapping("/account/sign")
    public ModelAndView sign(HttpServletRequest request, User user, Model model) {
        user = userService.login(user);
        if (user != null) {
            //request.getSession().setAttribute(Constants.CURRENT_USER, user);
            return new ModelAndView("company");
        } else {
            model.addAttribute("msg", "登陆失败，请重新登陆!");
            return new ModelAndView("login");
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
    @RequestMapping("/account/out")
    public String out(HttpServletRequest request) {
        request.getSession().setAttribute("company", null);
        return "login";
    }

    /**
     * Description 用户注册
     *
     * @return String
     * @author ZhengJiawei
     * @date 2019-03-19 09:27:51
     */
    @RequestMapping("/account/reg")
    public String register() {
        return "register";
    }

}