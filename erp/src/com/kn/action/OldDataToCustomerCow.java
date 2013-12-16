package com.kn.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.kn.data.pojo.OlddbIdlog;
import com.ihk.kn.data.pojo.OlddbIdlogCond;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;

/**
 * junit测试类
 * 
 * @author peter 2012-9-29
 */
public class OldDataToCustomerCow {

	private static FileSystemXmlApplicationContext factory;

	@BeforeClass
	public static void init() {
		factory = new FileSystemXmlApplicationContext("src/Junit-olddata.xml");

	}

	@Test
	public void test1() {

		try {
			xqmj(); 
			xqjg();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	static String CODE = "tj6_";
	/**
	 * 拿到所有问卷貌似需求面积的值 填写到相关customer 不能保证准确 但是应为不重复 而且 完整度有70%
	 * */
	public void xqmj() {
		System.out.println("input");
		//final List<Map> xqmap  = null;
		final List<Map> xqmap = OldDataToSqlUtils.getOldDataServices()
				.findKN_LPCS_DY_xqmj();

		OlddbIdlogCond idcond = new OlddbIdlogCond();
		idcond.setMyTable(CODE+"customer");
		List<OlddbIdlog> idlist = OldDataToSqlUtils.getOlddbIdlogServices()
				.findOlddbIdlog(idcond);
		final Map<String, String> idmap = new HashMap<String, String>();
		for (OlddbIdlog o : idlist) {
			idmap.put(o.getOlddbId(), o.getMyId());
		}
		idlist.clear();

		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					// TODO Auto-generated method stub
			
			for (Map p : xqmap) {// 大约20W
				String myids = idmap.get(p.get("ID").toString());
				if(myids == null)continue;
				Object valuso =p.get("VAL");
				if(valuso == null)continue;
				String valus = valuso.toString();
				// 转译成数字
				int val = zystring(valus);

				// 专门写一个customer update
				Map res = new HashMap<String, Object>();
				res.put("id", myids);
				res.put("pricenum", val);
				DescUtils.getCustomerServices().knUpdateXqmj(res);
			}
			
			
				}
			}.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 拿到所有问卷貌似需求面积的值 填写到相关customer 不能保证准确 但是应为不重复 而且 完整度有70%
	 * */
	public void xqjg() {
		System.out.println("input");
		//final List<Map> xqmap  = null;
		final List<Map> xqmap = OldDataToSqlUtils.getOldDataServices()
				.findKN_LPCS_DY_xqjg();

		OlddbIdlogCond idcond = new OlddbIdlogCond();
		idcond.setMyTable(CODE+"customer");
		List<OlddbIdlog> idlist = OldDataToSqlUtils.getOlddbIdlogServices()
				.findOlddbIdlog(idcond);
		final Map<String, String> idmap = new HashMap<String, String>();
		for (OlddbIdlog o : idlist) {
			idmap.put(o.getOlddbId(), o.getMyId());
		}
		idlist.clear();

		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					// TODO Auto-generated method stub
			
			for (Map p : xqmap) {// 大约20W
				String myids = idmap.get(p.get("ID").toString());
				if(myids == null)continue;
				Object valuso =p.get("VAL");
				if(valuso == null)continue;
				String valus = valuso.toString();
				// 转译成数字
				int val = zystring(valus);

				// 专门写一个customer update
				Map res = new HashMap<String, Object>();
				res.put("id", myids);
				res.put("pricenum", val);
				DescUtils.getCustomerServices().knUpdateXqjg(res);
			}
			
			
				}
			}.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	// 转译 规则 100-200 转译为50
	// 400以上 400
	public int zystring(String v) {
		v=v.replace("～", "-");
		v=v.replace("㎡", "");
		v=v.replace("~", "");
		String s1 = getNumbers(v);
		String s2 = getNumbers1(v);
		
		if(s1 != null){
			String[] ss1 = s1.split("-");
			return (Integer.parseInt(ss1[0]) + Integer.parseInt(ss1[1]))/2;
		}
		if(s2 != null){
			return Integer.parseInt(s2);
		}
	    return 0;
	}

	public  String getNumbers(String content) {
		Pattern pattern = Pattern.compile("\\d+-\\d+");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
				return matcher.group(0);
		}
		return null;
	}
	
	public  String getNumbers1(String content) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			if(matcher.group().length() > 1){
				return matcher.group();
			}else{
				continue;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		OldDataToCustomerCow oo = new OldDataToCustomerCow();
		int r = oo.zystring("三房133㎡～142㎡");
		System.out.println(r);
	}

}
