package com.ihk.customer.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.setting.data.pojo.Block;
import com.ihk.setting.data.pojo.BlockCond;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.services.IBlockServices;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;

/**
 *  省,市,区域 下拉框
 */
public class ProviCityRegionAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICityServices cityService;
	@Autowired
	IRegionServices regionServices;
	@Autowired
	IBlockServices blockServices;
	
	public String getCityByProvinceId() throws Exception{
		String content = "<option value=\"\">" + CommonUtils.EMPTY + "</option>"; //默认值
		
		String provinceId = request.getParameter("provinceId");
		try{
			
			List<City> cityList = cityService.findCityByProvinceId(Integer.parseInt(provinceId));
			LinkedHashMap<String, String> cityMap = new LinkedHashMap<String, String>();
			cityMap.put("", CommonUtils.EMPTY);
			
			StringBuffer sb = new StringBuffer();
			
			for(City city : cityList){
				cityMap.put(city.getCityId() + "", city.getCityName());
			}
			
			if(cityMap.keySet().size() > 1){
				Set<String> keys = cityMap.keySet();
				for(String key : keys){
					String value = cityMap.get(key);
					sb.append("<option value=\"")
						.append(key)
						.append("\">")
						.append(value)
						.append("</option>")
						;
				}
				
			}
			
			String getContent = sb.toString();
			if(!CustomerUtils.isStrEmpty(getContent)){
				content = getContent;
			}
			
		}catch(Exception e){
			
		}
		
		CustomerUtils.writeResponse(response, content);
		
		return null;
	}
	
	public String getRegionByCityId() throws Exception{
		
		String content = "<option value=\"\">" + CommonUtils.EMPTY + "</option>"; //默认值
		
		String cityId = request.getParameter("cityId");
		try{
			
			List<Region> regionList = regionServices.findRegionByCityId(Integer.parseInt(cityId));
			LinkedHashMap<String, String> regionMap = new LinkedHashMap<String, String>();
			regionMap.put("", CommonUtils.EMPTY);
			
			StringBuffer sb = new StringBuffer();
			
			for(Region region : regionList){
				regionMap.put(region.getRegionId() + "", region.getRegionName());
			}
			
			if(regionMap.keySet().size() > 1){
				Set<String> keys = regionMap.keySet();
				for(String key : keys){
					String value = regionMap.get(key);
					sb.append("<option value=\"")
						.append(key)
						.append("\">")
						.append(value)
						.append("</option>")
						;
				}
				
			}
			
			String getContent = sb.toString();
			if(!CustomerUtils.isStrEmpty(getContent)){
				content = getContent;
			}
			
		}catch(Exception e){
			
		}
		
		CustomerUtils.writeResponse(response, content);
		
		
		return null;
	}
	
	/**
	 * 改为手工输入
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public String getBlockByRegionId() throws Exception{
		
		String content = "<option value=\"\">" + CommonUtils.EMPTY + "</option>"; //默认值
		
		String regionId = request.getParameter("regionId");
		String projectId = request.getParameter("projectId");
		try{
			
			BlockCond blockCond = new BlockCond();
			blockCond.setProjectId(Integer.parseInt(projectId));
			blockCond.setRegionId(Integer.parseInt(regionId));
			
			List<Block> blockList = blockServices.findBlockByRegionIdAndProjectId(blockCond);
			
			LinkedHashMap<String, String> blockMap = new LinkedHashMap<String, String>();
			blockMap.put("", CommonUtils.EMPTY);
			
			StringBuffer sb = new StringBuffer();
			
			for(Block block : blockList){
				
				blockMap.put(block.getBlockId() + "", block.getBlockName());
			}
			
			if(blockMap.keySet().size() > 1){
				Set<String> keys = blockMap.keySet();
				for(String key : keys){
					String value = blockMap.get(key);
					sb.append("<option value=\"")
						.append(key)
						.append("\">")
						.append(value)
						.append("</option>")
						;
				}
				
			}
			
			String getContent = sb.toString();
			if(!CustomerUtils.isStrEmpty(getContent)){
				content = getContent;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		CustomerUtils.writeResponse(response, content);
		
		return null;
	}
	
}
