package com.ihk.saleunit.action.contract_record;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.ContractRecord;
import com.ihk.saleunit.data.pojo.ContractRecordCond;
import com.ihk.saleunit.data.services.IContractRecordDetailServices;
import com.ihk.saleunit.data.services.IContractRecordServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 合同手工变更
 */
public class ContractRecordHandChangeAction  extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired IContractRecordServices contractRecordServices;
	@Autowired IContractRecordDetailServices contractRecordDetailServices;
	private String ids;
	private List<ContractRecord> crtmpList;
	
	
	public String handChangeDialog(){
		String[] idsstr = ids.split(",");
		List<Integer> idslist  = new ArrayList<Integer>();
		
		for(String cid : idsstr){
			if(!cid.trim().equals("")){
				idslist.add(Integer.parseInt(cid));
			}
		}
		if(idslist == null || idslist.size()==0){
			crtmpList = null;
			return "suc";
		}
		crtmpList = contractRecordServices.findContractRecord(new ContractRecordCond().setIds(idslist));
		
		
		return "suc";
	}
	
	private String handRemark;//备注
	private Map<String,String> handMap;
	/**
	 * 持有人变更
	 * 
	 * */
	public String handChangeDialogForm(){
		String[] idsstr = ids.split(",");
		for(String p : idsstr){
			ContractRecord tmpCr = new  ContractRecord();
			
			tmpCr = contractRecordServices.findContractRecordById(Integer.parseInt(p));
			
			tmpCr.setHandoverUser(handMap.get("h"+p));
			
			tmpCr.setModId(SessionUser.getUserId());
			tmpCr.setModTime(new Date());
			tmpCr.setRemark(handRemark);
			contractRecordServices.updateContractRecord(tmpCr);
		}
		return "suc";
	}
	
	
	public String getHandRemark() {
		return handRemark;
	}

	public void setHandRemark(String handRemark) {
		this.handRemark = handRemark;
	}


	public String handChangeForm(){
		return "suc";
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public List<ContractRecord> getCrtmpList() {
		return crtmpList;
	}

	public void setCrtmpList(List<ContractRecord> crtmpList) {
		this.crtmpList = crtmpList;
	}

	public Map<String, String> getHandMap() {
		return handMap;
	}

	public void setHandMap(Map<String, String> handMap) {
		this.handMap = handMap;
	}
	
	
}

















