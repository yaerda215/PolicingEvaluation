package com.zjw.sy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zjw.core.beans.WherePrams;
import com.zjw.core.sql.where.C;
import com.zjw.sy.service.ICompanyService;
import com.zjw.sy.web.view.DatatablesView;
import com.zjw.sy.common.DateUtil;
import com.zjw.sy.common.MD5;
import com.zjw.sy.common.info.GenerateLinkUtils;
import com.zjw.sy.dao.CompanyDao;
import com.zjw.sy.entity.Company;
import com.zjw.sy.entity.bean.QueryCondition;

/**
 * @描述：企业信息service
 * @作者：CYH
 * @版本：V1.0
 * @创建时间：：2016-12-14 下午3:43:02
 */
@Service("companyService")
public class CompanyService implements ICompanyService{
	
	@Resource  
	private CompanyDao companyDao;


	@Override
	public List<Company> getAllCompany(){
		List<Company> list = companyDao.list();
		return list;
	}

	@Override
	public DatatablesView<Company> getCompanyByCondition(QueryCondition query){
		DatatablesView<Company> dataView = new DatatablesView<Company>();
		
		//构建查询条件
		WherePrams where = companyDao.structureConditon(query);
		
		Long count = companyDao.count(where);
		List<Company> list = companyDao.list(where);
		
		dataView.setRecordsTotal(count.intValue());
		dataView.setData(list);
		
		return dataView;
	}

	@Override
	public List<Company> getCompanyByType(Integer type){
		WherePrams where = new WherePrams();
		where.and("companyType", C.EQ, type);
		
		List<Company> list = companyDao.list(where);
		return list;
	}

	@Override
	public Company getCompanyById(long companyId){
		return companyDao.get(companyId);
	}

	@Override
	public Company getCompanyByNamePassword(Company company){
		WherePrams where = new WherePrams();
		where.and("username", C.EQ,company.getUsername());
		where.and("password", C.EQ, MD5.md5(company.getPassword()));
		
		List<Company> list = companyDao.list(where);
		for (Company com : list) {
			return com;
		}
		return null;
	}

	@Override
	public Company getCompanyByName(String username){
		WherePrams where = new WherePrams();
		where.and("username", C.EQ, username);
		List<Company> list = companyDao.list(where);
		for (Company com : list) {
			return com;
		}
		return null;
	}

	@Override
	public int addCompany(Company company){
		company.setPassword(MD5.md5(company.getPassword()));
		return companyDao.addLocal(company);
	}

	@Override
	public int editCompany(Company company){
		company.setLastOpTime(DateUtil.getNowTime());
		WherePrams where = new WherePrams();
		where.and("companyId", C.EQ, company.getCompanyId());
		return companyDao.updateLocal(company,where);
	}

	@Override
	public int removeCompany(long companyId){
		return companyDao.del(companyId);
	}

	@Override
	public int activeUser(Company company, String checkCode){
		boolean active = GenerateLinkUtils.verifyCheckcode(company, checkCode);
		
		int result = 0;
		if(active){
			Company com = new Company(company.getCompanyId());
			com.setCompanyStatus(1);
			WherePrams where = new WherePrams();
			where.and("companyId", C.EQ, company.getCompanyId());
			result = companyDao.updateLocal(com, where);
		}
		return result;
	}

	@Override
	public int forgetPassword(String id, String username, String checkCode){
		
		return 0;
	}
	
}