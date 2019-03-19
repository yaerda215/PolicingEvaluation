package com.zjw.sy.web.view;

import java.util.List;

/**
 * Description DataTable
 *
 * @author ZhengJiawei
 * @date 2019-03-19 09:30:55
 */
public class DataTablesView<T> {
  
    private List<T> data; //data 与datatales 加载的“dataSrc"对应  
    
    private int recordsTotal;   
    
    private int recordsFiltered;  
    
    private int draw;
    
    public DataTablesView() {
          
    }

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}  
  
} 