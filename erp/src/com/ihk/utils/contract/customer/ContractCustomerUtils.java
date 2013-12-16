package com.ihk.utils.contract.customer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ihk.constanttype.ContComProAreaBuildKey;
import com.ihk.constanttype.ContConfirmType;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * contract customer 帮助类
 * @author dtc
 * 2012-12-21,上午11:23:46
 */
public class ContractCustomerUtils {
	
	/**
	 * 根据请求参数获取楼栋id
	 * @param request
	 * @return
	 */
	public static List<Integer> getBuildIdsByRequest(HttpServletRequest request){
		
		List<Integer> retList = new ArrayList<Integer>();
		
		String type = request.getParameter("type");
		
		if(CommonUtils.isStrEmpty(type))
			return retList;
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(ContComProAreaBuildKey.PERPRO.equals(type)){
			//项目
			List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByPropertyId(id);
			if(!CommonUtils.isCollectionEmpty(buildList)){
				
				for(PropertyBuild build : buildList){
					
					retList.add(build.getId());
				}
			}
			
		}else if(ContComProAreaBuildKey.AREA.equals(type)){
			//分区
			List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByAreaId(id);
			if(!CommonUtils.isCollectionEmpty(buildList)){
				
				for(PropertyBuild build : buildList){
					
					retList.add(build.getId());
				}
			}
			
		}else if(ContComProAreaBuildKey.BUILD.equals(type)){
			//楼栋
			retList.add(id);
			
		}else if(ContComProAreaBuildKey.GROUP.equals(type)){
			//组团
			
			List<Integer> buildIdList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByGroupId(id);
			if(!CommonUtils.isCollectionEmpty(buildIdList)){
				retList.addAll(buildIdList);
			}
			
		}else if(ContComProAreaBuildKey.COMPRO.equals(type)){
			//公司项目
			
			PropertyBuildCond cond = new PropertyBuildCond();
			cond.setCompanyProjectId(id);
			
			List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuild(cond);
			if(!CommonUtils.isCollectionEmpty(buildList)){
				
				for(PropertyBuild build : buildList){
					
					retList.add(build.getId());
				}
			}
			
		}
		
		return retList;
	}
	
	/**
	 * 根据请求参数获取楼栋list,com.ihk.saleunit.action.contract_unit.DetailManagerAction.java中使用
	 * @param request
	 * @return
	 */
	public static List<PropertyBuild> getBuildListByRequest(HttpServletRequest request){
		
		List<PropertyBuild> retList = new ArrayList<PropertyBuild>();
		
		String type = request.getParameter("type");
		
		if(CommonUtils.isStrEmpty(type))
			return retList;
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(ContComProAreaBuildKey.PERPRO.equals(type)){
			//项目
			retList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByPropertyId(id);
			
		}else if(ContComProAreaBuildKey.AREA.equals(type)){
			//分区
			retList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByAreaId(id);
			
		}else if(ContComProAreaBuildKey.BUILD.equals(type)){
			//楼栋
			
			PropertyBuild build = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildById(id);
			if(build != null){
				retList.add(build);
			}
			
		}else if(ContComProAreaBuildKey.GROUP.equals(type)){
			//组团,暂时不查
		}
		
		return retList;
		
	}
	
	/**
	 * 获取confirmTypeName
	 * @param request
	 * @return
	 */
	public static String getConfirmTypeNameByRequest(HttpServletRequest request){
		
		String getType = request.getParameter("confirmType");
		
		if(CommonUtils.isStrEmpty(getType)){
			
			return "confirm";
		}
		
		return getType;
	}
	
	/**
	 * 获取confirmType
	 * @param request
	 * @return
	 */
	public static String getConfirmTypeByRequest(HttpServletRequest request){
		
		String getType = request.getParameter("confirmType");
		
		if(CommonUtils.isStrEmpty(getType)){
			
			return ContConfirmType.CONFIRM;
		}
		
		return getType;
	}
	
	/**
	 * 获取客户类型的map,默认是包括所有的选项
	 * @return
	 */
	public static Map<String, String> initConfirmType(){
		
		return initConfirmType(true);
	}
	
	/**
	 * 获取客户类型的map
	 * @param isPutAll
	 * @return
	 */
	public static Map<String, String> initConfirmType(boolean isPutAll){
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		map.put(ContConfirmType.CONFIRM, ContConfirmType.CONFIRM_STR_CN);
		map.put(ContConfirmType.CONTRACT, ContConfirmType.CONTRACT_STR_CN);
		map.put(ContConfirmType.CONFIRM_AND_CONTRACT, ContConfirmType.CONFIRM_AND_CONTRACT_STR_CN);
		
		if(isPutAll){
			
			map.put(ContConfirmType.CONFIRM_OR_CONTRACT, ContConfirmType.CONFIRM_OR_CONTRACT_STR_CN);
		}
		
		return map;
	}
	
	/**
	 * 设置合同客户的mainId
	 * @param request
	 * @param mainId
	 */
	public static void setUpContractCustomerMainId(HttpServletRequest request, int mainId){
		
		String customerId = request.getParameter("customerId");
		setUpContractCustomerMainId(customerId, mainId);
		
	}
	
	/**
	 * 设置合同客户的mainId
	 * @param customerId
	 * @param mainId
	 */
	public static void setUpContractCustomerMainId(String customerId, int mainId){
		
		if(CommonUtils.isStrZeroEmpty(customerId))
			return ;
		
		if(mainId <= 0)
			throw new RuntimeException("mainId不能为空");
		
		String[] customerIds = customerId.split(",");
		
		if(!CommonUtils.isCollectionEmpty(customerIds)){
			
			List<Integer> ids = new ArrayList<Integer>();
			
			for(String id : customerIds){
				
				if(!CommonUtils.isStrZeroEmpty(id) && CommonUtils.isIntString(id)){
					
					ids.add(Integer.parseInt(id));
				}
			}
			
			if(!CommonUtils.isCollectionEmpty(ids)){
				
				IContractCustomerServices contractCustomerServices = MyPropertyUtils.getContractCustomerServices();
				
				for(int id : ids){
					
					contractCustomerServices.updateContractCustomerMainId(id, mainId);
				}
			}
			
		}
		
	}
	
	/**
	 * 根据id及类型获取对应成交客户的名称,用","相连
	 * @param mainId
	 * @param confirmType
	 * @return
	 */
	public static String getCustomerNameByMainIdAndConfirmType(int mainId, String confirmType){
		
		List<ContractCustomer> cusList = 
			MyPropertyUtils.getContractCustomerServices().findContractCustomerByMainIdAndConfirmType(mainId, confirmType);
		
		if(CommonUtils.isCollectionEmpty(cusList)){
			return "";
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(ContractCustomer cus : cusList){
			
			sb.append(cus.getCustomerName()).append(",");
		}
		
		return CommonUtils.removeLastChar(sb.toString());
	}

    /**
     * 根据id及类型获取对应成交客户的名称,用","相连
     * @param cusList 客户列表
     * @param mainId
     * @param confirmType
     * @return
     */
    public static String getCustomerNameByMainIdAndConfirmType(List<Map<String, Object>> cusList ,int mainId, String confirmType){
        int i=0;  //计数
        int imax = 10;//最大不允许超过10个用户联名，为提供遍历速度设置的
        if(CommonUtils.isCollectionEmpty(cusList)){
            return "";
        }

        StringBuffer sb = new StringBuffer();

        for (Map<String, Object> mapobject : cusList) {
            int cust_mainId = Integer.parseInt(mapobject.get("main_id").toString());
            String cust_confirmType = mapobject.get("confirm_type").toString();
            String customerName = mapobject.get("customer_name").toString();

            if (cust_mainId == mainId && cust_confirmType.equalsIgnoreCase(confirmType)) {
                sb.append(customerName).append(",");
                i++;
            }

            if(i==imax){
                break;
            }
        }

        return CommonUtils.removeLastChar(sb.toString());
    }

    /**
	 * 修改客户,要先判断客户id是否有改变,有改变才需要进行对应的修改
	 * @param mainId
	 * @param confirmType
	 * @param newCustomerId
	 */
	public static void modifyCustomer(int mainId, String confirmType, String newCustomerId){
		
		//旧的客户
		List<ContractCustomer> oldCustomerList = MyPropertyUtils.getContractCustomerServices()
			.findContractCustomerByMainIdAndConfirmType(mainId, confirmType);
	 	List<Integer> oldIdList = new ArrayList<Integer>();
	 	
	 	if(!CommonUtils.isCollectionEmpty(oldCustomerList)){
	 		
	 		for(ContractCustomer cc : oldCustomerList){
		 		oldIdList.add(cc.getId());
		 	}
	 		
	 	}
	 	
	 	//新的客户id
	 	List<Integer> newIdList = CommonUtils.stringToList(newCustomerId);
	 	
	 	//修改客户状态及mainId
	 	for(int newId : newIdList){
	 		
	 		if(!oldIdList.contains(newId)){
	 			MyPropertyUtils.getContractCustomerServices()
	 				.updateContractCustomerConfirmTypeAndMainId(newId, confirmType, mainId);
	 		}
	 	}
	 	
	 	//删除
	 	for(int oldId : oldIdList){
	 		
	 		if(!newIdList.contains(oldId)){
	 			MyPropertyUtils.getContractCustomerServices().deleteContractCustomer(oldId);
	 		}
	 	}
	 	
	}
	
	public static void modifyCustomerForAddContract(int mainId, String confirmType, String newCustomerId){
		
	}
	
	
}
