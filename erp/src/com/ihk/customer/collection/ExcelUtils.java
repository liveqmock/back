package com.ihk.customer.collection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;

/**
 * Excel工具类
 *
 */
@SuppressWarnings("unused")
public class ExcelUtils {

	private static Logger logger = Logger.getLogger(ExcelUtils.class);
	
	@SuppressWarnings("rawtypes")
	public static void main(String args[]){
		Workbook wb=readExcel("D://test.xls");
		List<Map> list = excelToMapList(wb.getSheetAt(0),1,1000);
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).get("移动电话").getClass());
		}
	}
	
	/*
	 * maxlength读取excel行数的上限 startRow开始读取的行数
	 * 用于读取excel表中从startRow行到maxlength行的数据
	*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Map> excelToMapList(Sheet sheet, int startRow, int maxLength){
		List<Map> list = new ArrayList();
		Row firstrow = sheet.getRow(0); 
		
		//行数不能超过excel最大行
		int maxSize = sheet.getLastRowNum();
		if((startRow+maxLength-1) < sheet.getLastRowNum())
			maxSize = startRow+maxLength-1;
		//遍历行
		 for (int j = startRow; j <= maxSize; j++) {  
			 Row row = sheet.getRow(j);
			 Map map = new HashMap();
             //遍历列  
             for (int k = 0; k < row.getLastCellNum(); k++) {
            	 Cell cell = row.getCell(k);
                 String key= firstrow.getCell(k).getRichStringCellValue().getString();  
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
                     map.put(key,"");  
                 }  
             } 
             list.add(map); 
		 }
		return list;
	}
	
	public  static Workbook readExcel(String filePathName){  
        InputStream inp = null;  
        Workbook wb=null;  
         try {  
            inp = new FileInputStream(filePathName);  
            wb = WorkbookFactory.create(inp);  
            inp.close();  
        } catch (Exception e) {  
            try {  
                if(null!=inp){  
                    inp.close();  
                }  
            } catch (IOException e1) {  
                e1.printStackTrace();  
            }  
            e.printStackTrace();  
        }  
         return wb;  
    }
}
