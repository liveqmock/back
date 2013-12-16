package com.ihk.customer.collection.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.collection.IVipCustomerMapper;
import com.ihk.customer.collection.pojo.VipCustImp;
import com.ihk.customer.collection.pojo.VipCustImpCond;
import com.ihk.customer.collection.pojo.VipCustomer;
import com.ihk.customer.collection.pojo.VipCustomerCond;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

public class QueryVipCustomerAction extends SupperAction{

	@Autowired
	IVipCustomerMapper iVipCustomerMapper;
	private JSONObject custs;
	//当前页
	private int page;
	//每页的记录数
	private int rows;
	//排序字段
	private String sort;
	//排序方式 (asc|desc)
	private String order;
	public JSONObject getCusts() {
		return custs;
	}

	public void setCusts(JSONObject custs) {
		this.custs = custs;
	}

	public VipCustomerCond getSearchCond() {
		return searchCond;
	}

	public void setSearchCond(VipCustomerCond searchCond) {
		this.searchCond = searchCond;
	}

	/**
	 * 查询vip客户入口
	 * @return
	 * @throws Exception
	 */
	public String querycust() throws Exception {
		try{
	        JSONArray jsonArray = new JSONArray();
	        JSONObject jsonobj = new JSONObject();
	        //页面传过来的条件为空
	        if(searchCond == null)
	        	searchCond = new VipCustomerCond();
			searchCond.setCustomerName(request.getParameter("customerName"));
			searchCond.setContactAddr(request.getParameter("contactaddr"));
			searchCond.setWorkArea(request.getParameter("workarea"));
			searchCond.setPhone(request.getParameter("phone"));
			searchCond.setSource(request.getParameter("source"));
			searchCond.setAdArea(request.getParameter("adArea"));
			searchCond.setNotFollowDay(request.getParameter("notFollowDay"));
			searchCond.setPaymethod(request.getParameter("paymethod"));
			searchCond.setNatives(request.getParameter("natives"));
			searchCond.setBusinesscircle(request.getParameter("businesscircle"));
			searchCond.setDate1(request.getParameter("dt1"));
			searchCond.setDate2(request.getParameter("dt2"));
			searchCond.setFollow1(request.getParameter("fd1"));
			searchCond.setFollow2(request.getParameter("fd2"));
			
	        rows = Integer.parseInt((request.getParameter("rows") == null) ? "13" : request.getParameter("rows"));
			page = Integer.parseInt((request.getParameter("page") == null) ? "1" : request.getParameter("page"));
			
			sort = request.getParameter("sort");
			order = request.getParameter("order");
			searchCond.setSort(sort);
			searchCond.setOrder(order);
			searchCond.pageSize = rows;
			searchCond.startLine = (page - 1) * rows;

            searchCond.setCompanyId(SessionUser.getCompanyId());
			int recordCount = iVipCustomerMapper.findVipCustomerCount(searchCond);
			List<VipCustomer> vipCustomer = iVipCustomerMapper.findVipCustomerPage(searchCond);
			for (VipCustomer con : vipCustomer) {
	            jsonobj.put("id", con.getId());
	            jsonobj.put("contactAddr", con.getContactAddr());
	            jsonobj.put("customerNo", con.getCustomerNo());
	            jsonobj.put("customer_name", con.getCustomerName());
	            jsonobj.put("customerNo", con.getCustomerNo());
	            jsonobj.put("source", con.getSource());
	            jsonobj.put("customerName", con.getCustomerName());
	            jsonobj.put("idcard_no", con.getIdcardNo());
	            jsonobj.put("tel", con.getTel());
	            jsonobj.put("phone", con.getPhone());
	            jsonobj.put("resideArea", con.getResideArea());
	            jsonobj.put("wordArea", con.getWorkArea());
	            jsonobj.put("natives", con.getNatives());
	            jsonobj.put("dealDate", con.getDeal_date());
	            jsonobj.put("create_time", CommonUtils.getDateString(con.getCreateTime()));
	            jsonobj.put("follow_date", CommonUtils.getDateString(con.getFollowDate()));
	            jsonArray.add(jsonobj);
			}
			Map<String, Object> json = new HashMap<String, Object>();
			json.put("total", recordCount);// total键 存放总记录数，必须的
			json.put("rows", jsonArray);// rows键 存放每页记录 list
			custs = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
			ActionContext.getContext().getValueStack().set("custs",custs);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	private VipCustomerCond searchCond;
	
	public String editVipCustomer() throws Exception{
		
		return SUCCESS;
	}
	
}
