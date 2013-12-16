package com.ihk.saleunit.action.contract_unit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.impl.ConfirmServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.collection.XLSExport;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ApPayment;
import com.ihk.saleunit.data.pojo.ApPaymentCond;
import com.ihk.saleunit.data.services.IApPaymentServices;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.saleunitnew.PropertyUnitUtils;

public class PaidInManagerAction extends SupperAction{

	@Autowired
	IApPaymentServices apPaymentServices;
	@Autowired
    IConfirmServices confirmServices;
	//当前页
	private int page;
	//每页的记录数
	private int rows;
	//排序字段
	private String sort;
	//排序方式 (asc|desc)
	private String order;
	private JSONObject result;
	Map buildMap;
	ApPaymentCond cond;

	public ApPaymentCond getCond() {
		return cond;
	}

	public void setCond(ApPaymentCond cond) {
		this.cond = cond;
	}

	public Map getBuildMap() {
		return buildMap;
	}

	public void setBuildMap(Map buildMap) {
		this.buildMap = buildMap;
	}
	
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public String paidInManager() throws Exception {

		List<PropertyBuild> tmpList = ContractCustomerUtils.getBuildListByRequest(request);
		buildMap = PropertyUnitUtils.buildListToMap(tmpList);
		buildMap.remove("");
		return SUCCESS;
	}
	
	//查找
	public String searchPaidIn() throws Exception {
		
		try{
			JSONArray jsonArray = new JSONArray();
	        JSONObject jsonobj = new JSONObject();
			
			if(cond == null)
				cond = new ApPaymentCond();
			rows = Integer.parseInt((request.getParameter("rows") == null) ? "10" : request.getParameter("rows"));
			page = Integer.parseInt((request.getParameter("page") == null) ? "1" : request.getParameter("page"));
			cond.pageSize = rows;
			cond.startLine = (page - 1) * rows;

            //排序
            String sort = request.getParameter("sort")==null?"": request.getParameter("sort");
            String order = request.getParameter("order")==null?"": request.getParameter("order");

            if(sort.length()>0){
                cond.setStr_sort(sort);
                cond.setStr_order(order);
            }

            String buildId = request.getParameter("buildId");
            String impdate = request.getParameter("impdate");
            if(buildId!=null) cond.setBuild_id(Integer.parseInt(buildId));
            if(impdate!=null) cond.setImpdate(impdate);

            int recordCount = apPaymentServices.findApPaymentCount(cond);
			List<ApPayment> list = apPaymentServices.findApPaymentPage(cond);
			
			for (ApPayment app : list) {
				jsonobj.put("id", app.getId());
				jsonobj.put("unit_id", app.getPropertyUnit().getUnitNo());
				jsonobj.put("Impdate", DateTimeUtils.toStr(app.getImpdate()));
				jsonobj.put("Receiptdate", DateTimeUtils.toStr(app.getReceiptdate()));
				jsonobj.put("ArDate", DateTimeUtils.toStr(app.getArDate()));
				jsonobj.put("amount", app.getAmount());
				jsonobj.put("remark", app.getRemark());
				jsonArray.add(jsonobj);
			}
			
			Map<String, Object> json = new HashMap<String, Object>();
			json.put("total", recordCount);// total键 存放总记录数，必须的
			json.put("rows", jsonArray);// rows键 存放每页记录 list
			result = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	private File upload; 				//上传的文件
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	//导入数据
	public String excelPaidUpload() throws Exception {
		
		FileInputStream is = null;
		Workbook wb=null; 
		int rowFlag = 0;
		try{
			is = new FileInputStream(upload); 
			wb = WorkbookFactory.create(is);
			
			Sheet sheet = wb.getSheetAt(0);
			int maxSize = sheet.getLastRowNum(); //excel的总行数
			//遍历excel
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
			//将excel数据保存进ApPayment
			createApPayment(map);
			}
            CustomerUtils.writeResponse(response, "上传成功。");
		
		}catch(Exception e){
			e.printStackTrace();
            CustomerUtils.writeResponse(response,"错误："+e.getMessage());
		}
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	private void createApPayment(Map map) {
		ApPayment ment = new ApPayment();
		//if(map.get("公司").toString().trim() != ""&&map.get("公司").toString().trim() != null)
		//	ment.setCompanyId(Integer.parseInt(map.get("公司").toString().split("\\(")[1].split("\\)")[0]));
		ment.setAmount(new BigDecimal(map.get("实收金额").toString()));
		//if(map.get("楼栋").toString().trim() != ""&&map.get("楼栋").toString().trim() != null)
		//	ment.setBuildId(Integer.parseInt(map.get("楼栋").toString().split("\\(")[1].split("\\)")[0]));
		//ment.setUnitId(Integer.parseInt(map.get("ID").toString()));
		ment.setUnitId(Integer.parseInt(map.get("UnitID").toString()));
        ment.setBuildId(Integer.parseInt(map.get("BuildId").toString()));
		ment.setImpdate(new Date());
		ment.setRemark(map.get("备注").toString());

        String ardate = map.get("收款日期").toString();
        if(ardate!=null && ardate.length()>0){
            ment.setArDate(DateTimeUtils.getDate(ardate));
        }


        String receiptdate = map.get("对应应收月份").toString();
        if(receiptdate!=null && receiptdate.length()>0){
            ment.setReceiptdate(DateTimeUtils.getDate(receiptdate));
        }


		apPaymentServices.addApPayment(ment);
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
        ConfirmCond cond = new ConfirmCond();
		cond.setBuildId(request.getParameter("buildId"));
		List<Confirm> list = confirmServices.findConfirmUnit(cond);
		try{
			Map<String,String> mp = new LinkedHashMap<String,String>(){{
				put("xl1", "ID");
                put("xl101", "UnitID");
                put("xl102", "BuildId");
				//put("xl2", "公司");
				put("xl3", "项目");
				//put("xl4", "区域");
				put("xl5", "楼栋");
				put("xl6", "单元号");
				put("xl7", "客户名称");
                put("xl71", "建筑面积");
				put("xl8", "成交单价");
				put("xl9", "成交金额");
				put("xl10", "签约日期");
				put("xl11", "收款日期");
				put("xl12", "对应应收月份");
				put("xl13", "实收金额");
				put("xl14", "备注");
			}};
			List<Map> lstMp = new ArrayList();	
			for(int i=0;i < list.size();i ++) {
				Map e = new HashMap();
				e.put("xl1",String.valueOf(list.get(i).getId()));
                e.put("xl101",String.valueOf(list.get(i).getUnitId()));
                e.put("xl102",String.valueOf(list.get(i).getBuildId()));
                e.put("xl3",list.get(i).getPropertyProjectName());
				
				if(list.get(i).getBuildId() == 0)
					e.put("xl5","");
				else
					e.put("xl5",list.get(i).getDescBuildId());

                String unitNo = list.get(i).getUnit().getUnitNo();
                if(unitNo == null) {
                    e.put("xl6", "");
                }else{
                    unitNo = unitNo.replaceAll("-","");
                    e.put("xl6", unitNo);
                }

                if(list.get(i).getCustomerName() == null)
                    e.put("xl7", "");
                else
                    e.put("xl7", list.get(i).getCustomerName());

                if(list.get(i).getBuildArea() == null)
                    e.put("xl71", "");
                else
                    e.put("xl71", list.get(i).getBuildArea().toString());

				if(list.get(i).getBuildPrice() == null)
					e.put("xl8","");
				else
					e.put("xl8",list.get(i).getBuildPrice().toString());

				if(list.get(i).getSumMoney() == null)
					e.put("xl9", "");
				else
					e.put("xl9", list.get(i).getSumMoney().toString());

                if(list.get(i).getWorkDate() == null)
                    e.put("xl10", "");
                else
                    e.put("xl10", CommonUtils.getDateString(list.get(i).getWorkDate()));


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
	
	
	//模板导出
	public String excelPaid() throws Exception {
		
		return SUCCESS;
	}
}
