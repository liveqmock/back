package com.ihk.utils.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ihk.saleunit.data.pojo.Question;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;
import com.ihk.setting.data.pojo.Region;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.cache.MyCacheTemplate;
import com.ihk.utils.cache.MyCacheTemplateCallback;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 有关手机客户帮助类
 * @author dtc
 * 2013-7-23,下午04:07:44
 */
@SuppressWarnings("unchecked")
public class MobileCustomerUtils {
	
	/**
	 * 自定义问卷单选或者多选的name的前缀
	 */
	public static final String QUESTION_TOPIC = "topic_";
	
	/**
	 * 自定义问卷输入框其他的name的前缀
	 */
	public static final String QUESTION_OTHER_OPTION = "other_option_";
	
	/**
	 * 省份下拉框map
	 * @return
	 */
	public static Map<String, String> initSelProvince(){
		
		Object obj = MyCacheTemplate.cache("MobileCustomerUtils.initSelProvince", "provinceId", new MyCacheTemplateCallback() {
			
			@Override
			public Object doCache() throws Exception {
				
				Map<String, String> retMap = new LinkedHashMap<String, String>();
				retMap.put("", CommonUtils.EMPTY);
				
				List<Province> provinceList = MyPropertyUtils.getProvinceServices().findProvince(new ProvinceCond());
				
				for(Province province : provinceList){
					retMap.put(province.getProvinceId() + "", province.getProvinceName());
				}
				
				return retMap;
			}
		});
		
		return obj == null ? new HashMap<String, String>() : (Map<String, String>)obj; 
		
	}
	
	/**
	 * 城市下拉框map
	 * @param provinceId
	 * @return
	 */
	public static Map<String, String> initSelCity(final int provinceId){
		
		Object obj = MyCacheTemplate.cache("MobileCustomerUtils.initSelCity", provinceId + "", new MyCacheTemplateCallback() {
			
			@Override
			public Object doCache() throws Exception {
				
				Map<String, String> retMap = new LinkedHashMap<String, String>();
				retMap.put("", CommonUtils.EMPTY);
				
				if(provinceId <= 0){
					return retMap;
				}
				
				List<City> citys = MyPropertyUtils.getCityServices().findCityByProvinceId(provinceId);
				for(City city : citys){
					
					retMap.put(city.getCityId() + "", city.getCityName());
				}
				
				return retMap;
			}
		});
		
		return obj == null ? new HashMap<String, String>() : (Map<String, String>)obj;
	}
	
	/**
	 * 区域下拉框map
	 * @param cityId
	 * @return
	 */
	public static Map<String, String> initSelRegion(final int cityId){
		
		Object obj = MyCacheTemplate.cache("MobileCustomerUtils.initSelRegion", cityId + "", new MyCacheTemplateCallback() {
			
			@Override
			public Object doCache() throws Exception {
				
				Map<String, String> retMap = new LinkedHashMap<String, String>();
				retMap.put("", CommonUtils.EMPTY);
				
				if(cityId <= 0){
					return retMap;
				}
				
				List<Region> regions = MyPropertyUtils.getRegionServices().findRegionByCityId(cityId);
				for(Region region : regions){
					
					retMap.put(region.getRegionId() + "", region.getRegionName());
				}
				
				return retMap;
			}
		});
		
		return obj == null ? new HashMap<String, String>() : (Map<String, String>)obj;
	}
	
	/**
	 * 根据公司项目id,获取对应的问卷的下拉框html
	 * @param projectId
	 * @return
	 */
	public static String getQuestionSelectOptionHtml(int projectId){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "基本售前问卷");
		
		String selectValue = "0";
		
		QuestionCond cond = new QuestionCond();
		cond.setCompanyProjectId(projectId);
		
		List<Question> questionList = MyPropertyUtils.getQuestionServices().findQuestion(cond);
		
		if(!CommonUtils.isCollectionEmpty(questionList)){
			
			for(Question question : questionList){
				
				map.put(question.getId() + "", question.getQuestionName());
				
				if(question.getAreaId() == 1){
					
					selectValue = question.getId() + "";
				}
				
			}
		}
		
		return CommonUtils.getSelectContent(map, selectValue, false);
		
	}
	
	/**
	 * 返回QuestionTopic的选项
	 * @param topic
	 * @return
	 */
	public static String getQuestionTopicHtml(QuestionTopic topic){
		
		StringBuffer sb = new StringBuffer();
		
		String type = topic.getTopicType();
		String topicContent = "";
		
		if("1".equals(type)){
			//表示为单选
			topicContent = topic.getTopicContent();
			
			String[] contents = topicContent.split("\r\n");
			if(!CommonUtils.isCollectionEmpty(contents)){
				
				sb.append("<select name='").append(QUESTION_TOPIC).append(topic.getId()).append("'>");
				
				Map<String, String> map = new LinkedHashMap<String, String>();
				int length = contents.length;
				
				for(int i=0; i<length; i++){
					
					//map.put(i+"", contents[i]);
					map.put(contents[i], contents[i]);
				}
				
				sb.append(CommonUtils.getSelectContent(map, "", true));
				
				sb.append("</select>");
				
			}
			
			sb.append("<input type='text' name='").append(QUESTION_OTHER_OPTION).append(topic.getId()).append("'/>");
			
		}else if("2".equals(type)){
			//表示为多选
			topicContent = topic.getTopicContent();
			
			String[] contents = topicContent.split("\r\n");
			if(!CommonUtils.isCollectionEmpty(contents)){
				
				sb.append("<fieldset data-role='controlgroup'>");
				
				Map<String, String> map = new LinkedHashMap<String, String>();
				int length = contents.length;
				
				for(int i=0; i<length; i++){
					
					//map.put(i+"", contents[i]);
					map.put(contents[i], contents[i]);
				}
				
				sb.append(getCheckboxHtml(map, QUESTION_TOPIC + topic.getId()));
				
				sb.append("</fieldset>");
				
			}
			
			sb.append("<input type='text' name='").append(QUESTION_OTHER_OPTION).append(topic.getId()).append("'/>");
			
		}else{
			//表示为输入框
			sb.append("<input type='text' name='").append(QUESTION_OTHER_OPTION).append(topic.getId()).append("'/>");
		}
		
		return sb.toString();
	}
	
	/**
	 * 返回QuestionAnswerDetail的选项
	 * @param topic
	 * @return
	 */
	public static String getQuestionTopicHtml(QuestionAnswerDetail detail){
		
		StringBuffer sb = new StringBuffer();
		
		String type = detail.getTopicType();
		String anwserContent = "";
		
		if("1".equals(type)){
			//表示为单选
			/**
			 *  0:20岁以下
				0:20-30岁以下
				0:30-40岁
				0:40-50岁
				0:50岁以上
			 */
			anwserContent = detail.getAnwserContent();
			
			String[] contents = anwserContent.split("\r\n");
			if(!CommonUtils.isCollectionEmpty(contents)){
				
				sb.append("<select name='").append(QUESTION_TOPIC).append(detail.getId()).append("'>");
				
				Map<String, String> map = new LinkedHashMap<String, String>();
				int length = contents.length; 
				
				String check = ""; //单选选中的值
				String[] value = null; //临时值,如,0:20岁以下

				for(int i=0; i<length; i++){
					
					value = contents[i].split(":");
					
					try{
						
						map.put(value[1], value[1]);
						
						if("1".equals(value[0])){
							check = value[1];
						}
					}catch (Exception e) {
					}
				}
				
				sb.append(CommonUtils.getSelectContent(map, check, true));
				
				sb.append("</select>");
				
				sb.append("<input type='text' name='").append(QUESTION_OTHER_OPTION).append(detail.getId()).append("' value='")
					.append(detail.getOtherOption()).append("'/>");
			}
			
		}else if("2".equals(type)){
			//表示为多选
			anwserContent = detail.getAnwserContent();
			
			String[] contents = anwserContent.split("\r\n");
			if(!CommonUtils.isCollectionEmpty(contents)){
				
				sb.append("<fieldset data-role='controlgroup'>");
				
				Map<String, String> map = new LinkedHashMap<String, String>();
				int length = contents.length;
				
				List<String> checkList = new ArrayList<String>(); //多选选中的值
				String[] value = null; //临时值,如,0:20岁以下
				
				for(int i=0; i<length; i++){
					
					value = contents[i].split(":");
					
					try{
						map.put(value[1], value[1]);
						
						if("1".equals(value[0])){
							checkList.add(value[1]);
						}
					}catch (Exception e) {
					}
				}
				
				sb.append(getCheckboxHtml(map, checkList, QUESTION_TOPIC + detail.getId()));
				
				sb.append("</fieldset>");
				
				sb.append("<input type='text' name='").append(QUESTION_OTHER_OPTION).append(detail.getId()).append("' value='")
					.append(detail.getOtherOption()).append("'/>");
			}
			
		}else{
			//表示为输入框
			sb.append("<input type='text' name='").append(QUESTION_OTHER_OPTION).append(detail.getId()).append("' value='")
				.append(detail.getOtherOption()).append("'/>");
		}
		
		return sb.toString();
	}
	
	/**
	 * 根据map及name返回多选的html<br/>
	 * map的key为下拉框的值,value为下拉框的文本
	 * @param map
	 * @param name
	 * @return
	 */
	public static String getCheckboxHtml(Map<String, String> map, String name){
		
		return getCheckboxHtml(map, null, name);
	}
	
	/**
	 * 根据map及name返回多选的html<br/>
	 * map的key为下拉框的值,value为下拉框的文本,并设定选中的值
	 * @param map
	 * @param vals
	 * @param name
	 * @return
	 */
	public static String getCheckboxHtml(Map<String, String> map, List<String> vals, String name){
		
		if(CommonUtils.isMapEmpty(map)){
			
			return emptyCheckbox(name);
		}
		
		if(CommonUtils.isCollectionEmpty(vals)){
			vals = new ArrayList<String>();
		}
		
		StringBuffer sb = new StringBuffer();
		
		Set<String> keys = map.keySet();
		
		int index = 0;
		for(String key : keys){
			
			sb.append("<input type='checkbox' name='")
				.append(name).append("' value='").append(key).append("' id='").append(name).append("-").append(index).append("' ");
			
			if(vals.contains(key)){
				sb.append(" checked ");
			}
			
			sb.append("><label for='").append(name).append("-").append(index).append("'>").append(map.get(key)).append("</label>");   
			
			index++;
		}
		
		return sb.toString();
	}
	
	/**
	 * 空的checkbox
	 * @param name
	 * @return
	 */
	private static String emptyCheckbox(String name){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<input type='checkbox' name='")
			.append(name).append("' value='' id='").append(name).append("-0'")
			.append("><label for='").append(name).append("-0'>请选择</label>");     
		
		return sb.toString();
	}
	
}
