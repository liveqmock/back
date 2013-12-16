package com.ihk.saleunit.action.contract_unit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.collection.XLSExport;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.saleunitnew.PropertyUnitUtils;

public class BasePriceManagerAction extends SupperAction{

	@Autowired 
	ICompanyProjectServices companyProjectServices;
	@Autowired
	IPropertyUnitServices propertyUnitServices;
	@Autowired
	IPropertyBuildServices propertyBuildServices;
	Map buildMap;
	

	public Map getBuildMap() {
		return buildMap;
	}

	public void setBuildMap(Map buildMap) {
		this.buildMap = buildMap;
	}

	@SuppressWarnings("unchecked")
	public String basePriceManager() throws Exception {
		
		List<PropertyBuild> tmpList = ContractCustomerUtils.getBuildListByRequest(request);
		buildMap = PropertyUnitUtils.buildListToMap(tmpList);
		buildMap.remove("");
		return "suc";
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
	@SuppressWarnings("unchecked")
	public InputStream getDownloadFile() {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PropertyUnitCond cond = new PropertyUnitCond();
		cond.setBuildId(request.getParameter("buildId"));
		List<PropertyUnit> list = propertyUnitServices.findPropertyUnit(cond);
		try{
			Map<String,String> mp = new LinkedHashMap<String,String>(){{
				put("xl1", "系统单元ID");
				put("xl2", "房间号");
				put("xl3", "状态");
				/*put("xl4", "客户姓名");
				put("xl5", "认购日期");
				put("xl6", "签约日期");*/
				put("xl7", "建筑面积");
				put("xl8", "建筑单价");
				put("xl9", "标准总价");
				put("xl10", "单价(底价)");
				put("xl11", "总价(底价)");
			}};
			List<Map> lstMp = new ArrayList();
			for(int i=0;i < list.size();i ++) {
				Map e = new HashMap();
				e.put("xl1",String.valueOf(list.get(i).getId()));
				e.put("xl2",list.get(i).getUnitNo());
				e.put("xl3",list.get(i).getSaleStateStr());
				if(list.get(i).getBuildArea() == null)
					e.put("xl7","");
				else
					e.put("xl7",list.get(i).getBuildArea().toString());
				if(list.get(i).getBuildPrice() == null)
					e.put("xl8","");
				else
					e.put("xl8",list.get(i).getBuildPrice().toString());
				if(list.get(i).getSumPrice() == null)
					e.put("xl9","");
				else
					e.put("xl9",list.get(i).getSumPrice().toString());

				if(list.get(i).getBaseprice() == null)
					e.put("xl10","");
				else
					e.put("xl10",list.get(i).getBaseprice().toString());
				if(list.get(i).getTotalBaseprice() == null)
					e.put("xl11","");
				else
					e.put("xl11",list.get(i).getTotalBaseprice().toString());
				lstMp.add(e);
			}
			
			XLSExport.exportExcel(mp, lstMp).write(baos);
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
	 * 模板下载
	 */
	public String excelDownLoad() throws Exception {
		
		return SUCCESS;
	}
	
	/**
	 * 上传录入好的模板
	 */
	public String excelUpload() throws Exception {
		
		FileInputStream is = null;
		Workbook wb=null; 
		int rowFlag = 0;
		if(upload == null)
			return "fail";
		
		is = new FileInputStream(upload); 
		wb = WorkbookFactory.create(is);
		Sheet sheet = wb.getSheetAt(0);
		int maxSize = sheet.getLastRowNum();
        for(int j = 1;j <= maxSize; j++){
            Row row = sheet.getRow(j);
            Map map = new HashMap();
            rowFlag = j;
            for (int k = 0; k < row.getLastCellNum(); k++) {
                Cell cell = row.getCell(k);
                String key= sheet.getRow(0).getCell(k).getRichStringCellValue().getString();
                if(cell != null)
                {
                    switch (cell.getCellType()) {
                        //字符串
                        case Cell.CELL_TYPE_STRING:
                            map.put(key, cell.getRichStringCellValue().getString());
                            break;
                        //数字
                        case Cell.CELL_TYPE_NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                map.put(key, cell.getDateCellValue());
                            } else {
                                map.put(key, cell.getNumericCellValue());
                            }
                            break;
                        //boolean
                        case Cell.CELL_TYPE_BOOLEAN:
                            map.put(key, cell.getBooleanCellValue());
                            break;
                        //方程式
                        case Cell.CELL_TYPE_FORMULA:
                            map.put(key, cell.getCellFormula());
                            break;
                        //空值
                        default:
                            map.put(key, "");
                    }
                }

            }
            ToUpdatePropertyUnit(map);
        }

        return "suc";
	}
	
	
	private void ToUpdatePropertyUnit(Map map) {
		PropertyUnit unit = propertyUnitServices.findPropertyUnitById(Integer.parseInt(String.valueOf(map.get("系统单元ID"))));

        //已售单元不允许修改底价
        if(Integer.parseInt(unit.getSaleState())<8){
            unit.setTotalBaseprice(new BigDecimal(String.valueOf(map.get("总价(底价)"))));
            unit.setBaseprice(new BigDecimal(String.valueOf(map.get("单价(底价)"))));
            propertyUnitServices.updatePropertyUnit(unit);
        }
	}
	
	private File upload; 				//上传的文件
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	private List<PropertyUnit> unitList;
	
	public List<PropertyUnit> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<PropertyUnit> unitList) {
		this.unitList = unitList;
	}


}
