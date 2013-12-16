package com.ihk.saleunit.action.chip;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.services.IChipServices;
import com.ihk.utils.ActionMethodModifyUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.UnitChangeUtils;

/**
 * 作废认筹action
 * @author dtc
 * 2013-2-5,上午10:41:17
 */
public class VoidChipAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IChipServices chipServices;
	@Autowired
	IPropertyUnitServices unitServices;
	
	/**
	 * 作废,成功{"type":"true"};失败{"type":"false"}
	 * @return
	 * @throws Exception
	 */
	public String voidChip() throws Exception{
		
		new ActionMethodModifyUtils(true) {
			
			@Override
			protected void modifyMethod() throws Exception {
				//作废认筹单,并把对应的单元的认筹个数修改
				
				int id = Integer.parseInt(request.getParameter("id"));
				
				Chip chip = chipServices.findChipById(id);
				
				int unitId1 = chip.getUnitId1();
				if(unitId1 > 0){
					PropertyUnit unit1 = unitServices.findPropertyUnitById(unitId1);
					int chip1 = unit1.getChip1();
					if(unit1 != null && chip1 > 0){
						unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(unitId1, 1, --chip1);
						UnitChangeUtils.setSaleAble(unitId1,chip1);
					}
				}
				
				int unitId2 = chip.getUnitId2();
				if(unitId2 > 0){
					PropertyUnit unit2 = unitServices.findPropertyUnitById(unitId2);
					int chip2 = unit2.getChip2();
					if(unit2 != null && chip2 > 0){
						unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(unitId2, 2, --chip2);
						UnitChangeUtils.setSaleAble(unitId2,chip2);
					}
				}
				
				int unitId3 = chip.getUnitId3();
				if(unitId3 > 0){
					PropertyUnit unit3 = unitServices.findPropertyUnitById(unitId3); 
					int chip3 = unit3.getChip3();
					if(unit3 != null && chip3 > 0){
						unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(unitId3, 3, --chip3);
						UnitChangeUtils.setSaleAble(unitId3,chip3);
					}
				}
				
				chipServices.disabledChip(id);
			}
		}.doModify(this);
		
		return null;
	}
	
	
	//
	private Chip chip;
	
	public void setChip(Chip chip) {
		this.chip = chip;
	}
	
	public Chip getChip() {
		return chip;
	}

}
