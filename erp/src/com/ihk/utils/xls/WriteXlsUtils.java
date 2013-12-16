package com.ihk.utils.xls;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.ihk.utils.CommonUtils;

/**
 * 生成xls帮助类
 * @author dtc
 * 2013-12-5,上午11:47:31
 */
public class WriteXlsUtils {
	
	/**
	 * 利用jxl直接生成xls文档,
	 * @param pojoList
	 * @param fileName 输出的文件名
	 * @param cols 列总数,包括异常列
	 * @param response
	 * @throws Exception
	 */
	public static void writerExceptionXlsByJxl(List<WriteExceptionDataPojo> pojoList, String fileName, 
			int cols, HttpServletResponse response) throws Exception {
		
		if(CommonUtils.isCollectionEmpty(pojoList) || CommonUtils.isStrEmpty(fileName)){
			throw new Exception("数据为空或者文件名为空");
		}
		
		WritableWorkbook wwb = null;
		OutputStream out = null;

		try{
			
			out = response.getOutputStream();// 取得输出流   
	        response.reset();// 清空输出流   
	        fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
	        response.setHeader("Content-disposition", "attachment; filename=" +  fileName);// 设定输出文件头   
	        response.setContentType("application/msexcel");// 定义输出类型  
			
			wwb = Workbook.createWorkbook(out);
			WritableSheet ws = wwb.createSheet("异常数据", 1); // 创建一个工作表

			int rows = pojoList.size(); //行总数
			
			Label label = null;
			
			for (int c = 0; c < cols; c++) {
				
				for(int r = 0; r < rows; r++){
					
					label = initLabel(c, r, pojoList, cols-1);
					
					if(label != null){
						ws.addCell(label);
					}
					
				}
			}

			wwb.write();
			out.flush();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			
			if(wwb != null){
				wwb.close();
			}
			
			if(out != null){
				out.close();
			}
		}
	}
	
	/**
	 * 返回Label, jxl.write.Label.Label(int c, int r, String cont)<br/>
	 * 返回null表示该行数据有问题
	 * @param col
	 * @param row
	 * @param pojoList
	 * @param contentsColSize,非异常信息的列数
	 * @return
	 */
	private static Label initLabel(int col, int row, List<WriteExceptionDataPojo> pojoList, int contentsColSize){
		
		try{
		
			String data = "";
			
			WriteExceptionDataPojo pojo = pojoList.get(row); //对应行的数据
			
			//再获取对应的列,组成单元格的数据
			if(col < contentsColSize){
				
				data = pojo.getCell()[col].getContents();
				if(!CommonUtils.isStrEmpty(data)){
					
					data = data.trim();
				}
				
			}else{
				
				data = pojo.getExceptionData();
			}
			
			return new Label(col, row, data); // jxl.write.Label.Label(int c, int r, String cont)
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
		}
	}

}
