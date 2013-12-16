package com.ihk.report.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.permission.PermissionUtils;
import com.ihk.report.data.IReportPreCustomerMapper;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompany;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompanyCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompanyDate;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompanyDateCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerDate;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerDateCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerPhoneMulProject;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerPhoneMulProjectCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProject;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectDate;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectDateCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestion;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestionCompany;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestionCompanyCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestionCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestionSalesman;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestionSalesmanCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerSalesDate;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerSalesDateCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerSalesman;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerSalesmanCond;
import com.ihk.report.data.services.IReportPreCustomerServices;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetailCond;
import com.ihk.utils.SessionUser;

/**
 * @author 
 *
 */
@Service("reportPreCustomerServices")
public class ReportPreCustomerServices implements IReportPreCustomerServices {

	@Autowired	 IReportPreCustomerMapper preCustomerMapper;

	public List<ReportPreCustomerCompany> groupByCompany(ReportPreCustomerCompanyCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
    	return preCustomerMapper.groupByCompany(cond);
	}


	@Override
	public int getSumNumber(ReportPreCustomerCond cond) {
		//销售人员的权限(只看到他自己的认购单元)
		if(PermissionUtils.isReportOnlySale()){
			cond.setSalesId(SessionUser.getUserId());
		}
		else{
			//一般的人员权限增加
			cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		}
		return preCustomerMapper.getSumNumber(cond);
	}


	@Override
	public List<ReportPreCustomerProject> groupByProject(
			ReportPreCustomerProjectCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
    	return preCustomerMapper.groupByProject(cond);
	}


	@Override
	public List<ReportPreCustomerSalesman> groupBySalesman(
			ReportPreCustomerSalesmanCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
    	return preCustomerMapper.groupBySalesman(cond);
	}


	@Override
	public List<ReportPreCustomerDate> groupByDate(
			ReportPreCustomerDateCond cond) throws RuntimeException {
		//销售人员的权限(只看到他自己的客户)
		if(PermissionUtils.isReportOnlySale()){
			cond.setSalesId(SessionUser.getUserId());
		}
		else{
			//一般的人员权限增加
			cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		}
    	return preCustomerMapper.groupByDate(cond);
	}

	@Override
	public List<ReportPreCustomerProjectDate> groupByProjectDate(
			ReportPreCustomerProjectDateCond cond) throws RuntimeException {
		//销售人员的权限(只看到他自己的客户)
		if(PermissionUtils.isReportOnlySale()){
			cond.setSalesId(SessionUser.getUserId());
		}
		else{
			//一般的人员权限增加
			cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		}
    	return preCustomerMapper.groupByProjectDate(cond);
	}


	@Override
	public List<ReportPreCustomerPhoneMulProject> phoneMulProject(
			ReportPreCustomerPhoneMulProjectCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
    	return preCustomerMapper.phoneMulProject(cond);
	}


	@Override
	public List<Customer> phoneMulProjectDetail(
			ReportPreCustomerPhoneMulProjectCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
    	return preCustomerMapper.phoneMulProjectDetail(cond);
	}


	@Override
	public List<ReportPreCustomerCompanyDate> groupByCompanyDate(
			ReportPreCustomerCompanyDateCond cond) {
		//销售人员的权限(只看到他自己的客户)
		if(PermissionUtils.isReportOnlySale()){
			cond.setSalesId(SessionUser.getUserId());
		}
		else{
			//一般的人员权限增加
			cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		}
    	return preCustomerMapper.groupByCompanyDate(cond);
	}


	@Override
	public List<ReportPreCustomerSalesDate> groupBySalesDate(
			ReportPreCustomerSalesDateCond cond) {
		//销售人员的权限(只看到他自己的客户)
		if(PermissionUtils.isReportOnlySale()){
			cond.setSalesId(SessionUser.getUserId());
		}
		else{
			//一般的人员权限增加
			cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		}
    	return preCustomerMapper.groupBySalesDate(cond);
	}


	@Override
	public List<QuestionAnswerDetail> findQuestionAnswerDetail(QuestionAnswerDetailCond cond) {
    	return preCustomerMapper.findQuestionAnswerDetail(cond);
	}

	@Override
	public List<ReportPreCustomerQuestionCompany> findQuestionGroupByTopicCompany(
			ReportPreCustomerQuestionCompanyCond cond) {
		//一般的人员权限增加
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		
    	return preCustomerMapper.findQuestionGroupByTopicCompany(cond);
	}

	@Override
	public List<ReportPreCustomerQuestion> findQuestionGroupByTopicProject(
			ReportPreCustomerQuestionCond cond) {
		//一般的人员权限增加
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		
    	return preCustomerMapper.findQuestionGroupByTopicProject(cond);
	}

	@Override
	public List<ReportPreCustomerQuestionSalesman> findQuestionGroupByTopicSalesman(
			ReportPreCustomerQuestionSalesmanCond cond) {
		//一般的人员权限增加
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD));
		
    	return preCustomerMapper.findQuestionGroupByTopicSalesman(cond);
	}
}
