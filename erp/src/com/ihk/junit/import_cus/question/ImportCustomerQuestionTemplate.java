package com.ihk.junit.import_cus.question;

import java.io.File;
import java.util.List;

import jxl.Cell;

import org.junit.Test;

import com.ihk.junit.SupperJunit;
import com.ihk.junit.import_confirm.utils.LogDataUtils;
import com.ihk.junit.import_confirm.utils.WriterTxtUtils;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.xls.ReadXlsUtils;

/**
 * 客户问卷
 * @author dtc
 * 2013-12-6,上午10:45:39
 */
public class ImportCustomerQuestionTemplate extends SupperJunit{
	
	ICompanyProjectServices companyProjectServices = 
		(ICompanyProjectServices) factory.getBean("companyProjectServices");
	
	@Test
	public void _import() throws Exception{
		
		File file = new File("C:\\question\\兰乔圣菲_5.xls");
		
		List<Cell[]> cellList = ReadXlsUtils.readXls(file);
		
		moreImportData();
		
	}
	
	/**
	 * 遍历文件夹下的所有文件,文件名为楼栋id
	 */
	private void moreImportData(){
		
		File file = new File("C:\\question");
		
		File[] files = file.listFiles();
		
		for(File f : files){
			
			String fileName = f.getAbsolutePath();
			if("C:\\question\\exception".equalsIgnoreCase(fileName)){
				continue;
			}
			
			int projectId = getProjectIdByFileName(fileName);
			if(projectId == 0){
				//表示该文件不合法
				
				try {
					WriterTxtUtils.writerTxt("C:\\question\\exception\\有异常的文档.txt", fileName + "\r\n", true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
				continue;
			}
			
			try {
				//importData(build.getCompanyProjectId(), buildId, build.getPropertyId(), -1, f.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			LogDataUtils.log(LogDataUtils.CUSTOMER_QUESTION_TYPE, fileName.replace("C:\\question\\", "").replace("c:\\question\\", ""));
		}
	}

	/**
	 * 根据文件名返回项目id,如果返回0表示该文件不合法
	 * C:\\question\\兰乔圣菲_55.xl
	 * @param fileName
	 * @return
	 */
	private int getProjectIdByFileName(String fileName) {
		
		if(CommonUtils.isStrEmpty(fileName)){
			
			return 0;
		}
		
		try{
			
			int start = fileName.lastIndexOf("\\");
			int end = fileName.lastIndexOf(".");
			
			fileName = fileName.substring(start+1, end);
			
			String[] arr = fileName.split("_");
			
			String projectName = arr[0].trim(); //项目名称
			int projectId = Integer.parseInt(arr[1].trim()); //项目id
			
			CompanyProject project = companyProjectServices.findCompanyProjectById(projectId);
			
			if(project == null){
				//表示该文件不合法
				return 0;
			}
			
			if(!projectName.equals(project.getProjectName())){
				
				return 0;
			}
			
			return projectId;
			
		}catch (Exception e) {
			
			return 0;
		}
		
	}
	
	
}