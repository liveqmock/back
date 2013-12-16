package com.ihk.utils.saleunit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import com.ihk.constanttype.ContTable;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.ComparatorByIntAndString;
import com.ihk.utils.chip.ChipManagerUtils;

/**
 * 楼盘楼栋,单元的关系帮助类
 * @author dtc
 */
public class BuildUnitUtils {
	
	private static final String FLOOR = "层";
	private static final String CSS_FRONT_NAME = "sale_state_";
	
	/**
	 * 根据unitList 返回对应的tr值
	 * @param unitList
	 * @return
	 */
	public static List<String> initTrByUnitList(List<PropertyUnit> unitList){
		
		//map
		Map<String, List<PropertyUnit>> map = new TreeMap<String, List<PropertyUnit>>(); //TreeMap,key按自然顺序进行排序的map
		
		for(PropertyUnit unit : unitList){
			
			String floorNum = unit.getFloorNum();
			if(!map.containsKey(floorNum)){
				
				List<PropertyUnit> list = new ArrayList<PropertyUnit>();
				list.add(unit);
				
				map.put(floorNum, list);
				
			}else{
				
				List<PropertyUnit> tmpList = map.get(floorNum);
				tmpList.add(unit);
				
				map.put(floorNum, tmpList);
			}
		}
		
		List<String> retList = new ArrayList<String>();
		StringBuffer tr = null;
		
		SortedSet<String> keySet = (SortedSet<String>) map.keySet(); //按自然顺序进行排序的set
		
		for(String key : keySet){
			
			tr = new StringBuffer();
			List<PropertyUnit> valueList = map.get(key);
			
			tr.append(ContTable.TR_START)
				.append(ContTable.TD_START)
				.append(key + FLOOR)
				.append(ContTable.TD_END)
				;
			
			for(PropertyUnit value : valueList){
				tr.append("<td unitId=\"").append(value.getId()).append("\">")
					.append(value.getUnitNo())
					.append(ContTable.TD_END)
					;
				
			}
			
			tr.append(ContTable.TR_END);
			retList.add(tr.toString());
			
		}
		
		return retList;
	}
	
	
	/**
	 * 根据unitList 返回对应的tr值(框与字分开)
	 * @param unitList
	 * @return
	 */
	public static List<String> initTrAndDivTdByUnitList(List<PropertyUnit> unitList){
		
		//map
		Map<String, List<PropertyUnit>> map = new TreeMap<String, List<PropertyUnit>>(); //TreeMap,key按自然顺序进行排序的map
		
		for(PropertyUnit unit : unitList){
			
			String floorNum = unit.getFloorNum();
			if(!map.containsKey(floorNum)){
				
				List<PropertyUnit> list = new ArrayList<PropertyUnit>();
				list.add(unit);
				
				map.put(floorNum, list);
				
			}else{
				
				List<PropertyUnit> tmpList = map.get(floorNum);
				tmpList.add(unit);
				
				map.put(floorNum, tmpList);
			}
		}
		
		List<String> retList = new ArrayList<String>();
		StringBuffer tr = null;
		
		SortedSet<String> keySet = (SortedSet<String>) map.keySet(); //按自然顺序进行排序的set
		
		for(String key : keySet){
			
			tr = new StringBuffer();
			List<PropertyUnit> valueList = map.get(key);
			
			tr.append(ContTable.TR_START)
				.append(ContTable.TD_START)
				.append(key + FLOOR)
				.append(ContTable.TD_END)
				;
			
			for(PropertyUnit value : valueList){
				/**
				 * <td class="unit" width="150px" uid="2456" rom="0" flo="2">
					<div class="td3"></div>
					<div style="float: left">包-2-0</div>
					</td>
				 */
				tr.append("<td unitId=\"").append(value.getId()).append("\">")
					.append("<div class=\"").append(CSS_FRONT_NAME).append(value.getSaleState()).append("\"></div>")
					.append("<div style=\"float: left\">")
					.append(value.getUnitNo())
					.append("</div>")
					.append(ContTable.TD_END)
					;
				
			}
			
			tr.append(ContTable.TR_END);
			retList.add(tr.toString());
			
		}
		
		return retList;
	}


	/**
	 * 根据unitList 返回对应的tr值(框与字分开)
	 * @param unitList
	 * @return
	 */
	public static List<String> initTrAndDivTdByUnitList(List<PropertyUnit> unitList,String type){
		
		//map
		Map<String, List<PropertyUnit>> map = new TreeMap<String, List<PropertyUnit>>(); //TreeMap,key按自然顺序进行排序的map
		
		for(PropertyUnit unit : unitList){
			
			String floorNum = unit.getFloorNum();
			if(!map.containsKey(floorNum)){
				
				List<PropertyUnit> list = new ArrayList<PropertyUnit>();
				list.add(unit);
				
				map.put(floorNum, list);
				
			}else{
				
				List<PropertyUnit> tmpList = map.get(floorNum);
				tmpList.add(unit);
				
				map.put(floorNum, tmpList);
			}
		}
		
		List<String> retList = new ArrayList<String>();
		StringBuffer tr = null;
		
		SortedSet<String> keySet = (SortedSet<String>) map.keySet(); //按自然顺序进行排序的set
		
		for(String key : keySet){
			
			tr = new StringBuffer();
			List<PropertyUnit> valueList = map.get(key);
			
			tr.append(ContTable.TR_START)
				.append(ContTable.TD_START)
				.append(key + FLOOR)
				.append(ContTable.TD_END)
				;
			
			for(PropertyUnit value : valueList){
				/**
				 * <td class="unit" width="150px" uid="2456" rom="0" flo="2">
					<div class="td3"></div>
					<div style="float: left">包-2-0</div>
					</td>
				 */
				tr.append("<td unitId=\"").append(value.getId()).append("\">")
					.append("<div class=sale_state_"+0+"></div>")
					.append("<div style=\"float: left\">")
					.append(value.getUnitNo())
					.append("</div>")
					.append(ContTable.TD_END)
					;
			}
			tr.append(ContTable.TR_END);
			retList.add(tr.toString());
			
		}
		
		return retList;
	}
	
	/**
	 * 现场销控清空的单元显示
	 * @param unitList
	 * @param build
	 * @return
	 */
	public static List<String> initUnitMapForScene(List<PropertyUnit> unitList,PropertyBuild bb){
		LinkedList<String> louceng = new LinkedList<String>();//楼层
		LinkedList<String> danYuanHao = new LinkedList<String>();//单元号
		Map<String,PropertyUnit> unitMap = new HashMap<String, PropertyUnit>();//按照2维
		String LINKE_S = "&&";//连接符
		
		
		for(PropertyUnit p : unitList){//拿到有效楼层和有效单元号
			if(!louceng.contains(p.getFloorNum())){
				louceng.add(p.getFloorNum());
			}
			
			if(!danYuanHao.contains(p.getRoomNo().trim())){
				danYuanHao.add(p.getRoomNo().trim());
			}
			
			unitMap.put(p.getFloorNum()+LINKE_S + p.getRoomNo(), p);//存放Unit 按照楼层+单元号   单元号可以是string 
		}
		unitList.clear();
		
		
		//楼层单元号排序
//		Collections.sort(louceng);
//		Collections.reverse(louceng);
		Collections.sort(danYuanHao ,new ComparatorByIntAndString());
		//TODO 组合页面用string
		List<String> retList = new ArrayList<String>();//转译楼栋单元信息
		StringBuffer tdSb = null;//单个楼层
		
		
		String tou_1 = "<td nowrap='nowrap' unitId=";
		String tou_2 = "><div style='overflow:hidden;white-space:nowrap''><div style='overflow:hidden'>";
		String tou_3 = "<div class='sale_state_";
		String tou_4 = "' style='width: 10px'></div>";
		String tou_5 = "<div style='float: left;overflow:hidden;white-space:nowrap'>";
		String tou_6 = "</div></div></td>";
		
		for(String foolint : louceng){//循环楼层和单元号   组合成需要返回的字符串集合 retList
			tdSb = new StringBuffer();
			tdSb.append("<tr><td  class='' style='width: 20px;background-color: #106eab;color:#ffffff' ><div style='width: 35px;overflow: hidden'>")
				.append(foolint).append("层</div></td>");
			for(String danYuanint: danYuanHao){
				PropertyUnit unit = unitMap.get(foolint+LINKE_S+danYuanint);
				if(unit == null){
					tdSb.append("<td></td>");
				}else{
					tdSb.append(tou_1).append(unit.getId())
					.append(getUnitShowForScene(unit))
					.append(tou_2)
					.append(tou_3).append(unit.getSaleState()).append(tou_4)
					.append(tou_5).append(unit.getUnitNo()).append(tou_6);
				}
			}
			tdSb.append("</tr>");
			retList.add(tdSb.toString());
		}
		retList.add(0, "<th style='line-height: 20px;background-color: #106eab;color:#ffffff' colspan='"+danYuanHao.size()+1+"'>"+bb.getBuildName()+"</th>");
		return retList;
	}
	
	/**
	 * 现场销控清空的单元显示
	 * @param unitList
	 * @param maxFl
	 * @param minFl
	 * @param bb
	 * @return
	 */
	public static List<String> initUnitMapForScene(List<PropertyUnit> unitList,int maxFl,int minFl,PropertyBuild bb){
		if(unitList == null || unitList.size() == 0){
			List<String> resList = new ArrayList<String>();
			
			return resList;
		}
		int maxFloor = maxFl;
		int mixFloor = minFl;
		int maxUnitRoom;
		int minUnitRoom;
		
		
		maxUnitRoom = Integer.parseInt(unitList.get(0).getRoomNo());
		minUnitRoom = maxUnitRoom;
		
		for(PropertyUnit p : unitList){
			
			int tp = Integer.parseInt( p.getRoomNo()) ;
			
			if(tp>maxUnitRoom) maxUnitRoom = tp;
			if(tp<minUnitRoom) minUnitRoom = tp;
		}
		
		String[][] tdString = new String[maxFloor - mixFloor +1][maxUnitRoom - minUnitRoom +1];
		String tptr = "<td class='unit_td'></td>";
		
		for(int i = 0; i < maxFloor - mixFloor +1 ; i++){
			for(int j = 0; j < maxUnitRoom - minUnitRoom +1 ; j++){
				tdString[i][j] = tptr;
			}
		}
		
		StringBuffer tdSb = null;
		
		
		
		for(PropertyUnit unit : unitList){
			//String state = p.getSaleState()==null? "2":p.getSaleState();
			String f =  unit.getFloorNum();
			int r =  Integer.parseInt( unit.getRoomNo());
			
			tdSb = new StringBuffer();
			
			tdSb.append("<td class='unit_td' unitId=").append(unit.getId())
				.append(getUnitShowForScene(unit))
				.append("><div style='width: 50px;overflow: hidden'>")
				.append("<div class='sale_state_").append(unit.getSaleState()).append("'></div>")
				.append("<div style='float: left'>").append(unit.getUnitNo()).append("</div></div></td>");
			
			tdString[CommonUtils.getIntFromString(f) - mixFloor][r - minUnitRoom] = tdSb.toString();
			
		}
		
		List<String> retList = new ArrayList<String>();

		StringBuffer trSb = null;
		
		for(int i =  maxFloor   ; i >= mixFloor ; i--){
			//if(i == 0) continue;
			
			trSb = new StringBuffer();
			trSb.append("<td  class='' style='width: 20px;background-color: #106eab;color:#ffffff' ><div style='width: 35px;overflow: hidden'>")
				.append(i).append("层</div></td>");
			
			for(int j = 0; j < maxUnitRoom - minUnitRoom +1 ; j++){
				trSb.append(tdString[i - mixFloor][j]);
			}
			
			trSb.append("");
			
			retList.add(trSb.toString());
			
		}
		retList.add(0, "<th style='line-height: 20px;background-color: #106eab;color:#ffffff' colspan='"+(maxUnitRoom-minUnitRoom+2)+"'>"+bb.getBuildName()+"</th>");
		return retList;
	}
	
	/**
	 * 认筹界面的单元显示,颜色根据是否为认筹单元来区分
	 * @param unitList
	 * @param bb
	 * @return
	 */
	public static List<String> initUnitMapForChip(List<PropertyUnit> unitList,PropertyBuild bb){
		LinkedList<String> louceng = new LinkedList<String>();//楼层
		LinkedList<String> danYuanHao = new LinkedList<String>();//单元号
		Map<String,PropertyUnit> unitMap = new HashMap<String, PropertyUnit>();//按照2维
		String LINKE_S = "&&";//连接符
		
		
		for(PropertyUnit p : unitList){//拿到有效楼层和有效单元号
			if(!louceng.contains(p.getFloorNum())){
				louceng.add(p.getFloorNum());
			}
			
			if(!danYuanHao.contains(p.getRoomNo().trim())){
				danYuanHao.add(p.getRoomNo().trim());
			}
			
			unitMap.put(p.getFloorNum()+LINKE_S + p.getRoomNo(), p);//存放Unit 按照楼层+单元号   单元号可以是string 
		}
		unitList.clear();
		
		
		//楼层单元号排序
//		Collections.sort(louceng);
//		Collections.reverse(louceng);
		Collections.sort(danYuanHao ,new ComparatorByIntAndString());
		//TODO 组合页面用string
		List<String> retList = new ArrayList<String>();//转译楼栋单元信息
		StringBuffer tdSb = null;//单个楼层
		
		
		String tou_1 = "<td nowrap='nowrap' unitId=";
		String tou_2 = "><div style='overflow:hidden;white-space:nowrap''><div style='overflow:hidden'>";
		String tou_3 = "<div class='sale_state_";
		String tou_4 = "' style='width: 10px'></div>";
		String tou_5 = "<div style='float: left;overflow:hidden;white-space:nowrap'>";
		String tou_6 = "</div></div></td>";
		
		for(String foolint : louceng){//循环楼层和单元号   组合成需要返回的字符串集合 retList
			tdSb = new StringBuffer();
			tdSb.append("<tr><td  class='' style='width: 20px;background-color: #106eab;color:#ffffff' ><div style='width: 35px;overflow: hidden'>")
				.append(foolint).append("层</div></td>");
			for(String danYuanint: danYuanHao){
				PropertyUnit p = unitMap.get(foolint+LINKE_S+danYuanint);
				if(p == null){
					tdSb.append("<td></td>");
				}else{
					tdSb.append(tou_1).append(p.getId()).append(tou_2)
					.append(tou_3).append(ChipManagerUtils.getUnitChipClassNo(p)).append(tou_4)
					.append(tou_5).append(ChipManagerUtils.getUnitChipShow(p)).append(tou_6);
				}
			}
			tdSb.append("</tr>");
			retList.add(tdSb.toString());
		}
		retList.add(0, "<th style='line-height: 20px;background-color: #106eab;color:#ffffff' colspan='"+danYuanHao.size()+1+"'>"+bb.getBuildName()+"</th>");
		return retList;
	}
	
	/**
	 * 认筹界面的单元显示,颜色根据是否为认筹单元来区分(分区)
	 * @param unitList
	 * @param maxFl
	 * @param minFl
	 * @param bb
	 * @return
	 */
	public static List<String> initUnitMapForChip1(List<PropertyUnit> unitList,int maxFl,int minFl,PropertyBuild bb){
		if(unitList == null || unitList.size() == 0){
			List<String> resList = new ArrayList<String>();
			
			return resList;
		}
		int maxFloor = maxFl;
		int mixFloor = minFl;
		int maxUnitRoom;
		int minUnitRoom;
		
		
		maxUnitRoom = Integer.parseInt(unitList.get(0).getRoomNo());
		minUnitRoom = maxUnitRoom;
		
		for(PropertyUnit p : unitList){
			
			int tp = Integer.parseInt( p.getRoomNo()) ;
			
			if(tp>maxUnitRoom) maxUnitRoom = tp;
			if(tp<minUnitRoom) minUnitRoom = tp;
		}
		
		String[][] tdString = new String[maxFloor - mixFloor +1][maxUnitRoom - minUnitRoom +1];
		String tptr = "<td class='unit_td'></td>";
		
		for(int i = 0; i < maxFloor - mixFloor +1 ; i++){
			for(int j = 0; j < maxUnitRoom - minUnitRoom +1 ; j++){
				tdString[i][j] = tptr;
			}
		}
		
		StringBuffer tdSb = null;
		
		
		
		for(PropertyUnit unit : unitList){
			//String state = p.getSaleState()==null? "2":p.getSaleState();
			String f =  unit.getFloorNum();
			int r =  Integer.parseInt( unit.getRoomNo());
			
			tdSb = new StringBuffer();
			//PropertyUnit p = unitMap.get(f+LINKE_S+unit.getUnitNo());
			tdSb.append("<td class='unit_td' unitId=").append(unit.getId())
				.append(getUnitShowForScene(unit))
				.append("><div style='width: 50px;overflow: hidden'>")
				.append("<div class='sale_state_").append(ChipManagerUtils.getUnitChipClassNo(unit)).append("'></div>")
				.append("<div style='float: left;overflow:hidden;white-space:nowrap'>").append(ChipManagerUtils.getUnitChipShow(unit)).append("</div></div></td>");
			
			tdString[CommonUtils.getIntFromString(f) - mixFloor][r - minUnitRoom] = tdSb.toString();
			
		}
		
		List<String> retList = new ArrayList<String>();

		StringBuffer trSb = null;
		
		for(int i =  maxFloor   ; i >= mixFloor ; i--){
			//if(i == 0) continue;
			
			trSb = new StringBuffer();
			trSb.append("<td  class='' style='width: 20px;background-color: #106eab;color:#ffffff' ><div style='width: 35px;overflow: hidden'>")
				.append(i).append("层</div></td>");
			
			for(int j = 0; j < maxUnitRoom - minUnitRoom +1 ; j++){
				trSb.append(tdString[i - mixFloor][j]);
			}
			
			trSb.append("");
			
			retList.add(trSb.toString());
			
		}
		retList.add(0, "<th style='line-height: 20px;background-color: #106eab;color:#ffffff' colspan='"+(maxUnitRoom-minUnitRoom+2)+"'>"+bb.getBuildName()+"</th>");
		return retList;
	}
	
	/**
	 * 形成单元的销控表格	 
	 *  
	 * @param unitList
	 * @param bb
	 * @return "<tr><td>...</td></tr>"...的格式
	 */
	public static List<String> initUnitMap(List<PropertyUnit> unitList,PropertyBuild bb){
		LinkedList<String> louceng = new LinkedList<String>();//楼层
		LinkedList<String> danYuanHao = new LinkedList<String>();//单元号
		Map<String,PropertyUnit> unitMap = new HashMap<String, PropertyUnit>();//按照2维
		String LINKE_S = "&&";//连接符
		
		
		for(PropertyUnit p : unitList){//拿到有效楼层和有效单元号
			if(!louceng.contains(p.getFloorNum())){
				louceng.add(p.getFloorNum());
			}
			
			if(!danYuanHao.contains(p.getRoomNo().trim())){
				danYuanHao.add(p.getRoomNo().trim());
			}
			
			unitMap.put(p.getFloorNum()+LINKE_S + p.getRoomNo(), p);//存放Unit 按照楼层+单元号   单元号可以是string 
		}
		unitList.clear();
		
		
		//楼层单元号排序
//		Collections.sort(louceng);
//		Collections.reverse(louceng);
		Collections.sort(danYuanHao ,new ComparatorByIntAndString());
		//TODO 组合页面用string
		List<String> retList = new ArrayList<String>();//转译楼栋单元信息
		StringBuffer tdSb = null;//单个楼层
		
		String tou_1 = "<td nowrap='nowrap'  unitId=";
		String edition = " salestate='sale_state_";
		String tou_2 = "'><div style='overflow:hidden;white-space:nowrap''><div style='overflow:hidden'>";
		String tou_3 = "<div class='sale_state_";
		String tou_4 = "' style='width: 10px'></div>";
		String tou_5 = "<div style='float: left;overflow:hidden;white-space:nowrap'>";
		String tou_6 = "</div></div></td>";
		
		for(String foolint : louceng){//循环楼层和单元号   组合成需要返回的字符串集合 retList
			tdSb = new StringBuffer();
			tdSb.append("<tr><td  class='' style='width: 20px;background-color: #106eab;color:#ffffff' ><div style='width: 35px;overflow: hidden'>")
				.append(foolint).append("层</div></td>");
			for(String danYuanint: danYuanHao){
				PropertyUnit p = unitMap.get(foolint+LINKE_S+danYuanint);
				if(p == null){
					tdSb.append("<td></td>");
				}else{
					tdSb.append(tou_1).append(p.getId()).append(edition)
						.append(p.getSaleState())
						.append("' state='").append(p.getSaleState()).append("' ") //增加单元状态
						.append("checkfeeType='").append(p.getCheckfeeType()) //增加对数状态
						.append(tou_2)
						.append(tou_3).append(p.getSaleState()).append(tou_4)
						.append(tou_5).append(p.getUnitNo()).append(tou_6);
				}
			}
			tdSb.append("</tr>");
			retList.add(tdSb.toString());
		}
		retList.add(0, "<th style='line-height: 20px;background-color: #106eab;color:#ffffff' colspan='"+danYuanHao.size()+1+"'>"+bb.getBuildName()+"</th>");
		return retList;
	}
	
	
	public static List<String> initUnitMap(List<PropertyUnit> unitList,int maxFl,int minFl,PropertyBuild bb){
		LinkedList<String> louceng = new LinkedList<String>();//楼层
		LinkedList<String> danYuanHao = new LinkedList<String>();//单元号
		Map<String,PropertyUnit> unitMap = new HashMap<String, PropertyUnit>();//按照2维
		String LINKE_S = "&&";//连接符
		
		
		for(PropertyUnit p : unitList){//拿到有效楼层和有效单元号
			if(!louceng.contains(p.getFloorNum())){
				louceng.add(p.getFloorNum());
			}
			
			if(!danYuanHao.contains(p.getRoomNo().trim())){
				danYuanHao.add(p.getRoomNo().trim());
			}
			
			unitMap.put(p.getFloorNum()+LINKE_S + p.getRoomNo(), p);//存放Unit 按照楼层+单元号   单元号可以是string 
		}
		unitList.clear();
		
		
		//楼层单元号排序
//		Collections.sort(louceng);
//		Collections.reverse(louceng);
		Collections.sort(danYuanHao ,new ComparatorByIntAndString());
		//TODO 组合页面用string
		List<String> retList = new ArrayList<String>();//转译楼栋单元信息
		StringBuffer tdSb = null;//单个楼层
		
		
		String tou_1 = "<td nowrap='nowrap' unitId=";
		String tou_2 = "><div style='overflow:hidden;white-space:nowrap''><div style='overflow:hidden'>";
		String tou_3 = "<div class='sale_state_";
		String tou_4 = "' style='width: 10px'></div>";
		String tou_5 = "<div style='float: left;overflow:hidden;white-space:nowrap'>";
		String tou_6 = "</div></div></td>";
		
		for(String foolint : louceng){//循环楼层和单元号   组合成需要返回的字符串集合 retList
			tdSb = new StringBuffer();
			tdSb.append("<tr><td  class='' style='width: 20px;background-color: #106eab;color:#ffffff' ><div style='width: 35px;overflow: hidden'>")
				.append(foolint).append("层</div></td>");
			for(String danYuanint: danYuanHao){
				PropertyUnit p = unitMap.get(foolint+LINKE_S+danYuanint);
				if(p == null){
					tdSb.append("<td></td>");
				}else{
					tdSb.append(tou_1).append(p.getId()).append(tou_2)
						.append(tou_3).append(p.getSaleState()).append(tou_4)
						.append(tou_5).append(p.getUnitNo()).append(tou_6);
				}
			}
			tdSb.append("</tr>");
			retList.add(tdSb.toString());
		}
		retList.add(0, "<th style='line-height: 20px;background-color: #106eab;color:#ffffff' colspan='"+danYuanHao.size()+1+"'>"+bb.getBuildName()+"</th>");
		return retList;
	}
	
	/**
	 * 获取"现场销售情况"的单元显示内容
	 * @param unit
	 * @return
	 */
	private static String getUnitShowForScene(PropertyUnit unit){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" title='").append(getSceneUnitTitle(unit).replaceAll(";","&#10;")).append("' ");
		
		return sb.toString();
	}
	
	/**
	 * 获取"现场销售情况"的单元title
	 * @param unit
	 * @return
	 */
	private static String getSceneUnitTitle(PropertyUnit unit){
		
		StringBuffer title = new StringBuffer();
		
		title.append("销售状态:").append(unit.getSaleStateStr()).append(";")
			.append("建筑单价:").append(unit.getBuildPrice()).append(";")
			.append("套内单价:").append(unit.getInsidePrice()).append(";")
			.append("标准总价:").append(unit.getSumPrice())
			;
		
		return title.toString();
	}

	/**
	 * 2013-03-28
	 * 展示楼栋所属单元图形化信息
	 * 
	 * @author Administrator just
	 * @param unitList 单元列表
	 * @param bb 该单元楼栋
	 * */
	public static List<String> initUnitMap1(List<PropertyUnit> unitList,PropertyBuild bb){
		LinkedList<String> louceng = new LinkedList<String>();//楼层
		LinkedList<String> danYuanHao = new LinkedList<String>();//单元号
		Map<String,PropertyUnit> unitMap = new HashMap<String, PropertyUnit>();//按照2维
		String LINKE_S = "&&";//连接符
		
		
		for(PropertyUnit p : unitList){//拿到有效楼层和有效单元号
			if(!louceng.contains(p.getFloorNum())){
				louceng.add(p.getFloorNum());
			}
			
			if(!danYuanHao.contains(p.getRoomNo().trim())){
				danYuanHao.add(p.getRoomNo().trim());
			}
			
			unitMap.put(p.getFloorNum()+LINKE_S + p.getRoomNo(), p);//存放Unit 按照楼层+单元号   单元号可以是string 
		}
		unitList.clear();
		
		
		//楼层单元号排序
//		Collections.sort(louceng);
//		Collections.reverse(louceng);
		Collections.sort(danYuanHao ,new ComparatorByIntAndString());
		//TODO 组合页面用string
		List<String> retList = new ArrayList<String>();//转译楼栋单元信息
		StringBuffer tdSb = null;//单个楼层
		
		
		String tou_1 = "<td nowrap='nowrap' unitId=";
		String tou_2 = "><div style='overflow:hidden;white-space:nowrap''><div style='overflow:hidden'>";
		String tou_3 = "<div class='sale_state_";
		String tou_4 = "' style='width: 10px'></div>";
		String tou_5 = "<div style='float: left;overflow:hidden;white-space:nowrap'>";
		String tou_6 = "</div></div></td>";
		
		for(String foolint : louceng){//循环楼层和单元号   组合成需要返回的字符串集合 retList
			tdSb = new StringBuffer();
			tdSb.append("<tr><td  class='' style='width: 20px;background-color: #106eab;color:#ffffff' ><div style='width: 35px;overflow: hidden'>")
				.append(foolint).append("层</div></td>");
			for(String danYuanint: danYuanHao){
				PropertyUnit p = unitMap.get(foolint+LINKE_S+danYuanint);
				if(p == null){
					tdSb.append("<td></td>");
				}else{
					tdSb.append(tou_1).append(p.getId()).append(tou_2)
						.append(tou_3).append(p.getSaleState()).append(tou_4)
						.append(tou_5).append(p.getUnitNo()).append(tou_6);
				}
			}
			tdSb.append("</tr>");
			retList.add(tdSb.toString());
		}
		retList.add(0, "<th style='line-height: 20px;background-color: #106eab;color:#ffffff' colspan='"+danYuanHao.size()+1+"'>"+bb.getBuildName()+"</th>");
		return retList;
	}

	/**
	 * 对楼栋进行排序
	 * @param request
	 */
	public static void sortBuildId(HttpServletRequest request) throws RuntimeException{
		
		String sortBuildId = request.getParameter("sortBuildId");
		if(CommonUtils.isStrZeroEmpty(sortBuildId)){
			return ;
		}
		
		List<Integer> ids = CommonUtils.stringToList(sortBuildId);
		if(CommonUtils.isCollectionEmpty(ids)){
			return ;
		}
		
		int size = ids.size();
		for(int i=0; i<size; i++){
			
			int orderIndex = i + 1;
			MyPropertyUtils.getPropertyBuildServices().updatePropertyBuildOrderIndex(ids.get(i), orderIndex);
		}
		
	}
	
}

