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
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitDefine;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.kn.data.pojo.KN_XSGL_YZJL;

/**
 * 单元交楼
 * @author peter
 * 2012-9-29
 */
public class SaleStateAction {
	
	private static FileSystemXmlApplicationContext factory;
	
	@BeforeClass
	public static void init(){		
		factory = new FileSystemXmlApplicationContext(
				"src/Junit-olddata.xml");		
		
	}
	
	@Test
	public void test1(){
		
		try {
			jiaoLou();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	static String CODE = "tj6_";
	
	/*
	 * 销售管理_业主交楼
	 * 认购书ID . 业主实际交楼日期  .  备注 . 经办人
	 * */
	public void jiaoLou(){
		final List<KN_XSGL_YZJL> yejlList = OldDataToSqlUtils.getOldDataServices().findKN_XSGL_YZJL();//业主交楼LIST
		OlddbIdlogCond cond = new OlddbIdlogCond();
		cond.setMyTable(CODE+"confirm");
		List<OlddbIdlog> oldlog = OldDataToSqlUtils.getOlddbIdlogServices().findOlddbIdlog(cond);
		final Map<String, String> oldlogMap = new HashMap<String, String>(); 
		for(OlddbIdlog o : oldlog){
			oldlogMap.put(o.getOlddbId(),o.getMyId());
		}
		
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					// TODO Auto-generated method stub
					
			
			for(KN_XSGL_YZJL o : yejlList ){
				
				//1 修改单元状态到交楼
				if(oldlogMap.get(o.get认购书ID().toString()) == null)continue;
				int cid = Integer.parseInt(oldlogMap.get(o.get认购书ID().toString()));
				Confirm c = MyPropertyUtils.
						getConfirmServices().
						findConfirmById(cid);
				int unitid =c.getUnitId();//根据 c 得到单元ID
				PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(unitid) ;//根据unitid 得到unit
				if(unit  == null)continue;
				unit.setSaleState("14");//设置交楼
				
				MyPropertyUtils.getPropertyUnitServices().updatePropertyUnit(unit);//修改状态实现
				
				//2 修改单元额外信息 添加交楼日期
				PropertyUnitDefine unitde = MyPropertyUtils.getPropertyUnitDefineServices().findPropertyUnitDefineByUnitId(unitid);//根据单元ID找到额外数据 没有的话新建
				if(unitde == null){
					unitde = new PropertyUnitDefine();
					unitde.setIsDeleted("0");
					unitde.setCreatedId(2);
					unitde.setCreatedTime(new Date());
					unitde.setModId(2);
					unitde.setModTime(new Date());
					unitde.setUnitId(unitid);
					unitde.setRealHouseDate(o.get业主实际交楼日期());//设置交楼日期
					MyPropertyUtils.getPropertyUnitDefineServices().addPropertyUnitDefine(unitde);
				}else{
					unitde.setRealHouseDate(o.get业主实际交楼日期());//设置交楼日期
					MyPropertyUtils.getPropertyUnitDefineServices().updatePropertyUnitDefine(unitde);
				}
				
				
			}
				}
			}.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	

	
	
