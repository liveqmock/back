package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.ProjectDiscount;
import com.ihk.property.data.pojo.ProjectDiscountCond;

@Transactional 
public interface IProjectDiscountServices {
	public void addProjectDiscount(ProjectDiscount projectDiscount) throws RuntimeException;

	public void deleteProjectDiscount(int id) throws RuntimeException;

	public void updateProjectDiscount(ProjectDiscount projectDiscount) throws RuntimeException;

	public ProjectDiscount findProjectDiscountById(int id) throws RuntimeException;
    
	public List<ProjectDiscount> findProjectDiscountPage(ProjectDiscountCond cond) throws RuntimeException;
    
	public List<ProjectDiscount> findProjectDiscount(ProjectDiscountCond cond) throws RuntimeException;
	
	public List<ProjectDiscount> findProjectDiscountByPayWayId(int payWayId) throws RuntimeException;
	
	public void deleteProjectDiscountByPayWayId(int payWayId) throws Exception;
	
	/**
	 * 根据单元折扣id获取对应的项目折扣
	 * @param unitDiscountId
	 * @return
	 * @throws RuntimeException
	 */
	public List<ProjectDiscount> findProjectDiscountByUnitDiscountId(int unitDiscountId) throws RuntimeException; 
	
	
}