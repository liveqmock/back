package com.ihk.saleunit.action.new_report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.SupperConfirm;
import com.ihk.utils.saleunit.ReportShowUtils;

/**
 * 销售明细
 * */
public class SaleDetailReportAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired IPropertyUnitServices propertyUnitServices;
	@Autowired IConfirmServices confirmServices;
	@Autowired IContractServices contractServices;
	static String DE = "--";
	
	private int proId;
	private String date1;
	private String date2;
	private JSONArray res;
	private PropertyUnitCond propertyUnitCond;
	private String proIds;
	private String id;
	
	/** left跳转 */
	public String index() {
		id = null;
		return "success";
	}

	/** 
	 * 查询销售信息
	 * 
	 * search条件有 项目ID 以及销售人员
	 * 以 confirn 和 contract 为主
	 * 
	 * @param proIds 查询项目用
	 * @param id easyUi 默认 查询子节点
	 * @throws Exception 
	 * */
	public String search() throws Exception {
		//TODO 子节点信息查询
		if(id != null && !id.trim().equals("")){
			String[] idString = id.split("_");
			String tou = idString[0];
			int intId = Integer.parseInt(idString[1]);
			if(tou.equals("p"))res = getUser(intId);
			if(tou.equals("u"))res = getUnit(id);
			return "suc";
		}
		if(proIds == null || proIds.trim().equals(""))return "suc";
		//TODO 拿到所有符合条件的unit
		String[] pidss = proIds.split(",");
		List<Integer> intproIds = new ArrayList<Integer>();
		for(String s: pidss){
			intproIds.add(Integer.parseInt(s));
		}
		if(propertyUnitCond == null)propertyUnitCond = new PropertyUnitCond();
		propertyUnitCond.setCompanyProjectIds(intproIds);
		List<PropertyUnit> allUnit = this.propertyUnitServices.findPropertyUnit(propertyUnitCond);
		for (int i = 0; i < allUnit.size(); i++) {
			if(!allUnit.get(i).isSale()){
				allUnit.remove(i);
			}
		}
		
		//TODO 注入confirm and contract
		List<Confirm> listConfirm = confirmServices.findConfirm(new ConfirmCond());
		List<Contract> listContract = contractServices.findContractPage(new ContractCond());
		ReportShowUtils.initListPropertyUnit_Confirm(allUnit,listConfirm);
		ReportShowUtils.initListPropertyUnit_Contract(allUnit,listContract);
		this.getRequest().getSession().setAttribute("allUnit", allUnit);
		//TODO 组装页面需要的res
		res = initJson(allUnit,listConfirm,listContract);
		return "suc";
	}
	
	//组装需要的json 组装主方法
	private JSONArray initJson(List<PropertyUnit> unitList, List<Confirm> confirmList,List<Contract> contractList)throws Exception{
		if(proIds == null || proIds.trim().equals(""))return null;
		String[] ids = proIds.split(",");
		JSONArray jsonArray = new JSONArray();
		for(String id : ids){
			int intid = Integer.parseInt(id);
			JSONObject oneProsum = new JSONObject();
			countUnit(intid ,unitList,oneProsum);
			jsonArray.add(oneProsum);
		}
		return jsonArray;
	}
	
	//根据项目 合计 
	private  JSONObject countUnit(int id,List<PropertyUnit> unitList,JSONObject js){
		int count = 0;
		BigDecimal buildArea = new BigDecimal(0);//建筑面积
		BigDecimal insidedArea = new BigDecimal(0);//套内面积
		BigDecimal sumPrice = new BigDecimal(0);//标准总价
		BigDecimal salePrice = new BigDecimal(0);//销售总计
		SupperConfirm confirm ;
		for(PropertyUnit unit : unitList){
			confirm = unit.getContract() == null ? unit.getConfirm() : unit.getContract();
			if(confirm!= null && unit.isSale() && unit.getCompanyProjectId() == id){
				count++;
				buildArea = buildArea.add(unit.getBuildArea() == null ? new BigDecimal(0) : unit.getBuildArea());
				insidedArea = insidedArea.add(unit.getInsideArea() == null ? new BigDecimal(0) : unit.getInsideArea());
				sumPrice = sumPrice.add(unit.getSumPrice() == null ? new BigDecimal(0) : unit.getSumPrice());
				//salePrice = salePrice.add(unit.get)
			}
		}
		String heji = "(合计)";
		js.put("id", "p_"+id);
		js.put("buildArea",heji+ buildArea.toString());
		js.put("insidedArea", heji+insidedArea.toString());
		js.put("sumPrice",heji+ sumPrice);
		//不能够合计的项
		js.put("buildId",DE);
		js.put("unitNo",heji + count);
		js.put("saleState",DE);
		js.put("project",DescUtils.getCompanyProjectRealName(id));
		js.put("iconCls", "tree-icon");
		js.put("state", "closed");
		//js.put("children",detailUnit(id,unitList));
		return js;
	}
	
	// ID为项目ID 获取销售资料
	private JSONArray getUser(int proId) throws Exception{
		List<PropertyUnit> allUnit = (List<PropertyUnit>)this.getRequest().getSession().getAttribute("allUnit");
		JSONObject oneUnit = new JSONObject();
		JSONArray unitArr = new JSONArray();
		//TODO 拿到所有不同的销售
		List<String> saleList = new ArrayList<String>();
		SupperConfirm confirm ;
		Map<String,Map<String,BigDecimal>> saleHuizong = new HashMap<String, Map<String,BigDecimal>>();
		for(PropertyUnit unit : allUnit){
			confirm = unit.getContract() == null ? unit.getConfirm() : unit.getContract();
			if(proId == unit.getCompanyProjectId() && confirm != null && !saleList.contains(confirm.getSalesId()) ){
				saleList.add(confirm.getSalesId());
				saleHuizong.put(confirm.getSalesId(), new HashMap<String, BigDecimal>());
				saleHuizong.get(confirm.getSalesId()).put("buildArea", new BigDecimal(0));
				saleHuizong.get(confirm.getSalesId()).put("insideArea", new BigDecimal(0));
				saleHuizong.get(confirm.getSalesId()).put("sumPrice", new BigDecimal(0));
				saleHuizong.get(confirm.getSalesId()).put("count", new BigDecimal(0));
			}
			
			if(proId == unit.getCompanyProjectId() && confirm != null && saleList.contains(confirm.getSalesId()) ){
				saleHuizong.get(confirm.getSalesId())
					.put("buildArea", saleHuizong.get(confirm.getSalesId()).get("buildArea").add(unit.getBuildArea()));
				
				saleHuizong.get(confirm.getSalesId())
					.put("insideArea", saleHuizong.get(confirm.getSalesId()).get("insideArea").add(unit.getInsideArea()));
				
				saleHuizong.get(confirm.getSalesId())
					.put("sumPrice", saleHuizong.get(confirm.getSalesId()).get("sumPrice").add(unit.getSumPrice()));
				
				saleHuizong.get(confirm.getSalesId())
					.put("count", saleHuizong.get(confirm.getSalesId()).get("count").add(new BigDecimal(1)));
			}
			
			confirm = null;
		}
		
		for(String saleuser :  saleList){
			if(saleuser.equals("")){
				oneUnit.put("project", "NULL");//认购/临定/退房
			}else{
				String[] sales = saleuser.split(",");
				String name = "";
				for(String n : sales){
					name += DescUtils.getUserRealName(Integer.parseInt(n));
				}
				oneUnit.put("project", name);//认购/临定/退房
			}
			
			oneUnit.put("id", "u_"+saleuser+"_"+proId);
			oneUnit.put("buildId", DE);
			oneUnit.put("unitNo", "(合计)" + saleHuizong.get(saleuser).get("count").toString());
			oneUnit.put("buildArea", "(合计)" +saleHuizong.get(saleuser).get("buildArea"));//建筑面积
			oneUnit.put("insidedArea", "(合计)" +saleHuizong.get(saleuser).get("insideArea"));//套内面积
			oneUnit.put("sumPrice", "(合计)" +saleHuizong.get(saleuser).get("sumPrice"));//标准总价
			oneUnit.put("state", "closed");
			unitArr.add(oneUnit);
		}
		return unitArr;
	}
	
	//tree异步获取资料 ID为销售ID 获取所有该销售的销售资料
	private JSONArray getUnit(String id){
		String[] tou = id.split("_");
		Integer pid = Integer.parseInt(tou[2]);
		String saleids = tou[1];
		SupperConfirm confirm ;
		List<PropertyUnit> allUnit = (List<PropertyUnit>)this.getRequest().getSession().getAttribute("allUnit");
		JSONObject oneUnit = new JSONObject();
		JSONArray unitArr = new JSONArray();
		int jj = 0;
		for(PropertyUnit unit : allUnit){
			if(jj>50){
				oneUnit.put("id", "l_"+unit.getId());//认购/临定/退房
				oneUnit.put("project", "更多...");//认购/临定/退房
				oneUnit.put("buildId", DE);
				oneUnit.put("unitNo", DE);
				oneUnit.put("buildArea", DE);//建筑面积
				oneUnit.put("insidedArea", DE);//套内面积
				oneUnit.put("sumPrice", DE);//标准总价
				unitArr.add(oneUnit);
				break;
			}
			confirm = unit.getContract() ;
			if(confirm == null){
				confirm=unit.getConfirm();
			}
			
			//if(confirm != null)System.out.println("kong!!");
			
			if(confirm!=null&& unit.getCompanyProjectId() == pid && confirm.getSalesId().equals(saleids)){
			
				oneUnit.put("id", "l_"+unit.getId());//认购/临定/退房
				oneUnit.put("project", unit.getUnitNo());//认购/临定/退房
				oneUnit.put("buildId", unit.getDescBuildId());
				oneUnit.put("unitNo", unit.getUnitNo());
				//oneUnit.put("saleDate", unit.getUnitNo());//认购日期
				//oneUnit.put("saleDate", unit.getUnitNo());//客户名称
				oneUnit.put("buildArea", unit.getBuildArea());//建筑面积
				oneUnit.put("insidedArea", unit.getInsideArea());//套内面积
				oneUnit.put("sumPrice", unit.getSumPrice());//标准总价
				//oneUnit.put("sumPrice", unit.getSumPrice());//成交总价
				//oneUnit.put("sumPrice", unit.getSumPrice());//付款方式
				//oneUnit.put("sumPrice", unit.getSumPrice());//优惠折扣
				//oneUnit.put("sumPrice", unit.getSumPrice());//联系电话
				//oneUnit.put("sumPrice", unit.getSumPrice());//通讯地址
				//oneUnit.put("sumPrice", unit.getSumPrice());//证件号码
				//oneUnit.put("sumPrice", unit.getSumPrice());//销售人员
				//oneUnit.put("sumPrice", unit.getSumPrice());//签合同日期
				oneUnit.put("saleState", ContUnitSaleState.getSaleState().get(unit.getSaleState()));//认购/临定/退房
			//	oneUnit.put("state", open);
				unitArr.add(oneUnit);
				jj++;	
			}
			
		}
		
		return unitArr;
	}
	
	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public JSONArray getRes() {
		return res;
	}

	public void setRes(JSONArray res) {
		this.res = res;
	}

	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}

	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
	}

	public String getProIds() {
		return proIds;
	}

	public void setProIds(String proIds) {
		this.proIds = proIds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
}
















