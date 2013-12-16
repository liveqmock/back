package com.ihk.utils.saleunit;

import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.property.data.services.ICheckfeeServices;
import com.ihk.property.data.services.IPayWayDetailServices;
import com.ihk.property.data.services.IPayWayServices;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyDeveloperServices;
import com.ihk.property.data.services.IPropertyGroupDetailServices;
import com.ihk.property.data.services.IPropertyGroupServices;
import com.ihk.property.data.services.IPropertyPrivServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.property.data.services.IPropertyUnitDefineServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.property.data.services.IUnitPayBillServices;
import com.ihk.saleunit.data.services.ICancelUnitServices;
import com.ihk.saleunit.data.services.IChipServices;
import com.ihk.saleunit.data.services.IConfirmBookServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractSalesmanServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.ICustomerRenameServices;
import com.ihk.saleunit.data.services.IExtensionContractServices;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IReceiptDetailServices;
import com.ihk.saleunit.data.services.IReplaceUnitServices;
import com.ihk.saleunit.data.services.ISaleUnitLogServices;
import com.ihk.saleunit.data.services.ITartServices;
import com.ihk.saleunit.data.services.IUnitOperRecordServices;
import com.ihk.saleunit.log.services.ILogService;
import com.ihk.setting.data.services.IActionRecordLogServices;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.IOperLogServices;
import com.ihk.setting.data.services.IProjectCodeServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.ICompanyServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.user.data.services.IUserRoleServices;

/**
 * 
 * 获取楼盘项目,分区,楼栋,单元的services
 * 认筹方面的services
 * 客户方面的services
 * @author dtc
 *
 */
public class MyPropertyUtils {
	
	private static IPropertyDeveloperServices propertyDeveloperServices;
	
	private static IPropertyProjectServices propertyProjectServices;
	private static IPropertyAreaServices propertyAreaServices;
	private static IPropertyBuildServices propertyBuildServices;
	private static IPropertyUnitServices propertyUnitServices;
	
	private static IPayWayServices payWayServices;
	private static IPayWayDetailServices payWayDetailServices;
	private static IUnitPayBillServices unitPayBillServices;;
	
	private static ISaleUnitLogServices saleUnitLogServices;
	
	private static IConfirmServices confirmServices;
	private static IContractServices contractServices;
	
	private static IConfirmBookServices confirmBookServices;
	
	private static IPropertyGroupServices propertyGroupServices;
	private static IPropertyGroupDetailServices propertyGroupDetailServices;
	
	private static IPropertyPrivServices propertyPrivServices ;

	private static IContractCustomerServices contractCustomerServices ;
	
	private static IChipServices chipServices;
	
	private static ICompanyServices companyServices;
	private static ICompanyProjectServices companyProjectServices;
	private static IProjectCodeServices projectCodeServices;
	
	private static IExtensionContractServices extensionContractServices;
	
	private static IUserAccountServices userAccountServices;
	
	private static IPropertyUnitDefineServices propertyUnitDefineServices;
	
	private static IReceiptDetailServices receiptDetailServices; 
	
	private static IUnitOperRecordServices unitOperRecordServices;
	
	private static ITartServices tartServices;
	
	private static ICustomerRenameServices customerRenameServices;

	private static IReplaceUnitServices replaceUnitServices;
	
	private static ICancelUnitServices cancelUnitServices;
	
	private static ICheckfeeServices checkfeeServices;
	
	private static ICustomerServices customerServices;
	
	private static IProvinceServices provinceServices;
	
	private static ICityServices cityServices;
	
	private static IRegionServices regionServices;
	
	private static IQuestionServices questionServices;
	
	private static IOperLogServices operLogServices;
	
	private static ILogService logService;
	
	private static IContractSalesmanServices contractSalesmanServices;
	
	private static IActionRecordLogServices actionRecordLogServices;
	
	private static IUserRoleServices userRoleServices;
	
	public static IUserRoleServices getUserRoleServices() {
		return userRoleServices;
	}
	
	public void setUserRoleServices(IUserRoleServices userRoleServices) {
		MyPropertyUtils.userRoleServices = userRoleServices;
	}
	
	public static ILogService getLogService() {
		return logService;
	}
	
	public void setLogService(ILogService logService) {
		MyPropertyUtils.logService = logService;
	}
	
	public static IContractSalesmanServices getContractSalesmanServices() {
		return contractSalesmanServices;
	}
	
	public void setContractSalesmanServices(
			IContractSalesmanServices contractSalesmanServices) {
		MyPropertyUtils.contractSalesmanServices = contractSalesmanServices;
	}
	
	public static IOperLogServices getOperLogServices() {
		return operLogServices;
	}
	
	public void setOperLogServices(IOperLogServices operLogServices) {
		MyPropertyUtils.operLogServices = operLogServices;
	}
	
	public static IQuestionServices getQuestionServices() {
		return questionServices;
	}
	
	public void setQuestionServices(IQuestionServices questionServices) {
		MyPropertyUtils.questionServices = questionServices;
	}
	
	public static IProvinceServices getProvinceServices() {
		return provinceServices;
	}

	public void setProvinceServices(IProvinceServices provinceServices) {
		MyPropertyUtils.provinceServices = provinceServices;
	}

	public static ICityServices getCityServices() {
		return cityServices;
	}

	public void setCityServices(ICityServices cityServices) {
		MyPropertyUtils.cityServices = cityServices;
	}

	public static IRegionServices getRegionServices() {
		return regionServices;
	}

	public void setRegionServices(IRegionServices regionServices) {
		MyPropertyUtils.regionServices = regionServices;
	}

	public static ICustomerServices getCustomerServices() {
		return customerServices;
	}
	
	public void setCustomerServices(ICustomerServices customerServices) {
		MyPropertyUtils.customerServices = customerServices;
	}
	
	public static ICheckfeeServices getCheckfeeServices() {
		return checkfeeServices;
	}
	
	public void setCheckfeeServices(ICheckfeeServices checkfeeServices) {
		MyPropertyUtils.checkfeeServices = checkfeeServices;
	}
	
	public static ICustomerRenameServices getCustomerRenameServices() {
		return customerRenameServices;
	}

	public void setCustomerRenameServices(ICustomerRenameServices customerRenameServices) {
		MyPropertyUtils.customerRenameServices = customerRenameServices;
	}
	
	public static ITartServices getTartServices() {
		return tartServices;
	}

	public void setTartServices(ITartServices tartServices) {
		MyPropertyUtils.tartServices = tartServices;
	}

	public static IReplaceUnitServices getReplaceUnitServices() {
		return replaceUnitServices;
	}

	public void setReplaceUnitServices(
			IReplaceUnitServices replaceUnitServices) {
		MyPropertyUtils.replaceUnitServices = replaceUnitServices;
	}

	public static ICancelUnitServices getCancelUnitServices() {
		return cancelUnitServices;
	}

	public void setCancelUnitServices(ICancelUnitServices cancelUnitServices) {
		MyPropertyUtils.cancelUnitServices = cancelUnitServices;
	}

	
	public static IUnitOperRecordServices getUnitOperRecordServices() {
		return unitOperRecordServices;
	}
	
	public void setUnitOperRecordServices(
			IUnitOperRecordServices unitOperRecordServices) {
		MyPropertyUtils.unitOperRecordServices = unitOperRecordServices;
	}
	
	public static IReceiptDetailServices getReceiptDetailServices() {
		return receiptDetailServices;
	}

	public  void setReceiptDetailServices(
			IReceiptDetailServices receiptDetailServices) {
		MyPropertyUtils.receiptDetailServices = receiptDetailServices;
	}

	public static IPropertyUnitDefineServices getPropertyUnitDefineServices() {
		return propertyUnitDefineServices;
	}

	public void setPropertyUnitDefineServices(
			IPropertyUnitDefineServices propertyUnitDefineServices) {
		MyPropertyUtils.propertyUnitDefineServices = propertyUnitDefineServices;
	}

	public static IUserAccountServices getUserAccountServices() {
		return userAccountServices;
	}

	public void setUserAccountServices(
			IUserAccountServices userAccountServices) {
		MyPropertyUtils.userAccountServices = userAccountServices;
	}

	public static IExtensionContractServices getExtensionContractServices() {
		return extensionContractServices;
	}
	
	public void setExtensionContractServices(
			IExtensionContractServices extensionContractServices) {
		MyPropertyUtils.extensionContractServices = extensionContractServices;
	}
	
	public static ICompanyProjectServices getCompanyProjectServices() {
		return companyProjectServices;
	}

	public  void setCompanyProjectServices(
			ICompanyProjectServices companyProjectServices) {
		MyPropertyUtils.companyProjectServices = companyProjectServices;
	}

	public static IPropertyGroupDetailServices getPropertyGroupDetailServices() {
		return propertyGroupDetailServices;
	}
	
	public void setPropertyGroupDetailServices(
			IPropertyGroupDetailServices propertyGroupDetailServices) {
		MyPropertyUtils.propertyGroupDetailServices = propertyGroupDetailServices;
	}
	
	public static IProjectCodeServices getProjectCodeServices() {
		return projectCodeServices;
	}
	
	public void setProjectCodeServices(
			IProjectCodeServices projectCodeServices) {
		MyPropertyUtils.projectCodeServices = projectCodeServices;
	}
	
	public static ICompanyServices getCompanyServices() {
		return companyServices;
	}
	
	public void setCompanyServices(ICompanyServices companyServices) {
		MyPropertyUtils.companyServices = companyServices;
	}
	
	public static IChipServices getChipServices() {
		return chipServices;
	}
	
	public void setChipServices(IChipServices chipServices) {
		MyPropertyUtils.chipServices = chipServices;
	}
	
	public static IConfirmBookServices getConfirmBookServices() {
		return confirmBookServices;
	}
	
	public void setConfirmBookServices(
			IConfirmBookServices confirmBookServices) {
		MyPropertyUtils.confirmBookServices = confirmBookServices;
	}
	
	public static IPropertyPrivServices getPropertyPrivServices() {
		return propertyPrivServices;
	}

	public void setPropertyPrivServices(
			IPropertyPrivServices propertyPrivServices) {
		MyPropertyUtils.propertyPrivServices = propertyPrivServices;
	}

	public static IPropertyDeveloperServices getPropertyDeveloperServices() {
		return propertyDeveloperServices;
	}
	
	public void setPropertyDeveloperServices(
			IPropertyDeveloperServices propertyDeveloperServices) {
		MyPropertyUtils.propertyDeveloperServices = propertyDeveloperServices;
	}
	
	public static IPropertyGroupServices getPropertyGroupServices() {
		return propertyGroupServices;
	}

	public void setPropertyGroupServices(
			IPropertyGroupServices propertyGroupServices) {
		MyPropertyUtils.propertyGroupServices = propertyGroupServices;
	}

	public static IConfirmServices getConfirmServices() {
		return confirmServices;
	}

	public void setConfirmServices(IConfirmServices confirmServices) {
		MyPropertyUtils.confirmServices = confirmServices;
	}

	public static IContractServices getContractServices() {
		return contractServices;
	}

	public void setContractServices(IContractServices contractServices) {
		MyPropertyUtils.contractServices = contractServices;
	}

	public static IPropertyUnitServices getPropertyUnitServices() {
		return propertyUnitServices;
	}
	
	public void setPropertyUnitServices(
			IPropertyUnitServices propertyUnitServices) {
		MyPropertyUtils.propertyUnitServices = propertyUnitServices;
	}
	
	public static IPropertyProjectServices getPropertyProjectServices() {
		return propertyProjectServices;
	}

	public void setPropertyProjectServices(
			IPropertyProjectServices propertyProjectServices) {
		MyPropertyUtils.propertyProjectServices = propertyProjectServices;
	}

	public static IPropertyAreaServices getPropertyAreaServices() {
		return propertyAreaServices;
	}

	public void setPropertyAreaServices(IPropertyAreaServices propertyAreaServices) {
		MyPropertyUtils.propertyAreaServices = propertyAreaServices;
	}

	public static IPropertyBuildServices getPropertyBuildServices() {
		return propertyBuildServices;
	}

	public void setPropertyBuildServices(
			IPropertyBuildServices propertyBuildServices) {
		MyPropertyUtils.propertyBuildServices = propertyBuildServices;
	}

	public static ISaleUnitLogServices getSaleUnitLogServices() {
		return saleUnitLogServices;
	}

	public  void setSaleUnitLogServices(
			ISaleUnitLogServices saleUnitLogServices) {
		MyPropertyUtils.saleUnitLogServices = saleUnitLogServices;
	}

	public static IPayWayServices getPayWayServices() {
		return payWayServices;
	}

	public  void setPayWayServices(IPayWayServices payWayServices) {
		MyPropertyUtils.payWayServices = payWayServices;
	}

	public static IPayWayDetailServices getPayWayDetailServices() {
		return payWayDetailServices;
	}

	public  void setPayWayDetailServices(
			IPayWayDetailServices payWayDetailServices) {
		MyPropertyUtils.payWayDetailServices = payWayDetailServices;
	}

	public static IUnitPayBillServices getUnitPayBillServices() {
		return unitPayBillServices;
	}

	public void setUnitPayBillServices(
			IUnitPayBillServices unitPayBillServices) {
		MyPropertyUtils.unitPayBillServices = unitPayBillServices;
	}

	public static IContractCustomerServices getContractCustomerServices() {
		return contractCustomerServices;
	}

	public void setContractCustomerServices(
			IContractCustomerServices contractCustomerServices) {
		MyPropertyUtils.contractCustomerServices = contractCustomerServices;
	}

	public static IActionRecordLogServices getActionRecordLogServices() {
		return actionRecordLogServices;
	}

	public void setActionRecordLogServices(
			IActionRecordLogServices actionRecordLogServices) {
		MyPropertyUtils.actionRecordLogServices = actionRecordLogServices;
	}
	
}
