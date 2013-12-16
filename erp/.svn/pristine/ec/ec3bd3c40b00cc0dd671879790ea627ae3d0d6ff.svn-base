package com.ihk.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import net.sf.ehcache.CacheManager;

import com.ihk.utils.CacheUtils;
import com.ihk.utils.CustomerUtils;

/**
 * 缓存相关的测试类
 * @author dtc
 * 2012-9-29
 */
public class CacheTest {
	
	public static final String PERMIS_CACHE_NAME = "permission_cache";
	
	public static final String PERMIS_ELEMENT_KEY = "permission_element";
	
	private static String getInt(String str){
		
		char[] cs = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		for(char b : cs){
			try{
				
				String bStr = b + "";
				Integer.parseInt(bStr);
				sb.append(bStr);
				
			}catch(Exception e){
				break;
			}
		}
		
		return sb.toString();
	}
	
	private static final Random RANDOM = new Random();

	public static String generateGUID() {
		return new BigInteger(165, RANDOM).toString(36).toUpperCase();
	}
	
	public static void main(String[] args) throws Exception {
		
		for(int i=0; i<=9; i++){
			System.out.println(generateGUID());
		}
		
		
		/*Properties pros = System.getProperties();
		Enumeration<?> em = pros.keys();
		while(em.hasMoreElements()){
			Object key = em.nextElement();
			String value = System.getProperty(key.toString());
			System.out.println(key + "=" + value);
		}*/
		
		//String user_name=System.getProperty("user.name", "n/a");
		//System.out.println(user_name); 
		
		List<String> fileList = new ArrayList<String>();
		fileList.add("c:\\ok\\ok1.xls");
		fileList.add("c:\\ok\\ok2.xls");
		fileList.add("c:\\ok\\ok3.xls");
		fileList.add("c:\\ok\\ok4.xls");
		fileList.add("c:\\ok\\ok5.xls");
		
		for(String fileUrl : fileList){
			
			fileToSql(fileUrl);
		}
		
		
		
		
		//System.out.println(out.toString().length());
		//System.out.println(out.toString());
				
		
		/*
		Cache cache = CacheUtils.getCacheByName(PERMIS_CACHE_NAME);
		if(cache == null){
			System.out.println("1111");
		}
		
		for(int i=1; i<=10; i++){
			CacheUtils.put(PERMIS_CACHE_NAME, PERMIS_ELEMENT_KEY, i);
		}
		
		System.out.println(CacheUtils.getCacheByName(PERMIS_CACHE_NAME).get(PERMIS_ELEMENT_KEY).getValue());
		
		
		CacheUtils.put(PERMIS_CACHE_NAME + 2, PERMIS_ELEMENT_KEY, "aa");
		
		String[] cacheNames = CacheUtils.getCacheManager().getCacheNames();
		for(String cacheName : cacheNames){
			System.out.println(CacheUtils.getCacheByName(cacheName).get(PERMIS_ELEMENT_KEY).getValue());
			
		}
		
		System.out.println(CacheUtils.getValueByCacheNameAndKey(PERMIS_CACHE_NAME, PERMIS_ELEMENT_KEY));
		
		CacheUtils.removeCacheByCacheNameAndLikeKey(PERMIS_CACHE_NAME, "per");
		
		Object obj = CacheUtils.getValueByCacheNameAndKey(PERMIS_CACHE_NAME, PERMIS_ELEMENT_KEY);
		if(obj == null){
			System.out.println("---");
		}
		*/
		
		/*CacheUtils.put(PERMIS_CACHE_NAME, PERMIS_ELEMENT_KEY, "aaaa");
		System.out.println(CacheUtils.getValueByCacheNameAndKey(PERMIS_CACHE_NAME, PERMIS_ELEMENT_KEY));
		CacheUtils.updateCacheByCacheNameAndKey(PERMIS_CACHE_NAME, PERMIS_ELEMENT_KEY, "bbbb");
		System.out.println(CacheUtils.getValueByCacheNameAndKey(PERMIS_CACHE_NAME, PERMIS_ELEMENT_KEY + "2"));
		
		System.out.println(CacheUtils.getElementByCacheNameAndKey(PERMIS_CACHE_NAME, PERMIS_ELEMENT_KEY + "2"));
		
		if(CacheUtils.getElementByCacheNameAndKey(PERMIS_CACHE_NAME, PERMIS_ELEMENT_KEY + "2") == null){
			System.out.println("----------");
		}
		*/
		
		/*
		String[] arr = new String[]{"aa", "ab", "cc", "bb"};
		showArr(arr);
		Arrays.sort(arr);
		showArr(arr);
		
		String[] arrClone = arr.clone();
		arrClone = null;
		
		showArr(arr);
		
		arr = (String[]) change(arr);
		
		showArr(arr);*/
		
		
		/*Map<String, List<Element>> map = CacheUtils.getAllCacheAndElement();
		
		for(String cacheName : map.keySet()){
			
			List<Element> value = map.get(cacheName);
			for(Element e : value){
				String key = e.getKey() == null ? "" : e.getKey().toString();
				String eleValue = e.getValue() == null ? "" : e.getValue().toString();
				
				System.out.println(cacheName + " --> " + key + " : " + eleValue);
			}
		}
		
		
		//// ---------------------------------------------------------------------
		
		Pattern p = Pattern.compile("is.*");
		Matcher m = p.matcher("isProjectStateActive");
		boolean b = m.matches();
		
		System.out.println(b);
		
		
		for(int i=0; i<=10; i++){
			
			System.out.println(UUID.randomUUID().toString());
		}
		
		*/
		
	}
	
	private static void fileToSql(String fileUrl) throws Exception{
		
		File file = new File(fileUrl);
		
		InputStream in = new FileInputStream(file);
		Workbook book = Workbook.getWorkbook(in);
		Sheet sheet = book.getSheet(0);
		
		//int cols = sheet.getColumns();
		int rows = sheet.getRows();
		
		StringBuffer out = new StringBuffer();
		
		String userId = ""; 
		
		for(int i=0; i<rows; i++){
			
			StringBuffer insert = new StringBuffer("insert into customer(customer_name,gender,home_phone,phone,email,created_time," +
					"peer_number,is_first,is_owner,is_relation,relation_desc,area_num," +
					"price_num,buy_reson,background,intention_part,rating,rating_remark," +
					"user_id,remark1,remark2,remark3,remark4,created_id," +
					"company_id,project_id,team_id,customer_no,is_deleted,mod_id,mod_time) values ("); //0, created_id, mod_time
			
			Cell[] rowCe = sheet.getRow(i);
			
			userId = rowCe[23].getContents().trim();
			
			for(int index=0; index<=23; index++){
				
				String content = rowCe[index].getContents().trim();
				//System.out.print(content + "\t");
				//System.out.print(getInt(content));
				
				if("".equals(content)){
					content = "0";
				}
				
				insert.append("'")
					.append(content)
					.append("',");
			}
			
			//System.out.println();
			
			Date now = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //2011-11-22 00:15:49
			String date = df.format(now);
			
			insert.append("17,53,0," + "'" + CustomerUtils.getTmpCustomerNo() + "','0','" + userId + "','" + date + "'");
			
			insert.append(");");
			
			//System.out.println(insert.toString());
			out.append(insert.toString()).append("\n");
		}
		
		
		int fileLength = fileUrl.length();
		File outFile = new File(fileUrl.substring(0, fileLength-4) + ".txt");
		FileOutputStream fis = new FileOutputStream(outFile);
		OutputStreamWriter osw = new OutputStreamWriter(fis);
		
		osw.write(out.toString());
		osw.flush();
		
		osw.close();
		
	}
	
	private static Object change(Object obj){
		
		Object clo = obj;
		clo = null;
		
		return obj;
	}
	
	private static void showArr(Object[] arr){
		for(Object a : arr){
			System.out.println(a);
		}
		System.out.println("--------------");
	}
	
	private static void showCache(){
		CacheManager manager = CacheUtils.getCacheManager();
		String[] cacheNames = manager.getCacheNames();
		for(String cacheName : cacheNames){
			System.out.println(cacheName);
		}
		
	}

}
