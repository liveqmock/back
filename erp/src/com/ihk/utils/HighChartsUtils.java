package com.ihk.utils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.services.ICodeDtlServices;
import com.ihk.setting.data.services.ICodeTypeServices;

/**
 * 曲线的公用类
 * 2012-9-29
 */
public class HighChartsUtils {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(DescUtils.class);
	
	
	public static final String color0 = "#4572A7";
	public static final String color1 = "#89A54E";
	public static final String color2 = "#AA4643";
	public static final String color3 = "#4572A7";
	public static final String color4 = "#4572A7";
	public static final String color5 = "#4572A7";
	public static final String color6 = "#4572A7";
	
	
	//转换成x坐标的格式
	private static String toStringXAxis(DateTime[] dts){
		return toStringXAxis(dts,"MM-dd");
	}
	
	private static String toStringXAxis(DateTime[] dts,String format){
		StringBuilder sb = new StringBuilder("[");
		for(int i=0;i<dts.length;i++){
			sb.append("'");
			sb.append(dts[i].toString(format));
			sb.append("'");
			
			if(i<dts.length-1){
				sb.append(",");
			}
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	
	// 日期x坐标，作为x轴个格式返回
	// 参数 '2011-11-01','2011-11-04'
	// 返回['11-01','11-02','11-03','11-04']
	public static  String getDaysXAxis(String date1, String date2) {
		DateTime[] dts = DateTimeUtils.getDates(date1,date2);	
		
		return toStringXAxis(dts);
	}
	
	
	// 日期范围内的所有星期一形成的x坐标格式的字符串
	// 参数 '2011-11-01','2011-11-30',
	// 返回['10-31','11-07','11-14','11-21','11-28']
	public static  String getDaysXAxisMonday(String date1, String date2) {
		DateTime[] dts = DateTimeUtils.getMondays(date1,date2);	
		
		return toStringXAxis(dts);
	}
	
	
	// 日期范围内的所有月份第一天形成的x坐标格式的字符串
	// 参数 '2011-09-02','2011-11-28',
	// 返回['09-01','10-01','11-01']
	public static  String getDaysXAxisMonthFirstDay(String date1, String date2) {
		DateTime[] dts = DateTimeUtils.getMonthFirstDays(date1,date2);	
		return toStringXAxis(dts);
	}
	
	// 日期范围内的所有年份第一天形成的x坐标格式的字符串
	// 参数 '2009-09-02','2011-11-28',
	// 返回['2009-01-01','2010-01-01','2011-01-01']
	public static  String getDaysXAxisYearFirstDay(String date1, String date2) {
		DateTime[] dts = DateTimeUtils.getMonthFirstDays(date1,date2);	
		return toStringXAxis(dts,"yyyy-MM-dd");
	}
	

	// 根据x坐标以及哈希表，得到格式字符串，用于显示单一曲线
	public static String getChartSeriesByX(String[] xAxis,String ySeriesName,Map mapLine) {
		StringBuilder sb = new StringBuilder("[");
		sb.append("{name:'" + ySeriesName + "',data:[");

		// 循环日期
		for (int j = 0; j < xAxis.length; j++) {
			String keyN = xAxis[j];
			if (mapLine.containsKey(keyN)) {
				sb.append(String.valueOf(mapLine.get(keyN)));
			} else {
				sb.append("0");
			}

			if ((j + 1) < xAxis.length) {
				sb.append(",");
			}
		}

		sb.append("]}");
		sb.append("]");

		return sb.toString();
	}

	/**
	 * 根据x坐标y坐标以及哈希表，得到格式字符串，用于显示曲线(相同y坐标的情况)<br>
	 * 做两次循环,形成包括空值在内的实际值
	 * 格式为：<br>
	 * Categories,Apples,Pears,Oranges,Bananas;John,8,4,6,5;Jane,3,4,2,3<br>
	 * @param keyStrings (Apples,Pears,Oranges,Bananas;John)
	 * @param keyMap (John,Jane)
	 * @param mapNumValue (根据keyMap与keyString来找数据(keyMap:keyString))
	 * @return
	 */
	public static String getChartDataByXAndMap(String[] keyStrings, Map<String,String> keyMap,
			Map<String,Integer> realData) {
		StringBuilder sb = new StringBuilder("Categories,");

		// 循环日期(第一行)
		for (int j = 0; j < keyStrings.length; j++) {
			sb.append(keyStrings[j]);
			if ((j + 1) < keyStrings.length) {
				sb.append(",");
			}			
		}

		sb.append(";");

		Set<Entry<String, String>> set =keyMap.entrySet();
		Iterator it=set.iterator();
       	while(it.hasNext()){
       		Map.Entry<String, String>  entry=(Entry<String, String>) it.next();
       		sb.append(entry.getValue() + ",");       		

			// 循环日期
			for (int j = 0; j < keyStrings.length; j++) {
				String keyN = entry.getKey() + ":" + keyStrings[j];
				if (realData.containsKey(keyN)) {
					sb.append(String.valueOf(realData.get(keyN)));
				} else {
					sb.append("0");
				}

				if ((j + 1) < keyStrings.length) {
					sb.append(",");
				}
			}
			if(it.hasNext()){
				sb.append(";");
			}
       	}

		return sb.toString();
	}
	
	// 根据x坐标y坐标以及哈希表，得到格式字符串，用于显示曲线(相同y坐标的情况)
	public static String getChartSeriesByXY(String[] xAxis, String[] yAxis,
			Map mapLine, String[] yAxisShow) {
		StringBuilder sb = new StringBuilder("[");

		// 循环项目
		for (int i = 0; i < yAxisShow.length; i++) {
			String projectName = yAxisShow[i];//DescUtils.getCompanyProjectRealName(Integer.parseInt(yAxis[i]));
			sb.append("{name:'" + projectName + "',data:[");

			// 循环日期
			for (int j = 0; j < xAxis.length; j++) {
				String keyN = yAxis[i] + ":" + xAxis[j];
				if (mapLine.containsKey(keyN)) {
					sb.append(String.valueOf(mapLine.get(keyN)));
				} else {
					sb.append("0");
				}

				if ((j + 1) < xAxis.length) {
					sb.append(",");
				}
			}

			sb.append("]}");

			if ((i + 1) < yAxis.length) {
				sb.append(",");
			}
		}

		sb.append("]");

		return sb.toString();
	}
	
	// 根据x坐标y坐标以及哈希表，得到格式字符串，用于显示曲线(多个y坐标的情况)
	public static String getChartSeriesByXYMulY(String[] xAxis, String[] yAxis,
			Map mapLine, String[] yAxisShow,String[] yAxisType) {
		StringBuilder sb = new StringBuilder("[");

		// 循环项目
		for (int i = 0; i < yAxisShow.length; i++) {
			String showName = yAxisShow[i];//DescUtils.getCompanyProjectRealName(Integer.parseInt(yAxis[i]));
			sb.append("{name:'" + showName + "',");
			sb.append("color: '"+getColorByOrder(i)+"',");
			sb.append("type: '"+yAxisType[i]+"',");
			sb.append("yAxis: "+String.valueOf(i)+",");
			
			sb.append("data:[");

			// 循环日期
			for (int j = 0; j < xAxis.length; j++) {
				String keyN = yAxis[i] + ":" + xAxis[j];
				if (mapLine.containsKey(keyN)) {
					sb.append(String.valueOf(mapLine.get(keyN)));
				} else {
					sb.append("0");
				}

				if ((j + 1) < xAxis.length) {
					sb.append(",");
				}
			}

			sb.append("]}");

			if ((i + 1) < yAxis.length) {
				sb.append(",");
			}
		}

		sb.append("]");

		return sb.toString();
	}
	
	//除法求值
	public static BigDecimal divideW(BigDecimal val,int beDevide,int pointNum){
		return val.divide(new BigDecimal(beDevide), pointNum, RoundingMode.HALF_EVEN);
	}
	
	//得到顺序对应的颜色
	public static String getColorByOrder(int orderIndex){
		if(orderIndex==0){
			return color0;
		}
		else if(orderIndex==1){
			return color1;
		}
		else if(orderIndex==2){
			return color2;
		}
		else if(orderIndex==3){
			return color3;
		}
		else if(orderIndex==4){
			return color4;
		}
		else if(orderIndex==5){
			return color5;
		}
		else if(orderIndex==6){
			return color6;
		}
		
		
		return color0;
	}
	
	//得到y坐标
	public static String getYAxisElement(String title,String unitName,int orderIndex,boolean isOpposite){
		StringBuilder sb = new StringBuilder("{");
		sb.append("allowDecimals: false,min:0,");
		sb.append("title: {");
		sb.append("text:'"+title+"',");
		sb.append("style: {");
		sb.append("color: '"+getColorByOrder(orderIndex)+"'");
		sb.append("}");
		sb.append("},");
		sb.append("labels: {");
		sb.append("formatter: function() {");
		sb.append("return this.value +' "+unitName+"';");
		sb.append("},");
		sb.append("style: {");
		sb.append("color: '"+getColorByOrder(orderIndex)+"'");
		sb.append("}");
		sb.append("}");
					
		if(isOpposite==true){
		sb.append(",opposite: true");
		}		
		
		sb.append("}");
					
		return sb.toString();
	}

    /**
     * 拼合一维数组为字符串。
     * <B>拆分字串按指定字符分解到一维数组使用String类的split(String regex)</B>
     * @param param String[] 数组
     * @param spilt String 字符串之间的分离符
     * @return String
     */
    public static String arrayToString(String[] param, String spilt) {
        String rentunstring;
        StringBuffer tempstr = new StringBuffer();
        int len = param.length;
        if(len == 0)return "";
        for (int i = 0; i < len - 1; i++) {
            tempstr.append("'"+param[i]+"'");
            System.out.println(param[i]);
            tempstr.append(spilt);
        }
        tempstr.append("'" + param[len - 1] + "'");
        rentunstring = tempstr.toString();
        return rentunstring;
    }
    public static String arrayToNum(String[] param, String spilt) {
        String rentunstring;
        StringBuffer tempstr = new StringBuffer();
        int len = param.length;
        for (int i = 0; i < len - 1; i++) {
            tempstr.append(param[i]);
            tempstr.append(spilt);
        }
        tempstr.append(param[len - 1]);
        rentunstring = tempstr.toString();
        return rentunstring;
    }

    /**
     * 列表转换成字符串
     * 输出格式举例：
     * 字符串格式[ '广州',  '合盈',  '天津',  '北京',  '安徽']
     * BigDecimal格式[1.00,2.00,0,3.00,4.00]
     * @param list
     * @param fieldName
     * @return
     */
    public static String listToString(List list, String fieldName) {
    	Method metd = null;
    	String fdname = null;

		StringBuilder sb = new StringBuilder("[");
        try {
	    	for(int i=0;i<list.size();i++) {
	    		Object object = list.get(i);
	            Class clazz = object.getClass();// 获取集合中的对象类型	
                metd = clazz.getMethod("get" + changeMethodName(fieldName), null);// 根据字段名找到对应的get方法，null表示无参数

                if (metd != null) {// 比较是否在字段数组中存在name字段，如果不存在短路，如果存在继续判断该字段的get方法是否存在，同时存在继续执行
                    Object fieldValue = metd.invoke(object, null);// 调用该字段的get方法
                    
                if(metd.getReturnType()==BigDecimal.class){
                    if(fieldValue==null){
                    	fieldValue = BigDecimal.valueOf(0);//默认值
                    }
                    sb.append(fieldValue.toString());
                    
                }
                else {
                    if(fieldValue==null){
                		fieldValue = "";
                    }
                    sb.append("'"+fieldValue.toString()+"'");
                	}
                }

				if ((i + 1) < list.size()) {
					sb.append(",");
				}
	        }
        }catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

		sb.append("]");
		
		return sb.toString();
    }

    /**
     * 转换为MethodName形式(大小写)
     * methodName转为MethodName
     * @param src
     * @return
     */
    private static String changeMethodName(String src) {
        if (src != null) {
            StringBuffer sb = new StringBuffer(src);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            return sb.toString();
        } else {
            return null;
        }
    }

    
   /**
    * 获取工作区域,居住区域对应的region表的值
    * @param codeTypeServices
    * @param codeDtlServices
    * @param customerCond
    * @param selCategory
    * @param listCode
    * @return
    */
    public static List<CodeDtl> initCodeDtlListForHomeWorkDistrict(ICodeTypeServices codeTypeServices, ICodeDtlServices codeDtlServices, 
    		CustomerCond customerCond, String selCategory, List<CodeDtl> listCode){
    	
    	int defalutProjectId = ContProjectId.GUANG_ZHOU;
		if(!CommonUtils.isCollectionEmpty(customerCond.getSearchProjectIds())){
			
			defalutProjectId = customerCond.getSearchProjectIds().get(0);
		}
		
		try{
			if(selCategory.matches("^[0-9]+$")){
				listCode = codeTypeServices.findCodeList(selCategory, defalutProjectId);
			}else{
				listCode = codeTypeServices.findCodeList(EnumCodeTypeName.valueOf(selCategory).name(), defalutProjectId);
			}
			
			
		}catch(Exception ex){
			
			customerCond.setHomeOrWork(selCategory.trim().toLowerCase());
	    	
			//追加权限限制
			customerCond.addPermissionChartProjectIds();
			
			listCode = codeDtlServices.findCodeDtlListForHomeWorkDistrict(customerCond);
			
			
			//去除查询出来出现Null造成空指针的情况
			Iterator<CodeDtl> it;
			for(it=listCode.iterator();it.hasNext();){
				CodeDtl codeDtl=it.next();
				if(codeDtl==null){
					it.remove();
				}
			}
			
			
			for(CodeDtl dtl : listCode){
				
				if(dtl!=null&&"0".equals(dtl.getCodeVal())){
					dtl.setCodeDesc("其他");
					break;
				}
			}
		}
    	
    	return listCode;
    	
    }
    
}