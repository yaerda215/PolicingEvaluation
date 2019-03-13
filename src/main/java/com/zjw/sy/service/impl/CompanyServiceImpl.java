package com.zjw.sy.service.impl;

import com.zjw.sy.entity.Company;
import com.zjw.sy.entity.TaskManage;
import com.zjw.sy.entity.bean.QueryCondition;
import com.zjw.sy.mapper.CompMapper;
import com.zjw.sy.service.ICompanyService;
import com.zjw.sy.web.view.DatatablesView;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhengJiawei
 * @create 2019-03-12 16:08
 */
@Service("CompanyServiceImpl")
public class CompanyServiceImpl implements ICompanyService {

    @Resource
    private CompMapper compMapper;

    @Override
    public DatatablesView<TaskManage> getCompanyByCondition(QueryCondition query) {
        List<TaskManage> list = compMapper.taskList(query);
        DatatablesView<TaskManage> datatablesView = new DatatablesView<>();
        datatablesView.setData(list);
        datatablesView.setRecordsTotal(list.size());
        datatablesView.setDraw(query.getDraw());
        return datatablesView;
    }
}
