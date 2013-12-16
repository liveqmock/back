package com.ihk.saleunit.action.new_init;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.MakeBuildPrice;
import com.ihk.saleunit.data.pojo.MakeBuildPriceDetail;
import com.ihk.saleunit.data.services.IMakeBuildPriceDetailServices;
import com.ihk.saleunit.data.services.IMakeBuildPriceServices;
import com.ihk.utils.ActionMethodModifyUtils;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;


/**
 * 楼盘初始 价格管理
 * @author Administrator
 *
 */
public class GuangZhouNewInitPriceExcelAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	
	private String fileName;//下载文件名字
	private String buildId;//要选择哪一个楼栋
	
	@Autowired IMakeBuildPriceServices makeBuildPriceServices;
	@Autowired IMakeBuildPriceDetailServices makeBuildPriceDetailServices;
	@Autowired IPropertyUnitServices propertyUnitServices;
	@Autowired IPropertyBuildServices propertyBuildServices;
	@Autowired IPropertyAreaServices propertyAreaServices;
	/**
	 * 下载单元资料
	 * */
	public String loadExcel(){
		List<PropertyUnit> tempUnitList = new ArrayList<PropertyUnit>();
		String fileName = "";
		PropertyBuild build = propertyBuildServices.findPropertyBuildById(Integer.parseInt(buildId));
		fileName =  build.getBuildName();
		PropertyArea area = propertyAreaServices.findPropertyAreaById(build.getAreaId());
		fileName = area.getAreaName() +"-"+ fileName+"-";
		PropertyUnitCond cond = new PropertyUnitCond();
		cond.setBuildId(buildId);
		tempUnitList = propertyUnitServices.findPropertyUnit(cond);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("unitList", tempUnitList);
		
		try {
			ReportUtils.downLoadReport(map, "initUnit.xls", fileName + CustomerUtils.getNowForString() + "-.xls", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String upLoadExcelDIalog(){
		this.tips = "";
		return "suc";
	}
	
	private String tips;
	private String closeBody;
	private File xlsFile;
	private String xlsFileFileName;
	private String remark;
	private Map<String,List<Integer>> tipsMap; 
	
	/**
	 * 上传模板
	 * 2012/09/21 如果输入总价 则已总价为基准计算单价   
	 * 如果没有输入总价 则根据计价方式选择的 建筑/面积 为基准计算 总价(just)
	 * 
	 * */
	public String upLoadExcel(){
		
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					String url="";
					//	String url = UploadUtils.uploadFile(xlsFile,getXlsFileFileName());
						InputStream is = new FileInputStream(xlsFile);
						
						WorkbookSettings ws = new WorkbookSettings();
						ws.setCellValidationDisabled(true);
						Workbook book = Workbook.getWorkbook(is,ws);
						//Workbook book = Workbook.getWorkbook(is);
						Sheet she = book.getSheet("Sheet1");
						int row = she.getRows();
						if(row > 1){
							//先进行验证 要所有的UNIT ID 都符合才对
							//一个list 数据库 unitid 一个list 上传模板unit list 配对消减
							//1 list 剩下的就是 缺少的 unit 2list剩下的就是错误的unit id 
							//没有剩下 就是验证成功
							
							//得到数据库list
							List<PropertyUnit> list1 = propertyUnitServices.findPropertyUnit(new PropertyUnitCond().setBuildId(getBuildId()));
							List<Integer> list2 = new ArrayList<Integer>();
							for(int i = 1 ; i < row; i++){
								String uid = she.getCell(0,i).getContents();
								if(uid == null || uid.trim().equals(""))break;
								list2.add(Integer.parseInt(uid));
							}
							Map<String,List<Integer>> erroMap =  initList(list1,list2);
							if(erroMap != null){
								tips = "单元出现错误!";
							}
							//验证结束
							MakeBuildPrice mbp = new MakeBuildPrice();
							mbp.setFileSrc(url);
							mbp.setRemark(getRemark());
							mbp.setBuildId(Integer.parseInt(getBuildId()));
							mbp.setIsEffect(MakeBuildPrice.IS_DEFFECT_NO);
							CommonPojoUtils.initPojoCommonFiled(mbp);
							
							makeBuildPriceServices.addMakeBuildPrice(mbp);
							
							
							for(int i = 1 ; i < row; i++){
									String unitid = she.getCell(0,i ).getContents();//unit id
									if(unitid == null || unitid.trim().equals(""))break;
									
									PropertyUnit tpUnit = propertyUnitServices.findPropertyUnitById(Integer.parseInt(unitid));//找到需要修改的UNIT
									if(tpUnit!=null&&!"2".equals(tpUnit.getSaleState())){
										continue;
									}
									String insidePrice = she.getCell(6,i ).getContents();
									String buildPrice = she.getCell(7,i ).getContents();
									
									insidePrice = insidePrice == null || insidePrice.trim().equals("") ?  "0" : insidePrice;
									buildPrice = buildPrice == null || buildPrice.trim().equals("")? "0" : buildPrice;
									
									
									String insideAreaStr = she.getCell(4,i ).getContents();
									String buildAreaStr = she.getCell(5,i ).getContents();
									insideAreaStr = insideAreaStr == null || insideAreaStr.trim().equals("") ?  "0" : insideAreaStr;
									buildAreaStr = buildAreaStr == null || buildAreaStr.trim().equals("")? "0" : buildAreaStr;
									
									BigDecimal uinsideArea = new BigDecimal( CommonUtils.excelNumberFormat(insideAreaStr));
									BigDecimal ubuildArea = new BigDecimal( CommonUtils.excelNumberFormat(buildAreaStr));
									
//									BigDecimal uinsiArea = tpUnit.getInsideArea()  == null ? new BigDecimal(0) : tpUnit.getInsideArea() ;
//									BigDecimal ubuilArea = tpUnit.getBuildArea()  == null ? new BigDecimal(0) : tpUnit.getBuildArea() ;
									
									
									String priceWay = she.getCell(11,i ).getContents();
									
									MakeBuildPriceDetail mbpd = new MakeBuildPriceDetail();
									
									mbpd.setMakeId(mbp.getId());//外键
									
									mbpd.setBuildPrice(new BigDecimal(CommonUtils.excelNumberFormat(buildPrice)));//单价
									mbpd.setInsidePrice(new BigDecimal(CommonUtils.excelNumberFormat(insidePrice)));
									
									mbpd.setUnitId(Integer.parseInt(unitid));//单元
									
									mbpd.setBuildArea(ubuildArea);//室内 建筑 面积
									mbpd.setInsideArea(uinsideArea);
									
									String orientation = she.getCell(8,i ).getContents();//朝向
									mbpd.setOrientation("".equals(orientation)?null:getOrientationChar(orientation));
									
//									String roomType = she.getCell(9,i ).getContents();//房间结构
//									mbpd.setRoomType(this.getRoomTypeChar(roomType));
									
									String productType = she.getCell(10,i ).getContents();//产品类型
									mbpd.setProductType("".equals(productType)?null:getProductTypeChar(productType));
									
									String renovateDesc = she.getCell(12,i ).getContents();//装修标准
									mbpd.setRenovateDesc(renovateDesc);
									
									String renovatePrice = she.getCell(13,i ).getContents();//装修单价
									renovatePrice = renovatePrice == null || renovatePrice.trim().equals("")? "0" : renovatePrice;
									mbpd.setRenovatePrice(new BigDecimal(CommonUtils.excelNumberFormat(renovatePrice)));
									
									String renovateMoney = she.getCell(14,i ).getContents();//装修款
									renovateMoney = renovateMoney == null || renovateMoney.trim().equals("")? "0" : renovateMoney;
									mbpd.setRenovateMoney(new BigDecimal(CommonUtils.excelNumberFormat(renovateMoney)));
									
									String scenery = she.getCell(15,i ).getContents();//景观
									mbpd.setScenery(scenery);
									
									String remark = she.getCell(16,i ).getContents();//备注
									mbpd.setRemark(remark);
									
									String sumPrice = she.getCell(9,i ).getContents();//标准总价
									
									String roomNum = she.getCell(17,i ).getContents();//房间数
									try {
										mbpd.setRoomNum(Integer.parseInt(roomNum));
									} catch (Exception e) {
										mbpd.setRoomNum(0);
									}
									String hallNum = she.getCell(18,i ).getContents();//厅数
									try {
										mbpd.setHallNum(Integer.parseInt(hallNum));
									} catch (Exception e) {
										mbpd.setHallNum(0);
									}
									String toiletNum = she.getCell(19,i ).getContents();//卫数
									//String toiletNum = "1";
									try {
										mbpd.setToiletNum(Integer.parseInt(toiletNum));
									} catch (Exception e) {
										mbpd.setToiletNum(0);
									}
									
									if(sumPrice == null || sumPrice.trim().equals("") ||  sumPrice.trim().equals("0")||  sumPrice.trim().equals("0.00")){
										if(priceWay.equals(MakeBuildPriceDetail.SUM_TYPE_INSIDE)){//总价  计价方式
											mbpd.setSumPrice( mbpd.getInsidePrice().multiply( uinsideArea  ) );
											mbpd.setPriceWay(getPriceWayChar(priceWay));
										}else if(priceWay.equals(MakeBuildPriceDetail.SUM_TYPE_BUILD)){
											mbpd.setSumPrice(mbpd.getBuildPrice().multiply(ubuildArea) );
											mbpd.setPriceWay(getPriceWayChar(priceWay));
										}
//										else{//默认建筑单价
//											mbpd.setSumPrice(mbpd.getBuildPrice().multiply(ubuildArea) );
//											mbpd.setPriceWay(this.getPriceWayChar(priceWay));
//										}
									}else{
										BigDecimal sumPriceBig = new BigDecimal(CommonUtils.excelNumberFormat(sumPrice));
										if(mbpd.getBuildArea().toString().trim().equals("0")){
											mbpd.setBuildPrice(new BigDecimal(0));
										}else{
											mbpd.setBuildPrice(sumPriceBig.divide(mbpd.getBuildArea(),RoundingMode.HALF_UP));
										}
										
										if(mbpd.getInsideArea().toString().trim().equals("0")){
											mbpd.setInsidePrice(new BigDecimal(0));
										}else{
											mbpd.setInsidePrice(sumPriceBig.divide(mbpd.getInsideArea(),RoundingMode.HALF_UP));
										}
										mbpd.setSumPrice(sumPriceBig);
										mbpd.setPriceWay(getPriceWayChar(priceWay));
									}
									 
									
									
									CommonPojoUtils.initPojoCommonFiled(mbpd);
									
									makeBuildPriceDetailServices.addMakeBuildPriceDetail(mbpd);
							}
						}
						
						book.close();
						is.close();
						tips = "上传成功,自动忽略已成交和已签约单元的修改!";
				}
			}.execute();
		} catch (Exception e) {
			tips = "模板数据出现错误,请不要修改模板的结构和数据类型!";
			e.printStackTrace();
		}
		
		return "suc";
	}
	
	/**
	 * list1 数据库unit
	 * list2 模板unit
	 * @throws Exception 
	 * */
	private Map<String,List<Integer>> initList(List<PropertyUnit> list1, List<Integer> list2) throws Exception{
		if(list1 == null || list2 == null){
			throw new Exception();
		}
		List<Integer> tplist1 = new ArrayList<Integer>();
		for(PropertyUnit u : list1){
			tplist1.add(u.getId());
		}
		
		for(int i = 0;i<tplist1.size();i++){
			int list1tmint = tplist1.get(i);
			for(int j = 0;j<list2.size();j++){
				if(list2.get(j) == list1tmint){
					tplist1.remove(i);
					list2.remove(j);
					i--;j--;
					break;
				}
			}
		}
		
		if(tplist1.size() == 0 && list2.size() == 0)
		return null;
		else{
			Map<String,List<Integer>> res = new HashMap<String, List<Integer>>();
			res.put("dbUnitId", tplist1);
			res.put("xlsUnitId", list2);
			return res;
		}
		
	}
	
	private LinkedHashMap selOrientation;
	private LinkedHashMap selRoomType;
	private LinkedHashMap selProductType;
	private LinkedHashMap selPriceWay;
	private String getPriceWayChar(String showVal){
		if(selPriceWay ==null)
		selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay,EnumCodeTypeName.PROPERTY_PRICE_WAY,true);
		Iterator iterator = selPriceWay.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next().toString();
			String val = selPriceWay.get(key).toString();
			if(val.equals(showVal)){
				return key;
			}
		}
		return "";
	}
	
	private String getRoomTypeChar(String showVal){
		if(selRoomType ==null)
		selRoomType = DescUtils.getInitSelForGuangZhou(selRoomType,EnumCodeTypeName.PROPERTY_ROOM_TYPE,true);
		Iterator iterator = selRoomType.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next().toString();
			String val = selRoomType.get(key).toString();
			if(val.equals(showVal)){
				return key;
			}
		}
		return "1";
	}
	
	private String getProductTypeChar(String showVal){
		if(selProductType ==null)
		selProductType = DescUtils.getInitSelForGuangZhou(selProductType,EnumCodeTypeName.PROPERTY_PRODUCT_TYPE,true);
		Iterator iterator = selProductType.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next().toString();
			String val = selProductType.get(key).toString();
			if(val.equals(showVal)){
				return key;
			}
		}
		return "1";
	}
	
	private String getOrientationChar(String showVal){
		if(selOrientation ==null)
		selOrientation = DescUtils.getInitSelForGuangZhou(selOrientation, EnumCodeTypeName.PROPERTY_ORIENTATION,true);
		Iterator iterator = selOrientation.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next().toString();
			String val = selOrientation.get(key).toString();
			if(val.equals(showVal)){
				return key;
			}
		}
		return "1";
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getBuildId() {
		return buildId;
	}
	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}
	public File getXlsFile() {
		return xlsFile;
	}
	public void setXlsFile(File xlsFile) {
		this.xlsFile = xlsFile;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getCloseBody() {
		return closeBody;
	}

	public void setCloseBody(String closeBody) {
		this.closeBody = closeBody;
	}

	public String getXlsFileFileName() {
		return xlsFileFileName;
	}

	public void setXlsFileFileName(String xlsFileFileName) {
		this.xlsFileFileName = xlsFileFileName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Map<String, List<Integer>> getTipsMap() {
		return tipsMap;
	}
	
	
	
	
}
