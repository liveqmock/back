package com.ihk.sale.action;

import com.ihk.utils.SupperAction;

/**
 * 恒大主页
 */
public class IndexAction extends SupperAction{
	
	
	private static final long serialVersionUID = 1L;

	private String chartXAxis;
	private String chartSeries;
	
	
	
	public String getChartXAxis() {
		return chartXAxis;
	}



	public void setChartXAxis(String chartXAxis) {
		this.chartXAxis = chartXAxis;
	}



	public String getChartSeries() {
		return chartSeries;
	}



	public void setChartSeries(String chartSeries) {
		this.chartSeries = chartSeries;
	}


//根据登陆的人给出各自的index界面
	public String index(){
		this.chartXAxis = "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']";
		this.chartSeries =  "[{name: '恒大清远',data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6,1,1,1,1,1,1,1,1,1,1,1,1,1,11,1,11,1,1,2,2,3]}, {name: '恒大安徽',data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]}, {name: '恒大广州',data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]}, {name: '恒大',data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]}]";
		return "indexget";
	}
	
	
}
