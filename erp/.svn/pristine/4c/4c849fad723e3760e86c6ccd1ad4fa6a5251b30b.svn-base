package com.ihk.sale.action.guangzhou;

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

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.collection.XLSExport;
import com.ihk.customer.data.ICustomerMapper;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 * 项目客户数量图形action
 * @author peter.kuang
 *
 */
public class ChartProjectCustomerNumAction extends SupperAction {

	@Autowired
	ICustomerMapper iCustomerMapper;

	@Autowired
	ICompanyProjectServices iCompanyProjectServices;
	private CustomerCond cond;
	private String projectName;
	private String datetype;
	private List<Map> custList;
	private String tt;//是否有查看详细资料权限
	private String ttt;//是否单项目
	
	public String projectAndCustNumFirst() throws Exception{
		
		initlist();
		
		return "projectAndCustNumFirst";
	}
	
	/** 直接点进来 初始化cond */
	public String index() {
		// 初始化cond
		// 初始化显示列表
		tt = "";
		ttt = "";
		initlist();
		return "success";
	}

	/** 提交form 表单 初始化cond */
	public String search() {
		initlist();
		return "success";
	}

	// 初始化显示列表
	private void initlist() {
		// 得到一个customer list

		if (cond == null) {
			cond = new CustomerCond();
			cond.addPermissionChartProjectIds();			
			cond.setSearchProjectIds(cond.getPrivProjectIds());
			cond.setDate1(CommonUtils.getLastWeekFirstForString());
			cond.setDate2(CommonUtils.getOneDayBeforeForString(new Date()));
		}
		else{
			if(cond.getPrivProjectIds()==null){
				cond.addPermissionChartProjectIds();					
			}			
		}

		List<Integer> prlist = PermissionUtils
				.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD);
		if (prlist == null || prlist.size() == 0) {
			addActionMessage("没有管理用户权限");
			return;
		}else if(prlist.size() == 1){
			ttt = "yes";
			this.cond.setProjectId(prlist.get(0));
			this.projectName = DescUtils.getCompanyProjectRealName(prlist.get(0));
		}
		if(!PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER__DOWNLOAD, EnumDevFlag.GUANGZHOU)){
			tt = "yes";
		}
		//this.cond.setProjectIds(prlist);
		if (datetype != null) {
			if (datetype.equals("week")) {
				cond.setDate1(CommonUtils.getWeekFirstForString());
				cond.setDate2(CommonUtils.getWeekEndForString());
			} else if (datetype.equals("month")) {
				cond.setDate1(CommonUtils.getMonthFirstForString());
				cond.setDate2(CommonUtils.getMonthEndForString());
			}
		}
		// custList = custList.find...
		try {
			if(cond.getProjectId() != 0 ){
				cond.setProjectIds(null);
			}
			custList = iCustomerMapper
					.findCustomerForChartProjectCustomerNumAction(cond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 得到符合要求的项目列表
		CompanyProjectCond procond = new CompanyProjectCond();
		procond.setProjectIds(cond.getProjectIds());
		procond.setDevCode("customer_guangzhou");
		List<CompanyProject> proList = iCompanyProjectServices
				.findCompanyProjectPage(procond);
		setChartSeriesData(custList);
		if (custList == null || custList.isEmpty()) {
			custList = new ArrayList<Map>();
			setChartSeriesData(custList);
			if (this.cond.getProjectId() == 0) {

				for (CompanyProject pro : proList) {
					Map e = new HashMap();
					e.put("projectId", pro.getId());
					e.put("projectName", pro.getProjectName());
					e.put("count", 0);
					custList.add(e);
				}
			}
		}

		List<Map> temlist = new ArrayList<Map>();
		temlist.addAll(custList);
		if (this.cond.getProjectId() == 0) {
			if (temlist.size() < proList.size()) {
				for (CompanyProject pro : proList) {
					boolean ti = true;
					for (Map p : temlist) {
						if ((Integer) p.get("projectId") == pro.getId())
							ti = false;
					}
					if (ti) {
						Map e = new HashMap();
						e.put("projectId", pro.getId());
						e.put("projectName", pro.getProjectName());
						e.put("count", 0);
						custList.add(e);
					}
				}
			}
		}
		// 添加合计

		int sum = 0;
		for (Map p : temlist) {
			sum += Integer.parseInt((p.get("count").toString()));
		}
		if (sum == 0) {
			for (Map p : temlist) {
				p.put("pei", 0 + "%");
			}
		} else {
			for (Map p : temlist) {
				p.put("pei", Long.parseLong(p.get("count").toString()) * 100
						/ sum + "%");
			}
		}

		Map e = new HashMap();
		e.put("projectName", "合计");
		e.put("count", sum);
		e.put("pei", "100%");
		custList.add(e);
		
		request.getSession().setAttribute("custList", custList);
	}

	private String chartSeriesData;

	private void setChartSeriesData(List<Map> custList) {
		if (custList == null || custList.size() == 0) {
			this.chartSeriesData = "['无数据',1]";
			return;
		}
		String str = "";
		for (Map p : custList) {
			str += "['" + p.get("projectName") + "'," + p.get("count") + "]"
					+ ",";
		}
		this.chartSeriesData = str;
	}

	public String getChartSeriesData() {
		return this.chartSeriesData;
	}

	public void setCond(CustomerCond cond) {
		this.cond = cond;
	}

	public List<Map> getCustList() {
		return custList;
	}

	public CustomerCond getCond() {
		return cond;
	}

	public String getProjectName() {
		return DescUtils.getCompanyProjectRealName(this.cond.getProjectId());

	}

	public String getDatetype() {
		return datetype;
	}

	public void setDatetype(String datetype) {
		this.datetype = datetype;
	}

	public String getTt() {
		return tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

	public String getTtt() {
		return ttt;
	}

	public void setTtt(String ttt) {
		this.ttt = ttt;
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
		
		try{
			List<Map> list = new ArrayList();
			Map<String,String> mp = new LinkedHashMap<String,String>(){{
				put("projectName", "项目");
				put("count", "客户量");
				put("pei", "比例");
			}};
			
			list = (List<Map>) request.getSession().getAttribute("custList");
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
	
	/**
	 * 导出
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		return SUCCESS;
	}

}
