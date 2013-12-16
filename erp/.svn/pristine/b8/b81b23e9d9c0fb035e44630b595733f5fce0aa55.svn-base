package com.ihk.utils.xls;

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
 * 读取xls帮助类
 * @author dtc
 * 2013-12-3,下午03:48:33
 */
public class ReadXlsUtils {
	
	/**
	 * 指定总列数,读取xls,默认不忽略第一行
	 * @param file
	 * @param cols
	 * @return
	 */
	public static List<Cell[]> readXls(File file, int cols) {
		
		return readXls(file, cols, false);
	}
	
	/**
	 * 指定总列数,读取xls
	 * @param file
	 * @param cols
	 * @param isIgnoreFirstRow,是否忽略第一行
	 * @return
	 */
	public static List<Cell[]> readXls(File file, int cols, boolean isIgnoreFirstRow) {
		
		List<Cell[]> cellList = new ArrayList<Cell[]>();

		Workbook book = null;

		try {

			book = Workbook.getWorkbook(file);
			Sheet[] sheets = book.getSheets();

			if (CommonUtils.isCollectionEmpty(sheets)) {
				return null;
			}
			
			int start = 0;
			if(isIgnoreFirstRow){
				start = 1;
			}
			
			for (Sheet sheet : sheets) {

				int rows = sheet.getRows();

				for (int i = start; i < rows; i++) {
					
					Cell[] tmpCells = new Cell[cols];

					Cell[] cells = sheet.getRow(i);
					
					if (CommonUtils.isCollectionEmpty(cells))
						continue;
					
					for(int j=0; j<=cols-1; j++){
						
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
	
	/**
	 * 读取xls,默认不忽略第一行
	 * @param file
	 * @return
	 */
	public static List<Cell[]> readXls(File file){
		
		return readXls(file, false);
	}
	
	/**
	 * 读取xls
	 * @param file
	 * @param isIgnoreFirstRow,是否忽略第一行
	 * @return
	 */
	public static List<Cell[]> readXls(File file, boolean isIgnoreFirstRow) {
		
		List<Cell[]> cellList = new ArrayList<Cell[]>();

		Workbook book = null;

		try {

			book = Workbook.getWorkbook(file);
			Sheet[] sheets = book.getSheets();

			if (CommonUtils.isCollectionEmpty(sheets)) {
				return null;
			}
			
			int start = 0;
			if(isIgnoreFirstRow){
				start = 1;
			}
			
			for (Sheet sheet : sheets) {
				
				int cols = 0;

				int rows = sheet.getRows();

				for (int i = start; i < rows; i++) {

					//列数,以第一行为准
					if(cols <= 0){
						cols = sheet.getColumns();
					}
					
					Cell[] tmpCells = new Cell[cols];

					Cell[] cells = sheet.getRow(i);
					
					if (CommonUtils.isCollectionEmpty(cells))
						continue;
					
					for(int j=0; j<=cols-1; j++){
						
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
