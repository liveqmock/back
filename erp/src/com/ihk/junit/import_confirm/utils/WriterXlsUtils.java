package com.ihk.junit.import_confirm.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;

/**
 * 写帮助类
 * @author dtc
 * 2013-9-30,上午09:34:05
 */
public class WriterXlsUtils {
	
	/**
	 * 根据单元格输出xls
	 * @param cellList
	 * @param fileName
	 * @throws Exception
	 */
	public static void writerXls(List<Cell[]> cellList, String fileName) throws Exception{
		
		OutputStream out = null;
		
		try{
			
			long start = System.currentTimeMillis();
			
			File file = new File(fileName);
			out = new FileOutputStream(file);
	        fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
	        
	        String content = cellListToContent(cellList);
	        byte[] b = content.getBytes("utf-8");
	        
	        out.write(b);
			
			out.flush();
			
			long end = System.currentTimeMillis();
			
			System.out.println(CustomerUtils.getNowForString() + " " + CustomerUtils.getNowTimeForString() + " '" + 
					fileName + "'下载所花的时间为: " + (end - start)/1000 + "s");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if(out != null){
				out.close();
			}
		}
		
	}
	
	/**
	 * 根据单元格的内容返回table String
	 * @param cellList
	 * @return
	 */
	private static String cellListToContent(List<Cell[]> cellList){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<table border='1'>");
		
		if(!CommonUtils.isCollectionEmpty(cellList)){
			
			for(Cell[] cells : cellList){
				
				sb.append("<tr>");
				
				for(Cell cell : cells){
					
					String contents = "";
					
					if(cell.getType() == CellType.DATE){
						//如果为日期格式
						
						DateCell dc = (DateCell)cell;
						
						Date date = dc.getDate();
						SimpleDateFormat ds = new SimpleDateFormat("yyyy/MM/dd");
						contents = ds.format(date);
						
					}else{
						
						contents = cell.getContents().trim();
					}
					
					sb.append("<td>'").append(contents).append("</td>");
				}
				
				sb.append("</tr>");
			}
			
		}
		
		sb.append("</table>");
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		
		String file = "C:\\contract\\contact_template.xls";
		
		List<Cell[]> cellList = RealXlsUtils.realXls(file);
		
		writerXls(cellList, "C:\\contract\\contact_template2.xls");
		
	}

}
