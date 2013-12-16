package com.ihk.utils.phone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.utils.CommonUtils;

/**
 * 手机归属地
 * @param phone
 * @return
 */
public class PhoneUtils {
	
	
	private static final String PHONE_URL = "http://shouji.duapp.com/phone.php?m=";
	
	/**
	 * 使用jsoup使得查找获取一些网页数据,可以像jquery一样操作页面元素
	 * @param phone
	 * @return
	 */
	@Deprecated
	public static String phoneFrom(String phone){
		
		String ret = "";
		
		try {
			Document doc = Jsoup.connect(PHONE_URL + phone).timeout(6000).get();
			
			Elements eles = doc.select("body");
			
			Element ele = eles.get(0);
			
			List<TextNode> nodes = ele.textNodes();
			
			String text = nodes.get(1).getWholeText();
			
			String tmp = text.split("：")[1].trim();
			
			if(!ret.equals(tmp.split("-")[1])){
				
				ret = tmp;
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return ret;
		
	}
	
	/**
	 * 批量为客户设置号码归属地
	 * @param list
	 * @return
	 */
	public static List<Customer> postPhone(List<Customer> list){
		
		try{
			
			if(CommonUtils.isCollectionEmpty(list))
				return list;
		
			String url = "http://hd2001562.ourhost.cn/p.php";
			
			StringBuffer sb = new StringBuffer();
			sb.append("haomas=");
			
			for(Customer cus : list){
				
				sb.append(cus.getPhone()).append("\n");
			}
			
			String tmp = sb.toString();
			int length = tmp.length();
			String value = tmp.substring(0, length-2);
			
			//value = "haomas=13711706669\n13922189899\n13650563616\n98718988\n13724877556\n13703741117\n13907798889\n13802968369\n13318709027\n13808820617";
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("haomas", value);
			Response res = Jsoup.connect(url).timeout(4000).data(map).method(Method.POST).execute();
			
			Document doc = res.parse();
			String html = doc.select("p").first().html();
			
			String[] lines = html.split("<br />");
			
			Customer tmpCus = new Customer();
			String line = "";
			for(int i=0; i<lines.length; i++){
				
				tmpCus = list.get(i);
				line = lines[i];
				
				try{
					
					String startStr = "color=\"blue\">";
					String endStr = "</font>";
					int start = line.indexOf(startStr);
					int end = line.indexOf(endStr);
					
					String area = line.substring(start+startStr.length(), end).split(",")[0];
					tmpCus.setPhoneFrom(area);
					
				}catch(Exception e){
					tmpCus.setPhoneFrom("");
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 为传进来的客户设置号码归属地
	 * @param customer
	 * @return
	 */
	public static Customer postPhone(Customer customer){
		
		try{
			
			if(CommonUtils.isStrEmpty(customer.getPhone()))
				return customer;
		
			/*String url = "http://hd2001562.ourhost.cn/p.php";
			
			StringBuffer sb = new StringBuffer();
			sb.append("haomas=").append(customer.getPhone());
			
			String tmp = sb.toString();
			int length = tmp.length();
			String value = tmp.substring(0, length-2);
			
			//value = "haomas=13711706669\n13922189899\n13650563616\n98718988\n13724877556\n13703741117\n13907798889\n13802968369\n13318709027\n13808820617";
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("haomas", value);
			Response res = Jsoup.connect(url).timeout(4000).data(map).method(Method.POST).execute();
			
			Document doc = res.parse();
			String html = doc.select("p").first().html();
			
			String[] lines = html.split("<br />");
			
			String line = "";
			for(int i=0; i<lines.length; i++){
				
				line = lines[i];
				
				try{
					
					String startStr = "color=\"blue\">";
					String endStr = "</font>";
					int start = line.indexOf(startStr);
					int end = line.indexOf(endStr);
					
					String area = line.substring(start+startStr.length(), end).split(",")[0];
					customer.setPhoneFrom(area);
					
				}catch(Exception e){
					customer.setPhoneFrom("");
				}
				
			}*/
			
			List<Customer> list = new ArrayList<Customer>();
			list.add(customer);
			
			list = postPhoneForcha14(list);
			customer = list.get(0);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return customer;
	}
	
	/**
	 * 从http://cha14.com中获取
	 * @param list
	 * @return
	 */
	public static List<Customer> postPhoneForcha14(List<Customer> list){
		
		try{
			
			if(CommonUtils.isCollectionEmpty(list))
				return list;
		
			String url = "http://cha14.com/index.php";
			
			StringBuffer sb = new StringBuffer();
			
			String phone = "";
			for(Customer cus : list){
				
				phone = CommonUtils.isStrEmpty(cus.getPhone()) ? "" : cus.getPhone().trim();
				sb.append(phone).append("\n");
			}
			
			String tmp = sb.toString();
			
			int length = tmp.length();
			String value = tmp.substring(0, length-1);
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("textarea", value);
			map.put("dopost", "insert");
			Response res = Jsoup.connect(url).timeout(1000000).data(map).method(Method.POST).execute();
			
			Document doc = res.parse();
			Elements trs = doc.select("table tr");
			List<Element> eleList = trs.subList(2, trs.size());
			
			int cusCount = list.size();
			
			String from = null;
			
			for(int i=0; i<cusCount; i++){
				
				try{
					
					from = eleList.get(i).select("td").get(2).text();
					
				}catch (Exception e) {
					
				}
				
				if(CommonUtils.isStrEmpty(from)){
					from = "暂无信息";
				}
				list.get(i).setPhoneFrom(from);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		/*Customer customer = new Customer();
		customer.setPhone("13802925711");
		System.out.println(customer.getPhoneFrom());
		
		customer = postPhone(customer);
		System.out.println(customer.getPhoneFrom());*/
		
		List<Customer> list = new ArrayList<Customer>();
		
		Customer c1 = new Customer();
		c1.setPhone("14790410049");
		
		Customer c2 = new Customer();
		c2.setPhone(null);
		
		Customer c3 = new Customer();
		c3.setPhone("18656021779");
		
		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		list = postPhoneForcha14(list);
		
		//list = postPhone(list);
		
		for(Customer cu : list){
			
			System.out.println(cu.getPhoneFrom());
		}
		
		//http://www.xiaozhu.com/ajax.php?op=sendPhoneNum&phone=13450378198&aisle=null
		
		/*String url = "http://www.xiaozhu.com/ajax.php?op=sendPhoneNum&phone=13450378198&aisle=null";
		
		Connection conn = Jsoup.connect(url).timeout(4000).method(Method.GET);
		conn.execute();
		
		for(int i=1; i<=10; i++){
			
			Document doc = Jsoup.connect(url).timeout(6000).get();
			System.out.println(doc.body().attr("status"));
			
		}*/
		
		/*long start = System.currentTimeMillis();
		
		String phone = "13450378198";
		Customer customer = new Customer();
		customer.setPhone(phone);
		
		postPhone(customer);
		
		//phoneFrom(phone);
		
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);*/
		
		/*Customer cus = new Customer();
		cus.setPhone("13450378198");
		postPhone(cus);
		System.out.println(cus.getPhoneFrom());*/
		
		//System.out.println(phoneFrom("15910888361"));
		
		//postPhone(new ArrayList<Customer>());
		
		/*System.out.println(phoneFrom2("13450378198"));
		
		long start = System.currentTimeMillis();
		
		for(int i=0; i<=9; i++){
			//System.out.println(phoneFrom2("1345037819" + i));
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println((end-start));*/
		
	}
	
}
