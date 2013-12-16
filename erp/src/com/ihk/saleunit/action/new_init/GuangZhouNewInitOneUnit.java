package com.ihk.saleunit.action.new_init;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.BuildUnitUtils;

/**
 * 初始楼盘
 * 修改和新建一个单元
 * */
public class GuangZhouNewInitOneUnit extends SupperAction{
	private static final long serialVersionUID = 1L;
	
	@Autowired IPropertyUnitServices iPropertyUnitServices;
	@Autowired IPropertyBuildServices iPropertyBuildServices;
	private int buildId;
	private int unitId;
	private PropertyUnit initUnit;
	
	private String tip;
	
	private String topText;
	
	private String path;
	private LinkedHashMap selOrientation;
	private LinkedHashMap selRoomType;
	private LinkedHashMap selProductType;
	private LinkedHashMap selPriceWay;
	private LinkedHashMap selSaleState;
	private LinkedHashMap selRoomNum;
	private LinkedHashMap selhallNum;
	private LinkedHashMap seltoiletNum;
	private static String PATH_ADD_ONE = "./saleunit_new_init/appoint/guangzhou/initOneUnitForm.action";
	private static String PATH_UP_ONE = "./saleunit_new_init/appoint/guangzhou/updateOneUnitForm.action";
	
	public String index(){
		path = GuangZhouNewInitOneUnit.PATH_ADD_ONE;
		topText = "正在分区:  "+iPropertyBuildServices.findPropertyBuildById(buildId).getBuildName()+
					"  下创建单元";
		initsel();
		selSaleState.clear();
		initState(selSaleState);
		return "suc";
	}
	
	public String form(){
		initsel();
		topText = "正在分区:  "+iPropertyBuildServices.findPropertyBuildById(buildId).getBuildName()+
		"  下新建单元.";
		if(buildId ==0||
				initUnit.getUnitNo().trim().equals("") || initUnit.getUnitNo().trim().equals("0")
				){
			initUnit = new PropertyUnit();
			tip = "房间编号必须指定 或者 填写了不正确的数据";
			return "suc";
		}
		try {
			init(this.initUnit);
		} catch (Exception e) {
			initUnit = new PropertyUnit();
			tip = "房间编号必须指定 或者 填写了不正确的数据";
			return "suc";
		}
		
		if(this.haveSameUnit(initUnit)){
			tip = "房间有重复!";
			return "suc";
		}
		
//		if(mathPrice(initUnit)){
		mathPrice(initUnit);
			this.iPropertyUnitServices.addPropertyUnit(this.initUnit);
			tip = "添加成功!";
//		}else{
//			tip = "数据不完整 无法计算正确数据!";
//		}
		
		
		return "suc";
	}
	
	private void init(PropertyUnit u) throws Exception{
		path = GuangZhouNewInitOneUnit.PATH_ADD_ONE;
		try {
		Date now = new Date();
		u.setModId(SessionUser.getUserId());
		u.setModTime(now);
		u.setIsDeleted("0");
		u.setCreatedId(SessionUser.getUserId());
		u.setCreatedTime(now);
		u.setBuildId(buildId);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 计算单个单元的面积价格
	 * */
	private boolean mathPrice(PropertyUnit unit){
		if(unit.getBuildArea() == null) unit.setBuildArea(new BigDecimal(0));
		if(unit.getBuildPrice() == null) unit.setBuildPrice(new BigDecimal(0));
		if(unit.getInsideArea() == null) unit.setInsideArea(new BigDecimal(0));
		if(unit.getInsidePrice()== null) unit.setInsidePrice(new BigDecimal(0));
		//对总价进行初始化
		if(unit.getSumPrice() == null) unit.setSumPrice(new BigDecimal(0));
		try{
		if(unit.getPriceWay().equals("1")){//建筑计价
			//unit.setSumPrice(unit.getBuildArea().multiply(unit.getBuildPrice()));
			BigDecimal mu = unit.getSumPrice();
			BigDecimal fe = unit.getInsideArea();
			
			BigDecimal div = mu.divide(fe,1);
			
			unit.setInsidePrice( div );
			
		}else if(unit.getPriceWay().equals("2")){
			//unit.setSumPrice(unit.getInsideArea().multiply(unit.getInsidePrice()));
			
			unit.setBuildPrice(unit.getSumPrice().divide(unit.getBuildArea() ,1));
		}else{
			return false;
		}
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	private String selectuid;
	/**
	 * 删除单元
	 * @param selectuid 
	 * */
	public String del() throws IOException{
		try {
			PropertyUnit delUnit = iPropertyUnitServices.findPropertyUnitById(Integer.parseInt(selectuid));
			String state = delUnit.getSaleState();
			if(!ContUnitSaleState.SALE_ABLE.equals(state)){
			//	CustomerUtils.writeResponse(this.response, "房间已有操作,不能删除");
				CustomerUtils.writeResponse(this.response, "{\"sug\":\"非可售单元,不能删除\",\"flush\":\"false\"}");
				return null;
			}
			if(selectuid == null || selectuid.trim().equals("") || Integer.parseInt(selectuid) < 0){
				CustomerUtils.writeResponse(this.response, "{\"sug\":\"没有选择房间\",\"flush\":\"false\"}");
				return null;
			}
			iPropertyUnitServices.deletePropertyUnit(Integer.parseInt(selectuid));
			
			//CustomerUtils.writeResponse(this.response, "删除房间"+delUnit.getUnitNo()+"成功");
			CustomerUtils.writeResponse(this.response, "{\"sug\":\""+"删除房间"+delUnit.getUnitNo()+"成功"+"\",\"flush\":\"true\"}");
		} catch (IOException e) {
			CustomerUtils.writeResponse(this.response, "{\"sug\":\"删除失败\",\"flush\":\"false\"}");
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	/**
	 * 修改单个单元弹出框
	 * @param unitId 选择的单元
	 * */
	public String  updateOneUnit(){
		initsel();
		PropertyBuild tbu = iPropertyBuildServices.findPropertyBuildById(buildId);
		topText = "正在修改楼栋:  "+
		 tbu.getBuildName() +"  单元:  "  + this.iPropertyUnitServices.findPropertyUnitById(unitId).getUnitNo();
		path = GuangZhouNewInitOneUnit.PATH_UP_ONE;
		
		initUnit = iPropertyUnitServices.findPropertyUnitById(unitId);
		request.setAttribute("isupdate", "doupdatedesplay();");
		if(isSale(initUnit)){
			tip = "已销售单元,信息不能修改";
		}else{//2012-10-23 如果是可以修改的房间 销售状态只能有 可售 预留 冻结
			selSaleState.clear();
			initState(selSaleState);
		}
		return "suc";
	}
	
	static public  Map initState(Map selSaleState){
		selSaleState.put(ContUnitSaleState.SALE_ABLE, ContUnitSaleState.getSaleState().get(ContUnitSaleState.SALE_ABLE));
		selSaleState.put(ContUnitSaleState.RESERVE, ContUnitSaleState.getSaleState().get(ContUnitSaleState.RESERVE));
		selSaleState.put(ContUnitSaleState.FROZEN, ContUnitSaleState.getSaleState().get(ContUnitSaleState.FROZEN));
		selSaleState.put(ContUnitSaleState.IS_SALE, ContUnitSaleState.getSaleState().get(ContUnitSaleState.IS_SALE));
		selSaleState.put(ContUnitSaleState.NOT_FOR_SALE, ContUnitSaleState.getSaleState().get(ContUnitSaleState.NOT_FOR_SALE));
		return selSaleState;
	}
	
	private boolean isSale(PropertyUnit unit){
		return unit.isSale();
	}
	
	/**
	 * 提交表单 -- 修改一个单元
	 * @param unitId 单元ID
	 * */
	public String  updateOneUnitForm(){
		initsel();
		PropertyBuild tbu = iPropertyBuildServices.findPropertyBuildById(buildId);
		topText = tbu.getBuildName() +"  >>>   "  + this.iPropertyUnitServices.findPropertyUnitById(unitId).getUnitNo();
		path = GuangZhouNewInitOneUnit.PATH_UP_ONE;
		//init(this.initUnit);
		PropertyUnit tunit = iPropertyUnitServices.findPropertyUnitById(this.unitId);
		
		if(isSale(tunit) && SessionUser.getUserId() != 2){
			
			tip = "已销售单元,信息不能修改";
			this.initUnit = tunit;
			return "suc";
		}
		
		//大于等于认筹4就不能修改
		
//		if(! this.isInt(this.initUnit.getRoomNo())){
//			tip = "单元号错误!";
//			return "suc";
//		}
		
		//dtc 2013.11.21 
		
		/*if(isSale(tunit)){
			tip = "只能修改单元状态为,预留,冻结,可售";
			this.initUnit = tunit;
			return "suc";
		}else{
			tunit.setSaleState(this.initUnit.getSaleState());
		}
		*/
		
		tunit.setSaleState(this.initUnit.getSaleState());
		
		tunit.setUnitNo(this.initUnit.getUnitNo());
		tunit.setRoomNo(this.initUnit.getRoomNo());
		tunit.setFloorNum(this.initUnit.getFloorNum());
		tunit.setBuildArea(this.initUnit.getBuildArea());
		tunit.setInsideArea(this.initUnit.getInsideArea());
		tunit.setBuildPrice(this.initUnit.getBuildPrice());
		tunit.setInsidePrice(this.initUnit.getInsidePrice());
		tunit.setSumPrice(this.initUnit.getSumPrice());
		tunit.setRealPublicArea(this.initUnit.getRealPublicArea());
		tunit.setPublicArea(this.initUnit.getPublicArea());
		tunit.setRoomType(this.initUnit.getRoomType());
		tunit.setOrientation(this.initUnit.getOrientation());
		tunit.setPriceWay(this.initUnit.getPriceWay());
		tunit.setProductType(this.initUnit.getProductType());
		tunit.setModId(SessionUser.getUserId());
		tunit.setModTime(new Date());
		tunit.setRenovateDesc(this.initUnit.getRenovateDesc());
		tunit.setRenovateMoney(this.initUnit.getRenovateMoney());
		tunit.setRenovatePrice(this.initUnit.getRenovatePrice());
		tunit.setRemark(this.initUnit.getRemark());
		tunit.setScenery(this.initUnit.getScenery());
		tunit.setRoomNum(this.initUnit.getRoomNum());
		tunit.setHallNum(this.initUnit.getHallNum());
		tunit.setToiletNum(this.initUnit.getToiletNum());
		
		tunit.setSaleTime(this.initUnit.getSaleTime());
		
//		if(!mathPrice(tunit)){
		mathPrice(tunit);
			tip = "数据不完整 无法自动计算";
//			return "suc";
//		}
		this.iPropertyUnitServices.updatePropertyUnit(tunit);
		this.initUnit = tunit;
		tip = "修改成功!";
		selSaleState.clear();
		initState(selSaleState);
		
		setUpMarkToClose();
		
		return "suc";
	}
	
	private void initsel(){
	//	System.out.println(SessionUser.getProjectId());
	//	selOrientation = DescUtils.getInitSelForProjectText(selOrientation,EnumTextTypeName.TEXT_UNIT_ORIENTATION,true);
		selOrientation = DescUtils.getInitSelForGuangZhou(selOrientation, EnumCodeTypeName.PROPERTY_ORIENTATION,true);
		selRoomType = DescUtils.getInitSelForGuangZhou(selRoomType,EnumCodeTypeName.PROPERTY_ROOM_TYPE,true);
		selProductType = DescUtils.getInitSelForGuangZhou(selProductType,EnumCodeTypeName.PROPERTY_PRODUCT_TYPE,true);
		selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay,EnumCodeTypeName.PROPERTY_PRICE_WAY);
		selSaleState = DescUtils.getInitSelForGuangZhou(selSaleState,EnumCodeTypeName.PROPERTY_SALE_STATE);
		
		//2012-10-23 房间 厅 卫 
		selRoomNum = new LinkedHashMap<String, String>();
		selhallNum = new LinkedHashMap<String, String>();
		seltoiletNum = new LinkedHashMap<String, String>();
		for(int i = 0 ; i < 10 ; i ++){
			selRoomNum.put(i, i);
			selhallNum.put(i, i);
			seltoiletNum.put(i, i);
		}
	}
	
	
	/***
	 * 查找单元是否重复  这里是指物理空间重复  单元号 +楼层相等 
	 * */
	private boolean haveSameUnit(PropertyUnit checkUnit){
		PropertyUnitCond cond = new PropertyUnitCond();
		cond.setFloorNum(checkUnit.getFloorNum()+"");
		
		
		return false;
	}
	
	private boolean isInt(String textStr){
		try {
			Integer.parseInt(textStr);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	private List<String> trList; //房间的tr
	/**
	 * 批量修改单元 2012-11-05  jira:HDXMXSGLXT-633 HDXMXSGLXT-635
	 * @param buildId 选择的楼栋ID 必须有的
	 * */
	public String updateSomeUnit(){
		List<PropertyUnit> unitList;
		PropertyUnitCond cond = new PropertyUnitCond();
		cond.setBuildId(this.buildId+"");
		unitList = this.iPropertyUnitServices.findPropertyUnit(cond);
		trList = BuildUnitUtils.initUnitMap(unitList,new PropertyBuild());
		trList.remove(0);
		selSaleState = new LinkedHashMap<String, String>();
		initState(selSaleState);
		return "suc";
	}
	
	private String uids;
	public String delSomeUnit() throws IOException{
		String res = "true";
		if(uids == null || uids.equals("") || uids.equals("'"))CustomerUtils.writeResponse(response, "false");
		
		try{			
			new MyTransationTemplate() {
				@Override
				protected void doExecuteCallback() throws Exception {
					Date now = new Date();
					String delids[] = uids.split(",");
					if(delids.length == 0){
						throw new Exception();
					}
					for(String did : delids){
						PropertyUnit uu = iPropertyUnitServices.findPropertyUnitById(Integer.parseInt(did));
						if( Integer.parseInt(uu.getSaleState()) != 2){
							throw new Exception();
						}
						iPropertyUnitServices.deletePropertyUnit(Integer.parseInt(did));
					}
				}
			}.execute();
		}catch(Exception e){
			res = "false";
		}
		CustomerUtils.writeResponse(response,res);
		return null;
	}
	private int updateState;
	public String updateSaleStateBySomeUnitIds()throws IOException{
		String res = "true";
		if(uids == null || uids.equals("") || uids.equals("'"))
			CustomerUtils.writeResponse(response, "false");
		try{			
			new MyTransationTemplate() {
				@Override
				protected void doExecuteCallback() throws Exception {
					Date now = new Date();
					String delids[] = uids.split(",");
					if(delids.length == 0){
						throw new Exception();
					}
					for(String did : delids){
						PropertyUnit uu = iPropertyUnitServices.findPropertyUnitById(Integer.parseInt(did));
						if( Integer.parseInt(uu.getSaleState()) > 3 && Integer.parseInt(uu.getSaleState()) < 17){
							throw new Exception();
						}
//						uu.setSaleState(updateState+"");
//						uu.setModId(SessionUser.getUserId());
//						uu.setModTime(now);
//						iPropertyUnitServices.updatePropertyUnit(uu);
						Map<String, String> map = new HashMap<String, String>();
						map.put("saleState", updateState+"");
						map.put("id", uu.getId()+"");
						map.put("modTime", now.toLocaleString());
						iPropertyUnitServices.updatePropertyUnitSaleState(map);
					}
				}
			}.execute();
		}catch(Exception e){
			res = "false";
		}
		CustomerUtils.writeResponse(response,res);
		
		return null;
	}
	
	
	
	public int getUpdateState() {
		return updateState;
	}

	public void setUpdateState(int updateState) {
		this.updateState = updateState;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public PropertyUnit getInitUnit() {
		return initUnit;
	}

	public LinkedHashMap getSelOrientation() {
		return selOrientation;
	}

	public void setSelOrientation(LinkedHashMap selOrientation) {
		this.selOrientation = selOrientation;
	}

	public LinkedHashMap getSelRoomType() {
		return selRoomType;
	}

	public void setSelRoomType(LinkedHashMap selRoomType) {
		this.selRoomType = selRoomType;
	}

	public void setInitUnit(PropertyUnit initUnit) {
		this.initUnit = initUnit;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTopText() {
		return topText;
	}

	public void setTopText(String topText) {
		this.topText = topText;
	}

	public String getSelectuid() {
		return selectuid;
	}

	public void setSelectuid(String selectuid) {
		this.selectuid = selectuid;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public LinkedHashMap getSelProductType() {
		return selProductType;
	}

	public void setSelProductType(LinkedHashMap selProductType) {
		this.selProductType = selProductType;
	}

	public LinkedHashMap getSelPriceWay() {
		return selPriceWay;
	}

	public void setSelPriceWay(LinkedHashMap selPriceWay) {
		this.selPriceWay = selPriceWay;
	}

	public LinkedHashMap getSelSaleState() {
		return selSaleState;
	}

	public void setSelSaleState(LinkedHashMap selSaleState) {
		this.selSaleState = selSaleState;
	}

	public LinkedHashMap getSelRoomNum() {
		return selRoomNum;
	}

	public void setSelRoomNum(LinkedHashMap selRoomNum) {
		this.selRoomNum = selRoomNum;
	}

	public LinkedHashMap getSelhallNum() {
		return selhallNum;
	}

	public void setSelhallNum(LinkedHashMap selhallNum) {
		this.selhallNum = selhallNum;
	}

	public LinkedHashMap getSeltoiletNum() {
		return seltoiletNum;
	}

	public void setSeltoiletNum(LinkedHashMap seltoiletNum) {
		this.seltoiletNum = seltoiletNum;
	}

	public List<String> getTrList() {
		return trList;
	}

	public void setTrList(List<String> trList) {
		this.trList = trList;
	}

	public String getUids() {
		return uids;
	}

	public void setUids(String uids) {
		this.uids = uids;
	}

	
	
	

}
