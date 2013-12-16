package com.ihk.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihk.utils.CacheUtils;

import net.sf.ehcache.constructs.web.PageInfo;
import net.sf.ehcache.constructs.web.ResponseHeadersNotModifiableException;
import net.sf.ehcache.constructs.web.ResponseUtil;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

/**
 * 利用ehcache的SimplePageCachingFilter来实现HttpServletResponseWrapper对返回html文本处理的问题
 * 该类主要用于html内容的处理,并有缓存功能
 * 
 * @author dtc 2012-12-5,下午02:08:54
 */
public abstract class MyAbstractResponseWrapperLikePageCachingFilter extends
		SimplePageCachingFilter {

	/**
	 * 实现方法参照super.writeContent(request, response, pageInfo);
	 */
	@Override
	protected void writeContent(HttpServletRequest request,
			HttpServletResponse response, PageInfo pageInfo)
			throws IOException, ResponseHeadersNotModifiableException {

		byte[] body;

		boolean shouldBodyBeZero = ResponseUtil.shouldBodyBeZero(request,
				pageInfo.getStatusCode());
		if (shouldBodyBeZero) {
			body = new byte[0];
		} else if (acceptsGzipEncoding(request)) {
			body = pageInfo.getGzippedBody();
			if (ResponseUtil.shouldGzippedBodyBeZero(body, request)) {
				body = new byte[0];
			} else {
				ResponseUtil.addGzipHeader(response);
			}

		} else {
			body = pageInfo.getUngzippedBody();
		}
		
		String html = ungzip(body);
		html = dealHtml(html);

		/**
		 * 应该考虑参考ehcache利用gzip压缩后再输出
		 */
		response.setHeader("Content-Encoding", "text/html;charset=utf-8");
		response.setContentLength(html.length());
		PrintWriter out = response.getWriter();
		out.write(html);
		out.flush();
		out.close();
		
		/**
		 *  response.setContentLength(body.length);
	        OutputStream out = new BufferedOutputStream(response.getOutputStream());
	        out.write(body);
	        out.flush();
		 */

	}
	
	@Override
	protected String calculateKey(HttpServletRequest httpRequest) {
		
		return CacheUtils.getCacheKey(httpRequest);
	}

	/**
	 * 处理返回的html
	 * 
	 * @param html
	 * @return
	 */
	public abstract String dealHtml(String html);

	/**
	 * 解压对应的gzip流
	 * 该方法在net.sf.ehcache.constructs.web.PageInfo.class,line388
	 * @param gzipped
	 * @return
	 * @throws IOException
	 */
	private String ungzip(byte[] gzipped) throws IOException {
		
		String ret = "";

		GZIPInputStream inputStream = new GZIPInputStream(new ByteArrayInputStream(gzipped));
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(gzipped.length);
		
		final byte[] buffer = new byte[4196];
		int bytesRead = 0;
		while (bytesRead != -1) {
			bytesRead = inputStream.read(buffer, 0, 4196);
			if (bytesRead != -1) {
				byteArrayOutputStream.write(buffer, 0, bytesRead);
			}
		}
		
		ret = byteArrayOutputStream.toString("utf-8").trim();
		
		inputStream.close();
		byteArrayOutputStream.close();
		
		return ret;
	}
	
}
