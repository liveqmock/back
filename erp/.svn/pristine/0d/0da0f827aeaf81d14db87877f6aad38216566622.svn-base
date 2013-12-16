package com.kn.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.kn.data.pojo.OlddbIdlog;
import com.ihk.kn.data.pojo.OlddbIdlogCond;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.pinyin.PinyinBaseUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.kn.data.pojo.KN_RGS_YZ;
import com.kn.data.pojo.KN_XSGL_RGS;

/**
 * 认购书 售后客户 合同  以及可能会用到的 customer.user_id
 * @author peter
 * 2012-9-29
 */
public class OldDataToSqlTestRGS {
	
	private static FileSystemXmlApplicationContext factory;
	
	@BeforeClass
	public static void init(){		
		factory = new FileSystemXmlApplicationContext(
				"src/Junit-olddata.xml");		
		CODE = Tjvison.TJ1;
		
	}
	
	static int TJ = 33;
	@Test
	public void test1(){
		
		try {
			long be = System.currentTimeMillis();
			confirm();//认购书
			
			confirmAndContractCustomer();//认购书客户
			
			contract(null);//合同
			
			
			
			
			/*注意 下面2个方法不一定使用的 应为售前客户实际上是固定几个人开的  
			userAccount1();//售前客户负责人导入
			userAccount2();//根据上一步的导入增加外键联系
			*/
			System.out.println((System.currentTimeMillis() - be));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static String CODE = "tj6_";
	
	
	/**
	 * 认购书 对应confirm表
	 * 
	 * 认购书(有效状态)  1-1 单元
	 * 
	 * 
	 * 1:更新单元状态
	 *  update 
		olddb_idlog t, confirm tt ,property_unit ttt
		set ttt.sale_state = '8'
		where t. my_table = 'confirm' 
		and tt.id = t.my_id
		and ttt.id = tt.unit_id
		
		
		2:更新confirm 项目ID
		update 
		olddb_idlog t, confirm tt ,property_unit ttt
		set tt.company_project_id = ttt.company_project_id
		where t. my_table = 'confirm' 
		and tt.id = t.my_id
		and ttt.id = tt.unit_id
	 * */
	void confirm(){
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					
			List<KN_XSGL_RGS> rgsList = OldDataToSqlUtils.getOldDataServices().findKN_XSGL_RGS(null);
			OlddbIdlogCond cond = new OlddbIdlogCond();
			cond.setMyTable(CODE+"company_unit_lp2");
			List<OlddbIdlog> oldlog = OldDataToSqlUtils.getOlddbIdlogServices().findOlddbIdlog(cond);
			Map<Integer, Integer> oldlogMap = new HashMap<Integer, Integer>(); 
			for(OlddbIdlog o : oldlog){
				oldlogMap.put(Integer.parseInt(o.getOlddbId()), Integer.parseInt(o.getMyId()));
			}
			oldlog.clear();
			
			Confirm confirm = new Confirm();
			confirm.setIsDeleted("0");
			confirm.setCreatedId(2);
			confirm.setCreatedTime(new Date());
			confirm.setModId(2);
			confirm.setModTime(new Date());
			OlddbIdlog addlog = new OlddbIdlog();
			addlog.setMyTable(CODE+"confirm");
			for(KN_XSGL_RGS rgs : rgsList){
				/*KNLOG_XSGL_RGS logrgs = new KNLOG_XSGL_RGS();
				logrgs.setDataLab(rgs.getDataLab());
				logrgs.setDelInterval(rgs.getDelInterval());
				logrgs.setEmail(rgs.getEmail());
				logrgs.setRgTime(rgs.getRgTime());
				logrgs.set业主姓名(rgs.get业主姓名());
				logrgs.set付款方式(rgs.get付款方式());
				logrgs.set付款方式种类(rgs.get付款方式种类());
				logrgs.set价格id(rgs.get价格id());
				logrgs.set优惠减价(rgs.get优惠减价());
				logrgs.set修改人(rgs.get修改人());
				logrgs.set修改时间(rgs.get修改时间());
				logrgs.set其他证件号码(rgs.get其他证件号码());
				logrgs.set其他证件名称(rgs.get其他证件名称());
				logrgs.set创建人(rgs.get创建人());
				logrgs.set创建时间(rgs.get创建时间());
				logrgs.set单元id(rgs.get单元id());
				logrgs.set原价(rgs.get原价());
				logrgs.set售楼处(rgs.get售楼处());
				logrgs.set国籍(rgs.get国籍());
				logrgs.set地址(rgs.get地址());
				logrgs.set备注(rgs.get备注());
				logrgs.set审核(rgs.get审核());
				logrgs.set成交币种(rgs.get成交币种());
				logrgs.set成交总价(rgs.get成交总价());
				logrgs.set打印次数(rgs.get打印次数());
				logrgs.set折扣id(rgs.get折扣id());
				logrgs.set折扣批准人(rgs.get折扣批准人());
				logrgs.set折扣规则id(rgs.get折扣规则id());
				logrgs.set折扣计算方式(rgs.get折扣计算方式());
				logrgs.set服务佣金(rgs.get服务佣金());
				logrgs.set本位币成交总价(rgs.get本位币成交总价());
				logrgs.set汇率(rgs.get汇率());
				logrgs.set状态(rgs.get状态());
				logrgs.set生日(rgs.get生日());
				logrgs.set电话(rgs.get电话());
				logrgs.set移动电话(rgs.get移动电话());
				logrgs.set订房截止日期(rgs.get订房截止日期());
				logrgs.set认购书id(rgs.get认购书id());
				logrgs.set认购书号(rgs.get认购书号());
				logrgs.set认购交楼日期(rgs.get认购交楼日期());
				logrgs.set认购日期(rgs.get认购日期());
				logrgs.set认购时间(rgs.get认购时间());
				logrgs.set购买方式(rgs.get购买方式());
				logrgs.set身份证号(rgs.get身份证号());
				logrgs.set身份证地址(rgs.get身份证地址());
				logrgs.set邮编(rgs.get邮编());
				logrgs.set销售代理商(rgs.get销售代理商());
				logrgs.set附加价原因(rgs.get附加价原因());
				logrgs.set附加总价(rgs.get附加总价());
				logrgs.set预约签合同时间(rgs.get预约签合同时间());
				OldDataToSqlUtils.getOlddbIdlogServices().addKNLOG_XSGL_RGS(logrgs);*/
				
				if(!rgs.get状态().equals("认购")){
					continue;
				}
				Integer newUnitId =  oldlogMap.get(Integer .parseInt(rgs.get单元id().toString()));
				if(newUnitId == null)continue;
				
				if(rgs.get电话() == null){
					confirm.setPhone(rgs.get移动电话());
				}else if(rgs.get移动电话() == null){
					confirm.setPhone(rgs.get电话());
				}
				if(confirm.getPhone() == null)confirm.setPhone("0");
				confirm.setCustomerId(-1);//要在后面补充进去 ps:2
				confirm.setUnitId(newUnitId);
				confirm.setAgreeNo(rgs.get认购书号());
				confirm.setSumMoney(rgs.get成交总价());
				confirm.setWorkDate(rgs.get认购日期());
				
				confirm.setCompanyProjectId(-1);
				MyPropertyUtils.getConfirmServices().addConfirm(confirm);

				addlog.setOlddbId(rgs.get认购书id()+"");
				addlog.setMyId(confirm.getId()+"");
				OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(addlog);
			}
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 售后客户表
	 * 认购书_业主
	 * 
	 * 1存储业主
	 * 2找到业主OLD认购书ID
	 * 3找到Conifrm ID
	 * 4更新Confirm 客户ID
	 * 
	 * */
	void confirmAndContractCustomer(){
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
			List<KN_RGS_YZ> yzList = OldDataToSqlUtils.getOldDataServices().findKN_RGS_YZ(null);
					
			OlddbIdlogCond cond = new OlddbIdlogCond();
			cond.setMyTable(CODE+"confirm");
			List<OlddbIdlog> oldlog = OldDataToSqlUtils.getOlddbIdlogServices().findOlddbIdlog(cond);
			Map<Integer, Integer> oldlogMap = new HashMap<Integer, Integer>(); 
			for(OlddbIdlog o : oldlog){
				oldlogMap.put(Integer.parseInt(o.getOlddbId()), Integer.parseInt(o.getMyId()));
			}
			oldlog.clear();
			
			
			
			ContractCustomer ccustomer = new ContractCustomer();
			ccustomer = new ContractCustomer();
			ccustomer.setIsDeleted("0");
			ccustomer.setCreatedId(2);
			ccustomer.setCreatedTime(new Date());
			ccustomer.setModId(2);
			ccustomer.setModTime(new Date());
			OlddbIdlog log = new OlddbIdlog();
			log.setMyTable(CODE+"contract_customer");
			for(KN_RGS_YZ yz:yzList){
				//ps:1
				ccustomer.setCompanyId(0);
				ccustomer.setProjectId(0);
				ccustomer.setUserId(0);
				ccustomer.setConfirmType("1");
				ccustomer.setCustomerName(yz.get业主姓名());
				ccustomer.setIdcardNo(yz.get身份证号());
				ccustomer.setAddress(yz.get地址());
				ccustomer.setPhone(yz.get电话());
				ccustomer.setMobilePhone(yz.get移动电话());
				MyPropertyUtils.getContractCustomerServices().addKnContractCustomer(ccustomer);
				
//				//ps:2
//				Integer confirmId = oldlogMap.get(Integer.parseInt(yz.get认购书id().toString()));
//				//ps3
//				Confirm updateConfirm = confirMap.get(confirmId);
//				updateConfirm.setCustomerId(ccustomer.getId());
//				//ps:4
//				MyPropertyUtils.getConfirmServices().updateConfirm(updateConfirm);
				
				Integer confirmid = oldlogMap.get(Integer.parseInt(yz.get认购书id()+""));
				Map<String, Integer> p = new HashMap<String, Integer>();
				p.put("myId", confirmid);
				p.put("customerId", ccustomer.getId());
				MyPropertyUtils.getConfirmServices().updateConfirmSetCustomerIdById(p);
				
				log.setMyId(ccustomer.getId()+"");
				log.setOlddbId(yz.get业主id()+"");
				OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(log);
			}
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	/*
	 * confirm 与 contract_customer 外键连接
	 * */
	void confirmCustomerIdUpdate(){
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
			List<KN_RGS_YZ> yzList = OldDataToSqlUtils.getOldDataServices().findKN_RGS_YZ(null);
					
			OlddbIdlogCond cond = new OlddbIdlogCond();
			cond.setMyTable(CODE+"confirm");
			List<OlddbIdlog> oldlog = OldDataToSqlUtils.getOlddbIdlogServices().findOlddbIdlog(cond);
			Map<Integer, Integer> oldlogMap = new HashMap<Integer, Integer>(); 
			for(OlddbIdlog o : oldlog){
				oldlogMap.put(Integer.parseInt(o.getOlddbId()), Integer.parseInt(o.getMyId()));
			}
			oldlog.clear();
			
			
			
			ContractCustomer ccustomer = new ContractCustomer();
			ccustomer = new ContractCustomer();
			ccustomer.setIsDeleted("0");
			ccustomer.setCreatedId(2);
			ccustomer.setCreatedTime(new Date());
			ccustomer.setModId(2);
			ccustomer.setModTime(new Date());
			OlddbIdlog log = new OlddbIdlog();
			log.setMyTable(CODE+"contract_customer");
			for(KN_RGS_YZ yz:yzList){
				//ps:1
				ccustomer.setCompanyId(0);
				ccustomer.setProjectId(0);
				ccustomer.setUserId(0);
				ccustomer.setConfirmType("1");
				ccustomer.setCustomerName(yz.get业主姓名());
				ccustomer.setIdcardNo(yz.get身份证号());
				ccustomer.setAddress(yz.get地址());
				ccustomer.setPhone(yz.get电话());
				ccustomer.setMobilePhone(yz.get移动电话());
				MyPropertyUtils.getContractCustomerServices().addContractCustomer(ccustomer);
				
//				//ps:2
//				Integer confirmId = oldlogMap.get(Integer.parseInt(yz.get认购书id().toString()));
//				//ps3
//				Confirm updateConfirm = confirMap.get(confirmId);
//				updateConfirm.setCustomerId(ccustomer.getId());
//				//ps:4
//				MyPropertyUtils.getConfirmServices().updateConfirm(updateConfirm);
				
				Integer confirmid = oldlogMap.get(yz.get认购书id());
				Map<String, Integer> p = new HashMap<String, Integer>();
				p.put("myId", confirmid);
				p.put("customerId", ccustomer.getId());
				MyPropertyUtils.getConfirmServices().updateConfirmSetCustomerIdById(p);
				
				log.setMyId(ccustomer.getId()+"");
				log.setOlddbId(yz.get业主id()+"");
				OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(log);
			}
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 导入签约资料
	 * 
	 * sql:
	 * 先存的是老的confirmID 需要修改
	 * update contract t ,olddb_idlog tt set t.confirm_id = tt.my_id
		where tt.my_table = 'tj_confirm'
		and t.confirm_id = tt.olddb_id;
		
		

update contract t ,confirm tt set t.customer_id = tt.customer_id
where t.confirm_id = tt.id;

update contract t ,confirm tt set t.unit_id = tt.unit_id
where t.confirm_id = tt.id;

update contract t ,confirm tt set t.company_project_id = tt.company_project_id
where t.confirm_id = tt.id;

update property_unit t ,contract tt set t.sale_state = '9'
where t.id = tt.unit_id 
and tt.is_deleted = '0'
	 * 单元状态需要修改
	 * */
	public void contract(List<KN_XSGL_RGS> listrgs1){
		final List<KN_XSGL_RGS> listrgs;
		if(listrgs1 != null){
			 listrgs =listrgs1;
		}else{
			 listrgs = OldDataToSqlUtils.getOldDataServices().findKN_XSGL_RGS_HT(null);
		}
		
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
		
		
		OlddbIdlogCond cond = new OlddbIdlogCond();
		cond.setMyTable(CODE+"company_unit_lp2");
		List<OlddbIdlog> oldlog = OldDataToSqlUtils.getOlddbIdlogServices().findOlddbIdlog(cond);
		Map<Integer, Integer> oldlogMap = new HashMap<Integer, Integer>(); 
		for(OlddbIdlog o : oldlog){
			oldlogMap.put(Integer.parseInt(o.getOlddbId()), Integer.parseInt(o.getMyId()));
		}
		oldlog.clear();
		
		
		
		Contract contract = new Contract();
		contract.setIsDeleted("0");
		contract.setCreatedId(2);
		contract.setModId(2);
		contract.setCreatedTime(new Date());
		contract.setModTime(contract.getCreatedTime());
		
		OlddbIdlog addlog = new OlddbIdlog();
		addlog.setMyTable(CODE+"contract");
		
		for(KN_XSGL_RGS k : listrgs){
			Integer newUnitId =  oldlogMap.get(Integer .parseInt(k.get单元id().toString()));
			if(newUnitId == null)continue;
			contract.setSignDate(k.get签合同日期());
			contract.setTakeTime(k.get取合同时间());
			contract.setTakeUnitTime(k.get合同交楼日期());	
			contract.setContractNo(k.get合同编号().toString());
			contract.setConfirmId(k.get认购书id().intValue());//先存老的ID 等下再修改
			contract.setWorkDate(k.get认购日期());
			
			
			if(k.get电话() == null){
				contract.setPhone(k.get移动电话());
			}else if(k.get移动电话() == null){
				contract.setPhone(k.get电话());
			}
			if(contract.getPhone() == null)contract.setPhone("0");
			contract.setCustomerId(-1);//要在后面补充进去 ps:2
			contract.setUnitId(newUnitId);
//			contract.setAgreeNo(k.get认购书号());
			contract.setSumMoney(k.get成交总价());
			contract.setWorkDate(k.get认购日期());
			contract.setCompanyProjectId(-1);
			MyPropertyUtils.getContractServices().addContract(contract);
			
			addlog.setOlddbId(k.get认购书id().toString());
			addlog.setMyId(contract.getId()+"");
			OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(addlog);
		}
		
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
			contract(listrgs);
		}
	}
	
	
	
	/***
		1 售前客户负责人
	 * 
	 * */
	public void userAccount1(){
		
		//1 拿到所有的账户信息  database_user 与 database_user_role
		List<Map> userInfo = OldDataToSqlUtils.getOldDataServices().findUser();
			//OldDataToSqlUtils.getOldDataServices()
		
		//2 存入user_account
		UserAccount insertUserAccount = new UserAccount();
		insertUserAccount.setIsDeleted("0");
		insertUserAccount.setCreatedId(2);
		insertUserAccount.setCreatedTime(new Date());
		insertUserAccount.setModId(2);
		insertUserAccount.setModTime(insertUserAccount.getCreatedTime());
		insertUserAccount.setAccountType("1");
		
		//默认公司以及项目
		insertUserAccount.setCompanyId(TJ);
		insertUserAccount.setProjectId(1066);//test
		
		for(Map p :userInfo){
			try {
				insertUserAccount.setRealName(p.get("NAME").toString());
				//user_name 需要拼音包
				if(PinyinBaseUtils.isEn(insertUserAccount.getRealName())){//全英文直接=
					insertUserAccount.setUserName(insertUserAccount.getRealName()+".tj");
				}else{
					insertUserAccount.setUserName(PinyinBaseUtils.znTopinyin(insertUserAccount.getRealName())+".tj");
				}
				insertUserAccount.setUserPwd("a123456");
				MyPropertyUtils.getUserAccountServices().saveUserAccount(insertUserAccount);
			} catch (Exception e) {
				continue;
			}
		}
	}
	
	public static void main(String args[]) throws BadHanyuPinyinOutputFormatCombination{
		System.out.println(PinyinBaseUtils.znTopinyin("便宜110"));
	}
	
	/**
	 * 上一步的所有客户 根据name相同的 找到对应的user_id
	 * %%%%%%%%%%%%%%注意  knUpdateUserIdById 这个方法需要加 tj_表示
	 * */
	public void userAccount2(){
		//1 循环所有导入的客户  是ID
		UserAccountCond cond = new UserAccountCond();
		cond.setCompanyId(TJ);
		List<UserAccount> ListUser = MyPropertyUtils.getUserAccountServices().findUserAccountPage(cond);
		
		//找到所有老的该负责人的客户ID
		int errrow = 0;
		for(UserAccount a: ListUser){
			//找到该负责人的所有老客户ID
			try {
				List<Map> oldCustomerId = OldDataToSqlUtils.getOldDataServices().findKnKhgxglKh_by_zrr(a.getRealName());
				
				Map<String,Object> p = new HashMap<String, Object>();
				p.put("ids", oldCustomerId);
				p.put("userId", a.getId());
				
				MyPropertyUtils.getUserAccountServices().knUpdateUserIdById(p);
			} catch (Exception e) {
				errrow++;
			}
		}
		System.out.println(errrow);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
