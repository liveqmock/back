package com.ihk.saleunit.action.new_report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.customer.collection.XLSExport;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.pojo.PropertyUnitReportCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXByCompany;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXByCompanyCond;
import com.ihk.report.data.services.IReportUnitSaleServices;
import com.ihk.saleunit.action.new_report.utils.SaleReportUtils;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IReportDefineColumnServices;
import com.ihk.saleunit.data.services.IReportDefineTypeServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;

/**
 * 销售分析 报表
 * */
public class SaleReporCompanytAction extends SupperAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	IReportUnitSaleServices reportUnitSaleServices;

	private ReportPojoXSFXByCompanyCond cond;
	private String selType;//下拉框的类型	
	
	public String getSelType() {
		return selType;
	}


	public void setSelType(String selType) {
		this.selType = selType;
	}

	/** 直接点进来*/
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
			cond = new ReportPojoXSFXByCompanyCond();
		}
		setCondOrderSortByRequest(cond);
		
		if(cond.getSearchCompanyIds().size()<=0){
			cond.setSearchCompanyIds(PermissionUtils.getUserCompanyIdList());
		}
		
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
				
				List<ReportPojoXSFXByCompany> list ;
				if(selType.equalsIgnoreCase("contract")){
					list = reportUnitSaleServices.findXSFXByCompany_Contract(cond);					
				}
				else if(selType.equalsIgnoreCase("confirm")){
					list = reportUnitSaleServices.findXSFXByCompany_Confirm(cond);
				}
				else{
					list = reportUnitSaleServices.findXSFXByCompany_ConfirmBook(cond);
				}
				
				if(!CommonUtils.isCollectionEmpty(list)){
					
					Map<String, String> map = null;
					
					//与jsp中table的表头(th field)定义一致
					for(ReportPojoXSFXByCompany obj : list){
						
						map = new HashMap<String, String>();

						map.put("companyId", obj.getCompanyId());
						map.put("companyName", obj.getCompanyName());
						map.put("sumAmount", String.valueOf(obj.getSumAmount()));
						map.put("sumArea",  String.valueOf(obj.getSumArea()));
						map.put("sumMoney", String.valueOf(obj.getSumMoney()));
						map.put("leftAmount", String.valueOf(obj.getLeftAmount()));
						map.put("leftArea", String.valueOf(obj.getLeftArea()));
						map.put("leftMoney", String.valueOf(obj.getLeftMoney()));
						
						retList.add(map);
					}
					
					// 添加合计
					BigDecimal sumAmount = BigDecimal.valueOf(0);
					BigDecimal sumArea = BigDecimal.valueOf(0); 
					BigDecimal sumMoney = BigDecimal.valueOf(0);
					BigDecimal leftAmount = BigDecimal.valueOf(0);
					BigDecimal leftArea = BigDecimal.valueOf(0);
					BigDecimal leftMoney = BigDecimal.valueOf(0);
					for (Map<String, String> line : retList) {
						sumAmount = sumAmount.add(new BigDecimal(line.get("sumAmount").toString()));
						sumArea = sumArea.add(new BigDecimal(line.get("sumArea").toString()));
						sumMoney = sumMoney.add(new BigDecimal(line.get("sumMoney").toString()));
						leftAmount = leftAmount.add(new BigDecimal(line.get("leftAmount").toString()));
						leftArea = leftArea.add(new BigDecimal(line.get("leftArea").toString()));
						leftMoney = leftMoney.add(new BigDecimal(line.get("leftMoney").toString()));
					}

					Map<String, String> sumMap = new HashMap<String, String>();
					sumMap.put("companyId", "合计");
					sumMap.put("companyName", "合计");
					sumMap.put("sumAmount", sumAmount.toString());
					sumMap.put("sumArea", sumArea.toString());
					sumMap.put("sumMoney", sumMoney.toString());
					sumMap.put("leftAmount", leftAmount.toString());
					sumMap.put("leftArea", leftArea.toString());
					sumMap.put("leftMoney", leftMoney.toString());
					retList.add(sumMap);					
				}
				
				//数据格式化处理
				for (Map<String, String> line : retList) {
					line.put("sumAmount", ReportUtils.formatNumber(line.get("sumAmount"),0));
					line.put("sumArea", ReportUtils.formatNumber(line.get("sumArea"),0));
					line.put("sumMoney", ReportUtils.formatNumber(line.get("sumMoney"),0));
					line.put("leftAmount", ReportUtils.formatNumber(line.get("leftAmount"),0));
					line.put("leftArea", ReportUtils.formatNumber(line.get("leftArea"),0));
					line.put("leftMoney", ReportUtils.formatNumber(line.get("leftMoney"),0));
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
		request.getSession().setAttribute(ContSessionAttribute.XSFX_GS+ContSessionAttribute.DOWNLOAD_DATA, dataList);		
	}
		
	public ReportPojoXSFXByCompanyCond getCond() {
		return cond;
	}


	public void setCond(ReportPojoXSFXByCompanyCond cond) {
		this.cond = cond;
	}


	/**
	 * 下载数据
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception {			

		@SuppressWarnings("unchecked")
		List<Map<String, String>> dataList = (List<Map<String, String>>) request.getSession().getAttribute(ContSessionAttribute.XSFX_GS+ContSessionAttribute.DOWNLOAD_DATA);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList); //与模板里面的循环要求对应
		
		ReportUtils.downLoadReport(map, "xsfx-gs.xls", "download-销售分析(公司)-" + CustomerUtils.getNowForString() + ".xls", response);
		
		return null;
	}

}
