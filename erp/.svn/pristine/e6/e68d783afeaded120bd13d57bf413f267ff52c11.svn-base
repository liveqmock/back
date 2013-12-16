package com.ihk.user.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.ContractCustConfirm;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.RolePriv;
import com.ihk.user.data.pojo.RolePrivCond;
import com.ihk.user.data.services.IRolePrivServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.GuangZhouUtils;
import com.ihk.utils.SupperAction;

public class RoleprivAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	private List<Role> roleList;
	private RolePrivCond rolePrivCond;
	@Autowired	IRolePrivServices rolePrivServices;
	private String selRoleId;

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}	
	
	public String getSelRoleId() {
		return selRoleId;
	}

	public void setSelRoleId(String selRoleId) {
		this.selRoleId = selRoleId;
	}

	/**
	 * 查询角色列表
	 * @return
	 */
	public String searchRolepriv() {
		this.roleList = GuangZhouUtils.getGuangZhouRole();
		rolePrivCond = new RolePrivCond();
		return "success";
	}

	/**
	 * 具体的查询action
	 * @return
	 */
	public String searchRoleprivAjax() {
		rolePrivCond = new RolePrivCond();
		if(request.getParameter("selRoleId")!=null){
			selRoleId = request.getParameter("selRoleId").toString();
		}
		if(selRoleId!=null && !selRoleId.isEmpty() && !selRoleId.equalsIgnoreCase("0")){
			List<Integer> listSelRole = new ArrayList<Integer>();
			listSelRole.add(Integer.parseInt(selRoleId));
			rolePrivCond.setRoleIds(listSelRole);
		}
		
		ActionTemplate.executeAjaxPage(this, rolePrivCond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				//不分页的做法
				rolePrivCond.pageSize = 0;
				return 0;
			}
			
			//获取table中要显示的json
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
				
				List<RolePriv> list = rolePrivServices.findRolePrivPage(rolePrivCond); 
				
				if(!CommonUtils.isCollectionEmpty(list)){
					
					Map<String, String> map = null;
					
					//与jsp中table的表头(th field)定义一致
					for(RolePriv obj : list){
						
						map = new HashMap<String, String>();
						
						map.put("descRoleId", obj.getDescRoleId());
						map.put("descPrivId", obj.getDescPrivId());
						
						map.put("createdTime", DateTimeUtils.toStr(obj.getCreatedTime()));
												
						retList.add(map);
					}
					
				}
				return retList;
			}
		});
		return null;
	}
}
