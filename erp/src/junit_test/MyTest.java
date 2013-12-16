package junit_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.customer.action.CustomerListDownloadAction;
import com.ihk.permission.PermissionUtils;
import com.ihk.setting.data.pojo.ActionRecordLog;
import com.ihk.setting.data.pojo.ActionRecordLogCond;
import com.ihk.setting.data.services.IActionRecordLogServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.pojo.UserRoleCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IUserRoleServices;

public class MyTest {
	private static FileSystemXmlApplicationContext factory;

	private static IUserRoleServices userRoleServices;
	private static ICompanyProjectServices companyProjectServices;
	@BeforeClass
	public static void init() {

		factory = new FileSystemXmlApplicationContext(
				"src/Junit-applicationContext.xml");
		userRoleServices = (IUserRoleServices) factory.getBean("userRoleServices");
		companyProjectServices = (ICompanyProjectServices)factory.getBean("companyProjectServices");

	}
	//@Test
	public void test1(){
		UserRoleCond cond = new UserRoleCond();
		cond.setRoleId("12");
		cond.setProjectIds(Arrays.asList(new Integer[]{231,230}));
		cond.setDate1("2013-08-21 17:31:54");
		cond.setDate2("2013-08-21 17:31:54");
		System.out.println( userRoleServices.findRoleByCond(cond));
		
	}
	
	//@Test
	public void testReplaceRole(){
		UserRoleCond cond = new UserRoleCond();	
		cond.setRoleId("18");
		cond.setNewRoleId("11");
		
		cond.setProjectIds(Arrays.asList(new Integer[]{378, 141}));
		userRoleServices.replaceRole(cond);
	}
	
	//@Test 
	public void testActionLog(){
		IActionRecordLogServices actionRecordLogServices = (IActionRecordLogServices) factory.getBean("actionRecordLogServices");
		ActionRecordLogCond cond = new ActionRecordLogCond();
		cond.setProjectName("大学小筑");
		
		List<ActionRecordLog> actionRecordLogs =  actionRecordLogServices.findActionRecordLogPage(cond);
		for (ActionRecordLog actionRecordLog : actionRecordLogs) {
			System.out.println(actionRecordLog.getLogType());
		}
		System.out.println(actionRecordLogServices.findActionRecordLogCount(cond));
	}
	
	//@Test
	public void testFindProjectIdByRoleIdAndUserId(){
		StringBuilder builder = new StringBuilder("-1,");
		UserRoleCond cond = new UserRoleCond();
		//cond.setCompanyId(17+"");
		cond.setRoleId("14");
		cond.setUserId("5085");
		List<UserRole>  userRoles = userRoleServices.findUserRolePage(cond);
		List<Integer> companyIds = new ArrayList<Integer>();
		for (UserRole userRole : userRoles) {
			companyIds.add(userRole.getCompanyId());
		}
		if(companyIds.size()!=0){
			CompanyProjectCond projectCond  = new CompanyProjectCond();
			projectCond.setCompanyIds(companyIds);
			List<CompanyProject> companyProjects =  companyProjectServices.findCompanyProjectByCond(projectCond);
			for (CompanyProject companyProject : companyProjects) {
				builder.append(companyProject.getId()+",");
			}
		}
		System.out.println(builder.toString());
	}
	
	@Test
	public void test3(){
		List<Integer> list= PermissionUtils.findProjectIdByRoleIdAndUserId(2,14);
		System.out.println(list.contains(5));
		
		
		
	}
}
