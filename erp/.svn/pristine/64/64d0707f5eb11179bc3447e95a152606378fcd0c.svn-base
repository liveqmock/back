package com.ihk.customer.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContTable;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;

public class CustomerListDownloadAction extends SupperAction{

	private static final long serialVersionUID = 1L;

	@Autowired ICustomerServices ICustomerServices;
	
	private CustomerCond customerCond;
	private String sessionKey;//如果有 就从session尝试拿 没有 就取传上来的Cond
	
	/**
	 * 导出
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		try{
			
			long start = System.currentTimeMillis();
			
			HttpSession session = request.getSession();
			
			CustomerCond cond = customerCond;
			
			if(sessionKey != null && !sessionKey.trim().equals("")){
				Object o = session.getAttribute(sessionKey);
				if(o != null ){
					cond = (CustomerCond)o;
				}
			}
			
		//	cond.setUserId(SessionUser.getUserId()+"");
			final List<Customer> getList = ICustomerServices.findCustomerForDownload(cond);
			
			String[] ths = new String[]{"客户姓名", "所属项目", "客户评级", "录入日期", "移动电话", "固定电话", "居住区域",
					"工作区域", "购房用途", "置业次数", "意向总价", "产品类型", 
					"客户来源", "销售人员", "来访次数", "性别", "国籍", "身份证号码",
					"驾车车型", "年龄", "地址", "邮编", "家庭结构", "家庭收入", "行业分类",
					"职业", "购买单元1", "购买单元2", "购房目的", "付款方式", "意向面积",
					"意向套数", "意向户型", "认知途径", "关注点", "客户背景", "备注"
					};
			
			final StringBuffer sb = new StringBuffer();
			
			sb.append(ContTable.TABLE_START)
				.append(ContTable.TR_START)
				;
			for(String th : ths){
				sb.append(ContTable.TH_START)
					.append(th)
					.append(ContTable.TH_END)
					;
				
			}
			sb.append(ContTable.TR_END);
			
			//用多线程试试看
			/*
			int size = getList.size();
			int threadCount = size/20 + (size % 20 == 0 ? 0 : 1);//每20条数据一个线程
			
			ExecutorService pool = Executors.newFixedThreadPool(threadCount); //新建一个对应容量的线程池
			try{
				DownloadHandler handler = new DownloadHandler(getList, sb);
				pool.execute(handler);
				
			}finally{
				pool.shutdown();
			}
			*/
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					for(Customer get : getList){
						sb.append(ContTable.TR_START);
						
						for(String value : getFieldValue(get)){
							sb.append(ContTable.TD_START)
								.append(value == null ? "" : value)
								.append(ContTable.TD_END)
								;
						}
						
						sb.append(ContTable.TR_END);
							
					}
					
				}
			}.execute();
			
			sb.append(ContTable.TALBE_END);
			
			String fileName = "download-" + CustomerUtils.getNowForString() + "-.xls";
			ReportUtils.downLoadReport(sb.toString(), fileName, response);
			
			long end = System.currentTimeMillis();
			
			System.out.println(CustomerUtils.getNowForString() + " " + CustomerUtils.getNowTimeForString() 
					+ "\t" + fileName + "下载所花的时间为: " + (end - start)/1000 + "." + (end - start)%1000 + "s");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	
	}
	
	
	private List<String> getFieldValue(Customer cust){
		
		List<String> ret = new ArrayList<String>();
		
		ret.add(cust.getCustomerName());
		ret.add(cust.getProjectName());
		ret.add(cust.getDescRating());
		ret.add(cust.getDownloadCreatedTime());
		ret.add(cust.getPhone());
		
		ret.add(cust.getHomePhone());
		ret.add(cust.getHomeArea());
		ret.add(cust.getWorkArea());
		ret.add(cust.getDescBuyUse());
		
		ret.add(cust.getDescBuyCount());
		ret.add(cust.getPriceNum() + "");
		ret.add(cust.getDescHouseType());
		ret.add(cust.getDescCustomerSource());
		
		ret.add(cust.getDescUserId());
		ret.add(cust.getDescVisitCount());
		ret.add(cust.getDescGender());
		ret.add(cust.getNationality());
		
		ret.add(CommonUtils.isStrEmpty(cust.getIdcardNo()) ? "" : "'" + cust.getIdcardNo()); //避免导出文件不能完全显示
		ret.add(cust.getTrafficDesc());
		ret.add(cust.getDescAge());
		ret.add(cust.getAddress());
		
		ret.add(cust.getPostcode());
		ret.add(cust.getDescFamilyType());
		ret.add(cust.getDescFamilyIncome());
		ret.add(cust.getDescJobType());
		
		ret.add(cust.getDescJobIndustry());
		ret.add(cust.getIntentUnit1());
		ret.add(cust.getIntentUnit2());
		ret.add(cust.getDescBuyAim());
		
		ret.add(cust.getDescPayType());
		ret.add(cust.getAreaNum() + "");
		ret.add(cust.getDescIntentBuynum());
		ret.add(cust.getDescRoomType());
		
		ret.add(cust.getCustomerKnowns());
		ret.add(cust.getCustomerFocus());
		
		//汇悦台
		ret.add(cust.getBackground());
		ret.add(cust.getRemark1());
		
		return ret;
	}


	public CustomerCond getCustomerCond() {
		return customerCond;
	}
	
	
	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}
	
	
	public String getSessionKey() {
		return sessionKey;
	}
	
	
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

}
