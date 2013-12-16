package com.ihk.property.data;

import java.util.List;

import com.ihk.property.data.pojo.ProjectDiscount;
import com.ihk.property.data.pojo.ProjectDiscountCond;
import com.ihk.utils.base.PojoDeleteCond;
 
public interface IProjectDiscountMapper {

	public void addProjectDiscount(ProjectDiscount projectDiscount) ;

	public void deleteProjectDiscount(PojoDeleteCond cond) throws RuntimeException;

	public void updateProjectDiscount(ProjectDiscount projectDiscount) throws RuntimeException;
	
	public ProjectDiscount findProjectDiscountById(int id) throws RuntimeException;
	
	public List<ProjectDiscount> findProjectDiscountPage(ProjectDiscountCond cond) ;
    
	public List<ProjectDiscount> findProjectDiscount(ProjectDiscountCond cond) ;
    
	public int findProjectDiscountCount(ProjectDiscountCond cond) ;
	
	public List<ProjectDiscount> findProjectDiscountByPayWayId(int payWayId) throws RuntimeException;
	
	public void deleteProjectDiscountByPayWayId(int payWayId) throws Exception;
	
	public List<ProjectDiscount> findProjectDiscountByUnitDiscountId(int unitDiscountId) throws RuntimeException;
}
