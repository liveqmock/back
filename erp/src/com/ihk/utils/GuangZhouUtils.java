package com.ihk.utils;

import java.util.List;

import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.RoleCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IRoleServices;

/**
 * 有关广州项目的帮助类
 * @author dtc
 * 2012-9-29
 */
public class GuangZhouUtils {
	
	private IRoleServices iRoleServices;
	private ICompanyProjectServices iCompanyProjectServices;
	
	private static GuangZhouUtils guangZhouUtils;
	
	public void init(){
		guangZhouUtils = this;
		guangZhouUtils.iRoleServices = this.iRoleServices;
	}
	public static List<Role> getGuangZhouRole(){
		RoleCond cond = new RoleCond();
		cond.setDevFlag("guangzhou");
		return guangZhouUtils.iRoleServices.findRolePage(cond);
	}
	public static List<Role> getGuangZhouRole(int companyId){
		RoleCond cond = new RoleCond();
		cond.setDevFlag("guangzhou");
        cond.setCompanyId(companyId);
		return guangZhouUtils.iRoleServices.findRolePage(cond);
	}
	public static List<CompanyProject> getGuangZhouCompanyProject(){
		CompanyProjectCond cond = new CompanyProjectCond();
		cond.setDevCode("customer_guangzhou");
		return guangZhouUtils.iCompanyProjectServices.findCompanyProjectPage(cond);
	}
	
	public static String bigStringTo_String(String bigS){
		if(bigS == null || bigS.trim().equals("")){
			return "";
		}
	
		
		String re = "";
		for (int i = 0; i < bigS.length(); i++) {
			Character cc= bigS.charAt(i);
	
		    boolean d=Character.isUpperCase(cc);
		    if(d){
		    	re = bigS.substring(0,i) + "_" + bigS.substring(i);
		    }
		   
		}
		if(re.equals("")){
			return bigS.toLowerCase();
		}else{
			return re.toLowerCase();
		}
		
	}
	
	public static String getRowName(String row){
		if(row == null || row.trim().equals("")){
			return "555";
		}
		
		if(row.equals("customerNo"))return "客户编号";
		if(row.equals("customerName"))return "客户姓名";
		if(row.equals("companyId"))return "所属公司";
		if(row.equals("projectId"))return "所属项目";
		if(row.equals("teamId"))return "所属组别";
		if(row.equals("userId"))return "所属人员";
		if(row.equals("managerId"))return "负责人(销售经理)";
		if(row.equals("customerSource"))return "客户来源";
		if(row.equals("intentEstate"))return "意向楼盘";
		if(row.equals("customerState"))return "客户类型";
		if(row.equals("phone"))return "电话";
		if(row.equals("homePhone"))return "固定电话";
		if(row.equals("officePhone"))return "办公电话";
		if(row.equals("gender"))return "性别";
		if(row.equals("email"))return "e-mail";
		if(row.equals("peerNumber"))return "同行人数";
		if(row.equals("visitDate"))return "来访日期";
		
		if(row.equals("isFirst"))return "是否首次";
		if(row.equals("firstDate"))return "首次到场日期";
		if(row.equals("firstHour"))return "首次到场时间";
		if(row.equals("visitCount"))return "来访次数";
		if(row.equals("isRelation"))return "是否提及关系";
		if(row.equals("relationDesc"))return "关系户描述";
		if(row.equals("isOwner"))return "是否业主";
		if(row.equals("nationality"))return "国籍";
		if(row.equals("background"))return "背景";
		if(row.equals("requestArea"))return "需求面积";
		if(row.equals("priceAmount"))return "预算";
		if(row.equals("areaNum"))return "意向面积";
		if(row.equals("priceNum"))return "意向价格";
	
		if(row.equals("buyReson"))return "影响客户购买原因";
		if(row.equals("notBuyReson"))return "客户购买抗拒原因";
		if(row.equals("intentionPart"))return "意向区间";
		if(row.equals("rating"))return "客户评级";
		if(row.equals("ratingRemark"))return "初步评级备录";
		if(row.equals("payType"))return "付款方式";
		if(row.equals("familyType"))return "家庭结构";
		if(row.equals("familyIncome"))return "家庭收入";
		if(row.equals("remark1"))return "备注1";
		if(row.equals("remark2"))return "备注2";
		if(row.equals("remark3"))return "备注3";
		if(row.equals("remark4"))return "备注4";
		
		if(row.equals("marriage"))return "婚姻状况";
		if(row.equals("age"))return "年龄";
		if(row.equals("birthday"))return "生日";
		if(row.equals("idcardType"))return "证件类型";
		if(row.equals("idcardNo"))return "证件号码";
		if(row.equals("faceLook"))return "外貌特征";
		if(row.equals("workUnit"))return "工作单位";
		if(row.equals("jobPosition"))return "职位";
		if(row.equals("wage"))return "月收入";
		if(row.equals("jobType"))return "行业性质";
		if(row.equals("jobIndustry"))return "从事行业";
		if(row.equals("jobDesc"))return "行业描述";
		
		if(row.equals("homeProvince"))return "居住地";
		if(row.equals("homeCity"))return "居住城市";
		if(row.equals("homeRegion"))return "居住区域";
		if(row.equals("homeBlock"))return "居住板块";
		if(row.equals("workProvince"))return "工作地";
		if(row.equals("workCity"))return "工作地城市";
		if(row.equals("workRegion"))return "工作地区域";
		if(row.equals("workBlock"))return "工作地板块";
		if(row.equals("customerRegion"))return "客户区域";
		if(row.equals("address"))return "客户地址";
		if(row.equals("postcode"))return "邮编";
		if(row.equals("family"))return "家庭情况";
		if(row.equals("interest"))return "兴趣爱好";
		if(row.equals("trafficTool"))return "交通工具";
		if(row.equals("trafficDesc"))return "交通工具描述";
		
		if(row.equals("knownFrom"))return "来访获知途径";
		if(row.equals("buyAim"))return "购买动机";
		if(row.equals("buyUse"))return "购买用途";
		if(row.equals("productClaim"))return "产品需求";
		if(row.equals("unitPrice"))return "意向单价区间";
		if(row.equals("houseType"))return "意向产品类型";
		if(row.equals("roomType"))return "意向户型";
		if(row.equals("floor"))return "意向楼层";
		if(row.equals("parking"))return "车位";
		if(row.equals("buyFactor"))return "购买因素";
		if(row.equals("intentLease"))return "意向租价";
		if(row.equals("payBy"))return "付款方式";
		if(row.equals("rejectFactor"))return "未购因素";
		if(row.equals("intentUnit1"))return "意向购买单元1";
		if(row.equals("intentUnit2"))return "意向购买单元2";
		if(row.equals("intentBuynum"))return "意向购买套数";
		if(row.equals("intentionDesc"))return "意向购买说明";
		if(row.equals("buyCount"))return "置业次数";
		return row;
		
	}
	
	
	public IRoleServices getiRoleServices() {
		return iRoleServices;
	}
	public ICompanyProjectServices getiCompanyProjectServices() {
		return iCompanyProjectServices;
	}
	public void setiCompanyProjectServices(
			ICompanyProjectServices iCompanyProjectServices) {
		this.iCompanyProjectServices = iCompanyProjectServices;
	}
	public void setiRoleServices(IRoleServices iRoleServices) {
		this.iRoleServices = iRoleServices;
	}
	
	
	
}
