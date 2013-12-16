package com.ihk.setup.base;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumProjectTextType;
import com.ihk.constanttype.EnumRoundingType;
import com.ihk.property.data.pojo.PayWay;
import com.ihk.property.data.pojo.PayWayCond;
import com.ihk.property.data.pojo.PayWayDetail;
import com.ihk.property.data.services.IPayWayDetailServices;
import com.ihk.property.data.services.IPayWayServices;
import com.ihk.utils.ActionMethodModifyUtils;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.common.setup.PayTypeUtils;

/**
 * 绑定到项目的付款方式的设定
 * @author dtc
 * 2013-1-15,下午05:10:50
 */
public class SetPayWayForProjectAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPayWayServices payWayServices;
	@Autowired
	IPayWayDetailServices detailServices;
	
	/**
	 * 根据项目id获取对应的付款方式,并跳转到对应的显示页面
	 * @return
	 * @throws Exception
	 */
	public String payWayList() throws Exception{
		
		PayWayCond cond = new PayWayCond();
		cond.setProjectId(Integer.parseInt(request.getParameter("propertyProjectId")));
		
		payWayList = payWayServices.findPayWay(cond);
		
		return "payWayList";
	}
	
	/**
	 * 跳到增加界面
	 * @return
	 * @throws Exception
	 */
	public String toAddPayWayDetail() throws Exception{
		
		payWayDetail = new PayWayDetail();
		payWayDetail.setTypeName(PayTypeUtils.getPayTypeValueByKey("TEXT_FEE_TYPE_HOUSING_LOAN")); //房款
		payWayDetail.setIsInclude(CommonUtils.TRUE_STR); //是否包含定金
		payWayDetail.setModNum(EnumRoundingType.TEN_THOUSAND.getValue()); //取整方式
		
		init();
		
		return "toAddPayWayDetail";
	}
	
	/**
	 * 增加
	 * @return
	 * @throws Exception
	 */
	public String addPayWayDetail() throws Exception{
		
		return new ActionMethodModifyUtils() {
			
			@Override
			protected void modifyMethod() throws Exception {
				
				CommonPojoUtils.initPojoCommonFiled(payWayDetail);
				detailServices.addPayWayDetail(payWayDetail);
				
			}
		}.doModify(this);
		
	}
	
	/**
	 * 跳到修改明细界面
	 * @return
	 * @throws Exception
	 */
	public String toUpdatePayWayDetail() throws Exception{
		
		payWayDetail = detailServices.findPayWayDetailById(Integer.parseInt(request.getParameter("detailId")));
		
		//判断付款时间及付款金额的单选框哪个为选中状态
		initRadio(payWayDetail);
		init();
		
		return "toUpdatePayWayDetail";
	}
	
	/**
	 * 更新
	 * @return
	 * @throws Exception
	 */
	public String updatePayWayDetail() throws Exception{
		
		return new ActionMethodModifyUtils() {
			
			@Override
			protected void modifyMethod() throws Exception {
				
				PayWayDetail oldDetail = detailServices.findPayWayDetailById(payWayDetail.getId());
				CommonPojoUtils.initPojoForUpdate(oldDetail, payWayDetail);
				
				detailServices.updatePayWayDetail(payWayDetail);
				
			}
		}.doModify(this);
		
	}
	
	/**
	 * 一些初始化
	 */
	private void init(){
		
		selPayType = PayTypeUtils.getPayTypeValueMap();
		selIncludeDeposit = CommonUtils.initSelEmptyAndTrueFalse();
		selRounding = EnumRoundingType.initRoundingTypeMap();
		
		textType = EnumProjectTextType.PAY_WAY.getType();
	}
	
	/**
	 * 设置付款时间及付款金额哪个处于选中状态
	 * @param payWayDetail
	 */
	private void initRadio(PayWayDetail payWayDetail){
		
		Date payDate = payWayDetail.getPayDate();
		
		BigDecimal payPercent = payWayDetail.getPayPercent();
		
		if(payDate != null){
			
			timeRadio = "2";
		}
		
		if(payPercent != null && payPercent.compareTo(new BigDecimal(0)) != 0){
			
			moneyRadio = "2";
			
			JSONObject.fromObject(payPercent);
			JSONObject.toBean(null);
		}
		
	}
	
	////
	private List<PayWay> payWayList;
	
	private PayWayDetail payWayDetail;
	
	/**
	 * 收费类别
	 */
	private LinkedHashMap<String, String> selPayType;
	
	/**
	 * 付款方式
	 */
	private int wayId;
	
	/**
	 * project_text中的text_type
	 */
	private int textType;
	
	/**
	 * 判断付款时间及付款金额哪个处于选中状态
	 */
	private String timeRadio;
	private String moneyRadio;
	
	/**
	 * 是否包含定金
	 */
	private Map<String, String> selIncludeDeposit;
	
	/**
	 * 取整方式
	 */
	private Map<Integer, String> selRounding;
	
	public void setTextType(int textType) {
		this.textType = textType;
	}
	
	public int getTextType() {
		return textType;
	}
	
	public Map<String, String> getSelIncludeDeposit() {
		return selIncludeDeposit;
	}

	public void setSelIncludeDeposit(Map<String, String> selIncludeDeposit) {
		this.selIncludeDeposit = selIncludeDeposit;
	}

	public Map<Integer, String> getSelRounding() {
		return selRounding;
	}

	public void setSelRounding(Map<Integer, String> selRounding) {
		this.selRounding = selRounding;
	}

	public String getTimeRadio() {
		return timeRadio;
	}

	public void setTimeRadio(String timeRadio) {
		this.timeRadio = timeRadio;
	}

	public String getMoneyRadio() {
		return moneyRadio;
	}

	public void setMoneyRadio(String moneyRadio) {
		this.moneyRadio = moneyRadio;
	}

	public void setWayId(int wayId) {
		this.wayId = wayId;
	}
	
	public int getWayId() {
		return wayId;
	}
	
	public void setSelPayType(LinkedHashMap<String, String> selPayType) {
		this.selPayType = selPayType;
	}
	
	public LinkedHashMap<String, String> getSelPayType() {
		return selPayType;
	}
	
	public void setPayWayDetail(PayWayDetail payWayDetail) {
		this.payWayDetail = payWayDetail;
	}
	
	public PayWayDetail getPayWayDetail() {
		return payWayDetail;
	}
	
	public void setPayWayList(List<PayWay> payWayList) {
		this.payWayList = payWayList;
	}
	
	public List<PayWay> getPayWayList() {
		return payWayList;
	}

}
