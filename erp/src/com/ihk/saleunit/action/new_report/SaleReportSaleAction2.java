package com.ihk.saleunit.action.new_report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.collection.XLSExport;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.pojo.PropertyUnitReportCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * @deprecated 20130628 转为规范SaleReportSaleUnitAction
 * 销售分析 报表(销售 - 详细)
 * */
public class SaleReportSaleAction2 extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired
	IPropertyUnitServices propertyUnitServices;
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractServices contractServices;
	@Autowired
	IContractCustomerServices contractCustomerServices;
	
	private PropertyUnitCond propertyUnitCond;
	private PropertyUnitReportCond urcond;
	private JSONObject res;
	private String initJs;
	private String proIds;
	private String saleName;
	private String salesid;
	int type;
	
	/** 直接点进来 初始化cond */
	public String index() {
		System.out.println("putin");
		try {
		if ( urcond != null ) {
			String[] salesids = urcond.getUserId().split(",");
			int serarchUserId  = 0; 
			for(String sid : salesids){
				if(sid.length()>0){
					serarchUserId = Integer.parseInt(sid);
					break;
				}
			}
			
			saleName = DescUtils.getUserRealName(serarchUserId);
			
			urcond.setUserId(serarchUserId+"");
			
			initJs = "submitSearch()";
		}else{
			urcond = new PropertyUnitReportCond();
			urcond.setDate1(DateTimeUtils.getMonthFirstDayStr(new Date()));
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}

	/**
	 * 销售分析汇总(销售)
	 * @param propertyUnitCond 项目ID
	 * */
	public String search(){
		long star = System.currentTimeMillis();
		System.out.println("进入方法" + System.currentTimeMillis());

		try {
			new MyTransationTemplate() {
				@SuppressWarnings("unchecked")
				@Override
				protected void doExecuteCallback() throws Exception {
					JSONArray proJsList = new JSONArray();
					JSONObject onePro = new JSONObject();
					JSONObject boot = new JSONObject();
					if(urcond.getCompanyProjectId() == 0)return;	
					
					List<Map> listmap;
					if(type == 0){
						listmap = MyPropertyUtils.getPropertyUnitServices().findListMapForReportByPidAndUserIdXX(urcond);
					}else{
						listmap = MyPropertyUtils.getPropertyUnitServices().findListMapForReportByPidAndUserIdContractXX(urcond);
					}
					
					int cou = listmap.size();
					for(Map m : listmap){
						String sales = m.get("r1").toString();
						String names = " -";
						if(sales.equals("")){
						}else if( sales.equals("0")){
						}else{
							String[] s = sales.split(",");
							for(String n : s){
								if(n.equals("") || n.equals("0"))continue;
								try {
									if(names.equals(" -"))names = "";
								names += DescUtils.getUserRealName(Integer.parseInt(n))+" ";
								} catch (Exception e) {
									continue;
								}
							}
						}
						onePro.put("r1", names);
						onePro.put("id",m.get("id"));
						onePro.put("salesName",m.get("salesName"));
						onePro.put("build", m.get("build"));
						onePro.put("roomNo", m.get("roomNo"));
						if(type == 0){
							onePro.put("saleDate",CommonUtils.getDateString((Date)m.get("saleDate")));
						}else {
							onePro.put("saleDate2",CommonUtils.getDateString((Date)m.get("saleDate")));
						}
						int confirm_id=(Integer)m.get("cid");
						List<ContractCustomer> ccList=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirm_id, String.valueOf(type+1));
						String ccName="";
						for(ContractCustomer cc:ccList){
							ccName=ccName+cc.getCustomerName()+" ";
						}
						onePro.put("customerName",ccName);
						onePro.put("buildArea", m.get("buildArea"));
						onePro.put("insideArea", m.get("insideArea"));
						onePro.put("sumPrice", m.get("sumPrice"));
						onePro.put("salePrice",m.get("salePrice"));
						onePro.put("payWay",m.get("payWay"));
						onePro.put("discountPercent",m.get("discountPercent"));
						proJsList.add(onePro);
					}
					boot.put("r1", "合计");
					JSONArray boots = new JSONArray();
					boots.add(boot);
					Map<String, Object> json = new HashMap<String, Object>();
					json.put("total", cou);// total键 存放总记录数，必须的
					json.put("rows", proJsList);// rows键 存放每页记录 list
					res = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
					
					List<Map> dowinfo = new ArrayList<Map>(proJsList);
//					dowinfo.add(oneBoot);
					request.getSession().setAttribute("xs_xsmx", dowinfo);
				}
			}.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		star = System.currentTimeMillis() - star;
		System.out.println("完工=" + star);
		return "suc";
	}
	
	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}


	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
	}


	public JSONObject getRes() {
		return res;
	}

	

	public PropertyUnitReportCond getUrcond() {
		return urcond;
	}

	public void setUrcond(PropertyUnitReportCond urcond) {
		this.urcond = urcond;
	}

	public void setRes(JSONObject res) {
		this.res = res;
	}

	public String getInitJs() {
		return initJs;
	}

	public void setInitJs(String initJs) {
		this.initJs = initJs;
	}

	public String getProIds() {
		return proIds;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setProIds(String proIds) {
		this.proIds = proIds;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	private void initSearchCond(){
		if (propertyUnitCond == null) {
			propertyUnitCond = new PropertyUnitCond();

			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));			
			propertyUnitCond.setSearchCompanyProjectIds(propertyUnitCond.getPrivCompanyProjectIds());
			
		}			
	}
	
	//文件名参数变量
	private String fileName;
	
	public String getFileName() {
        return fileName;
	}

	public void setFileName(String fileName) {
        this.fileName = fileName;
	}
	
	//从下载文件原始存放路径读取得到文件输出流
	public InputStream getDownloadFile() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//todo
		try{
			List<Map> list = new ArrayList();
			Map<String,String> mp = new LinkedHashMap<String,String>(){{
                put("r1", "销售");
                put("buildArea", "建筑面积");
                put("insideArea", "套内面积");
                put("sumPrice", "标准总价");
                put("salePrice", "成交总价");
                
                put("saleDate", "认购日期");
                put("saleDate2", "签约日期");
                put("payWay", "付款方式");
                put("discountPercent", "优惠折扣");
                put("build", "楼栋");
                put("roomNo", "房号");
                
                put("customerName", "客户名称");
			}};
			
			list = (List<Map>) request.getSession().getAttribute("xs_xsmx");
			Date now = new Date();
			fileName = "销售分析(销售 销售明细)"+now.toLocaleString();
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
	
	public String saleReportSaleDownload() throws Exception {
		return SUCCESS;
	}

	public String getSalesid() {
		return salesid;
	}

	public void setSalesid(String salesid) {
		this.salesid = salesid;
	}
	
	
	
	
}



















