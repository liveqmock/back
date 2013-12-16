package com.ihk.saleunit.action.new_init;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.constanttype.EnumSelectTypeSessionKey;
import com.ihk.property.data.pojo.PayWay;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyDeveloper;
import com.ihk.property.data.pojo.PropertyDeveloperCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPayWayServices;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyDeveloperServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Question;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.BuildUnitUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.ihk.utils.saleunitnew.JsonUtils;

/**
 * 初始化 关于tree的操作
 * 新建楼盘 开发商等
 * */
public class GuangZhouNewInitTree extends SupperAction{
	private static final long serialVersionUID = 1L;
	
	public static Map<String,String> path;
	static {
		path = new HashMap<String, String>();
		path.put("add_project", "./saleunit_new_init/appoint/guangzhou/addProject.action");
		path.put("add_area", "./saleunit_new_init/appoint/guangzhou/addArea.action");
		path.put("add_build", "./saleunit_new_init/appoint/guangzhou/addBuild.action");
		
		path.put("rename_project", "./saleunit_new_init/appoint/guangzhou/renameProject.action");
		path.put("rename_area", "./saleunit_new_init/appoint/guangzhou/renameArea.action");
		path.put("rename_build", "./saleunit_new_init/appoint/guangzhou/renameBuild.action");
	}
	
	@Autowired IPropertyProjectServices iPropertyProjectServices;
	@Autowired IPropertyAreaServices iPropertyAreaServices;
	@Autowired IPropertyBuildServices iPropertyBuildServices;
	
	@Autowired IPropertyUnitServices iPropertyUnitServices;
	
	@Autowired IPropertyDeveloperServices iPropertyDeveloperServices;
	@Autowired IQuestionServices questionServices;
	@Autowired IQuestionTopicServices questionTopicServices;
	
	@Autowired ICodeTypeServices codeTypeServices;
	@Autowired IPayWayServices payWayServices;
	
	private String type;
	private String newName;
	private String text1;
	private String actionPath;
	private String sug;
	private int id;// 需要操作的project area unit 的ID 根据type做选择
	List<PropertyDeveloper> devList;
	private String proName;
	private String devName;
	private String proDevName;
	
	private int getProid(){
		String key = EnumSelectTypeSessionKey.Init.getValue();

		return (Integer)request.getSession().getAttribute(key);
	}
	
	public String addDev(){
		PropertyDeveloperCond devCond = new PropertyDeveloperCond();
		devCond.setCompanyProjectId(getProid());
		devList = iPropertyDeveloperServices.findPropertyDeveloper(devCond);
		if(devName == null || devName.trim().equals("")){
			this.setSuggestion("开发商名称不能为空");
			return "prosuc";
		}
		boolean isHav = false;
		for(PropertyDeveloper odev : devList){
			if(odev.getDeveloperName().equals(devName.trim())){
				isHav = true;
				break;
			}
		}
		if(isHav){
			this.setSuggestion("已有该开发商,请直接选择");
			return "prosuc";
		}
		
		
		PropertyDeveloper devtmp = new PropertyDeveloper();
		devtmp.setDeveloperName(devName);
		devtmp.setIsDeleted("0");
		devtmp.setCreatedId(SessionUser.getUserId());
		devtmp.setCreatedTime(new Date());
		devtmp.setModId(SessionUser.getUserId());
		devtmp.setModTime(new Date());
		devtmp.setCompanyProjectId(getProid());
		iPropertyDeveloperServices.addPropertyDeveloper(devtmp);
		sug = "新建开发商成功";
		PropertyDeveloperCond devCond1 = new PropertyDeveloperCond();
		devCond1.setCompanyProjectId(getProid());
		devList = iPropertyDeveloperServices.findPropertyDeveloper(devCond);
		return "prosuc";
	}
	
	public String addSome(){
		this.removeSuggestion();
		actionPath = path.get(type);
		
		if(type.equals("add_project")){
			PropertyDeveloperCond devCond = new PropertyDeveloperCond();
			devCond.setCompanyProjectId(getProid());
			devList = iPropertyDeveloperServices.findPropertyDeveloper(devCond);
			return "prosuc";
		}
		
		if(type.equals("add_area"))text1 = "在楼盘  <font color=red>"+iPropertyProjectServices.findPropertyProjectById(id).getPropertyName()+"</font> 下新建分区";
		if(type.equals("add_build")){
			text1 = "在分区<font color=red>"+iPropertyAreaServices.findPropertyAreaById(id).getAreaName()+"</font> 下新建楼栋";
			
			return "build";
		}
		return "suc";
	}

	//功能、项目地址、所属行政区等栏目供填写
	private String saleCard;
	private String projectDesc;
	private String propertyAddress;
	private String areaName;
	/**
	 * 根据newName 新建一个项目
	 * @throws Exception 
	 * */
	public String addProject() throws Exception{
		
		new MyTransationTemplate() {
			
			@Override
			protected void doExecuteCallback() throws Exception {
				
				removeSuggestion();
				
				if(newName == null || newName.trim().equals("")){
					actionPath = path.get(type);
					setSuggestion("楼盘名称不能为空");
					//sug = "名称不能为空!";
					PropertyDeveloperCond devCond = new PropertyDeveloperCond();
					String key = EnumSelectTypeSessionKey.Init.getValue();

					devCond.setCompanyProjectId((Integer)request.getSession().getAttribute(key));
					devList = iPropertyDeveloperServices.findPropertyDeveloper(devCond);
					
					return ;
				}
				if(proDevName ==null || proDevName.equals("")){
					actionPath = path.get(type);
					setSuggestion("请先选择开发商");
					PropertyDeveloperCond devCond = new PropertyDeveloperCond();
					devCond.setCompanyProjectId(getProid());
					devList = iPropertyDeveloperServices.findPropertyDeveloper(devCond);
					return ;
				}
				PropertyProject pe = new PropertyProject();
				pe.setPropertyName(newName);
				pe.setParentId(0);
				pe.setIsDeleted("0");
				pe.setModId(SessionUser.getUserId());
				pe.setModTime(new Date());
				pe.setCreatedId(SessionUser.getUserId());
				pe.setCreatedTime(pe.getModTime());
				pe.setCompanyProjectId(getProid());
				
				pe.setProjectDesc(projectDesc);
				pe.setPropertyAddress(propertyAddress);
				pe.setAreaName(areaName);
				pe.setSaleCard(saleCard);
				pe.setDeveloperId(Integer.parseInt(proDevName));
				iPropertyProjectServices.addPropertyProject(pe);
				setSuggestion("操作成功");
				setUpMarkToClose();
				projectDesc = "";
				propertyAddress = "";
				areaName = "";
				saleCard = "";
				PropertyDeveloperCond devCond = new PropertyDeveloperCond();
				devCond.setCompanyProjectId(getProid());
				devList = iPropertyDeveloperServices.findPropertyDeveloper(devCond);
				
				//添加固定的5种付款方式
				PayWay payway = new PayWay();
				payway.setIsDeleted("0");
				payway.setCreatedId(SessionUser.getUserId());
				payway.setCreatedTime(new Date());
				payway.setModId(payway.getCreatedId());
				payway.setModTime(payway.getCreatedTime());
				payway.setProjectId(pe.getId());
				
				payway.setPayName("一次性付款");
				payWayServices.addPayWay(payway);
				
				payway.setPayName("分期付款");
				payWayServices.addPayWay(payway);
				
				payway.setPayName("商业按揭");
				payWayServices.addPayWay(payway);
				
				payway.setPayName("组合贷款");
				payWayServices.addPayWay(payway);
				
				payway.setPayName("公积金贷款");
				payWayServices.addPayWay(payway);
				
			}
		}.execute();
		
		return "prosuc";
		
	}
	
	/**
	 * 根据newName 新建一个area
	 * */
	public String addArea(){
		
		if(newName == null || newName.trim().equals("")){
			newName = "";
			this.type = "add_area";
			this.setSuggestion("操作失败,请填写名称.");
			return addSome();
		}
		PropertyArea pe = new PropertyArea();
		pe.setAreaName(this.newName);
		pe.setPropertyId(this.id);
		pe.setIsDeleted("0");
		pe.setModId(SessionUser.getUserId());
		pe.setModTime(new Date());
		pe.setCreatedId(SessionUser.getUserId());
		pe.setCreatedTime(pe.getModTime());
		this.iPropertyAreaServices.addPropertyArea(pe);
		this.setSuggestion("操作成功.");
		this.setUpMarkToClose();
		this.type = "add_area";
		return addSome();
	}
	
	private String chipType;
	/**
	 * 根据newName 新建一个build
	 * */
	public String addBuild(){
		type = "add_build";
		text1 = "在分区<font color=red>"+iPropertyAreaServices.findPropertyAreaById(id).getAreaName()+"</font> 下新建楼栋";
		if(newName == null || newName.trim().equals("")){
			this.setSuggestion("操作失败,请填写名称");
			return "suc";
		}
		PropertyBuild pe = new PropertyBuild();
		pe.setBuildName(this.newName);
		pe.setAreaId(this.id);
		pe.setPropertyId(this.iPropertyAreaServices.findPropertyAreaById(id).getPropertyId());
		pe.setChipType(chipType);
		pe.setIsDeleted("0");
		pe.setModId(SessionUser.getUserId());
		pe.setModTime(new Date());
		pe.setCreatedId(SessionUser.getUserId());
		pe.setCreatedTime(pe.getModTime());
		
		this.iPropertyBuildServices.addPropertyBuild(pe);
		
		
		//TODO 新建楼栋的时候加一套售后问卷
		//initQuestion(pe.getId());
		
		
		
		this.setSuggestion("操作成功.");
		this.setUpMarkToClose();
		return "suc";
	}
	
	private int copyToAreaId;
	/**
	 * copy 一个build 以及他的下属unit
	 * */
	public String copyBuildDialog(){
		initSelAreaMap();
		PropertyBuild b = this.iPropertyBuildServices.findPropertyBuildById(id);
		text1 = b.getBuildName();
		actionPath = "./saleunit_new_init/appoint/guangzhou/copyBuildDialog.action";
		if(newName == null || newName.trim().equals("")){
			sug = "<font color=red>名称不能为空</font>";
			return "suc";
		}
		copyByNameAndBuildId(newName,id,copyToAreaId,this.chipType);
		sug =  "<font color=red>复制成功</font>";
		return "suc";
	}
	
	
	/**
	 * 需要的参数 
	 * copy的buildId 新的build的NAME
	 * */
	public String copyBuildForm(){
		PropertyBuild b = this.iPropertyBuildServices.findPropertyBuildById(id);
		text1 = b.getBuildName();
		actionPath = "./saleunit_new_init/appoint/guangzhou/copyBuildDialog.action";
		initSelAreaMap();
		return "suc";
	}
	private HashMap<String, String> selChipMap;
	private HashMap<String, String> selAreaMap;
	private void initSelAreaMap(){//查询可以操作的area
		selChipMap = codeTypeServices.findCodeListForSel(EnumCodeTypeName.CHIP_TYPE,getProid());
		
		List<PropertyProject> proList = JsonUtils.roleProlist(this.getProid());
		List<PropertyArea> areaList = new ArrayList<PropertyArea>();
		PropertyAreaCond areaCond= new PropertyAreaCond();
		selAreaMap = new HashMap<String, String>();
		if(proList.isEmpty()){
			return ;
		}else{
			for(PropertyProject p : proList){
				areaCond.setPropertyId(p.getId());
				List<PropertyArea> aa =MyPropertyUtils.getPropertyAreaServices().findPropertyArea(areaCond);
				areaList.addAll(aa);
			}
		}
		
		for(PropertyArea a : areaList){
			selAreaMap.put(a.getId()+"", a.getDescPropertyId()+"--"+ a.getAreaName());
		}
	}
	
	/*************修改名字***
	 * 2012-10月之后各种类型修改已经不能共用
	 * */
	public String renameSome(){
		this.removeSuggestion();
		actionPath = path.get(type);
		if(type.equals("rename_project")){
			text1 = "修改楼盘<font color=red>"+iPropertyProjectServices.findPropertyProjectById(id).getPropertyName()+"</font>";
			//return "project";
		}
		if(type.equals("rename_area")){
			text1 = "修改分区<font color=red>"+iPropertyAreaServices.findPropertyAreaById(id).getAreaName()+"</font>";
			PropertyArea aa = new PropertyArea();
			aa = this.iPropertyAreaServices.findPropertyAreaById(id);
			this.newName = aa.getAreaName();
			return "updateArea";
		}
		if(type.equals("rename_build"))text1 = "修改楼栋<font color=red>"+iPropertyBuildServices.findPropertyBuildById(id).getBuildName()+"</font>";
		return "suc";
	}
	
	
	private int upProId;
	private PropertyProject upProject;
	/**
	 * 项目需要修改详细信息
	 * */
	public String updateProjectDialog(){
		this.removeSuggestion();
		this.upProject = this.iPropertyProjectServices.findPropertyProjectById(upProId);
		PropertyDeveloperCond devCond = new PropertyDeveloperCond();
		devCond.setCompanyProjectId(getProid());
		devList = iPropertyDeveloperServices.findPropertyDeveloper(devCond);
		
		return "suc";
	}
	
	/**
	 *  2012-9-3 增加删除已经多个字段
	 * 
	 *	需要修改界面单独分离出来
	 * */
	public String updateProjectForm(){
		if(upProject.getIsDeleted().equals("1")){
			PropertyAreaCond cond = new PropertyAreaCond();
			cond.setPropertyId(upProject.getId());
			List<PropertyArea> ar = this.iPropertyAreaServices.findPropertyArea(cond);
			if( ar.size() > 0){
				this.setSuggestion("请先删除该楼盘下分区");
			}else{
				iPropertyProjectServices.deletePropertyProject(upProject.getId());
				this.setSuggestion("删除成功");
				this.setUpMarkToClose();
			}
			PropertyDeveloperCond devCond = new PropertyDeveloperCond();
			devCond.setCompanyProjectId(getProid());
			devList = iPropertyDeveloperServices.findPropertyDeveloper(devCond);
			return "suc";
		}
		
		if(upProject.getPropertyName().trim().equals("")){
			this.setSuggestion("操作失败,请填写名称.");
			PropertyDeveloperCond devCond = new PropertyDeveloperCond();
			devCond.setCompanyProjectId(getProid());
			devList = iPropertyDeveloperServices.findPropertyDeveloper(devCond);
			return "suc";
		}
		
		PropertyProject oldPro = this.iPropertyProjectServices.findPropertyProjectById(upProject.getId());
		
		oldPro.setPropertyName(upProject.getPropertyName());
		oldPro.setSaleCard(upProject.getSaleCard());
		oldPro.setPropertyAddress(upProject.getPropertyAddress());
		oldPro.setAreaName(upProject.getAreaName());
		oldPro.setProjectDesc(upProject.getProjectDesc());
		oldPro.setDeveloperId(upProject.getDeveloperId());
		
		oldPro.setModId(SessionUser.getUserId());
		oldPro.setModTime(new Date());
		this.iPropertyProjectServices.updatePropertyProject(oldPro);
		PropertyDeveloperCond devCond = new PropertyDeveloperCond();
		devCond.setCompanyProjectId(getProid());
		devList = iPropertyDeveloperServices.findPropertyDeveloper(devCond);
		this.setSuggestion("操作成功");
		this.setUpMarkToClose();
		return "suc";
	}
	@Deprecated
	public String renameProject(){
		PropertyProject pe = this.iPropertyProjectServices.findPropertyProjectById(this.id);
		sug = "楼盘名称:"+pe.getPropertyName()+">>"+newName;
		if(newName == null || newName.trim().equals("")){
			this.setSuggestion("操作失败,请填写名称.");
			return "suc";
		}
		
		pe.setPropertyName(this.newName);
		pe.setModId(SessionUser.getUserId());
		pe.setModTime(new Date());
		this.iPropertyProjectServices.updatePropertyProject(pe);
		return "suc";
	}
	public String renameArea(){
		PropertyArea pe = this.iPropertyAreaServices.findPropertyAreaById(this.id);
		sug = "分区名称:"+pe.getAreaName()+">>"+newName;
		if(newName == null || newName.trim().equals("")){
			this.setSuggestion("操作失败,请填写名称.");
			return "suc";
		}
		pe.setAreaName(this.newName);
		pe.setModId(SessionUser.getUserId());
		pe.setModTime(new Date());
		this.iPropertyAreaServices.updatePropertyArea(pe);
		this.setSuggestion("操作成功");
		this.setUpMarkToClose();
		return "suc";
	}
	public String renameBuild(){
		PropertyBuild pe = this.iPropertyBuildServices.findPropertyBuildById(this.id);
		sug = "楼栋名称:"+pe.getBuildName()+">>"+newName;
		if(newName == null || newName.trim().equals("")){
			this.setSuggestion("操作失败,请填写名称.");
			return "suc";
		}
		pe.setBuildName(this.newName);
		pe.setModId(SessionUser.getUserId());
		pe.setModTime(new Date());
		this.iPropertyBuildServices.updatePropertyBuild(pe);
		this.setSuggestion("操作成功");
		this.setUpMarkToClose();
		return "suc";
	}
	
	
	private int upBuildId;
	private PropertyBuild upBuild;
	/**
	 * @param upBuild 需要更新的build
	 * @param upBuildId 选择的楼栋ID
	 * @return 
	 */
	public String updateBuildDialog(){
		this.removeSuggestion();
		upBuild = this.iPropertyBuildServices.findPropertyBuildById(this.upBuildId);
		return "suc";
	}
	/**
	 * 提交修改楼栋信息表单  变量同上
	 * */
	public String updateBuildForm(){
		try {
			PropertyBuild oldBuild = this.iPropertyBuildServices.findPropertyBuildById(upBuild.getId());
			if(upBuild.getBuildName() == null || upBuild.getBuildName().trim().equals("")){
				upBuild = oldBuild;
				this.setSuggestion("操作失败,请填写名称.");
				return "suc";
			}
			
			if(upBuild.getIsDeleted().trim().equals("1")){//删除该楼栋
				
				//该楼栋下面有一个unit sale_state 超过3的 则不能删除
				List<PropertyUnit> tbList = this.iPropertyUnitServices.findUnitsByBuildId(upBuild.getId()); 
				boolean canDel = true;
				for(PropertyUnit u : tbList){
					if(Integer.parseInt(u.getSaleState()) > 3){
						canDel = false;
						break;
					}
				}
				if(canDel){
					this.iPropertyBuildServices.deletePropertyBuild(upBuild.getId());
					this.setSuggestion("操作成功.删除楼栋");
					this.setUpMarkToClose();
					return "suc";
				}else{
					this.setSuggestion("该楼栋已经有房间出售,不能删除");
					return "suc";
				}
			}else{
				oldBuild.setBuildName(upBuild.getBuildName());
				oldBuild.setModId(SessionUser.getUserId());
				oldBuild.setModTime(new Date());
				this.iPropertyBuildServices.updatePropertyBuild(oldBuild);
			}
			this.setSuggestion("操作成功.修改名称");
			this.setUpMarkToClose();
			return "suc";
		} catch (Exception e) {
			this.setSuggestion("操作异常");
			
		}
		return "suc";
	}
	
	/**
	 * 新建一个build 
	 * 然后复制所有的UNIT到他的下面
	 * */
	@Deprecated
	private void copyByNameAndBuildId(String cbName,int cbid){
		PropertyBuild tempBuild = iPropertyBuildServices.findPropertyBuildById(cbid);
		
		tempBuild.setBuildName(cbName);
		tempBuild.setCreatedId(SessionUser.getUserId());
		tempBuild.setCreatedTime(new Date());
		tempBuild.setModId(SessionUser.getUserId());
		tempBuild.setModTime(tempBuild.getCreatedTime());
		iPropertyBuildServices.addPropertyBuild(tempBuild);
		//TODO 复制基本问卷
		initQuestion(tempBuild.getId());
		
		int newBid = tempBuild.getId();
		
		PropertyUnitCond cond = new PropertyUnitCond();
		cond.setBuildId(cbid + "");
		List<PropertyUnit> cblist = iPropertyUnitServices.findPropertyUnit(cond);
		
		for(PropertyUnit pu : cblist){
			pu.setBuildId(newBid);
			pu.setCreatedId(SessionUser.getUserId());
			pu.setCreatedTime(new Date());
			pu.setModId(SessionUser.getUserId());
			pu.setModTime(pu.getCreatedTime());
			pu.setSaleState("1");
			iPropertyUnitServices.addPropertyUnit(pu);
		}
	}
	
	/**
	 * 2012-9-21 修改楼栋复制可以复制到任意分区下
	 * @param cbName : 楼栋名称
	 * @param cbid : 复制的源楼栋
	 * @param areaId : 复制的目的区域
	 * @author just
	 * */
	private void copyByNameAndBuildId(String cbName,int cbid,int areaId,String chip){
		PropertyArea ar = iPropertyAreaServices.findPropertyAreaById(areaId);
		PropertyBuild tempBuild = new PropertyBuild();
		tempBuild.setAreaId(ar.getId());
		tempBuild.setPropertyId(ar.getPropertyId());
		tempBuild.setChipType(chip);
		tempBuild.setIsDeleted("0");
		tempBuild.setBuildName(cbName);
		tempBuild.setCreatedId(SessionUser.getUserId());
		tempBuild.setCreatedTime(new Date());
		tempBuild.setModId(SessionUser.getUserId());
		tempBuild.setModTime(tempBuild.getCreatedTime());
		iPropertyBuildServices.addPropertyBuild(tempBuild);
		//TODO 复制基本问卷
		initQuestion(tempBuild.getId());
		
		int newBid = tempBuild.getId();
		
		PropertyUnitCond cond = new PropertyUnitCond();
		cond.setBuildId(cbid + "");
		List<PropertyUnit> cblist = iPropertyUnitServices.findPropertyUnit(cond);
		
		for(PropertyUnit pu : cblist){
			pu.setBuildId(newBid);
			pu.setCreatedId(SessionUser.getUserId());
			pu.setCreatedTime(new Date());
			pu.setModId(SessionUser.getUserId());
			pu.setModTime(pu.getCreatedTime());
			pu.setSaleState("1");
			iPropertyUnitServices.addPropertyUnit(pu);
		}
	}
	
	
	private boolean initQuestion(int buildId){
		try {
		Question que = new Question();
		que.setBuildId(buildId);
		que.setQuestionName("基本问卷");
		
		this.questionServices.addQuestion(que);
		
		this.questionTopicServices.insertBaseTopic(que.getId());
		CommonPojoUtils.initPojoCommonFiled(que);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	private String isDeleted;
	
	/**
	 * 修改分区信息 2012-11-06
	 * 包含删除
	 * @param Id 
	 * @param newName
	 * @param isDeleted
	 * @throws Exception 
	 * */
	public String updateAreaForm() throws Exception{
		if(id == 0 ){
			this.setSuggestion("请选择分区");
			this.setUpMarkToClose();
			return "suc";
		}
		
		final PropertyArea aa = iPropertyAreaServices.findPropertyAreaById(id);
		text1 = "修改分区<font color=red>"+aa.getAreaName()+"</font>";
		
		if(isDeleted.equals("1")){
			PropertyBuildCond cond = new PropertyBuildCond();
			cond.setAreaId(id+"");
			List<PropertyBuild> tmB = this.iPropertyBuildServices.findPropertyBuild(cond);
			if(tmB.size() > 0 ){
				this.setSuggestion("请先删除分区下面楼栋再删除本分区");
				return "suc";
			}
			this.iPropertyAreaServices.deletePropertyArea(id);
			this.setSuggestion("操作成功,删除分区");
			this.setUpMarkToClose();
			return "suc";
		}
		
		new MyTransationTemplate() {
			
			@Override
			protected void doExecuteCallback() throws Exception {
				
				//修改分区
				aa.setAreaName(newName);
				aa.setModId(SessionUser.getUserId());
				aa.setModTime(new Date());
				iPropertyAreaServices.updatePropertyArea(aa);
				
				//修改对应楼栋的排序
				BuildUnitUtils.sortBuildId(request);
				
				setSuggestion("操作成功,修改名称");
				setUpMarkToClose();
				
			}
		}.doExecuteCallback();
		
		return "suc";
	}
	
	
	
	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSug() {
		return sug;
	}

	public void setSug(String sug) {
		this.sug = sug;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getActionPath() {
		return actionPath;
	}

	public void setActionPath(String actionPath) {
		this.actionPath = actionPath;
	}

	public List<PropertyDeveloper> getDevList() {
		return devList;
	}

	public void setDevList(List<PropertyDeveloper> devList) {
		this.devList = devList;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getProDevName() {
		return proDevName;
	}

	public void setProDevName(String proDevName) {
		this.proDevName = proDevName;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getSaleCard() {
		return saleCard;
	}

	public void setSaleCard(String saleCard) {
		this.saleCard = saleCard;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getUpProId() {
		return upProId;
	}

	public void setUpProId(int upProId) {
		this.upProId = upProId;
	}

	public PropertyProject getUpProject() {
		return upProject;
	}

	public void setUpProject(PropertyProject upProject) {
		this.upProject = upProject;
	}

	public String getChipType() {
		return chipType;
	}

	public void setChipType(String chipType) {
		this.chipType = chipType;
	}

	public int getCopyToAreaId() {
		return copyToAreaId;
	}

	public void setCopyToAreaId(int copyToAreaId) {
		this.copyToAreaId = copyToAreaId;
	}

	public HashMap<String, String> getSelAreaMap() {
		return selAreaMap;
	}

	public void setSelAreaMap(HashMap<String, String> selAreaMap) {
		this.selAreaMap = selAreaMap;
	}

	public HashMap<String, String> getSelChipMap() {
		return selChipMap;
	}

	public void setSelChipMap(HashMap<String, String> selChipMap) {
		this.selChipMap = selChipMap;
	}

	public int getUpBuildId() {
		return upBuildId;
	}

	public void setUpBuildId(int upBuildId) {
		this.upBuildId = upBuildId;
	}

	public PropertyBuild getUpBuild() {
		return upBuild;
	}

	public void setUpBuild(PropertyBuild upBuild) {
		this.upBuild = upBuild;
	}
	
	
	
}
