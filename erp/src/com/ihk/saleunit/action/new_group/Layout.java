package com.ihk.saleunit.action.new_group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.property.data.services.impl.PropertyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunitnew.GroupDataLeftBean;
import com.ihk.utils.saleunitnew.GroupDataUtils;

/**
 *  数据分组
 */
public class Layout extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	PropertyProjectServices projectServices;
	
	public String groupLayout() throws Exception{
		
		return "groupLayout";
	}
	
	public String layoutLeftGroup() throws Exception{
		
		/*StringBuffer sb = new StringBuffer();
		
		sb.append("[")
		.append("{\"text\":\"单元内容\",\"state\":\"closed\",\"children\":")
		.append("[{\"id\":\"1\",\"text\":\"<input type='checkbox'/><span class='check_name'>楼栋</span><span class='search' id='s1'></span>\",\"attributes\":{\"type\":\"endNode\"}}")
		.append(",{\"id\":\"2\",\"text\":\"<input type='checkbox'/><span class='check_name'>分区</span><span class='search' id='s2'></span>\",\"attributes\":{\"type\":\"endNode\"}}")
		.append(",{\"id\":\"3\",\"text\":\"<input type='checkbox'/><span class='check_name'>楼盘</span><span class='search' id='s3'></span>\",\"attributes\":{\"type\":\"endNode\"}}]")
		.append("}")
		.append(",")
		.append("{\"text\":\"单元内容2\",\"state\":\"closed\",\"children\":")
		.append("[{\"id\":\"1\",\"text\":\"<input type='checkbox'/><span class='check_name'>楼栋</span><span class='search' id='s1'></span>\",\"attributes\":{\"type\":\"endNode\"}}")
		.append(",{\"id\":\"2\",\"text\":\"<input type='checkbox'/><span class='check_name'>分区</span><span class='search' id='s2'></span>\",\"attributes\":{\"type\":\"endNode\"}}")
		.append(",{\"id\":\"3\",\"text\":\"<input type='checkbox'/><span class='check_name'>楼盘</span><span class='search' id='s3'></span>\",\"attributes\":{\"type\":\"endNode\"}}]")
		.append("}")
		.append(",")
		.append("{\"text\":\"单元内容3\",\"state\":\"closed\",\"children\":")
		.append("[]")
		.append("}")
		.append("]")
		;
		
		CustomerUtils.writeResponse(response, sb.toString());*/
		
		
		LinkedHashMap<String, List<GroupDataLeftBean>> listMap = new LinkedHashMap<String, List<GroupDataLeftBean>>();;
		
		List<GroupDataLeftBean> beanList = new ArrayList<GroupDataLeftBean>();
		
		for(int i=1; i<=4; i++){
			
			GroupDataLeftBean bean = new GroupDataLeftBean();
			bean.setId(i);
			bean.setName(getNameById(i));
			bean.setGroupType(getGroupTypeById(i));
			
			beanList.add(bean);
			
		}
		
		listMap.put("单元内容", beanList);
		
		CustomerUtils.writeResponse(response, GroupDataUtils.initGroupLeft(listMap));
		
		return null;
	}
	
	/**
	 * 获取初始化的相关配置数据
	 * @return
	 * @throws Exception
	 */
	public String groupDataGrid() throws Exception{
		
		String groupby = request.getParameter("groupby"); //grouptype|groupname_grouptype|groupname
		String[] groups = groupby.split("_"); //grouptype|groupname(text:groupname, datafield: grouptype)
		
		List<Map<String, String>> colList = new ArrayList<Map<String,String>>();
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		StringBuffer urlArg = new StringBuffer();
		
		for(String group : groups){
			
			if(!"".equals(group.trim())){
				
				Map<String, String> colMap = new HashMap<String, String>();
				Map<String, String> dataMap = new HashMap<String, String>();
				
				String[] datas = group.split("=");
				colMap.put("text", datas[1]);
				colMap.put("datafield", datas[0]);
				
				dataMap.put("name", datas[0]);
				
				colList.add(colMap);
				dataList.add(dataMap);
				
				urlArg.append(datas[0]).append("_");
				
			}
		}
		
		String columns = CommonUtils.getListMapJsonAnd(colList);
		String datafields = CommonUtils.getListMapJsonAnd(dataList);
		
		//String columns = "[{ text: '公司名称', datafield: 'CompanyName'},{ text: '城市', datafield: 'City'},{text: '国家', datafield: 'Country'}]";
		//String datafields = "[{ name: 'CompanyName' },{ name: 'City' },{ name: 'Country' }]";
		String url = "./saleunit_new/appoint/guangzhou/groupData.action?groupDataBy=" + urlArg.toString();
		
		if(dataGrid == null){
			
			dataGrid = new HashMap<String, String>();
			dataGrid.put("columns", columns);
			dataGrid.put("datafields", datafields);
			dataGrid.put("url", url);
			
		}
		
		return "groupDataGrid";
	}
	
	/**
	 * 获取实际的分组数据
	 * @return
	 * @throws Exception
	 */
	public String groupData() throws Exception{
		
		String groupDataBy = request.getParameter("groupDataBy"); //name_name
		String[] datas = groupDataBy.split("_");
		
	/*case 1:
		ret = "project";
		break;
	case 2:
		ret = "area";
		break;
	case 3:
		ret = "build";
		break;
	case 4:
		ret = "unit";*/
		
		
		List<PropertyProject> proList = projectServices.findPropertyProject(new PropertyProjectCond());
		List<Map<String, String>> proMapList = new ArrayList<Map<String,String>>();
		Map<String, String> map = null;
		
		for(PropertyProject pro : proList){
			
			map = new HashMap<String, String>();
			map.put("project", pro.getPropertyName());
			
			proMapList.add(map);
			
		}
		
		CustomerUtils.writeResponse(response, CommonUtils.getListMapJsonAnd(proMapList));
		
		/*InputStream is = this.getClass().getResourceAsStream("customers.json");
		InputStreamReader isr = new InputStreamReader(is, Charset.forName(ContCacheAndCode.ENCODING));
		BufferedReader br = new BufferedReader(isr);
		
		StringBuffer sb = new StringBuffer();
		String line = null;
		while((line = br.readLine()) != null){
			
			sb.append(line.toString().trim());
		}
		
		CustomerUtils.writeResponse(response, sb.toString());*/
		
		return null;
	}
	
	////
	
	/**
	 * datafields,id,url,columns
	 */
	private Map<String, String> dataGrid;
	
	public void setDataGrid(Map<String, String> dataGrid) {
		this.dataGrid = dataGrid;
	}
	
	public Map<String, String> getDataGrid() {
		return dataGrid;
	}
	
	private String getNameById(int id){
		
		String ret = "默认值";
		
		switch (id) {
		case 1:
			ret = "楼盘";
			break;
		case 2:
			ret = "分区";
			break;
		case 3:
			ret = "楼栋";
			break;
		case 4:
			ret = "单元";
			break;
		default:
			break;
		}
		
		return ret;
		
	}
	
	private String getGroupTypeById(int id){
		
		String ret = "";
		
		switch (id) {
		case 1:
			ret = "project";
			break;
		case 2:
			ret = "area";
			break;
		case 3:
			ret = "build";
			break;
		case 4:
			ret = "unit";
			break;
		default:
			break;
		}
		
		return ret;
	}

}
