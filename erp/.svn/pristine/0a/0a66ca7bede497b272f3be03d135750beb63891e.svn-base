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

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.collection.XLSExport;
import com.ihk.customer.data.ICustomerFollowMapper;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompany;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProject;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestionCompany;
import com.ihk.report.data.services.IReportPreCustomerServices;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.RolePriv;
import com.ihk.user.data.pojo.RolePrivCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;

/**
 * 客户数量对比(项目)
 *
 */
public class CustomerNumCompareProjectAction extends SupperAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	IReportPreCustomerServices reportPreCustomerServices ;
	private ReportPreCustomerProjectCond cond;
	private boolean cbxIncludeEmpty=false;//是否显示没有数据的项目

	public boolean getCbxIncludeEmpty() {
		return cbxIncludeEmpty;
	}

	public void setCbxIncludeEmpty(boolean cbxIncludeEmpty) {
		this.cbxIncludeEmpty = cbxIncludeEmpty;
	}

	/**
	 * 直接返回查询的列表格式
	 * @return
	 * @throws Exception
	 */
	public String index() throws Exception {
		return SUCCESS;
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
			str_Number += "['" + p.get("projectName") + "'," + p.get("sumCount") + "]"
					+ ",";
		}
		chartSeriesData = str_Number;

		request.getSession().setAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_PROJECT+ContSessionAttribute.TITLE, "客户数量对比(项目)");
		request.getSession().setAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_PROJECT+ContSessionAttribute.CHART_SERIES_DATA, chartSeriesData);
	}
	
	/**
	 * session保存页面当前数据，用于下载
	 * @param dataList
	 */
	private void setDownloadDataInSession(List<Map<String, String>> dataList){
		request.getSession().setAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_PROJECT+ContSessionAttribute.DOWNLOAD_DATA, dataList);		
	}


	public void setCond(ReportPreCustomerProjectCond cond) {
		this.cond = cond;
	}

	public ReportPreCustomerProjectCond getCond() {
		return cond;
	}
	
	/**
	 * 下载数据
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception {			

		@SuppressWarnings("unchecked")
		List<Map<String, String>> dataList = (List<Map<String, String>>) request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_PROJECT+ContSessionAttribute.DOWNLOAD_DATA);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList); //与模板里面的循环要求对应
		
		ReportUtils.downLoadReport(map, "customer_num_compare_project.xls", "download-客户数量对比-项目-" + CustomerUtils.getNowForString() + ".xls", response);
		
		return null;
	}
	

	/**
	 * 点击查询的数据返回
	 * @return
	 * @throws Exception
	 */
	public String searchAjax() throws Exception {
		if(cond==null){
			cond = new ReportPreCustomerProjectCond();
		}
		setCondOrderSortByRequest(cond);
		getCbxIncludeEmpty();
		
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
				List<ReportPreCustomerProject> list = reportPreCustomerServices.groupByProject(cond); 

				if(cbxIncludeEmpty){
					addEmptyNumProjects(list);
				}
				
				if(!CommonUtils.isCollectionEmpty(list)){
					
					Map<String, String> map = null;
					
					//与jsp中table的表头(th field)定义一致
					for(ReportPreCustomerProject obj : list){
						
						map = new HashMap<String, String>();

						map.put("projectId", String.valueOf(obj.getProjectId()));
						map.put("projectName", obj.getProjectName());
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
					sumMap.put("projectName", "合计");
					sumMap.put("sumCount", String.valueOf(sumCount));
					retList.add(sumMap);
					
				}
				return retList;
			}
		});
		return null;
	}
	
	/**
	 * 把没有录入的项目，加载到列表的最后
	 * @param list
	 */
	private void addEmptyNumProjects(List<ReportPreCustomerProject> list){
		//把没有数据的项目,也列出来，数据补填为0		
		//HashMap性能提升，用于提升遍历性能,设置对象的主从关系
		HashMap<Integer,ReportPreCustomerProject> hmList = new HashMap<Integer,ReportPreCustomerProject>();
		for(int i=0; i<list.size(); i++){
			hmList.put(list.get(i).getProjectId(), list.get(i));
		}
		//
		for(int i=0;i<cond.getSearchCompanyProjectIds().size();i++){
			if(!hmList.containsKey(cond.getSearchCompanyProjectIds().get(i))){
				int pId = cond.getSearchCompanyProjectIds().get(i);
				ReportPreCustomerProject newLine = new ReportPreCustomerProject();
				newLine.setProjectId(pId);
				newLine.setProjectName(DescUtils.getCompanyProjectRealName(pId));
				newLine.setSumCount(0);
				
				list.add(newLine);
			}
		}		
	}

}
