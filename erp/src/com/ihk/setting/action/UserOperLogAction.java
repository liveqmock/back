package com.ihk.setting.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumOperLogType;
import com.ihk.setting.data.pojo.OperLogCond;
import com.ihk.setting.data.services.IOperLogServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 * 用户操作日志
 *
 */
public class UserOperLogAction extends SupperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired IOperLogServices iOperLogServices;
	
	private OperLogCond operCond;

	private String realName;
	private List<Map> tableList;
	
	public String index(){
		operCond = new OperLogCond();
		operCond.setDevFlag("customer_guangzhou");
		operCond.setDate1(CommonUtils.getOneWeekBeforeForString());
		return "suc";
	}
	
	
	/**根据账号 时间跨度 查出有多少条记录*/
	public String search(){
		if(operCond == null){
			operCond = new OperLogCond();
			
		}
		operCond.setDevFlag("customer_guangzhou");
		init();
		return "suc";
	}
	
	private void init(){
//		if(operCond.getSearchName() == null || operCond.getSearchName().trim().equals("")){
//			addActionMessage("请输入账号");
//			return;
//		}
//		UserAccount us = DescUtils.getUserAccountByUserName(operCond.getSearchName());
//		if(us == null){
//			if(!(operCond.getSearchName() == null || operCond.getSearchName().trim().equals(""))){
//				addActionMessage("错误的账号");
//				return ;
//			}
//			realName = "";
			
//		}else{
//			realName = us.getRealName();
//			if(us.getId() != 0 ){
//				operCond.setUserId(us.getId()+"");
//			}
//		}
		operCond.pageSize = 50;
		
		tableList = new ArrayList<Map>();
		List<Map> temp;
		temp = iOperLogServices.findByUserIdAndLogCount(operCond);
		//logCount = iOperLogServices.findOperLogCount(operCond)+"";
		Map<String, String> listmap = new HashMap<String, String>();
		String tip = "";
		if(temp != null){
			for(Map p :temp){
				if( !((p.get("userId").toString()+p.get("projectId").toString()).equals(listmap.get("userId")+listmap.get("projectId")))  ){
					listmap = new HashMap<String, String>();
					tip = "add";
				}
				listmap.put("userId", p.get("userId").toString());
				listmap.put("realName", DescUtils.getUserRealName(Integer.parseInt(listmap.get("userId"))));
				
				listmap.put("userName", DescUtils.getUserAccountById(Integer.parseInt(listmap.get("userId"))).getUserName());
				listmap.put("projectId", p.get("projectId").toString());
				listmap.put("projectName", DescUtils.getCompanyProjectRealName(Integer.parseInt(listmap.get("projectId"))));
				
				if(p.get("logType").equals(EnumOperLogType.LOGIN.toString())){
					listmap.put("countSuc", p.get("count").toString());
				}else{
					listmap.put("countErr", p.get("count").toString());
				}
				
				if(tip.equals("add")){
					this.tableList.add(listmap);
					tip="";
				}
				
				
			}
		}
	}


	public OperLogCond getOperCond() {
		return operCond;
	}


	public void setOperCond(OperLogCond operCond) {
		this.operCond = operCond;
	}




	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public List<Map> getTableList() {
		return tableList;
	}


	public void setTableList(List<Map> tableList) {
		this.tableList = tableList;
	}


	
	
	
	
}
