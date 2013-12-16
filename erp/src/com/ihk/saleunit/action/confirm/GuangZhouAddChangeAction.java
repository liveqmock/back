package com.ihk.saleunit.action.confirm;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.saleunit.data.pojo.ApprovalChange;
import com.ihk.saleunit.data.pojo.ChangeOut;
import com.ihk.saleunit.data.pojo.ChangeOutCond;
import com.ihk.saleunit.data.pojo.ChangeOwner;
import com.ihk.saleunit.data.pojo.ChangeOwnerCond;
import com.ihk.saleunit.data.pojo.ChangeOwnerDetail;
import com.ihk.saleunit.data.pojo.ChangeOwnerDetailCond;
import com.ihk.saleunit.data.pojo.ChangePrice;
import com.ihk.saleunit.data.pojo.ChangePriceCond;
import com.ihk.saleunit.data.pojo.ChangeUnit;
import com.ihk.saleunit.data.pojo.ChangeUnitCond;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.PropertyOwner;
import com.ihk.saleunit.data.pojo.PropertyOwnerCond;
import com.ihk.saleunit.data.services.IApprovalChangeServices;
import com.ihk.saleunit.data.services.IChangeOutServices;
import com.ihk.saleunit.data.services.IChangeOwnerDetailServices;
import com.ihk.saleunit.data.services.IChangeOwnerServices;
import com.ihk.saleunit.data.services.IChangePriceServices;
import com.ihk.saleunit.data.services.IChangeUnitServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IPropertyOwnerServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;


/**
 * 修改审批
 */
public class GuangZhouAddChangeAction extends SupperAction {
	
	private static final long serialVersionUID = 1L;
	@Autowired IConfirmServices iConfirmServices;
	@Autowired IChangeOutServices iChangeOutServices;
	@Autowired IChangeOwnerServices iChangeOwnerServices;
	@Autowired IChangePriceServices IChangePriceServices;
	@Autowired IChangeUnitServices iChangeUnitServices;
	@Autowired IApprovalChangeServices IApprovalChangeServices;
	@Autowired IPropertyOwnerServices iPropertyOwnerServices;
	@Autowired IChangeOwnerDetailServices iChangeOwnerDetailServices;
	private String changeType;   //修改单的类型
	private String changeId;     //修改单的ID
	
	private ChangePrice changePriceInfo;//变价格
	private ChangeUnit changeUnitInfo;//变房间
	private ChangeOwner changeOwnerInfo; //变权益人
	private ChangeOut changeOutInfo;//退房变更
	
	private ChangePrice changePriceForm;//变价格
	private ChangeUnit changeUnitForm;//变房间
	private ChangeOwner changeOwnerForm; //变权益人
	private ChangeOut changeOutForm;//退房变更
	
	private String confirmId;//热的 认购单
	private Confirm confirm;//
	
	private String CONFIRM_TYPE = "1"; //状态 用来判断是 认购还是合同
	
	private List<ApprovalChange> appChangeList;//index展示LIST
	
	private List<ChangePrice> changePriceList;
	private List<ChangeUnit> changeUnitList;
	private List<ChangeOwner> changeOwnerList;
	private List<ChangeOut> changeOutList;
	
	/**
	 * 显示该认购ID的相关变更列表
	 * 可以查看各个列表的详细信息
	 * 可以申请4种变更的弹出
	 * 可以查看4种变更的弹出
	 * */
	public String index(){
		this.init();
		return "suc";
	}
	private void init(){//主页面需要的信息
		confirm = this.iConfirmServices.findConfirmById(Integer.parseInt(this.confirmId));//认购单信息
		
		int cid = Integer.parseInt(this.confirmId);
		//修改单 根据主ID查询 
		//ApprovalChangeCond cond = new ApprovalChangeCond();
		//1 表示认购 2表示合同
		ChangePriceCond cond1 =  new ChangePriceCond();
		cond1.setMainId(cid);
		cond1.setConfirmType(CONFIRM_TYPE);
		changePriceList = this.IChangePriceServices.findChangePrice(cond1);
		
		ChangeUnitCond cond2 =  new ChangeUnitCond();
		cond2.setMainId(cid);
		cond2.setConfirmType(CONFIRM_TYPE);
		changeUnitList = this.iChangeUnitServices.findChangeUnit(cond2);
		
		ChangeOwnerCond cond3 =  new ChangeOwnerCond();
		cond3.setMainId(cid);
		cond3.setConfirmType(CONFIRM_TYPE);
		changeOwnerList = this.iChangeOwnerServices.findChangeOwner(cond3);
		
		ChangeOutCond cond4 =  new ChangeOutCond();
		cond4.setMainId(cid);
		cond4.setConfirmType(CONFIRM_TYPE);
		changeOutList = this.iChangeOutServices.findChangeOut(cond4);
		
	}
	
	/**
	 * 查看响应点击事件的 具体修改信息
	 * @param 单的类型 和ID 来确定是哪一个修改单
	 * resut应该有几个类型的修改 就有几种
	 * 
	 *查看
	 * */
	private  List<ChangeOwnerDetail> OwnerListForDetail;
	public String approvalInformation(){
		int cid ;
		try {
			cid = Integer.parseInt(this.changeId);
			if(cid==0)return "err";
		} catch (Exception e) {
			return "err";
		}
		confirm = this.iConfirmServices.findConfirmById(confirm.getId());//认购单信息
		if(this.changeType.equals("price")){//价格
			this.changePriceInfo = this.IChangePriceServices.findChangePriceById(cid);
			return "price";
		}
		
		if(this.changeType.equals("unit")){//房间
			this.changeUnitInfo = this.iChangeUnitServices.findChangeUnitById(cid);
			return "unit";
		}
		
		if(this.changeType.equals("owner")){//权益人
			this.changeOwnerInfo = this.iChangeOwnerServices.findChangeOwnerById(cid);
			PropertyOwnerCond onerCond = new PropertyOwnerCond();
			onerCond.setMainId(confirm.getId()+"");
			onerCond.setConfirmType("1");
			ownerList = iPropertyOwnerServices.findPropertyOwner(onerCond);
			ChangeOwnerDetailCond ccond = new ChangeOwnerDetailCond();
			ccond.setChangeId(changeId);
			OwnerListForDetail = iChangeOwnerDetailServices.findChangeOwnerDetail(ccond);
			return "owner";
		}
		if(this.changeType.equals("out")){//退房
			this.changeOutInfo = this.iChangeOutServices.findChangeOutById(cid);
			return "out";
		}
		return "err";
	}
	
	/**
	 * 在已经确定的 confirm里面添加变更
	 *  这里只是确定是那个 添加的弹出框
	 *  * price_way1 计价方式
	 * is_merge1 是否并入合同
	 * pay_type2 付款方式
	 * 
	 * 提交审批申请
	 * */
	private LinkedHashMap selPriceWay;
	private LinkedHashMap selPayType;
	private List<PropertyOwner> ownerList;
	public String addChangeForThisConfirmIndex(){
		// 1根据 变更类型确定 弹出什么样的 输入框
		confirm = iConfirmServices.findConfirmById(confirm.getId());
		if(this.changeType.equals("price")){
			initForPrice();
			return "price";
		}
		if(this.changeType.equals("unit"))return "unit";
		if(this.changeType.equals("owner")){
			//原来的权益人列表 ownerList
			PropertyOwnerCond onerCond = new PropertyOwnerCond();
			onerCond.setMainId(confirm.getId()+"");
			onerCond.setConfirmType("1");
			ownerList = iPropertyOwnerServices.findPropertyOwner(onerCond);
			request.getSession().setAttribute("changeOwnerList", ownerList);
			return "owner";
		}
		if(this.changeType.equals("out"))return "out";
		return "suc";
	}
	/**在增加权益人修改的时候
	 * 需要保存一个权益人列表
	 * */
	private PropertyOwner ownerForAdd;
	public String addOwnerForaddChangeForThisConfirmOwner(){
		confirm = iConfirmServices.findConfirmById(confirm.getId());
		//需要和审批申请一样的条件  confirm.id    
		PropertyOwnerCond onerCond = new PropertyOwnerCond();
		onerCond.setMainId(confirm.getId()+"");
		onerCond.setConfirmType("1");
		ownerList = iPropertyOwnerServices.findPropertyOwner(onerCond);
		//增加Sessions里保存的changeOwnerList
		List<PropertyOwner> tt = (List<PropertyOwner>) request.getSession().getAttribute("changeOwnerList");
		tt.add(ownerForAdd);
		request.getSession().setAttribute("changeOwnerList", tt);
		return "owner";
	}
	
	/**提交价格变更单据
	 * 需要一些sel 
	 * */
	public String addChangeForThisConfirmPrice() {
		String tip = "";
		confirm = iConfirmServices.findConfirmById(confirm.getId());
		changePriceForm.setPriceWay1(confirm.getPriceWay());
		//changePriceForm.setPayType1(confirm.getPayType());  ///---
		changePriceForm.setPayType1(confirm.getPayWayId() + "");
		changePriceForm.setDiscountPercent1(confirm.getDiscountPercent());
		changePriceForm.setBuildPrice1(confirm.getBuildPrice());
		changePriceForm.setInsideUnitPrice1(confirm.getInsideUnitPrice());
		changePriceForm.setDiscountDesc1(confirm.getDiscountDesc());
		changePriceForm.setSumMoney1(confirm.getSumMoney());
		changePriceForm.setRenovateDesc1(confirm.getRenovateDesc());
		changePriceForm.setRenovatePrice1(confirm.getRenovatePrice());
		changePriceForm.setIsMerge1(confirm.getIsMerge());
		changePriceForm.setRenovateMoney1(confirm.getRenovateMoney());
		changePriceForm.setAgreeNo1(confirm.getAgreeNo());
		changePriceForm.setShouldDeposit1(confirm.getShouldDeposit());
		changePriceForm.setAgreeMoney1(confirm.getAgreeMoney());

		changePriceForm.setMainId(this.confirm.getId());
		changePriceForm.setConfirmType(CONFIRM_TYPE);
		changePriceForm.setApplyUser(SessionUser.getUserId());
		changePriceForm.setApplyDate(new Date());
		changePriceForm.setApplyState("1");
		changePriceForm.setCreatedId(SessionUser.getUserId());
		changePriceForm.setCreatedTime(changePriceForm.getApplyDate());
		changePriceForm.setModId(changePriceForm.getCreatedId());
		changePriceForm.setModTime(changePriceForm.getCreatedTime());
		changePriceForm.setIsDeleted("0");
		this.IChangePriceServices.addChangePrice(this.changePriceForm);
		tip = "申请成功";
		try {
			CustomerUtils.writeResponse(response, tip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String addChangeForThisConfirmOwner(){
		String tip = "";
		changeOwnerForm.setMainId(this.confirm.getId());
		changeOwnerForm.setConfirmType(CONFIRM_TYPE);
		changeOwnerForm.setApplyUser(SessionUser.getUserId());
		changeOwnerForm.setApplyDate(new Date());
		changeOwnerForm.setApplyState("1");
		changeOwnerForm.setCreatedId(SessionUser.getUserId());
		changeOwnerForm.setCreatedTime(changeOwnerForm.getApplyDate());
		changeOwnerForm.setModId(changeOwnerForm.getCreatedId());
		changeOwnerForm.setModTime(changeOwnerForm.getCreatedTime());
		changeOwnerForm.setIsDeleted("0");
		
		List<PropertyOwner> ff = null;
		try {
			ff = (List<PropertyOwner>)request.getSession().getAttribute("changeOwnerList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(ff == null || ff .size() == 0){
			tip = "申请失败, 没有修改权益人";
			try {
				CustomerUtils.writeResponse(response, tip);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		this.iChangeOwnerServices.addChangeOwner(this.changeOwnerForm);
		
		int cid  = changeOwnerForm.getId();
		//然后拿到这个数据的ID之后 添加SESSION 里的OWNER LIST
		ChangeOwnerDetail temp = new ChangeOwnerDetail();
		temp.setIsDeleted("0");
		temp.setCreatedTime(new Date());
		temp.setModTime(temp.getCreatedTime());
		temp.setCreatedId(SessionUser.getUserId());
		temp.setModId(temp.getCreatedId());
		temp.setChangeId(cid);
		
		for(PropertyOwner cc : ff){		   
			temp.setCustomerName(cc.getCustomerName());
			temp.setIdcardNo(cc.getIdcardNo());
			temp.setPhone(cc.getPhone());
			temp.setRightPercent(cc.getRightPercent());
			temp.setAgentName(cc.getAgentName());
			temp.setAgentNation(cc.getAgentNation());
			temp.setCardNum(cc.getCardNum());
			temp.setAgentPhone(cc.getAgentPhone());

			iChangeOwnerDetailServices.addChangeOwnerDetail(temp);
		}
		tip = "申请成功";
		try {
			CustomerUtils.writeResponse(response, tip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String addChangeForThisConfirmUnit(){
		String tip = "";
		confirm = iConfirmServices.findConfirmById(confirm.getId());
		changeUnitForm.setMainId(this.confirm.getId());
		changeUnitForm.setUnitId1(confirm.getUnitId());
		changeUnitForm.setConfirmType(CONFIRM_TYPE);
		changeUnitForm.setApplyUser(SessionUser.getUserId());
		changeUnitForm.setApplyDate(new Date());
	//	changeUnitForm.setApplyState("1");
		changeUnitForm.setCreatedId(SessionUser.getUserId());
		changeUnitForm.setCreatedTime(changeUnitForm.getApplyDate());
		changeUnitForm.setModId(changeUnitForm.getCreatedId());
		changeUnitForm.setModTime(changeUnitForm.getCreatedTime());
		changeUnitForm.setIsDeleted("0");
		this.iChangeUnitServices.addChangeUnit(this.changeUnitForm);
		tip = "申请成功";
		try {
			CustomerUtils.writeResponse(response, tip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String addChangeForThisConfirmOut(){
		String tip = "";
		changeOutForm.setMainId(this.confirm.getId());
		changeOutForm.setConfirmType(CONFIRM_TYPE);
		changeOutForm.setApplyUser(SessionUser.getUserId());
		changeOutForm.setApplyDate(new Date());
		changeOutForm.setApplyState("1");
		changeOutForm.setCreatedId(SessionUser.getUserId());
		changeOutForm.setCreatedTime(changeOutForm.getApplyDate());
		changeOutForm.setModId(changeOutForm.getCreatedId());
		changeOutForm.setModTime(changeOutForm.getCreatedTime());
		changeOutForm.setIsDeleted("0");
		this.iChangeOutServices.addChangeOut(this.changeOutForm);
		tip = "申请成功";
		try {
			CustomerUtils.writeResponse(response, tip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void initForPrice(){
		selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay,EnumCodeTypeName.PROPERTY_PRICE_WAY,true);
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType,EnumCodeTypeName.PROPERTY_PAY_TYPE,true);
	}
	
	
	/************************************************************/
	public ChangePrice getChangePriceInfo() {
		return changePriceInfo;
	}


	public void setChangePriceInfo(ChangePrice changePriceInfo) {
		this.changePriceInfo = changePriceInfo;
	}


	public ChangeUnit getChangeUnitInfo() {
		return changeUnitInfo;
	}


	public void setChangeUnitInfo(ChangeUnit changeUnitInfo) {
		this.changeUnitInfo = changeUnitInfo;
	}


	public ChangeOwner getChangeOwnerInfo() {
		return changeOwnerInfo;
	}


	public void setChangeOwnerInfo(ChangeOwner changeOwnerInfo) {
		this.changeOwnerInfo = changeOwnerInfo;
	}


	public ChangeOut getChangeOutInfo() {
		return changeOutInfo;
	}


	public void setChangeOutInfo(ChangeOut changeOutInfo) {
		this.changeOutInfo = changeOutInfo;
	}


	public String getConfirmId() {
		return confirmId;
	}


	public void setConfirmId(String confirmId) {
		this.confirmId = confirmId;
	}


	public Confirm getConfirm() {
		return confirm;
	}


	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}


	public String getChangeId() {
		return changeId;
	}


	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}


	public String getChangeType() {
		return changeType;
	}


	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public List<ApprovalChange> getAppChangeList() {
		return appChangeList;
	}
	public void setAppChangeList(List<ApprovalChange> appChangeList) {
		this.appChangeList = appChangeList;
	}
	public List<ChangePrice> getChangePriceList() {
		return changePriceList;
	}
	public void setChangePriceList(List<ChangePrice> changePriceList) {
		this.changePriceList = changePriceList;
	}
	public List<ChangeUnit> getChangeUnitList() {
		return changeUnitList;
	}
	public void setChangeUnitList(List<ChangeUnit> changeUnitList) {
		this.changeUnitList = changeUnitList;
	}
	public List<ChangeOwner> getChangeOwnerList() {
		return changeOwnerList;
	}
	public void setChangeOwnerList(List<ChangeOwner> changeOwnerList) {
		this.changeOwnerList = changeOwnerList;
	}
	public List<ChangeOut> getChangeOutList() {
		return changeOutList;
	}
	public void setChangeOutList(List<ChangeOut> changeOutList) {
		this.changeOutList = changeOutList;
	}
	public ChangePrice getChangePriceForm() {
		return changePriceForm;
	}
	public void setChangePriceForm(ChangePrice changePriceForm) {
		this.changePriceForm = changePriceForm;
	}
	public ChangeUnit getChangeUnitForm() {
		return changeUnitForm;
	}
	public void setChangeUnitForm(ChangeUnit changeUnitForm) {
		this.changeUnitForm = changeUnitForm;
	}
	public ChangeOwner getChangeOwnerForm() {
		return changeOwnerForm;
	}
	public void setChangeOwnerForm(ChangeOwner changeOwnerForm) {
		this.changeOwnerForm = changeOwnerForm;
	}
	public ChangeOut getChangeOutForm() {
		return changeOutForm;
	}
	public void setChangeOutForm(ChangeOut changeOutForm) {
		this.changeOutForm = changeOutForm;
	}
	public LinkedHashMap getSelPriceWay() {
		return selPriceWay;
	}
	public void setSelPriceWay(LinkedHashMap selPriceWay) {
		this.selPriceWay = selPriceWay;
	}
	public LinkedHashMap getSelPayType() {
		return selPayType;
	}
	public void setSelPayType(LinkedHashMap selPayType) {
		this.selPayType = selPayType;
	}
	public List<PropertyOwner> getOwnerList() {
		return ownerList;
	}
	public void setOwnerList(List<PropertyOwner> ownerList) {
		this.ownerList = ownerList;
	}
	public PropertyOwner getOwnerForAdd() {
		return ownerForAdd;
	}
	public void setOwnerForAdd(PropertyOwner ownerForAdd) {
		this.ownerForAdd = ownerForAdd;
	}
	public List<ChangeOwnerDetail> getOwnerListForDetail() {
		return OwnerListForDetail;
	}
	public void setOwnerListForDetail(List<ChangeOwnerDetail> ownerListForDetail) {
		OwnerListForDetail = ownerListForDetail;
	}

	
	
	
	
	
	
	
	
	
	
}
