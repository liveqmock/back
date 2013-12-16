package com.ihk.utils.saleunitnew;

import java.util.Date;
import java.util.Map;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumOperLogType;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.setting.data.pojo.OperLog;
import com.ihk.utils.SessionUser;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 主要用于单元的认购合同新建或查看的href 
 * @author dtc
 * 2012-6-25
 */
public class UnitConfirmContractUtils {
	
	private static final String CREATE_TEMP_CONFIRM_FUNCTION = "createTempConfirmDialog"; //临定
	private static final String SHOW_TEMP_CONFIRM_FUNCTION = "showTempConfirmDialog"; //临定
	private static final String CREATE_CONFIRM_FUNCTION = "createConfirmDialog"; //成交(认购)
	private static final String SHOW_CONFIRM_FUNCTION = "showConfirmDialog"; //成交
	
	/**
	 * 该单元为成交,要用成交的基本信息设到合同的基本信息中
	 */
	private static final String CREATE_CONTRACT_FROM_CONFIRM_FUNCTION = "createContractDialogFromConfirm";
	
	private static final String CREATE_CONTRACT_FUNCTION = "createContractDialog";
	private static final String SHOW_CONTRACT_FUNCTION = "showContractDialog"; //签约(合同)
	
	private static final String CREATE_TEMP_CONFIRM = "新建" + ContUnitSaleState.CONFIRM_BOOK_STR; //临定
	private static final String SHOW_TEMP_CONFIRM = "查看" + ContUnitSaleState.CONFIRM_BOOK_STR; //临定
	private static final String CREATE_CONFIRM = "新建" + ContUnitSaleState.CONFIRM_STR; //成交
	private static final String SHOW_CONFIRM = "查看" + ContUnitSaleState.CONFIRM_STR; //成交
	private static final String CREATE_CONTRACT = "新建" + ContUnitSaleState.CONTRACT_STR;
	private static final String SHOW_CONTRACT = "查看" + ContUnitSaleState.CONTRACT_STR; //签约
	
	/**
	 * 跳转的状态map,包括:IS_SALE ="17"(他售),NOT_FOR_SALE ="18"(不可售),FROZEN = "1"(冻结)
	 */
	private static Map<String, String> skipMap;
	
	public void setSkipMap(Map<String, String> skipMap) {
		UnitConfirmContractUtils.skipMap = skipMap;
	}
	
	public static Map<String, String> getSkipMap() {
		return skipMap;
	}
	
	/**
	 * 根据单元获取对应的操作url
	 * @param unit
	 * @return
	 */
	public static String getConfirmContractCreateOrShowHref(PropertyUnit unit){
		
		StringBuffer href = new StringBuffer();
		
		try{
			
			//避免新增一个新的状态都要重新修改代码,放到配置文件中
			if(skipMap.containsKey(unit.getSaleState())){
				
				return "<a href='javascript:void(0)' style='color:red'>" + skipMap.get(unit.getSaleState()) + "</a>";
			}
			
			if(ContUnitSaleState.CONTRACT.equals(unit.getSaleState())){
				//合同: 查看临定(如果有)+查看认购(如果有)+查看合同
				
				Confirm confirm = unit.getConfirm();
				ConfirmBook confirmBook = unit.getConfirmBook();
				
				if(confirmBook != null){
					
					href.append(initHref(SHOW_TEMP_CONFIRM_FUNCTION, confirmBook.getId(), SHOW_TEMP_CONFIRM));
				}
				
				if(confirm != null){
					
					href.append(initHref(SHOW_CONFIRM_FUNCTION, confirm.getId(), SHOW_CONFIRM));
				}
				
				href.append(initHref(SHOW_CONTRACT_FUNCTION, unit.getContract().getId(), SHOW_CONTRACT));
				
			}else{
				
				if(ContUnitSaleState.CONFIRM.equals(unit.getSaleState())){
					//认购: 查看临定(如果有)+查看认购+新建合同
					
					ConfirmBook confirmBook = unit.getConfirmBook();
					if(confirmBook != null){
						
						href.append(initHref(SHOW_TEMP_CONFIRM_FUNCTION, confirmBook.getId(), SHOW_TEMP_CONFIRM));
					}
					
					href.append(initHref(SHOW_CONFIRM_FUNCTION, unit.getConfirm().getId(), SHOW_CONFIRM))
						//.append(initHref(CREATE_CONTRACT_FUNCTION, unit.getId(), CREATE_CONTRACT))
						.append(initHref(CREATE_CONTRACT_FROM_CONFIRM_FUNCTION, unit.getId(), CREATE_CONTRACT))
						;
					
				}else{
					//非认购非合同: 
					
					if(ContUnitSaleState.CONFIRM_BOOK.equals(unit.getSaleState())){
						//临定: 查看临定+新建认购+新建合同
						
						href.append(initHref(SHOW_TEMP_CONFIRM_FUNCTION, unit.getConfirmBook().getId(), SHOW_TEMP_CONFIRM))
							.append(initHref(CREATE_CONFIRM_FUNCTION, unit.getId(), CREATE_CONFIRM))
							.append(initHref(CREATE_CONTRACT_FUNCTION, unit.getId(), CREATE_CONTRACT))
							;
						
					}else{					
						//可售:
						
						href.append(initHref(CREATE_TEMP_CONFIRM_FUNCTION, unit.getId(), CREATE_TEMP_CONFIRM))
							.append(initHref(CREATE_CONFIRM_FUNCTION, unit.getId(), CREATE_CONFIRM))
							.append(initHref(CREATE_CONTRACT_FUNCTION, unit.getId(), CREATE_CONTRACT))
							;
					}
					
				}
				
			}
		
		}catch (Exception e) {
			//直接改状态会出现异常
			href.delete(0, href.length());
			href.append("<a href='javascript:void(0)' style='color:red'>该单元没有对应的认购单或合同单</a>");
			
		}
		
		return href.toString();
	}
	
	/**
	 * 初始化href
	 * @param functionName
	 * @param id
	 * @param text
	 * @return
	 */
	private static String initHref(String functionName, int id, String text){
		
		StringBuffer sb = new StringBuffer();
		
		if(id > 0){
			sb.append("<a href=\"javascript:void(0)\" style=\"color:#1199FF; text-decoration:underline\" onclick=\"return ")
				.append(functionName)
				.append("('")
				.append(id)
				.append("')\">")
				.append(text)
				.append("</a>")
				.append("&nbsp;&nbsp;&nbsp;");
		}
		
		return sb.toString();
	}
	
	/**
	 * 增加退房记录,log_desc保存认购或签约对应的id
	 * @param type
	 * @param confirmOrContractId
	 * @throws Exception 
	 */
	public static void addUnitCheckOutLog(EnumOperLogType type, int confirmOrContractId) throws Exception{
		
		int userId = SessionUser.getUserId();
		int projectId = SessionUser.getProjectId();
		Date date = new Date();
		
		OperLog oper = new OperLog();
		oper.setDevFlag("");
		oper.setLogTime(date);
		oper.setLogType(type.toString());
		
		oper.setUserId(userId);
		oper.setProjectId(projectId);
		
		oper.setLogDesc("" + confirmOrContractId);
		
		UnitOprLogUtils.getOperLogServices().addOperLog(oper);
		
	}
	
	/**
	 * 根据单元id删除对应的延期签约
	 * @param unitId
	 * @throws Exception
	 */
	public static void deleteExtensionContractByUnitId(int unitId) throws Exception{
		
		MyPropertyUtils.getExtensionContractServices().deleteExtensionContractByUnitId(unitId);
	}

}
