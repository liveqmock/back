package com.ihk.saleunit.action.new_report;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IReportDefineColumnServices;
import com.ihk.saleunit.data.services.IReportDefineTypeServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;

/**
 * 报表:总体货量分析
 * 没有采用sql语句进行提取数据（原因是直接与销售货量分析_按楼层这样的保持一致）
 *
 */
public class ZthlfxReportAction extends SupperAction {


	@Autowired
	IPropertyUnitServices propertyUnitServices;
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractServices contractServices;
	@Autowired
	IReportDefineTypeServices reportDefineTypeServices;
	@Autowired
	IReportDefineColumnServices reportDefineColumnServices;

	/**
	 * 总货量_总套数
	 */
	private BigDecimal zhl_zts=BigDecimal.valueOf(0);//总货量_总套数
	
	/**
	 * 总货量_总面积
	 */
	private BigDecimal zhl_zmj=BigDecimal.valueOf(0);//总货量_总面积
	
	/**
	 * 总货量_总金额（定价）
	 */
	private BigDecimal zhl_zje=BigDecimal.valueOf(0);//总货量_总金额（定价）

	
	/**
	 * 推出货量_总套数
	 */
	private BigDecimal tchl_zts=BigDecimal.valueOf(0);//推出货量_总套数
	
	/**
	 * 推出货量_总面积
	 */
	private BigDecimal tchl_zmj=BigDecimal.valueOf(0);//推出货量_总面积
	
	/**
	 * 推出货量_总金额（定价）
	 */
	private BigDecimal tchl_zje=BigDecimal.valueOf(0);//推出货量_总金额（定价）

	/**
	 * 总剩余货量_总套数
	 */
	private BigDecimal zsyhl_zts=BigDecimal.valueOf(0);//总剩余货量_总套数
	
	/**
	 * 总剩余货量_总面积
	 */
	private BigDecimal zsyhl_zmj=BigDecimal.valueOf(0);//总剩余货量_总面积
	
	/**
	 * 总剩余货量_总金额（定价）
	 */
	private BigDecimal zsyhl_zje=BigDecimal.valueOf(0);//总剩余货量_总金额（定价）

	/**
	 * 认购情况_成交套数
	 */
	private BigDecimal rgqk_cjts=BigDecimal.valueOf(0);//认购情况_成交套数
	
	/**
	 * 认购情况_成交面积
	 */
	private BigDecimal rgqk_cjmj=BigDecimal.valueOf(0);//认购情况_成交面积
	
	/**
	 * 认购情况_成交金额
	 */
	private BigDecimal rgqk_cjje=BigDecimal.valueOf(0);//认购情况_成交金额

	/**
	 * 已签约情况_签约套数
	 */
	private BigDecimal yqyqk_qyts=BigDecimal.valueOf(0);//已签约情况_签约套数
	
	/**
	 * 已签约情况_签约面积
	 */
	private BigDecimal yqyqk_qymj=BigDecimal.valueOf(0);//已签约情况_签约面积
	
	/**
	 * 已签约情况_签约金额
	 */
	private BigDecimal yqyqk_qyje=BigDecimal.valueOf(0);//已签约情况_签约金额

	
	/**
	 * 未签约情况_未签约套数
	 */
	private BigDecimal wqyqk_wqyts=BigDecimal.valueOf(0);//未签约情况_未签约套数
	
	/**
	 * 未签约情况_未签约面积
	 */
	private BigDecimal wqyqk_wqymj=BigDecimal.valueOf(0);//未签约情况_未签约面积
	
	/**
	 * 未签约情况_未签约金额
	 */
	private BigDecimal wqyqk_wqyje=BigDecimal.valueOf(0);//未签约情况_未签约金额
	
	/**
	 * 未签约情况_均价
	 */
	private BigDecimal wqyqk_jj=BigDecimal.valueOf(0);//未签约情况_均价

	
	/**
	 * 推出剩余货量_总量
	 */
	private BigDecimal tcsyhl_zl=BigDecimal.valueOf(0);//推出剩余货量_总量
	
	/**
	 * 推出剩余货量_面积
	 */
	private BigDecimal tcsyhl_mj=BigDecimal.valueOf(0);//推出剩余货量_面积
	
	/**
	 * 推出剩余货量_金额
	 */
	private BigDecimal tcsyhl_je=BigDecimal.valueOf(0);//推出剩余货量_金额
	
	/**
	 * 推出剩余货量_均价
	 */
	private BigDecimal tcsyhl_jj=BigDecimal.valueOf(0);//推出剩余货量_均价
	
	/**
	 * 推出剩余货量_剩余率
	 */
	private BigDecimal tcsyhl_syl=BigDecimal.valueOf(0);//推出剩余货量_剩余率

	/*
	 * 数据表的准备
	 * 1,所有单元信息；（单元表）:property_unit
	 * 2，认购表的取得；confirm
	 * 3，合同表:contract
	 * 
	 * 在以上表格中进行重新组装得到数据
	 */
	

	/**
	 * 执行报表处理
	 */
	public String runReport() {		
		List<PropertyUnit> listUnit = propertyUnitServices.findPropertyUnit(propertyUnitCond);
		List<Confirm> listConfirm = confirmServices.findConfirm(new ConfirmCond());
		List<Contract> listContract = contractServices.findContractPage(new ContractCond());
				
		//重新初始化listUnit
		ReportShowUtils.initListPropertyUnit_Confirm(listUnit,listConfirm);
		ReportShowUtils.initListPropertyUnit_Contract(listUnit,listContract);
						
			
		//对单元进行循环,然后对页面对应的值进行填充
		for(int i=0;i<listUnit.size();i++){
			PropertyUnit unit = listUnit.get(i);
			zhl_zts=ReportShowUtils.addNumber(zhl_zts,BigDecimal.valueOf(1));//总货量_总套数
			zhl_zmj=ReportShowUtils.addNumber(zhl_zmj,unit.getBuildArea());//总货量_总面积
			zhl_zje=ReportShowUtils.addNumber(zhl_zje,unit.getSumPrice());//总货量_总金额（定价）
			
			//以sale_state(销售状态)来判断
			if(unit.isTuiHuo()){
				tchl_zts=ReportShowUtils.addNumber(tchl_zts,BigDecimal.valueOf(1));//推出货量_总套数
				tchl_zmj=ReportShowUtils.addNumber(tchl_zmj,unit.getBuildArea());//推出货量_总面积
				tchl_zje=ReportShowUtils.addNumber(tchl_zje,unit.getSumPrice());//推出货量_总金额（定价）
			}

			//以sale_state(销售状态)来判断
			if(unit.getConfirm() == null){
				zsyhl_zts=ReportShowUtils.addNumber(zsyhl_zts,BigDecimal.valueOf(1));//总剩余货量_总套数
				zsyhl_zmj=ReportShowUtils.addNumber(zsyhl_zmj,unit.getBuildArea());//总剩余货量_总面积
				zsyhl_zje=ReportShowUtils.addNumber(zsyhl_zje,unit.getSumPrice());//总剩余货量_总金额（定价）
			}

			if(unit.getConfirm()!=null){
				rgqk_cjts=ReportShowUtils.addNumber(rgqk_cjts,BigDecimal.valueOf(1));//认购情况_成交套数
				rgqk_cjmj=ReportShowUtils.addNumber(rgqk_cjmj,unit.getBuildArea());;//认购情况_成交面积
				rgqk_cjje=ReportShowUtils.addNumber(rgqk_cjje,unit.getConfirm().getSumMoney());//认购情况_成交金额
			}

			if(unit.getContract()!=null){
				yqyqk_qyts=ReportShowUtils.addNumber(yqyqk_qyts,BigDecimal.valueOf(1));//已签约情况_签约套数
				yqyqk_qymj=ReportShowUtils.addNumber(yqyqk_qymj,unit.getBuildArea());//已签约情况_签约面积
				yqyqk_qyje=ReportShowUtils.addNumber(yqyqk_qyje,unit.getContract().getSumMoney());//已签约情况_签约金额
			}
		}
		
		System.out.println("输出总体货量分析完毕:"+DateTimeUtils.getNow());
		
		return "suc";
	}	

	public String zthlfxReportFirst() throws Exception{
		
		initSearchDate();
		
		return "zthlfxReportFirst";
	}
	
	/**
	 * 总体货量分析
	 * @return
	 */
	public String zthlfxReport() {
		initSearchDate();
		runReport();
		return "suc";
	}
	
	private List list = new ArrayList();
	
	

	public List getList() {
		return list;
	}



	public void setList(List list) {
		this.list = list;
	}

	private String showTrs;
	public String getShowTrs(){
		return showTrs;
	}
	
	public void setShowTrs(String showTrs){
		this.showTrs = showTrs;
	}

	
	
	private void initSearchDate(){		
		if (propertyUnitCond == null) {
			propertyUnitCond = new PropertyUnitCond();

			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));		
			propertyUnitCond.setSearchCompanyProjectIds(propertyUnitCond.getPrivCompanyProjectIds());
			
//			propertyUnitCond.setDate1(CommonUtils.getMonthFirstForString());
			propertyUnitCond.setDate2(CommonUtils.getOneDayBeforeForString(new Date()));
		}
		else if(propertyUnitCond.getPrivCompanyProjectIds()==null){
			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));	
		}
		
		
	}
	
	private PropertyUnitCond propertyUnitCond;
	private String projectName;
	

	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}

	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	//总货量_总套数
	public String getZhl_zts() {
		return zhl_zts.toString();
	}

	//总货量_总面积
	public String getZhl_zmj() {
		return zhl_zmj.toString();
	}

	//总货量_总金额（定价）
	public String getZhl_zje() {
		return zhl_zje.divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)).toPlainString().toString();
	}

	//总货量_均价
	public String getZhl_jj() {
		return ReportShowUtils.divideNumber(zhl_zje, zhl_zmj).toString();
	}

	//推出货量_总套数
	public String getTchl_zts() {
		return tchl_zts.toString();
	}

	//推出货量_总面积
	public String getTchl_zmj() {
		return tchl_zmj.toString();
	}

	//推出货量_总金额（定价）
	public String getTchl_zje() {
		return tchl_zje.divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)).toPlainString().toString();
	}

	//推出货量_均价
	public String getTchl_jj() {
		return ReportShowUtils.divideNumber(tchl_zje, tchl_zmj).toString();
	}

	//总剩余货量_总套数
	public String getZsyhl_zts() {
		return zsyhl_zts.toString();
	}

	//总剩余货量_总面积
	public String getZsyhl_zmj() {
		return zsyhl_zmj.toString();
	}

	//总剩余货量_总金额（定价）
	public String getZsyhl_zje() {
		return zsyhl_zje.divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)).toPlainString().toString();
	}

	//总剩余货量_均价
	public String getZsyhl_jj() {
		return ReportShowUtils.divideNumber(zsyhl_zje, zsyhl_zmj).toString();
	}

	//总剩余货量_余货比例
	public String getZsyhl_yhbl() {
		return ReportShowUtils.divideNumberPercent(zsyhl_zts, tchl_zts).toString();
	}

	//认购情况_成交套数
	public String getRgqk_cjts() {
		return rgqk_cjts.toString();
	}

	//认购情况_成交面积
	public String getRgqk_cjmj() {
		return rgqk_cjmj.toString();
	}

	//认购情况_成交金额
	public String getRgqk_cjje() {
		return rgqk_cjje.divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)).toPlainString().toString();
	}

	//认购情况_均价
	public String getRgqk_jj() {
		return ReportShowUtils.divideNumber(rgqk_cjje, rgqk_cjmj).toString();
	}

	//已签约情况_签约套数
	public String getYqyqk_qyts() {
		return yqyqk_qyts.toString();
	}

	//已签约情况_签约面积
	public String getYqyqk_qymj() {
		return yqyqk_qymj.toString();
	}

	//已签约情况_签约金额
	public String getYqyqk_qyje() {
		return yqyqk_qyje.divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)).toPlainString().toString();
	}

	//已签约情况_均价
	public String getYqyqk_jj() {
		return ReportShowUtils.divideNumber(yqyqk_qyje, yqyqk_qymj).toPlainString().toString();
	}

	//已签约情况_签约率
	public String getYqyqk_qyl() {
		return ReportShowUtils.divideNumberPercent(yqyqk_qyts, rgqk_cjts).toString();
	}

	//未签约情况_未签约套数
	public String getWqyqk_wqyts() {
		wqyqk_wqyts = ReportShowUtils.subtractNumber(rgqk_cjts,yqyqk_qyts); 
		return wqyqk_wqyts.toString();
	}

	//未签约情况_未签约面积
	public String getWqyqk_wqymj() {
		wqyqk_wqymj = ReportShowUtils.subtractNumber(rgqk_cjmj,yqyqk_qymj); 
		return wqyqk_wqymj.toString();
	}

	//未签约情况_未签约金额
	public String getWqyqk_wqyje() {
		wqyqk_wqyje = ReportShowUtils.subtractNumber(rgqk_cjje,yqyqk_qyje);
		return wqyqk_wqyje.divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)).toPlainString().toString();
	}

	//未签约情况_均价
	public String getWqyqk_jj() {
		return ReportShowUtils.divideNumber(wqyqk_wqyje, wqyqk_wqymj).toPlainString().toString();
	}

	//推出剩余货量_总量
	public String getTcsyhl_zl() {
		tcsyhl_zl = ReportShowUtils.subtractNumber(tchl_zts,rgqk_cjts);
		return tcsyhl_zl.toString();
	}

	//推出剩余货量_面积
	public String getTcsyhl_mj() {
		tcsyhl_mj = ReportShowUtils.subtractNumber(tchl_zmj,rgqk_cjmj);
		return tcsyhl_mj.toString();
	}

	//推出剩余货量_金额
	public String getTcsyhl_je() {
		tcsyhl_je = ReportShowUtils.subtractNumber(tchl_zje,rgqk_cjje);
		return tcsyhl_je.divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)).toPlainString().toString();
	}

	//推出剩余货量_均价
	public String getTcsyhl_jj() {
		return ReportShowUtils.divideNumber(tcsyhl_je, tcsyhl_mj).toPlainString().toString();
	}

	//推出剩余货量_剩余率
	public String getTcsyhl_syl() {
		return ReportShowUtils.divideNumberPercent(tcsyhl_zl, tchl_zts).toString();
	}
	
}
