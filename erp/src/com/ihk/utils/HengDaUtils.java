package com.ihk.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.pojo.ArticleCond;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.constanttype.ContProjectId;
import com.ihk.permission.PermissionUtils;
import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.services.ISaleMonitorLogbeforeServices;
import com.ihk.sale.data.services.ISaleMonitorMonthServices;
import com.ihk.sale.data.services.ISaleMonitorServices;
import com.ihk.sale.data.services.ISaleMonitorWeekServices;
import com.ihk.sale.data.services.ISaleMonitorYearServices;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.ICompanyServices;

/**
 * 恒大相关帮助类
 * @author dtc
 * 2012-9-29
 */
public class HengDaUtils {
	
	public static final String IS_COMPANYBUTTOM_SHOW = "isCompanyButtomShow"; //公司销售列表 按钮是否显示
	public static final String IS_COMPANY_SHOW = "isCompanyShow"; //公司销售列表 是否显示
	public static final String IS_COMPANY_LISTEMPTY_SHOW = "isCompanyListEmptyShow"; // 是否空白的公司列表 显示
	public static final String IS_PROJECT_LISTEMPTY_SHOW = "isProjectListEmptyShow"; // 是否空白的项目列表 显示
	
	public static List<Integer> getUserProjects(){
		List<Integer> projectIds = new ArrayList<Integer>();  //该管理员所拥有的project id,要判断该项目是否过期
		
		List<CompanyProject> userProject = PermissionUtils.getUserProjectListByUid(SessionUser.getUserId());
		for(CompanyProject pro : userProject){
			int proId = pro.getId();
			boolean isActive = hengDaUtils.getComProjectServices().isProjectStateActive(proId, new DateTime());
			
			if(isActive){
				projectIds.add(proId);
			}
			
		}
		
		//projectIds.add(SessionUser.getProjectId()); //加上自己的project id,自己的project id也要通过权限来控制
		return projectIds;
	}
	
	public static List<Integer> getUserProjectsByCompanyId(int companyId, List<Integer> userAllProjectIds){
		//判断该公司下的项目id, 该用户有多少个
		
		List<Integer> retList = new ArrayList<Integer>();
		List<CompanyProject> comProjects = hengDaUtils.comProjectServices.findCompanyProjectsByCompanyId(companyId);
		
		for(CompanyProject comProject : comProjects){
			Integer getProjectId = comProject.getId();
			boolean isActive = hengDaUtils.getComProjectServices().isProjectStateActive(getProjectId, new DateTime());
			
			if(userAllProjectIds.contains(getProjectId) && isActive){
				retList.add(getProjectId);
			}
		}
		
		return retList;
	}
	                                                         
	
	public static LinkedHashMap<String, String> getSelCompany(){
		LinkedHashMap<String, String> selCompany = new LinkedHashMap<String, String>();
		selCompany.put("", CommonUtils.ALL);
		
		List<Company> companys = PermissionUtils.getUserCompanyListByUid(SessionUser.getUserId());
		if(companys==null){
			return selCompany;
		}
		for(Company company : companys){
			selCompany.put(company.getId() + "", company.getCompanyName());
		}
		
		//也是通过权限去控制
		/*
		Company userCompany = hendDaUtils.companyServices.findCompanyById(SessionUser.getCompanyId());
		String userCompanyId = userCompany.getId() + "";
		if(!selCompany.containsKey(userCompanyId)){
			selCompany.put(userCompanyId, userCompany.getCompanyName());
		}
		*/
		return selCompany;
	}
	
	public static LinkedHashMap<String, String> getSelCompany(List<Company> companys){
		LinkedHashMap<String, String> selCompany = new LinkedHashMap<String, String>();
		selCompany.put("", CommonUtils.ALL);
		for(Company company : companys){
			selCompany.put(company.getId() + "", company.getCompanyName());
		}
		
		//也是通过权限去控制
		/*
		Company userCompany = hendDaUtils.companyServices.findCompanyById(SessionUser.getCompanyId());
		String userCompanyId = userCompany.getId() + "";
		if(!selCompany.containsKey(userCompanyId)){
			selCompany.put(userCompanyId, userCompany.getCompanyName());
		}
		*/
		return selCompany;
	}
	public static LinkedHashMap<String, String> getSelProject(){
		
		LinkedHashMap<String, String> selProject = new LinkedHashMap<String, String>();
		selProject.put("", CommonUtils.ALL);
		
		List<CompanyProject> userProjects = PermissionUtils.getUserProjectListByUid(SessionUser.getUserId());  //该用户所能管理
		for(CompanyProject pro : userProjects){
			int proId = pro.getId();
			boolean isActive = hengDaUtils.getComProjectServices().isProjectStateActive(proId, new DateTime());
			
			if(isActive){
				selProject.put(proId + "", pro.getProjectName());
			}
		}
		
		/**
		 * 权限中去控制
		 */
		/*
		CompanyProject userProject = hendDaUtils.comProjectServices.findCompanyProjectById(SessionUser.getProjectId());   //用户自身所属的项目
		String userProId = userProject.getId() + "";
		if(!selProject.containsKey(userProId)){
			selProject.put(userProId, userProject.getProjectName()); 
		}
		*/
		return selProject;
	}
	
	public static LinkedHashMap<String, String> getProjectsByCompanyId(int companyId){
		//根据company id 获取该用户能够拥有的project
		
		List<Integer> userProjectIds = getUserProjects();
		
		LinkedHashMap<String, String> projectMap = new LinkedHashMap<String, String>();
		projectMap.put("", CommonUtils.ALL);
		
		List<CompanyProject> projects = hengDaUtils.comProjectServices.findCompanyProjectsByCompanyId(companyId);
		for(CompanyProject project : projects){
			Integer proId = project.getId();
			
			boolean isActive = hengDaUtils.getComProjectServices().isProjectStateActive(proId, new DateTime());
			
			if(userProjectIds.contains(proId) && isActive){
				projectMap.put(proId + "", project.getProjectName());
			}
			
		}
		
		return projectMap;
	}
	
	public static List<Integer> getProjectsByCompanyIdForHengDa(int companyId){
		//根据company id 获取该用户能够拥有的project
		
		List<Integer> retList = new ArrayList<Integer>();
		
		List<Integer> userProjectIds = getUserProjects();
		List<CompanyProject> projects = hengDaUtils.comProjectServices.findCompanyProjectsByCompanyId(companyId);
		
		for(CompanyProject project : projects){
			Integer proId = project.getId();
			
			boolean isActive = hengDaUtils.getComProjectServices().isProjectStateActive(proId, new DateTime());
			
			if(userProjectIds.contains(proId) && isActive){
				retList.add(proId);
			}
			
		}
		
		return retList;
	}
	
	public static CompanyProject findCompanyProjectByProjectId(int projectId){
		
		return hengDaUtils.comProjectServices.findCompanyProjectById(projectId);
	}
	
	public static Company findCompanyByCompanyId(int companyId){
		
		return hengDaUtils.companyServices.findCompanyById(companyId);
	}
	
	public static String getProjectsForSelectByCompanyId(int companyId){
		//跟进companyId获取用户所拥有的project并组合成select标签可以用的String
		
		LinkedHashMap<String, String> projectMap = getProjectsByCompanyId(companyId);
		StringBuffer sb = new StringBuffer();
		
		if(projectMap.keySet().size() > 1){
			Set<String> keys = projectMap.keySet();
			for(String key : keys){
				String value = projectMap.get(key);
				sb.append("<option value=\"")
					.append(key)
					.append("\">")
					.append(value)
					.append("</option>")
					;
				
			}
			
		}
		
		return sb.toString();
	}
	
	@SuppressWarnings("deprecation")
	public static LinkedHashMap<String, String> setSessionIfCompanyAndProjectOne(HttpServletRequest request){
		//判断该用户是否只有一个公司,和项目
		List<Company> companys = PermissionUtils.getUserCompanyList();
		List<CompanyProject> projects = PermissionUtils.getUserProjectList();
		
		List<CompanyProject> activeProjects = new ArrayList<CompanyProject>();
		
		for(CompanyProject project : projects){
			Integer proId = project.getId();
			
			boolean isActive = hengDaUtils.getComProjectServices().isProjectStateActive(proId, new DateTime());
			
			if(isActive){
				activeProjects.add(project);
			}
			
		}
		
		if(companys==null){
			return null;
		}
		
		LinkedHashMap<String, String> selProject = null;
		
		if(companys.size() == 1 && activeProjects.size() == 1){
			//companyId projectId
			Company com = companys.get(0); 
			CompanyProject pro = activeProjects.get(0);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("companyId", com.getId());
			session.setAttribute("projectId", pro.getId());
			
			selProject = HengDaUtils.getProjectsByCompanyId(com.getId());
			
		}
		
		return selProject;
		
	}
	
	public static void downLoadTemplate(String key, Object value, String srcFileName, 
			String fileName, HttpServletResponse response) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(key, value);
		
		ReportUtils.downLoadReport(map, srcFileName, fileName, response);
	}
	
	public static void downLoadTemplate(String key, Object value, String srcFileName, 
			HttpServletResponse response) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(key, value);
		
		ReportUtils.downLoadReport(map, srcFileName, "download-" + CustomerUtils.getNowForString() + "-.xls", response);
	}
	
	public static void addArticle(Article article) throws Exception{
		hengDaUtils.articleServices.addArticle(article);
	}
	
	public static Article getMaxIndexArticle(String now){
		
		ArticleCond cond = new ArticleCond();
		cond.setDate1(now);
		cond.setArticleType(ArticleType.SYSTEM_ARTICLE);
		return hengDaUtils.articleServices.findArticleIndexMax(cond);
		
	}
	
	public static List<CompanyProject> getNotDataCompamyForHengDaByMonitorDate(String monitorDate){
		try {
			List<CompanyProject> allHengDaComProject = hengDaUtils.comProjectServices.findCompanyProjectForHengDa();
			
			List<SaleMonitor> saleList = hengDaUtils.saleMonitorServices.findSaleMonitorByMonitorDate(monitorDate);
			List<Integer> saleProjectIdList = new ArrayList<Integer>();
			for(SaleMonitor sale : saleList){
				saleProjectIdList.add(sale.getProjectId());
			}
			
			List<CompanyProject> retComProject = new ArrayList<CompanyProject>();
			for(CompanyProject comPro : allHengDaComProject){
				Integer projectId = new Integer(comPro.getId());
				if(saleProjectIdList.contains(projectId))
					continue;
				retComProject.add(comPro);
			}
			
			return retComProject;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<CompanyProject>();
		}
		
	}
	
	//////////////////////////////
	
	private static HengDaUtils hengDaUtils;

	private ICompanyProjectServices comProjectServices;
	private ICompanyServices companyServices;
	
	//供SaleMonitorQuartz使用
	private	ISaleMonitorServices saleMonitorServices;
	private	ISaleMonitorWeekServices saleMonitorWeekServices;
	private	ISaleMonitorMonthServices saleMonitorMonthServices;
	private	ISaleMonitorYearServices saleMonitorYearServices;
	private ISaleMonitorLogbeforeServices saleMonitorLogbeforeServices;
	
	//HengDaArticleQurtz 使用
	private IArticleServices articleServices;	
	
	public IArticleServices getArticleServices() {
		return articleServices;
	}

	public void setArticleServices(IArticleServices articleServices) {
		this.articleServices = articleServices;
	}

	public static ISaleMonitorLogbeforeServices getSaleMonitorLogbeforeServices() {
		return hengDaUtils.saleMonitorLogbeforeServices;
	}
	
	public void setSaleMonitorLogbeforeServices(
			ISaleMonitorLogbeforeServices saleMonitorLogbeforeServices) {
		this.saleMonitorLogbeforeServices = saleMonitorLogbeforeServices;
	}
	
	public static ISaleMonitorServices getSaleMonitorServices() {
		return hengDaUtils.saleMonitorServices;
	}

	public void setSaleMonitorServices(ISaleMonitorServices saleMonitorServices) {
		this.saleMonitorServices = saleMonitorServices;
	}

	public static ISaleMonitorWeekServices getSaleMonitorWeekServices() {
		return hengDaUtils.saleMonitorWeekServices;
	}

	public void setSaleMonitorWeekServices(
			ISaleMonitorWeekServices saleMonitorWeekServices) {
		this.saleMonitorWeekServices = saleMonitorWeekServices;
	}

	public static ISaleMonitorMonthServices getSaleMonitorMonthServices() {
		return hengDaUtils.saleMonitorMonthServices;
	}

	public void setSaleMonitorMonthServices(
			ISaleMonitorMonthServices saleMonitorMonthServices) {
		this.saleMonitorMonthServices = saleMonitorMonthServices;
	}

	public static ISaleMonitorYearServices getSaleMonitorYearServices() {
		return hengDaUtils.saleMonitorYearServices;
	}

	public void setSaleMonitorYearServices(
			ISaleMonitorYearServices saleMonitorYearServices) {
		this.saleMonitorYearServices = saleMonitorYearServices;
	}

	public ICompanyProjectServices getComProjectServices() {
		return comProjectServices;
	}

	public void setComProjectServices(ICompanyProjectServices comProjectServices) {
		this.comProjectServices = comProjectServices;
	}

	public ICompanyServices getCompanyServices() {
		return companyServices;
	}

	public void setCompanyServices(ICompanyServices companyServices) {
		this.companyServices = companyServices;
	}
	
	public void init(){
		hengDaUtils = this;
		hengDaUtils.comProjectServices = this.comProjectServices;
		hengDaUtils.companyServices = this.companyServices;
		
		hengDaUtils.saleMonitorServices = this.saleMonitorServices;
		hengDaUtils.saleMonitorWeekServices = this.saleMonitorWeekServices;
		hengDaUtils.saleMonitorMonthServices = this.saleMonitorMonthServices;
		hengDaUtils.saleMonitorYearServices = this.saleMonitorYearServices;
		
		hengDaUtils.saleMonitorLogbeforeServices = this.saleMonitorLogbeforeServices;
		
		hengDaUtils.articleServices = this.articleServices;
		
	}
	
	
	// 初始化的曲线类型下拉框
	public static  LinkedHashMap<String, String> getListSelYType() {
		LinkedHashMap<String, String> listSelYType = new LinkedHashMap<String, String>();
			listSelYType.put("sale","套数面积金额");
			listSelYType.put("visit","来访来电");
			listSelYType.put("intention","认筹");
		return listSelYType;
	}
	

	//取得CRM对应
	public static Integer getCRMCodeProjectId(){
		return ContProjectId.CRM_CODE_PROJECT;//清远金碧天下作为所有恒大项目的crm字典对应的projectId
	}	
	
	
}
