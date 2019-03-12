package com.zjw.sy.service;

import java.util.List;

import com.zjw.sy.entity.Company;
import com.zjw.sy.entity.TaskManage;
import com.zjw.sy.entity.bean.QueryCondition;
import com.zjw.sy.web.view.DatatablesView;

/**
 * @描述：企业信息service接口
 * @作者：ChenYunhong
 * @版本：V1.0
 * @创建时间：：2016-12-14 下午3:43:31
 */
public interface ICompanyService{

	/**
	 * 功能描述：根据条件获取企业信息
	 * @return
	 */
	DatatablesView<TaskManage> getCompanyByCondition(QueryCondition query);

	
}
