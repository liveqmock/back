package com.ihk.saleunit.action.new_report;

import java.util.ArrayList;
import java.util.List;

import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.utils.SupperAction;

public class CommonPieAction extends SupperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String chartSeriesData;
	
	private List<String> list = new ArrayList<String>();


	public String getChartSeriesData() {
		return this.chartSeriesData;
	}

	private String titleText;


	public String getTitleText() {
		return this.titleText;
	}
	private void init(){
		//客户跟进情况(公司)
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_PHONE);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_VISIT);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_PURCHASED);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_PHONE2VISIT);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_IDENTIFICATIONCHIPS);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_INITIATION);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_HOMEEXHIBITIONSWILL);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_EXTERNALEXHIBITION);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_LEAFLET);
		//客户跟进情况(项目)
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_PHONE);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_VISIT);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_PURCHASED);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_PHONE2VISIT);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_IDENTIFICATIONCHIPS);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_INITIATION);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_HOMEEXHIBITIONSWILL);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_EXTERNALEXHIBITION);
		list.add(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_LEAFLET);
		//客户跟进情况(销售)
		list.add(ContSessionAttribute.XSGJQK_PHONE);
		list.add(ContSessionAttribute.XSGJQK_VISIT);
		list.add(ContSessionAttribute.XSGJQK_PURCHASED);
		list.add(ContSessionAttribute.XSGJQK_PHONE2VISIT);
		list.add(ContSessionAttribute.XSGJQK_IDENTIFICATIONCHIPS);
		list.add(ContSessionAttribute.XSGJQK_INITIATION);
		list.add(ContSessionAttribute.XSGJQK_HOMEEXHIBITIONSWILL);
		list.add(ContSessionAttribute.XSGJQK_EXTERNALEXHIBITION);
		list.add(ContSessionAttribute.XSGJQK_LEAFLET);
		
		
		list.add(ContSessionAttribute.CUSTOMER_NUM_COMPARE_COMPANY);
		list.add(ContSessionAttribute.CUSTOMER_NUM_COMPARE_PROJECT);
		list.add(ContSessionAttribute.CUSTOMER_NUM_COMPARE_SALES);
		list.add(ContSessionAttribute.CUSTOMER_PIE);
		
	}
	
	
	/**
	 * 输出饼图
	 * @return
	 * @throws Exception
	 */
	public String commonPie() throws Exception {
		this.init();
		String flag = request.getParameter("flag");
		if(flag!=null){
			if(list.contains(flag)){
				Object titleTextObject = request.getSession().getAttribute(flag+ContSessionAttribute.TITLE);
				Object chartSeriesDataObject = request.getSession().getAttribute(flag+ContSessionAttribute.CHART_SERIES_DATA);
				if(titleTextObject!=null&&chartSeriesDataObject!=null){
					titleText = titleTextObject.toString();
					chartSeriesData = chartSeriesDataObject.toString();
				}
			}
		}
		//客户跟进情况(公司)
//		if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_PHONE)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_PHONE+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_PHONE+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_VISIT)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_VISIT+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_VISIT+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_PURCHASED)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_PURCHASED+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_PURCHASED+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_PHONE2VISIT)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_PHONE2VISIT+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_PHONE2VISIT+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_IDENTIFICATIONCHIPS)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_IDENTIFICATIONCHIPS+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_IDENTIFICATIONCHIPS+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_INITIATION)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_INITIATION+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_INITIATION+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_HOMEEXHIBITIONSWILL)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_HOMEEXHIBITIONSWILL+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_HOMEEXHIBITIONSWILL+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_EXTERNALEXHIBITION)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_EXTERNALEXHIBITION+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_EXTERNALEXHIBITION+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_LEAFLET)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_LEAFLET+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_COMPANY_LEAFLET+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
		//客户跟进情况(项目)
//		 if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_PHONE)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_PHONE+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_PHONE+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_VISIT)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_VISIT+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_VISIT+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_PURCHASED)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_PURCHASED+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_PURCHASED+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_PHONE2VISIT)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_PHONE2VISIT+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_PHONE2VISIT+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_IDENTIFICATIONCHIPS)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_IDENTIFICATIONCHIPS+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_IDENTIFICATIONCHIPS+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_INITIATION)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_INITIATION+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_INITIATION+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_HOMEEXHIBITIONSWILL)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_HOMEEXHIBITIONSWILL+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_HOMEEXHIBITIONSWILL+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_EXTERNALEXHIBITION)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_EXTERNALEXHIBITION+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_EXTERNALEXHIBITION+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_LEAFLET)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_LEAFLET+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_FOLLOW_PROJECT_LEAFLET+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
		//客户跟进情况(销售)
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.XSGJQK_PHONE)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_PHONE+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_PHONE+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.XSGJQK_VISIT)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_VISIT+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_VISIT+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.XSGJQK_PURCHASED)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_PURCHASED+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_PURCHASED+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.XSGJQK_PHONE2VISIT)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_PHONE2VISIT+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_PHONE2VISIT+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.XSGJQK_IDENTIFICATIONCHIPS)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_IDENTIFICATIONCHIPS+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_IDENTIFICATIONCHIPS+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.XSGJQK_INITIATION)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_INITIATION+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_INITIATION+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.XSGJQK_HOMEEXHIBITIONSWILL)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_HOMEEXHIBITIONSWILL+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_HOMEEXHIBITIONSWILL+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.XSGJQK_EXTERNALEXHIBITION)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_EXTERNALEXHIBITION+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_EXTERNALEXHIBITION+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.XSGJQK_LEAFLET)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_LEAFLET+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.XSGJQK_LEAFLET+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
		//客户数量对比(公司)
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_NUM_COMPARE_COMPANY)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_COMPANY+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_COMPANY+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		//客户数量对比(项目)
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_NUM_COMPARE_PROJECT)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_PROJECT+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_PROJECT+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		//客户数量对比(销售)
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_NUM_COMPARE_SALES)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_SALES+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_NUM_COMPARE_SALES+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
//		//客户分类比例(项目)
//		else if(request.getParameter("flag")!=null && request.getParameter("flag").toString().equalsIgnoreCase(ContSessionAttribute.CUSTOMER_PIE)){
//			titleText = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_PIE+ContSessionAttribute.TITLE).toString();
//			chartSeriesData = request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_PIE+ContSessionAttribute.CHART_SERIES_DATA).toString();
//		}
		return "success";
	}

}
