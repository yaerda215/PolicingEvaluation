package com.zjw.sy.dao;

import org.springframework.stereotype.Repository;

import com.zjw.core.beans.WherePrams;
import com.zjw.core.dao.impl.DaoImpl;
import com.zjw.core.sql.where.C;
import com.zjw.sy.entity.Company;
import com.zjw.sy.entity.bean.QueryCondition;

/**
 * 
 * @描述：企业信息Dao
 * @author ：zjw
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午10:58:09
 *
 */
@Repository("companyDao")
public class CompanyDao extends DaoImpl<Company, Long>{
	
	/**
	 * 构建查询条件
	 * @param query
	 * @return
	 */
	public WherePrams structureConditon(QueryCondition query){
		WherePrams where = new WherePrams();
		
		//类型
		if(query.getType() != null && !"".equals(query.getType()) && query.getType() != 0){
			where.and("companyType", C.EQ, query.getType());
		}
		
		//关键字
		if(query.getKeyword() != null && !"".equals(query.getKeyword())){
			where.orStart();
			where.or("username", C.LIKE, query.getKeyword());
			where.or("companyContactsName", C.LIKE, query.getKeyword());
			where.or("companyContactsTel", C.LIKE, query.getKeyword());
			where.or("companyContactsEmail", C.LIKE, query.getKeyword());
			where.or("companyContactsMobile", C.LIKE, query.getKeyword());
			where.or("companyName", C.LIKE, query.getKeyword());
			where.orEnd();
		}
		
		where.orderBy("createTime DESC");
		where.limit(query.getStart(), query.getLength());
		
		return where;
	}
	
}
