package com.zjw.sy.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.zjw.sy.entity.User;
import com.zjw.sy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zjw.sy.common.Constants;
import com.zjw.sy.common.info.EmailUtils;
import com.zjw.sy.entity.Company;
import com.zjw.sy.service.ICompanyService;
import com.zjw.sy.web.view.MessageView;

/**
 * @描述：用户Controller
 * @author ：zjw
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:08:43
 */
@Controller
public class UserController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ICompanyService companyService;

	@Resource
	private UserService userService;
	
	/**
	 * 用户登陆
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/account/sign")
	public ModelAndView sign(HttpServletRequest request, User user, Model model){
		user = userService.login(user);
		if(user != null){
			//request.getSession().setAttribute(Constants.CURRENT_USER, user);
			return new ModelAndView("company");
		}else{
			model.addAttribute("msg", "登陆失败，请重新登陆!");
			return new ModelAndView("login");
		}
	}
	
	/**
	 * 用户退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/account/out")
	public String out(HttpServletRequest request){   
		request.getSession().setAttribute("company", null);
		return "login";
	}

	
	/**
	 * 用户找回密码
	 * @param request
	 * @return
	 */
	@RequestMapping("/account/resetPassword/service")
	public String forgetPassword(HttpServletRequest request){   
		request.getSession().setAttribute("company", null);
		return "login";
	}

	
	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping("/account/reg")
	public String register(){ 
		return "register";
	}

	
	/**
	 * 发送激活邮件线程
	 * @author zjw
	 *
	 */
	class SendMailThread implements Runnable{
		
		private Company company;
		
		public SendMailThread(Company company){
			this.company = company;
		}

		@Override
		public void run() {
			//发送激活邮件
			EmailUtils.sendAccountActivateEmail(company);
		}
	}
	
}