package com.ihk.utils.upload;

import java.io.File;

import net.sf.json.JSONObject;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;

/**
 * KindEditor文件上传公共action,只判断图片格式
 * POST参数
 * imgFile: 文件form名称
 * dir: 上传类型，分别为image、flash、media、file
 * @author dtc
 * 2013-7-12,上午11:10:22
 */
public class KindEditorUploadAction extends SupperAction{

	private static final long serialVersionUID = 7695366003385257098L;
	
	/**
	 * 上传文件
	 * @return
	 * @throws Exception
	 */
	public String upload() throws Exception{
		
		//KindEditor中指定的文件类型
		String dir = request.getParameter("dir");
		//真正上传的文件类型
		String fileType = UploadUtils.getFileType(CommonUtils.getFileName(imgFileFileName));
		
		boolean isMark = UploadUtils.isMarkFileType(dir, fileType);
		
		if(!isMark){
			
			throw new Exception("文件格式不符合");
		}
		
		String url = "";
		
		try{
			url = UploadUtils.uploadFile(getImgFile(), getImgFileFileName());
		}catch (Exception e) {
		}
		
		JSONObject json = new JSONObject();
		
		if(CommonUtils.isStrEmpty(url)){
			//表示上传失败
			
			json.put("error", 1);
			json.put("message", "上传失败,请重试");
		}else{
			//表示上传成功
			
			json.put("error", 0);
			json.put("url", url);
			
		}
		
		CustomerUtils.writeResponse(response, json.toString());
		
		return null;
	}
	
	/**
	 * KindEditor文件上传的type='file'的name
	 */
	private File imgFile;
	
	/**
	 * struts2对应的文件名称方法
	 */
	private String imgFileFileName;
	
	/**
	 * struts2自动绑定文件类型
	 */
	private String imgFileContentType;

	public File getImgFile() {
		return imgFile;
	}

	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}

	public String getImgFileFileName() {
		return imgFileFileName;
	}

	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	public String getImgFileContentType() {
		return imgFileContentType;
	}

	public void setImgFileContentType(String imgFileContentType) {
		this.imgFileContentType = imgFileContentType;
	} 
	
}
