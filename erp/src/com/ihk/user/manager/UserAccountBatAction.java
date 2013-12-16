package com.ihk.user.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContRoleId;
import com.ihk.constanttype.ContUserId;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyCond;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.ICompanyServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.user.data.services.IUserRoleServices;
import com.ihk.utils.ActionAjaxFieldPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.GuangZhouUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import com.ihk.utils.method.ActionAjaxMethodModifyNoThrowsExceptionCallback;
import com.ihk.utils.xls.ReadXlsUtils;

/**
 * 用户批量操作
 * 批量新建用户,批量修改用户所属项目
 * @author dtc
 * 2013-11-29,上午11:06:54
 */
public class UserAccountBatAction extends SupperAction{
	
	private static final long serialVersionUID = 4972471277503915899L;
	
	@Autowired IUserAccountServices userAccountServices;
	@Autowired ICompanyProjectServices companyProjectServices;
	@Autowired IUserRoleServices userRoleServices;
	@Autowired
	ICompanyServices companyServices;

	private List<UserAccount> userAccountList;
	private List<Role> roleList;
	private int selProjectId;
	private int selRoleId;
	private String userStr;

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	public int getSelProjectId() {
		return selProjectId;
	}

	public void setSelProjectId(int selProjectId) {
		this.selProjectId = selProjectId;
	}

	public int getSelRoleId() {
		return selRoleId;
	}

	public void setSelRoleId(int selRoleId) {
		this.selRoleId = selRoleId;
	}	

	public String getUserStr() {
		return userStr;
	}

	public void setUserStr(String userStr) {
		this.userStr = userStr;
	}

	/**
	 * 批量新建用户
	 * @return
	 */
	public String batInputUser(){
		this.roleList = GuangZhouUtils.getGuangZhouRole();
		return "success";
	}


	/**
	 * 提交批量新建用户
	 * @return
	 */
	public String submitBatUser(){
		ActionTemplate.executeAjaxMethod(true,this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
			}
			
			@Override
			public void modifyMethod() throws Exception {
				if(SessionUser.getUserId()!=ContUserId.ADMIN){
					throw new Exception("目前仅供系统管理员使用");					
				}
				
				if(selProjectId<=0){
					throw new Exception("必须选择项目");						
				}

				if(selRoleId<=0){
					throw new Exception("必须选择角色");						
				}

				Date thisDate = new Date();
				CompanyProject project = companyProjectServices.findCompanyProjectById(selProjectId);
				
				if(userAccountList==null){
					userAccountList = new ArrayList<UserAccount>();
				}
				
				
				//每行格式校验
				String strLine[]=userStr.split("\r\n");

				for(int i=0;i<strLine.length;i++){
					if(strLine[i].endsWith(",")){
						strLine[i] = strLine[i]+" ";
					}
					String strUserInfo[] = strLine[i].split(",");
					
					if(strUserInfo.length!=5){
						throw new Exception("第"+(i+1)+"行格式不对");							
					}
					
					UserAccount userAccount = new UserAccount();
					userAccount.setUserName(strUserInfo[0]);
					userAccount.setRealName(strUserInfo[1]);
					userAccount.setRemark(strUserInfo[2]);
					userAccount.setMobilePhone(strUserInfo[3]);
					userAccount.setJobNumber(strUserInfo[4]);					

					userAccount.setUserPwd(ContUserId.INIT_PASSWORD);
					userAccount.setAccountType("1");
					userAccount.setCompanyId(project.getCompanyId());
					userAccount.setProjectId(project.getId());
					userAccount.setCreatedId(SessionUser.getUserId());
					userAccount.setCreatedTime(thisDate);
					userAccount.setModId(SessionUser.getUserId());
					userAccount.setModTime(thisDate);
					userAccount.setIsDeleted("0");
					
					userAccountList.add(userAccount);
				}
				
				//用户校验(用户名是否已经存在)
				for(int i=0;i<userAccountList.size();i++){
					if(userAccountServices.findUserAccountByName(userAccountList.get(i).getUserName())>0){
						throw new Exception("用户账号已经存在,无法添加("+userAccountList.get(i).getUserName()+")全部账号都不会创建!");	
					}
				}
				
				//执行保存
				for(int i=0;i<userAccountList.size();i++){
					userAccountServices.saveUserAccount(userAccountList.get(i));
					
					addRole(userAccountList.get(i),selRoleId);
				}
				
			}
		});
		
		return null;
	}

	/**
	 * 在新建用户的时候 初始化 角色权限
	 * */
	private void addRole(UserAccount u,int roleId){
		UserRole userRole ;
		userRole = new UserRole();
		userRole.setRoleId(ContRoleId.SALEROLE_ID);  //~~~~~~~~~~直接保存权限11 为销售人员
		userRole.setProjectId(0);
		userRole.setCreatedId(SessionUser.getUserId());
		userRole.setCreatedTime(u.getCreatedTime());
		userRole.setIsDeleted("0");
		userRole.setModId(SessionUser.getUserId());
		userRole.setModTime(u.getCreatedTime());
		userRole.setUserId(u.getId());
		
		if(roleId==ContRoleId.SALEROLE_ID){
			//销售人员能够通录该公司的数据,所以不设置具体的项目
			userRole.setProjectId(0);
			userRole.setCompanyId(u.getCompanyId());
		}
		else{
			userRole.setProjectId(u.getProjectId());
			userRole.setCompanyId(u.getCompanyId());			
		}
		
		userRoleServices.addUserRole(userRole);
	}		
	
	////dtc 2013.11.29
	
	/**
	 * 异常数据session key
	 */
	private String BATCH_EXCEPTION_DATA = "batch_exception_data";
	
	/**
	 * 上传的文件
	 */
	private File batchFile;
	
	/**
	 * 公司下拉框
	 */
	private String companyOption;
	
	public void setCompanyOption(String companyOption) {
		this.companyOption = companyOption;
	}
	
	public String getCompanyOption() {
		return companyOption;
	}
	
	public void setBatchFile(File batchFile) {
		this.batchFile = batchFile;
	}
	
	public File getBatchFile() {
		return batchFile;
	}
	
	/**
	 * 跳到批量修改项目的页面
	 * dtc 2013.11.29
	 * @return
	 * @throws Exception
	 */
	public String toBatchModifyProject() throws Exception{
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		List<Company> companyList = companyServices.findCompany(new CompanyCond());
		if(!CommonUtils.isCollectionEmpty(companyList)){
			
			for(Company com : companyList){
				
				map.put(com.getId() + "", com.getCompanyName());
			}
			
		}
		
		companyOption = CommonUtils.getSelectContent(map, SessionUser.getCompanyId() + "", true);
		
		return "toBatchModifyProject";
	}
	
	/**
	 * 批量修改项目
	 * @return
	 * @throws Exception
	 */
	public String batchModifyProject() throws Exception{
		
		//先移除之前session中的异常数据
		
		request.getSession().removeAttribute(BATCH_EXCEPTION_DATA);
		
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				String ignoreFirstRowStr = request.getParameter("ignoreFirstRow"); //是否忽略第一行
				boolean ignoreFirstRow = false;
				if(!CommonUtils.isStrEmpty(ignoreFirstRowStr)){
					ignoreFirstRow = true;
				}
				
				List<Cell[]> cellList = ReadXlsUtils.readXls(batchFile, 5, ignoreFirstRow);
				
				if(CommonUtils.isCollectionEmpty(cellList)){
					
					return ;
				}
				
				int companyId = Integer.parseInt(request.getParameter("companyId"));
				CompanyProjectCond proCond = new CompanyProjectCond();
				proCond.setCompanyId(companyId);
				
				List<CompanyProject> proList = companyProjectServices.findCompanyProjectByCond(proCond);
				
				List<BatchExceptionData> pojoList = new ArrayList<BatchExceptionData>();
				BatchExceptionData pojo = null;
				
				for(Cell[] cell : cellList){
					
					pojo = modifyUserAccountProject(cell, proList, companyId); //返回null表示修改成功
					
					if(pojo != null){
						
						pojoList.add(pojo);
					}
				}
				
				if(!CommonUtils.isCollectionEmpty(pojoList)){
					//表示有异常数据
					request.getSession().setAttribute(BATCH_EXCEPTION_DATA, pojoList);
				}
				
			}
		});
		
		return null;
	}
	
	/**
	 * 判断是否有异常数据
	 * @return
	 * @throws Exception
	 */
	public String ajaxExceptionData() throws Exception{
		
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				Object obj = request.getSession().getAttribute(BATCH_EXCEPTION_DATA);
				if(obj == null){
					//表示没有异常数据
					throw new Exception();
				}
				
			}
		});
		
		return null;
	}
	
	/**
	 * 异常数据datagrid
	 * @return
	 * @throws Exception
	 */
	public String ajaxExceptionDataGrid() throws Exception{
		
		ActionTemplate.executeAjaxPage(this, null, new ActionAjaxFieldPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				return 0;
			}
			
			@SuppressWarnings("unchecked")
			@Override
			public List<?> initRows() throws Exception {
				
				List<BatchExceptionData> batchList = null;
				
				Object obj = request.getSession().getAttribute(BATCH_EXCEPTION_DATA);
				if(obj != null){
					
					batchList = (List<BatchExceptionData>) obj;
				}
				
				return batchList;
			}
			
		}, "projectName", "projectId", "jobNumber", "realName", "exceptionData");
		
		return null;
	}
	
	/**
	 * 下载模板
	 * @return
	 * @throws Exception
	 */
	public String downloadTemplate() throws Exception{
		
		List<BatchExceptionData> batchList = new ArrayList<BatchExceptionData>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("batchList", batchList);
		
		String srcFileName = "batch-exception-data.xls";
		String fileName = "模板.xls";
		
		ReportUtils.downLoadReport(map, srcFileName, fileName, response);
		
		return null;
	}
	
	/**
	 * 下载异常数据
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String downloadExceptionData() throws Exception{
		
		List<BatchExceptionData> batchList = new ArrayList<BatchExceptionData>();
		
		Object obj = request.getSession().getAttribute(BATCH_EXCEPTION_DATA);
		if(obj != null){
			
			batchList = (List<BatchExceptionData>) obj;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("batchList", batchList);
		
		map.put("message", "异常信息");
		
		String srcFileName = "batch-exception-data.xls";
		String fileName = "异常数据.xls";
		
		ReportUtils.downLoadReport(map, srcFileName, fileName, response);
		
		return null;
	}
	
	/**
	 * 返回null表示修改成功
	 * @param cell
	 * @param proList
	 * @param companyId
	 * @return
	 */
	private BatchExceptionData modifyUserAccountProject(Cell[] cell, List<CompanyProject> proList, int companyId){
		
		String message = "";
		
		try{
			
			String projectName = cell[0].getContents().trim();
			int projectId = 0;
			try{
				projectId = Integer.parseInt(cell[1].getContents().trim());
			}catch (Exception e) {
			}
			
			String jobNumber = cell[2].getContents().trim();
			
			String realName = cell[3].getContents().trim();
			
			if(projectId > 0){
				//表示填了项目id
				
				CompanyProject project = companyProjectServices.findCompanyProjectById(projectId);
				if(project == null || !projectName.equals(project.getProjectName())){
					
					message = "项目名称与id不一致";
					throw new Exception();
					
				}
			}else{
				//没有填项目id
				
				List<CompanyProject> inclueProList = isIncludeOnlyCompanyProject(proList, projectName);
				if(CommonUtils.isCollectionEmpty(inclueProList) || inclueProList.size() != 1){
				
					message = "选择的公司该项目不合法";
					throw new Exception();
				}
				
				projectId = inclueProList.get(0).getId();
				
			}
			
			UserAccount userAccount = new UserAccount(); //参数
			userAccount.setCompanyId(companyId);
			userAccount.setRealName(realName);
			if(!CommonUtils.isStrEmpty(jobNumber)){
				userAccount.setJobNumber(jobNumber);
			}
			
			List<UserAccount> userList = userAccountServices.findUserAccountByCompanyIdAndRealNameOrJobNumberIncludeDelete(userAccount);
			if(CommonUtils.isCollectionEmpty(userList) || userList.size() != 1){
				
				message = "用户姓名不能唯一确定一个用户";
				throw new Exception();
			}
			
			UserAccount user = userList.get(0);
			
			user.setProjectId(projectId);
			
			user.setModId(SessionUser.getUserId());
			user.setModTime(new Date());
			
			userAccountServices.updateUserAccount(user);
			
		}catch (Exception e) {
			
			if(CommonUtils.isStrEmpty(message)){
				
				message = "数据格式不合法\n" + e.getMessage();
			}
		}
		
		if(CommonUtils.isStrEmpty(message)){
			//表示修改成功
			
			return null;
		}
		
		BatchExceptionData retPojo = new BatchExceptionData();
		
		retPojo.setProjectName(cell[0].getContents());
		retPojo.setProjectId(cell[1].getContents());
		retPojo.setJobNumber(cell[2].getContents());
		retPojo.setRealName(cell[3].getContents());
		retPojo.setExceptionData(message);
		
		return retPojo;
	}
	
	/**
	 * 返回null表示修改成功
	 * @param cell
	 * @return
	 */
	@SuppressWarnings("unused")
	private BatchExceptionData modifyUserAccountProject(Cell[] cell){
		
		String message = "";
		
		try{
			
			String projectName = cell[0].getContents().trim();
			int projectId = Integer.parseInt(cell[1].getContents().trim());
			
			String realName = cell[3].getContents().trim();
			String userName = cell[4].getContents().trim();
			
			CompanyProject project = companyProjectServices.findCompanyProjectById(projectId);
			if(project == null || !projectName.equals(project.getProjectName())){
				
				message = "项目名称与id不一致";
				throw new Exception();
				
			}
			
			UserAccount user = userAccountServices.findUserAccountByUserNameIncludeDelete(userName);
			if(user == null || !realName.equals(user.getRealName())){
				
				message = "用户的姓名与账号不一致";
				throw new Exception();
			}
			
			user.setProjectId(projectId);
			
			user.setModId(SessionUser.getUserId());
			user.setModTime(new Date());
			
			userAccountServices.updateUserAccount(user);
			
		}catch (Exception e) {
			
			if(CommonUtils.isStrEmpty(message)){
				
				message = "数据格式不合法";
			}
		}
		
		if(CommonUtils.isStrEmpty(message)){
			//表示修改成功
			
			return null;
		}
		
		BatchExceptionData retPojo = new BatchExceptionData();
		
		retPojo.setProjectName(cell[0].getContents());
		retPojo.setProjectId(cell[1].getContents());
		retPojo.setJobNumber(cell[2].getContents());
		retPojo.setRealName(cell[3].getContents());
		retPojo.setUserName(cell[4].getContents());
		retPojo.setExceptionData(message);
		
		return retPojo;
	}
	
	/**
	 * 判断是否唯一包含公司项目,如果返回的list size不等于1就表示有问题
	 * @param proList
	 * @param companyProjectName
	 * @return
	 */
	private List<CompanyProject> isIncludeOnlyCompanyProject(List<CompanyProject> proList, String companyProjectName){
		
		List<CompanyProject> retList = new ArrayList<CompanyProject>();
		
		if(CommonUtils.isCollectionEmpty(proList)){
			
			return retList;
		}
		
		for(CompanyProject pro : proList){
			
			if(companyProjectName.equals(pro.getProjectName())){
				
				retList.add(pro);
			}
			
		}
		
		return retList;
	}
	
}
