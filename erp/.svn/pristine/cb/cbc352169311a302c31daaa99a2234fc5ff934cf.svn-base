package com.ihk.property.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IProjectDiscountMapper;
import com.ihk.property.data.pojo.ProjectDiscount;
import com.ihk.property.data.pojo.ProjectDiscountCond;
import com.ihk.property.data.services.IProjectDiscountServices;

import com.ihk.utils.base.PojoDeleteCond;

@Service("projectDiscountServices")
public class ProjectDiscountServices implements IProjectDiscountServices {
	@Autowired	 IProjectDiscountMapper projectDiscountMapper;

	public void deleteProjectDiscount(int id) throws RuntimeException {
		projectDiscountMapper.deleteProjectDiscount(new PojoDeleteCond(id));
	}

	public void addProjectDiscount(ProjectDiscount projectDiscount) throws RuntimeException {		
		projectDiscountMapper.addProjectDiscount(projectDiscount);
	}

	@Override
	public ProjectDiscount findProjectDiscountById(int id) throws RuntimeException {
		return projectDiscountMapper.findProjectDiscountById(id);
	}

	@Override
	public void updateProjectDiscount(ProjectDiscount projectDiscount) throws RuntimeException {
		projectDiscountMapper.updateProjectDiscount(projectDiscount);		
	}
	
	public List<ProjectDiscount> findProjectDiscountPage(ProjectDiscountCond cond) throws RuntimeException {
		int recordCount = projectDiscountMapper.findProjectDiscountCount(cond);
		
		cond.recordCount = recordCount;
				
		return projectDiscountMapper.findProjectDiscountPage(cond);
	}
    
	public List<ProjectDiscount> findProjectDiscount(ProjectDiscountCond cond) throws RuntimeException {
    	return projectDiscountMapper.findProjectDiscount(cond);
	}

	@Override
	public List<ProjectDiscount> findProjectDiscountByPayWayId(int payWayId)
			throws RuntimeException {
		return projectDiscountMapper.findProjectDiscountByPayWayId(payWayId);
	}

	@Override
	public void deleteProjectDiscountByPayWayId(int payWayId)
			throws Exception {
		projectDiscountMapper.deleteProjectDiscountByPayWayId(payWayId);
	}

	@Override
	public List<ProjectDiscount> findProjectDiscountByUnitDiscountId(
			int unitDiscountId) throws RuntimeException {
		return projectDiscountMapper.findProjectDiscountByUnitDiscountId(unitDiscountId);
	}
}
