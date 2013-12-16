package com.ihk.customer.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.collection.XLSExport;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.setting.data.pojo.ProjectCodeCond;
import com.ihk.setting.data.services.IProjectCodeServices;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 * 报表用用户LIST
 * */
public class CustomerListByReportAction extends SupperAction{

	@Autowired ICustomerServices customerServices;
	@Autowired IProjectCodeServices projectCodeServices;
	private CustomerCond customerCond;
	private List<Customer> customerList;
	
	
	public String search(){
		//参数：区域 天河
		
		System.out.println(this.request);
		if(customerCond != null){
			this.request.getSession().setAttribute("customerCond", customerCond);
		}		

		Object c = this.request.getSession().getAttribute("customerCond");
		if(c != null){
			customerCond = (CustomerCond)c;
		}else{
			customerCond = new CustomerCond();
			HttpSession session = request.getSession();
			session.setAttribute("customerCond", customerCond); 
		}
		
		autoSetCondByParameter();
		return "suc";
	}

	/**
	 * 自动根据参数设置条件
	 */
	private void autoSetCondByParameter(){
		if(customerCond.getGroupField()!=null){
			autoSetCondByParameter_GroupField();
		}
		else if(customerCond.getCol1()!=null){
			autoSetCondByParameter_Col2();			
		}
		else{
			customerCond.setGroupField(request.getParameter("groupValue1").toString());
		}
		request.getSession().removeAttribute("customerCond");
		request.getSession().setAttribute("customerCond", customerCond);
	}
	
	/**
	 * 自动根据参数设置条件
	 */
	private void autoSetCondByParameter_GroupField(){
		
		//来访次数
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.VISIT_COUNT.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setVisitCount(Integer.parseInt(request.getParameter("groupValue1").toString()));
			}
		}
		
		//居住区域
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.HOME_DISTRICT.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setHomeRegion(request.getParameter("groupValue1").toString());
			}
		}
		
		//工作区域
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.WORK_DISTRICT.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setWorkRegion(request.getParameter("groupValue1").toString());
			}			
		}
		
		//购房用途
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.BUY_USE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setBuyUse(request.getParameter("groupValue1").toString());
			}			
		}

		//置业次数
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.BUY_COUNT.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setBuyCount(request.getParameter("groupValue1").toString());
			}			
		}

		//意向总价
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.PRICE_AMOUNT.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setPriceAmount(request.getParameter("groupValue1").toString());
			}			
		}

		//产品类型
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.HOUSE_TYPE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setHouseType(request.getParameter("groupValue1").toString());
			}			
		}

		//客户来源
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.CUSTOMER_SOURCE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setCustomerSource(request.getParameter("groupValue1").toString());
			}			
		}

		//性别
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.GENDER.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setGender(request.getParameter("groupValue1").toString());
			}			
		}

		//年龄
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.AGE_RANGE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setAgeRange(request.getParameter("groupValue1").toString());
			}			
		}

		//家庭结构
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.FAMILY_TYPE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setFamilyType(request.getParameter("groupValue1").toString());
			}			
		}

		//家庭收入
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.FAMILY_INCOME.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setFamilyIncome(request.getParameter("groupValue1").toString());
			}			
		}

		//行业分类
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.JOB_TYPE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setJobType(request.getParameter("groupValue1").toString());
			}			
		}

		//职业
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.JOB_INDUSTRY.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setJobIndustry(request.getParameter("groupValue1").toString());
			}			
		}

		//购房目的
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.BUY_AIM.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setBuyAim(request.getParameter("groupValue1").toString());
			}			
		}

		//付款方式
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.PAY_TYPE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setPayType(request.getParameter("groupValue1").toString());
			}			
		}

		//意向套数
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.INTENT_BUYNUM.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setIntentBuynum(request.getParameter("groupValue1").toString());
			}			
		}

		//意向户型
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.ROOM_TYPE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setRoomType(request.getParameter("groupValue1").toString());
			}			
		}
		
		//认知途径
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.KNOWN_FROM.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setCustomerKnown(request.getParameter("groupValue1").toString());
			}			
		}
		
		//关注点
		if(customerCond.getGroupField().equalsIgnoreCase(EnumCodeTypeName.CUSTOMER_FOCUS.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setCustomerFocus(request.getParameter("groupValue1").toString());
			}			
		}
	
		if(customerCond.getGroupField().matches("^[0-9]+$")){
			customerCond.setGroupField(request.getParameter("groupValue1").toString());
		}
	}

	/**
	 * 自动根据参数设置条件(交叉分析)
	 */
	private void autoSetCondByParameter_Col2(){
		//居住区域
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.HOME_DISTRICT.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setHomeRegion(request.getParameter("groupValue1").toString());
			}
		}
		
		//工作区域
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.WORK_DISTRICT.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setWorkRegion(request.getParameter("groupValue1").toString());
			}			
		}
		
		//购房用途
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.BUY_USE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setBuyUse(request.getParameter("groupValue1").toString());
			}			
		}

		//置业次数
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.BUY_COUNT.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setBuyCount(request.getParameter("groupValue1").toString());
			}			
		}

		//意向总价
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.PRICE_AMOUNT.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setPriceAmount(request.getParameter("groupValue1").toString());
			}			
		}

		//产品类型
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.HOUSE_TYPE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setHouseType(request.getParameter("groupValue1").toString());
			}			
		}

		//客户来源
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.CUSTOMER_SOURCE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setCustomerSource(request.getParameter("groupValue1").toString());
			}			
		}

		//性别
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.GENDER.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setGender(request.getParameter("groupValue1").toString());
			}			
		}

		//年龄
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.AGE_RANGE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setAgeRange(request.getParameter("groupValue1").toString());
			}			
		}

		//家庭结构
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.FAMILY_TYPE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setFamilyType(request.getParameter("groupValue1").toString());
			}			
		}

		//家庭收入
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.FAMILY_INCOME.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setFamilyIncome(request.getParameter("groupValue1").toString());
			}			
		}

		//行业分类
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.JOB_TYPE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setJobType(request.getParameter("groupValue1").toString());
			}			
		}

		//职业
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.JOB_INDUSTRY.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setJobIndustry(request.getParameter("groupValue1").toString());
			}			
		}

		//购房目的
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.BUY_AIM.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setBuyAim(request.getParameter("groupValue1").toString());
			}			
		}

		//付款方式
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.PAY_TYPE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setPayType(request.getParameter("groupValue1").toString());
			}			
		}

		//意向套数
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.INTENT_BUYNUM.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setIntentBuynum(request.getParameter("groupValue1").toString());
			}			
		}

		//意向户型
		if(customerCond.getCol1().equalsIgnoreCase(EnumCodeTypeName.ROOM_TYPE.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setRoomType(request.getParameter("groupValue1").toString());
			}			
		}	
		
		//以下col2的匹配

		//居住区域
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.HOME_DISTRICT.toString())){
			if(request.getParameter("groupValue1")!=null){
				customerCond.setHomeRegion(request.getParameter("groupValue2").toString());
			}
		}
		
		//工作区域
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.WORK_DISTRICT.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setWorkRegion(request.getParameter("groupValue2").toString());
			}			
		}

		//购房用途
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.BUY_USE.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setBuyUse(request.getParameter("groupValue2").toString());
			}			
		}

		//置业次数
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.BUY_COUNT.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setBuyCount(request.getParameter("groupValue2").toString());
			}			
		}

		//意向总价
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.PRICE_AMOUNT.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setPriceAmount(request.getParameter("groupValue2").toString());
			}			
		}

		//产品类型
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.HOUSE_TYPE.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setHouseType(request.getParameter("groupValue2").toString());
			}			
		}

		//客户来源
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.CUSTOMER_SOURCE.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setCustomerSource(request.getParameter("groupValue2").toString());
			}			
		}

		//性别
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.GENDER.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setGender(request.getParameter("groupValue2").toString());
			}			
		}

		//年龄
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.AGE_RANGE.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setAgeRange(request.getParameter("groupValue2").toString());
			}			
		}

		//家庭结构
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.FAMILY_TYPE.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setFamilyType(request.getParameter("groupValue2").toString());
			}			
		}

		//家庭收入
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.FAMILY_INCOME.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setFamilyIncome(request.getParameter("groupValue2").toString());
			}			
		}

		//行业分类
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.JOB_TYPE.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setJobType(request.getParameter("groupValue2").toString());
			}			
		}

		//职业
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.JOB_INDUSTRY.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setJobIndustry(request.getParameter("groupValue2").toString());
			}			
		}

		//购房目的
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.BUY_AIM.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setBuyAim(request.getParameter("groupValue2").toString());
			}			
		}

		//付款方式
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.PAY_TYPE.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setPayType(request.getParameter("groupValue2").toString());
			}			
		}

		//意向套数
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.INTENT_BUYNUM.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setIntentBuynum(request.getParameter("groupValue2").toString());
			}			
		}

		//意向户型
		if(customerCond.getCol2().equalsIgnoreCase(EnumCodeTypeName.ROOM_TYPE.toString())){
			if(request.getParameter("groupValue2")!=null){
				customerCond.setRoomType(request.getParameter("groupValue2").toString());
			}			
		}		
	}

	private JSONObject res;
	private int rows;
	private int page;
	/**
	 * 得到客户资料JSON
	 * */
	private Object deepClone(Object object) throws IOException, ClassNotFoundException    
	{    
		//将对象写到流里    
		ByteArrayOutputStream bo=new ByteArrayOutputStream();    
		ObjectOutputStream oo=new ObjectOutputStream(bo);    
		oo.writeObject(object);    
		//从流里读出来    
		ByteArrayInputStream bi=new ByteArrayInputStream(bo.toByteArray());    
		ObjectInputStream oi=new ObjectInputStream(bi);    
		return(oi.readObject());    
	}   
	
	public String searchCustomerList(){
			Object c = this.request.getSession().getAttribute("customerCond");
			if(c != null){
				customerCond = (CustomerCond)c;
			}else{
				customerCond = new CustomerCond();
			}

			int recordCount=0;
			customerCond.pageSize = rows;
			customerCond.startLine = (page - 1) * rows;
			JSONArray proJsList = new JSONArray();
			JSONArray downloadJsList = new JSONArray();
			JSONObject onePro = new JSONObject();
			if(customerCond.getTopicId()==null){
				this.customerList = this.customerServices.findCustomerPage(customerCond);
				recordCount=customerCond.recordCount;
				for(Customer cc : customerList){
					onePro.put("name", cc.getCustomerName());
					onePro.put("phone1", cc.getPhone());
					onePro.put("phone2", cc.getHomePhone());
					onePro.put("id", cc.getId());
					onePro.put("cuser", cc.getDescCreatedId());
					
					onePro.put("area", cc.getAreaNum());
					onePro.put("price", cc.getPriceNum());
					onePro.put("ctime", cc.getCreatedTime().toLocaleString());
					onePro.put("pro", cc.getDescProjectId());
					proJsList.add(onePro);
				}
				customerCond.startLine=0;
				customerCond.pageSize=0;
				List<Customer> downloadList=this.customerServices.findCustomerSearch(customerCond);
				for(Customer cc : downloadList){
					onePro.put("name", cc.getCustomerName());
					onePro.put("phone1", cc.getPhone());
					onePro.put("phone2", cc.getHomePhone());
					onePro.put("id", cc.getId());
					onePro.put("cuser", cc.getDescCreatedId());
					
					onePro.put("area", cc.getAreaNum());
					onePro.put("price", cc.getPriceNum());
					onePro.put("ctime", cc.getCreatedTime().toLocaleString());
					onePro.put("pro", cc.getDescProjectId());
					downloadJsList.add(onePro);
				}
				Map<String, Object> json = new HashMap<String, Object>();
				json.put("total", recordCount);// total键 存放总记录数，必须的
				json.put("rows", proJsList);// rows键 存放每页记录 list
				res = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
				
				
				List<Map> dowinfo = new ArrayList<Map>(downloadJsList);
				request.getSession().setAttribute("flmxkurep", dowinfo);
			}else{
				int startLine = customerCond.startLine;
				int pageSize = customerCond.pageSize;
				customerCond.startLine=0;
				customerCond.pageSize=0;
				this.customerListMap = this.customerServices.findCustomerPageReport(customerCond);
				for(Map cc : customerListMap){
					String[] s=cc.get("anwserContent").toString().split("\\r\\n");
					for(String arr:s){
						if(arr.startsWith("1")){
							ProjectCodeCond cond=new ProjectCodeCond();
							cond.setCodeDesc(arr.split(":")[1]);
							cond.setTypeName(cc.get("topicId").toString());
							//System.out.println(projectCodeServices.findProjectCode(cond).getCodeVal());
							if(projectCodeServices.findProjectCode(cond).getCodeVal().equals(customerCond.getGroupField())){
								onePro.put("name", cc.get("customerName"));
								onePro.put("phone1", cc.get("phone"));
								onePro.put("phone2", cc.get("homePhone"));
								onePro.put("id", cc.get("id"));
								onePro.put("cuser", DescUtils.getUserRealName(Integer.valueOf(cc.get("descCreatedId").toString())));
								
								onePro.put("area", cc.get("areaNum"));
								onePro.put("price", cc.get("priceNum"));
								onePro.put("ctime", new SimpleDateFormat("yyyy-MM-dd").format(cc.get("createdTime")));
								onePro.put("pro", cc.get("descProjectId"));
								proJsList.add(onePro);
								recordCount++;
							}	
						}
					}	
				}
//				customerCond.startLine=0;
//				customerCond.pageSize=0;
//				List<Customer> downloadList=this.customerServices.findCustomerSearch(customerCond);
//				for(Customer cc : downloadList){
//					onePro.put("name", cc.getCustomerName());
//					onePro.put("phone1", cc.getPhone());
//					onePro.put("phone2", cc.getHomePhone());
//					onePro.put("id", cc.getId());
//					onePro.put("cuser", cc.getDescCreatedId());
//					
//					onePro.put("area", cc.getAreaNum());
//					onePro.put("price", cc.getPriceNum());
//					onePro.put("ctime", cc.getCreatedTime().toLocaleString());
//					onePro.put("pro", cc.getDescProjectId());
//					downloadJsList.add(onePro);
//				}
				//customerCond.recordCount=recordCount;
				JSONArray proFinalJsList= new JSONArray();;
				for(int i=startLine;i<startLine+pageSize;i++){
					if(i<proJsList.size()){
						proFinalJsList.add(proJsList.get(i));
					}else{
						break;
					}
				}
				Map<String, Object> json = new HashMap<String, Object>();
				json.put("total", recordCount);// total键 存放总记录数，必须的
				json.put("rows", proFinalJsList);// rows键 存放每页记录 list
				res = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
				
				
				List<Map> dowinfo = new ArrayList<Map>(proJsList);
				request.getSession().setAttribute("flmxkurep", dowinfo);
			}
			
//			Map<String, Object> json = new HashMap<String, Object>();
//			json.put("total", recordCount);// total键 存放总记录数，必须的
//			json.put("rows", proJsList);// rows键 存放每页记录 list
//			res = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
//			
//			
//			List<Map> dowinfo = new ArrayList<Map>(downloadJsList);
//			request.getSession().setAttribute("flmxkurep", dowinfo);
			return "suc";
	}
	
	public JSONObject getRes() {
		return res;
	}

	public void setRes(JSONObject res) {
		this.res = res;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public ICustomerServices getCustomerServices() {
		return customerServices;
	}

	public void setCustomerServices(ICustomerServices customerServices) {
		this.customerServices = customerServices;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	
	public String saleReportDownload() throws Exception {
		return SUCCESS;
	}
	
	//文件名参数变量
	private String fileName;
	
	public String getFileName() {
        return fileName;
	}

	public void setFileName(String fileName) {
        this.fileName = fileName;
	}
	
	private List<Map> customerListMap;
	
	public List<Map> getCustomerListMap() {
		return customerListMap;
	}

	public void setCustomerListMap(List<Map> customerListMap) {
		this.customerListMap = customerListMap;
	}

	//从下载文件原始存放路径读取得到文件输出流
	public InputStream getDownloadFile() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//todo
		try{
			List<Map> list = new ArrayList();
			Map<String,String> mp = new LinkedHashMap<String,String>(){{
				put("name", "客户名称");
				put("phone1", "移动电话");
				put("phone2", "固定电话");
				put("area", "意向面积");
				
				put("price", "意向总价");
				put("pro", "项目");
				put("cuser", "录入人员");
				
				put("ctime", "录入时间");
			}};
			list = (List<Map>) request.getSession().getAttribute("flmxkurep");
			Date now = new Date();
			fileName = "客户明细"+now.toLocaleString();
			XLSExport.exportExcel(mp, list).write(baos);
		}catch(Exception e){
			e.printStackTrace();
		}
		byte[] ba = baos.toByteArray();  
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        return bais;
	}
	
	//如果下载文件名为中文，进行字符编码转换
	public String getDownloadChineseFileName() {
	        String downloadChineseFileName = fileName;
	        try {
	                  downloadChineseFileName = new String(downloadChineseFileName.getBytes(),"ISO8859-1");
	        } catch(UnsupportedEncodingException e) {
	                  e.printStackTrace();
	        }
	        return downloadChineseFileName;
	}
}
