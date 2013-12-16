package com.ihk.saleunit.action.contract_record;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.ContractRecord;
import com.ihk.saleunit.data.services.IContractRecordServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;

/**
 * 添加合同记录
 */
public class ContractRecordForAddAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired IContractRecordServices contractRecordServices;
	
	private Map ctMap;
	private String input1;
	private String input2;
	private String input3;
	private String input4;
	private String input5;
	private String input6;
	private String input7;
	private String input8;
	
	
	

	/**弹出新建*/
	public String addContractRecords(){
		
		return "suc";
	}
	
	/**提交新建表单*/
	public String addContractRecordsForm(){
		String[] input1Str = input1.split(",");
		String[] input2Str = input2.split(",");
		String[] input3Str = input3.split(",");
		String[] input4Str = input4.split(",");
		
		String[] input5Str = input5.split(",");
		String[] input6Str = input6.split(",");
		String[] input7Str = input7.split(",");
		String[] input8Str = input8.split(",");
		List<ContractRecord> addTempList = new ArrayList<ContractRecord>();
		try {
			for(int i = 1; i < input1Str.length; i ++){
				ContractRecord cr = new ContractRecord();
				cr.setContractNo(input1Str[i]);
				
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
				if(!input2Str[i].equals("")){
					cr.setContractDate(sdf.parse(input2Str[i]));
				}else {
					cr.setContractDate(null);
				}
				cr.setCustomerName(input3Str[i]);
				if(!input2Str[i].equals("")){
					cr.setContractMoney(new BigDecimal(input4Str[i]));
				}else {
					cr.setContractMoney(new BigDecimal(0));
				}
				cr.setSalesName(input5Str[i]);
				cr.setState(input6Str[i]);
				cr.setRemark(input7Str[i]);
				cr.setHandoverUser(input8Str[i]);
				
				CommonPojoUtils.initPojoCommonFiled(cr);
				addTempList.add(cr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				CustomerUtils.writeResponse(response, "数据错误,录入失败!");
				return null;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		StringBuffer res = new StringBuffer();
		res.append("录入成功").append(addTempList.size()).append("条记录.合同编号:");
		for(ContractRecord cre : addTempList){
			contractRecordServices.addContractRecord(cre);
			res.append(cre.getContractNo());
		}
		try {
			CustomerUtils.writeResponse(response, res.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map getCtMap() {
		return ctMap;
	}

	public void setCtMap(Map ctMap) {
		this.ctMap = ctMap;
	}

	public String getInput1() {
		return input1;
	}

	public void setInput1(String input1) {
		this.input1 = input1;
	}
	
	public String getInput2() {
		return input2;
	}

	public void setInput2(String input2) {
		this.input2 = input2;
	}

	public String getInput3() {
		return input3;
	}

	public void setInput3(String input3) {
		this.input3 = input3;
	}

	public String getInput4() {
		return input4;
	}

	public void setInput4(String input4) {
		this.input4 = input4;
	}

	public String getInput5() {
		return input5;
	}

	public void setInput5(String input5) {
		this.input5 = input5;
	}

	public String getInput6() {
		return input6;
	}

	public void setInput6(String input6) {
		this.input6 = input6;
	}

	public String getInput7() {
		return input7;
	}

	public void setInput7(String input7) {
		this.input7 = input7;
	}

	public String getInput8() {
		return input8;
	}

	public void setInput8(String input8) {
		this.input8 = input8;
	}
	
}
