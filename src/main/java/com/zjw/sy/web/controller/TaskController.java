package com.zjw.sy.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.zjw.sy.entity.TaskManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zjw.sy.entity.bean.QueryCondition;
import com.zjw.sy.service.ITaskService;
import com.zjw.sy.web.view.DataTablesView;

/**
 * Description TaskController
 *
 * @author ZhengJiawei
 * @date 2019-03-19 09:31:32
 */
@Controller
public class TaskController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ITaskService taskService;

    /**
     * Description 获取任务列表
     *
     * @param request request
     * @param query query
     * @return String
     * @author ZhengJiawei
     * @date 2019-03-19 09:22:33
     */
    @RequestMapping(value = "/com/getData", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getTaskList(HttpServletRequest request, QueryCondition query) {
        DataTablesView<TaskManage> dataTable = taskService.getTaskByCondition(query);
        String data = JSON.toJSONString(dataTable);
        return data;
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e, HttpServletRequest request) {
        request.setAttribute("exception", e);
        return "/pages/error/404.html";
    }

}