package com.ihk.constanttype;

import com.ihk.utils.projectid.ProjectIdUtils;

/**
 * 对应的项目配置迁移到contProjectId.properties
 * 之后的代码可以在本类中设置,也可以直接使用ProjectIdUtils.java中的方法
 * @author dtc
 * 2012-8-10
 */
public class ContProjectId {
	
	/**
	 * 广州
	 */
	public final static Integer GUANG_ZHOU = ProjectIdUtils.getProjectId("GUANG_ZHOU");
	
	/**
	 * 恒大
	 */
	public final static Integer HENG_DA = ProjectIdUtils.getProjectId("HENG_DA");
	
	/**
	 * 清远金碧天下作为所有恒大项目的crm字典对应的projectId
	 */
	public final static Integer CRM_CODE_PROJECT = ProjectIdUtils.getProjectId("CRM_CODE_PROJECT");
	
	/**
	 * 汇景新城
	 */
	public final static Integer OLD_HUI_JING = ProjectIdUtils.getProjectId("OLD_HUI_JING"); //汇景新城
	
	/**
	 * 判断是否为汇景新城
	 * @param projectId
	 * @return
	 */
	public static boolean isOldHuiJing(int projectId){
		
		return OLD_HUI_JING == projectId;
	}
	
	/**
	 * 侨鑫
	 */
	public final static Integer QIAO_XIN = ProjectIdUtils.getProjectId("QIAO_XIN"); //侨鑫
	
	/**
	 * 中信山语湖
	 */
	public final static Integer SHAN_YU_HU = ProjectIdUtils.getProjectId("SHAN_YU_HU");
	
	/**
	 * 判断是否为侨鑫
	 * @param projectId
	 * @return
	 */
	public static boolean isQiaoXin(int projectId){
		
		return QIAO_XIN == projectId;
	}

	/**
	 * 大学小筑 测试1
	 */
	public final static Integer GZ_TEST_1 = ProjectIdUtils.getProjectId("GZ_TEST_1"); //大学小筑
	/**
	 * 大学小筑 测试2
	 */
	public final static Integer GZ_TEST_2 = ProjectIdUtils.getProjectId("GZ_TEST_2"); //大学小筑
	/**
	 * 大学小筑 测试3
	 */
	public final static Integer GZ_TEST_3 = ProjectIdUtils.getProjectId("GZ_TEST_3"); //大学小筑

	/**
	 * 判断是否为大学小筑
	 * @param projectId
	 * @return
	 */
	public static boolean isXiaoZhu(int projectId){
		return GZ_TEST_1 == projectId ||  GZ_TEST_2 == projectId ||  GZ_TEST_3 == projectId;
	}
	
	/**
	 * 安徽默认项目
	 */
	public final static Integer DEFALUT_AN_HUI = ProjectIdUtils.getProjectId("DEFALUT_AN_HUI"); //安徽默认项目
	
	/**
	 * 根据公司id获取该公司下的默认项目id,主要用于获取不同公司的下拉框,因为下拉框是根据项目来获取的,所以给多个项目的公司一个默认的项目
	 * (DescUtils.getInitSelForGuangZhou(LinkedHashMap sel, EnumCodeTypeName codeType, boolean isPutEmpty, Integer ... companyIdList))
	 * @param companyId
	 * @return
	 */
	public static int getDefaultProjectIdByCompanyId(int companyId){
		
		return ProjectIdUtils.getCompanyDefaultProjectId("" + companyId);
	}
	
	/**
	 * 判断是否为新公司(安徽 河南公司等)
	 * @param companyId
	 * @return
	 */
	public static boolean isNewCompany(int companyId){
		return companyId != 17;//新公司 安徽 河南公司等
	}
	
}
