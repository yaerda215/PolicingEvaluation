package com.zjw.sy.service;


import com.zjw.sy.entity.TaskManage;
import com.zjw.sy.entity.bean.QueryCondition;
import com.zjw.sy.web.view.DataTablesView;

/**
 * Description ITaskService
 *
 * @author ZhengJiawei
 * @date 2019-03-19 09:25:12
 */
public interface ITaskService {

    /**
     * Description 获取任务列表
     *
     * @param query
     * @return DataTablesView
     * @author ZhengJiawei
     * @date 2019-03-19 09:29:31
     */
    DataTablesView<TaskManage> getTaskByCondition(QueryCondition query);


}
