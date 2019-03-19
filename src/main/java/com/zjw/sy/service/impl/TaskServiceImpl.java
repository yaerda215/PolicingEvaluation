package com.zjw.sy.service.impl;

import com.zjw.sy.entity.TaskManage;
import com.zjw.sy.entity.bean.QueryCondition;
import com.zjw.sy.mapper.TaskMapper;
import com.zjw.sy.service.ITaskService;
import com.zjw.sy.web.view.DataTablesView;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description TaskServiceImpl
 *
 * @author ZhengJiawei
 * @date 2019-03-19 09:28:48
 */
@Service("TaskServiceImpl")
public class TaskServiceImpl implements ITaskService {

    @Resource
    private TaskMapper taskMapper;

    @Override
    public DataTablesView<TaskManage> getTaskByCondition(QueryCondition query) {
        List<TaskManage> list = taskMapper.taskList(query);
        DataTablesView<TaskManage> dataTablesView = new DataTablesView<>();
        dataTablesView.setData(list);
        dataTablesView.setRecordsTotal(list.size());
        dataTablesView.setDraw(query.getDraw());
        return dataTablesView;
    }
}
