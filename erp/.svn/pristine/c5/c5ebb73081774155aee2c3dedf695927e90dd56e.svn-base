package com.ihk.customer.collection.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.collection.IVipCustFollowMapper;
import com.ihk.customer.collection.IVipCustomerMapper;
import com.ihk.customer.collection.pojo.VipCustFollow;
import com.ihk.customer.collection.pojo.VipCustFollowCond;
import com.ihk.customer.collection.pojo.VipCustomer;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

public class FollowVipCustomerAction extends SupperAction{

	@Autowired
	IVipCustFollowMapper iVipCustFollowMapper;
	@Autowired
	IVipCustomerMapper iVipCustomerMapper;
	VipCustFollow vipfollow;
	private JSONObject result;
	
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
	public VipCustFollow getVipfollow() {
		return vipfollow;
	}

	public void setVipfollow(VipCustFollow vipfollow) {
		this.vipfollow = vipfollow;
	}

	//初始化
	public String followVipCust() throws Exception {
		this.inifollowtype();
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			VipCustFollowCond cond = new VipCustFollowCond();
			cond.setRefId(id);
			request.getSession().setAttribute("cond", cond);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		if(vipfollow == null)
			vipfollow = new VipCustFollow();
		ActionContext.getContext().getValueStack().set("vipfollow",vipfollow);
		return SUCCESS;
	}
	
	//初始化跟进列
	public String IniFollowList() throws Exception {
		
		try{
			JSONArray jsonArray = new JSONArray();
	        JSONObject jsonobj = new JSONObject();
	        VipCustFollowCond custCond = (VipCustFollowCond) request.getSession().getAttribute("cond");
	        int recordCount = iVipCustFollowMapper.findVipCustFollowCount(custCond);
	        List<VipCustFollow> list = iVipCustFollowMapper.findVipCustFollow(custCond);
	        for (VipCustFollow con : list) {
	        	  jsonobj.put("id", con.getId());
	              jsonobj.put("followStr", con.getFollowTypeStr());
	              jsonobj.put("user", con.getDescUser());
	              jsonobj.put("followDate", con.getCreateDateStr());
	              jsonobj.put("content", con.getContent());
	              jsonArray.add(jsonobj);
	              Map<String, Object> json = new HashMap<String, Object>();
	  			  json.put("total", recordCount);// total键 存放总记录数，必须的
	  			  json.put("rows", jsonArray);// rows键 存放每页记录 list
	  			  result = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
	        }
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	//添加跟进
	public String addFollowCust() throws Exception {
		try{
			
			UserAccount user = SessionUser.getSessionUser();
			if(vipfollow == null)
					vipfollow = new VipCustFollow();
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date date = df.parse(request.getParameter("dt"));
			vipfollow.setFollowDate(date);
			
			VipCustFollowCond custCond = (VipCustFollowCond) request.getSession().getAttribute("cond");
			vipfollow.setRefId(custCond.getRefId());
			vipfollow.setRegUserId(user.getId());
			vipfollow.setIsDeleted("0");
			iVipCustFollowMapper.addVipCustFollow(vipfollow);
			
			//更新vipcustomer表的跟进日期 与最后一次跟进日期相同
			VipCustomer customer = iVipCustomerMapper.findVipCustomerById(custCond.getRefId());
			customer.setFollowDate(new Date());
			iVipCustomerMapper.updateVipCustomer(customer);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public void inifollowtype(){
		followType = DescUtils.getInitSelForGuangZhou(followType, EnumCodeTypeName.FOLLOW_TYPE, true);
	}
	
	private LinkedHashMap<?, ?> followType; //跟进类型

	public LinkedHashMap<?, ?> getFollowType() {
		return followType;
	}

}
