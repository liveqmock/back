package com.ihk.customer.action;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ReportDefineColumn;
import com.ihk.saleunit.data.pojo.ReportDefineColumnCond;
import com.ihk.saleunit.data.pojo.ReportShowTD;
import com.ihk.saleunit.data.pojo.ReportShowTR;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IReportDefineColumnServices;
import com.ihk.saleunit.data.services.IReportDefineTypeServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.report.ReportTableUtils;
import com.ihk.utils.saleunit.ReportShowUtils;


/**
 * 成交数据交叉分析
 * 性能暂不考虑，如果性能有问题，做成定时器来实施
 * 
 * 报表算法：
 * 1,x,y轴坐标都是自动生成的；
 * 2,分析内容1与分析内容2的下拉框，都写在数据库报表的定义中；
 * 3，取出所有源数据，对目标表格进行填充
 * 4，显示表格
 */
public class CjsjjcReportAction extends SupperAction {

	private static final long serialVersionUID = 1L;

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
	
	public String cjsjjcReportFirst() throws Exception{
		
		initSearchDate();
		
		return "cjsjjcReportFirst";
	}
	
	public String cjsjjcReport() throws Exception{
		
		initSearchDate();
		
		List<PropertyUnit> listUnit = propertyUnitServices.findConfirmUnit(propertyUnitCond);
				
		//List<PropertyUnit> listUnit = propertyUnitServices.findPropertyUnit(propertyUnitCond);
		//List<Confirm> listConfirm = confirmServices.findConfirm(null);
		//List<Contract> listContract = contractServices.findContractPage(new ContractCond());
		
		if(CommonUtils.isCollectionEmpty(listUnit)){
			
			String emptyStr = "<tr bgcolor='#FFFFFF' onMouseOver=\"this.style.backgroundColor='#f1f9fe'\" onMouseOut=\"this.style.backgroundColor=''\">" +
					"<td>无符合数据</td></tr>";
			
			setShowTrs(emptyStr);
			
			return "success";
		}
				
		//报表Y轴,(show_name,type_name)
		ReportDefineColumnCond condYColumn = new ReportDefineColumnCond();
		condYColumn.setReportName(getSelCategory1());
		//List<ReportDefineColumn> listReportDefineYColumn = reportDefineColumnServices.findReportDefineColumnForY(condYColumn);
		List<ReportDefineColumn> listReportDefineYColumn = ReportTableUtils.initReportDefineColumnList(propertyUnitCond, condYColumn);
		
		//报表X轴
		ReportDefineColumnCond condXColumn = new ReportDefineColumnCond();
		condXColumn.setReportName(getSelCategory2());
		List<ReportDefineColumn> listReportDefineXColumn = reportDefineColumnServices.findReportDefineColumnForY(condXColumn);	
		
		//分析内容3形成的x轴
		ReportDefineColumnCond condXColumn2 = new ReportDefineColumnCond();
		condXColumn2.setReportName(getSelCategory3());
		List<ReportDefineColumn> listReportDefineXColumn2 = reportDefineColumnServices.findReportDefineColumnForY(condXColumn2);	
									
		//步骤1：进行List的定义，直接对应于html页面的Table		
		ArrayList<ReportShowTR> trList = new ArrayList<ReportShowTR>();
		
		//列出X轴表头
		//统计内容的列也一并生成
		ReportShowTR showTH1 = new ReportShowTR(" ");
		ReportShowTR showTH2 = new ReportShowTR(" ");
		ReportShowTR showTH3 = new ReportShowTR(" ");
		
		int countType = getSelCountType().length;		

		String tdYTitle = getListSelCategory1().get(getSelCategory1());//左上角的中文
		showTH1.addTD(new ReportShowTD(tdYTitle));
		showTH2.addTD(new ReportShowTD(tdYTitle));
		showTH3.addTD(new ReportShowTD(tdYTitle));
		
		//表头标题
		for(int i=0;i<listReportDefineXColumn.size();i++){
			if(listReportDefineXColumn2.size()>0){
				for(int j=0;j<listReportDefineXColumn2.size();j++){
					for(int k=0;k<countType;k++){
						ReportShowTD td1 = new ReportShowTD();
						td1.setxTypeName(listReportDefineXColumn.get(i).getShowName());
						td1.setyShowName(listReportDefineXColumn.get(i).getShowName());
						td1.setXyValueText(listReportDefineXColumn.get(i).getShowName());
						showTH1.addTD(td1);
						
						ReportShowTD td2 = new ReportShowTD();
						td2.setxTypeName(listReportDefineXColumn2.get(j).getShowName());
						td2.setyShowName(listReportDefineXColumn2.get(j).getShowName());
						td2.setXyValueText(listReportDefineXColumn2.get(j).getShowName());
						td2.setxTheadText(listReportDefineXColumn2.get(j).getShowName()+"_"+getSelCountType()[k]); //在computeTdByUnit()中使用
						showTH2.addTD(td2);

						ReportShowTD td3 = new ReportShowTD();
						td3.setxTypeName(getSelCountType()[k]);
						td3.setyShowName(getSelCountType()[k]);
						td3.setXyValueText(getSelCountType()[k]);
						td3.setxTheadText(listReportDefineXColumn.get(i).getShowName()+"_"+getSelCountType()[k]); //在computeTdByUnit()中使用
						showTH3.addTD(td3);
					}
				}
			}
			else{
				for(int k=0;k<countType;k++){
					ReportShowTD td1 = new ReportShowTD();
					td1.setxTypeName(listReportDefineXColumn.get(i).getShowName());
					td1.setyShowName(listReportDefineXColumn.get(i).getShowName());
					td1.setXyValueText(listReportDefineXColumn.get(i).getShowName());
					td1.setxTheadText(listReportDefineXColumn.get(i).getShowName()+"_"+getSelCountType()[k]); //在computeTdByUnit()中使用
					showTH1.addTD(td1);

					//
					ReportShowTD td3 = new ReportShowTD();
					td3.setxTypeName(getSelCountType()[k]);
					td3.setyShowName(getSelCountType()[k]);
					td3.setXyValueText(getSelCountType()[k]);
					td3.setxTheadText(listReportDefineXColumn.get(i).getShowName()+"_"+getSelCountType()[k]); //在computeTdByUnit()中使用
					showTH3.addTD(td3);
				}
			}
		}
		trList.add(showTH1);	
		if(showTH2.getTdsCount()>1){
			trList.add(showTH2);				
		}
		trList.add(showTH3);			
		
		//形成表格
		//总货量_总套数
		//列出Y轴循环
		for(int i=0;i<listReportDefineYColumn.size();i++){
			
			ReportDefineColumn yColumn = listReportDefineYColumn.get(i);
			//按此方式，进行扩展，进行一个list的定义			
			ReportShowTR showTR = new ReportShowTR(yColumn.getTypeName());

			ReportShowTD tdY = new ReportShowTD(yColumn.getShowName());
			tdY.setyTypeName(yColumn.getShowName());
			showTR.addTD(tdY);
			
			//列出X轴表头
			for(int j=1;j<showTH3.getTdsCount();j++){
				
				ReportShowTD td = new ReportShowTD();
				
				td.setyShowName(showTH3.getTD(j).getyShowName());
				td.setXyValue(BigDecimal.valueOf(0)); //设置td要显示的默认值
				td.setxTheadText(yColumn.getShowName()+"_"+showTH3.getTD(j).getxTheadText()); //在computeTdByUnit()中使用
				
				showTR.addTD(td);
			}			
						
			trList.add(showTR);
		}

		//遍历单元设置td要显示的值
		for(int i=0;i<listUnit.size();i++){
			PropertyUnit unit = listUnit.get(i);
			
			for(int k=0;k<trList.size();k++){
				
				String yTypeName = trList.get(k).getTD(0).getyTypeName();
				
				if(yTypeName.equalsIgnoreCase(unit.getFloorNum() + "楼") || 
					yTypeName.equalsIgnoreCase(unit.getRoomNo()) || 
					yTypeName.equalsIgnoreCase(unit.getBuildIdLR())){ //
					
					for(int j=0;j<trList.get(k).getTdsCount();j++){
						computeTdByUnit(trList.get(k).getTD(j), unit);
					}
					
				}
				
				/*
				if(trList.get(k).getTD(0).getyTypeName().equalsIgnoreCase(String.valueOf(unit.getFloorNum())+"楼")||
						trList.get(k).getTD(0).getyTypeName().equalsIgnoreCase(unit.getRoomNo())||
						trList.get(k).getTD(0).getyTypeName().equalsIgnoreCase(String.valueOf(unit.getBuildIdLR()))){
					
					for(int j=0;j<trList.get(k).getTdsCount();j++){
						computeTdByUnit(trList.get(k).getTD(j),unit);
					}
				}*/
				
			}
		}

		ReportShowUtils.autoAddAllSumTRToListReportShow(trList,1,2);//总累计
		
		ReportShowUtils.autoFixColSpanVisiable(trList);
		if(showTH2.getTdsCount()>1){
			ReportShowUtils.autoFixColSpanVisiable(trList,1);		
		}
						
		String str = ReportShowUtils.getTrsByListTR(trList);		
		
		setShowTrs(str);//设置输出
		System.out.println("交叉分析完毕:"+DateTimeUtils.getNow());
		
		return "success";
	}
	
	/**
	 * 根据单元设置td要显示的值
	 * @param td
	 * @param unit
	 */
	private void computeTdByUnit(ReportShowTD td,PropertyUnit unit){
		//System.out.println(td.getxTheadText());
		//楼层-建筑面积,(面积四舍五入,再进行比较), [0,100],(100, 150], (150..)
		if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"0-100㎡_套数")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) <= 0&&unit.getBuildArea().compareTo(BigDecimal.valueOf(0)) >=0 ){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"0-100㎡_建筑面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) <= 0&&unit.getBuildArea().compareTo(BigDecimal.valueOf(0)) >=0 ){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"0-100㎡_套内面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) <= 0&&unit.getBuildArea().compareTo(BigDecimal.valueOf(0)) >=0 ){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"0-100㎡_成交总价")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) <= 0&&unit.getBuildArea().compareTo(BigDecimal.valueOf(0)) >=0 ){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"101-150㎡_套数")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) == 1&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) <= 0){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"101-150㎡_建筑面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) == 1&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) <= 0){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"101-150㎡_套内面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) == 1&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) <= 0){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"101-150㎡_成交总价")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) == 1&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) <= 0){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"150㎡以上_套数")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) == 1){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"150㎡以上_建筑面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) == 1){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"150㎡以上_套内面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) == 1){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"150㎡以上_成交总价")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) == 1){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		
		//房号-建筑面积
		if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"0-100㎡_套数")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) <= 0&&unit.getBuildArea().compareTo(BigDecimal.valueOf(0)) >=0 ){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"0-100㎡_建筑面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) <= 0&&unit.getBuildArea().compareTo(BigDecimal.valueOf(0)) >=0 ){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"0-100㎡_套内面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) <= 0&&unit.getBuildArea().compareTo(BigDecimal.valueOf(0)) >=0 ){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"0-100㎡_成交总价")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) <= 0&&unit.getBuildArea().compareTo(BigDecimal.valueOf(0)) >=0 ){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"101-150㎡_套数")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) == 1&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) <= 0){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"101-150㎡_建筑面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) == 1&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) <= 0){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"101-150㎡_套内面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) == 1&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) <= 0){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"101-150㎡_成交总价")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) == 1&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) <= 0){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"150㎡以上_套数")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) == 1){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"150㎡以上_建筑面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) == 1){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"150㎡以上_套内面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) == 1){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"150㎡以上_成交总价")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) == 1){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		
		//楼栋-建筑面积
		if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"0-100㎡_套数")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) <= 0&&unit.getBuildArea().compareTo(BigDecimal.valueOf(0)) >=0 ){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"0-100㎡_建筑面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) <= 0&&unit.getBuildArea().compareTo(BigDecimal.valueOf(0)) >=0 ){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"0-100㎡_套内面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) <= 0&&unit.getBuildArea().compareTo(BigDecimal.valueOf(0)) >=0 ){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"0-100㎡_成交总价")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) <= 0&&unit.getBuildArea().compareTo(BigDecimal.valueOf(0)) >=0 ){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"101-150㎡_套数")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) == 1&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) <= 0){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"101-150㎡_建筑面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) == 1&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) <= 0){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"101-150㎡_套内面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) == 1&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) <= 0){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"101-150㎡_成交总价")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(100)) == 1&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) <= 0){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"150㎡以上_套数")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) == 1){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"150㎡以上_建筑面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) == 1){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"150㎡以上_套内面积")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) == 1){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"150㎡以上_成交总价")){
			if(unit.getBuildArea()!=null&&unit.getBuildArea().compareTo(BigDecimal.valueOf(150)) == 1){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		
		//楼层-装修标准
		if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"毛坯_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"毛坯_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"毛坯_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"毛坯_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"精装修_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"精装修_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"精装修_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"精装修_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//房号-装修标准
		if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"毛坯_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"毛坯_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"毛坯_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"毛坯_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"精装修_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"精装修_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"精装修_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"精装修_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼栋-装修标准
		if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"毛坯_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"毛坯_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"毛坯_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"毛坯_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"精装修_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"精装修_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"精装修_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"精装修_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼层-房间结构
		if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"一房_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"一房_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"一房_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"一房_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"两房两厅_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"两房两厅_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"两房两厅_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"两房两厅_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"三房两厅_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"三房两厅_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"三房两厅_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"三房两厅_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//房号-房间结构
		if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"一房_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"一房_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"一房_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"一房_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"两房两厅_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"两房两厅_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"两房两厅_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"两房两厅_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"三房两厅_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"三房两厅_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"三房两厅_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"三房两厅_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼栋-房间结构
		if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"一房_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"一房_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"一房_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"一房_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"两房两厅_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"两房两厅_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"两房两厅_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"两房两厅_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"三房两厅_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"三房两厅_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"三房两厅_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"三房两厅_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼层-产品类型
		if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"住宅-高层住宅_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"住宅-高层住宅_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"住宅-高层住宅_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"住宅-高层住宅_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"住宅-低层住宅_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"住宅-低层住宅_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"住宅-低层住宅_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"住宅-低层住宅_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"别墅-独栋_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"别墅-独栋_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"别墅-独栋_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"别墅-独栋_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"别墅-联排_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"别墅-联排_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"别墅-联排_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"别墅-联排_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//房号-产品类型
		if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"住宅-高层住宅_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"住宅-高层住宅_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"住宅-高层住宅_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"住宅-高层住宅_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"住宅-低层住宅_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"住宅-低层住宅_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"住宅-低层住宅_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"住宅-低层住宅_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"别墅-独栋_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"别墅-独栋_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"别墅-独栋_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"别墅-独栋_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"别墅-联排_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"别墅-联排_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"别墅-联排_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"别墅-联排_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼栋-产品类型
		if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"住宅-高层住宅_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"住宅-高层住宅_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"住宅-高层住宅_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"住宅-高层住宅_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"住宅-低层住宅_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"住宅-低层住宅_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"住宅-低层住宅_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"住宅-低层住宅_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"别墅-独栋_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"别墅-独栋_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"别墅-独栋_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"别墅-独栋_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"别墅-联排_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"别墅-联排_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"别墅-联排_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"别墅-联排_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼层-朝向
		if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"东_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"东_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"东_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"东_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"南_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"南_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"南_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"南_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"西_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"西_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"西_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"西_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"北_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"北_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"北_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"东西_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"东西_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"东西_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"东西_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"南北_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"南北_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"南北_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"南北_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//房号-朝向
		if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"东_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"东_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"东_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"东_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"南_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"南_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"南_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"南_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"西_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"西_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"西_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"西_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"北_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"北_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"北_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"东西_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"东西_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"东西_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"东西_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"南北_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"南北_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"南北_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"南北_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼栋-朝向
		if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"东_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"东_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"东_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"东_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"南_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"南_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"南_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"南_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"西_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"西_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"西_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"西_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"北_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"北_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"北_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"东西_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"东西_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"东西_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"东西_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"南北_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"南北_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"南北_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"南北_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼层-景观
		if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"园林_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"园林_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"园林_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"园林_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"江景_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"江景_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"江景_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"江景_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//房号-景观
		if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"园林_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"园林_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"园林_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"园林_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"江景_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"江景_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"江景_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"江景_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼栋-景观
		if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"园林_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"园林_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"园林_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"园林_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"江景_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"江景_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"江景_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"江景_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼层-成交总价
		if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"100万以下_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"100万以下_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"100万以下_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"100万以下_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"100-200万_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"100-200万_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"100-200万_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"100-200万_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"200万以上_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"200万以上_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"200万以上_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"200万以上_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//房号-成交总价
		if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"100万以下_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"100万以下_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"100万以下_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"100万以下_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"100-200万_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"100-200万_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"100-200万_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"100-200万_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"200万以上_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"200万以上_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"200万以上_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"200万以上_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼栋-成交总价
		if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"100万以下_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"100万以下_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"100万以下_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"100万以下_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"100-200万_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"100-200万_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"100-200万_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"100-200万_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"200万以上_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"200万以上_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"200万以上_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"200万以上_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼层-付款方式
		if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"一次性_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"一次性_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"一次性_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"一次性_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"分期付款_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"分期付款_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"分期付款_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"分期付款_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"按揭_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"按揭_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"按揭_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"按揭_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"轻松按揭_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"轻松按揭_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"轻松按揭_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"轻松按揭_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"其他_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"其他_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"其他_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getFloorNum()+"楼"+"_"+"其他_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//房号-付款方式
		if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"一次性_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"一次性_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"一次性_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"一次性_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"分期付款_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"分期付款_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"分期付款_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"分期付款_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"按揭_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"按揭_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"按揭_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"按揭_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"轻松按揭_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"轻松按揭_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"轻松按揭_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"轻松按揭_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"其他_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"其他_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"其他_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getRoomNo()+"_"+"其他_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
		//楼栋-付款方式
		if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"一次性_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"一次性_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"一次性_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"一次性_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"分期付款_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"分期付款_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"分期付款_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"分期付款_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"按揭_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"按揭_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"按揭_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"按揭_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"轻松按揭_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"轻松按揭_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"轻松按揭_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"轻松按揭_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"其他_套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"其他_建筑面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"其他_套内面积")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getInsideArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getBuildIdLR()+"_"+"其他_成交总价")){
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		
	}

	public String execute() throws Exception {		 
	  return cjsjjcReport();
	} 

	private String showTrs;
	public String getShowTrs(){
		return showTrs;
	}
	
	public void setShowTrs(String showTrs){
		this.showTrs = showTrs;
	}

	private PropertyUnitCond propertyUnitCond;	

	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}

	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
	}
	
	private void initSearchDate(){
		if (propertyUnitCond == null) {
			propertyUnitCond = new PropertyUnitCond();

			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));		
			propertyUnitCond.setSearchCompanyProjectIds(propertyUnitCond.getPrivCompanyProjectIds());
			
			propertyUnitCond.setDate1(CommonUtils.getMonthFirstForString());
			propertyUnitCond.setDate2(CommonUtils.getMonthEndForString());
		}	
		
		if(selCategory1 == null){
			selCategory1 = "CJSJJC_LC";//默认楼层
		}
		if(selCategory2 == null){
			selCategory2 = "CJSJJC_JZMJ";//建筑面积
		}
		
	}
	
	//下拉框(分析内容1)
	private LinkedHashMap<String, String> listSelCategory1;
	//下拉框(分析内容2)
	private LinkedHashMap<String, String> listSelCategory2;
	//下拉框(分析内容3)
	private LinkedHashMap<String, String> listSelCategory3;

	//选中的统计内容
	private String[] selCountType;
	
	
	//选中的分析内容1
	private String selCategory1;
	private String selCategory2;
	private String selCategory3;
		
	public String getSelCategory1() {
		return selCategory1;
	}

	public void setSelCategory1(String selCategory1) {
		this.selCategory1 = selCategory1;
	}

	public String getSelCategory2() {
		return selCategory2;
	}

	public void setSelCategory2(String selCategory2) {
		this.selCategory2 = selCategory2;
	}

	public String getSelCategory3() {
		return selCategory3;
	}

	public void setSelCategory3(String selCategory3) {
		this.selCategory3 = selCategory3;
	}

		
	/**
	 * 分析内容1的列表
	 * @return
	 */
	public LinkedHashMap<String, String> getListSelCategory1() {
		if(listSelCategory1==null){
			listSelCategory1 = new LinkedHashMap<String, String>();
			
			listSelCategory1.put("CJSJJC_LC","楼层");
			listSelCategory1.put("CJSJJC_FH","房号");
			listSelCategory1.put("CJSJJC_LCx","楼栋");

		}
		return listSelCategory1;
	}

	/**
	 * 分析内容2的列表
	 * @return
	 */
	public LinkedHashMap<String, String> getListSelCategory2() {
		if(listSelCategory2==null){
			listSelCategory2 = new LinkedHashMap<String, String>();

			listSelCategory2.put("CJSJJC_JZMJ","建筑面积");
			listSelCategory2.put("CJSJJC_TNMJ","套内面积");
			listSelCategory2.put("CJSJJC_ZXBZ","装修标准");
			listSelCategory2.put("CJSJJC_FJJG","房间结构");
			listSelCategory2.put("CJSJJC_CPLX","产品类型");
			listSelCategory2.put("CJSJJC_CX","朝向");
			listSelCategory2.put("CJSJJC_JG","景观");
			listSelCategory2.put("CJSJJC_CJZJ","成交总价");
			listSelCategory2.put("CJSJJC_FKFS","付款方式");

		}
		return listSelCategory2;
	}
	

	/**
	 * 分析内容2的列表
	 * @return
	 */
	public LinkedHashMap<String, String> getListSelCategory3() {
		if(listSelCategory3==null){
			listSelCategory3 = new LinkedHashMap<String, String>();

			listSelCategory3.put("","--");
			
			listSelCategory3.put("CJSJJC_JZQY","居住区域");
			listSelCategory3.put("CJSJJC_GZQY","工作区域");
			listSelCategory3.put("CJSJJC_ZYCS","置业次数");
			listSelCategory3.put("CJSJJC_GFYT","购房用途");
			listSelCategory3.put("CJSJJC_KHLY","客户来源");
			listSelCategory3.put("CJSJJC_HY","行业");
			listSelCategory3.put("CJSJJC_JTRS","家庭人数");
			listSelCategory3.put("CJSJJC_NLC","年龄层");
			listSelCategory3.put("CJSJJC_XSRR","销售人员");

		}
		return listSelCategory3;
	}

	/**
	 * 统计内容的列表
	 * checkboxlist(统计内容)用于显示
	 * @return
	 */
	public String[] getListCountType() {
		return new String[]{"套数","建筑面积","套内面积","成交总价"};
	}
	
	public String[] getSelCountType()
    {
		if(selCountType==null){
			selCountType = new String[]{"套数","建筑面积"};
		}
        return selCountType;
    }
    
	public void setSelCountType(String[] selCountType)
    {
        this.selCountType = selCountType;
    }
		
	/*private String roomNoStr(String roomNo){
		String str = String.format("%02d", Integer.parseInt(roomNo));
		return str;
	}
	*/
}
