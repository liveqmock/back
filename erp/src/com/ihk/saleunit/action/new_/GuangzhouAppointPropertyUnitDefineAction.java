package com.ihk.saleunit.action.new_;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnitDefine;
import com.ihk.property.data.pojo.PropertyUnitDefineCond;
import com.ihk.property.data.services.IPropertyUnitDefineServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.saleunit.UnitSaleStateUtils;

/**
 * 单元自定义信息
 * @author peter.kuang
 *
 */
public class GuangzhouAppointPropertyUnitDefineAction {

	@Autowired IPropertyUnitDefineServices propertyUnitDefineServices;
	@Autowired IPropertyUnitServices propertyUnitServices;
	private String unitId; //选择的房间ID
	private String unitDefId;//自定义数据的ID
	private PropertyUnitDefine unitDe;
	
	
	/**
	 * 查看单元自定义信息tab
	 * 需要选择UNITID
	 * 1-1 594
	 * */
	public String showTab(){
		if(unitId == null || unitId.equals("") || unitId.equals("0")){
			return null;
		}
		PropertyUnitDefineCond cond = new PropertyUnitDefineCond();
		cond.setUnitId(unitId);
		
		List<PropertyUnitDefine> tpList = propertyUnitDefineServices.findPropertyUnitDefine(cond);
		if(tpList == null || tpList.size() == 0){
			unitDe = new PropertyUnitDefine();
			unitDe.setId(0);
			return "suc";
		}
		unitDe = tpList.get(0);
		
		//如果有有就显示 没有就显示为空
		return "suc";
	}
	
	
	private String script;
	/**
	 * 保存自定义信息
	 * 如果ID为0就新建
	 * 不然就更新
	 * */
	public String saveTab(){
		if(unitDefId != null && !unitDefId.trim().equals("") && !unitDefId.trim().equals("0") ){
			
			PropertyUnitDefine tmpOld = propertyUnitDefineServices.findPropertyUnitDefineById(Integer.parseInt(unitDefId));
			
			propertyUnitDefineServices.deletePropertyUnitDefine(Integer.parseInt(unitDefId));
			
			unitDe.setCreatedId(tmpOld.getCreatedId());
			unitDe.setCreatedTime(tmpOld.getCreatedTime());
			unitDe.setIsDeleted("0");
			unitDe.setModId(SessionUser.getUserId());
			unitDe.setModTime(new Date());
			unitDe.setUnitId(tmpOld.getUnitId());
			propertyUnitDefineServices.addPropertyUnitDefine(unitDe);
			script="alert('提交成功')";
			return "suc";
		}else{
			unitDe.setIsDeleted("0");
			unitDe.setCreatedId(SessionUser.getUserId());
			unitDe.setCreatedTime(new Date());
			unitDe.setModId(SessionUser.getUserId());
			unitDe.setModTime(unitDe.getCreatedTime());
			unitDe.setUnitId(Integer.parseInt(unitId));
			
			
			if(unitDe.getCheckDate() != null){
				try {
					UnitSaleStateUtils.changeSaleState(Integer.parseInt(unitId), ContUnitSaleState.IS_CHECK);
				} catch (Exception e) {
					e.printStackTrace();
					script="alert('必须是签约房间才能对数')";
					return "suc";
				}
			}
			
			if(unitDe.getCommissionDate() != null){
				try {
					UnitSaleStateUtils.changeSaleState(Integer.parseInt(unitId), ContUnitSaleState.IS_COMMISSION);
				} catch (Exception e) {
					e.printStackTrace();
					script="alert('必须是已对数房间才能对佣')";
					return "suc";
				}
			}
			
			propertyUnitDefineServices.addPropertyUnitDefine(unitDe);
			script="alert('提交成功')";
			return "suc";
		}
	}

	
	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitDefId() {
		return unitDefId;
	}

	public void setUnitDefId(String unitDefId) {
		this.unitDefId = unitDefId;
	}

	public PropertyUnitDefine getUnitDe() {
		return unitDe;
	}

	public void setUnitDe(PropertyUnitDefine unitDe) {
		this.unitDe = unitDe;
	}



	public String getScript() {
		return script;
	}



	public void setScript(String script) {
		this.script = script;
	}
	
	
}
