package com.ihk.sale.action;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.permission.PermissionUtils;
import com.ihk.sale.data.pojo.PresaleMonitor;
import com.ihk.sale.data.pojo.PresaleMonitorCond;
import com.ihk.sale.data.services.IPresaleMonitorServices;
import com.ihk.sale.data.services.impl.PresaleMonitorServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.RolePriv;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.impl.CompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

import org.apache.log4j.Logger; 

/**
 * 预售数据
 * @author peter.kuang
 *
 */
public class PresaleAction extends SupperAction{
	
	private static final Logger logger = Logger.getLogger(PresaleAction.class); 	
	
	private static final long serialVersionUID = 1L;
	@Autowired PresaleMonitorServices preServices;
	@Autowired ICompanyProjectServices projectServices;
	private PresaleMonitor presaleMonitor;
	private PresaleMonitorCond cond;
	private List<PresaleMonitor> listpre;
	private String tips;
	private String id;
	private List<CompanyProject> listCompanyProject;
	
	//=======

	 
	
	public PresaleMonitor getPresaleMonitor() {
		return presaleMonitor;
	}
	public List<CompanyProject> getListCompanyProject() {
		return listCompanyProject;
	}
	public void setListCompanyProject(List<CompanyProject> listCompanyProject) {
		this.listCompanyProject = listCompanyProject;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PresaleMonitorCond getCond() {
		return cond;
	}
	public void setCond(PresaleMonitorCond cond) {
		this.cond = cond;
	}
	public List<PresaleMonitor> getListpre() {
		return listpre;
	}
	public void setListpre(List<PresaleMonitor> listpre) {
		this.listpre = listpre;
	}
	public void setPresaleMonitor(PresaleMonitor presaleMonitor) {
		this.presaleMonitor = presaleMonitor;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public PresaleAction(){
		super();
		tips = "";
	}
	//======================================================
	public String index(){
		return "index";
	}
	
	public String addPresale_jsp(){
//		if(!PermissionUtils.hasPermission(SessionUser.getProjectId() ,PrivCode.ADD_PRESALE )){
//			addActionMessage("需要授权.");
//			return "index";
//		}
		return "addpresalejsp";
	}
	
	public String addPresale()throws Exception{
//		for(RolePriv p : PermissionUtils.getUserPrivList()){
//			System.out.println(p.getPrivCode());
//		}///没有给到presale的权限 全是sale的
		if(!PermissionUtils.hasPermission(SessionUser.getProjectId() ,EnumPrivCode.ADD_PRESALE ,EnumDevFlag.HENGDA)){
			addActionMessage("需要授权.");
			return "addpresale";
		}
		initPre();
		if(preServices.valDate(presaleMonitor)){
			addActionMessage("录入失败!!!已经有这个日期的数据,可在查询界面修改信息。"); 
			return "addpresale";
		}
		preServices.addPresaleMonitor(presaleMonitor);
		addActionMessage("数据已经录入成功!"); 
		return "addpresale";
	}
	
	private void initPre()throws Exception{
		this.presaleMonitor.setCreatedTime(new Date(System.currentTimeMillis()));
		this.presaleMonitor.setModTime(new Date(System.currentTimeMillis()));
		this.presaleMonitor.setCreatedId(SessionUser.getUserId());
		this.presaleMonitor.setModId(SessionUser.getUserId());
		this.presaleMonitor.setIsDeleted("0");
		this.presaleMonitor.setCompanyId(SessionUser.getSessionUser().getCompanyId());
		this.presaleMonitor.setProjectId(SessionUser.getProjectId());
	}
	
	public String indexPresale()throws Exception{
		if(!PermissionUtils.hasPermission(SessionUser.getProjectId() ,EnumPrivCode.FIND_PRESALE ,EnumDevFlag.HENGDA)){
			addActionMessage("需要授权.");
			return "index";
		}
		HttpSession session = request.getSession();
		session.setAttribute("cond",new PresaleMonitorCond());
		cond = new PresaleMonitorCond();
		cond.setProjectId( SessionUser.getProjectId() + "" );
		setPage(10);
		return "indexpre";
	}

	@SuppressWarnings("unchecked")
	public String searchPresale()throws Exception{
		if(!PermissionUtils.hasPermission(SessionUser.getProjectId() ,EnumPrivCode.FIND_PRESALE ,EnumDevFlag.HENGDA)){
			addActionMessage("需要授权.");
			return "index";
		}
		HttpSession session = request.getSession();
		Map<String, String[]> map = request.getParameterMap();
		if(map.containsKey("ob")){
			Object getCond = session.getAttribute("cond");
			cond = (PresaleMonitorCond) getCond;		
		}
		cond.setProjectId( SessionUser.getProjectId() + "" );
		setPage(10);
		session.setAttribute("cond", cond);		
		return "searchpre";
	}
	
	public String indexPresaleAll_jsp() throws Exception{		
//		if(!PermissionUtils.hasPermission(SessionUser.getProjectId() ,PrivCode.SUM_PRESALE )){
//			addActionMessage("需要授权.");
//			return "index";
//		}
		//listCompanyProject = PermissionUtils.getUserProjectList();
		logger.debug("indexPresaleAll_jsp");
		System.out.println("out-indexPresaleAll_jsp");
		listCompanyProject = PermissionUtils.getUserProjectList(EnumPrivCode.SUM_PRESALE,EnumDevFlag.HENGDA);
		
		HttpSession session = request.getSession();
		session.setAttribute("cond",new PresaleMonitorCond());
		cond = new PresaleMonitorCond();
		return "indexallpre";
	}
	
	public String searchPresaleAll()throws Exception{
		listCompanyProject = PermissionUtils.getUserProjectList(EnumPrivCode.SUM_PRESALE,EnumDevFlag.HENGDA);
		if(!SessionUser.isAdmin())return "indexallpre";
		HttpSession session = request.getSession();
		Map<String, String[]> map = request.getParameterMap();
		if(map.containsKey("ob")){
			Object getCond = session.getAttribute("cond");
			cond = (PresaleMonitorCond) getCond;		
		}
		if(cond.getProjectId() == null)return "indexallpre";
		session.setAttribute("cond",cond);
		System.out.println("checkProjectId = >>>>>>>>>>>>>>>>>>"+cond.getProjectId()+">>>>>>>>>>"+PermissionUtils.getUserRoleListByProjectId(Integer.parseInt(cond.getProjectId())).get(0).getRoleName());
		List<RolePriv> tmlist =PermissionUtils.getUserPrivList();
		Iterator it = tmlist.iterator();
		while(it.hasNext()){
			//peter注释：因数据库字段变化
//			String hh = ((RolePriv)(it.next())).getPrivCode();
//			System.out.println("code+>>>>>>>>>>>>>>>>>>>>>>>>>"+hh);
		}
		if(!PermissionUtils.hasPermission(Integer.parseInt(cond.getProjectId()) ,EnumPrivCode.SUM_PRESALE ,EnumDevFlag.HENGDA)){
			addActionMessage("需要授权.");
			return "indexallpre";
		}
		setPage(1);	
		if(listpre.size() == 0 )addActionMessage("还没有该项目数据");
		return "indexallpre";
	}
	
	@SuppressWarnings("unchecked")
	public void setPage(int size)throws Exception{

		String action = CustomerUtils.getActionNameFromRequest(request);
		cond.recordCount = preServices.findPresaleMonitorCount(cond);
		Pager page = new Pager(ActionContext.getContext(),size,action);
		page.setCond(cond);
		listpre = preServices.findPresaleMonitorPage(cond);
		
		this.setShowPage(page.toHtmlString());

	}
	
	public String updatePre_jsp()throws Exception{
		
		
		
		this.presaleMonitor = preServices.findPresaleMonitorById(Integer.parseInt(this.getId()));
		request.getSession().setAttribute("tempPre", presaleMonitor);
		return "updatePre_jsp";
	}
	
	public String updatePre(){
//		if(!PermissionUtils.hasPermission(SessionUser.getProjectId() ,PrivCode.ADD_PRESALE )){
//			addActionMessage("需要授权.");
//			return "updatePre_jsp";
//		}
		PresaleMonitor tempPre =  (PresaleMonitor) request.getSession().getAttribute("tempPre");
		if(presaleMonitor.getPhoneNum() == 0 && presaleMonitor.getVisitorNum() == 0 && presaleMonitor.getIntentionNum() == 0){
			addActionMessage("表单数据为空.");
			return "updatePre_jsp";
		}
		
		tempPre.setPhoneNum(presaleMonitor.getPhoneNum());
		tempPre.setVisitorNum(presaleMonitor.getVisitorNum());
		tempPre.setIntentionNum(presaleMonitor.getIntentionNum());
		tempPre.setModId(SessionUser.getUserId());
		tempPre.setModTime(new Date(System.currentTimeMillis()));	
		
		if(!PermissionUtils.hasPermission(SessionUser.getProjectId() ,EnumPrivCode.LOCK_SALE ,EnumDevFlag.HENGDA)){
			int cha =0;
		
			cha = getIntervalDays(tempPre.getCreatedTime(),new Date(System.currentTimeMillis()));
			if(cha > 1){
				System.out.println("相差"+cha);
				addActionMessage("不能修改超过一天的数据");
				return "updatePre_jsp";
			}
	    }//录入数据的第2天之后不能修改  如果有lock_persale权限 不在此限制列
		preServices.updatePresaleMonitor(tempPre);
		presaleMonitor = tempPre;
		addActionMessage("修改成功!");
		return "updatePre_jsp";
	}
	public int getIntervalDays(Date startday,Date endday){      
        
       
        long sl=startday.getTime();
      
        long el=endday.getTime();
       
      
        long ei=el-sl;          
        return (int)(ei/(1000*24*60*60));
    }
	
	public String delPre() throws Exception{
		if(!PermissionUtils.hasPermission(SessionUser.getProjectId() ,EnumPrivCode.ADD_PRESALE ,EnumDevFlag.HENGDA)){
			addActionMessage("需要授权.");
			return indexPresale();
		}
		String getIdStr = request.getParameter("ids");
		String[] idsStr = getIdStr.split("_");	
		try{
			for(String idStr : idsStr){
				int id = Integer.parseInt(idStr);
				preServices.deletePresaleMonitor(id);
			}
			addActionMessage("删除成功!");
		}catch(Exception e){
			e.printStackTrace();
			addActionMessage("删除失败。");
		}	
		return indexPresale();
	}
}
