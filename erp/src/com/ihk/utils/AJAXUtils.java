package com.ihk.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 异步操作，页面输出方面的静态方法
 * @author Administrator
 *
 */
public class AJAXUtils {

	/**
	 * 输出Response
	 * @param response
	 * @param content
	 * @throws IOException
	 */
	public static void writeResponse(HttpServletResponse response, String content) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(content);
		pw.flush();
		pw.close();
		
	}
}
