package com.ihk.saleunit.action.new_report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.collection.XLSExport;
import com.ihk.customer.data.ICustomerFollowMapper;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProject;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerSalesman;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerSalesmanCond;
import com.ihk.report.data.services.IReportPreCustomerServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;

/**
 * 客户数量对比(销售)
 * @author peter
 *
 */
public class CustomerNumCompareSalesAction extends SupperAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	IReportPreCustomerServices reportPreCustomerServices ;
	private ReportPreCustomerSalesmanCond cond;

	public String index() throws Exception {
		return "success";
	}



	public void setCond(ReportPreCustomerSalesmanCond cond) {
		this.cond = cond;
	}

	public ReportPreCustomerSalesmanCond getCond() {
		return cond;
	}
	
	

	/**
	 * 设置于session中的数据
	 * @param dataList
	 */
	private void setChartSeriesDataInSession(List<Map<String, String>> dataList) {
		String chartSeriesData;
		
		if (dataList == null || dataList.size() == 0) {
			chartSeriesData = "['无数据',1]";
			return;
		}
		String str_Number = "";
		for (Map p : dataList) {
			str_Number += "['" + p.get("realName") + "'," + p.get("sumCount") + "]"
					+ ",";
		}
		chartSeriesData = str_Number;

		request.getSession().setAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_SALES+ContSessionAttribute.TITLE, "客户数量对比(销售)");
		request.getSession().setAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_SALES+ContSessionAttribute.CHART_SERIES_DATA, chartSeriesData);
	}
	
	/**
	 * session保存页面当前数据，用于下载
	 * @param dataList
	 */
	private void setDownloadDataInSession(List<Map<String, String>> dataList){
		request.getSession().setAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_SALES+ContSessionAttribute.DOWNLOAD_DATA, dataList);		
	}

	/**
	 * 下载数据
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception {			

		@SuppressWarnings("unchecked")
		List<Map<String, String>> dataList = (List<Map<String, String>>) request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_SALES+ContSessionAttribute.DOWNLOAD_DATA);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList); //与模板里面的循环要求对应
		
		ReportUtils.downLoadReport(map, "customer_num_compare_sales.xls", "download-客户数量对比-销售" + CustomerUtils.getNowForString() + "-.xls", response);
		
		return null;
	}

	/**
	 * 点击查询的数据返回
	 * @return
	 * @throws Exception
	 */
	public String searchAjax() throws Exception {
		if(cond==null){
			cond = new ReportPreCustomerSalesmanCond();
		}
		setCondOrderSortByRequest(cond);
		
		ActionTemplate.executeAjaxPage(this, cond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				//不分页的做法
				cond.pageSize = 0;
				return 0;
			}
			
			//获取table中要显示的json
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
								
				cond.setReturnCount(0);
				List<ReportPreCustomerSalesman> list = reportPreCustomerServices.groupBySalesman(cond); 
				
				if(!CommonUtils.isCollectionEmpty(list)){
					
					Map<String, String> map = null;
					
					//与jsp中table的表头(th field)定义一致
					for(ReportPreCustomerSalesman obj : list){
						
						map = new HashMap<String, String>();

						map.put("projectName", obj.getProjectName());
						map.put("userId", String.valueOf(obj.getSalesmanId()));
						map.put("realName", obj.getSalesmanName());
						map.put("sumCount", String.valueOf(obj.getSumCount()));
												
						retList.add(map);
					}

					setChartSeriesDataInSession(retList);
					setDownloadDataInSession(retList);
					
					// 添加合计
					int sumCount = 0;
					for (Map line : retList) {
						sumCount += Integer.parseInt((line.get("sumCount").toString()));
					}

					Map<String, String> sumMap = new HashMap<String, String>();
					sumMap.put("projectName", "");
					sumMap.put("realName", "合计");
					sumMap.put("sumCount", String.valueOf(sumCount));
					retList.add(sumMap);
					
				}
				return retList;
			}
		});
		return null;
	}
	

}
