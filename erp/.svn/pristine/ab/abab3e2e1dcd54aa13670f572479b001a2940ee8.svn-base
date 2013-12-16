package com.ihk.saleunit.action.new_init;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.DeleteProvider;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.ProjectText;
import com.ihk.setting.data.pojo.ProjectTextCond;
import com.ihk.setting.data.services.IProjectTextServices;
import com.ihk.setting.data.services.impl.CodeTypeServices;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/***
 * 批量新建单元
 * */
public class GuangZhouNewInitSomeUnit extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired IPropertyBuildServices iPropertyBuildServices;
	@Autowired IPropertyUnitServices iPropertyUnitServices;
	private int buildId;
	
	private String topInfo;
	private Map<String,String> unitinfo;
	
	private String buildFname;
	private String unitFname;
	private String nameType;
	private int unitNum;
	private String unitNumMin;
	private String unitNumMax;
	private int bfl;
	private int efl;
	
	private String selRoomType;
	private String selOrientations;
	private String selPayWay;
	private String productType;
	
	
	
	private String inUnittips;
	
	private Date saleTime;//推货日期
	
	
	public String index(){
		init();
		return "suc";
	}
	
	public String form(){
		inUnittips = addUnits();
		init();
		return "suc";
	}
	
	
	@Autowired IProjectTextServices projectTextServices;
	private void init(){
		StringBuilder sb = new StringBuilder();
		List<CodeDtl> roomDtl = DescUtils.getCodeTypeServices(). findCodeList(EnumCodeTypeName.PROPERTY_ROOM_TYPE.toString(),SessionUser.getProjectId());
		for(CodeDtl c : roomDtl){
			sb.append("{productid:'"+c.getCodeVal()).append("',name:'"+c.getCodeDesc()).append("'},");
		}
		selRoomType = sb.toString();
		selRoomType= selRoomType.substring(0,selRoomType.length()-1);
		
		sb = new StringBuilder();
		List<CodeDtl> OrDtl = DescUtils.getCodeTypeServices(). findCodeList(EnumCodeTypeName.PROPERTY_ORIENTATION.toString(),SessionUser.getProjectId());
		for(CodeDtl c : OrDtl){
			sb.append("{productid:'"+c.getCodeVal()).append("',name:'"+c.getCodeDesc()).append("'},");
		}
		selOrientations = sb.toString();
		selOrientations= selOrientations.substring(0,selOrientations.length()-1);
		
		
		sb = new StringBuilder();
		List<CodeDtl> payWayDtl = DescUtils.getCodeTypeServices(). findCodeList(EnumCodeTypeName.PROPERTY_PRICE_WAY.toString(),SessionUser.getProjectId());
		for(CodeDtl c : payWayDtl){
			sb.append("{productid:'"+c.getCodeVal()).append("',name:'"+c.getCodeDesc()).append("'},");
		}
		selPayWay = sb.toString();
		selPayWay= selPayWay.substring(0,selPayWay.length()-1);
		
		sb = new StringBuilder();
		/**
		 * 2012-11-14 修改成projecttex
		 * 
		List<CodeDtl> productTypeDtl = DescUtils.getCodeTypeServices(). findCodeList(EnumCodeTypeName.PROPERTY_PRODUCT_TYPE.toString(),SessionUser.getProjectId());
		for(CodeDtl c : productTypeDtl){
			sb.append("{productid:'"+c.getCodeVal()).append("',name:'"+c.getCodeDesc()).append("'},");
		}*/
		ProjectTextCond cond = new ProjectTextCond();
		cond.setTypeName("PRODUCT_TYPE");
		cond.setProjectId(SessionUser.getProjectId()+"");
		List<ProjectText> productTypeDtl = projectTextServices.findProjectText(cond);
		
		if(productTypeDtl.size() == 0){
			productType = "";
		}else{
			for(ProjectText c : productTypeDtl){
				sb.append("{productid:'"+c.getId()).append("',name:'"+c.getCodeDesc()).append("'},");
			}
			
			productType = sb.toString();
			productType = productType.substring(0,productType.length()-1);
		}
		
		
		PropertyBuild bu = this.iPropertyBuildServices.findPropertyBuildById(buildId);
		topInfo = bu.getDescPropertyId() +">>" + bu.getAreaName() + ">>" + bu.getBuildName();
	}
	
	/***
	 * 批量新建单元实现
	 * */
	@Deprecated
	private String addUnits1(){
		if(unitNum <= 0)return "没有设定房间";
		if(bfl >efl)return "楼层有错误";
		
		List<PropertyUnit> floUnit = initFlUnits(this.unitinfo);//得到层基本LIST
		List<String> addUnit = new ArrayList<String>();
		for (int i = bfl; i <= efl; i++) {
			
			if(unitNum > 10){
				PropertyUnit uu = floUnit.get(0);
				for (int j = 1; j <= unitNum; j++) {
					uu.setRoomNo(j+"");
					uu.setFloorNum(""+i);
					uu.setUnitNo(this.initUnirNo(i, uu.getRoomNo()));
					uu.setBuildId(buildId);
					addUnit.add(uu.getFloorNum()+"-"+uu.getRoomNo());//
				}
			}else{
				for(PropertyUnit uu : floUnit){
					uu.setFloorNum(""+i);
					uu.setUnitNo(this.initUnirNo(i, uu.getRoomNo()));
					uu.setBuildId(buildId);
					addUnit.add(uu.getFloorNum()+"-"+uu.getRoomNo());//
				}
			}
			
			
		}
		
		if(isRepeat(buildId,addUnit)){
			return "房间有冲突,请先确定已有房间";
		}else{
				for (int i = bfl; i <= efl; i++) {
					if(i == 0)continue;
					
					if(unitNum > 10){
						PropertyUnit uu = floUnit.get(0);
						for (int j = 1; j <= unitNum; j++) {
							uu.setRoomNo(j+"");
							uu.setFloorNum(""+i);
							uu.setUnitNo(this.initUnirNo(i, uu.getRoomNo()));
							uu.setBuildId(buildId);
							initPropertyUnit(uu);
							uu.setSaleTime(saleTime);
							iPropertyUnitServices.addPropertyUnit(uu);
						}
					}else{
						for(PropertyUnit uu : floUnit){//使用基本层数循环   其实最好是循环设定的单元数
							uu.setFloorNum(""+i);
							uu.setUnitNo(this.initUnirNo(i, uu.getRoomNo()));
							uu.setBuildId(buildId);
							initPropertyUnit(uu);
							uu.setSaleTime(saleTime);
							iPropertyUnitServices.addPropertyUnit(uu);
						}
					}
					
				}
			return "房间新建成功";
		}
	}
	

	/***
	 * 批量新建单元实现
	 * */
	private String addUnits(){
		Date createdTime = new Date();
		if(Integer.valueOf(unitNumMax) - Integer.valueOf(unitNumMin) <  0)return "请先设定房间";
		
		if((Integer.valueOf(unitNumMax) - Integer.valueOf(unitNumMin) + 1)*(efl - bfl+1) > 999)return "最多一次建立999个单元,如需要请分次建立";
		unitNum = Integer.valueOf(unitNumMax) - Integer.valueOf(unitNumMin) +1;
		if(bfl == 0 && efl ==0)return "请设定楼层";
		if(bfl > efl){
			int tmp = 0;
			tmp = bfl;
			bfl = efl;
			efl = tmp;
		}
		List<PropertyUnit> floUnit = initFlUnits(this.unitinfo);//得到层基本LIST
		List<String> addUnit = new ArrayList<String>();
		for (int i = bfl; i <= efl; i++) {
			
			if(unitNum > 20){
				PropertyUnit uu = floUnit.get(0);
				for (int j = Integer.valueOf(unitNumMin); j <= Integer.valueOf(unitNumMax); j++) {
					uu.setRoomNo(j+"");
					uu.setFloorNum(""+i);
					uu.setUnitNo(this.initUnirNo(i, uu.getRoomNo()));
					uu.setBuildId(buildId);
					addUnit.add(uu.getFloorNum()+"-"+uu.getRoomNo());
				}
			}else{
				for(PropertyUnit uu : floUnit){
					uu.setFloorNum(""+i);
					uu.setUnitNo(this.initUnirNo(i, uu.getRoomNo()));
					uu.setBuildId(buildId);
					addUnit.add(uu.getFloorNum()+"-"+uu.getRoomNo());
				}
			}
		}
		
		if(isRepeat(buildId,addUnit)){
			return "房间有冲突,请先确定已有房间";
		}else{
				for (int i = bfl; i <= efl; i++) {
					if(i == 0)continue;
					
					if(unitNum > 20){
						PropertyUnit uu = floUnit.get(0);
						String begin ="";
						String second="";
						if(Integer.valueOf(unitNumMin)<10){
							if(unitNumMin.charAt(0)=='0'){
								begin="0";
								if(unitNumMin.charAt(1)=='0'){
									begin="00";
									second="0";
								}
							}
						}
						if(Integer.valueOf(unitNumMin)>=10){
							if(unitNumMin.charAt(0)=='0'){
								second="0";
							}
						}
						
						for (int j = Integer.valueOf(unitNumMin); j <= Integer.valueOf(unitNumMax); j++) {
							if(j<10){
								uu.setRoomNo(begin+j);
							}else if(j<100){
								uu.setRoomNo(second+j);
							}else{
								uu.setRoomNo(""+j);
							}
							uu.setFloorNum(""+i);
							uu.setUnitNo(this.initUnirNo(i, uu.getRoomNo()));
							uu.setBuildId(buildId);
							initPropertyUnit(uu);
							uu.setSaleTime(saleTime);
							uu.setCreatedTime(createdTime);
							iPropertyUnitServices.addPropertyUnit(uu);
						}
					}else{
						for(PropertyUnit uu : floUnit){//使用基本层数循环   其实最好是循环设定的单元数
							uu.setFloorNum(""+i);
							uu.setUnitNo(this.initUnirNo(i, uu.getRoomNo()));
							uu.setBuildId(buildId);
							initPropertyUnit(uu);
							uu.setSaleTime(saleTime);
							uu.setCreatedTime(createdTime);
							iPropertyUnitServices.addPropertyUnit(uu);
						}
					}
					
				}
			return "房间新建成功";
		}
	}
	
	/**
	 * 解析map来自jsp设定
	 * */
	private List<PropertyUnit> initFlUnits(Map<String,String> p){
		String[] roomNos = p.get("roomNo") .split("&");
		//String[] roomType = p.get("roomType") .split("&");
		String[] roomNum = p.get("roomNum") .split("&");
		String[] hallNum = p.get("hallNum") .split("&");
		String[] toiletNum = p.get("toiletNum") .split("&");
		
		String[] insideAreas = p.get("insideArea") .split("&");
		String[] buildAreas = p.get("buildArea") .split("&");
		String[] insidePrices = p.get("insidePrice") .split("&");
		String[] priceWay = p.get("priceWay").split("&");
		String[] buildPrice = p.get("buildPrice") .split("&");
		String[] orientation = p.get("orientation") .split("&");
		
		String[] productType = p.get("productType") .split("&");
		String[] renovateDesc = p.get("renovateDesc") .split("&");
		String[] renovatePrice = p.get("renovatePrice") .split("&");
		String[] renovateMoney = p.get("renovateMoney") .split("&");
		
		
		List<PropertyUnit> tplist = new ArrayList<PropertyUnit>();
		Date now = new Date();
		if(roomNos[0] == null || roomNos[0].trim().equals("")){
			return tplist;
		}
		for(int i = 0 ; i < roomNos.length ; i++){
			PropertyUnit tu = new PropertyUnit();
			tu.setRoomNo(roomNos[i]);
			try {
				if(roomNum[i] == null || roomNum[i].trim().equals(""))
					tu.setRoomNum(0);
				else tu.setRoomNum(Integer.parseInt(roomNum[i]) );
			} catch (Exception e) {
				tu.setRoomNum(0);
			}
			try {
				if(hallNum[i] == null || hallNum[i].trim().equals(""))
					tu.setHallNum(0);
				else tu.setHallNum(Integer.parseInt(hallNum[i]) );
			} catch (Exception e) {
				tu.setHallNum(0);
			}
			try {
				if(toiletNum[i] == null || toiletNum[i].trim().equals(""))
					tu.setToiletNum(0);
				else tu.setToiletNum(Integer.parseInt(toiletNum[i]) );
			} catch (Exception e) {
				tu.setToiletNum(0);
			}
			try {
				if(insideAreas[i] == null || insideAreas[i].trim().equals(""))
					tu.setInsideArea(new BigDecimal(0));
				else tu.setInsideArea(new BigDecimal(insideAreas[i]));
			} catch (Exception e) {
				tu.setInsideArea(new BigDecimal(0));
			}
			try {
				if(buildAreas[i] == null || buildAreas[i].trim().equals(""))
					tu.setBuildArea(new BigDecimal(0));
				else tu.setBuildArea(new BigDecimal(buildAreas[i]));
			} catch (Exception e) {
				tu.setBuildArea(new BigDecimal(0));
			}
			try {
				if(insidePrices[i] == null || insidePrices[i].trim().equals(""))
					tu.setInsidePrice(new BigDecimal(0));
				else tu.setInsidePrice(new BigDecimal(insidePrices[i]));
			} catch (Exception e) {
				tu.setInsidePrice(new BigDecimal(0));
			}
			try {
				if(buildPrice[i] == null || buildPrice[i].trim().equals(""))
					tu.setBuildPrice(new BigDecimal(0));
				else tu.setBuildPrice(new BigDecimal(buildPrice[i]));
			} catch (Exception e) {
				tu.setBuildPrice(new BigDecimal(0));
			}
			try {
				if(priceWay[i] == null || priceWay[i].trim().equals("")){
					tu.setPriceWay("1");//默认建筑单价
				}
				else tu.setPriceWay(priceWay[i]);
			} catch (Exception e) {
				tu.setPriceWay("1");
			}
			try {
				if(orientation[i] == null || orientation[i].trim().equals("")){
				}
				else tu.setOrientation(orientation[i]);
			} catch (Exception e) {
			}
			
			try {
				if(productType[i] == null || productType[i].trim().equals("")){
					tu.setProductType("");
				}
				else tu.setProductType(productType[i]);
			} catch (Exception e) {
				tu.setProductType("");
			}
			try {
				if(renovateDesc[i] == null || renovateDesc[i].trim().equals("")){
				}
				else tu.setRenovateDesc(renovateDesc[i]);
			} catch (Exception e) {
				tu.setRenovateDesc("");
			}
			try {
				if(renovatePrice[i] == null || renovatePrice[i].trim().equals("")){
				}
				else tu.setRenovatePrice(new BigDecimal(renovatePrice[i]));
			} catch (Exception e) {
				tu.setRenovatePrice(new BigDecimal(0));
			}
			try {
				if(renovateMoney[i] == null || renovateMoney[i].trim().equals("")){
				}
				else tu.setRenovateMoney(new BigDecimal(renovateMoney[i]));
			} catch (Exception e) {
				tu.setRenovateMoney(new BigDecimal(0));
			}
			
			tu.setCreatedId(SessionUser.getUserId());
			tu.setCreatedTime(now);
			tu.setIsDeleted("0");
			tu.setModId(SessionUser.getUserId());
			tu.setModTime(now);
			tplist.add(tu);
		}
		return tplist;
	}
	
	/**
	 *  根据name type
	 *  楼层  房间号 前缀等 
	 *  得到编号
	 * */
	private String initUnirNo(int fl,String rno ){
		if(this.nameType.equals("1"))
			return this.buildFname+fl+this.unitFname +rno;
		if(this.nameType.equals("2"))
			return this.buildFname+this.unitFname +rno;
		return fl+"0"+rno;
	}
	
	/**
	 * 判断数据是否有重复
	 * buildId floorNum roomNum 不能同时相等
	 * @return true是有重复 false 是没有重复
	 * */
	private boolean isRepeat(int reBuildId,List<String> inList){
		List<String> dbList = new ArrayList<String>();
		List<PropertyUnit> tmp = iPropertyUnitServices.findPropertyUnit(new PropertyUnitCond().setBuildId(reBuildId+""));
		for(PropertyUnit p : tmp){
			dbList.add(p.getFloorNum()+"-"+p.getRoomNo());
		}
		
		int maxLength = 0;
		//maxLength = dbList.size() + inList.size();
		
		Set<String> allSet = new HashSet<String>();
		allSet.addAll(dbList);
		maxLength = allSet.size() + inList.size();//DB可能有重复房间  历史问题
		allSet.addAll(inList);
		
		return !(allSet.size() == maxLength);
	}
	
	
	/**
	 * 给房间默认的价格
	 * */
	private PropertyUnit initPropertyUnit(PropertyUnit pro){
		if(pro.getPriceWay() != null && !pro.getPriceWay().trim().equals("")){
			//pro.setPriceWay("1");//默认建筑价格
			if(pro.getPriceWay().equals("1")){
				pro.setSumPrice(pro.getBuildPrice().multiply(pro.getBuildArea()));
			}else{
				pro.setSumPrice(pro.getInsidePrice().multiply(pro.getInsideArea()));
			}
		}
		return pro;
		
	}
	
	public String getTopInfo() {
		return topInfo;
	}

	public void setTopInfo(String topInfo) {
		this.topInfo = topInfo;
	}

	public int getBuildId() {
		return buildId;
	}
	
	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public Map<String, String> getUnitinfo() {
		return unitinfo;
	}

	public void setUnitinfo(Map<String, String> unitinfo) {
		this.unitinfo = unitinfo;
	}

	public String getBuildFname() {
		return buildFname;
	}

	public void setBuildFname(String buildFname) {
		this.buildFname = buildFname;
	}

	public String getUnitFname() {
		return unitFname;
	}

	public void setUnitFname(String unitFname) {
		this.unitFname = unitFname;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public int getUnitNum() {
		return unitNum;
	}

	public void setUnitNum(int unitNum) {
		this.unitNum = unitNum;
	}

	public int getBfl() {
		return bfl;
	}

	public void setBfl(int bfl) {
		this.bfl = bfl;
	}

	public int getEfl() {
		return efl;
	}

	public void setEfl(int efl) {
		this.efl = efl;
	}

	

	public String getSelRoomType() {
		return selRoomType;
	}

	public void setSelRoomType(String selRoomType) {
		this.selRoomType = selRoomType;
	}

	public String getSelOrientations() {
		return selOrientations;
	}

	public void setSelOrientations(String selOrientations) {
		this.selOrientations = selOrientations;
	}

	public String getSelPayWay() {
		return selPayWay;
	}

	public void setSelPayWay(String selPayWay) {
		this.selPayWay = selPayWay;
	}

	public String getInUnittips() {
		return inUnittips;
	}

	public void setInUnittips(String inUnittips) {
		this.inUnittips = inUnittips;
	}

	public Date getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getUnitNumMin() {
		return unitNumMin;
	}

	public void setUnitNumMin(String unitNumMin) {
		this.unitNumMin = unitNumMin;
	}

	public String getUnitNumMax() {
		return unitNumMax;
	}

	public void setUnitNumMax(String unitNumMax) {
		this.unitNumMax = unitNumMax;
	}

	
	
	
	
}
