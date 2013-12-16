package com.ihk.junit.import_confirm.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 写txt
 * @author dtc
 * 2013-10-21,下午03:37:58
 */
public class WriterTxtUtils {
	
	/**
	 * 把内容写到文档中,默认为不追加
	 * @param fileName
	 * @param content
	 * @throws Exception 
	 */
	public static void writerTxt(String fileName, String content) throws Exception{
		
		writerTxt(fileName, content, false);
	}
	
	/**
	 * 把内容写到文档中,判断是否为追加
	 * @param fileName
	 * @param content
	 * @param isAppend
	 * @throws Exception
	 */
	public static void writerTxt(String fileName, String content, boolean isAppend) throws Exception{
		
		OutputStream out = null;
		
		try{
			
	        File file = new File(fileName);
			out = new FileOutputStream(file, isAppend);
	        fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
	        
	        byte[] b = content.getBytes("utf-8");
	        
	        out.write(b);
			
			out.flush();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if(out != null){
				out.close();
			}
		}
	}

}
