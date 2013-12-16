package com.ihk.utils.saleunit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihk.constanttype.ContReportColumnMethod;
import com.ihk.constanttype.EnumReportOperator;
import com.ihk.constanttype.EnumReportShowTDMethod;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ReportColumnCond;
import com.ihk.saleunit.data.pojo.ReportDefineColumn;
import com.ihk.saleunit.data.pojo.ReportShowTD;
import com.ihk.saleunit.data.pojo.ReportShowTR;
import com.ihk.utils.html.JsoupUtils;

/**
 * 报表显示的静态方法
 *
 */
public class ReportShowUtils {
//	
	/**
	 * 根据unit 来设置td
	 * @param td
	 * @param unit
	 */
	public static void setShowTD(ReportShowTD td,PropertyUnit unit){
		if(td.getXyMethodSql()==null){
			return;
		}		
		

		//TODO:各种列的取得数据..与EnumReportShowTDMethod对应
//		switch(td.getXyMethod()){
//		case UNIT_ROOM_TYPE_FLOOR_NUM_COUNT:
//			setShowTDByMethod_UNIT_ROOM_TYPE_FLOOR_NUM_COUNT(td,unit);
//			break;
//		case UNIT_BUILD_PRICE_SUM_PRICE:
//			setShowTDByMethod_UNIT_BUILD_PRICE_SUM_PRICE(td,unit);
//			break;	
//		case UNIT_ROOM_NUM_HALL_NUM_TOILET_NUM_HOUSE_TYPE_PAY_WAY_COUNT:
//			setShowTDByMethod_UNIT_ROOM_NUM_HALL_NUM_TOILET_NUM_HOUSE_TYPE_PAY_WAY_COUNT(td,unit);
//			break;
//		case UNIT_COUNT:
//			setShowTDByMethod_UNIT_COUNT(td,unit);
//			break;
//		}
		
	}
//	
//	/**
//	 * 总货量，按价格
//	 * @param td
//	 * @param unit
//	 */
//	public static void setShowTDByMethod_UNIT_BUILD_PRICE_SUM_PRICE(ReportShowTD td,PropertyUnit unit){
//		
//		String xyMethodSql=td.getXyMethodSql();
//		//对语法判断，看unit是否符合价格的范围
//		ReportColumnCond cond = new ReportColumnCond(xyMethodSql);
//		
//		BigDecimal build_sum_price;
//		
//		
//		if(cond.getColumnName().equalsIgnoreCase(ContReportTableColumn.BUILD_PRICE)){
//			build_sum_price=unit.getBuildPrice();
//		}else{
//			//按总价格区分统计
//			build_sum_price=unit.getSumPrice();
//		}
//		//System.out.println("build_sum_price="+build_sum_price+" cond.getColumnName()="+cond.getColumnName());
//		if(build_sum_price==null){
//			build_sum_price = BigDecimal.valueOf(0);
//		}
//		BigDecimal buildArea=unit.getBuildArea();
//		if(unit.getBuildArea()==null){
//			buildArea = BigDecimal.valueOf(0);
//		}
//		BigDecimal sumPrice = unit.getSumPrice();
//		if(unit.getSumPrice()==null){
//			sumPrice = BigDecimal.valueOf(0);
//		}
//		
//		if(td.getxTheadText().equalsIgnoreCase("总货量_总套数")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_Increment(td);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("总货量_总面积")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td, buildArea);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("总货量_总金额")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td, sumPrice);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("总货量_均价")){
//			//todo:后面方法设置
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("推出货量_总套数")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_Increment(td);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("推出货量_总面积")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td, buildArea);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("推出货量_总金额")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td,sumPrice);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("推出货量_均价")){
//			//todo:后面方法设置
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_总套数")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_Increment(td);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_总面积")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td, buildArea);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_总金额")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td, sumPrice);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_均价")){
//			//todo:后面方法设置
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_余货比例")){
//			//todo:后面方法设置
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("认购情况_成交套数")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_Increment(td);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("认购情况_成交面积")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td,buildArea);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("认购情况_成交金额")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td, sumPrice);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("认购情况_均价")){
//			//todo:后面的方法设置
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_签约套数")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_Increment(td);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_签约面积")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td, buildArea);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_签约金额")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td, sumPrice);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_均价")){
//			//todo:后面方法设置
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_签约率")){
//			//todo:后面方法设置
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("未签约情况_未签约套数")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_Increment(td);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("未签约情况_未签约面积")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td, buildArea);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("未签约情况_未签约金额")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td, sumPrice);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("未签约情况_均价")){
//			//todo:后面方法设置
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("推出剩余货量_总量")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_Increment(td);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("推出剩余货量_面积")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td, buildArea);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("推出剩余货量_金额")){
//			if(cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)){
//				if(cond.getColumnValueStartDECIMAL().compareTo(build_sum_price)<0
//						&& cond.getColumnValueEndDECIMAL().compareTo(build_sum_price)>0){
//					ReportShowTD_AddNum(td, sumPrice);
//				}
//			}
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("推出剩余货量_均价")){
//			//todo:后面方法设置
//		}
//		else if(td.getxTheadText().equalsIgnoreCase("推出剩余货量_剩余率")){
//			//todo:后面方法设置
//		}
//	}

//	/**
//	 * 总货量，按类型取得数据
//	 * @param td
//	 * @param unit
//	 */
//	public static void setShowTDByMethod_UNIT_ROOM_TYPE_FLOOR_NUM_COUNT(ReportShowTD td,PropertyUnit unit){
//		List<ReportColumnCond> listCond = getListReportColumnCond_AND(td.getXyMethodSql());			
//		
//		//目前这里写的比较固定，与method_sql的个数顺序一致
//		if(listCond.size()==2){
//			ReportColumnCond condRoomType = listCond.get(0);
//			ReportColumnCond condFloorNum = listCond.get(1);
//			
//			if(checkCond(condRoomType,ContReportTableColumn.ROOM_TYPE,ContReportColumnMethod.EQ,unit.getRoomType())//类型条件
//					&& checkCond(condFloorNum,ContReportTableColumn.FLOOR_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getFloorNum()))){//楼层条件
//				//TODO:具体设置td的算法
//				VerifyShowTD(td,unit);	
//			}
//		
//				
//		}
//	}
	
//	/**
//	 * 总体货量分析
//	 */
//	public static void setShowTDByMethod_UNIT_COUNT(ReportShowTD td,PropertyUnit unit){
//		//TODO:具体设置td的算法
//		VerifyShowTD(td,unit);		
//	}
	
//	/**
//	 * ---------------------------
//	 * 分类，按类型取得数据
//	 * @param td
//	 * @param unit
//	 */
//	public static void setShowTDByMethod_UNIT_ROOM_NUM_HALL_NUM_TOILET_NUM_HOUSE_TYPE_PAY_WAY_COUNT(ReportShowTD td,PropertyUnit unit){
//		
//		List<ReportColumnCond> listCond = getListReportColumnCond_AND(td.getXyMethodSql());	
//		
//		if(listCond.size()==1){
//			ReportColumnCond condRoomNum = listCond.get(0);
//
//			if(td.getyTypeName().equals("规格")){
//				if(checkCond(condRoomNum,ContReportTableColumn.ROOM_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getRoomNum()))){
//					//TODO:具体设置td的算法
//					VerifyShowTD(td,unit);				
//				}	
//			}
//			if(td.getyTypeName().equals("户型")){
//				if(checkCond(condRoomNum,ContReportTableColumn.HOUSE_TYPE,ContReportColumnMethod.EQ,unit.getHouseType())){
//					//TODO:具体设置td的算法---小复A，小复B，小复C，数据库字段HOUSE_TYPE的长度为char(2)
//					
//					VerifyShowTD(td,unit);					
//				}	
//			}
//			if(td.getyTypeName().equals("付款方式")){
//				if(checkCond(condRoomNum,ContReportTableColumn.PAY_WAY_ID,ContReportColumnMethod.EQ,String.valueOf(unit.getPriceWay()))){
//					//TODO:具体设置td的算法
//										
//				}
//			}
//					
//		}else if(listCond.size()==2){
//			ReportColumnCond condRoomNum = listCond.get(0);
//			ReportColumnCond condToiletNum = listCond.get(1);
//			if(checkCond(condRoomNum,ContReportTableColumn.ROOM_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getRoomNum()))
//					&& checkCond(condToiletNum,ContReportTableColumn.TOILET_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getToiletNum()))){
//				//TODO:具体设置td的算法
//				VerifyShowTD(td,unit);					
//			}	
//		}else{
//			ReportColumnCond condRoomNum = listCond.get(0);
//			ReportColumnCond condHallNum = listCond.get(1);
//			ReportColumnCond condToiletNum = listCond.get(2);
//			if(checkCond(condRoomNum,ContReportTableColumn.ROOM_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getRoomNum()))
//					&& checkCond(condHallNum,ContReportTableColumn.HALL_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getHallNum()))
//					&& checkCond(condToiletNum,ContReportTableColumn.TOILET_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getToiletNum()))){//楼层条件
//				//TODO:具体设置td的算法
//				VerifyShowTD(td,unit);				
//			}				
//		}
//		
//	}
	
	
	
	/**
	 * 得到list的and数据
	 * @param xyMethodSql
	 * @return
	 */
	public static List<ReportColumnCond> getListReportColumnCond_AND(String xyMethodSql){
		List<ReportColumnCond> listCond = new ArrayList<ReportColumnCond>();//td.getXyMethodSql()
		
		for(String strCond:xyMethodSql.split("\\"+ContReportColumnMethod.AND)){
			ReportColumnCond cond = new ReportColumnCond(strCond);
			listCond.add(cond);
		}
		
		return listCond;
	}
	

	/**
	 * 检验条件是否成立，自动能够匹配运算符(等于,大于之类)
	 * @param cond
	 * @param columnName
	 * @param dbObjectValue
	 * @return
	 */
	public static boolean checkCond(ReportColumnCond cond,String columnName,String dbObjectValue){
		return checkCond(cond,columnName,cond.getCompareMethod(),dbObjectValue);
	}

	//检验条件是否成立
	public static boolean checkCond(ReportColumnCond cond,String columnName,String columnMethod,String dbObjectValue){
		if(columnMethod.equalsIgnoreCase( ContReportColumnMethod.EQ)){
			return checkCond_EQ(cond,columnName,dbObjectValue);
		}
		else if(columnMethod.equalsIgnoreCase( ContReportColumnMethod.GT)){
			return checkCond_GT(cond,columnName,dbObjectValue);
		}
		else if(columnMethod.equalsIgnoreCase( ContReportColumnMethod.IN)){
			return checkCond_IN(cond,columnName,dbObjectValue);
		}
		
		return false;
	}

	//需要把各个方法写一遍
	//private static boolean checkCond_IN(ReportColumnCond cond,String columnName,String columnMethod,String dbObjectValue){

	/**
	 * 检查是否等于
	 */
	private static boolean checkCond_EQ(ReportColumnCond cond,String columnName,String dbObjectValue){
		if(cond.getColumnName().equalsIgnoreCase( columnName)
				&& cond.getColumnValue().equalsIgnoreCase(dbObjectValue)){
			return true;
		}
		return false;
	}

	/**
	 * 检查是否大于
	 */
	private static boolean checkCond_GT(ReportColumnCond cond,String columnName,String dbObjectValue){
		BigDecimal condValue = new BigDecimal(cond.getColumnValue());
		BigDecimal dbValue = new BigDecimal(dbObjectValue);
		if(cond.getColumnName().equalsIgnoreCase( columnName)
				&& dbValue.compareTo(condValue)>0){
			return true;
		}
		return false;
	}

	/**
	 * 检查是否在范围内
	 */
	private static boolean checkCond_IN(ReportColumnCond cond,String columnName,String dbObjectValue){
		BigDecimal condValue1 = cond.getColumnValueStartDECIMAL();
		BigDecimal condValue2 = cond.getColumnValueEndDECIMAL();
		BigDecimal dbValue = new BigDecimal(dbObjectValue);
		if(cond.getColumnName().equalsIgnoreCase( columnName)){
			if(dbValue.compareTo(condValue1)>=0 && dbValue.compareTo(condValue2)<=0){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 初始化unit中的confirm属性
	 * @param listUnit
	 * @param listConfirm
	 */
	public static void initListPropertyUnit_Confirm(List<PropertyUnit> listUnit,List<Confirm> listConfirm){
		//形成一个map，方便取得数据
		Map<Integer,Confirm> map = new HashMap<Integer, Confirm>();//以unitId为key，默认一个unit仅有一个有效的confirm
		for (Confirm confirm : listConfirm) {
            if (map.containsKey(confirm.getUnitId())) {
                //map.put(confirm.getUnitId(),confirm);//可以预留做一些判断
            } else {
                map.put(confirm.getUnitId(),confirm);
            }
        }		
		
		for(int i=0;i<listUnit.size();i++){
			if(map.containsKey(listUnit.get(i).getId())){
				listUnit.get(i).setConfirm(map.get(listUnit.get(i).getId()));
			}
			listUnit.get(i).setInitConfirmContractInfo(true);
		}
	}	

	/**
	 * 初始化unit中的contract属性
	 * @param listUnit
	 * @param listContract
	 */
	public static void initListPropertyUnit_Contract(List<PropertyUnit> listUnit,List<Contract> listContract){
		//形成一个map，方便取得数据
		Map<Integer,Contract> map = new HashMap<Integer, Contract>();//以unitId为key，默认一个unit仅有一个有效的confirm
		for (Contract contract : listContract) {
            if (map.containsKey(contract.getUnitId())) {
                map.put(contract.getUnitId(),contract);//可以预留做一些判断
            } else {
                map.put(contract.getUnitId(),contract);
            }
        }		
		
		for(int i=0;i<listUnit.size();i++){
			if(map.containsKey(listUnit.get(i).getId())){
				listUnit.get(i).setContract(map.get(listUnit.get(i).getId()));
			}
			listUnit.get(i).setInitConfirmContractInfo(true);
		}
	}

	
	/**
	 * 相同一行的表格
	 * xText(对应的td)=xText1/xText2的值
	 * @param tdList
	 * @param xText
	 * @param xText1
	 * @param xText2
	 */
	public static void fixShowTDDivide(List<ReportShowTD> tdList,String xText,String xText1,String xText2){
		
	}

	/**
	 * 相同一行的表格
	 * xText(对应的td)=xText1*xText2的值
	 * @param tdList
	 * @param xText
	 * @param xText1
	 * @param xText2
	 */
	public static void fixShowTDMultiply(List<ReportShowTD> tdList,String xText,String xText1,String xText2){
		
	}

	/**
	 * 相同一行的表格
	 * xText(对应的td)=xText1+xText2的值
	 * @param tdList
	 * @param xText
	 * @param xText1
	 * @param xText2
	 */
	public static void fixShowTDAdd(List<ReportShowTD> tdList,String xText,String xText1,String xText2){
		
	}

	/**
	 * 相同一行的表格
	 * xText(对应的td)=xText1-xText2的值
	 * @param tdList
	 * @param xText
	 * @param xText1
	 * @param xText2
	 */
	public static void fixShowTDSubtract(List<ReportShowTD> tdList,String xText,String xText1,String xText2){
		
	}
	

	/**
	 * 相同一列的表格
	 * xText1,yText(对应的td)=xText累计的值
	 * @param tdList
	 * @param xText
	 * @param xText1
	 * @param xText2
	 */
	public static void fixShowTD_RowsSum(List<ReportShowTD> tdList,String xText,String yText){
		
	}
	
	/**
	 * 得到字符串输出，用于直接显示在jsp页面中
	 * @param tdList
	 * @param trSize
	 * @return
	 */
	public static String getTrsByListTD(ArrayList<ReportShowTD> tdList,int trSize){
		StringBuilder sb = new StringBuilder("");
		sb.append("<tr bgcolor='#FFFFFF'>");
		for(int i=0;i<tdList.size();i++){
//			for(int j=0;j<trSize;j++){
//				//sb.append("<td rowspan='"+tdList.get(i).getRowspan()+"' colspan='"+tdList.get(i).getColspan()+"'>");
//			}
			
			sb.append("<td >");
			sb.append(tdList.get(i).getXyValueText());
			sb.append("</td>");
			
			if((i+1)%trSize==0){
				sb.append("</tr><tr bgcolor='#FFFFFF'>");				
			}
		}
		sb.append("</tr>");
		
		return sb.toString();
	}
	
	/**
	 * 自动修改td里面的rowspan以及visiable
	 * 一般用于第一列type相同,跨行合并显示
	 * @param trList
	 */
	public static void autoFixRowSpanVisiable(ArrayList<ReportShowTR> trList){	
		int rowSpan=1;
		for(int i=0;i<trList.size();i++){
			if(i>0 && trList.get(i-1).getTD(0).getyTypeName().equalsIgnoreCase(trList.get(i).getTD(0).getyTypeName())){
				rowSpan++;
				trList.get(i+1-rowSpan).getTD(0).setRowspan(rowSpan);
				trList.get(i).getTD(0).setVisiable(false);
			}
			else{
				rowSpan=1;
			}
		}		
	}

	/**
	 * 自动修改td里面的colspan以及visiable
	 * 一般用于第一行type相同,跨列合并显示
	 * @param trList
	 */
	public static void autoFixColSpanVisiable(ArrayList<ReportShowTR> trList){	
		autoFixColSpanVisiable(trList,0);	
	}


	/**
	 * 自动修改td里面的colspan以及visiable
	 * 一般用于第一行type相同,跨列合并显示
	 * @param trList
	 * @param rowIndex 第几行
	 */
	public static void autoFixColSpanVisiable(ArrayList<ReportShowTR> trList,int rowIndex){
		int colSpan=1;
		for(int i=0;i<trList.get(rowIndex).getTdsCount();i++){
			System.out.println("trList.get(0).getTD(i).getxTypeName()"+trList.get(0).getTD(i).getxTypeName());
			if(i>0 && trList.get(rowIndex).getTD(i-1).getxTypeName().equalsIgnoreCase(trList.get(rowIndex).getTD(i).getxTypeName()) && trList.get(rowIndex).getTD(i-1).getxTypeName().isEmpty()==false){
				colSpan++;
				trList.get(rowIndex).getTD(i+1-colSpan).setColspan(colSpan);
				trList.get(rowIndex).getTD(i).setVisiable(false);
			}
			else{
				colSpan=1;
			}
		}		
	}

	/**
	 *  得到字符串输出，用于直接显示在jsp页面中
	 * @param trList
	 * @return
	 */
	public static String getTrsByListTR(ArrayList<ReportShowTR> trList){
		
		autoFixRowSpanVisiable(trList);
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<trList.size();i++){
			sb.append("<tr bgcolor='#FFFFFF' onMouseOver=\"this.style.backgroundColor='#f1f9fe'\" onMouseOut=\"this.style.backgroundColor=''\" >");
			for(int j=0;j<trList.get(i).getTdsCount();j++){
				if(trList.get(i).getTD(j).isVisiable()){
					sb.append("<td ");
					if(trList.get(i).getTD(j).getColspan()>1){
						sb.append(" colspan='"+trList.get(i).getTD(j).getColspan()+"' ");					
					}
					if(trList.get(i).getTD(j).getRowspan()>1){
						sb.append(" rowspan='"+trList.get(i).getTD(j).getRowspan()+"' ");					
					}
					sb.append(">");
					sb.append(trList.get(i).getTD(j).getXyValueText()); //此处为td显示的值
					sb.append("</td>");
				}
			}			
			
			sb.append("</tr>");
		}
		
		/*
		 * 为了兼容原先旧的判断,一些要改变的显示的值在返回的String中处理,如:楼栋(id-->中文名)...
		 * dtc,2013.3.14增加
		 */
		String ret = JsoupUtils.cjsjjcReportTable(sb.toString());
		
		return ret;
	}

	/**
	 *  得到字符串输出，用于直接显示在jsp页面中
	 * @param trList
	 * @return
	 */
	public static String getTrsOnlyTdIndexByListTR(ArrayList<ReportShowTR> trList){
		autoFixRowSpanVisiable(trList);
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<trList.size();i++){
			sb.append("<tr bgcolor='#FFFFFF' onMouseOver=\"this.style.backgroundColor='#f1f9fe'\" onMouseOut=\"this.style.backgroundColor=''\" >");
			for(int j=0;j<trList.get(i).getTdsCount();j++){
				if(trList.get(i).getTD(j).isVisiable()){
					sb.append("<td ");
					if(trList.get(i).getTD(j).getColspan()>1){
						sb.append(" colspan='"+trList.get(i).getTD(j).getColspan()+"' ");					
					}
					if(trList.get(i).getTD(j).getRowspan()>1){
						sb.append(" rowspan='"+trList.get(i).getTD(j).getRowspan()+"' ");					
					}
					sb.append(">");
					sb.append(j);//输出顺序
					sb.append("</td>");
				}
			}			
			
			sb.append("</tr>");
		}
		
		return sb.toString();
	}
	

	/**
	 * 初始化要显示的td
	 * @param xColumn
	 * @param theadText
	 * @param tdMethod
	 * @return
	 */
	public static ReportShowTD initShowTD(ReportDefineColumn xColumn,String theadText){
		ReportShowTD td = new ReportShowTD();
		td.setyTypeName(xColumn.getTypeName());
		td.setyShowName(xColumn.getShowName());
		td.setxTheadText(theadText);
		td.setXyMethodSql(xColumn.getMethodSql());
		td.setXyValue(BigDecimal.valueOf(0));
		return td;
	}	

	/**
	 * 初始化要显示的td
	 * @param xColumn
	 * @param theadText
	 * @param tdMethod
	 * @return
	 */
	public static ReportShowTD initShowTD(ReportDefineColumn xColumn,String theadText,String xyValueFormatText){
		ReportShowTD td = new ReportShowTD();
		td.setyTypeName(xColumn.getTypeName());
		td.setyShowName(xColumn.getShowName());
		td.setxTheadText(theadText);
		td.setXyMethodSql(xColumn.getMethodSql());
		td.setXyValueFormatText(xyValueFormatText);
		td.setXyValue(BigDecimal.valueOf(0));
		return td;
	}

	/**
	 * 初始化要显示的td
	 * @param xColumn
	 * @param theadText
	 * @param tdMethod
	 * @return
	 */
	public static ReportShowTD initShowTD(ReportDefineColumn xColumn,String theadText,EnumReportShowTDMethod tdMethod){
		ReportShowTD td = new ReportShowTD();
		td.setyTypeName(xColumn.getTypeName());
		td.setyShowName(xColumn.getShowName());
		td.setxTheadText(theadText);
		td.setXyMethod(tdMethod);
		td.setXyMethodSql(xColumn.getMethodSql());
		return td;
	}
	
	/**
	 * 初始化TR行的数据
	 * @param trList
	 * @param val
	 * @param startTDIndex
	 */
	public static void initListReportShowTR(ArrayList<ReportShowTR> trList,BigDecimal val,int startTDIndex){
		for(int i=0;i<trList.size();i++){
			
			for(int j=startTDIndex;j<trList.get(i).getTdsCount();j++){
				trList.get(i).getTD(j).setXyValue(val);
			}			
		}		
	}

	/**
	 * 自动增加累计行,按typeName进行分组增加
	 * @param trList
	 */
	public static void autoAddSumTRToListReportShow(ArrayList<ReportShowTR> trList){
		int tmpStartCountIndex = 0;//每个分组的开始行
		int tmpNewIndex = 0;	//新增行需要增加的数量
		ReportShowTR tmpTR ;
		Map<Integer,ReportShowTR> sumTRList = new LinkedHashMap<Integer,ReportShowTR>();
		for(int i=0;i<trList.size();i++){
			if((i>0 && trList.get(i).getTypeName().equalsIgnoreCase(trList.get(i-1).getTypeName())==false)
					|| i==trList.size()-1
					){
				tmpTR = new ReportShowTR(trList.get(i-1).getTypeName());
				tmpTR.setTypeSum(true);

				tmpTR.addTD(new ReportShowTD(trList.get(i-1).getTypeName()));
				tmpTR.addTD(new ReportShowTD("累计"));
				for(int j=2;j<trList.get(i).getTdsCount();j++){
					BigDecimal vv = BigDecimal.valueOf(0);
					
					for(int k=tmpStartCountIndex;k<i || (k<i+1 && i==trList.size()-1);k++){
						if(trList.get(k).getTD(j).getXyValue()!=null){
							vv = vv.add(trList.get(k).getTD(j).getXyValue());
						}
					}					
					
					ReportShowTD tmpTD = new ReportShowTD();
					tmpTD.setXyValueFormatText(trList.get(tmpStartCountIndex).getTD(j).getXyValueFormatText());//格式化的样式也和上一行一致
					tmpTD.setXyValue(vv);
					tmpTR.addTD(tmpTD);					
				}
				
				if(i==trList.size()-1){
					tmpNewIndex++;					
				}
				sumTRList.put(i+tmpNewIndex, tmpTR);
				tmpNewIndex++;
				
				tmpStartCountIndex=i;
			}	
		}
		
		for(Map.Entry<Integer, ReportShowTR> entry: sumTRList.entrySet()) {
			trList.add(entry.getKey(), entry.getValue());
		}	
	}
	
	/**
	 * 根据类型，取得比例图的对应SeriesData
	 * @param typeName
	 * @param trList
	 * @param x1
	 * @param x2
	 * @return
	 */
	public static String getChartSeriesDataByType(String typeName,ArrayList<ReportShowTR> trList,int x1,int x2){		
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<trList.size();i++){
			if((i>0 && trList.get(i).getTypeName().equalsIgnoreCase(typeName))){
				if(trList.get(i).getTD(x1).getXyValueText().equalsIgnoreCase("累计")==false){
					sb.append("['"+trList.get(i).getTD(x1).getXyValueText()+"',"+trList.get(i).getTD(x2).getXyValueText()+"]");
					if(i<trList.size()-1 && trList.get(i+1).getTD(x1).getXyValueText().equalsIgnoreCase("累计")==false){
						sb.append(",");
					}
				}
			}	
		}
		
		return sb.toString();
	}

	/**
	 * 没有分类型的情况
	 * @param trList
	 * @param skipXCount 跳过x轴的多少列，可以理解为 第一个总计数字出现在第几个顺序index
	 * @param startYIndex 跳过y轴的多少行，从第几个tr开始算求和
	 */
	public static void autoAddAllSumTRToListReportShow(ArrayList<ReportShowTR> trList,int skipXCount,int startYIndex){
		ReportShowTR tmpTR ;
		tmpTR = new ReportShowTR("总累计");
		tmpTR.setTypeSum(true);

		for(int i=1;i<skipXCount;i++){
			tmpTR.addTD(new ReportShowTD(""));
		}
		tmpTR.addTD(new ReportShowTD("总累计"));
		
		if(trList!=null && trList.size()>0){
			int tdsCount = trList.get(trList.size()-1).getTdsCount();
			for(int j=skipXCount;j<tdsCount;j++){
				BigDecimal vv = BigDecimal.valueOf(0);
				
				for(int k=startYIndex;k<trList.size();k++){
					if(
							trList.get(k).getTD(0).getXyValueText().equals("")==false 
							&& trList.get(k).getTD(1).getXyValueText().equals("累计")==false 
							&& trList.get(k).getTD(j).getXyValue()!=null
							){
						vv = vv.add(trList.get(k).getTD(j).getXyValue());
					}
				}			
				
				ReportShowTD tmpTD = new ReportShowTD();
				tmpTD.setXyValue(vv);
				tmpTR.addTD(tmpTD);					
			}		
		}
		
		trList.add(tmpTR);
	}
	
	/**
	 * 总累计
	 * @param trList
	 */
	public static void autoAddAllSumTRToListReportShow(ArrayList<ReportShowTR> trList){
		autoAddAllSumTRToListReportShow(trList,2,0);		
	}
	

	/**
	 * 自动计算列
	 * TD(resultTDIndex)=TD(factorTDIndex1) [computeMethod] TD(factorTDIndex2)
	 * @param trList
	 * @param resultTDIndex
	 * @param factorTDIndex1
	 * @param factorTDIndex2
	 * @param reportOperator
	 */
	public static void autoComputeListReportShow(ArrayList<ReportShowTR> trList,int resultTDIndex,int factorTDIndex1,int factorTDIndex2,EnumReportOperator reportOperator){
		for(int i=0;i<trList.size();i++){
			if(trList.get(i).getTD(factorTDIndex1)==null||trList.get(i).getTD(factorTDIndex2)==null)
				continue;
			if(trList.get(i).getTD(factorTDIndex1).getXyValue()!=null
			&& trList.get(i).getTD(factorTDIndex2).getXyValue()!=null
			){
				if(reportOperator==EnumReportOperator.ADD){
					trList.get(i).getTD(resultTDIndex).setXyValue(trList.get(i).getTD(factorTDIndex1).getXyValue().add(trList.get(i).getTD(factorTDIndex2).getXyValue()));
				}
				else if(reportOperator==EnumReportOperator.SUBTRACT){
					trList.get(i).getTD(resultTDIndex).setXyValue(trList.get(i).getTD(factorTDIndex1).getXyValue().subtract(trList.get(i).getTD(factorTDIndex2).getXyValue()));
				}
				else if(reportOperator==EnumReportOperator.MULTIPLY){
					trList.get(i).getTD(resultTDIndex).setXyValue(trList.get(i).getTD(factorTDIndex1).getXyValue().multiply(trList.get(i).getTD(factorTDIndex2).getXyValue()));
				}
				else if(reportOperator==EnumReportOperator.DIVIDE){
					if(trList.get(i).getTD(factorTDIndex2).getXyValue().compareTo(BigDecimal.valueOf(0))>0){

						trList.get(i).getTD(resultTDIndex).setXyValue(trList.get(i).getTD(factorTDIndex1).getXyValue().divide(trList.get(i).getTD(factorTDIndex2).getXyValue(), 4, BigDecimal.ROUND_HALF_UP));
					}
					
				}
			}
		}
	}
	

	/**
	 * 自增加1
	 * @param td
	 */
	public static void ReportShowTD_Increment(ReportShowTD td){
		ReportShowTD_AddNum(td,BigDecimal.valueOf(1));
	}

	/** 
	 * 增加数据
	 * @param td
	 * @param number
	 */
	public static void ReportShowTD_AddNum(ReportShowTD td,BigDecimal number){
		td.setXyValue(addNumber(td.getXyValue(),number));
//		if(number.compareTo(BigDecimal.valueOf(0))>0){
//			if(td.getXyValue()!=null){
//				td.setXyValue(td.getXyValue().add(number));
//			}
//			else{
//				td.setXyValue(BigDecimal.valueOf(0));
//				td.setXyValue(td.getXyValue().add(number));
//			}
//		}
		
	}

	/**
	 * 销售货量分析（按楼层）（按分类）判断方法
	 */
	@SuppressWarnings("unused")
	private static void VerifyShowTD(ReportShowTD td,PropertyUnit unit){
		if(td.getxTheadText().equalsIgnoreCase("总货量_总套数")){
			ReportShowTD_Increment(td);
		}else if(td.getxTheadText().equalsIgnoreCase("总货量_总面积")){
			
			ReportShowTD_AddNum(td,unit.getBuildArea()==null?BigDecimal.valueOf(0):unit.getBuildArea());
		}else if(td.getxTheadText().equalsIgnoreCase("总货量_总金额")){
			
			ReportShowTD_AddNum(td,unit.getSumPrice()==null?BigDecimal.valueOf(0):unit.getSumPrice());
		}else if(td.getxTheadText().equalsIgnoreCase("总货量_均价")){
			//todo:后面方法设置
		}
		else if(td.getxTheadText().equalsIgnoreCase("推出货量_总套数")){
			ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase("推出货量_总面积")){
			
			ReportShowTD_AddNum(td,unit.getBuildArea()==null?BigDecimal.valueOf(0):unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase("推出货量_总金额")){
			
			ReportShowTD_AddNum(td,unit.getSumPrice()==null?BigDecimal.valueOf(0):unit.getSumPrice());
		}
		else if(td.getxTheadText().equalsIgnoreCase("推出货量_均价")){
			//todo:后面方法设置
		}
		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_总套数")){
			ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_总面积")){
			
			ReportShowTD_AddNum(td,unit.getBuildArea()==null?BigDecimal.valueOf(0):unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_总金额")){
			
			ReportShowTD_AddNum(td,unit.getSumPrice()==null?BigDecimal.valueOf(0):unit.getSumPrice());
		}
		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_均价")){
			//todo:后面方法设置
		}
		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_余货比例")){
			//todo:后面方法设置
		}
		else if(td.getxTheadText().equalsIgnoreCase("认购情况_成交套数")){
			ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase("认购情况_成交面积")){
			
			ReportShowTD_AddNum(td,unit.getBuildArea()==null?BigDecimal.valueOf(0):unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase("认购情况_成交金额")){
			
			ReportShowTD_AddNum(td,unit.getSumPrice()==null?BigDecimal.valueOf(0):unit.getSumPrice());
		}
		else if(td.getxTheadText().equalsIgnoreCase("认购情况_均价")){
			//todo:后面的方法设置
		}
		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_签约套数")){
			ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_签约面积")){
			
			ReportShowTD_AddNum(td,unit.getBuildArea()==null?BigDecimal.valueOf(0):unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_签约金额")){
			
			ReportShowTD_AddNum(td,unit.getSumPrice()==null?BigDecimal.valueOf(0):unit.getSumPrice());
		}
		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_均价")){
			//todo:后面方法设置
		}
		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_签约率")){
			//todo:后面方法设置
		}
		else if(td.getxTheadText().equalsIgnoreCase("未签约情况_未签约套数")){
			ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase("未签约情况_未签约面积")){
			
			ReportShowTD_AddNum(td,unit.getBuildArea()==null?BigDecimal.valueOf(0):unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase("未签约情况_未签约金额")){
			
			ReportShowTD_AddNum(td,unit.getSumPrice()==null?BigDecimal.valueOf(0):unit.getSumPrice());
		}
		else if(td.getxTheadText().equalsIgnoreCase("未签约情况_均价")){
			//todo:后面方法设置
		}
		else if(td.getxTheadText().equalsIgnoreCase("推出剩余货量_总量")){
			ReportShowTD_Increment(td);
		}
		else if(td.getxTheadText().equalsIgnoreCase("推出剩余货量_面积")){
			
			ReportShowTD_AddNum(td,unit.getBuildArea()==null?BigDecimal.valueOf(0):unit.getBuildArea());
		}
		else if(td.getxTheadText().equalsIgnoreCase("推出剩余货量_金额")){
			
			ReportShowTD_AddNum(td,unit.getSumPrice()==null?BigDecimal.valueOf(0):unit.getSumPrice());
		}
		else if(td.getxTheadText().equalsIgnoreCase("推出剩余货量_均价")){
			//todo:后面方法设置
		}
		else if(td.getxTheadText().equalsIgnoreCase("推出剩余货量_剩余率")){
			//todo:后面方法设置
		}
		
	}
	

	/**
	 * 求和number1+number2
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static BigDecimal addNumber(BigDecimal number1,BigDecimal number2){
		return getNotNullNumber(number1).add(getNotNullNumber(number2));
	}

	/**
	 * 减number1-number2
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static BigDecimal subtractNumber(BigDecimal number1,BigDecimal number2){
		return getNotNullNumber(number1).subtract(getNotNullNumber(number2));
	}
	

	/**
	 * 乘number1*number2
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static BigDecimal multiplyNumber(BigDecimal number1,BigDecimal number2){
		return getNotNullNumber(number1).multiply(getNotNullNumber(number2));
	}
	

	/**
	 * 除number1/number2
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static BigDecimal divideNumber(BigDecimal number1,BigDecimal number2){
		if(number2.compareTo(BigDecimal.valueOf(0))>0){
			return number1.divide(number2, 4, BigDecimal.ROUND_HALF_UP);
		}
		
		return BigDecimal.valueOf(0);
	}

	/**
	 *  除number1/number2的比例 number1*100/number2
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static BigDecimal divideNumberPercent(BigDecimal number1,BigDecimal number2){
		return divideNumber(multiplyNumber(number1,BigDecimal.valueOf(100)),number2);
	}

	
	/**
	 * 得到非空的数据
	 * @param number
	 * @return
	 */
	public static BigDecimal getNotNullNumber(BigDecimal number){
		if(number==null){
			return BigDecimal.valueOf(0);
		}
		
		return number;
		
	}
	
}
