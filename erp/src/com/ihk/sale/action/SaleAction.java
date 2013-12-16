package com.ihk.sale.action;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorAll;
import com.ihk.sale.data.pojo.SaleMonitorAllCond;
import com.ihk.sale.data.pojo.SaleMonitorAllList;
import com.ihk.sale.data.pojo.SaleMonitorAmount;
import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.pojo.SaleMonitorMonth;
import com.ihk.sale.data.pojo.SaleMonitorMonthCond;
import com.ihk.sale.data.pojo.SaleMonitorWeek;
import com.ihk.sale.data.pojo.SaleMonitorWeekCond;
import com.ihk.sale.data.services.ISaleMonitorAllServices;
import com.ihk.sale.data.services.ISaleMonitorMonthServices;
import com.ihk.sale.data.services.ISaleMonitorServices;
import com.ihk.sale.data.services.ISaleMonitorWeekServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.Pager;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 销控数据
 */
public class SaleAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ISaleMonitorServices saleMonitorServices;
	@Autowired
	ISaleMonitorWeekServices saleMonitorWeekServices;
	@Autowired
	ISaleMonitorMonthServices saleMonitorMonthServices;
	@Autowired
	ISaleMonitorAllServices saleMonitorAllServices;
	@Autowired
	ICompanyProjectServices comProjectServices;
	
	
	@SuppressWarnings("unchecked")
	public String searchSale() throws Exception{
		String from = request.getParameter("from");  //按条件搜索时就为空
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(CommonUtils.USER_SESSION_KEY);
		if(obj == null){
			//如果没有数据就跳回登陆界面
			return "loginFail";
		}
		
		UserAccount user = (UserAccount) obj;
		
		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(),pageSize,action);
		
		String date = CommonUtils.getNowForString();
		
		if("left".equals(from)){
			//点击左边或顶上的"查询客户"
			session.removeAttribute("saleCond"); //清空该session
			
			saleCond = new SaleMonitorCond(); 
			saleCond.setDate1(date);
			saleCond.setDate2(date);
			
		}else{
			
			Map<String, String[]> map = request.getParameterMap();
			if(map.containsKey("ob") || "return".equals(from)){
				//表示点击了排序, 返回
				Object getCond = session.getAttribute("saleCond");
				saleCond = (SaleMonitorCond) getCond;
				
			}
			
			if(saleCond == null){ //登陆
				saleCond = new SaleMonitorCond();
				saleCond.setDate1(date);
				saleCond.setDate2(date);
				
			}
			
		}
		
		String type = request.getParameter("type");
		
		if("week".equals(type)){
			
			String now = CommonUtils.getNowForString();
			String weekBefore = CommonUtils.getOneWeekBeforeForString();
			saleCond.setDate1(weekBefore);
			saleCond.setDate2(now);
		}else if("month".equals(type)){
			
			String monthFirst = CommonUtils.getMonthFirstForString();
			String monthEnd = CommonUtils.getMonthEndForString();
			saleCond.setDate1(monthFirst);
			saleCond.setDate2(monthEnd);
		}
		
		List<Integer> projectIds = new ArrayList<Integer>();
		projectIds.add(user.getProjectId());  //该方法只有普通的操作人员能调用,所以projectIds的大小最大只能为1
		saleCond.setProjectIds(projectIds);
		
		page.setCond(saleCond);
		saleList = saleMonitorServices.findSaleMonitorPage(saleCond);
		
		amount = initSaleMonitorAmount(amount, saleList);
		
		session.setAttribute("saleCond", saleCond);   //供查找返回及下载使用
		session.removeAttribute("suggestion");
		
		this.setShowPage(page.toHtmlString());
		
		return "querySaleLimit";
	}
	
	public String doSomeForAddSale() throws Exception{
		HttpSession session = request.getSession();
		
		String now = CustomerUtils.getNowForString();
		session.setAttribute("now", now);
		
		String from = request.getParameter("from");
		if("hengda".equals(from)){
			session.removeAttribute("suggestion");
		}
		
		if(PermissionUtils.hasPermission(EnumPrivCode.LOCK_SALE,EnumDevFlag.HENGDA)){
			//表示可以编辑录入时间
			return "forAddSale_admin";
		}else{
		
			return "forAddSale";
		}
	}
	
	public String addSale() throws Exception{
		String ret = "";
		
		try{
			if(PermissionUtils.hasPermission(EnumPrivCode.LOCK_SALE,EnumDevFlag.HENGDA)){
				ret = "addSaleAdmin";
			}else{
				ret = "addSale";
			}
			
			saleMonitorMonth = new SaleMonitorMonth();
			saleMonitorAll = new SaleMonitorAll();
			
			Date date = saleMonitor.getMonitorDate();
			
			String monitorDate = CustomerUtils.getDateString(date);
			
			SaleMonitorCond cond = new SaleMonitorCond();
			cond.setMonitorDate(monitorDate);
			cond.setProjectId(SessionUser.getProjectId());
			boolean isExists = saleMonitorServices.findMonitorDateIsExistsByProject(cond); //该日期下的该项目是否有值
			
			if(isExists){
				setSuggestion("该日期下的项目数据已经存在");
				return ret;
			}
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					saleMonitor = initSaleMonitorToAdd(saleMonitor);
					saleMonitorMonth = initSaleMonitorMonthToAdd(saleMonitor, saleMonitorMonth);//
					saleMonitorAll = initSaleMonitorAllToAdd(saleMonitor, saleMonitorAll);
					
					saleMonitorServices.addSaleMonitor(saleMonitor); //要一并把相关的数据增加到总表中
					saleMonitorMonthServices.addSaleMonitorMonth(saleMonitorMonth);
					saleMonitorAllServices.addSaleMonitorAll(saleMonitorAll);
					
					//修改该月该日期后的相关数据
					saleMonitorMonthServices.updateMonthFromAddSaleMonitor(saleMonitor);
					saleMonitorAllServices.updateAllFromAddSaleMonitor(saleMonitor);
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
				}
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return ret;
	}
	
	public String querySaleMonitorById() throws Exception{
		HttpSession session = request.getSession();
		
		int id = 0;
		Object obj = session.getAttribute("saleMonitorId"); 
		if(obj != null){
			//表示从方法updateSale()过来
			id = Integer.parseInt(obj.toString());
			
		}else{
			//表示从查看详情过来,要清空提示
			session.removeAttribute("suggestion");
			id = Integer.parseInt(request.getParameter("id"));
		}
		
		SaleMonitor saleMonitor = saleMonitorServices.findSaleMonitorById(id);
		session.setAttribute("saleMonitor", saleMonitor);
		session.removeAttribute("saleMonitorId");
		
		return "querySaleMonitorByIdForUpdate";
	}
	
	public String updateSale() throws Exception{
		boolean isUpdateSucc = true;
		int saleMonitorId = saleMonitor.getId();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("saleMonitorId", saleMonitorId);
		
		try{
			UserAccount user = (UserAccount) session.getAttribute(CommonUtils.USER_SESSION_KEY);
			//要先判断是否具有权限LOCK_SALE，如果没有该权限就要判断该条数据录入是否已经超过24小时
			
			SaleMonitor oldMonitor = saleMonitorServices.findSaleMonitorById(saleMonitorId);
			
			boolean isCanModify = PermissionUtils.hasPermission(saleMonitor.getProjectId(), EnumPrivCode.LOCK_SALE,EnumDevFlag.HENGDA); //是否具有权限LOCK_SALE
			if(!isCanModify){
				Date createdDate = oldMonitor.getCreatedTime();
				Date now = new Date();
				
				boolean isOneDayLater = CommonUtils.isOneDayLater(createdDate, now); //判断是否超过24h
				
				if(isOneDayLater){
					setSuggestion(CommonUtils.MODIFY);
					return querySaleMonitorById();
				}
			}
			
			final SaleMonitor oldSaleMonitor = saleMonitorServices.findSaleMonitorById(saleMonitorId);
			saleMonitor = initSaleMonitorToUpdate(user, oldSaleMonitor, saleMonitor); //非界面的其他信息
			
			new MyTransationTemplate(){

				@Override
				protected void doExecuteCallback() throws Exception {
					
					saleMonitorServices.updateSaleMonitor(oldSaleMonitor,saleMonitor);
					
					//修改该月该日期后的相关数据(+new -old)
					saleMonitorMonthServices.updateMonthFromModifySaleMonitorAdd(saleMonitor);
					saleMonitorMonthServices.updateMonthFromModifySaleMonitorDel(oldSaleMonitor);
					
					saleMonitorAllServices.updateAllFromModifySaleMonitorAdd(saleMonitor);
					saleMonitorAllServices.updateAllFromModifySaleMonitorDel(oldSaleMonitor);
					
				}
				
			}.execute();
			
			
		}catch(Exception e){
			isUpdateSucc = false;
			e.printStackTrace();
		}
		
		if(isUpdateSucc){
			setSuggestion(CommonUtils.SUCCSUGG);
			
		}else{
			setSuggestion(CommonUtils.FAILSUGG);
			
		}
		
		return querySaleMonitorById();
	}
	
	public String doSomeForSearchSaleAll() throws Exception{
		HttpSession session = request.getSession();
		session.removeAttribute("saleCond"); //清空该session
		
		String ret = "";
		
		String from = request.getParameter("from");
		if("week".equals(from)){
			
			ret = "forSearchSaleWeek";
		}else if("month".equals(from)){
			
			ret = "forSearchSaleMonth";
		}else if("all".equals(from)){
			
			ret = "forSearchSaleAll";
		}else{
			
			ret = "forSearchSale";
		}
		
		return ret;
	}
	
	public String searchSaleAll() throws Exception{
		//管理员使用
		String from = request.getParameter("from");  //按条件搜索时就为空
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(CommonUtils.USER_SESSION_KEY);
		if(obj == null){
			//如果没有数据就跳回登陆界面
			return "loginFail";
		}
		
		if("left".equals(from)){
			//点击左边或顶上
			saleCond = new SaleMonitorCond();
			saleCond.setDate1(CommonUtils.getNowForString());
			saleCond.setDate2(CommonUtils.getNowForString());
			
		}
		
		showSaleAllList = new ArrayList<SaleMonitorAllList>();
		
		saleCond.setProjectIds(getUserProjects());
		
		saleList = saleMonitorServices.findSaleMonitor(saleCond);  //管理员使用
		
		showSaleAllList = addSaleMonitorToShowList(showSaleAllList, saleList);  //最好改为都从日表中统计,而月表总表只是在增加或者修改的时候进行相关记录
		
		session.setAttribute("showSaleAllList", showSaleAllList); //供下载使用
		session.setAttribute("saleCond", saleCond);   //供查找返回使用
		session.removeAttribute("suggestion");
		
		
		return "forSearchSale";
	}
	
	//周 月 总
	public String searchSaleFromType() throws Exception{
		HttpSession session = request.getSession();
		
		String type = request.getParameter("type");
		String now = CustomerUtils.getNowForString();
		String ret = "";
		
		if("week".equals(type)){
			if(saleWeekCond == null){
				saleWeekCond = new SaleMonitorWeekCond();
			}
			if(CustomerUtils.isStrEmpty(saleWeekCond.getDate1())){
				saleWeekCond.setDate1(CommonUtils.getOneWeekBeforeForString());
			}
			if(CustomerUtils.isStrEmpty(saleWeekCond.getDate2())){	
				saleWeekCond.setDate2(now);
			}
			saleWeekCond.setProjectIds(getUserProjects());
			
			String proId = saleWeekCond.getProjectId();
			if(proId == null){
				proId = SessionUser.getProjectId() + "";
			}
			session.setAttribute("projectId", proId);
			saleWeekList = saleMonitorWeekServices.findSaleMonitorWeek(saleWeekCond);
			
			amount = initSaleMonitorWeekAmount(amount, saleWeekList);
			
			session.setAttribute("saleWeekList", saleWeekList);  //下载使用 ,没有分页不用利用saleWeekCond再查询一次
			
			ret = "forSearchSaleWeek";
			
		}else if("month".equals(type)){
			if(saleMonthCond == null){
				saleMonthCond = new SaleMonitorMonthCond();
			}
			if(CustomerUtils.isStrEmpty(saleMonthCond.getDate1())){
				saleMonthCond.setDate1(CommonUtils.getMonthFirstForString());
			}
			if(CustomerUtils.isStrEmpty(saleMonthCond.getDate2())){
				saleMonthCond.setDate2(CommonUtils.getMonthEndForString());
			}
			saleMonthCond.setProjectIds(getUserProjects());
			
			String proId = saleMonthCond.getProjectId();
			if(proId == null){
				proId = SessionUser.getProjectId() + "";
			}
			session.setAttribute("projectId", proId);
			saleMonthList = saleMonitorMonthServices.findSaleMonitorMonth(saleMonthCond);
			
			amount = initSaleMonitorMonthAmount(amount, saleMonthList);
			 
			session.setAttribute("saleMonthList", saleMonthList);  //下载使用 ,没有分页不用利用saleWeekCond再查询一次
			
			ret = "forSearchSaleMonth";
			
		}else if("all".equals(type)){ //暂时没有使用
			if(saleAllCond == null){
				saleAllCond = new SaleMonitorAllCond();
			}
			if(CustomerUtils.isStrEmpty(saleAllCond.getMonitorDate())){
				saleAllCond.setMonitorDate(now);
			}
			saleAllList = null;
			
			ret = "forSearchSaleAll";
		}
		
		initSelProject();
		return ret;
	}
	
	public String delSales() throws Exception{
		String getIdStr = request.getParameter("ids");
		
		try{
			final UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
			
			final String[] idsStr = getIdStr.split("_");
			
			if(idsStr.length != 1){
				throw new Exception();
			}else{
				new MyTransationTemplate() {
					
					@Override
					protected void doExecuteCallback() throws Exception {
						int id = Integer.parseInt(idsStr[0]);
						SaleMonitor oldSaleMonitor = saleMonitorServices.findSaleMonitorById(id);
						SaleMonitor newSaleMonitor = new SaleMonitor();
						
						saleMonitorServices.deleteSaleMonitor(id); //只是把is_deleted标示为1,表示删除
						
						newSaleMonitor = initSaleMonitorToDel(user, oldSaleMonitor, newSaleMonitor);
						
						//修改该月该日期后的相关数据(+new -old)
						saleMonitorMonthServices.updateMonthFromModifySaleMonitorAdd(newSaleMonitor);
						saleMonitorMonthServices.updateMonthFromModifySaleMonitorDel(oldSaleMonitor);
						saleMonitorMonthServices.deleteSaleMonitorMonthByMonitorDate(oldSaleMonitor);  //
						
						saleMonitorAllServices.updateAllFromModifySaleMonitorAdd(newSaleMonitor);
						saleMonitorAllServices.updateAllFromModifySaleMonitorDel(oldSaleMonitor);
						saleMonitorAllServices.deleteSaleMonitorAllByMonitorDate(oldSaleMonitor);
						
					}
				}.execute();
				
			}
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "deleteSale"; //修正地址栏的路径问题
	}

	
	@SuppressWarnings("unchecked")
	public String downLoadMonth() throws Exception{
		HttpSession session = request.getSession();
		
		List<SaleMonitorMonth> getList = (List<SaleMonitorMonth>) session.getAttribute("saleMonthList");
		
		downLoadTemplate("saleList", getList, "saleType.xls", "报表.xls");
		return null;
		
	}
	
	@SuppressWarnings("unchecked")
	public String downLoadWeek() throws Exception{
		
		HttpSession session = request.getSession();
		
		List<SaleMonitorWeek> getList = (List<SaleMonitorWeek>) session.getAttribute("saleWeekList");
		
		downLoadTemplate("saleList", getList, "saleType.xls", "报表.xls");
		return null;
		
	}
	
	public String downLoadSale() throws Exception{
		
		HttpSession session = request.getSession();
		SaleMonitorCond downLoadSaleCond = (SaleMonitorCond) session.getAttribute("saleCond");
		
		List<SaleMonitor> getList = saleMonitorServices.findSaleMonitor(downLoadSaleCond);
		
		downLoadTemplate("saleList", getList, "sale.xls", "报表.xls");
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String downLoadAll() throws Exception{
		
		HttpSession session = request.getSession();
		List<SaleMonitorAllList> getList = (List<SaleMonitorAllList>) session.getAttribute("showSaleAllList");
		
		downLoadTemplate("showSaleAllList", getList, "saleAll.xls", "汇总报表.xls");
		
		return null;
	}
	
	private void downLoadTemplate(String key, Object value, String srcFileName, String fileName) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(key, value);
		
		ReportUtils.downLoadReport(map, srcFileName, fileName, response);
		
	}
	
	@SuppressWarnings("unchecked")
	@Deprecated
	public String downLoad2() throws Exception{
		int cols = 27;
		List<SaleMonitorAllList> showSaleAllList = (List<SaleMonitorAllList>) request.getSession().getAttribute("showSaleAllList");
		
		OutputStream os = response.getOutputStream();// 取得输出流   
        response.reset();// 清空输出流   
        String fileName = "汇总报表.xls";
        fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
        response.setHeader("Content-disposition", "attachment; filename=" +  fileName);// 设定输出文件头   
        response.setContentType("application/msexcel");// 定义输出类型  
		
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		
		WritableSheet sheet = workbook.createSheet("汇总报表", 0);
		
		//

		//销售公司 	项目序号 		项目名称 		日期 	来电(次) 	来访(人) 	住宅(套) 	商铺(个) 	
		//车位(个) 	临定(套) 	齐定面积(m2) 	齐定金额(千元) 	住宅(套) 	商铺(个) 	
		//车位(个) 	临定(套) 	本月成交面积(m2) 	本月成交金额(千元) 	住宅 (套) 	商铺(个) 	
		//车位(个) 	临定(套) 	累计总面积(m2) 	累计总金额(千元)
		
		String[] head = new String[]{
				"销售公司","项目序号","项目名称","日期","来电(次)","来访(人)",
				"住宅(套)","商铺(个)","车位(个)","临定(套)","齐定面积(m2)","齐定金额(千元)","当日认筹(次)",
				"本月住宅(套)","本月商铺(个)","本月车位(个)","本月临定(套)","本月成交面积(m2)","本月成交金额(千元)","本月认筹(次)",
				"累计住宅(套)","累计商铺(个)","累计车位(个)","累计临定(套)","累计总面积(m2)","累计总金额(千元)","累计认筹(次)"
		};

		for(int i=0; i<cols; i++){
			Label label = new Label(i, 0, head[i]); //Label(列号,行号 ,内容 ) 列号，行号以0开始 
			sheet.addCell(label);
		}
		
		for(int i=0; i<showSaleAllList.size(); i++){
			SaleMonitorAllList showSale = showSaleAllList.get(i);
			String[] showArray = new String[cols];
			showArray[0] = showSale.getDescCompanyName();
			showArray[1] = showSale.getDescProjectOrderIndex();
			showArray[2] = showSale.getDescProjectName();
			
			showArray[3] = CustomerUtils.getDateString(showSale.getMonitorDate());
			showArray[4] = showSale.getPhoneNum() + "";
			showArray[5] = showSale.getVisitorNum() + "";
			showArray[6] = showSale.getHouseNum() + "";
			showArray[7] = showSale.getShopNum() + "";
			showArray[8] = showSale.getParkNum() + "";
			showArray[9] = showSale.getTempNum() + "";
			showArray[10] = showSale.getCompleteArea() + "";
			showArray[11] = showSale.getCompleteMoney() + "";
			showArray[12] = showSale.getIntentionNum() + "";
			
			showArray[13] = showSale.getHouseNum_m() + "";
			showArray[14] = showSale.getShopNum_m() + "";
			showArray[15] = showSale.getParkNum_m() + "";
			showArray[16] = showSale.getTempNum_m() + "";
			showArray[17] = showSale.getCompleteArea_m() + "";
			showArray[18] = showSale.getCompleteMoney_m() + "";
			showArray[19] = showSale.getIntentionNum_m() + "";
			
			showArray[20] = showSale.getHouseNum_a() + "";
			showArray[21] = showSale.getShopNum_a() + "";
			showArray[22] = showSale.getParkNum_a() + "";
			showArray[23] = showSale.getTempNum_a() + "";
			showArray[24] = showSale.getCompleteArea_a() + "";
			showArray[25] = showSale.getCompleteMoney_a() + "";
			showArray[26] = showSale.getIntentionNum_a() + "";
			
			
			for(int j=0; j<cols; j++){
				
				Label label = new Label(j, i+1, showArray[j]); //Label(列号,行号 ,内容 ) 列号，行号以0开始 
				sheet.addCell(label);
			}
			
		}
		
		//
		
		workbook.write();
		workbook.close();
		os.close();
		
		return null;
	}
	
	//该方法暂时没使用
	public String findMonitorDateIsExists() throws Exception{
		String monitorDate = request.getParameter("monitorDate");
		
		SaleMonitorCond cond = new SaleMonitorCond();
		cond.setMonitorDate(monitorDate);
		cond.setProjectId(SessionUser.getProjectId());
		boolean isExists = saleMonitorServices.findMonitorDateIsExistsByProject(cond);
		
		if(isExists){
			CustomerUtils.writeResponse(response, "true");
		}else{
			CustomerUtils.writeResponse(response, "false");
		}
		
		return null;
	}
	
	public String leftDisplay() throws Exception{
		//设置左边的隐藏与显示
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("leftDisplay");
		if(obj == null){
			session.setAttribute("leftDisplay", "0");
		}else{
			String leftDisplay = obj.toString();
			if("1".equals(leftDisplay)){
				session.setAttribute("leftDisplay", "0");
			}else{
				session.setAttribute("leftDisplay", "1");
			}
		}
		
		return null;
	}
	
	private SaleMonitor initSaleMonitorToAdd(SaleMonitor saleMonitor){
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(CommonUtils.USER_SESSION_KEY);
		UserAccount user = (UserAccount) obj;
		
		Date date = new Date();
		
		saleMonitor.setIsDeleted(CommonUtils.NORMAL);
		saleMonitor.setCreatedId(user.getId());
		saleMonitor.setCreatedTime(date);
		saleMonitor.setModId(user.getId());
		saleMonitor.setModTime(date);
		saleMonitor.setProjectId(user.getProjectId());
		saleMonitor.setCompanyId(user.getCompanyId());
		
		return saleMonitor;
	}
	
	private SaleMonitor initSaleMonitorToUpdate(UserAccount user, SaleMonitor oldSaleMonitor, SaleMonitor newSaleMonitor){
		Date date = new Date();
		
		newSaleMonitor.setProjectId(oldSaleMonitor.getProjectId());
		newSaleMonitor.setCompanyId(oldSaleMonitor.getCompanyId());
		newSaleMonitor.setIsDeleted(oldSaleMonitor.getIsDeleted());
		newSaleMonitor.setCreatedId(oldSaleMonitor.getCreatedId());
		newSaleMonitor.setCreatedTime(oldSaleMonitor.getCreatedTime());
		newSaleMonitor.setModId(user.getId());
		newSaleMonitor.setModTime(date);
		
		return newSaleMonitor;
	}
	
	private SaleMonitor initSaleMonitorToDel(UserAccount user, SaleMonitor oldSaleMonitor, SaleMonitor newSaleMonitor){
		Date date = new Date();
		
		newSaleMonitor.setProjectId(oldSaleMonitor.getProjectId());
		newSaleMonitor.setCompanyId(oldSaleMonitor.getCompanyId());
		newSaleMonitor.setIsDeleted(oldSaleMonitor.getIsDeleted());
		newSaleMonitor.setCreatedId(oldSaleMonitor.getCreatedId());
		newSaleMonitor.setCreatedTime(oldSaleMonitor.getCreatedTime());
		newSaleMonitor.setModId(user.getId());
		newSaleMonitor.setModTime(date);
		
		return newSaleMonitor;
	}
	
	private SaleMonitorAll initSaleMonitorAllToAdd(SaleMonitor saleMonitor, SaleMonitorAll saleMonitorAll) throws Exception{
		SaleMonitorAll tmpSaleMonitorAll = saleMonitorAllServices.findSaleMonitorAllForAdd(saleMonitor);
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(CommonUtils.USER_SESSION_KEY);
		UserAccount user = (UserAccount) obj;
		
		Date date = new Date();
		
		saleMonitorAll.setMonitorDate(saleMonitor.getMonitorDate());
		saleMonitorAll.setProjectId(saleMonitor.getProjectId());
		saleMonitorAll.setCompanyId(saleMonitor.getCompanyId());
		
		if(tmpSaleMonitorAll != null){
			//此时应该把该日期后的相关数据递增(重新统计),即把该项目该日期后所有的数据都加上该天的数据
			
			saleMonitorAll.setPhoneNum(tmpSaleMonitorAll.getPhoneNum() + saleMonitor.getPhoneNum());
			saleMonitorAll.setVisitorNum(tmpSaleMonitorAll.getVisitorNum() + saleMonitor.getVisitorNum());
			saleMonitorAll.setHouseNum(tmpSaleMonitorAll.getHouseNum() + saleMonitor.getHouseNum());
			saleMonitorAll.setShopNum(tmpSaleMonitorAll.getShopNum() + saleMonitor.getShopNum());
			saleMonitorAll.setParkNum(tmpSaleMonitorAll.getParkNum() + saleMonitor.getParkNum());
			saleMonitorAll.setTempNum(tmpSaleMonitorAll.getTempNum() + saleMonitor.getTempNum());
			saleMonitorAll.setRescissionNum(tmpSaleMonitorAll.getRescissionNum() + saleMonitor.getRescissionNum());			
			saleMonitorAll.setCompleteArea(tmpSaleMonitorAll.getCompleteArea() + saleMonitor.getCompleteArea());
			saleMonitorAll.setCompleteMoney(tmpSaleMonitorAll.getCompleteMoney() + saleMonitor.getCompleteMoney());
			saleMonitorAll.setIntentionNum(tmpSaleMonitorAll.getIntentionNum() + saleMonitor.getIntentionNum()); //统筹
		}else{
			
			saleMonitorAll.setPhoneNum(saleMonitor.getPhoneNum());
			saleMonitorAll.setVisitorNum(saleMonitor.getVisitorNum());
			saleMonitorAll.setHouseNum(saleMonitor.getHouseNum());
			saleMonitorAll.setShopNum(saleMonitor.getShopNum());
			saleMonitorAll.setParkNum(saleMonitor.getParkNum());
			saleMonitorAll.setTempNum(saleMonitor.getTempNum());
			saleMonitorAll.setRescissionNum(saleMonitor.getRescissionNum());
			saleMonitorAll.setCompleteArea(saleMonitor.getCompleteArea());
			saleMonitorAll.setCompleteMoney(saleMonitor.getCompleteMoney());
			saleMonitorAll.setIntentionNum(saleMonitor.getIntentionNum());
		}
		
		saleMonitorAll.setIsDeleted(CommonUtils.NORMAL);
		saleMonitorAll.setCreatedId(user.getId());
		saleMonitorAll.setCreatedTime(date);
		saleMonitorAll.setModId(user.getId());
		saleMonitorAll.setModTime(date);
		
		
		return saleMonitorAll;
	}
		
	private SaleMonitorMonth initSaleMonitorMonthToAdd(SaleMonitor saleMonitor, SaleMonitorMonth saleMonitorMonth) throws Exception{
		//先拿出该项目该月该日期前的和,再保存到月中
		SaleMonitorMonth tmpMonitorMonth = saleMonitorMonthServices.findSaleMonitorMonthForAdd(saleMonitor); //该项目该月该日期前的和
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(CommonUtils.USER_SESSION_KEY);
		UserAccount user = (UserAccount) obj;
		
		Date date = new Date();
		
		saleMonitorMonth.setMonitorDate(saleMonitor.getMonitorDate());
		saleMonitorMonth.setProjectId(saleMonitor.getProjectId());
		saleMonitorMonth.setCompanyId(saleMonitor.getCompanyId());
		
		if(tmpMonitorMonth != null){
			//此时应该把该日期后的相关数据递增(重新统计),即把该月该日期后所有的数据都加上该天的数据
			
			saleMonitorMonth.setPhoneNum(tmpMonitorMonth.getPhoneNum() + saleMonitor.getPhoneNum());
			saleMonitorMonth.setVisitorNum(tmpMonitorMonth.getVisitorNum() + saleMonitor.getVisitorNum());
			saleMonitorMonth.setHouseNum(tmpMonitorMonth.getHouseNum() + saleMonitor.getHouseNum());
			saleMonitorMonth.setShopNum(tmpMonitorMonth.getShopNum() + saleMonitor.getShopNum());
			saleMonitorMonth.setParkNum(tmpMonitorMonth.getParkNum() + saleMonitor.getParkNum());
			saleMonitorMonth.setTempNum(tmpMonitorMonth.getTempNum() + saleMonitor.getTempNum());
			saleMonitorMonth.setRescissionNum(tmpMonitorMonth.getRescissionNum() + saleMonitor.getRescissionNum()); //挞定
			saleMonitorMonth.setCompleteArea(tmpMonitorMonth.getCompleteArea() + saleMonitor.getCompleteArea());
			saleMonitorMonth.setCompleteMoney(tmpMonitorMonth.getCompleteMoney() + saleMonitor.getCompleteMoney());
			saleMonitorMonth.setIntentionNum(tmpMonitorMonth.getIntentionNum() + saleMonitor.getIntentionNum()); //统筹
		}else{
			
			saleMonitorMonth.setPhoneNum(saleMonitor.getPhoneNum());
			saleMonitorMonth.setVisitorNum(saleMonitor.getVisitorNum());
			saleMonitorMonth.setHouseNum(saleMonitor.getHouseNum());
			saleMonitorMonth.setShopNum(saleMonitor.getShopNum());
			saleMonitorMonth.setParkNum(saleMonitor.getParkNum());
			saleMonitorMonth.setTempNum(saleMonitor.getTempNum());
			saleMonitorMonth.setRescissionNum(saleMonitor.getRescissionNum());
			saleMonitorMonth.setCompleteArea(saleMonitor.getCompleteArea());
			saleMonitorMonth.setCompleteMoney(saleMonitor.getCompleteMoney());
			saleMonitorMonth.setIntentionNum(saleMonitor.getIntentionNum());
		}
		
		saleMonitorMonth.setIsDeleted(CommonUtils.NORMAL);
		saleMonitorMonth.setCreatedId(user.getId());
		saleMonitorMonth.setCreatedTime(date);
		saleMonitorMonth.setModId(user.getId());
		saleMonitorMonth.setModTime(date);
		
		return saleMonitorMonth;
	}
	
	
	private List<SaleMonitorAllList> addSaleMonitorToShowList(List<SaleMonitorAllList> showSaleAllList, List<SaleMonitor> saleList) 
		throws Exception{
		//从月表及总表中查相关的数据
		
		for(SaleMonitor sale : saleList){
			SaleMonitorMonth getMonth = saleMonitorMonthServices.findSaleMonitorMonthToShow(sale);
			SaleMonitorAll getAll = saleMonitorAllServices.findSaleMonitorAllToShow(sale);
			
			if(getMonth == null){
				getMonth = new SaleMonitorMonth();
			}
			if(getAll == null){
				getAll = new SaleMonitorAll();
			}
			
			SaleMonitorAllList all = new SaleMonitorAllList();
			all.setMonitorDate(sale.getMonitorDate()); //jsp
			all.setMonitorDateString(CustomerUtils.getDateString(sale.getMonitorDate())); //下载
			all.setProjectId(sale.getProjectId());
			all.setCompanyId(sale.getCompanyId());
			
			all.setPhoneNum(sale.getPhoneNum());
			all.setVisitorNum(sale.getVisitorNum());
			all.setHouseNum(sale.getHouseNum());
			all.setShopNum(sale.getShopNum());
			all.setParkNum(sale.getParkNum());
			all.setTempNum(sale.getTempNum() - sale.getRescissionNum()); //汇总显示的临定数为临定数-挞定数
			all.setCompleteArea(sale.getCompleteArea());
			all.setCompleteMoney(sale.getCompleteMoney());
			all.setIntentionNum(sale.getIntentionNum());
			
			HttpSession session = request.getSession();
			Object obj = session.getAttribute(CommonUtils.USER_SESSION_KEY);
			UserAccount user = (UserAccount) obj;
			
			Date date = new Date();
			
			all.setIsDeleted(CommonUtils.NORMAL);
			all.setCreatedId(user.getId());
			all.setCreatedTime(date);
			all.setModId(user.getId());
			all.setModTime(date);
			
			//
			all.setHouseNum_m(getMonth.getHouseNum());
			all.setShopNum_m(getMonth.getShopNum());
			all.setParkNum_m(getMonth.getParkNum());
			all.setTempNum_m(getMonth.getTempNum() - getMonth.getRescissionNum());  //汇总显示的临定数为临定数-挞定数
			all.setCompleteArea_m(getMonth.getCompleteArea());
			all.setCompleteMoney_m(getMonth.getCompleteMoney());
			all.setIntentionNum_m(getMonth.getIntentionNum());
			
			all.setHouseNum_a(getAll.getHouseNum());
			all.setShopNum_a(getAll.getShopNum());
			all.setParkNum_a(getAll.getParkNum());
			all.setTempNum_a(getAll.getTempNum() - getAll.getRescissionNum());   //汇总显示的临定数为临定数-挞定数
			all.setCompleteArea_a(getAll.getCompleteArea());
			all.setCompleteMoney_a(getAll.getCompleteMoney());
			all.setIntentionNum_a(getAll.getIntentionNum());
			
			showSaleAllList.add(all);
			
		}
		
		return showSaleAllList;
	}
	
	
	private SaleMonitorAmount initSaleMonitorAmount(SaleMonitorAmount saleMonitorAmount, List<SaleMonitor> saleList){
		if(saleMonitorAmount == null)
			saleMonitorAmount = new SaleMonitorAmount();
		
		for(SaleMonitor sale : saleList){
			saleMonitorAmount.setPhoneNum(saleMonitorAmount.getPhoneNum() + sale.getPhoneNum());
			saleMonitorAmount.setVisitorNum(saleMonitorAmount.getVisitorNum() + sale.getVisitorNum());
			
			saleMonitorAmount.setSumNum(saleMonitorAmount.getSumNum() + sale.getSumNum());
			saleMonitorAmount.setSumArea(saleMonitorAmount.getSumArea().add(sale.getSumArea()));
			saleMonitorAmount.setSumMoney(saleMonitorAmount.getSumMoney().add(sale.getSumMoney()));
			
			saleMonitorAmount.setUndoSumNum(saleMonitorAmount.getUndoSumNum() + sale.getUndoSumNum());
			saleMonitorAmount.setUndoSumArea(saleMonitorAmount.getUndoSumArea().add(sale.getUndoSumArea()));
			saleMonitorAmount.setUndoSumMoney(saleMonitorAmount.getUndoSumMoney().add(sale.getUndoSumMoney()));
			
			saleMonitorAmount.setIntentionNum(saleMonitorAmount.getIntentionNum() + sale.getIntentionNum()); //认筹
			
		}
		
		return saleMonitorAmount;
		
	}
	
	private SaleMonitorAmount initSaleMonitorWeekAmount(SaleMonitorAmount saleMonitorAmount, List<SaleMonitorWeek> saleList){
		if(saleMonitorAmount == null)
			saleMonitorAmount = new SaleMonitorAmount();
		
		for(SaleMonitorWeek sale : saleList){
			saleMonitorAmount.setPhoneNum(saleMonitorAmount.getPhoneNum() + sale.getPhoneNum());
			saleMonitorAmount.setVisitorNum(saleMonitorAmount.getVisitorNum() + sale.getVisitorNum());
			
			saleMonitorAmount.setSumNum(saleMonitorAmount.getSumNum() + sale.getSumNum());
			saleMonitorAmount.setSumArea(saleMonitorAmount.getSumArea().add(sale.getSumArea()));
			saleMonitorAmount.setSumMoney(saleMonitorAmount.getSumMoney().add(sale.getSumMoney()));
			
			saleMonitorAmount.setUndoSumNum(saleMonitorAmount.getUndoSumNum() + sale.getUndoSumNum());
			saleMonitorAmount.setUndoSumArea(saleMonitorAmount.getUndoSumArea().add(sale.getUndoSumArea()));
			saleMonitorAmount.setUndoSumMoney(saleMonitorAmount.getUndoSumMoney().add(sale.getUndoSumMoney()));
			
			saleMonitorAmount.setIntentionNum(saleMonitorAmount.getIntentionNum() + sale.getIntentionNum()); //认筹
			
		}
		
		return saleMonitorAmount;
		
	}
	
	
	private SaleMonitorAmount initSaleMonitorMonthAmount(SaleMonitorAmount saleMonitorAmount, List<SaleMonitorMonth> saleList){
		if(saleMonitorAmount == null)
			saleMonitorAmount = new SaleMonitorAmount();
		
		for(SaleMonitorMonth sale : saleList){
			saleMonitorAmount.setPhoneNum(saleMonitorAmount.getPhoneNum() + sale.getPhoneNum());
			saleMonitorAmount.setVisitorNum(saleMonitorAmount.getVisitorNum() + sale.getVisitorNum());
			
			saleMonitorAmount.setSumNum(saleMonitorAmount.getSumNum() + sale.getSumNum());
			saleMonitorAmount.setSumArea(saleMonitorAmount.getSumArea().add(sale.getSumArea()));
			saleMonitorAmount.setSumMoney(saleMonitorAmount.getSumMoney().add(sale.getSumMoney()));
			
			saleMonitorAmount.setUndoSumNum(saleMonitorAmount.getUndoSumNum() + sale.getUndoSumNum());
			saleMonitorAmount.setUndoSumArea(saleMonitorAmount.getUndoSumArea().add(sale.getUndoSumArea()));
			saleMonitorAmount.setUndoSumMoney(saleMonitorAmount.getUndoSumMoney().add(sale.getUndoSumMoney()));
			
			saleMonitorAmount.setIntentionNum(saleMonitorAmount.getIntentionNum() + sale.getIntentionNum()); //认筹
			
		}
		
		return saleMonitorAmount;
		
	}
	
	
	
	
	/////////////////////
	
	private SaleMonitor saleMonitor;
	private SaleMonitorWeek saleMonitorWeek;
	private SaleMonitorMonth saleMonitorMonth;
	private SaleMonitorAll saleMonitorAll;
	
	private SaleMonitorCond saleCond;
	private SaleMonitorWeekCond saleWeekCond;
	private SaleMonitorMonthCond saleMonthCond;
	private SaleMonitorAllCond saleAllCond;
	
	private SaleMonitorAmount amount;
	
	private String suggestion; //操作提示
	
	private List<SaleMonitor> saleList;
	private List<SaleMonitorWeek> saleWeekList;
	private List<SaleMonitorMonth> saleMonthList;
	private List<SaleMonitorAll> saleAllList;
	
	private List<SaleMonitorAllList> showSaleAllList; //用于页面显示
	
	private LinkedHashMap<String, String> selProject;
	
	public void setSelProject(LinkedHashMap<String, String> selProject) {
		this.selProject = selProject;
	}
	
	public LinkedHashMap<String, String> getSelProject() {
		return selProject;
	}
	
	public void initSelProject(){
		if(this.selProject == null){
			selProject = new LinkedHashMap<String, String>();
			selProject.put("", CommonUtils.ALL);
			List<CompanyProject> userProjects = PermissionUtils.getUserProjectListByUid(SessionUser.getUserId());
			CompanyProject userProject = comProjectServices.findCompanyProjectById(SessionUser.getProjectId()); //用户自身所属的项目
			selProject.put(userProject.getId() + "", userProject.getProjectName());
			for(CompanyProject pro : userProjects){
				selProject.put(pro.getId() + "", pro.getProjectName());
			}
			
		}
	}

	private List<Integer> getUserProjects(){
		List<Integer> projectIds = new ArrayList<Integer>();  //该管理员所拥有的project id
		
		List<CompanyProject> userProject = PermissionUtils.getUserProjectListByUid(SessionUser.getUserId());
		for(CompanyProject pro : userProject){
			projectIds.add(pro.getId());
		}
		projectIds.add(SessionUser.getProjectId()); //加上自己的project id
		return projectIds;
	}
	
	
	
	public void setSaleWeekList(List<SaleMonitorWeek> saleWeekList) {
		this.saleWeekList = saleWeekList;
	}
	
	public List<SaleMonitorWeek> getSaleWeekList() {
		return saleWeekList;
	}
	
	public void setSaleMonitorWeek(SaleMonitorWeek saleMonitorWeek) {
		this.saleMonitorWeek = saleMonitorWeek;
	}
	
	public SaleMonitorWeek getSaleMonitorWeek() {
		return saleMonitorWeek;
	}
	
	public void setSaleWeekCond(SaleMonitorWeekCond saleWeekCond) {
		this.saleWeekCond = saleWeekCond;
	}
	
	public SaleMonitorWeekCond getSaleWeekCond() {
		return saleWeekCond;
	}
	
	public void setAmount(SaleMonitorAmount amount) {
		this.amount = amount;
	}
	
	public SaleMonitorAmount getAmount() {
		return amount;
	}
	
	public List<SaleMonitorAllList> getShowSaleAllList() {
		return showSaleAllList;
	}
	
	public void setShowSaleAllList(List<SaleMonitorAllList> showSaleAllList) {
		this.showSaleAllList = showSaleAllList;
	}
	
	public void setSaleMonitorAll(SaleMonitorAll saleMonitorAll) {
		this.saleMonitorAll = saleMonitorAll;
	}
	
	public SaleMonitorAll getSaleMonitorAll() {
		return saleMonitorAll;
	}
	
	public void setSaleMonitorMonth(SaleMonitorMonth saleMonitorMonth) {
		this.saleMonitorMonth = saleMonitorMonth;
	}
	
	public SaleMonitorMonth getSaleMonitorMonth() {
		return saleMonitorMonth;
	}
	
	public void setSaleMonthCond(SaleMonitorMonthCond saleMonthCond) {
		this.saleMonthCond = saleMonthCond;
	}
	
	public SaleMonitorMonthCond getSaleMonthCond() {
		return saleMonthCond;
	}
	
	public void setSaleMonitor(SaleMonitor saleMonitor) {
		this.saleMonitor = saleMonitor;
	}
	
	public SaleMonitor getSaleMonitor() {
		return saleMonitor;
	}
	
	public void setSaleCond(SaleMonitorCond saleCond) {
		this.saleCond = saleCond;
	}
	
	public SaleMonitorCond getSaleCond() {
		return saleCond;
	}
	
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
		request.getSession().setAttribute("suggestion", suggestion);
	}
	
	public String getSuggestion() {
		return suggestion;
	}
	
	public void setSaleList(List<SaleMonitor> saleList) {
		this.saleList = saleList;
	}
	
	public List<SaleMonitor> getSaleList() {
		return saleList;
	}
	
	public void setSaleAllCond(SaleMonitorAllCond saleAllCond) {
		this.saleAllCond = saleAllCond;
	}
	
	public SaleMonitorAllCond getSaleAllCond() {
		return saleAllCond;
	}

	public List<SaleMonitorMonth> getSaleMonthList() {
		return saleMonthList;
	}

	public void setSaleMonthList(List<SaleMonitorMonth> saleMonthList) {
		this.saleMonthList = saleMonthList;
	}

	public List<SaleMonitorAll> getSaleAllList() {
		return saleAllList;
	}

	public void setSaleAllList(List<SaleMonitorAll> saleAllList) {
		this.saleAllList = saleAllList;
	}
	

}
