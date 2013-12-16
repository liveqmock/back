package com.ihk.junit.import_confirm.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.biff.EmptyCell;
import jxl.read.biff.BiffException;

import com.ihk.utils.CommonUtils;

/**
 * 读取帮助类
 * @author dtc
 * 2013-9-30,上午09:33:55
 */
public class RealXlsUtils {
	
	/**
	 * 返回文档中的数据
	 * @param file
	 * @return
	 */
	public static List<Cell[]> realXls(String file) {
		
		List<Cell[]> cellList = new ArrayList<Cell[]>();

		Workbook book = null;

		try {

			book = Workbook.getWorkbook(new File(file));
			Sheet[] sheets = book.getSheets();

			if (CommonUtils.isCollectionEmpty(sheets)) {
				return null;
			}
			
			//只拿第一个Sheet
			
			Sheet sheet = sheets[0];
			
			int rows = sheet.getRows();

			for (int i = 0; i < rows; i++) {
				
				Cell[] tmpCells = new Cell[30];

				Cell[] cells = sheet.getRow(i);
				
				if(CommonUtils.isCollectionEmpty(cells)){
					continue;
				}
				
				Cell ce = cells[4];
				if(ce instanceof EmptyCell){
					continue;
				}

				for(int j=0; j<=29; j++){
					
					Cell tmpCe = new EmptyCell(i, j);
					
					try{
						tmpCe = cells[j];
					}catch (Exception e) {
					}
					
					tmpCells[j] = tmpCe;
				}
				
				cellList.add(tmpCells);
			}
			
			/**
			for (Sheet sheet : sheets) {

				int rows = sheet.getRows();

				for (int i = 0; i < rows; i++) {
					
					Cell[] tmpCells = new Cell[30];

					Cell[] cells = sheet.getRow(i);
					
					if(CommonUtils.isCollectionEmpty(cells)){
						continue;
					}
					
					Cell ce = cells[4];
					if(ce instanceof EmptyCell){
						continue;
					}

					for(int j=0; j<=29; j++){
						
						Cell tmpCe = new EmptyCell(i, j);
						
						try{
							tmpCe = cells[j];
						}catch (Exception e) {
						}
						
						tmpCells[j] = tmpCe;
					}
					
					cellList.add(tmpCells);
				}

			}
			*/

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (book != null) {
				book.close();
			}
		}
		
		return cellList;
	}
	
	/**
	 * 售前客户模板导入
	 * @param file
	 * @return
	 */
	public static List<Cell[]> realCustomeXls(String file) {
		
		List<Cell[]> cellList = new ArrayList<Cell[]>();

		Workbook book = null;

		try {

			book = Workbook.getWorkbook(new File(file));
			Sheet[] sheets = book.getSheets();

			if (CommonUtils.isCollectionEmpty(sheets)) {
				return null;
			}
			
			for (Sheet sheet : sheets) {

				int rows = sheet.getRows();

				for (int i = 0; i < rows; i++) {
					
					Cell[] tmpCells = new Cell[20];

					Cell[] cells = sheet.getRow(i);
					
					Cell phoneCe = cells[3];
					Cell homePhoneCe = cells[4];
					
					if(phoneCe instanceof EmptyCell && homePhoneCe instanceof EmptyCell){
						continue;
					}

					if (CommonUtils.isCollectionEmpty(cells))
						continue;
					
					for(int j=0; j<=19; j++){
						
						Cell tmpCe = new EmptyCell(i, j);
						
						try{
							tmpCe = cells[j];
						}catch (Exception e) {
						}
						
						tmpCells[j] = tmpCe;
					}
					
					cellList.add(tmpCells);
				}

			}

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (book != null) {
				book.close();
			}
		}
		
		return cellList;
	}

}
