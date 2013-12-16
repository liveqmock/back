package com.ihk.utils.customer;

import java.io.Serializable;
import java.util.List;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.setting.data.pojo.ProjectCode;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.exception.CustomerException;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 根据project_code设置customer的price_num对应的项目的PRICE_AMOUNT值,area_num对应的项目的REQUEST_AREA值
 * code_desc值的格式: (xxx以下,xxx-xxx,...,xxx以上)
 * @author dtc
 * 2012-11-30,上午11:24:37
 */
public class ProjectCodeFieldUtils {
	
	private static final String START_LIMIT = "以下";
	
	private static final String END_LIMIT = "以上";
	
	/**
	 * 设置客户对应的price_num和area_num
	 * @param customer
	 */
	public static void setRriceAndAreaNum(Customer customer){
		
		int projectId = customer.getProjectId();
		if(projectId <= 0){
			throw new CustomerException("请先确定项目");
		}
		
		//预算总价
		int priceNum = customer.getPriceNum();
		//需求面积
		int areaNum = customer.getAreaNum();
		
		if(priceNum > 0){
			
			List<ProjectCode> priceAmountCodeList = MyPropertyUtils.getProjectCodeServices()
				.findProjectCodeByProjectIdAndTypeName(projectId, EnumCodeTypeName.PRICE_AMOUNT.toString());
			
			customer.setPriceAmount(findCodeValByCodeListAndIntNum(priceAmountCodeList, priceNum));
			
		}
		
		if(areaNum > 0){
			
			List<ProjectCode> requestAreaCodeList = MyPropertyUtils.getProjectCodeServices()
				.findProjectCodeByProjectIdAndTypeName(projectId, EnumCodeTypeName.REQUEST_AREA.toString());
			
			customer.setRequestArea(findCodeValByCodeListAndIntNum(requestAreaCodeList, areaNum));
			
		}
		
	}
	
	/**
	 * 根据code list及intNum,获取intNum对应的codeVal
	 * 200㎡以下,200-300㎡,300-400㎡,400-500㎡,500-600㎡,600㎡以上
	 * (xxx,xxx]
	 * @param codeList
	 * @param intNum
	 * @return
	 */
	public static String findCodeValByCodeListAndIntNum(List<ProjectCode> codeList, int intNum){
		
		if(intNum <= 0 || CommonUtils.isCollectionEmpty(codeList)){
			
			return "";
		}
		
		try{
			
			for(ProjectCode code : codeList){
				
				String codeVal = code.getCodeVal();
				String codeDesc = code.getCodeDesc();
				
				if(codeDesc.endsWith(START_LIMIT)){
					
					int intStartLimitEnd = Integer.parseInt(getStartOrEnd(codeDesc));
					
					if(intNum <= intStartLimitEnd){
						
						return codeVal;
					}
					
				}else if(codeDesc.endsWith(END_LIMIT)){
					
					int intEndLimitStart = Integer.parseInt(getStartOrEnd(codeDesc));
					
					if(intNum >= intEndLimitStart){
						
						return codeVal;
					}
					
				}else{
					
					String[] arr = codeDesc.split("-");
					
					int intMiddleStart = Integer.parseInt(arr[0]);
					int intMiddleEnd = Integer.parseInt(getStartOrEnd(arr[1]));
					
					if(intMiddleStart<= intNum && intNum <= intMiddleEnd){
						
						return codeVal;
					}
					
				}
				
			}
			
		}catch (Exception e) {
		}
		
		return "";
	}
	
	/**
	 * 获取xxx以下,或xxx以上的值的数字部分
	 * @param val
	 * @return
	 */
	private static String getStartOrEnd(String val){
		
		StringBuffer sb = new StringBuffer();
		
		int length = val.length();
		
		for(int index=0; index<length; index++){
			
			int tmp = index;
			String indexVal = val.substring(tmp, ++tmp);
			try{
				
				int intVal = Integer.parseInt(indexVal);
				sb.append(intVal);
				
			}catch (Exception e) {
				
				break;
			}
			
		}
		
		return sb.toString();
	}
	
	/**
	 * 比较bean
	 * @author dtc
	 * 2012-12-3,上午11:04:48
	 */
	static class CodeBean implements Serializable{
		
		private static final long serialVersionUID = 9071870796269925030L;
		
		private String start;
		private String end;
		
		public String getStart() {
			return start;
		}
		
		public void setStart(String start) {
			this.start = start;
		}
		
		public String getEnd() {
			return end;
		}
		
		public void setEnd(String end) {
			this.end = end;
		}
		
	}
	
}
