package com.ihk.setup.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PayWay;
import com.ihk.property.data.pojo.PayWayCond;
import com.ihk.property.data.pojo.PayWayDetail;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.services.IPayWayDetailServices;
import com.ihk.property.data.services.IPayWayServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.common.setup.PayTypeUtils;
import com.ihk.utils.method.ActionAjaxMethodModifyNoThrowsExceptionCallback;

/**
 * 付款方式相关设定
 * 
 * */
public class SetPayWayAction extends SupperAction{
	
	private static final long serialVersionUID = 2628389383067693835L;
	
	@Autowired private IPayWayServices payWayServices; 
	@Autowired private IPayWayDetailServices payWayDetailServices;
	@Autowired private IPropertyBuildServices propertyBuildServices; 
	@Autowired IConfirmServices confirmServices;
	@Autowired IContractServices contractServices;
	
	//private int buildId;//楼栋ID      2012-11-01 del
    private int propertyProjectId;// 2012-11-1 修改付款方式按照项目
	private List<PayWay> listPayWay;
	
	private String mag;
	
	/**
	 * 初始化tab 
	 * */
	public String tabHtml(){
		if(propertyProjectId == 0){
			listPayWay = new ArrayList<PayWay>();
			return "suc";
		}
		PayWayCond cond = new PayWayCond();
		//cond.setBuildId(SessionUser.getProjectId()+"");
		cond.setProjectId(this.propertyProjectId);
		listPayWay = payWayServices.findPayWay(cond);
		for(PayWay ww: listPayWay){
			ww.initPayDeil(payWayDetailServices);
		}
		return "suc";
	}

	/**添加付款方式
	 * propertyProjectId 基于楼栋
     * 2012-11-14
	 * */
	public String dialogPayWay(){
		//接受了一个propertyProjectId 去jsp传递
		return "suc";
	}
	
	private PayWay payWay;

	/**
	 * 新建付款方式表单提交
	 * @return
	 */
	@Deprecated
	public String dialogPayWayForm(){
		if(propertyProjectId == 0){
			mag = "";
			return "suc";
		}
		payWay.setModId(SessionUser.getUserId());
		payWay.setModTime(new Date());
		//payWay.setBuildId(buildId);
		PayWayCond cond = new PayWayCond();
		cond.setProjectId(propertyProjectId);
		List<PayWay> dpw =  payWayServices.findPayWayPage(cond);
		if(dpw != null && dpw.size()>0){
			if(isHaveThisName(payWay.getPayName(),dpw)){
				mag = "名称重复";
				return "suc";
			}
		}
		payWay.setProjectId(propertyProjectId);
		payWay.setCreatedId(SessionUser.getUserId());
		payWay.setCreatedTime(new Date());
		payWay.setIsDeleted("0");
		payWayServices.addPayWay(payWay);
		mag = "添加成功";
		return "suc";
	}
	public String dialogUpdatePayWay(){
		payWay = payWayServices.findPayWayById(wayId);
		return "suc";
	}
	
	@Deprecated
	public String dialogUpdatePayWayForm(){
		PayWay old = payWayServices.findPayWayById(wayId);
		old.setRemark(payWay.getRemark());
		old.setPayName(payWay.getPayName());
		old.setModId(SessionUser.getUserId());
		old.setModTime(new Date());
		payWayServices.updatePayWay(old);
		this.mag = "修改成功";
		return "suc";
	}
	
	/**
	 * easyui新增付款方式
	 * @return
	 * @throws Exception
	 */
	public String inputPayWay() throws Exception{
		
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				PayWayCond cond = new PayWayCond();
				cond.setProjectId(payWay.getProjectId());
				List<PayWay> oldPayWayList =  payWayServices.findPayWayPage(cond);
				
				if(!CommonUtils.isCollectionEmpty(oldPayWayList)){
					
					if(isHaveThisName(payWay.getPayName(),oldPayWayList)){
						
						setUpEasyuiAjaxForFail("名称重复");
						throw new Exception();
					}
				}
				
				CommonPojoUtils.initPojoCommonFiled(payWay);
				payWayServices.addPayWay(payWay);
				
			}
		});
		
		return null;
	}
	
	/**
	 * easyui修改付款方式
	 * @return
	 * @throws Exception
	 */
	public String updatePayWay() throws Exception{
		
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				PayWay oldPayWay = payWayServices.findPayWayById(payWay.getId());
				CommonPojoUtils.initPojoForUpdate(oldPayWay, payWay);
				
				payWay.setBuildId(oldPayWay.getBuildId());
				payWay.setProjectId(oldPayWay.getProjectId());
				payWay.setPayType(oldPayWay.getPayType());
				
				payWayServices.updatePayWay(payWay);
				
			}
		});
		
		return null;
	}
	
	/**
	 * 删除付款方式
	 * 2012-11-12 增加删除要求, 只能删除没有在 confirm 和 contrat 使用过的付款方式
	 * @param pwId 删除的pay way   ID
	 * */
	public String delPayWay() throws Exception{
		
		String out = "删除成功";
		int count1 = 0;
		int count2 = 0;
		
		ConfirmCond cond1 = new ConfirmCond();
		ContractCond cond2 = new ContractCond();
		cond1.setPayWayId(this.wayId);
		cond2.setPayWayId(this.wayId);
		
		count1 = confirmServices.findConfirmCount(cond1);
		count2 = contractServices.findContractCount(cond2);
		
		if(count1 + count2 > 0 ){
			out = "该付款方式已经被使用,不能删除";
		}else{
			try{
				payWayServices.deletePayWay(wayId);
				
			}catch (Exception e) {
				out = "删除失败,请重试";
			}
		}
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}

	/*************************付款方式详细*****************
	 * @param wayId 外键
	 * */
	private int wayId;
	private PayWayDetail payWayDetail;
	private int pwdId;
	
	public String dialogPayWayDetail(){//新建
		
		//selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.SALEUNIT_PAY_TYPE, true);
		selPayType = PayTypeUtils.getPayTypeValueMap();
		
		return "suc";
	}
	private int time;
	private int money;
	private LinkedHashMap selPayType; 
	public String dialogPayWayDetailForm(){//新建提交
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.SALEUNIT_PAY_TYPE, true);
		try {
			CommonPojoUtils.initPojoCommonFiled(payWayDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PayWay temppw = payWayServices.findPayWayById(wayId);
		payWayDetail.setPayName(temppw.getPayName());
		payWayDetail.setWayId(temppw.getId());
		
		
		if(time == 1){
			payWayDetail.setPayDate(null);
		}else{
			payWayDetail.setDayNum(-1);
		}
		if(money == 1){
			payWayDetail.setPayPercent(null);
		}else{
			payWayDetail.setPayMoney(null);
			payWayDetail.setPayPercent(payWayDetail.getPayPercent().divide(new BigDecimal(100)));
		}
		
		//payWayDetail.setTypeName(PayTypeUtils.getPayTypeValueByKey(payBill.getTypeName()));
		//payWayDetail.setPayType(PayTypeUtils.getPayTypeValueByKey(payWayDetail.getPayType()));
		
		payWayDetailServices.addPayWayDetail(payWayDetail);
		
		this.mag = "添加成功";
		return "suc";
	}

	public String dialogUpdatePayWayDetail(){//修改
		payWayDetail = payWayDetailServices.findPayWayDetailById(pwdId);
		return "suc";
	}
	public String dialogUpdatePayWayDetailForm(){//修改提交
		PayWayDetail old = payWayDetailServices.findPayWayDetailById(pwdId);
		
		old.setDetailName(payWayDetail.getDetailName());
		old.setDayNum(payWayDetail.getDayNum());
		old.setBaseMoneyType(payWayDetail.getBaseMoneyType());
		old.setPayMoney(payWayDetail.getPayMoney());
		old.setPayPercent(payWayDetail.getPayPercent());
		old.setModNum(payWayDetail.getModNum());
		old.setIsInclude(payWayDetail.getIsInclude());
		old.setRemark(payWayDetail.getRemark());
		
		old.setModId(SessionUser.getUserId());
		old.setModTime(new Date());
		payWayDetailServices.updatePayWayDetail(old);
		this.mag = "修改成功";
		return "suc";
	}
	
	
	public String delPayWayDetail() throws Exception{//删除
		
		String out = "删除成功";
			try{
				payWayDetailServices.deletePayWayDetail(pwdId);
			}catch (Exception e) {
				out = "删除失败,请重试";
			}
		CustomerUtils.writeResponse(response, out);
		return null;
	}
	
	/**付款方式明细*******************************end****/
	
	
	/**复制付款方式  type=1 增加  2 覆盖*/
	private String copyType;
	private List<PropertyBuild> buildList;
	private int copyBuildId;//复制到那个build
	
	/**
	 * 弹出复制付款方式界面
	 * 
	 * */
	public String dialogCopyPayWay(){
		initByCopy();
		return "suc";
	}
	
	/**
	 * 提交复制
	 * 需要根据复制的类型看是否需要删除目标build原来拥有的付款方式
	 * 
	 * */
	public String dialogCopyPayWayForm(){
		if(copyType .equals("2")){//1 根据type判断是否删除原有的付款方式
			PayWayCond pwcd = new PayWayCond();
			pwcd.setBuildId(this.copyBuildId);
			List<PayWay> pwld = this.payWayServices.findPayWay(pwcd);
			
			for(PayWay delp : pwld){
				payWayServices.deletePayWay(delp.getId());
			}
		}
		//2 得到付款方式list
		PayWayCond pwc1 = new PayWayCond();
        pwc1.setProjectId(this.propertyProjectId);
        List<PayWay> pwl1 = this.payWayServices.findPayWay(pwc1);

		//3循环复制
		for(PayWay fpw: pwl1){
			int owid = fpw.getId();
			//fpw.setBuildId(this.copyBuildId);
			this.payWayServices.addPayWay(fpw);
			
			copyPayWayDetail(owid,fpw.getId());
		}
		this.mag = "复制付款方式.操作成功";
		return dialogCopyPayWay();
	}
	
	private int copyPayWayDetail(int p1,int p2){
		int i = 0;
		List<PayWayDetail> dlist = this.payWayDetailServices.findPayWayDetailByWayId(p1);
		
		for(PayWayDetail fpwd : dlist){
			fpwd.setWayId(p2);
			payWayDetailServices.addPayWayDetail(fpwd);
			i++;
		}
		return i;
	}

    @Deprecated
	private void initByCopy(){
		PropertyBuild b1 = this.propertyBuildServices.findPropertyBuildById(this.propertyProjectId);
		PropertyBuildCond bc1 = new PropertyBuildCond();
		bc1.setAreaId(b1.getAreaId()+"");
		this.buildList = this.propertyBuildServices.findPropertyBuild(bc1);
		for(PropertyBuild itb:this.buildList){
			if(itb.getId() == this.propertyProjectId){
				buildList.remove(itb);
				break;
			}
		}
	}
	/**复制付款方式 end*/
	
	private boolean isHaveThisName(String name,List<PayWay> pwl){
		for(PayWay pw : pwl){
			if(pw.getPayName().equals(name)){
				return true;
			}
		}
		return false;
	}
	
	public PayWay getPayWay() {
		return payWay;
	}

	public void setPayWay(PayWay payWay) {
		this.payWay = payWay;
	}



	public List<PayWay> getListPayWay() {
		return listPayWay;
	}

	public void setListPayWay(List<PayWay> listPayWay) {
		this.listPayWay = listPayWay;
	}

	public String getMag() {
		return mag;
	}

	public void setMag(String mag) {
		this.mag = mag;
	}

	public int getWayId() {
		return wayId;
	}

	public void setWayId(int wayId) {
		this.wayId = wayId;
	}

	public PayWayDetail getPayWayDetail() {
		return payWayDetail;
	}

	public void setPayWayDetail(PayWayDetail payWayDetail) {
		this.payWayDetail = payWayDetail;
	}

	public int getPwdId() {
		return pwdId;
	}

	public void setPwdId(int pwdId) {
		this.pwdId = pwdId;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public LinkedHashMap getSelPayType() {
		return selPayType;
	}

	public void setSelPayType(LinkedHashMap selPayType) {
		this.selPayType = selPayType;
	}

	public String getCopyType() {
		return copyType;
	}

	public void setCopyType(String copyType) {
		this.copyType = copyType;
	}

	public List<PropertyBuild> getBuildList() {
		return buildList;
	}

	public void setBuildList(List<PropertyBuild> buildList) {
		this.buildList = buildList;
	}

	public int getCopyBuildId() {
		return copyBuildId;
	}

	public void setCopyBuildId(int copyBuildId) {
		this.copyBuildId = copyBuildId;
	}

    public int getPropertyProjectId() {
        return propertyProjectId;
    }

    public void setPropertyProjectId(int propertyProjectId) {
        this.propertyProjectId = propertyProjectId;
    }
}
