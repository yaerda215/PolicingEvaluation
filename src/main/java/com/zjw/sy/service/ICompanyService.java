package com.zjw.sy.service;

import java.util.List;

import com.zjw.sy.entity.Company;
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
	 * 功能描述：获取所有企业信息
	 * @return
	 */
	List<Company> getAllCompany();
	
	/**
	 * 功能描述：根据条件获取企业信息
	 * @return
	 */
	DatatablesView<Company> getCompanyByCondition(QueryCondition query);
	
	/**
	 * 根据制定类型获取用户
	 * @param type
	 * @return
	 */
	List<Company> getCompanyByType(Integer type);
	
	/**
	 * 功能描述：根据ID获取企业信息
	 * @param companyId
	 * @return
	 */
	Company getCompanyById(long companyId);
	
	/**
	 * 功能描述：根据用户名和密码获取企业信息
	 * @param company
	 * @return
	 */
	Company getCompanyByNamePassword(Company company);
	
	/**
	 * 功能描述：根据用户名获取企业信息
	 * @param username
	 * @return
	 */
	Company getCompanyByName(String username);
	
	/**
	 * 功能描述：添加企业信息
	 * @param company
	 * @return
	 */
	int addCompany(Company company);
	
	/**
	 * 功能描述：修改企业信息
	 * @param company
	 * @return
	 */
	int editCompany(Company company);
	
	/**
	 * 功能描述：删除企业信息
	 * @param companyId
	 * @return
	 */
	int removeCompany(long companyId);
	
	/**
	 * 功能描述：用户激活
	 * @param company
	 * @param checkCode
	 * @return
	 */
	public int activeUser(Company company, String checkCode);
	
	/**
	 * 功能描述：找回密码
	 * @param id
	 * @param username
	 * @param checkCode
	 * @return
	 */
	int forgetPassword(String id, String username, String checkCode);
	
}
