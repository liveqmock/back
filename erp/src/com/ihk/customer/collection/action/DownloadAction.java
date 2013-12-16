package com.ihk.customer.collection.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.ihk.utils.SupperAction;

@SuppressWarnings("serial")
public class DownloadAction extends SupperAction{

	//下载文件原始存放路径
	private final static String DOWNLOADFILEPATH="/upload/";
	//文件名参数变量
	private String fileName;
	
	public String getFileName() {
        return fileName;
	}

	public void setFileName(String fileName) {
        this.fileName = fileName;
	}
	
	//从下载文件原始存放路径读取得到文件输出流
	public InputStream getDownloadFile() {
	        return ServletActionContext.getServletContext().getResourceAsStream(DOWNLOADFILEPATH+fileName);
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
	
	public String download() throws Exception {
        return SUCCESS;
	}
	
}
