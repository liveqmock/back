package com.ihk.saleunit.action.new_report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXByUnit;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXByUnitCond;
import com.ihk.report.data.services.IReportUnitSaleServices;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;

/**
 * 销售分析 报表(销售 明细)
 * */
public class SaleReportSaleUnitAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired
	IReportUnitSaleServices reportUnitSaleServices;
	@Autowired
	IContractCustomerServices contractCustomerServices;
	
	private ReportPojoXSFXByUnitCond cond;
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
			cond = new ReportPojoXSFXByUnitCond();
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
				
				List<ReportPojoXSFXByUnit> list ;
				if(selType.equalsIgnoreCase("contract")){
					list = reportUnitSaleServices.findXSFXByUnit_Contract(cond);					
				}
				else if(selType.equalsIgnoreCase("confirm")){
					list = reportUnitSaleServices.findXSFXByUnit_Confirm(cond);					
				}
				else{
					list = reportUnitSaleServices.findXSFXByUnit_ConfirmBook(cond);
				}
				
				if(!CommonUtils.isCollectionEmpty(list)){
					
					Map<String, String> map = null;
					
					//与jsp中table的表头(th field)定义一致
					for(ReportPojoXSFXByUnit obj : list){
						
						map = new HashMap<String, String>();

						map.put("salesId", obj.getSalesId());
						map.put("salesName", obj.getSalesName());
						map.put("buildId", obj.getBuildId());
						map.put("buildName", obj.getBuildName());
						map.put("roomNo", obj.getRoomNo());
						map.put("buildArea", String.valueOf(obj.getBuildArea()));
						map.put("insideArea", String.valueOf(obj.getInsideArea()));
						map.put("sumPrice", String.valueOf(obj.getSumPrice()));
						map.put("salePrice", String.valueOf(obj.getSalePrice()));
						map.put("workDate", obj.getWorkDate());
						map.put("payWay", obj.getPayWay());
						map.put("discountPercent", obj.getDiscountPercent());
						
						String customerName="";
//						List<ContractCustomer> ccList = contractCustomerServices.findContractCustomerByMainIdAndConfirmType(obj.getMainId(), ContConfirmType.CONFIRM);
//						for(ContractCustomer cc:ccList){
//							customerName=customerName+cc.getCustomerName()+" ";
//						}
						map.put("customerName", obj.getCustomerName());
						
						retList.add(map);
					}
					
					// 添加合计
					BigDecimal buildArea = BigDecimal.valueOf(0);
					BigDecimal insideArea = BigDecimal.valueOf(0); 
					BigDecimal sumPrice = BigDecimal.valueOf(0);
					BigDecimal salePrice = BigDecimal.valueOf(0);
					for (Map<String, String> line : retList) {
						buildArea = buildArea.add(new BigDecimal(line.get("buildArea").toString()));
						insideArea = insideArea.add(new BigDecimal(line.get("insideArea").toString()));
						sumPrice = sumPrice.add(new BigDecimal(line.get("sumPrice").toString()));
						salePrice = salePrice.add(new BigDecimal(line.get("salePrice").toString()));
					}

					Map<String, String> sumMap = new HashMap<String, String>();

					sumMap.put("salesId", "");
					sumMap.put("salesName", "合计");
					sumMap.put("buildId", "");
					sumMap.put("buildName", "");
					sumMap.put("roomNo", "");
					sumMap.put("buildArea", String.valueOf(buildArea));
					sumMap.put("insideArea", String.valueOf(insideArea));
					sumMap.put("sumPrice", String.valueOf(sumPrice));
					sumMap.put("salePrice", String.valueOf(salePrice));
					sumMap.put("workDate", "");
					sumMap.put("payWay", "");
					sumMap.put("discountPercent", "");
					sumMap.put("customerName", "");
					
					retList.add(sumMap);					
				}
				
				//数据格式化处理
				for (Map<String, String> line : retList) {
					line.put("buildArea", ReportUtils.formatNumber(line.get("buildArea"),0));
					line.put("insideArea", ReportUtils.formatNumber(line.get("insideArea"),0));
					line.put("sumPrice", ReportUtils.formatNumber(line.get("sumPrice"),0));
					line.put("salePrice", ReportUtils.formatNumber(line.get("salePrice"),0));
					if(!line.get("workDate").equalsIgnoreCase("")){
						line.put("workDate", ReportUtils.formatDate(line.get("workDate")));
					}
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
		request.getSession().setAttribute(ContSessionAttribute.XSFX_XSMX+ContSessionAttribute.DOWNLOAD_DATA, dataList);		
	}
		
	public ReportPojoXSFXByUnitCond getCond() {
		return cond;
	}


	public void setCond(ReportPojoXSFXByUnitCond cond) {
		this.cond = cond;
	}


	/**
	 * 下载数据
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception {			

		@SuppressWarnings("unchecked")
		List<Map<String, String>> dataList = (List<Map<String, String>>) request.getSession().getAttribute(ContSessionAttribute.XSFX_XSMX+ContSessionAttribute.DOWNLOAD_DATA);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList); //与模板里面的循环要求对应
		
		ReportUtils.downLoadReport(map, "xsfx-xsmx.xls", "download-销售分析(销售明细)-" + CustomerUtils.getNowForString() + ".xls", response);
		
		return null;
	}
	

	
}



















