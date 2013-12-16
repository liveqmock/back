package com.ihk.utils.html;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

public class JsoupUtils {
	
	/**
	 * 成交数据交叉分析
	 * @param table
	 * @return
	 */
	public static String cjsjjcReportTable(String table){
		
		String defaultTable = table;
		
		try{
		
			String html = "<table>" + table + "</table>";
			
			Document doc = Jsoup.parse(html);
			
			String firstTd = doc.select("tr td").first().text();
			
			if(!"楼栋".equals(firstTd)){
				
				return table;
			}
			
			//要变的楼栋的id
			List<Integer> changeBuildIdList = new ArrayList<Integer>();
			
			//把楼栋的id转成对应的楼栋名称
			Elements trs = doc.select("tr");
			
			for(Element tr : trs){
				
				String td = tr.select("td").first().html();
				if(CommonUtils.isStrZeroEmpty(td))
					continue;
				
				if(td.startsWith("[") && td.endsWith("]")){
					
					String buildId = td.substring(1, td.length()-1);
					if(CommonUtils.isIntString(buildId)){
						
						changeBuildIdList.add(Integer.parseInt(buildId));
					}
				}
			}
			
			if(!CommonUtils.isCollectionEmpty(changeBuildIdList)){
				
				for(int buildId : changeBuildIdList){
					
					String buildAllName = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildAllNameByBuildId(buildId);
					table = table.replace("[" + buildId + "]", buildAllName);
				}
			}
			
			return table;
		}catch (Exception e) {
			
			return defaultTable;
		}
	}

}
