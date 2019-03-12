package com.zjw.sy.mapper;

import com.zjw.sy.entity.TaskManage;
import com.zjw.sy.entity.bean.QueryCondition;

import java.util.List;

/**
 * @author ZhengJiawei
 * @create 2019-03-12 16:10
 */
public interface CompMapper {

    List<TaskManage> taskList(QueryCondition task);
}
