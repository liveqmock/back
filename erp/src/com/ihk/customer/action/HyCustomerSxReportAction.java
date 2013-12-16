package com.ihk.customer.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerPhoneMulProject;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerPhoneMulProjectCond;
import com.ihk.report.data.services.IReportPreCustomerServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.onlyfollow.CustomerOnlyFollowUtils;

/**
 * 活跃客户筛选报表
 * @author peter.kuang
 *
 */
public class HyCustomerSxReportAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	ICustomerServices customerServices;
	@Autowired
	IUserAccountServices userAccountServices;

	@Autowired 
	IReportPreCustomerServices reportServices;

	private ReportPreCustomerPhoneMulProjectCond cond;

	public ReportPreCustomerPhoneMulProjectCond getCond() {
		return cond;
	}

	public void setCond(ReportPreCustomerPhoneMulProjectCond reportPreCustomerPhoneMulProjectCond) {
		this.cond = reportPreCustomerPhoneMulProjectCond;
	}

	/**
	 * 直接返回查询的列表格式
	 * @return
	 * @throws Exception
	 */
	public String index() throws Exception {
		return SUCCESS;
	}
	

	/**
	 * 点击查询的数据返回
	 * @return
	 * @throws Exception
	 */
	public String customerQueryAjax() throws Exception {
		if(cond==null){
			cond = new ReportPreCustomerPhoneMulProjectCond();
		}
		setCondOrderSortByRequest(cond);
		
		ActionTemplate.executeAjaxPage(this, cond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				//不分页的做法
				cond.pageSize = 0;
				return 0;
			}
			
			//获取table中要显示的json
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
				
				List<ReportPreCustomerPhoneMulProject> list = reportServices.phoneMulProject(cond);				
				
				if(!CommonUtils.isCollectionEmpty(list)){
					List<String> phoneList = new ArrayList<String>();
					for(int i=0; i<list.size(); i++){
						phoneList.add(list.get(i).getPhone());
					}
					cond.setPhoneList(phoneList);
					
					//所有的客户明细
					List<Customer> listCustomer = reportServices.phoneMulProjectDetail(cond);
					//HashMap的存储格式[phone,[customerList]]
					//HashMap性能提升，用于提升遍历性能,设置对象的主从关系
					HashMap<String,List<Customer>> phoneCustomerList = new HashMap<String,List<Customer>>();
					for(int i=0; i<list.size(); i++){
						phoneCustomerList.put(list.get(i).getPhone(), new ArrayList<Customer>());
					}
					
					for(Customer c : listCustomer){
						phoneCustomerList.get(c.getPhone()).add(c);
					}
					
					for(int i=0; i<list.size(); i++){
						list.get(i).setCustomerList(phoneCustomerList.get(list.get(i).getPhone()));					
					}					
					
					Map<String, String> map = null;
					
					//与jsp中table的表头(th field)定义一致
					for(int i=0; i<list.size(); i++){
						map = new HashMap<String, String>();
						
						map.put("phone", list.get(i).getPhone());
						map.put("projectCount", String.valueOf(list.get(i).getProjectCount()));
						
						retList.add(map);
					}

					setDetailDataInSession(phoneCustomerList);	
					setDownloadDataInSession(list);					
				}
				
				return retList;
			}
		});
		return null;
	}

	/**
	 * session保存页面当前数据，用于下载
	 * @param dataList
	 */
	private void setDownloadDataInSession(List<ReportPreCustomerPhoneMulProject> dataList){
		request.getSession().setAttribute(ContSessionAttribute.KXMKHMX+ContSessionAttribute.DOWNLOAD_DATA, dataList);		
	}

	/**
	 * session保存页面当前明细数据，用于查看客户明细
	 * @param dataList
	 */
	private void setDetailDataInSession(HashMap<String,List<Customer>> phoneCustomerList){
		request.getSession().setAttribute(ContSessionAttribute.KXMKHMX+ContSessionAttribute.DETAIL, phoneCustomerList);		
	}
	

	/**
	 * 下载分组
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception {
		@SuppressWarnings("unchecked")
		List<ReportPreCustomerPhoneMulProject> dataList = (List<ReportPreCustomerPhoneMulProject>) request.getSession().getAttribute(ContSessionAttribute.KXMKHMX+ContSessionAttribute.DOWNLOAD_DATA);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList); //与模板里面的循环要求对应
		
		ReportUtils.downLoadReport(map, "mulproject-phone.xls", "download-活跃客户筛选报表(电话)" + CustomerUtils.getNowForString() + "-.xls", response);
		
		return null;
	}
	

	/**
	 * 下载明细
	 * @return
	 * @throws Exception
	 */
	public String downloadDetail() throws Exception {
		@SuppressWarnings("unchecked")
		List<ReportPreCustomerPhoneMulProject> dataList = (List<ReportPreCustomerPhoneMulProject>) request.getSession().getAttribute(ContSessionAttribute.KXMKHMX+ContSessionAttribute.DOWNLOAD_DATA);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList); //与模板里面的循环要求对应
		
		ReportUtils.downLoadReport(map, "mulproject-phone-customer.xls", "download-活跃客户筛选报表明细(客户)" + CustomerUtils.getNowForString() + "-.xls", response);
		
		return null;
	}
	

	/**
	 * 相关电话的明细列表格式
	 * @return
	 * @throws Exception
	 */
	public String phoneDetailList() throws Exception {
		return SUCCESS;		
	}

	/**
	 * 相关电话的明细列表格式，实际查询
	 * @return
	 * @throws Exception
	 */
	public String phoneDetailListAjax() throws Exception {	
		System.out.println("dd");
		if(cond==null){
			cond = new ReportPreCustomerPhoneMulProjectCond();
		}

		ActionTemplate.executeAjaxPage(this, cond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				//不分页的做法
				cond.pageSize = 0;
				return 0;
			}
			
			//获取table中要显示的json
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				HashMap<String,List<Customer>> phoneCustomerList = (HashMap)request.getSession().getAttribute(ContSessionAttribute.KXMKHMX+ContSessionAttribute.DETAIL);
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
				Map<String, String> map = null;
						
				List<Customer> list = phoneCustomerList.get(cond.getPhone());
				//与jsp中table的表头(th field)定义一致
				if(list!=null){
					for(int i=0; i<list.size(); i++){
						map = new HashMap<String, String>();
						
						map.put("phone", list.get(i).getPhone());
						map.put("customerName", list.get(i).getCustomerName());
						map.put("projectName", list.get(i).getProjectName());
						map.put("salesName", list.get(i).getDescUserId());
						
						retList.add(map);
					}
				}
				
				return retList;	
			}
		});	
		
		return null;
	}
	
	

}
