package com.zjw.sy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zjw.core.beans.WherePrams;
import com.zjw.core.sql.where.C;
import com.zjw.sy.common.DateUtil;
import com.zjw.sy.dao.AreaDao;
import com.zjw.sy.entity.Area;
import com.zjw.sy.entity.bean.QueryCondition;
import com.zjw.sy.service.IAreaService;
import com.zjw.sy.web.view.DatatablesView;

/**
 * @描述：国家信息service
 * @作者：CYH
 * @版本：V1.0
 * @创建时间：：2016-12-14 下午3:42:45
 */
@Service("areaService")
public class AreaService implements IAreaService{
	
	@Resource
	private AreaDao areaDao;

	@Override
	public DatatablesView<Area> getAreaByCondition(QueryCondition query) {
		DatatablesView<Area> dataView = new DatatablesView<Area>();
		
		//构建查询条件
		WherePrams where = areaDao.structureConditon(query);
		
		Long count = areaDao.count(where);
		List<Area> list = areaDao.list(where);
		
		dataView.setRecordsTotal(count.intValue());
		dataView.setData(list);
		
		return dataView;
	}

	@Override
	public List<Area> getAllArea(){
		return areaDao.list();
	}

	@Override
	public Area getAreaById(long areaId){
		return areaDao.get(areaId);
	}

	@Override
	public int addArea(Area area){
		return areaDao.addLocal(area);
	}

	@Override
	public int editArea(Area area){
		area.setUpdateTime(DateUtil.getNowTime());
		WherePrams where = new WherePrams();
		where.and("areaId", C.EQ, area.getAreaId());
		return areaDao.updateLocal(area,where);
	}

	@Override
	public int removeArea(long areaId){
		return areaDao.del(areaId);
	}

}
