package com.kn.action;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.kn.data.pojo.OlddbIdlog;
import com.ihk.kn.data.pojo.OlddbIdlogCond;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.kn.data.pojo.KN_DATABASES;
import com.kn.data.pojo.KN_LPCS_DY;
import com.kn.data.pojo.KN_LPCS_DY_Cond;
import com.kn.data.pojo.KN_LPCS_LP2;
import com.kn.data.pojo.KN_LPCS_LP2_Cond;

/**
 * junit测试类
 * 
 * @author peter 2012-9-29
 */
public class DaoShuDanYuan {

	private static FileSystemXmlApplicationContext factory;

	@BeforeClass
	public static void init() {
		factory = new FileSystemXmlApplicationContext("src/Junit-olddata.xml");

	}
	private static int COMPANY_ID = 34;// 所有类容都导入广州公司
	private static String CODE = "tj7_";//标注 每次重新导数 olddb_idlog的my_table标注  修改company_id必须修改CODE
	@Test
	public void test1() {
//846128ms
		try {
			long be = System.currentTimeMillis();
			companyProject();//项目
			propertyProject();//楼盘
		    propertyArea();//区域
			propertyBuild();//楼栋
			propertyBuildbc4();//结构不符合3层结构
			propertyBuildbc5();//同上
			propertyUnit();//单元
			unit2();//单元补充
			unit3();//单元补充
			unit4();//单元补充
			System.out.println((System.currentTimeMillis() - be));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/***
	 * 2013/1/8 楼盘单元操作指引
	 * 
	 * OLD 表相关 DATABASES : company_project 公司项目 楼盘初始_楼盘2 : property_project &
	 * property_area & property_build 根据各种条件转换成三层结构 楼盘初始_单元 : property_unit 单元资料
	 * 
	 * 
	 * 1: DATABASES 所有都当是广州公司的项目录入 2: 楼盘初始_楼盘2 根据1的所属项目 分别导入根楼盘 即 父楼盘ID为空 3: 根据1
	 * 2 结果 导入区域 能找到所有根目录ID为父ID的楼盘 4: 继续循环3的结果 导入楼栋
	 * 
	 * 5: a.循环所有楼栋ID 找到相关UNIT 导入 b.循环所有区域ID 找到相关UNIT 如果有房间复制名字到该区域下面新建一个楼栋
	 * 导入UNIT
	 * 
	 *PS: 所有记录的ID都对应到 OLDID_IDLOG表 缺少的字段可以后期用UPDATE来做
	 * 
	 * 
	 * 
	 *结果: 导入项目101个 完整导入 所有DATEBASE表都算项目
	 * 
	 *8428 949 4级以下 导入楼盘549个 完整导入 没有父级楼盘的都属于楼盘 导入区域2858个 完整导入 上级楼盘属于楼盘的算区域
	 * 导入楼栋4027个 完整导入 上级属于区域的算楼盘 导入单元 355225个 366411 原始数据368238个 查出缺少数据
	 * 楼盘下直接挂的单元没有录入 大约1800条 其他未知导入数据10000左右 当区域下直接有单元的 新建一个下级别楼同导入资料
	 * 
	 *导入客户36732个 缺少非直接属于楼盘的客户3211个
	 * */
	
	// 第一步 导入公司项目
	private void companyProject() {
		try {
			new MyTransationTemplate() {
				@Override
				protected void doExecuteCallback() throws Exception {
					List<KN_DATABASES> kn_dbs = OldDataToSqlUtils
							.getOldDataServices().findKN_DATABASES(null);
					OlddbIdlog olddbIdlog = new OlddbIdlog();
					olddbIdlog.setMyTable(CODE+"company_project_databases");
					CompanyProject cpro;
					for (KN_DATABASES dbs : kn_dbs) {
						cpro = new CompanyProject();
						cpro.setCompanyId(COMPANY_ID);
						cpro.setProjectName(dbs.getDbLongName());
						cpro.setDevCode("customer_guangzhou");
						cpro.setCreatedId(2);
						cpro.setCreatedTime(new Date());
						cpro.setModId(2);
						cpro.setModTime(new Date());
						cpro.setIsDeleted("0");
						cpro.setPinyin("");
						MyPropertyUtils.getCompanyProjectServices()
								.addKnCompanyProject(cpro);

						
						olddbIdlog.setOlddbId(dbs.getDbId() + "");
						olddbIdlog.setMyId(cpro.getId() + "");
						OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(
								olddbIdlog);
					}
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 第二步 导入根节点 楼盘项目
	
	//文档解释  8606548 id为这个的没有DBID 所以少一个
	private void propertyProject() {
		try {
			new MyTransationTemplate() {
				@Override
				protected void doExecuteCallback() throws Exception {
					OlddbIdlogCond cond = new OlddbIdlogCond();
					cond.setMyTable(CODE+"company_project_databases"); // 拿到第一步存储的ID
					List<OlddbIdlog> old_log = OldDataToSqlUtils
							.getOlddbIdlogServices().findOlddbIdlog(cond);

					PropertyProject pro;
					OlddbIdlog olddbIdlog;
					for (OlddbIdlog o : old_log) {

						KN_LPCS_LP2_Cond lp2cond = new KN_LPCS_LP2_Cond();
						lp2cond.setDbId(Integer.parseInt(o.getOlddbId()));
						lp2cond.set上级楼盘ID为空(true);
						List<KN_LPCS_LP2> lpsList = OldDataToSqlUtils
								.getOldDataServices().findKN_LPCS_LP2(lp2cond);

						for (KN_LPCS_LP2 lp2kn : lpsList) {
							pro = new PropertyProject();
							pro.setPropertyName(lp2kn.get名称());
							pro.setParentId(0);
							pro.setDeveloperId(1);
							pro.setCompanyProjectId(Integer.parseInt(o
									.getMyId()));
							pro.setCreatedId(2);
							pro.setCreatedTime(new Date());
							pro.setModId(2);
							pro.setModTime(new Date());
							pro.setIsDeleted("0");
							MyPropertyUtils.getPropertyProjectServices()
									.addPropertyProject(pro);

							olddbIdlog = new OlddbIdlog();
							olddbIdlog.setMyTable(CODE+"company_project_lp2");
							olddbIdlog.setOlddbId(lp2kn.get楼盘id() + "");
							olddbIdlog.setMyId(pro.getId() + "");
							OldDataToSqlUtils.getOlddbIdlogServices()
									.addOlddbIdlog(olddbIdlog);
						}
					}
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 第三步 区域
	private void propertyArea() {
		try {
			new MyTransationTemplate() {
				@Override
				protected void doExecuteCallback() throws Exception {
					OlddbIdlogCond cond = new OlddbIdlogCond();
					cond.setMyTable(CODE+"company_project_lp2"); // 拿到第一步存储的ID
					List<OlddbIdlog> old_log = OldDataToSqlUtils
							.getOlddbIdlogServices().findOlddbIdlog(cond);

					PropertyArea pro;
					OlddbIdlog olddbIdlog;
					for (OlddbIdlog o : old_log) {

						KN_LPCS_LP2_Cond lp2cond = new KN_LPCS_LP2_Cond();
						lp2cond.set上级楼盘ID(Integer.parseInt(o.getOlddbId()));
						List<KN_LPCS_LP2> lpsList = OldDataToSqlUtils
								.getOldDataServices().findKN_LPCS_LP2(lp2cond);

						for (KN_LPCS_LP2 lp2kn : lpsList) {
							pro = new PropertyArea();
							pro.setAreaName(lp2kn.get名称());
							pro.setPropertyId(Integer.parseInt(o.getMyId()));

							pro.setCreatedId(2);
							pro.setCreatedTime(new Date());
							pro.setModId(2);
							pro.setModTime(new Date());
							pro.setIsDeleted("0");
							MyPropertyUtils.getPropertyAreaServices()
									.addPropertyArea(pro);

							olddbIdlog = new OlddbIdlog();
							olddbIdlog.setMyTable(CODE+"company_area_lp2");
							olddbIdlog.setOlddbId(lp2kn.get楼盘id() + "");
							olddbIdlog.setMyId(pro.getId() + "");
							OldDataToSqlUtils.getOlddbIdlogServices()
									.addOlddbIdlog(olddbIdlog);
						}
					}
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 第三步 楼栋
	private void propertyBuild() {
		try {
			new MyTransationTemplate() {
				@Override
				protected void doExecuteCallback() throws Exception {
					OlddbIdlogCond cond = new OlddbIdlogCond();
					cond.setMyTable(CODE+"company_area_lp2"); // 拿到第一步存储的ID
					List<OlddbIdlog> old_log = OldDataToSqlUtils
							.getOlddbIdlogServices().findOlddbIdlog(cond);

					PropertyBuild pro;
					OlddbIdlog olddbIdlog;
					for (OlddbIdlog o : old_log) {

						KN_LPCS_LP2_Cond lp2cond = new KN_LPCS_LP2_Cond();
						lp2cond.set上级楼盘ID(Integer.parseInt(o.getOlddbId()));
						List<KN_LPCS_LP2> lpsList = OldDataToSqlUtils
								.getOldDataServices().findKN_LPCS_LP2(lp2cond);

						for (KN_LPCS_LP2 lp2kn : lpsList) {
							pro = new PropertyBuild();
							pro.setBuildName(lp2kn.get名称());
							pro.setAreaId(Integer.parseInt(o.getMyId()));
							pro.setChipType("");

							pro.setCreatedId(2);
							pro.setCreatedTime(new Date());
							pro.setModId(2);
							pro.setModTime(new Date());
							pro.setIsDeleted("0");
							MyPropertyUtils.getPropertyBuildServices()
									.addKnPropertyBuild(pro);

							olddbIdlog = new OlddbIdlog();
							olddbIdlog.setMyTable(CODE+"company_build_lp2");
							olddbIdlog.setOlddbId(lp2kn.get楼盘id() + "");
							olddbIdlog.setMyId(pro.getId() + "");
							OldDataToSqlUtils.getOlddbIdlogServices()
									.addOlddbIdlog(olddbIdlog);
						}
					}
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 第三步 楼栋 的补充 应为KN有4层5层结构
	private void propertyBuildbc4() {
		try {
			new MyTransationTemplate() {
				@Override
				protected void doExecuteCallback() throws Exception {
					// 4层结构 找到该楼栋的上2级 area 挂在下面 名称修改为 3层-4层
					List<KN_LPCS_LP2> lp24 = OldDataToSqlUtils
							.getOldDataServices().findKN_LPCS_LP2_4ceng();

					PropertyBuild sjpro;// 3级BUILD下还有4级楼盘2资料下面在我们数据库的BUILD
					PropertyBuild pro;// 4级楼栋
					OlddbIdlogCond oldcond;
					OlddbIdlog sjolddbIdlog;// 3级楼栋的ID对应资料
					OlddbIdlog olddbIdlog;
					OlddbIdlog olddbIdlog2;
					for (KN_LPCS_LP2 c4lp2 : lp24) {
						oldcond = new OlddbIdlogCond();
						oldcond.setOldId(c4lp2.get上级楼盘id().intValue());
						oldcond.setMyTable(CODE+"company_build_lp2");
						// 需要与他同层
						sjolddbIdlog = OldDataToSqlUtils
								.getOlddbIdlogServices()
								.findOlddbIdlogByOldIdAndTableName(oldcond);

						sjpro = MyPropertyUtils.getPropertyBuildServices()
								.findPropertyBuildById(Integer.parseInt(sjolddbIdlog.getMyId()));

						pro = new PropertyBuild();
						pro.setBuildName(sjpro.getBuildName() + "-"
								+ c4lp2.get名称());
						pro.setAreaId(sjpro.getAreaId());
						pro.setChipType("");

						pro.setCreatedId(2);
						pro.setCreatedTime(new Date());
						pro.setModId(2);
						pro.setModTime(new Date());
						pro.setIsDeleted("0");
						MyPropertyUtils.getPropertyBuildServices()
								.addKnPropertyBuild(pro);

						olddbIdlog = new OlddbIdlog();
						olddbIdlog.setMyTable(CODE+"company_build_lp2");
						olddbIdlog.setOlddbId(c4lp2.get楼盘id() + "");
						olddbIdlog.setMyId(pro.getId() + "");
						OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(
								olddbIdlog);

						olddbIdlog2 = new OlddbIdlog();
						olddbIdlog2.setMyTable(CODE+"company_build_lp2_bc");
						olddbIdlog2.setOlddbId(c4lp2.get楼盘id() + "");
						olddbIdlog2.setMyId(pro.getId() + "");
						OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(
								olddbIdlog2);
					}

				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void propertyBuildbc5() {
		try {
			new MyTransationTemplate() {
				@Override
				protected void doExecuteCallback() throws Exception {
					// 4层结构 找到该楼栋的上2级 area 挂在下面 名称修改为 3层-4层
					List<KN_LPCS_LP2> lp24 = OldDataToSqlUtils
							.getOldDataServices().findKN_LPCS_LP2_5ceng();// 找到5层结构

					PropertyBuild sjpro;// 3级BUILD下还有4级楼盘2资料下面在我们数据库的BUILD
					PropertyBuild pro;// 4级楼栋
					OlddbIdlogCond oldcond;
					OlddbIdlog sjolddbIdlog;// 3级楼栋的ID对应资料
					OlddbIdlog olddbIdlog;
					OlddbIdlog olddbIdlog2;

					KN_LPCS_LP2 ce4old;
					KN_LPCS_LP2 ce3old;
					for (KN_LPCS_LP2 c4lp2 : lp24) {
						ce4old = OldDataToSqlUtils.getOldDataServices()
								.findKN_LPCS_LP2_byId(c4lp2.get上级楼盘id().intValue());
						ce3old = OldDataToSqlUtils.getOldDataServices()
								.findKN_LPCS_LP2_byId(ce4old.get上级楼盘id().intValue());

						oldcond = new OlddbIdlogCond();
						oldcond.setOldId(ce3old.get楼盘id().intValue());
						oldcond.setMyTable(CODE+"company_build_lp2");
						// 需要与他同层
						sjolddbIdlog = OldDataToSqlUtils
								.getOlddbIdlogServices()
								.findOlddbIdlogByOldIdAndTableName(oldcond);

						sjpro = MyPropertyUtils.getPropertyBuildServices()
								.findPropertyBuildById(Integer.parseInt(sjolddbIdlog.getMyId()));

						pro = new PropertyBuild();
						pro.setBuildName(ce3old.get名称() + "-" + ce4old.get名称()
								+ "-" + c4lp2.get名称());
						pro.setAreaId(sjpro.getAreaId());
						pro.setChipType("");

						pro.setCreatedId(2);
						pro.setCreatedTime(new Date());
						pro.setModId(2);
						pro.setModTime(new Date());
						pro.setIsDeleted("0");
						MyPropertyUtils.getPropertyBuildServices()
								.addKnPropertyBuild(pro);

						olddbIdlog = new OlddbIdlog();
						olddbIdlog.setMyTable(CODE+"company_build_lp2");
						olddbIdlog.setOlddbId(c4lp2.get楼盘id() + "");
						olddbIdlog.setMyId(pro.getId() + "");
						OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(
								olddbIdlog);

						olddbIdlog2 = new OlddbIdlog();
						olddbIdlog2.setMyTable(CODE+"company_build_lp2_bc");
						olddbIdlog2.setOlddbId(c4lp2.get楼盘id() + "");
						olddbIdlog2.setMyId(pro.getId() + "");
						OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(
								olddbIdlog2);
					}
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 第三步 单元
	// 两步 1 所有BUILD
	// 2所有AREA 有房间的话新建一个同名称BUILD
	
	//地二次导数 61269
	private void propertyUnit() {
		// 1 找出所有BUILD所属的单元添加进去
		try {
			OlddbIdlogCond cond = new OlddbIdlogCond();
		//	cond.setMyTable(CODE+"company_build_lp2"); // 拿到第一步存储的ID
			cond.setMyTable(CODE+"company_build_lp2"); // 拿到第一步存储的ID
			final List<OlddbIdlog> old_log = OldDataToSqlUtils
					.getOlddbIdlogServices().findOlddbIdlog(cond);

			
				
				new MyTransationTemplate() {
					@Override
					protected void doExecuteCallback() throws Exception {
						for (int i = 0; i < old_log.size(); i++) {
						OlddbIdlog o = old_log.get(i);
						OlddbIdlog olddbIdlog;
						olddbIdlog = new OlddbIdlog();
						olddbIdlog.setMyTable(CODE+"company_unit_lp2");
						
						PropertyUnit unit;
						
						List<KN_LPCS_DY> dyList = null;
						KN_LPCS_DY_Cond dycond = new KN_LPCS_DY_Cond();
						dycond.set楼阁ID(Integer.parseInt(o.getOlddbId()));
						dyList = OldDataToSqlUtils.getOldDataServices()
								.findKN_LPCS_DY(dycond);
						if (dyList.size() > 0) {// 区域下面有单元

							for (KN_LPCS_DY lp2kn : dyList) {
								unit = new PropertyUnit();
								unit.setBuildId(Integer.parseInt(o.getMyId()));
								unit.setBuildArea(lp2kn.get建筑面积());
								unit.setInsideArea(lp2kn.get套内面积());
								unit.setSumPrice(lp2kn.get总价());
								unit.setUnitNo(lp2kn.get单元编号());
								unit.setFloorNum(""+lp2kn.get楼层().intValue());
								unit.setRoomNo(lp2kn.get房号());

								unit.setCreatedId(2);
								unit.setCreatedTime(new Date());
								unit.setModId(2);
								unit.setModTime(new Date());
								unit.setIsDeleted("0");

								MyPropertyUtils.getPropertyUnitServices()
										.addKnPropertyUnit(unit);

								
								olddbIdlog.setOlddbId(lp2kn.get单元id() + "");
								olddbIdlog.setMyId(unit.getId() + "");
								OldDataToSqlUtils.getOlddbIdlogServices()
										.addOlddbIdlog(olddbIdlog);
							}
							dyList.clear();
						}
						}
					}
				}.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * tj1 62070
	 * */
	public void unit2(){
		try {
			OlddbIdlogCond cond = new OlddbIdlogCond();
			cond.setMyTable(CODE+"company_property_lp2"); // 拿到第一步存储的ID
			List<OlddbIdlog> old_log = OldDataToSqlUtils.getOlddbIdlogServices()
					.findOlddbIdlog(cond);

			for (int i = 0; i < old_log.size(); i++) {
				final OlddbIdlog o = old_log.get(i);
				new MyTransationTemplate() {
					PropertyArea inArea;
					PropertyBuild pro;
					OlddbIdlog olddbIdlog;
					PropertyUnit unit;
					List<KN_LPCS_DY> dyList;

					@Override
					protected void doExecuteCallback() throws Exception {
						KN_LPCS_DY_Cond dycond = new KN_LPCS_DY_Cond();
						dycond.set楼阁ID(Integer.parseInt(o.getOlddbId()));
						dyList = OldDataToSqlUtils.getOldDataServices()
								.findKN_LPCS_DY(dycond);

						if (dyList.size() > 0) {// 区域下面有单元
							inArea = new PropertyArea();
							inArea.setIsDeleted("0");
							inArea.setCreatedId(2);
							inArea.setCreatedTime(new Date());
							inArea.setModId(2);
							inArea.setModTime(new Date());
							inArea.setPropertyId(Integer.parseInt(o.getMyId()));
							PropertyProject project = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectById(Integer.parseInt(o.getMyId()));
							inArea.setAreaName(project.getPropertyName());
							MyPropertyUtils.getPropertyAreaServices().addPropertyArea(inArea);
							olddbIdlog = new OlddbIdlog();
							olddbIdlog.setMyTable(CODE+"company_area_lp2_unit2");
							olddbIdlog.setOlddbId(o.getOlddbId());
							olddbIdlog.setMyId(inArea.getId() + "");
							OldDataToSqlUtils.getOlddbIdlogServices()
									.addOlddbIdlog(olddbIdlog);
							
							
							pro = new PropertyBuild();
							pro.setBuildName(project.getPropertyName());
							pro.setAreaId(inArea.getId());
							pro.setChipType("");
							pro.setCreatedId(2);
							pro.setCreatedTime(new Date());
							pro.setModId(2);
							pro.setModTime(new Date());
							pro.setIsDeleted("0");
							MyPropertyUtils.getPropertyBuildServices()
									.addKnPropertyBuild(pro);
							

							olddbIdlog = new OlddbIdlog();
							olddbIdlog.setMyTable(CODE+"company_build_lp2_unit2");
							olddbIdlog.setOlddbId(o.getOlddbId());
							olddbIdlog.setMyId(pro.getId() + "");
							OldDataToSqlUtils.getOlddbIdlogServices()
									.addOlddbIdlog(olddbIdlog);

							for (KN_LPCS_DY lp2kn : dyList) {
								unit = new PropertyUnit();
								unit.setBuildId(pro.getId());
								unit.setBuildArea(lp2kn.get建筑面积());
								unit.setInsideArea(lp2kn.get套内面积());
								unit.setSumPrice(lp2kn.get总价());
								unit.setUnitNo(lp2kn.get单元编号());
								unit.setFloorNum(""+lp2kn.get楼层().intValue());
								unit.setRoomNo(lp2kn.get房号());

								unit.setCreatedId(2);
								unit.setCreatedTime(new Date());
								unit.setModId(2);
								unit.setModTime(new Date());
								unit.setIsDeleted("0");

								MyPropertyUtils.getPropertyUnitServices()
										.addKnPropertyUnit(unit);

								olddbIdlog = new OlddbIdlog();
								olddbIdlog.setMyTable(CODE+"company_unit_lp2");
								olddbIdlog.setOlddbId(lp2kn.get单元id() + "");
								olddbIdlog.setMyId(unit.getId() + "");
								OldDataToSqlUtils.getOlddbIdlogServices()
										.addOlddbIdlog(olddbIdlog);
							}
							dyList.clear();
						}
					}
				}.execute();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	//tj1 75058
	public void unit3(){
		// 2 查找所有区域所属单元 如果有 则新建一个下属同名称楼栋 然后把单元放在其下面 对照ID也加上
		try {
			OlddbIdlogCond cond = new OlddbIdlogCond();
			cond.setMyTable(CODE+"company_area_lp2"); // 拿到第一步存储的ID
			List<OlddbIdlog> old_log = OldDataToSqlUtils.getOlddbIdlogServices()
					.findOlddbIdlog(cond);

			for (int i = 0; i < old_log.size(); i++) {
				final OlddbIdlog o = old_log.get(i);
				new MyTransationTemplate() {
					PropertyBuild pro;
					OlddbIdlog olddbIdlog;
					PropertyUnit unit;
					List<KN_LPCS_DY> dyList;

					@Override
					protected void doExecuteCallback() throws Exception {
						KN_LPCS_DY_Cond dycond = new KN_LPCS_DY_Cond();
						dycond.set楼阁ID(Integer.parseInt(o.getOlddbId()));
						dyList = OldDataToSqlUtils.getOldDataServices()
								.findKN_LPCS_DY(dycond);

						if (dyList.size() > 0) {// 区域下面有单元
							pro = new PropertyBuild();
							pro.setBuildName(MyPropertyUtils
									.getPropertyAreaServices()
									.findPropertyAreaById(
											Integer.parseInt(o.getMyId()))
									.getAreaName());
							pro.setAreaId(Integer.parseInt(o.getMyId()));
							pro.setChipType("");
							pro.setCreatedId(2);
							pro.setCreatedTime(new Date());
							pro.setModId(2);
							pro.setModTime(new Date());
							pro.setIsDeleted("0");
							MyPropertyUtils.getPropertyBuildServices()
									.addKnPropertyBuild(pro);

							olddbIdlog = new OlddbIdlog();
							olddbIdlog.setMyTable(CODE+"company_build_lp2_unit3");
							olddbIdlog.setOlddbId(o.getOlddbId());
							olddbIdlog.setMyId(pro.getId() + "");
							OldDataToSqlUtils.getOlddbIdlogServices()
									.addOlddbIdlog(olddbIdlog);

							for (KN_LPCS_DY lp2kn : dyList) {
								unit = new PropertyUnit();
								unit.setBuildId(pro.getId());
								unit.setBuildArea(lp2kn.get建筑面积());
								unit.setInsideArea(lp2kn.get套内面积());
								unit.setSumPrice(lp2kn.get总价());
								unit.setUnitNo(lp2kn.get单元编号());
								unit.setFloorNum(""+lp2kn.get楼层().intValue());
								unit.setRoomNo(lp2kn.get房号());

								unit.setCreatedId(2);
								unit.setCreatedTime(new Date());
								unit.setModId(2);
								unit.setModTime(new Date());
								unit.setIsDeleted("0");

								MyPropertyUtils.getPropertyUnitServices()
										.addKnPropertyUnit(unit);

								olddbIdlog = new OlddbIdlog();
								olddbIdlog.setMyTable(CODE+"company_unit_lp2");
								olddbIdlog.setOlddbId(lp2kn.get单元id() + "");
								olddbIdlog.setMyId(unit.getId() + "");
								OldDataToSqlUtils.getOlddbIdlogServices()
										.addOlddbIdlog(olddbIdlog);
							}
							dyList.clear();
						}
					}
				}.execute();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 楼盘下直接挂的单元
	 * 下推一个分区直接  楼盘名-楼盘名
	 * 下推一个楼栋 楼      楼盘名-楼盘名-楼盘名
	 * */
	public void unit4(){
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					// TODO Auto-generated method stub
					
				
		
		OlddbIdlogCond cond = new OlddbIdlogCond();
		cond.setMyTable(CODE+"company_project_lp2"); // 拿到第一步存储的ID
		List<OlddbIdlog> old_log = OldDataToSqlUtils
				.getOlddbIdlogServices().findOlddbIdlog(cond);
		
		//循环楼盘 去查找有没有下属单元 OLD
		for(OlddbIdlog o : old_log){
			KN_LPCS_DY_Cond dycond = new KN_LPCS_DY_Cond();
			dycond.set楼阁ID(Integer.parseInt(o.getOlddbId()));
			List<KN_LPCS_DY> dyList = OldDataToSqlUtils.getOldDataServices()
					.findKN_LPCS_DY(dycond);
			
			OlddbIdlog log =  new OlddbIdlog();
			if(dyList == null || dyList.size() == 0)continue;//没有找到单元就推出这次
			
			PropertyProject pro = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectById(Integer.parseInt(o.getMyId()));//有下属单元的 导入的楼盘
			
			//有的情况 先建立一个下属区域 
			PropertyArea area = new PropertyArea();
			Date now = new Date();
			area.setIsDeleted("0");
			area.setCreatedId(2);
			area.setCreatedTime(now);
			area.setModId(2);
			area.setModTime(now);
			
			area.setPropertyId(pro.getId());
			area.setAreaName(pro.getPropertyName() + "-" +pro.getPropertyName());
			MyPropertyUtils.getPropertyAreaServices().addPropertyArea(area);
			log.setMyTable(CODE+"company_area_lp2_unit4");
			log.setOlddbId(o.getOlddbId());
			log.setMyId(area.getModId()+"");
			OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(log);
			//建立一个下属的楼栋
			PropertyBuild build = new PropertyBuild();
			build.setIsDeleted("0");
			build.setCreatedId(2);
			build.setCreatedTime(now);
			build.setModId(2);
			build.setModTime(now);
			
			build.setChipType("1");
			build.setBuildName(pro.getPropertyName() + "-" +pro.getPropertyName()+ "-" +pro.getPropertyName());
			build.setAreaId(area.getId());
			MyPropertyUtils.getPropertyBuildServices().addKnPropertyBuild(build);
			log.setMyTable(CODE+"company_build_lp2_unit4");
			log.setOlddbId(o.getOlddbId());
			log.setMyId(area.getModId()+"");
			OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(log);
			
			//开始存单元
			PropertyUnit unit = new PropertyUnit();
			for (KN_LPCS_DY lp2kn : dyList) {
				unit.setBuildId(pro.getId());
				unit.setBuildArea(lp2kn.get建筑面积());
				unit.setInsideArea(lp2kn.get套内面积());
				unit.setSumPrice(lp2kn.get总价());
				unit.setUnitNo(lp2kn.get单元编号());
				unit.setFloorNum(""+lp2kn.get楼层().intValue());
				unit.setRoomNo(lp2kn.get房号());

				unit.setCreatedId(2);
				unit.setCreatedTime(new Date());
				unit.setModId(2);
				unit.setModTime(new Date());
				unit.setIsDeleted("0");

				MyPropertyUtils.getPropertyUnitServices()
						.addKnPropertyUnit(unit);

				log = new OlddbIdlog();
				log.setMyTable(CODE+"company_unit_lp2");
				log.setOlddbId(lp2kn.get单元id() + "");
				log.setMyId(unit.getId() + "");
				OldDataToSqlUtils.getOlddbIdlogServices()
						.addOlddbIdlog(log);
			}
			
		}
				}
			}.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 参考 已经没有使用
	// /**
	// * 楼盘项目
	// *
	// * 相关表
	// * 楼盘初始_楼盘2 T1
	// * 楼盘详细资料 : 楼盘初始_楼盘2_属性 T2
	// * 条件 T1没有上级楼盘ID is null 的都属于楼盘层次
	// * */
	// private void project(){
	// KN_LPCS_LP2_Cond cond = new KN_LPCS_LP2_Cond();
	// cond.set上级楼盘ID为空(true);
	// final List<KN_LPCS_LP2> dyList =
	// OldDataToSqlUtils.getOldDataServices().findKN_LPCS_LP2(cond);
	//		
	// OlddbIdlog olddbIdlog;
	// PropertyProject pr ;
	// for(KN_LPCS_LP2 lp2 : dyList){
	// pr = new PropertyProject();
	// pr.setPropertyName(lp2.get名称());
	// pr.setDeveloperId(0);
	// pr.setParentId(0);
	//			
	// pr.setIsDeleted("0");
	// pr.setCreatedId(2);
	// pr.setCreatedTime(new Date());
	// pr.setModId(2);
	// pr.setModTime(new Date());
	// pr.setCompanyProjectId(141);//广州KN导0108
	// OldDataToSqlUtils.getPropertyProjectServices().addPropertyProject(pr);
	//			
	// olddbIdlog = new OlddbIdlog();
	// olddbIdlog.setMyTable(CODE+"property_project_LPCS_LP2");
	// olddbIdlog.setOlddbId(lp2.get楼盘id() + "");
	// olddbIdlog.setMyId(pr.getId()+"");
	// OldDataToSqlUtils .getOlddbIdlogServices().addOlddbIdlog(olddbIdlog);
	// }
	// }
	//	
	// /**
	// * 楼盘区域
	// *
	// * 相关表
	// * 楼盘初始_楼盘2 T1
	// * 楼盘详细资料 : 楼盘初始_楼盘2_属性 T2
	// * 条件 根据现有 对照ID 找到所有楼盘 然后逐条搜索 以该ID为上级ID的楼盘 批量插入
	// * */
	// private void area(){
	// try {
	// new MyTransationTemplate() {
	//				
	// @Override
	// protected void doExecuteCallback() throws Exception {
	// // TODO Auto-generated method stub
	// OlddbIdlogCond cond = new OlddbIdlogCond();
	// cond.setMyTable(CODE+"property_project_LPCS_LP2");
	// List<OlddbIdlog> idlog = OldDataToSqlUtils
	// .getOlddbIdlogServices().findOlddbIdlog(cond);
	// OlddbIdlog olddbIdlog;
	// PropertyArea ar ;
	// for(OlddbIdlog lp2 : idlog){
	// KN_LPCS_LP2_Cond lp2cond = new KN_LPCS_LP2_Cond();
	// lp2cond.set上级楼盘ID(Integer.parseInt(lp2.getOlddbId()));
	// List<KN_LPCS_LP2> areaLp2List =
	// OldDataToSqlUtils.getOldDataServices().findKN_LPCS_LP2(lp2cond);
	//						
	// for(KN_LPCS_LP2 arlp2 : areaLp2List){
	// ar = new PropertyArea();
	// ar.setAreaName(arlp2.get名称());
	// ar.setPropertyId(Integer.parseInt(lp2.getMyId()));
	//							
	// ar.setIsDeleted("0");
	// ar.setCreatedId(2);
	// ar.setCreatedTime(new Date());
	// ar.setModId(2);
	// ar.setModTime(new Date());
	// ar.setCompanyProjectId(141);
	// OldDataToSqlUtils.getPropertyAreaServices().addPropertyArea(ar);
	//							
	// olddbIdlog = new OlddbIdlog();
	// olddbIdlog.setMyTable(CODE+"property_area_LPCS_LP2");
	// olddbIdlog.setOlddbId(arlp2.get楼盘id() + "");
	// olddbIdlog.setMyId(ar.getId()+"");
	// OldDataToSqlUtils .getOlddbIdlogServices().addOlddbIdlog(olddbIdlog);
	// }
	// }
	// }
	// }.execute();
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//	
	//	
	// /**
	// * 楼栋
	// *
	// * 相关表
	// * 楼盘初始_楼盘2 T1
	// * 楼盘详细资料 : 楼盘初始_楼盘2_属性 T2
	// * 条件 根据现有 对照ID
	// * */
	// private void build(){
	// try {
	// new MyTransationTemplate() {
	//				
	// @Override
	// protected void doExecuteCallback() throws Exception {
	// // TODO Auto-generated method stub
	// OlddbIdlogCond cond = new OlddbIdlogCond();
	// cond.setMyTable(CODE+"property_area_LPCS_LP2");
	// List<OlddbIdlog> idlog = OldDataToSqlUtils
	// .getOlddbIdlogServices().findOlddbIdlog(cond);
	// OlddbIdlog olddbIdlog;
	// PropertyArea ar ;
	// for(OlddbIdlog lp2 : idlog){
	// KN_LPCS_LP2_Cond lp2cond = new KN_LPCS_LP2_Cond();
	// lp2cond.set上级楼盘ID(Integer.parseInt(lp2.getOlddbId()));
	// List<KN_LPCS_LP2> areaLp2List =
	// OldDataToSqlUtils.getOldDataServices().findKN_LPCS_LP2(lp2cond);
	//						
	// for(KN_LPCS_LP2 arlp2 : areaLp2List){
	// ar = new PropertyArea();
	// ar.setAreaName(arlp2.get名称());
	// ar.setPropertyId(Integer.parseInt(lp2.getMyId()));
	//							
	// ar.setIsDeleted("0");
	// ar.setCreatedId(2);
	// ar.setCreatedTime(new Date());
	// ar.setModId(2);
	// ar.setModTime(new Date());
	// ar.setCompanyProjectId(141);
	// OldDataToSqlUtils.getPropertyAreaServices().addPropertyArea(ar);
	//							
	// olddbIdlog = new OlddbIdlog();
	// olddbIdlog.setMyTable(CODE+"property_area_LPCS_LP2");
	// olddbIdlog.setOlddbId(arlp2.get楼盘id() + "");
	// olddbIdlog.setMyId(ar.getId()+"");
	// OldDataToSqlUtils .getOlddbIdlogServices().addOlddbIdlog(olddbIdlog);
	// }
	// }
	// }
	// }.execute();
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
