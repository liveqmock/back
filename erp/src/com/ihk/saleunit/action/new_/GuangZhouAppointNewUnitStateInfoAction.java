package com.ihk.saleunit.action.new_;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 * 根据所在的楼栋分析出该楼栋的销售状态数据
 */
public class GuangZhouAppointNewUnitStateInfoAction extends SupperAction{
	
	private static final long serialVersionUID = 1L;

	@Autowired 
	IPropertyUnitServices iPropertyUnitServices;
	
	/**
	 * 根据单元ID找到楼栋相关资料
	 * @param unitInfoList ;List<List<Map>> 
	 * 
	 * */
	public String unitStateInfo(){
		
		int buildId = Integer.parseInt(request.getParameter("buildId"));
		
		List<PropertyUnit> unitsList = iPropertyUnitServices.findUnitsByBuildId(buildId);
		
		unitInfoList = new ArrayList<Map<String,String>>();
		
		List<String> sortKeys = ContUnitSaleState.getSortKey();
		
		for(String key : sortKeys){
			
			unitInfoList.add(initTr(key, unitsList));
		}
		
		return "unit_state_info";
	}
	
	
	private Map<String,String> initTr(String state, List<PropertyUnit> uList){
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		String name = ContUnitSaleState.getSaleState().get(state);
		
		int count = uList.size();
		int num = 0;		
		BigDecimal insideAreaCount = new BigDecimal(0); //所有单元的套内面积总和
		BigDecimal insideAreaStateCount = new BigDecimal(0); //所有单元中,state状态下的套内面积总和
		BigDecimal sumPriceCount = new BigDecimal(0); //所有单元的标准总价总和
		BigDecimal sumPriceStateCount = new BigDecimal(0); ////所有单元中,state状态下的标准总价总和
		
		for(PropertyUnit unit : uList){
			
			if(state.equals(unit.getSaleState())){
				num++;
				if(unit.getInsideArea() != null){
					insideAreaStateCount.add(unit.getInsideArea()); 
				}
				if(unit.getSumPrice() != null){
					sumPriceStateCount.add(unit.getSumPrice());
				}
			}
			
			if(unit.getInsideArea() != null){
				insideAreaCount.add(unit.getInsideArea()); 
			}
			if(unit.getSumPrice() != null){
				sumPriceCount.add(unit.getSumPrice());
			}
			
		}
		
		retMap.put("cls", state);
		retMap.put("name", name); //销售状态的中文名称
		retMap.put("num", num + ""); //套数
		retMap.put("numPer", CommonUtils.moneyDividePer(new BigDecimal(num), new BigDecimal(count))); //套数比例
		retMap.put("area", insideAreaStateCount.toString()); //面积
		retMap.put("areaPer", CommonUtils.moneyDividePer(insideAreaStateCount, insideAreaCount)); //面积比例
		retMap.put("money", sumPriceStateCount.toString()); //金额
		retMap.put("moneyPer", CommonUtils.moneyDividePer(sumPriceStateCount, sumPriceCount)); //金额比例
		
		return retMap;
	}
	
	//
	
	/**
	 * 根据单元ID拿到楼栋单元LIST
	 * 
	private List<PropertyUnit> getUnitsListByUnitId(int unitId){
		PropertyUnit u = iPropertyUnitServices.findPropertyUnitById(this.id);
		return iPropertyUnitServices.findUnitsByBuildId(u.getBuildId());
	}
	
	
	private Map<String,String> initTr_(String state,List<PropertyUnit> ulist){
		HashMap<String,String> m = new HashMap<String, String>();
		if(ulist == null || ulist.size() ==0){
			return m;
		}
		
		float ol = ulist.size();
		int lo = 0;
		BigDecimal s_area = new BigDecimal(0);
		for(PropertyUnit u : ulist){
			if(u.getSaleState()!= null && u.getSaleState().equals(state)){
				lo++;
				if(u.getInsideArea()!=null)s_area.add(u.getInsideArea());
			}
		}
		String name = ContUnitSaleState.getSaleState().get(state);//-状态名称
		String cls = "";//-状态CLASS
		m.put("name", name);
		m.put("cls", state);
		m.put("num", lo+"");
		if(ol == 0 ){
			m.put("per", "0%");
		}else{
			DecimalFormat df = new DecimalFormat("#0.00");
			m.put("per", df.format(lo/ol*100)+"%");
		}
		m.put("sarea", s_area.toString());
		return m;
	}
	*/

	
	/*********************************/
	
	private int id;//--所选单元ID
	private List<Map<String,String>> unitInfoList;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Map<String, String>> getUnitInfoList() {
		return unitInfoList;
	}

	public void setUnitInfoList(List<Map<String, String>> unitInfoList) {
		this.unitInfoList = unitInfoList;
	}
	
	
}
