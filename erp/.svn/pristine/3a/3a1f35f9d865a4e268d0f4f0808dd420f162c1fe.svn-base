package com.ihk.saleunit.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.SaleDaily;
import com.ihk.saleunit.data.services.ISaleDailyServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 *  修改action
 */
public class GuangZhouLogUpdateAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ISaleDailyServices saleDailyServices;
	
	public String getById() throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		saleDaily = saleDailyServices.findSaleDailyById(id);
		
		return "getById";
	}
	
	public String updateSaleDaily() throws Exception{
		
		int id = saleDaily.getId();

		SaleDaily odlSaleDaily = saleDailyServices.findSaleDailyById(id);
		CommonPojoUtils.initPojoForUpdate(odlSaleDaily,saleDaily);
		//SaleDailyUtils.initOtherForUpdate(oldSaleDaily, saleDaily);
		
		try{
			
			saleDailyServices.updateSaleDaily(saleDaily);
			setSuggestion(CommonUtils.SUCCSUGG);
			
		}catch(Exception e){
			e.printStackTrace();
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		saleDaily = saleDailyServices.findSaleDailyById(id);
		
		return "updateSaleDaily";
	}
	
	
	////////////
	
	private SaleDaily saleDaily;
	
	public void setSaleDaily(SaleDaily saleDaily) {
		this.saleDaily = saleDaily;
	}
	
	public SaleDaily getSaleDaily() {
		return saleDaily;
	}
	

}
