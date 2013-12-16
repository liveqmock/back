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
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;

/**
 * 根据异常数据的生成异常文档
 * @author dtc 2013-10-9,下午02:44:14
 */
public class ExceptionDataUtils {
	
	/**
	 * 利用jxl直接生成xls文档,
	 * @param pojoList
	 * @param fileName
	 * @param cols 列总数,包括异常列
	 * @throws Exception
	 */
	public static void writerXlsByJxl(List<ExceptionDataPojo> pojoList, String fileName, int cols) throws Exception {
		
		if(CommonUtils.isCollectionEmpty(pojoList) || CommonUtils.isStrEmpty(fileName)){
			throw new Exception("数据为空或者文件名为空");
		}
		
		int size = pojoList.size();
		if(size <= 1){
			return ;
		}
		
		WritableWorkbook wwb = null;

		try{
			
			FileOutputStream fos = new FileOutputStream(fileName);
			wwb = Workbook.createWorkbook(fos);
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
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			
			if(wwb != null){
				wwb.close();
			}
		}
	}
	
	/**
	 * 返回Label, jxl.write.Label.Label(int c, int r, String cont)
	 * @param col
	 * @param row
	 * @param pojoList
	 * @param contentsColSize,非异常信息的列数
	 * @return
	 */
	private static Label initLabel(int col, int row, List<ExceptionDataPojo> pojoList, int contentsColSize){
		
		try{
		
			String data = "";
			
			ExceptionDataPojo pojo = pojoList.get(row); //对应行的数据
			
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

	/**
	 * 输出异常数据(字符串的形式)
	 * @param pojoList
	 * @param fileName
	 * @throws Exception
	 */
	public static void writerXlsString(List<ExceptionDataPojo> pojoList, String fileName) throws Exception {

		OutputStream out = null;

		try {

			long start = System.currentTimeMillis();

			File file = new File(fileName);
			out = new FileOutputStream(file);
			fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");

			String content = pojoListToContent(pojoList);
			byte[] b = content.getBytes("utf-8");

			out.write(b);

			out.flush();

			long end = System.currentTimeMillis();

			System.out.println(CustomerUtils.getNowForString() + " "
					+ CustomerUtils.getNowTimeForString() + " '" + fileName
					+ "'下载所花的时间为: " + (end - start) / 1000 + "s");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			if (out != null) {
				out.close();
			}
		}

	}

	/**
	 * 返回参数的table字符串
	 * @param pojoList
	 * @return
	 */
	private static String pojoListToContent(List<ExceptionDataPojo> pojoList) {

		StringBuffer sb = new StringBuffer();

		sb.append("<table border='1'>");

		if (!CommonUtils.isCollectionEmpty(pojoList)) {

			for (ExceptionDataPojo pojo : pojoList) {

				String tr = cellListToTr(pojo.getCell(),
						pojo.getExceptionData());

				if (!CommonUtils.isStrEmpty(tr)) {

					sb.append(tr);
				}

			}

		}

		sb.append("</table>");

		return sb.toString();
	}

	/**
	 * 根据单元格的内容返回table String
	 * 
	 * @param cellList
	 * @param exception
	 * @return
	 */
	private static String cellListToTr(Cell[] cells, String exception) {

		StringBuffer sb = new StringBuffer();

		if (!CommonUtils.isCollectionEmpty(cells)) {

			sb.append("<tr>");

			for (Cell cell : cells) {

				String contents = "";

				if (cell.getType() == CellType.DATE) {
					// 如果为日期格式

					DateCell dc = (DateCell) cell;

					Date date = dc.getDate();
					SimpleDateFormat ds = new SimpleDateFormat("yyyy/MM/dd");
					contents = ds.format(date);

				} else {

					contents = cell.getContents().trim();
				}

				sb.append("<td>'").append(contents).append("</td>");
			}

			sb.append("<td>").append(exception).append("</td>");

			sb.append("</tr>");

		}

		return sb.toString();
	}

}
