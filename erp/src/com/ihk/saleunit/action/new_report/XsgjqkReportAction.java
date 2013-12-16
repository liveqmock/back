package com.ihk.saleunit.action.new_report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.customer.data.pojo.CustomerFollowCond;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.utils.ActionAjaxPageByFooterCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;

/**
 * 销售跟进情况报表
 * @author peter
 *
 */
public class XsgjqkReportAction extends SupperAction {

	@Autowired
	ICustomerFollowServices customerFollowServices;
	private CustomerFollowCond cond;

	public String index() throws Exception {
		return "success";
	}



	public void setCond(CustomerFollowCond cond) {
		this.cond = cond;
	}

	public CustomerFollowCond getCond() {
		return cond;
	}
	
	

	/**
	 * 设置于session中的数据
	 * @param dataList
	 */
	private void setChartSeriesDataInSession(List<Map<String, Object>> dataList) {
		String chartSeriesData_Phone;
		String chartSeriesData_Visit;
		//追加
		String chartSeriesData_Purchased;
		String chartSeriesData_Phone2visit;
		String chartSeriesData_IdentificationChips;
		String chartSeriesData_Initiation;
		String chartSeriesData_HomeExhibitionsWill;
		String chartSeriesData_ExternalExhibition;
		String chartSeriesData_Leaflet;
		if (dataList == null || dataList.size() == 0) {
			chartSeriesData_Phone = "['无数据',1]";
			chartSeriesData_Visit = "['无数据',1]";
			chartSeriesData_Purchased = "['无数据',1]";
			chartSeriesData_Phone2visit = "['无数据',1]";
			chartSeriesData_IdentificationChips = "['无数据',1]";
			chartSeriesData_Initiation = "['无数据',1]";
			chartSeriesData_Initiation = "['无数据',1]";
			chartSeriesData_ExternalExhibition = "['无数据',1]";
			chartSeriesData_Leaflet = "['无数据',1]";
			return;
		}
		String str_Phone = "";
		String str_Visit = "";
		String str_Purchased = "";
		String str_Phone2visit = "";
		String str_IdentificationChips = "";
		String str_Initiation = "";
		String str_HomeExhibitionsWill = "";
		String str_ExternalExhibition = "";
		String str_Leaflet = "";
		for (Map<String,Object> p : dataList) {
			str_Phone += "['" + p.get("realName") + "'," + p.get("phoneCount") + "]"
					+ ",";

			str_Visit += "['" + p.get("realName") + "'," + p.get("visitCount") + "]"
					+ ",";
			str_Purchased += "['" + p.get("realName") + "'," + p.get("purchasedCount") + "]"
					+ ",";
			str_Phone2visit += "['" + p.get("realName") + "'," + p.get("phone2visitCount") + "]"
					+ ",";
			str_IdentificationChips += "['" + p.get("realName") + "'," + p.get("identificationChipsCount") + "]"
					+ ",";
			str_Initiation += "['" + p.get("realName") + "'," + p.get("initiationCount") + "]"
					+ ",";
			str_HomeExhibitionsWill += "['" + p.get("realName") + "'," + p.get("homeExhibitionsWillCount") + "]"
					+ ",";
			str_ExternalExhibition += "['" + p.get("realName") + "'," + p.get("externalExhibitionCount") + "]"
					+ ",";
			str_Leaflet += "['" + p.get("realName") + "'," + p.get("leafletCount") + "]"
					+ ",";
		}
		chartSeriesData_Phone = str_Phone.substring(0,str_Phone.length()-1);
		chartSeriesData_Visit = str_Visit.substring(0,str_Visit.length()-1);
		chartSeriesData_Purchased = str_Purchased.substring(0,str_Purchased.length()-1);
		chartSeriesData_Phone2visit =  str_Phone2visit.substring(0,str_Phone2visit.length()-1);
		chartSeriesData_IdentificationChips =  str_IdentificationChips.substring(0,str_IdentificationChips.length()-1);
		chartSeriesData_Initiation =  str_Initiation.substring(0,str_Initiation.length()-1);
		chartSeriesData_HomeExhibitionsWill =  str_HomeExhibitionsWill.substring(0,str_HomeExhibitionsWill.length()-1);
		chartSeriesData_ExternalExhibition =  str_ExternalExhibition.substring(0,str_ExternalExhibition.length()-1);
		chartSeriesData_Leaflet =  str_Leaflet.substring(0,str_Leaflet.length()-1);
		
		
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_PHONE+ContSessionAttribute.TITLE, "客户跟进情况(销售)-电话跟进");
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_PHONE+ContSessionAttribute.CHART_SERIES_DATA, chartSeriesData_Phone);

		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_VISIT+ContSessionAttribute.TITLE, "客户跟进情况(销售)-再次到访");
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_VISIT+ContSessionAttribute.CHART_SERIES_DATA, chartSeriesData_Visit);
		
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_PURCHASED+ContSessionAttribute.TITLE, "客户跟进情况(销售)-已购买");
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_PURCHASED+ContSessionAttribute.CHART_SERIES_DATA, chartSeriesData_Purchased);
		
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_PHONE2VISIT+ContSessionAttribute.TITLE, "客户跟进情况(销售)-电转访");
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_PHONE2VISIT+ContSessionAttribute.CHART_SERIES_DATA, chartSeriesData_Phone2visit);
		
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_IDENTIFICATIONCHIPS+ContSessionAttribute.TITLE, "客户跟进情况(销售)-认筹");
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_IDENTIFICATIONCHIPS+ContSessionAttribute.CHART_SERIES_DATA, chartSeriesData_IdentificationChips);
		
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_INITIATION+ContSessionAttribute.TITLE, "客户跟进情况(销售)-入会");
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_INITIATION+ContSessionAttribute.CHART_SERIES_DATA, chartSeriesData_Initiation);
		
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_HOMEEXHIBITIONSWILL+ContSessionAttribute.TITLE, "客户跟进情况(销售)-房展会");
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_HOMEEXHIBITIONSWILL+ContSessionAttribute.CHART_SERIES_DATA, chartSeriesData_HomeExhibitionsWill);
	
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_EXTERNALEXHIBITION+ContSessionAttribute.TITLE, "客户跟进情况(销售)-外展场");
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_EXTERNALEXHIBITION+ContSessionAttribute.CHART_SERIES_DATA, chartSeriesData_ExternalExhibition);

		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_LEAFLET+ContSessionAttribute.TITLE, "客户跟进情况(销售)-派单");
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_LEAFLET+ContSessionAttribute.CHART_SERIES_DATA, chartSeriesData_Leaflet);

	}
	
	/**
	 * session保存页面当前数据，用于下载
	 * @param dataList
	 */
	private void setDownloadDataInSession(List<Map<String, Object>> dataList){
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK+ContSessionAttribute.DOWNLOAD_DATA, dataList);		
	}

	/**
	 * 下载数据
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception {			

		@SuppressWarnings("unchecked")
		List<Map<String, String>> dataList = (List<Map<String, String>>) request.getSession().getAttribute(ContSessionAttribute.XSGJQK+ContSessionAttribute.DOWNLOAD_DATA);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList); //与模板里面的循环要求对应
		
		ReportUtils.downLoadReport(map, "customer-follow-sales.xls", "download-客户跟进情况-销售-" + CustomerUtils.getNowForString() + "-.xls", response);
		
		return null;
	}

	/**
	 * 点击查询的数据返回
	 * @return
	 * @throws Exception
	 */
	public String xsgjqkReportAjax() throws Exception {
		if(cond==null){
			cond = new CustomerFollowCond();
		}
//		setCondOrderSortByRequest(cond);
		
		
		ActionTemplate.executeAjaxPage(this, cond, new ActionAjaxPageByFooterCallback() {
			List<Map<String, Object>> retList = new ArrayList<Map<String,Object>>();
			@Override
			public int initTotal() throws Exception {
				//不分页的做法
				cond.pageSize = 0;
				return 0;
			}
			
			@Override
			public List<Map<String, Object>> initRows() throws Exception {
				// TODO Auto-generated method stub

				
				

				List<Map> list = customerFollowServices.findReportSumGroupByUser(cond); 
				
				if(!CommonUtils.isCollectionEmpty(list)){
					
					Map<String, Object> map = null;
					
					//与jsp中table的表头(th field)定义一致
					for(Map obj : list){
						
						map = new HashMap<String, Object>();

						map.put("projectName", obj.get("projectName").toString());
						map.put("userId", obj.get("userId").toString());
						map.put("realName", obj.get("realName").toString());
						map.put("phoneCount", obj.get("phoneCount").toString());
						map.put("visitCount", obj.get("visitCount").toString());
						map.put("purchasedCount", obj.get("purchasedCount").toString());
						map.put("phone2visitCount", obj.get("phone2visitCount").toString());
						map.put("identificationChipsCount", obj.get("identificationChipsCount").toString());
						map.put("initiationCount", obj.get("initiationCount").toString());
						map.put("homeExhibitionsWillCount", obj.get("homeExhibitionsWillCount").toString());
						map.put("externalExhibitionCount", obj.get("externalExhibitionCount").toString());
						map.put("leafletCount", obj.get("leafletCount").toString());
						retList.add(map);
					}
				}
					setChartSeriesDataInSession(retList);
					setDownloadDataInSession(retList);
				return retList;
			}
			
			@Override
			public JSONArray initFootor(List<Map<String, Object>> rows)
					throws Exception {
				// 添加合计
				int sumPhoneCount = 0;
				int sumVisitCount = 0;
				//追加
				int sumPurchasedCount = 0;
				int sumPhone2visitCount = 0;
				int sumIdentificationChipsCount = 0; 
				int sumInitiationCount = 0;
				int sumHomeExhibitionsWillCount = 0;
				int sumExternalExhibitionCount = 0; 
				int sumLeafletCount = 0;
				
				for (Map<String,Object> line : retList) {
					sumPhoneCount += Integer.parseInt((line.get("phoneCount").toString()));
					sumVisitCount += Integer.parseInt((line.get("visitCount").toString()));
					sumPurchasedCount += Integer.parseInt(line.get("purchasedCount").toString());
					sumPhone2visitCount += Integer.parseInt(line.get("phone2visitCount").toString());
					sumIdentificationChipsCount += Integer.parseInt(line.get("identificationChipsCount").toString());
					sumInitiationCount += Integer.parseInt(line.get("initiationCount").toString());
					sumHomeExhibitionsWillCount += Integer.parseInt(line.get("homeExhibitionsWillCount").toString());
					sumExternalExhibitionCount += Integer.parseInt(line.get("externalExhibitionCount").toString());
					sumLeafletCount += Integer.parseInt(line.get("leafletCount").toString());
				}
				
				JSONArray retArr = new JSONArray();
				JSONObject json = new JSONObject();
				
				json.put("projectName", "");
				json.put("realName", "合计");
				json.put("phoneCount", String.valueOf(sumPhoneCount));
				json.put("visitCount", String.valueOf(sumVisitCount));
				json.put("purchasedCount",String.valueOf(sumPurchasedCount));
				json.put("phone2visitCount",String.valueOf(sumPhone2visitCount));
				json.put("identificationChipsCount",String.valueOf(sumIdentificationChipsCount));
				json.put("initiationCount", String.valueOf(sumInitiationCount));
				json.put("homeExhibitionsWillCount", String.valueOf(sumHomeExhibitionsWillCount));
				json.put("externalExhibitionCount", String.valueOf(sumExternalExhibitionCount));
				json.put("leafletCount", String.valueOf(sumLeafletCount));
				retArr.add(json);
				return retArr;
			}
		});
		return null;
	}

}
