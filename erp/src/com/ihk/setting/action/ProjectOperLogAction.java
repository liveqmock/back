package com.ihk.setting.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUserId;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumOperLogType;
import com.ihk.permission.PermissionUtils;
import com.ihk.setting.data.pojo.OperLogCond;
import com.ihk.setting.data.services.IOperLogServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 项目操作日志
 * @author peter.kuang
 *
 */
public class ProjectOperLogAction extends SupperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired IOperLogServices iOperLogServices;
	private List<Map> tableList;
	private OperLogCond operCond;
	
	public String index(){
		operCond= new OperLogCond();
		operCond.setDevFlag("customer_guangzhou");
		operCond.setDate1(CommonUtils.getOneWeekBeforeForString());
		return "suc";
	}
	
	public String search(){
		init();
		return "suc";
	}
	
	private void init() {

		operCond.pageSize = 50;
		operCond.setDevFlag("customer_guangzhou");
		tableList = new ArrayList<Map>();
		List<Map> temp;
		if (operCond.getProjectId().equals("0"))
			operCond.setProjectId("");
		temp = iOperLogServices.findByProjectId(operCond);
		// logCount = iOperLogServices.findOperLogCount(operCond)+"";
		Map<String, String> listmap = new HashMap<String, String>();
		List<Integer> projectIds =  PermissionUtils.findProjectIdByRoleIdAndUserId(SessionUser.getUserId(),14);
		
		String tip = "";
		if (temp != null) {
			for (Map p : temp) {
				if (projectIds.contains(p.get("projectId"))||SessionUser.getUserId()==ContUserId.ADMIN) {
					if (!(p.get("projectId").toString().equals(listmap
							.get("projectId")))) {
						listmap = new HashMap<String, String>();
						tip = "add";
					}
					listmap.put("projectId", p.get("projectId").toString());
					listmap.put("projectName", DescUtils
							.getCompanyProjectRealName(Integer.parseInt(listmap
									.get("projectId"))));

					if (p.get("logType").equals(
							EnumOperLogType.LOGIN.toString())) {
						listmap.put("countSuc", p.get("count").toString());
					} else {
						listmap.put("countErr", p.get("count").toString());
					}

					if (tip.equals("add")) {
						this.tableList.add(listmap);
						tip = "";
					}

				}
			}
		}
	}

	public List<Map> getTableList() {
		return tableList;
	}

	public void setTableList(List<Map> tableList) {
		this.tableList = tableList;
	}

	public OperLogCond getOperCond() {
		return operCond;
	}

	public void setOperCond(OperLogCond operCond) {
		this.operCond = operCond;
	}
	
	
	
}
