package com.ihk.utils.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.ihk.utils.CommonUtils;

/**
 * 上传工具类
 *
 */
public class UploadUtils {
	
	/**
	 * 文件保存的路径
	 */
	private static final String PATH_XLS = "/upload";
	
	/**
	 * 判断类型是否符合,值来源KindEditor中的demo
	 */
	private static Map<String, String> extMap = new HashMap<String, String>();
	
	static{
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
	}
	
	/**
	 * 文件上传,返回保存后的路径
	 * @param file
	 * @param oldFileName
	 * @return
	 * @throws Exception
	 */
	public static String uploadFile(File file, String oldFileName) throws Exception{
		
		String path = PropertiesUtils.getPropertiesValue(PropertiesUtils.PRO_FILE_NAME, "unit.image.path").toString();
		
		return uploadFile(path, file, oldFileName);
	}
	
	/**
	 * 上传xls文件,返回保存后的路径
	 * @param file
	 * @param oldFileName
	 * @return
	 * @throws Exception
	 */
	public static String uploadXls1(File file, String oldFileName) throws Exception{
		
		return uploadFile(PATH_XLS, file, oldFileName);
	}
	
	/**
	 * 
	 * @param path 基础路径
	 * @param fileName <input type='file' />中的name
	 * @param oldFileName 上传文件的原文件名称加后缀
	 * @return 保存的文件的名称(包括path,可以保存到数据库路径)
	 * @throws Exception
	 */
	public static String uploadFile(String path, File file, String oldFileName) throws Exception{
		
		//基于fileName创建一个文件输入流  
        InputStream is = new FileInputStream(file);  
          
        // 设置上传文件保存目录  
        String uploadPath = ServletActionContext.getServletContext().getRealPath(path);  //"/upload"
        
        File tmpFile = new File(uploadPath);
        if(!tmpFile.exists()){
        	
        	boolean isMk = tmpFile.mkdir();
        	if(!isMk){
        		throw new Exception("新建路径失败");
        	}
        }
        
        //可以通过getFileNameContentType()来获取文件格式,判断是否可以保存
          
        // 设置目标文件  
        if(CommonUtils.isStrEmpty(oldFileName)){
        	throw new Exception("上传文件为空");
        }
        String toFileName = CommonUtils.getFileName(oldFileName);
        File toFile = new File(uploadPath, toFileName);  
          
        // 创建一个输出流  
        OutputStream os = new FileOutputStream(toFile);  
  
        //设置缓存  
        byte[] buffer = new byte[1024];  
  
        int length = 0;  
  
        //读取unitImage输出到toFile文件中  
        while ((length = is.read(buffer)) > 0) {  
            os.write(buffer, 0, length);  
        }  
        
        os.flush();
        
        //关闭输入流  
        is.close();  
          
        //关闭输出流  
        os.close();  
        
        //删除临时文件
        UploadTmpDirClass.deleteTmp();
        
        if(path.startsWith("/")){
        	
        	return path.substring(1, path.length()) + "/" + toFileName; //path要去掉前面的/
        }else{
        	
        	return path + "/" + toFileName;
        }
        
	}
	
	/**
	 * 获取文件类型
	 * @param oldFileName
	 * @return
	 */
	public static String getFileType(String oldFileName){
		
		int index = oldFileName.lastIndexOf(".");
		
		if(index == -1){
			
			return oldFileName;
		}
		
		return oldFileName.substring(index+1, oldFileName.length());
	}
	
	/**
	 * 判断文件类型是否符合
	 * @param dir
	 * @param fileType
	 * @return
	 */
	public static boolean isMarkFileType(String dir, String fileType){
		
		boolean isMark = false;
		
		if(!extMap.containsKey(dir)){
			return isMark;
		}
		
		String value = extMap.get(dir);
		
		String[] types = value.split(",");
		
		for(String type : types){
			
			if(type.equalsIgnoreCase(fileType)){
				
				isMark = true;
				break;
			}
		}
		
		return isMark;
		
	}

}
