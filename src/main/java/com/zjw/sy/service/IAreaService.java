package com.zjw.sy.service;

import java.util.List;

import com.zjw.sy.entity.Area;
import com.zjw.sy.entity.bean.QueryCondition;
import com.zjw.sy.web.view.DatatablesView;

/**
 * @描述：国家信息service接口
 * @author ：CYH
 * @版本：V1.0
 * @创建时间：：2016-12-14 下午3:43:16
 */
public interface IAreaService{
	
	/**
	 * 功能描述：获取所有国家信息
	 * @return
	 */
	List<Area> getAllArea();
	
	/**
	 * 功能描述：根据条件获取国家信息
	 * @return
	 */
	DatatablesView<Area> getAreaByCondition(QueryCondition query);
	
	/**
	 * 功能描述：根据ID获取国家信息
	 * @param areaId
	 * @return
	 */
	Area getAreaById(long areaId);
	
	/**
	 * 功能描述：添加国家信息
	 * @param area
	 * @return
	 */
	int addArea(Area area);
	
	/**
	 * 功能描述：修改国家信息
	 * @param area
	 * @return
	 */
	int editArea(Area area);
	
	/**
	 * 功能描述：删除国家信息
	 * @param areaId
	 * @return int
	 */
	int removeArea(long areaId);
	
}
