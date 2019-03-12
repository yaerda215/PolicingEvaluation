package com.zjw.sy.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjw.sy.entity.TaskManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zjw.sy.entity.Company;
import com.zjw.sy.entity.bean.QueryCondition;
import com.zjw.sy.service.ICompanyService;
import com.zjw.sy.web.view.DatatablesView;

/**
 * @描述：企业Controller
 * @author ：zjw
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:07:29
 */
@Controller
public class CompanyController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ICompanyService companyService;

	/**
	 * 查询用户记录
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="/com/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, QueryCondition query) {
		DatatablesView<TaskManage> dataTable = companyService.getCompanyByCondition(query);
		//dataTable.setDraw(query.getDraw());
		String data = JSON.toJSONString(dataTable);
		return data;
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "/pages/error/404.html";
	}
}