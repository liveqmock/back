package com.ihk.test;

import com.ihk.filter.MyAbstractResponseWrapperLikePageCachingFilter;

/**
 * 测试
 * @author dtc
 * 2012-12-5,下午02:57:52
 */
public class MyDealFilter extends MyAbstractResponseWrapperLikePageCachingFilter {

	@Override
	public String dealHtml(String html) {
		
		String ret = html.replace("客户", "customer");
		
		return ret;
	}

}
