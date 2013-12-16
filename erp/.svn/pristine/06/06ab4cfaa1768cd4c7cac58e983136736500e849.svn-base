package com.ihk.saleunit.action.new_report;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomerCond;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.SupperAction;

public class KhzhlfxReportAction extends SupperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 176697576134072112L;
	
	@Autowired
	private IContractCustomerServices contractCustomerServices;
	@Autowired
	private ICustomerServices customerServices;
	
	
	private LinkedHashMap<String,String> countTypeList;
	private String countType;
	private ContractCustomerCond contractCustomerCond;
	private CustomerCond customerCond;
	
	
	public String execute() {
		countTypeList=new LinkedHashMap<String,String>();
		countTypeList.put("1", "售前转认筹");
		countTypeList.put("2", "售前转临订");
		countTypeList.put("3", "售前转认购");
		countTypeList.put("4", "认筹转认购");
		countTypeList.put("5", "临订转认购");
		return "success";
	}
	
	/**
	 * 点击查询的数据返回
	 * @return
	 * @throws Exception
	 */
	public String searchAjax() throws Exception {
		if(contractCustomerCond==null){
			contractCustomerCond = new ContractCustomerCond();
		}
		setCondOrderSortByRequest(contractCustomerCond);
		
		ActionTemplate.executeAjaxPage(this, contractCustomerCond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				//不分页的做法
				contractCustomerCond.pageSize = 0;
				return 0;
			}
			
			//获取table中要显示的json
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
				countType = request.getParameter("countType");
				String projectId=request.getParameter("projectId");
				contractCustomerCond.setProjectId(projectId);
				customerCond = new CustomerCond();
				customerCond.setDate1(contractCustomerCond.getDate1());
				customerCond.setDate2(contractCustomerCond.getDate2());
				customerCond.setProjectId(Integer.parseInt(projectId));
				customerCond.setCreatedId(0);
				//int contractCustomerCount = contractCustomerServices.findContractCustomerCount(contractCustomerCond);
				int customerCount = customerServices.findCustomerCount(customerCond);
				List<ContractCustomer> cclist = contractCustomerServices.findContractCustomer(contractCustomerCond);
				int countTypeSum = 0; //分子
				int sum = 0;	//分母
				double result = 0;
				double elseResult = 0;
				for(ContractCustomer cc: cclist){
					if("1".equals(countType)){
						if(ContConfirmType.CHIP.equals(cc.getConfirmType())){
							countTypeSum++;
						}
						sum=customerCount;
					}
					if("2".equals(countType)){
						if(ContConfirmType.CONFIRM_BOOK.equals(cc.getConfirmType())){
							countTypeSum++;
						}	
						sum=customerCount;
					}
					if("3".equals(countType)){
						if(ContConfirmType.CONFIRM.equals(cc.getConfirmType())){
							countTypeSum++;
						}	
						sum=customerCount;
					}
					if("4".equals(countType)){
						if(ContConfirmType.CONFIRM.equals(cc.getConfirmType())&&ContConfirmType.CHIP.equals(cc.getPreCustomerType())){
							countTypeSum++;
						}
						if(ContConfirmType.CHIP.equals(cc.getPreCustomerType())){
							sum++;
						}
					}
					if("5".equals(countType)){
						if(ContConfirmType.CONFIRM.equals(cc.getConfirmType())&&ContConfirmType.CONFIRM_BOOK.equals(cc.getPreCustomerType())){
							countTypeSum++;
						}
						if(ContConfirmType.CONFIRM_BOOK.equals(cc.getPreCustomerType())){
							sum++;
						}
					}
					
				}
				DecimalFormat df2 = new DecimalFormat("###.00");
				if(sum!=0){
					result=Double.parseDouble(df2.format(countTypeSum*1.0/sum*1.0));
					elseResult=Double.parseDouble(df2.format(1 - result));
				}
				else{
					result=0;
					elseResult=0;
				}
				Map<String, String> map = new HashMap<String,String>();
				map.put("fixList", "数量");
				map.put("changed", countTypeSum+"");
				map.put("notChanged", sum-countTypeSum+"");
				
				retList.add(map);
				map = new HashMap<String,String>();
				map.put("fixList", "所占比例");
				map.put("changed", (int)(result*100)+"%");
				map.put("notChanged", (int)(elseResult*100)+"%");
				retList.add(map);
//				map = new HashMap<String,String>();
//				map.put("fixList", "明细");
//				map.put("changed"," <a href='#' onclick='javacript:return showCustomerList1("+0+");' style='color:blue;'>查看</a>");
//				map.put("notChanged"," <a href='#' onclick='javacript:return showCustomerList1("+0+");' style='color:blue;'>查看</a>");
//				retList.add(map);
				return retList;
			}
		});
		
		return null;
		
	}
	


	public LinkedHashMap<String, String> getCountTypeList() {
		return countTypeList;
	}

	public void setCountTypeList(LinkedHashMap<String, String> countTypeList) {
		this.countTypeList = countTypeList;
	}

	public String getCountType() {
		return countType;
	}


	public void setCountType(String countType) {
		this.countType = countType;
	}


	public ContractCustomerCond getContractCustomerCond() {
		return contractCustomerCond;
	}


	public void setContractCustomerCond(ContractCustomerCond contractCustomerCond) {
		this.contractCustomerCond = contractCustomerCond;
	}

	public CustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}


	
	
	

}
