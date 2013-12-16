package com.ihk.saleunit.action.new_report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumReportShowTDMethod;
import com.ihk.customer.collection.XLSExport;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.pojo.ReportDefineColumn;
import com.ihk.saleunit.data.pojo.ReportDefineColumnCond;
import com.ihk.saleunit.data.pojo.ReportDefineType;
import com.ihk.saleunit.data.pojo.ReportDefineTypeCond;
import com.ihk.saleunit.data.pojo.ReportShowTD;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IReportDefineColumnServices;
import com.ihk.saleunit.data.services.IReportDefineTypeServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;

/**
 * 报表：售前客户统计
 * @author peter.kuang
 *
 */
public class SqkhtjReportAction extends SupperAction {


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

	

	/*
	 * 数据表的准备
	 * 1,所有单元信息；（单元表）:property_unit
	 * 2，认购表的取得；confirm
	 * 3，合同表:contract
	 * 4，报表定义表:report_define_type
	 * 5，报表定义的列:report_define_column
	 * 
	 * 在以上表格中进行重新组装得到数据
	 */
	

	/*
	 * 测试报表的组装
	 */
	public String test() {
		List<PropertyUnit> listUnit = propertyUnitServices.findPropertyUnit(null);
		List<Confirm> listConfirm = confirmServices.findConfirm(null);
		List<Contract> listContract = contractServices.findContractPage(new ContractCond());
		List<ReportDefineType> listReportDefineType = reportDefineTypeServices.findReportDefineType(new ReportDefineTypeCond());
		List<ReportDefineColumn> listReportDefineColumn = reportDefineColumnServices.findReportDefineColumn(new ReportDefineColumnCond());
		
		
		//重新初始化listUnit
		ReportShowUtils.initListPropertyUnit_Confirm(listUnit,listConfirm);
		ReportShowUtils.initListPropertyUnit_Contract(listUnit,listContract);
		
		

		
		
		
		//步骤1：进行List的定义，直接对应于html页面的Table		
		//循环unit,对Map进行填充数据
		ArrayList<ReportShowTD> tdList = new ArrayList();
		
		//形成表格
		//总货量_总套数
		//列出Y轴循环
		for(int i=0;i<listReportDefineType.size();i++){
			//内循环Y轴（子分类）
			for(int j=0;j<listReportDefineColumn.size();j++){
				ReportDefineType yType = listReportDefineType.get(i);
				ReportDefineColumn xColumn = listReportDefineColumn.get(j);
				//ReportShowTD td = ;
				//按此方式，进行推广，进行一个list的定义
//				tdList.add(getTD_现场来访量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_现场来访量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_老客来访量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_老客来访量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//				
//				tdList.add(getTD_外展来访量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_外展来访量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_来电统计量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_来电统计量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//				
//				tdList.add(getTD_房展会来访量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_房展会来访量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_兼职派单量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_兼职派单量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//				
//				tdList.add(getTD_电话回访量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_电话回访量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_活动统计量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_活动统计量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//
//				tdList.add(getTD_电转访量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_电转访量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_陌生拜访量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_陌生拜访量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//			
//				tdList.add(getTD_电话CALL客量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_电话CALL客量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_入会量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_入会量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//			
//				tdList.add(getTD_诚意金量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_诚意金量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_成交量(yType.getId(),xColumn,yType.getTypeName(),i));
//				tdList.add(getTD_成交量_百分比(yType.getId(),xColumn,yType.getTypeName(),i));
			
			}
		}
		
		System.out.println("输出list"+tdList);
		
		//测试：对List快速填充值
//		for(int i=0;i<listUnit.size();i++){
//			PropertyUnit unit = listUnit.get(i);
//			
//			
//			for(int j=0;j<tdList.size();j++){
//				ReportShowTD td = tdList.get(j);	
//				
//				//关键写好内部的计算方式
//				ReportShowUtils.setShowTD(td,unit);				
//			}
//		}
		
		
		//tdList.a
		
		//再次按照构造Map的顺序，来拼凑string进行输出
		
		//不可采用遍历的方式，应该是反向遍历，保证每个原表只是遍历一次，然后填充目标map
//			//一个表格的时间:5s
//			for(int i=1;i<10000;i++){
//				for(int j=0;j<listUnit.size();j++){
//					PropertyUnit u = listUnit.get(j); 
//					if(u.getFloorNum()>2){
//						str = u.getFloorNum()+"b";
//					}
//				}
//			}
//		System.out.println(dt1);
		System.out.println(DateTimeUtils.getNow());
		
		return "suc";
	}
//	
//	private ReportShowTD getTD_现场来访量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("现场来访量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(0);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_现场来访量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(1);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//
//	private ReportShowTD getTD_老客来访量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("老客来访量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(2);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_老客来访量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(3);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//	private ReportShowTD getTD_外展来访量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("外展来访量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(4);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_外展来访量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(5);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//	private ReportShowTD getTD_来电统计量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("来电统计量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(6);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_来电统计量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(7);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}

//	private ReportShowTD getTD_房展会来访量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("房展会来访量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(8);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_房展会来访量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(9);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//	
//	private ReportShowTD getTD_兼职派单量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("兼职派单量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(10);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_兼职派单量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(11);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//	
//	private ReportShowTD getTD_电话回访量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("电话回访量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(12);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_电话回访量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(13);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//	
//	private ReportShowTD getTD_活动统计量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("活动统计量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(14);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_活动统计量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(15);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//	
//	private ReportShowTD getTD_电转访量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("电转访量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(16);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_电转访量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(17);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//	
//	private ReportShowTD getTD_陌生拜访量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("陌生拜访量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(18);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_陌生拜访量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(19);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//	
//	private ReportShowTD getTD_电话CALL客量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("电话CALL客量");
//		td.setyText(yText);
//		
//		td.setxOrderIndex(20);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_电话CALL客量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(21);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//	
//	private ReportShowTD getTD_入会量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("入会量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(22);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_入会量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(23);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//	
//	private ReportShowTD getTD_诚意金量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("诚意金量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(24);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_诚意金量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(25);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//	
//	private ReportShowTD getTD_成交量(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("成交量");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(26);
//		td.setyOrderIndex(yOrderIndex);	
//		return td;
//	}
//
//	private ReportShowTD getTD_成交量_百分比(int idType,ReportDefineColumn xColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+xColumn.getId());
//		td.setxText("百分比");
//		td.setyText(yText);
//		td.setXyMethod(EnumReportShowTDMethod.UNIT_ROOM_TYPE_FLOOR_NUM_COUNT);
//		td.setXyMethodSql(xColumn.getMethodSql());
//		td.setxOrderIndex(27);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
	
	
	
	// 销售货量分析(按楼层)
	public String sqkhtjReport() {
		initSearchDate();
		test();//测试
		return "suc";
	}

	
	
	private void initSearchDate(){
		if (customerCond == null) {
			customerCond = new CustomerCond();
			
			customerCond.setDate1(CommonUtils.getMonthFirstForString());
			customerCond.setDate2(CommonUtils.getMonthEndForString());
		}
		
		
	}

	// 下拉框(分析类型)
	private LinkedHashMap<String, String> listSelCategory;
	private CustomerCond customerCond;
	private String projectName;
	// 选中的分析类型
	private String selCategory;
	

	public LinkedHashMap<String, String> getListSelCategory() {
		if(listSelCategory==null){
			listSelCategory = CustomerUtils.getListSelCategory();
		}
		return listSelCategory;
	}

	public void setListSelCategory(LinkedHashMap<String, String> listSelCategory) {
		this.listSelCategory = listSelCategory;
	}

	public CustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}

	public String getSelCategory() {
		return selCategory;
	}

	public void setSelCategory(String selCategory) {
		this.selCategory = selCategory;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	//文件名参数变量
	private String fileName;
	
	public String getFileName() {
        return fileName;
	}

	public void setFileName(String fileName) {
        this.fileName = fileName;
	}
	
	//从下载文件原始存放路径读取得到文件输出流
	public InputStream getDownloadFile() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try{
			List<List> list = new ArrayList();
			list.addAll((List) request.getSession().getAttribute("tableList"));
			XLSExport.exportListExcel(list).write(baos);
		}catch(Exception e){
			e.printStackTrace();
		}
		byte[] ba = baos.toByteArray();  
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        return bais;
	}
	
	//如果下载文件名为中文，进行字符编码转换
	public String getDownloadChineseFileName() {
	        String downloadChineseFileName = fileName;
	        try {
	                  downloadChineseFileName = new String(downloadChineseFileName.getBytes(),"ISO8859-1");
	        } catch(UnsupportedEncodingException e) {
	                  e.printStackTrace();
	        }
	        return downloadChineseFileName;
	}
	
	/**
	 * 导出
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		return SUCCESS;
	}
	
	
}
