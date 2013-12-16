package com.kn.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.kn.data.pojo.OlddbIdlog;
import com.ihk.kn.data.pojo.OlddbIdlogCond;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.saleunit.data.pojo.ReceiptDetail;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.kn.data.pojo.KN_CUGL_SSK;
import com.kn.data.pojo.KN_CWGL_YSK;

/**
 * 财务
 * @author peter
 * 2012-9-29
 */
public class Caiwu {
	
	private static FileSystemXmlApplicationContext factory;
	
	@BeforeClass
	public static void init(){		
		factory = new FileSystemXmlApplicationContext(
				"src/Junit-olddata.xml");		
		
	}
	String CODE = "tj6_";
	@Test
	public void test1(){
		try {
			caiwu();//应收款
			caiwumingxi();//明细
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  --climb.财务管理_收据_金额
		--climb.财务管理_收据
	 * 
	 *  --climb.财务管理_应收款   额外加了单元ID 为了适应我们系统
		--climb.财务管理_实收款  应收款 收据 中间表
	 * 
	 * climb.财务管理_应收款  == unit_pay_bill
	 * confirm > climb.财务管理_应收款(有效的) > 
	 * */
	public void caiwu(){
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					// TODO Auto-generated method stub
					List<KN_CWGL_YSK> ysklist = OldDataToSqlUtils.getOldDataServices().findKN_CWGL_YSK();
					
					OlddbIdlogCond cond = new OlddbIdlogCond();
					cond.setMyTable(CODE+"company_unit_lp2");
					List<OlddbIdlog> oldlog = OldDataToSqlUtils.getOlddbIdlogServices().findOlddbIdlog(cond);
					final Map<String, String> oldlogMap = new HashMap<String, String>(); 
					for(OlddbIdlog o : oldlog){
						oldlogMap.put(o.getOlddbId(),o.getMyId());
					}
					oldlog.clear();
					UnitPayBill bill = new UnitPayBill();
					bill.setIsDeleted("0");
					bill.setCreatedId(2);
					bill.setCreatedTime(new Date());
					bill.setModId(2);
					bill.setModTime(new Date());
					OlddbIdlog log = new OlddbIdlog();
					log.setMyTable(CODE+"unit_pay_bill");
			for(KN_CWGL_YSK o : ysklist){
				//找到confirm >  找到单元
				String unitid = oldlogMap.get(o.get单元ID().toString());
				int unitidint = 0;
				
				if(unitid == null)continue;
				unitidint = Integer.parseInt(unitid);
				
				bill.setUnitId(unitidint);
				bill.setShouldPay(o.get应收本币金额());
				bill.setHadPay(o.get已收金额());
				bill.setTypeName(o.get类别());
				bill.setFeeType(o.get收费项目());
				bill.setPayDate(o.get应收日期());
				bill.setPayPercent(o.get房款比例());//房款比例
				MyPropertyUtils.getUnitPayBillServices().addUnitPayBill(bill);
				
				log.setMyId(bill.getId()+"");
				log.setOlddbId(o.get应收款ID().toString());
				OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(log);
			}
				}
			}.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * climb.财务管理_实收款 KN_cugl_ssk fk:应收款ID pk:收据Id 已收金额  本次收款
	 * 
	 * 收据明细 receipt_detail fk:receipt_id(没用) fk:bill_id 本次付款pay_money 全部NOT NULL
	 * */
	public void caiwumingxi(){
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					// TODO Auto-generated method stub
					
			
			List<KN_CUGL_SSK> ssklist = OldDataToSqlUtils.getOldDataServices().findKN_CUGL_SSK();
			
			
			OlddbIdlogCond cond = new OlddbIdlogCond();
			cond.setMyTable(CODE+"unit_pay_bill");
			List<OlddbIdlog> oldlog = OldDataToSqlUtils.getOlddbIdlogServices().findOlddbIdlog(cond);
			final Map<String, String> oldlogMap = new HashMap<String, String>(); 
			for(OlddbIdlog o : oldlog){
				oldlogMap.put(o.getOlddbId(),o.getMyId());
			}
			oldlog.clear();
			
			ReceiptDetail rd = new ReceiptDetail();
			rd.setIsDeleted("0");
			rd.setCreatedId(2);
			rd.setCreatedTime(new Date());
			rd.setModId(2);
			rd.setModTime(new Date());
			rd.setReceiptId(0);
			rd.setPayMan("");
			rd.setPayDate(new Date());
			OlddbIdlog log = new OlddbIdlog();
			log.setMyTable(CODE+"receipt_detail");
			for(KN_CUGL_SSK o : ssklist){
				if(oldlogMap.get(o.get应收款ID().toString()) == null)continue;
				int billid = Integer.parseInt(oldlogMap.get(o.get应收款ID().toString()));
				rd.setBillId(billid);
				rd.setPayMoney(o.get本次收款());
				MyPropertyUtils.getReceiptDetailServices().addReceiptDetail(rd);
				
				
				log.setMyId(rd.getId()+"");
				log.setOlddbId(o.get收据ID().toString());
				OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(log);
			}
			
				}
			}.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


















