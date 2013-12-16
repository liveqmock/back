package com.ihk.saleunit.action.check_fee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONArray;

import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;

/**
 * 有关对数的修改action
 * @author dtc
 * 2013-5-29,上午11:31:14
 */
public class CheckFeeModAction extends SupperAction{

	private static final long serialVersionUID = -6128290891687303105L;
	
	@Autowired
    IConfirmServices confirmServices;
	
	public String myGetCheckFeeDateList() throws Exception{
    	
        JSONArray jsonArray = new JSONArray();

        confirmCond = new ConfirmCond();
        confirmCond.setPropertyId(request.getParameter("propertyId"));
        
        List<Map<String, Object>> checkFeeDateList = confirmServices.checkFeeDateList(confirmCond);
        
        for (int i = 0; i < checkFeeDateList.size(); i++) {
        	
            Map<String, Object> mapobject = checkFeeDateList.get(i);

            String  checkfee_date = mapobject.get("checkfee_date")==null?"":mapobject.get("checkfee_date").toString();
            
            if(!CommonUtils.isStrEmpty(checkfee_date)){
            	
                Map<String, Object> json = new HashMap<String, Object>();
                json.put("checkFeeDate", CommonUtils.getDateString(CommonUtils.getDateFromString(checkfee_date)));
                
                jsonArray.add(json);
            }

        }
        
        CustomerUtils.writeResponse(response, jsonArray.toString());
        
        return null;
    }
	
	////
	private ConfirmCond confirmCond;
	
	public void setConfirmCond(ConfirmCond confirmCond) {
		this.confirmCond = confirmCond;
	}
	
	public ConfirmCond getConfirmCond() {
		return confirmCond;
	}

}
