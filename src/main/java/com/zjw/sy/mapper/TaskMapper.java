package com.zjw.sy.mapper;

import com.zjw.sy.entity.TaskManage;
import com.zjw.sy.entity.bean.QueryCondition;

import java.util.List;

/**
 * @author ZhengJiawei
 * @create 2019-03-12 16:10
 */
public interface TaskMapper {

    /**
     * Description 获取任务列表
     *
     * @param task 任务
     * @return List<TaskManage>
     * @author ZhengJiawei
     * @date 2019-03-19 09:29:31
     */
    List<TaskManage> taskList(QueryCondition task);
}
