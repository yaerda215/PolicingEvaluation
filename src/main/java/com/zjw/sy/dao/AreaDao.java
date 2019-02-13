package com.zjw.sy.dao;

import org.springframework.stereotype.Repository;

import com.zjw.core.beans.WherePrams;
import com.zjw.core.dao.impl.DaoImpl;
import com.zjw.core.sql.where.C;
import com.zjw.sy.entity.Area;
import com.zjw.sy.entity.bean.QueryCondition;

/**
 * 
 * @描述：国家信息Dao
 * @author ：zjw
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午10:57:45
 *
 */
@Repository("areaDao")
public class AreaDao extends DaoImpl<Area, Long>{
	
	/**
	 * 构建查询条件
	 * @param query
	 * @return
	 */
	public WherePrams structureConditon(QueryCondition query){
		WherePrams where = new WherePrams();
		
		//关键字
		if(query.getKeyword() != null && !"".equals(query.getKeyword())){
			where.orStart();
			where.or("areaNameCn", C.LIKE, query.getKeyword());
			where.or("areaNameEn", C.LIKE, query.getKeyword());
			where.orEnd();
		}
		
		where.orderBy("createTime DESC");
		where.limit(query.getStart(), query.getLength());
		
		return where;
	}
}
