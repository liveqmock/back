package com.kn.action;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.h2.util.New;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.kn.data.pojo.OlddbIdlog;
import com.ihk.kn.data.pojo.OlddbIdlogCond;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.kn.data.pojo.KN_KHGXGL_KH;
import com.kn.data.pojo.KN_KHGXGL_KH_Cond;

/**
 * junit测试类
 * 
 * @author peter 2012-9-29
 */
public class DaoShuShouQianCustomer {

	private static FileSystemXmlApplicationContext factory;

	@BeforeClass
	public static void init() {
		factory = new FileSystemXmlApplicationContext("src/Junit-olddata.xml");
		CODE = Tjvison.TJ1;
	}

	@Test
	public void test1() {

		try {
			long be = System.currentTimeMillis();

			 List<PropertyProject> cpList =
			 MyPropertyUtils.getPropertyProjectServices().findPropertyProject(new
			 PropertyProjectCond());
			 Map<Integer, PropertyProject> cpMap = new HashMap<Integer,
			 PropertyProject>();
			
			 for(PropertyProject pp : cpList){
			 cpMap.put(pp.getId(), pp);
			 }
			 for(int min = 0;min < 380001;){
			 customer(min,min+10000,cpMap);
			 min =min+10000;
			 }

			customer1();
			customerwenjuan();
			customerwenjuan1();
			System.out.println((System.currentTimeMillis() - be));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String CODE;

	/**
	 * customer 客户关系管理_客户
	 * */
	public void customer(int min, int max,
			final Map<Integer, PropertyProject> cpMap) {
		KN_KHGXGL_KH_Cond khcond = new KN_KHGXGL_KH_Cond();
		khcond.setLimitmin(min);
		khcond.setLimitmax(max);
		final List<KN_KHGXGL_KH> khList = OldDataToSqlUtils
				.getOldDataServices().findKnKhgxglKh(khcond);

		try {
			new MyTransationTemplate() {
				@Override
				protected void doExecuteCallback() throws Exception {

					// Map<Integer, PropertyProject> cpMap = new
					// HashMap<Integer, PropertyProject>();
					//
					// for(PropertyProject pp : cpList){
					// cpMap.put(pp.getId(), pp);
					// }
					// cpList.clear();

					OlddbIdlogCond oldcond = new OlddbIdlogCond();
					oldcond.setMyTable(CODE + "company_project_lp2");
					List<OlddbIdlog> olddb = OldDataToSqlUtils
							.getOlddbIdlogServices().findOlddbIdlog(oldcond);

					Map<Integer, Integer> oldMap = new HashMap<Integer, Integer>();
					for (OlddbIdlog oo : olddb) {
						oldMap.put(Integer.parseInt(oo.getOlddbId()), Integer
								.parseInt(oo.getMyId()));
					}

					Customer cust;
					OlddbIdlog olddbIdlog;
					for (KN_KHGXGL_KH kh : khList) {

						cust = new Customer();
						PropertyProject pp = cpMap.get(oldMap.get(kh.get楼盘id()
								.intValue()));
						if (pp == null) {
							continue;
						}
						cust.setProjectId(pp.getCompanyProjectId());
						cust.setCompanyId(0);

						cust.setTeamId(0);
						cust.setUserId(2);

						cust.setCustomerName(kh.get姓名());
						cust.setAddress(kh.get住址());
						cust.setPhone(kh.get移动电话() == null ? "" : kh.get移动电话());
						cust.setHomePhone(kh.get电话());
						cust.setRemark1(kh.get备注());
						cust.setCustomerNo("KN");

						cust.setIsDeleted("0");
						cust.setCreatedId(2);
						cust.setModId(2);
						cust.setCreatedTime(new Date());
						cust.setModTime(new Date());

						DescUtils.getCustomerServices().saveKnCustomer(cust);

						olddbIdlog = new OlddbIdlog();
						olddbIdlog.setMyTable(CODE + "customer");
						olddbIdlog.setOlddbId(kh.get客户id() + "");
						olddbIdlog.setMyId(cust.getId() + "");
						OldDataToSqlUtils.getOlddbIdlogServices()
								.addOlddbIdlog(olddbIdlog);

					}
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * customer 客户关系管理_客户补充 因为小部分客是属于区域
	 * */
	public void customer1() {

		try {
			new MyTransationTemplate() {
				@Override
				protected void doExecuteCallback() throws Exception {
					List<KN_KHGXGL_KH> khList = OldDataToSqlUtils
							.getOldDataServices().findKnKhgxglKh_quyu();

					// List<PropertyArea> cpList
					// =MyPropertyUtils.getPropertyAreaServices().findPropertyArea(null);
					//					
					// Map<Integer, PropertyArea> cpMap = new HashMap<Integer,
					// PropertyArea>();
					//
					// for(PropertyArea pp : cpList){
					// cpMap.put(pp.getId(), pp);
					// }

					// OlddbIdlogCond oldcond = new OlddbIdlogCond();
					// oldcond.setMyTable(CODE+"company_area_lp2");
					// List<OlddbIdlog> olddb = OldDataToSqlUtils
					// .getOlddbIdlogServices()
					// .findOlddbIdlog(oldcond);
					//					
					// Map<Integer, Integer> oldMap = new HashMap<Integer,
					// Integer>();
					// for(OlddbIdlog oo :olddb){
					// oldMap.put(Integer.parseInt(oo.getOlddbId()),
					// Integer.parseInt(oo.getMyId()));
					// }

					Customer cust;
					OlddbIdlog olddbIdlog;
					for (KN_KHGXGL_KH kh : khList) {
						IPropertyAreaServices se = MyPropertyUtils
								.getPropertyAreaServices();
						cust = new Customer();
						// PropertyArea pp =
						// cpMap.get(oldMap.get(kh.get楼盘id().intValue()) );
						// Integer ss = oldMap.get(kh.get楼盘id());
						// if(null == ss)continue;
						OlddbIdlogCond tcond = new OlddbIdlogCond();
						tcond.setMyTable(CODE + "company_area_lp2");
						tcond.setOldId(kh.get楼盘id().intValue());
						OlddbIdlog tolddbIdlog = OldDataToSqlUtils
								.getOlddbIdlogServices()
								.findOlddbIdlogByOldIdAndTableName(tcond);
						if (null == tolddbIdlog) {
							continue;
						}
						PropertyArea pp = se.findPropertyAreaById(Integer
								.parseInt(tolddbIdlog.getMyId()));
						if (pp == null) {
							continue;
						}
						cust.setProjectId(pp.getCompanyProjectId());
						cust.setCompanyId(0);

						cust.setTeamId(0);
						cust.setUserId(2);

						cust.setCustomerName(kh.get姓名());
						cust.setAddress(kh.get住址());
						cust.setPhone(kh.get移动电话() == null ? "" : kh.get移动电话());
						cust.setHomePhone(kh.get电话());
						cust.setRemark1(kh.get备注());
						cust.setCustomerNo("KN");

						cust.setIsDeleted("0");
						cust.setCreatedId(2);
						cust.setModId(2);
						cust.setCreatedTime(new Date());
						cust.setModTime(new Date());

						DescUtils.getCustomerServices().saveCustomer(cust);

						olddbIdlog = new OlddbIdlog();
						olddbIdlog.setMyTable(CODE + "customer");
						olddbIdlog.setOlddbId(kh.get客户id() + "");
						olddbIdlog.setMyId(cust.getId() + "");
						OldDataToSqlUtils.getOlddbIdlogServices()
								.addOlddbIdlog(olddbIdlog);
					}
				}
			}.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 问卷调查 进备注 findwenjuan 分多次查询
	 * */
	public void customerwenjuan() {
		try {
			new MyTransationTemplate() {

				@Override
				protected void doExecuteCallback() throws Exception {
					// TODO Auto-generated method stub

					List<Map<String, Object>> wenjuan = OldDataToSqlUtils
							.getOldDataServices().findwenjuan();
					// 组成 {id : 问卷字段} 的MAP
					Map<String, String> beizhu = new HashMap<String, String>();
					for (Map<String, Object> p : wenjuan) {

						String kid = p.get("ID").toString();
						String kwen = p.get("KWEN") == null ? "" : p
								.get("KWEN").toString();
						String kda = p.get("KDA") == null ? "" : p.get("KDA")
								.toString();
						String endda = "";

						String[] lda = kda.split("\n");
						if (lda.length > 1) {
							for (String r : lda) {
								endda = endda + r + ",";
							}
						} else {
							endda = kda;
						}

						if (beizhu.get(kid) == null) {
							beizhu.put(kid, kwen + ":" + endda);
						} else {
							String oldString = beizhu.get(kid);
							oldString = oldString +"\n"+ kwen + ":" + endda;
							beizhu.put(kid, oldString);
						}
					}
					wenjuan.clear();
					// 找到客户ID做循环 插入customer.remark字段
					for (int i = 0; i <= 380001; i += 50000) {
						OlddbIdlogCond cond = new OlddbIdlogCond();
						cond.setMyTable(CODE + "customer");
						cond.startLine = i;
						cond.topNum = i + 10000;
						List<OlddbIdlog> idloglist = OldDataToSqlUtils
								.getOlddbIdlogServices().findOlddbIdlog(cond);
						if (idloglist.size() == 0)
							break;
						for (OlddbIdlog o : idloglist) {

							String remark = beizhu.get(o.getOlddbId());
							if (remark == null || remark.length() > 7000)
								continue;

							Map p = new HashMap<String, String>();
							p.put("id", o.getMyId());
							p.put("remark", remark);
							DescUtils.getCustomerServices().knAddRemark(p);
							p.clear();
						}

						idloglist.clear();
					}
				}
			}.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public void customerwenjuan1() {
		final List<Map> updateMap = new LinkedList<Map>();
		final List<Map<String, Integer>> listmap = OldDataToSqlUtils
				.getOlddbIdlogServices()
				.findIdMapByTableName(CODE + "customer");
		for (Map<String, Integer> p : listmap) {
			
			List<Map> wenjuanList = OldDataToSqlUtils.getOlddbIdlogServices().findQuestionByCustomerId(p.get("oid"));
			
			StringBuffer s = null;
			if (wenjuanList.size() > 0) {
				for (Map sp : wenjuanList) {
					s = new StringBuffer();
					s.append("\n").append(
							sp.get("val") == null ? "" : sp.get("val")
									.toString().replace("\n", ""));
				}
				Map res = new HashMap();
				if (s != null && s.length() < 7000) {
					res.put("id", p.get("mid"));
					res.put("remark", s.toString());
					updateMap.add(res);
				}
			}
		}
		
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {

			for(Map p :updateMap){
				DescUtils.getCustomerServices().knAddRemark(p);
			}
			
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		System.out.println("\ndfddfdf\nfdfdf");
		System.out.println("\ndfddfdf\nfdfdf".replace("\n", ""));
	}

}
