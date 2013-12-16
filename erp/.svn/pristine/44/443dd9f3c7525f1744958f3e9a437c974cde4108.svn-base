package com.ihk.saleunit.action.new_report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.customer.collection.XLSExport;
import com.ihk.customer.data.pojo.CustomerFollowCond;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.pojo.PropertyUnitReportCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXBySalesman;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXBySalesmanCond;
import com.ihk.report.data.services.IReportUnitSaleServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 销售分析 报表(销售)
 * */
public class SaleReportSaleAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired
	IReportUnitSaleServices reportUnitSaleServices;
	
	private ReportPojoXSFXBySalesmanCond cond;
	private String selType;//下拉框的类型	
	
	public String getSelType() {
		return selType;
	}


	public void setSelType(String selType) {
		this.selType = selType;
	}


	public String index() {
		return "success";
	}


	/**
	 * 点击查询的数据返回
	 * @return
	 * @throws Exception
	 */
	public String searchAjax() throws Exception {
		if(cond==null){
			cond = new ReportPojoXSFXBySalesmanCond();
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
				
				List<ReportPojoXSFXBySalesman> list ;
				if(selType.equalsIgnoreCase("contract")){
					list = reportUnitSaleServices.findXSFXBySalesman_Contract(cond);					
				}
				else if(selType.equalsIgnoreCase("confirm")){
					list = reportUnitSaleServices.findXSFXBySalesman_Confirm(cond);					
				}
				else{
					list = reportUnitSaleServices.findXSFXBySalesman_ConfirmBook(cond);
				}
				
				if(!CommonUtils.isCollectionEmpty(list)){
					
					Map<String, String> map = null;
					
					//与jsp中table的表头(th field)定义一致
					for(ReportPojoXSFXBySalesman obj : list){
						
						map = new HashMap<String, String>();

						map.put("salesId", String.valueOf(obj.getSalesId()));
						map.put("salesName", obj.getSalesName());
						map.put("projectId", String.valueOf(obj.getProjectId()));
						map.put("projectName", obj.getProjectName());
						map.put("sumAmount", String.valueOf(obj.getSumAmount()));
						map.put("sumArea",  String.valueOf(obj.getSumArea()));
						map.put("sumMoney", String.valueOf(obj.getSumMoney()));
						
						retList.add(map);
					}
					
					// 添加合计
					BigDecimal sumAmount = BigDecimal.valueOf(0);
					BigDecimal sumArea = BigDecimal.valueOf(0); 
					BigDecimal sumMoney = BigDecimal.valueOf(0);
					for (Map<String, String> line : retList) {
						sumAmount = sumAmount.add(new BigDecimal(line.get("sumAmount").toString()));
						sumArea = sumArea.add(new BigDecimal(line.get("sumArea").toString()));
						sumMoney = sumMoney.add(new BigDecimal(line.get("sumMoney").toString()));
					}

					Map<String, String> sumMap = new HashMap<String, String>();
					sumMap.put("salesId", "合计");
					sumMap.put("salesName", "合计");
					sumMap.put("projectId", "合计");
					sumMap.put("projectName", "合计");
					sumMap.put("sumAmount", sumAmount.toString());
					sumMap.put("sumArea", sumArea.toString());
					sumMap.put("sumMoney", sumMoney.toString());
					retList.add(sumMap);					
				}
				
				//数据格式化处理
				for (Map<String, String> line : retList) {
					line.put("sumAmount", ReportUtils.formatNumber(line.get("sumAmount"),0));
					line.put("sumArea", ReportUtils.formatNumber(line.get("sumArea"),0));
					line.put("sumMoney", ReportUtils.formatNumber(line.get("sumMoney"),0));
				}

				setDownloadDataInSession(retList);
				
				return retList;
			}
		});
		return null;
	}

	/**
	 * session保存页面当前数据，用于下载
	 * @param dataList
	 */
	private void setDownloadDataInSession(List<Map<String, String>> dataList){
		request.getSession().setAttribute(ContSessionAttribute.XSFX_XS+ContSessionAttribute.DOWNLOAD_DATA, dataList);		
	}
		
	public ReportPojoXSFXBySalesmanCond getCond() {
		return cond;
	}


	public void setCond(ReportPojoXSFXBySalesmanCond cond) {
		this.cond = cond;
	}


	/**
	 * 下载数据
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception {			

		@SuppressWarnings("unchecked")
		List<Map<String, String>> dataList = (List<Map<String, String>>) request.getSession().getAttribute(ContSessionAttribute.XSFX_XS+ContSessionAttribute.DOWNLOAD_DATA);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList); //与模板里面的循环要求对应
		
		ReportUtils.downLoadReport(map, "xsfx-xs.xls", "download-销售分析(销售)-" + CustomerUtils.getNowForString() + ".xls", response);
		
		return null;
	}
	

	
}



















