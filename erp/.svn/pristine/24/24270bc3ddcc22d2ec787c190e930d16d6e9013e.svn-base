package com.ihk.utils.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 用于删除文件上传的临时文件
 * @author dtc
 * 2012-6-27
 */
public class UploadTmpDirClass {
	
	private final String SAVE_DIR = "struts.multipart.saveDir";
	
	private Properties pro;
	private static File realFile;
	
	public void setRealFile(File realFile) {
		UploadTmpDirClass.realFile = realFile;
	}
	
	public File getRealFile() {
		return realFile;
	}
	
	public void setPro(Properties pro) {
		this.pro = pro;
	}
	
	public Properties getPro() {
		return pro;
	}
	
	/**
	 * 利用spring bean的初始化来初始化其构造函数
	 */
	public UploadTmpDirClass() {
		
		pro = new Properties();
		
		URL url = this.getClass().getClassLoader().getResource("struts.properties");
		String srcFilePath = url.getPath();
		
		File file = new File(srcFilePath);
		InputStream is;
		try {
			
			is = new FileInputStream(file);
			pro.load(is);
			
			Object obj = pro.get(SAVE_DIR);
			if(obj != null){
				String tmpPath = obj.toString();
				mkDir(tmpPath); //可以不用
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void deleteTmp(){
		
		try{
			
			File[] tmpFile = realFile.listFiles();
			for(File file : tmpFile){
				
				file.delete();
			}
			
		}catch(Exception e){
		}
		
	}
	
	private void mkDir(String mkPath){
		File tmpFile = new File(mkPath);
		realFile = tmpFile.getAbsoluteFile();
		
        if(!realFile.exists()){
        	
        	realFile.mkdirs(); //创建对应的文件夹
        }
        
	}
	
}
