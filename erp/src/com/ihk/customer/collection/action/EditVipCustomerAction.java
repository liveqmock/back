package com.ihk.customer.collection.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihk.customer.collection.IVipCustImpMapper;
import com.ihk.customer.collection.pojo.*;
import com.ihk.utils.CommonUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.collection.IVipCustItemMapper;
import com.ihk.customer.collection.IVipCustomerMapper;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

public class EditVipCustomerAction extends SupperAction{

	@Autowired
	private IVipCustomerMapper iVipCustomerMapper;
	@Autowired
	private IVipCustItemMapper iVipCustItemMapper;
	@Autowired
	private IVipCustImpMapper iVipCustImpMapper;

	VipCustomer vipCust;
	private JSONObject result;
	
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public VipCustomer getVipCust() {
		return vipCust;
	}

	public void setVipCust(VipCustomer vipCust) {
		this.vipCust = vipCust;
	}

	//查询 初始化
	public String editVipCust() throws Exception {
		try{
			if(request.getParameter("id") == null)
				return SUCCESS;
			
			int id = Integer.parseInt(request.getParameter("id"));

			vipCust = iVipCustomerMapper.findVipCustomerById(id);
			ActionContext.getContext().getValueStack().set("vipCust",vipCust);
			
			//加载购买楼盘
			VipCustItemCond cond = new VipCustItemCond();
			cond.setRefId(id);

            //客户编号取原始数据ID
            String customerNo = request.getParameter("customerNo");
            VipCustImpCond cond1 = new VipCustImpCond();
            if(customerNo!=null && customerNo.length()>0){
                cond.setCustomerNo(customerNo);
                //cond1.setId(Integer.parseInt(customerNo));
                request.getSession().setAttribute("cond1", cond1);
            }

			request.getSession().setAttribute("cond", cond);

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	//修改vip客户
	public String saveVipCust() throws Exception {
		try{
			if(request.getParameter("id")==null)
					return SUCCESS;
			int id= Integer.parseInt(request.getParameter("id"));
			vipCust.setId(id);
			iVipCustomerMapper.updateVipCustomer(vipCust);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	//初始化购买的项目
	/*public String InitailItem1() throws Exception {
		
		try{
			JSONArray jsonArray = new JSONArray();
	        JSONObject jsonobj = new JSONObject();
            VipCustImpCond custCond = (VipCustImpCond) request.getSession().getAttribute("cond1");
			int recordCount = iVipCustImpMapper.findVipCustImpCount(custCond);
			List<VipCustImp> item = iVipCustImpMapper.findVipCustImp(custCond);
			
			for (VipCustImp con : item) {
				  jsonobj.put("id", con.getId());
	              jsonobj.put("customer_name", con.getCustomerName());
	              jsonobj.put("projectName", con.getProjectName());
	              jsonobj.put("building", con.getBuilding());
	              jsonobj.put("floor", con.getFloor());
	              jsonobj.put("room_no", con.getRoom_no());
	              jsonobj.put("total", con.getTotal());
	              jsonobj.put("construction_area", con.getConstruction_area());
	              jsonobj.put("areaSize", con.getAreaSize());
	              jsonobj.put("paymethod", con.getPaymethod());
	              jsonobj.put("adArea", con.getAdArea());
	              jsonobj.put("businesscircle", con.getBusinesscircle());
	              jsonobj.put("constructtype", con.getConstructtype());
	              jsonArray.add(jsonobj);
			}
			Map<String, Object> json = new HashMap<String, Object>();
			json.put("total", recordCount);// total键 存放总记录数，必须的
			json.put("rows", jsonArray);// rows键 存放每页记录 list
			result = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}*/

    /**
     * 按拆分显示明细
     * @return
     * @throws Exception
     */
    public String InitailItem() throws Exception {

        try{
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonobj = new JSONObject();
            VipCustItemCond custCond = (VipCustItemCond) request.getSession().getAttribute("cond");


            int recordCount = iVipCustItemMapper.findVipCustItemCount(custCond);
            List<VipCustItem> item = iVipCustItemMapper.findVipCustItem(custCond);

            for (VipCustItem con : item) {
                //VipCustImp vipCustImp = iVipCustImpMapper.findVipCustImpById(Integer.parseInt(con.getCustomerNo()));

                jsonobj.put("id", con.getId());
                //jsonobj.put("customer_name", vipCustImp.getCustomerName());
                //jsonobj.put("phone", vipCustImp.getPhone());
                jsonobj.put("projectName", con.getProjectName());
                jsonobj.put("area", con.getArea());
                jsonobj.put("building", con.getBuilding());
                jsonobj.put("floor", con.getFloor());
                jsonobj.put("room_no", con.getRoom_no());
                jsonobj.put("total", con.getTotal());
                jsonobj.put("construction_area", con.getConstruction_area());
                jsonobj.put("areaSize", con.getAreaSize());
                jsonobj.put("paymethod", con.getPaymethod());
                jsonobj.put("adArea", con.getAdArea());
                jsonobj.put("businesscircle", con.getBusinesscircle());
                jsonobj.put("constructtype", con.getConstructtype());

                jsonobj.put("source", con.getSource());
                jsonobj.put("customer_name", con.getCustomer_name());
                jsonobj.put("idcard_no", con.getIdcard_no());
                jsonobj.put("tel", con.getTel());
                jsonobj.put("phone", con.getPhone());
                jsonobj.put("attribute", con.getAttribute());
                jsonobj.put("natives", con.getNatives());
                jsonobj.put("reside_area", con.getReside_area());
                jsonobj.put("word_area", con.getWord_area());
                jsonobj.put("deal_date", CommonUtils.getDateString(con.getDeal_date()));
                jsonobj.put("createdate", CommonUtils.getDateString(con.getCreatedate()));

                jsonArray.add(jsonobj);
            }
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("total", recordCount);// total键 存放总记录数，必须的
            json.put("rows", jsonArray);// rows键 存放每页记录 list
            result = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return SUCCESS;
    }
}
