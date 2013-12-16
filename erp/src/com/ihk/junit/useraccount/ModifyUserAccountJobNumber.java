package com.ihk.junit.useraccount;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;

import org.junit.Test;

import com.ihk.junit.SupperJunit;
import com.ihk.junit.import_confirm.utils.ExceptionDataPojo;
import com.ihk.junit.import_confirm.utils.ExceptionDataUtils;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.xls.ReadXlsUtils;

/**
 * 修改用户的工号
 * @author dtc
 * 2013-12-4,下午04:57:14
 */
public class ModifyUserAccountJobNumber extends SupperJunit{
	
	IUserAccountServices userAccountServices = (IUserAccountServices) factory.getBean("userAccountServices");
	
	/**
	 * 修改工号
	 * @throws Exception
	 */
	@Test
	public void modifyJobNumber() throws Exception{
		
		File file = new File("C:\\jobNumber\\jobNumber.xls");
		
		List<Cell[]> cellList = ReadXlsUtils.readXls(file, 3, false);
		
		if(CommonUtils.isCollectionEmpty(cellList)){
			return ;
		}
		
		List<ExceptionDataPojo> exList = new ArrayList<ExceptionDataPojo>();
		ExceptionDataPojo pojo = null;
		
		String message = "";
		
		for(Cell[] cell : cellList){
			
			message = modifyOne(cell);
			if(!CommonUtils.isStrEmpty(message)){
				
				pojo = new ExceptionDataPojo(cell, message);
				exList.add(pojo);
				
			}
		}
		
		if(!CommonUtils.isCollectionEmpty(exList)){
			
			String fileName = "C:\\jobNumber\\exception\\异常数据.xls";
			ExceptionDataUtils.writerXlsByJxl(exList, fileName, 4);
		}
		
	}
	
	/**
	 * 修改一行,返回空表示修改成功,否则修改失败
	 * @param cell
	 * @return
	 */
	private String modifyOne(Cell[] cell){
		
		String message = "";
		
		try{
			
			String jobNumber = cell[0].getContents().trim();
			String realName = cell[1].getContents().trim();
			String userName = cell[2].getContents().trim();
			
			UserAccount user = userAccountServices.findUserAccountByUserNameIncludeDelete(userName);
			if(user == null || !realName.equals(user.getRealName().trim())){
				
				message = "用户的姓名与账号不一致";
				throw new Exception();
			}
			
			user.setJobNumber(jobNumber);
			userAccountServices.updateUserAccountJobNumber(user);
			
		}catch (Exception e) {
			
			if(CommonUtils.isStrEmpty(message)){
				
				message = "数据格式有问题";
			}
		}
		
		return message;
	}

}
