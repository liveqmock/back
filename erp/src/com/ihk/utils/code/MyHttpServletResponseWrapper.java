package com.ihk.utils.code;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 重写HttpServletResponse,可以利用对应的getContent()获取页面源代码
 * 主要用于缓存或字符替代...
 * @author dtc
 * 2012-12-4,下午04:26:40
 */
public class MyHttpServletResponseWrapper extends HttpServletResponseWrapper {
	
	private MyPrintWriter tmpWriter;
	private ByteArrayOutputStream output;

	/**
	 * 设置对应的MyPrintWriter及ByteArrayOutputStream
	 * @param response
	 */
	public MyHttpServletResponseWrapper(HttpServletResponse response) {
		super(response);
		response.setContentLength(-1); //恢复HttpServletResponse的HTTP Content-Length长度 
		
		output = new ByteArrayOutputStream(); 
		tmpWriter = new MyPrintWriter(output);  
	}
	
	/**
	 * 返回页面的源代码
	 * @return
	 * @throws IOException
	 */
	public String getContent() throws IOException {
		
		try{
		
			tmpWriter.flush(); // 刷新该流的缓冲，详看java.io.Writer.flush()
			output.flush();
			
			ByteArrayOutputStream os = tmpWriter.getByteArrayOutputStream();
			String out = new String(os.toByteArray());
			
			return out;
			
		}catch (IOException e) {
			
			throw e;
			
		}finally{
			
			tmpWriter.close();
			output.close();
		}
		
	}  

	/**
	 * 重写该方法,对输出流及内容进行相关的处理
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		
		return tmpWriter;
	}
	
	class MyPrintWriter extends PrintWriter{
		
		ByteArrayOutputStream myOutput;

		public MyPrintWriter(ByteArrayOutputStream myOutput) {
			super(myOutput);
			this.myOutput = myOutput;
		}
		
		public ByteArrayOutputStream getByteArrayOutputStream() {
			return myOutput;
		}
		
	}

}
