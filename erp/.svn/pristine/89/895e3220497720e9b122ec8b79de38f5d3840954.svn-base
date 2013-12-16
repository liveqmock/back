package com.kn.action;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.kn.data.pojo.OlddbIdlog;
import com.ihk.kn.data.pojo.OlddbIdlogCond;
import com.ihk.property.data.pojo.PayWay;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.Region;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.kn.data.pojo.KN_KHGXGL_KH;
import com.kn.data.pojo.KN_LPCS_DY;
import com.kn.data.pojo.KN_LPCS_DY_Cond;
import com.kn.data.pojo.KN_XSGL_RGS;

/**
 * junit测试类
 * @author peter
 * 2012-9-29
 */
public class OldDataToSqlAddCom {
	
	private static FileSystemXmlApplicationContext factory;
	
	@BeforeClass
	public static void init(){		
		factory = new FileSystemXmlApplicationContext(
				"src/Junit-olddata.xml");		
		
	}
	
	@Test
	public void test1(){
		
		try {
			Long g = System.currentTimeMillis();
//			List<KN_KHGXGL_KH> khList = 
//			OldDataToSqlUtils.getOldDataServices().findKnKhgxglKh(null);
			addCustomer();//地址 有sql直接实现
			addUnitCom();//产品类型 装修标准 等等 字段 有sql直接实现
			addpayway();//付款方式
			addConfirm();//认购书号等补充
			freezeUnit();//冻结单元状态
			System.out.println((System.currentTimeMillis() - g)/1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	static String CODE = "tj6_";
	
	/**
	 * 补充字段 客户关系管理_客户   customer
	 * 
	 * 主要补充各种地址
	 * */
	public void addCustomer(){
		//复制 地址资料到CUSTOMER
		OlddbIdlogCond idcond = new OlddbIdlogCond();
		idcond.setMyTable(CODE+"customer");
		final List<OlddbIdlog> oldid = OldDataToSqlUtils.getOlddbIdlogServices().findOlddbIdlog(idcond);
		
		//417866
		List<KN_KHGXGL_KH> khList = OldDataToSqlUtils.getOldDataServices().findKN_KHGXGL_KH_forAddcom();
		final Map<String,KN_KHGXGL_KH> khListMap = new HashMap<String, KN_KHGXGL_KH>();
		 for(KN_KHGXGL_KH k : khList){
			 khListMap.put(k.get客户id()+"", k);
		 }
		 khList.clear();
		//实现UPDATE
		
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					Customer upcustomer ;
					KN_KHGXGL_KH oldcustomer;
					for(OlddbIdlog k : oldid){
						oldcustomer = khListMap.get(k.getOlddbId());
						if(oldcustomer == null)continue;
						
						upcustomer = DescUtils.getCustomerServices().getKnCustomerById(
								Integer.parseInt(k.getMyId()));
						if(upcustomer == null)continue;
						upcustomer.setWorkContent(oldcustomer.get地址工作());
						upcustomer.setHomeContent(oldcustomer.get住址());
						upcustomer.setAddress(oldcustomer.get身份证地址());
						
						Province p;
						Map searchCmap = new HashMap<String, Object>();
						City city;
						Region region;
						//home 排除空 减少查询
						if(!(oldcustomer.get省() == null || oldcustomer.get省().length() <= 1)){
							p = DescUtils.getProvinceServices().findProvineByName(oldcustomer.get省().substring(0,2));
							if(p == null){
								addErrCustomer(k);
								continue;
							}
							upcustomer.setHomeProvince(p.getProvinceId());
						
						if(!(oldcustomer.get市() == null || oldcustomer.get市().length() <= 1 )){
							searchCmap = new HashMap<String, Object>();
							searchCmap.put("name", oldcustomer.get市().substring(0,2));
							searchCmap.put("subId", p.getProvinceId());
							city = DescUtils.getCityServices().findCityByname(searchCmap);
							if(city == null){
								addErrCustomer(k);
								continue;
							}
							upcustomer.setHomeCity(city.getCityId());
						
						if(!(oldcustomer.get县区() == null || oldcustomer.get县区().length() <= 1)){
							searchCmap.clear();
							searchCmap.put("name", oldcustomer.get县区().substring(0,2));
							searchCmap.put("subId", city.getCityId());
							region = DescUtils.getRegionServices().findRegionByName(searchCmap);
							
							if(null == region){
								Region g = new Region();
								g.setCityId( city.getCityId());
								g.setIsDeleted("0");
								g.setOrderIndex(999);
								g.setRegionName(oldcustomer.get县区());
								DescUtils.getRegionServices().addRegion(g);
								upcustomer.setHomeRegion(g.getRegionId());
							}else{
								upcustomer.setHomeRegion(region.getRegionId());
							}
						}}}
						//work
						p = null;
						searchCmap = new HashMap<String, Object>();
						city = null;
						region = null;
						if(!(oldcustomer.get省工作() == null || oldcustomer.get省工作().length()<= 1)){
							p = DescUtils.getProvinceServices().findProvineByName(oldcustomer.get省工作().substring(0,2));
							if(p == null){
								addErrCustomer(k);
								continue;
							}
							upcustomer.setWorkProvince(p.getProvinceId());
						
						if(!(oldcustomer.get市工作() == null || oldcustomer.get市工作().length() <= 1)){
							searchCmap = new HashMap<String, Object>();
							searchCmap.put("name", oldcustomer.get市工作().substring(0,2));
							searchCmap.put("subId", p.getProvinceId());
							city = DescUtils.getCityServices().findCityByname(searchCmap);
							if(city == null){
								addErrCustomer(k);
								continue;
							}
							upcustomer.setWorkCity(city.getCityId());
						
						if(!(oldcustomer.get县区工作() == null || oldcustomer.get县区工作().length() <= 1)){
							searchCmap.clear();
							searchCmap.put("name", oldcustomer.get县区工作().substring(0,2));
							searchCmap.put("subId", city.getCityId());
							region = DescUtils.getRegionServices().findRegionByName(searchCmap);
							
							if(null == region){
								Region g = new Region();
								g.setCityId( city.getCityId());
								g.setIsDeleted("0");
								g.setOrderIndex(999);
								g.setRegionName(oldcustomer.get县区工作());
								DescUtils.getRegionServices().addRegion(g);
								upcustomer.setWorkRegion(g.getRegionId());
							}else{
								upcustomer.setWorkRegion(region.getRegionId());
							}
							
						}}}
						
						upcustomer.setRemark1(oldcustomer.get备注());
						DescUtils.getCustomerServices().updateKnCustomer(upcustomer);
					}
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void addErrCustomer(OlddbIdlog k){
		k.setMyTable(CODE+"customer_err");
		OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(k);
	}
	
	
	/*
	 * 
	 */
	@SuppressWarnings("unused")
	public void addUnitCom(){
		final List<KN_LPCS_DY> dyList;
		List<OlddbIdlog> logList;
		final Map<String, String> idMap = new HashMap<String, String>();
		
		dyList = OldDataToSqlUtils.getOldDataServices().findKN_LPCS_DY(null);
		
		OlddbIdlogCond oldcond = new OlddbIdlogCond();
		oldcond.setMyTable(CODE+"company_unit_lp2");
		logList = OldDataToSqlUtils.getOlddbIdlogServices().findOlddbIdlog(oldcond);
		for(OlddbIdlog o : logList){
			idMap.put(o.getOlddbId(), o.getMyId());
		}
		logList.clear();
		
		try {
			new MyTransationTemplate() {
				@Override
				protected void doExecuteCallback() throws Exception {
					for(KN_LPCS_DY dy : dyList){
						PropertyUnit unit = null;
						try {
						unit = MyPropertyUtils.getPropertyUnitServices()
											.findPropertyUnitById(Integer.parseInt(idMap.get(dy.get单元id().toString())));
						} catch (NumberFormatException e) {
							continue;
						}
						if(unit == null)continue;
						
						//产品类型 50
						unit.setProductType(dy.get功能());
						//装修标准 50
						unit.setRenovateDesc(dy.get装修标准());
						//朝向
						unit.setOrientation(getcx(dy.get朝向()));
						//备注 max 27
						unit.setRemark(dy.get备注());
						//户型
						sethx(dy,unit);
						//附加面积 +字段
						unit.setAddArea(dy.get附加面积());
						//显示楼层
						unit.setFloorShowName(dy.get显示楼层());
						
						MyPropertyUtils.getPropertyUnitServices().updatePropertyUnit(unit);
					}
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static Map<String, String> p = new HashMap<String, String>();
	static {
		p.put("东向"     , "1")	;              
		p.put("南向"     , "2")	;              
		p.put("南/西户"   ,"8")	;              
		p.put("东"      , "1")	;              
		p.put("中向"       , "1")	;              
		p.put("北向"       , "4")	;              
		p.put("南北(东户)"   , "6")	;              
		p.put("东西"       , "5")	;              
		p.put("南3户"      , "2")	;              
		p.put("南4户"      , "2")	;              
		p.put("南北"       , "6")	;              
		p.put("正南"       , "2")	;              
		p.put("北"        , "4")	;              
		p.put("南北(西户)"   , "6")	;              
		p.put("南/东户"     , "7")	;              
		p.put("南北（西户）"   , "6")	;              
		p.put("南北(金角)"   , "6")	;              
		p.put("东南"       , "7")	;              
		p.put("东北"       , "10")	;              
		p.put("hhh"      , "0")	;              
		p.put("西南"       , "8")	;              
		p.put("南西北"      , "8")	;              
		p.put("南面"       , "2")	;              
		p.put("西"        , "3")	;              
		p.put("东西北"      , "5")	;              
		p.put("南1户"      , "2")	;              
		p.put("南2户"      , "2")	;              
		p.put("南北(银角)"   , "6")	;              
		p.put("西向"       , "3")	;              
		p.put("西北"       , "9")	;              
		p.put("南"        , "2")	;              
		p.put("南北（东户）"   , "6")	;      
	}
	//得到朝向ID
	public String getcx(String cx){
		if(cx == null || cx.trim().equals(""))return "0";
		return p.get(cx);
	}
	static Map<String,String> pp = new HashMap<String, String>();
	static {
		pp.put("六室二厅五卫","625");
		pp.put("一室一厅一卫","111");
		pp.put("三室二厅二卫（跃）","322");
		pp.put("六室三厅三卫","633");
		pp.put("六室三厅四卫","634");
		pp.put("四室两厅三卫","423");
		pp.put("2+1三室一厅","310");
		pp.put("二室一厅","210");
		pp.put("六室二厅三卫","623");
		pp.put("二房二厅二卫","222");
		pp.put("三室二厅二卫","322");
		pp.put("二室一厅一卫","211");
		pp.put("四室二厅五卫","425");
		pp.put("二室二厅两卫","222");
		pp.put("五室二厅四三卫","524");
		pp.put("三房三厅三卫","333");
		pp.put("三房二厅二卫","322");
		pp.put("四室三厅四卫","434");
		pp.put("二室二厅一卫","221");
		pp.put("三室二厅一卫","321");
		pp.put("四室二厅二卫（跃）","422");
		pp.put("五室三厅三卫","533");
		pp.put("一室两厅一卫","121");
		pp.put("二室一厅二卫","212");
		pp.put("八室四厅一厨八卫","848");
		pp.put("三室三厅四卫","334");
		pp.put("三室二厅三卫(跃)","323");
		pp.put("五室四厅三卫","543");
		pp.put("三室一厅一卫","311");
		pp.put("五室二厅二卫","522");
		pp.put("四室二厅四卫","424");
		pp.put("三室二厅三卫","323");
		pp.put("五室三厅五卫","535");
		pp.put("四室二厅二卫","422");
		pp.put("五室二厅三卫","523");
		pp.put("两室二厅二卫","222");
		pp.put("五室二厅四卫","524");
		pp.put("五室三厅四卫","534");
		pp.put("一室二厅一卫","121");
		pp.put("一室一卫","101");
		pp.put("三室三厅三卫","333");
		pp.put("三室四厅三卫","343");
		pp.put("三室二厅","320");
		pp.put("二室二厅","220");
		pp.put("四室四厅四卫","444");
		pp.put("五室二厅六卫","526");
		pp.put("四室三厅三卫","433");
		pp.put("三室三厅二卫","332");
		pp.put("2+1二室二厅","220");
		pp.put("五室四厅五卫","545");
		pp.put("四室二厅三卫","423");
		pp.put("三室二厅三卫（跃）","323");
		pp.put("五室二厅五卫","525");
		pp.put("四室二厅一卫","421");
		pp.put("二室二厅二卫","222");
		pp.put("三室两厅四卫","324");
		pp.put("六室三厅一厨五卫","635");
		pp.put("三室一厅二卫","312");
	}
	//得到户型  dy.规格
	public void sethx(KN_LPCS_DY dy,PropertyUnit unit){
		String guige = pp.get(dy.get规格());
		if(guige==null)return;
		
		int i1 = Integer.parseInt(guige.substring(0,1));
		int i2 = Integer.parseInt(guige.substring(1,2));
		int i3 = Integer.parseInt(guige.substring(2,3));
		
		unit.setRoomNum(i1);
		unit.setHallNum(i2);
		unit.setToiletNum(i3);
	}
	
	/**
	 * 认购书
	 * 认购书号  
	 * */
	public void addConfirm(){
		final List<KN_XSGL_RGS> rgslist = OldDataToSqlUtils.getOldDataServices().findKN_XSGL_RGS(null);
		OlddbIdlogCond idcond = new OlddbIdlogCond();
		idcond.setMyTable(CODE+"confirm");
		List<OlddbIdlog> idlist = OldDataToSqlUtils.getOlddbIdlogServices().findOlddbIdlog(idcond);
		final Map<String,String> idmap = new HashMap<String, String>();
		for(OlddbIdlog o : idlist){
			idmap.put(o.getOlddbId(), o.getMyId());
		}
		idlist.clear();
		
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					// TODO Auto-generated method stub
					Confirm c ;
					for(KN_XSGL_RGS r : rgslist){
						String myids = idmap.get(r.get认购书id().toString());
						if(myids == null)continue;
						
						int myid = Integer.parseInt(myids);
						c = MyPropertyUtils.getConfirmServices().findConfirmById(myid);
						//认购书号
						if(c==null){
							continue;
						}
						c.setAgreeNo(r.get认购书号());
						//付款方式
						c.setPayWayId(payway(r,c));
						//创建时间
						c.setCreatedTime(r.get创建时间());
						//备注
						c.setRemark(r.get备注());
						
						MyPropertyUtils.getConfirmServices().updateConfirm(c);
					}
				}
			}.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int payway(KN_XSGL_RGS r,Confirm c){//根据中文付款方式找到付款方式ID
		//需要根据com
		try {
			
		
		if(r.get付款方式() == null || r.get付款方式().trim().equals(""))return 0;
		PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(c.getUnitId());
		PropertyBuild build = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildById(unit.getBuildId());
		PropertyArea area = MyPropertyUtils.getPropertyAreaServices().findPropertyAreaById(build.getAreaId());
		PropertyProject property = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectById(area.getPropertyId());
		
		int proid = property.getId();
		
		Map<String,Object> p = new HashMap<String, Object>();
		p.put("pid", proid);
		p.put("name", r.get付款方式());
		
		PayWay payway = MyPropertyUtils.getPayWayServices().findPayWayByNameAndProId(p);
		
		if(payway == null){
			payway = newpayway(proid,r.get付款方式());
		}
		
		return payway.getId();
		} catch (Exception e) {
			return 0;
		}
	}
	private PayWay newpayway(int proid,String payname){
		Date now = new Date();
		PayWay y = new PayWay();
		y.setBuildId(0);
		y.setIsDeleted("0");
		y.setCreatedId(2);
		y.setCreatedTime(now);
		y.setModId(2);
		y.setModTime(now);
		
		y.setPayName(payname);
		y.setProjectId(proid);
		MyPropertyUtils.getPayWayServices().addPayWay(y);
		return y;
	}
	
	//补充付款方式
	public void addpayway(){
		
		OlddbIdlogCond idcond = new OlddbIdlogCond();
		idcond.setMyTable(CODE+"company_project_databases");
		List<OlddbIdlog> idlist = OldDataToSqlUtils.getOlddbIdlogServices().findOlddbIdlog(idcond);
		
		List<String> paywayname = new LinkedList<String>();
		paywayname.add("一次性");
		paywayname.add("VIP");
		paywayname.add("公积金");
		paywayname.add("组合");
		paywayname.add("首付分期");
		paywayname.add("半年分期");
		paywayname.add("两年分期");
		paywayname.add("按揭");
		paywayname.add("壹月分期");
		paywayname.add("贰月分期");
		paywayname.add("分期");
		
		
		Date now = new Date();
		PayWay y = new PayWay();
		y.setBuildId(0);
		y.setIsDeleted("0");
		y.setCreatedId(2);
		y.setCreatedTime(now);
		y.setModId(2);
		y.setModTime(now);
		for(OlddbIdlog o : idlist){
			PropertyProject pro = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectById(Integer.parseInt(o.getMyId()));
			if(pro == null)continue;
			for(String s : paywayname){
				y.setPayName(s);
				y.setProjectId(pro.getId());
				MyPropertyUtils.getPayWayServices().addPayWay(y);
			}
		}
	}
	
	
	public static void main(String[] args) {
		
	}
	
	
	public void freezeUnit(){
		KN_LPCS_DY_Cond dycond = new KN_LPCS_DY_Cond();
		dycond.set状态("冻结");
		final List<KN_LPCS_DY> dylist = OldDataToSqlUtils.getOldDataServices().findKN_LPCS_DY(dycond);
		try {
			new MyTransationTemplate() {
				@Override
				protected void doExecuteCallback() throws Exception {
					for(KN_LPCS_DY d : dylist){
						OlddbIdlogCond idcond = new OlddbIdlogCond();
						idcond.setOldId(d.get单元id().intValue());
						idcond.setMyTable(CODE+"company_unit_lp2");
						OlddbIdlog idlog = OldDataToSqlUtils.getOlddbIdlogServices().findOlddbIdlogByOldIdAndTableName(idcond);
						if(idlog == null){
							continue;
						}
						PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(Integer.parseInt(idlog.getMyId()));
						if(unit == null){
							continue;
						}
						unit.setSaleState("1");
						MyPropertyUtils.getPropertyUnitServices().updatePropertyUnit(unit);
					}
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 交楼
	 * */
	public void realhoseDate(){
		
	}
}











