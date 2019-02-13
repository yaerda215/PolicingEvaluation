package com.zjw.sy.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zjw.sy.entity.Area;
import com.zjw.sy.entity.bean.QueryCondition;
import com.zjw.sy.service.IAreaService;
import com.zjw.sy.web.view.DatatablesView;
import com.zjw.sy.web.view.MessageView;

/**
 * @描述：国家Controller
 * @author ：zjw
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:06:52
 */

@Controller
public class AreaController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private IAreaService areaService;
	
	/**
	 * 进入国家列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/area/list")
	public String goAreaList(HttpServletRequest request, Model model) {
		//request.getSession().setAttribute(Constants.CURRENT_USER, null);
		return "area";
	}
	
	/**
	 * 查询国家记录
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="/area/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, QueryCondition query) {
		DatatablesView<Area> dataTable = areaService.getAreaByCondition(query);
		dataTable.setDraw(query.getDraw());
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	/**
	 * 国家添加
	 * @param area
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/area/add", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String add(Area area, ModelMap model) {
		int status = areaService.addArea(area);
		
		String info = "";
		if (status == 1) {
			info = area.getAreaNameCn() + " 添加成功!";
			log.info("CCIC-SY系统：国家：" + info);
		}
		
		MessageView msg = new MessageView(status, info);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 国家修改
	 * @param area
	 * @return
	 */
	@RequestMapping(value = "/area/update", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(Area area) {
		int status = areaService.editArea(area);
		String info = "";
		if (status == 1) {
			info = area.getAreaNameCn() + " 修改成功!";
			log.info("CCIC-SY系统：国家：" + info);
		}
		
		MessageView msg = new MessageView(status, info);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 国家删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/area/del/{id}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		int status = areaService.removeArea(id);
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 获取所有国家列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/area/listAll", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String list(Model model){
		List<Area> list = areaService.getAllArea();
		return JSON.toJSONString(list);
	}
}