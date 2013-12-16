package com.ihk.saleunit.action;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumChangeType;
import com.ihk.saleunit.data.pojo.ApprovalChange;
import com.ihk.saleunit.data.pojo.ApprovalChangeCond;
import com.ihk.saleunit.data.pojo.ChangeOut;
import com.ihk.saleunit.data.pojo.ChangeOwner;
import com.ihk.saleunit.data.pojo.ChangeOwnerDetail;
import com.ihk.saleunit.data.pojo.ChangeOwnerDetailCond;
import com.ihk.saleunit.data.pojo.ChangePrice;
import com.ihk.saleunit.data.pojo.ChangeUnit;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.PropertyOwner;
import com.ihk.saleunit.data.pojo.PropertyOwnerCond;
import com.ihk.saleunit.data.services.IApprovalChangeServices;
import com.ihk.saleunit.data.services.IChangeOutServices;
import com.ihk.saleunit.data.services.IChangeOwnerDetailServices;
import com.ihk.saleunit.data.services.IChangeOwnerServices;
import com.ihk.saleunit.data.services.IChangePriceServices;
import com.ihk.saleunit.data.services.IChangeUnitServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IPropertyOwnerServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.SupperConfirm;
import com.opensymphony.xwork2.ActionContext;

/**
 * ApprovalChange 
 * 审批
 */
public class GuangZhouApprovalChangeAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired IApprovalChangeServices iApprovalChangeServices;

	
	private List<ApprovalChange> appChangeList;//index展示LIST
	private ApprovalChangeCond appChangeCond;//index查询条件
	
	private String changeId;     //修改单的ID
	private String changeType;   //修改单的类型
	
	private String approvalId ;  //审批单的ID 
	
	//变更的几种类型
	private ChangePrice changePriceInfo;//变价格
	private ChangeUnit changeUnitInfo;//变房间
	private ChangeOwner changeOwnerInfo; //变权益人
	private  List<ChangeOwnerDetail> ownerListForDetail;//变更的权益人
	private List<PropertyOwner> ownerList;//该认购单的权益人
	
	private ChangeOut changeOutInfo;//退房变更

	@Autowired IChangePriceServices iChangePriceServices;
	@Autowired IChangeUnitServices iChangeUnitServices;
	@Autowired IChangeOwnerServices iChangeOwnerServices;
	@Autowired IChangeOutServices iChangeOutServices;
	@Autowired IChangeOwnerDetailServices iChangeOwnerDetailServices;
	@Autowired IConfirmServices iConfirmServices;
	@Autowired IContractServices iContractServices;
	@Autowired IPropertyOwnerServices iPropertyOwnerServices;
	private LinkedHashMap<String,String> selChangeState;//审批状态list 
	private String changeState;//审批状态
	
	private SupperConfirm confirm; //选择的认购单

	
	
	
	public String index(){
		appChangeCond = new ApprovalChangeCond();
		init();
		return "suc";
	}
	
	public String search (){
		init();
		return "suc";
	}
	
	/**
	 * 查看响应点击事件的 具体修改信息
	 * @param 单的类型 和ID 来确定是哪一个修改单
	 * resut应该有几个类型的修改 就有几种
	 * */
	public String approvalInformation(){
		int cid ;
		try {
			cid = Integer.parseInt(this.changeId);
			if(cid==0)return "err";
		} catch (Exception e) {
			return "err";
		}
		
		this.initApprovalInformation();//接受 changeId 和init审批状态list
		
		if(this.changeType.equals(EnumChangeType.CHANGE_PRICE.toString())){//价格
			this.changePriceInfo = this.iChangePriceServices.findChangePriceById(cid);
			if(changePriceInfo.getConfirmType().equals("1")){
				this.confirm = iConfirmServices.findConfirmById(changePriceInfo.getMainId());
			}else if(changePriceInfo.getConfirmType().equals("2")){
				this.confirm = iContractServices.findContractById(changePriceInfo.getMainId());
			}
			
			return "price";
		}
		
		if(this.changeType.equals(EnumChangeType.CHANGE_UNIT.toString())){//房间
			this.changeUnitInfo = this.iChangeUnitServices.findChangeUnitById(cid);
			if(changeUnitInfo.getConfirmType().equals("1")){
				this.confirm = iConfirmServices.findConfirmById(changeUnitInfo.getMainId());
			}else if(changeUnitInfo.getConfirmType().equals("2")){
				this.confirm = iContractServices.findContractById(changeUnitInfo.getMainId());
			}
			return "unit";
		}
		
		if(this.changeType.equals(EnumChangeType.CHANGE_OWNER.toString())){//权益人
			this.changeOwnerInfo = this.iChangeOwnerServices.findChangeOwnerById(cid);
			String condid = "";
			if(changeOwnerInfo.getConfirmType().equals("1")){
				this.confirm = iConfirmServices.findConfirmById(changeOwnerInfo.getMainId());
				condid = ((Confirm) confirm).getId()+"";
			}else if(changeOwnerInfo.getConfirmType().equals("2")){
				this.confirm = iContractServices.findContractById(changeOwnerInfo.getMainId());
				condid = ((Contract) confirm).getId()+"";
			}
			PropertyOwnerCond onerCond = new PropertyOwnerCond();
			onerCond.setMainId(condid);
			onerCond.setConfirmType(changeOwnerInfo.getConfirmType());
			ownerList = iPropertyOwnerServices.findPropertyOwner(onerCond);
			
			ChangeOwnerDetailCond ccond = new ChangeOwnerDetailCond();
			ccond.setChangeId(changeId);
			ownerListForDetail = iChangeOwnerDetailServices.findChangeOwnerDetail(ccond);
			return "owner";
		}
		
		if(this.changeType.equals(EnumChangeType.CHANGE_OUT.toString())){//退房
			this.changeOutInfo = this.iChangeOutServices.findChangeOutById(cid);
			if(changeOutInfo.getConfirmType().equals("1")){
				this.confirm = iConfirmServices.findConfirmById(changeOutInfo.getMainId());
			}else if(changeOutInfo.getConfirmType().equals("2")){
				this.confirm = iContractServices.findContractById(changeOutInfo.getMainId());
			}
			return "out";
		}
		
	
		
		return "err";
	}
	private void initApprovalInformation(){
		
	}
	
	/**
	 * 修改审批的状态
	 * 看需不需要 在修改单据也加一个标示updateApprovalState
	 * 每次修改都需要增加一条记录  
	 * @param 审批的单 ID 
	 * 
	 * 虽然修改的 类型不同  但是只需要把changeId 回传 就可以只需要读取修改状态就可以了
	 * 
	 * */
	public String updateApprovalState(){
		String tip = "";
		int cid = 0 ;
		try {
			cid = Integer.parseInt(this.changeId);
			if(cid==0)tip="错误的数据";
		} catch (Exception e) {
			tip="权限错误";
		}
		try {
			ApprovalChange temp =  this.iApprovalChangeServices.findApprovalChangeById(cid);
			temp.setModTime(new Date());
			temp.setModId(SessionUser.getUserId());
			temp.setApprovalState("2");
			temp.setApprovalMan(temp.getModId());
			temp.setApprovalDate(temp.getModTime());
			temp.setDoMan(temp.getModId());
			temp.setDoDate(temp.getModTime());
			this.iApprovalChangeServices.updateApprovalChange(temp);
			//修改相关的 change 
			//updateForState(temp);//需要调试
			//修改相关的confirm
			
			tip = "修改成功";
		} catch (Exception e) {
			tip="操作失败";
			e.printStackTrace();
		}
		
		try {
			CustomerUtils.writeResponse(response, tip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 批准申请  修改 changeprice changeout changeowner changeunit    STATE
	 * */
	private void updateForState(ApprovalChange changeForState){
		if(changeForState == null || !changeForState.getApprovalState() .equals("2")){
			return;
		}
		if(changeForState.getApprovalState() != null && changeForState.getApprovalState().equals(EnumChangeType.CHANGE_OUT.toString())){
			ChangeOut tempOut = this.iChangeOutServices.findChangeOutById(changeForState.getApplyId());
			tempOut.setApplyState("2");
			tempOut.setModId(SessionUser.getUserId());
			tempOut.setModTime(new Date());
			iChangeOutServices.updateChangeOut(tempOut);
		}
		
	}
	
	private void init(){
		if(appChangeCond == null)appChangeCond = new ApprovalChangeCond();
		String action = CustomerUtils.getActionNameFromRequest(request);
		 Pager page = new Pager(ActionContext.getContext(), 10, action);
		 appChangeCond.recordCount =
		 this.iApprovalChangeServices.findApprovalChangeCount(appChangeCond);
		 page.setCond(appChangeCond);
		 this.appChangeList = this.iApprovalChangeServices.findApprovalChangePage(appChangeCond);
		 this.setShowPage(page.toHtmlString());
	}
	
	/**
	 * 执行 修改对应的合同或者认购
	 * 把审批的数据真正的修改到合同或者认购中去
	 * 1 ： 如果state是2 也就是通过了审批的
	 * 2 ： 根据approvalType 得到是哪一种审批
	 * 3 ：  根据 具体审批类型 得到是合同还是认购
	 * 4 ：  修改相应的合同或者认购数据
	 * */
	@SuppressWarnings("unused")
	private void doApprovalChange(ApprovalChange changeForState){// 执行跳转
		if(changeForState != null && changeForState.getApprovalState() != null && changeForState.getApprovalState().trim().equals("2")){
			if(changeForState.getApplyType().equals(EnumChangeType.CHANGE_OUT.toString()))
				doAppForOut( changeForState);
			if(changeForState.getApplyType().equals(EnumChangeType.CHANGE_OWNER.toString()))
				doAppForOwner( changeForState);
			if(changeForState.getApplyType().equals(EnumChangeType.CHANGE_PRICE.toString()))
				doAppForPrice( changeForState);
			if(changeForState.getApplyType().equals(EnumChangeType.CHANGE_UNIT.toString()))
				doAppForUnit( changeForState);
		}
	}
	private void doAppForOut(ApprovalChange changeForState){//change out 执行   删除
		ChangeOut tempOut;
		tempOut = iChangeOutServices.findChangeOutById(changeForState.getApplyId());
		if(tempOut == null || tempOut.getConfirmType() == null || tempOut.getConfirmType() .trim().equals(""))return ;
		if(tempOut .getConfirmType().trim().equals("1")){
			Confirm outConfirm = iConfirmServices.findConfirmById(tempOut.getMainId());
			outConfirm.setModId(SessionUser.getUserId());
			outConfirm.setModTime(new Date());
			outConfirm.setIsDeleted("1");
			iConfirmServices.updateConfirm(outConfirm);
		}else if (tempOut .getConfirmType().trim().equals("2")){
			Contract outContract = iContractServices.findContractById(tempOut.getMainId());
			outContract.setModId(SessionUser.getUserId());
			outContract.setModTime(new Date());
			outContract.setIsDeleted("1");
			iContractServices.updateContract(outContract);
		}
	}
	private void doAppForOwner(ApprovalChange changeForState){//change owner 执行 删除原先权益人 新增对应权益人
		ChangeOwner tpOwner;
		tpOwner = iChangeOwnerServices.findChangeOwnerById(changeForState.getApplyId());
		if(tpOwner == null || tpOwner.getConfirmType() == null || tpOwner.getConfirmType().trim().equals(""))return ;
		//TODO 删除原先的权益人
		PropertyOwnerCond ocond = new PropertyOwnerCond();
		ocond.setMainId(tpOwner.getMainId()+"");
		ocond.setConfirmType(tpOwner.getConfirmType());
		List<PropertyOwner> owList = iPropertyOwnerServices.findPropertyOwner(ocond);
		for(PropertyOwner o : owList){
			o.setIsDeleted("1");
			o.setModId(SessionUser.getUserId());
			o.setModTime(new Date());
			iPropertyOwnerServices.updatePropertyOwner(o);
		}
		//TODO 新增权益人从 零时权益人
		ChangeOwnerDetailCond odCond = new ChangeOwnerDetailCond();
		List<ChangeOwnerDetail> downerList;
	    downerList = iChangeOwnerDetailServices.findChangeOwnerDetail(odCond);
	    for(ChangeOwnerDetail d : downerList){
	    	PropertyOwner owner = new PropertyOwner();
	    	try {
				CommonPojoUtils.initPojoCommonFiled(owner);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	owner.setConfirmType(tpOwner.getConfirmType());
	    	owner.setMainId(tpOwner.getMainId());
	    	owner.setCustomerName(d.getCustomerName());
	    	owner.setIdcardNo(d.getIdcardNo());
	    	owner.setPhone(d.getPhone());
	    	owner.setRightPercent(d.getRightPercent());
	    	owner.setAgentName(d.getAgentName());
	    	owner.setAgentNation(d.getAgentNation());
	    	owner.setAgentPhone(d.getAgentPhone());
	    	owner.setCardNum(d.getCardNum());
	    	iPropertyOwnerServices.addPropertyOwner(owner);
	    }
	}
	private void doAppForUnit(ApprovalChange changeForState){
		/*
		 * 换房
		 * 1 目标房间没有被锁定
		 * 申请的时候锁定目标房间？ 批准的时候需要判断目标房间锁定？
		 * 
		 * 附属房产？
		 * 跨楼栋换房？
		 * */
		
		
	}
	private void doAppForPrice(ApprovalChange changeForState){
		/*
		 * 价格变更。。 
		 * 还不确定是变那些价格
		 * 是否房间资料也一起变？
		 * 
		 * */
	}
	

	
	public List<ApprovalChange> getAppChangeList() {
		return appChangeList;
	}

	public void setAppChangeList(List<ApprovalChange> appChangeList) {
		this.appChangeList = appChangeList;
	}

	public ApprovalChangeCond getAppChangeCond() {
		return appChangeCond;
	}

	public void setAppChangeCond(ApprovalChangeCond appChangeCond) {
		this.appChangeCond = appChangeCond;
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

	public String getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}

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

	
	public LinkedHashMap<String,String> getSelChangeState() {
		return selChangeState;
	}

	public void setSelChangeState(LinkedHashMap<String,String> selChangeState) {
		this.selChangeState = selChangeState;
	}

	public String getChangeState() {
		return changeState;
	}

	public void setChangeState(String changeState) {
		this.changeState = changeState;
	}

	

	public SupperConfirm getConfirm() {
		return confirm;
	}

	public void setConfirm(SupperConfirm confirm) {
		this.confirm = confirm;
	}

	public List<PropertyOwner> getOwnerList() {
		return ownerList;
	}

	public void setOwnerList(List<PropertyOwner> ownerList) {
		this.ownerList = ownerList;
	}

	public List<ChangeOwnerDetail> getOwnerListForDetail() {
		return ownerListForDetail;
	}

	public void setOwnerListForDetail(List<ChangeOwnerDetail> ownerListForDetail) {
		this.ownerListForDetail = ownerListForDetail;
	}
	
	
}
