package com.ihk.customer.collection;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;

/**
 * 生成导出Excel文件对象
 */
public class XLSExport {

    //  设置cell编码解决中文高位字节截断 
    // private   static   short  XLS_ENCODING  =  HSSFWorkbook.ENCODING_UTF_16;

    //  定制日期格式 
    private static String DATE_FORMAT = "yyyy-mm-dd";  //  "m/d/yy h:mm"

    //  定制浮点数格式 
    private static String NUMBER_FORMAT = "#,###.00";

    private String xlsFileName;

    public HSSFWorkbook workbook;

    private HSSFSheet sheet;

    private HSSFRow row;

    /**
     * 初始化Excel
     * <p/>
     * 导出文件名
     */
    public XLSExport() {
        this.workbook = new HSSFWorkbook();
        this.sheet = workbook.createSheet();
    }

    /**
     * 导出三个list
     *
     * @param title
     * @param header
     * @param list
     * @return
     */
    public static HSSFWorkbook exportDoubleTitleExcel(Map title, Map header, List<Map> list) {
        HSSFWorkbook workbooks = new HSSFWorkbook();
        HSSFSheet sheets = workbooks.createSheet();
        HSSFRow rows = null;
        Iterator<Entry<String, String>> titleiter = title.entrySet().iterator();
        int i = 0;
        rows = sheets.createRow(0);
        while (titleiter.hasNext()) {
            Entry<String, String> entry = titleiter.next();
            HSSFCell cell = rows.createCell((short) i);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            System.out.println(entry.getValue());
            cell.setCellValue(entry.getValue());
            i++;
        }
        Iterator<Entry<String, String>> headeriters = header.entrySet().iterator();
        int m = 0;
        rows = sheets.createRow(1);
        while (headeriters.hasNext()) {
            Entry<String, String> entry = headeriters.next();
            HSSFCell cell = rows.createCell((short) i);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(entry.getValue());
            m++;
        }
        Iterator<Entry<String, String>> headiters = header.entrySet().iterator();
        for (int j = 0; j < list.size(); j++) {
            rows = sheets.createRow(j + 2);
            int k = 0;
            while (headiters.hasNext()) {
                Entry<String, String> entry = headiters.next();
                HSSFCell cell = rows.createCell((short) k);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                if (list.get(j).get(entry.getKey()) instanceof Date)
                    cell.setCellValue((String) list.get(j).get(entry.getKey()));
                else if (list.get(j).get(entry.getKey()) instanceof Long)
                    cell.setCellValue((Long) list.get(j).get(entry.getKey()));
                else
                    cell.setCellValue((String) list.get(j).get(entry.getKey()));
                k++;
            }
        }
        return workbooks;
    }

    /**
     * 导出
     *
     * @param headers
     * @param list
     * @return
     */
    public static HSSFWorkbook exportExcel(Map headers, List<Map> list) {
        HSSFWorkbook workbooks = new HSSFWorkbook();
        HSSFSheet sheets = workbooks.createSheet();
        HSSFRow rows = null;
        Iterator<Entry<String, String>> iter = headers.entrySet().iterator();
        int i = 0;
        rows = sheets.createRow(0);
        while (iter.hasNext()) {
            Entry<String, String> entry = iter.next();
            HSSFCell cell = rows.createCell((short) i);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(entry.getValue());
            i++;
        }

        for (int j = 0; j < list.size(); j++) {
            rows = sheets.createRow(j + 1);
            int k = 0;
            Iterator<Entry<String, String>> iters = headers.entrySet().iterator();
            while (iters.hasNext()) {
                Entry<String, String> entry = iters.next();
                HSSFCell cell = rows.createCell((short) k);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                if (list.get(j).get(entry.getKey()) instanceof Date)
                    cell.setCellValue((String) list.get(j).get(entry.getKey()));
                else if (list.get(j).get(entry.getKey()) instanceof Long)
                    cell.setCellValue((Long) list.get(j).get(entry.getKey()));
                else if (list.get(j).get(entry.getKey()) instanceof Integer)
                    cell.setCellValue((Integer) list.get(j).get(entry.getKey()));
                else if (list.get(j).get(entry.getKey()) instanceof BigDecimal)
                    cell.setCellValue(((BigDecimal) list.get(j).get(entry.getKey())).doubleValue());
                else
                    //cell.setCellValue( (String) list.get(j).get(entry.getKey()));
                    cell.setCellValue(
                            list.get(j).get(entry.getKey()) == null ? "" : list.get(j).get(entry.getKey()).toString());
                k++;
            }
        }

        return workbooks;
    }

    public static HSSFWorkbook exportListExcel(List<List> list) {
        HSSFWorkbook workbooks = new HSSFWorkbook();
        HSSFSheet sheets = workbooks.createSheet();
        HSSFRow rows = null;
        for (int i = 0; i < list.size(); i++) {
            rows = sheets.createRow(i);
            for (int j = 0; j < list.get(i).size(); j++) {
                HSSFCell cell = rows.createCell((short) j);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                if (list.get(i).get(j) instanceof Date)
                    cell.setCellValue((String) list.get(i).get(j));
                else if (list.get(i).get(j) instanceof Long)
                    cell.setCellValue((Long) list.get(i).get(j));
                else if (list.get(i).get(j) instanceof Integer)
                    cell.setCellValue((Integer) list.get(i).get(j));
                else
                    cell.setCellValue((String) list.get(i).get(j));
            }
        }
        return workbooks;
    }

    /**
     * 导出Excel文件
     *
     * @throws Exception
     */
    public void exportXLS() throws Exception {
        try {
            FileOutputStream fOut = new FileOutputStream(xlsFileName);
            workbook.write(fOut);
            fOut.flush();
            fOut.close();
        } catch (FileNotFoundException e) {
            throw new Exception("生成导出Excel文件出错!", e);
        } catch (IOException e) {
            throw new Exception("写入Excel文件出错!", e);
        }

    }

    /**
     * 增加一行
     *
     * @param index 行号
     */
    public void createRow(int index) {
        this.row = this.sheet.createRow(index);
    }

    /**
     * 设置单元格
     *
     * @param index 列号
     * @param value 单元格填充值
     */
    public void setCell(int index, String value) {
        HSSFCell cell = this.row.createCell((short) index);
        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        cell.setCellValue(value);
    }

    /**
     * 设置单元格
     *
     * @param index 列号
     * @param value 单元格填充值
     */
    public void setCell(int index, Calendar value) {
        HSSFCell cell = this.row.createCell((short) index);
        //cell.setEncoding(XLS_ENCODING);
        cell.setCellValue(value.getTime());
        HSSFCellStyle cellStyle = workbook.createCellStyle();  //  建立新的cell样式
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT));  //  设置cell样式为定制的日期格式
        cell.setCellStyle(cellStyle);  //  设置该cell日期的显示格式
    }

    /**
     * 设置单元格
     *
     * @param index 列号
     * @param value 单元格填充值
     */
    public void setCell(int index, int value) {
        HSSFCell cell = this.row.createCell((short) index);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(value);
    }

    /**
     * 设置单元格
     *
     * @param index 列号
     * @param value 单元格填充值
     */
    public void setCell(int index, double value) {
        HSSFCell cell = this.row.createCell((short) index);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(value);
        HSSFCellStyle cellStyle = workbook.createCellStyle();  //  建立新的cell样式
        HSSFDataFormat format = workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat(NUMBER_FORMAT));  //  设置cell样式为定制的浮点数格式
        cell.setCellStyle(cellStyle);  //  设置该cell浮点数的显示格式
    }

}
