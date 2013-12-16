package com.ihk.setup.discount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.ProjectDiscount;
import com.ihk.property.data.services.IProjectDiscountServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunitnew.DiscountManagerUtils;
import com.ihk.utils.saleunitnew.PropertyTreeUtils;

/**
 * 楼盘项目折扣管理
 * @author dtc
 * 2012-10-29,下午02:32:03
 */
@Deprecated
public class ProjectDiscountAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IProjectDiscountServices projectDiscountServices;
	
	public String layout() throws Exception{
		
		return "layout";
	}
	
	public String left() throws Exception{
		
		String treeJson = PropertyTreeUtils.getRoleProjectJson(true);
		
		CustomerUtils.writeResponse(response, treeJson);
		
		return null;
	}
	
	public String toProjectDiscountManager() throws Exception{
		
		projectId = request.getParameter("projectId");
		
		init(projectId);
		
		return "toProjectDiscountManager";
	}
	
	/**
	 * 获取project_discount(楼盘折扣)的table map String
	 * @return
	 * @throws Exception
	 */
	public String ajaxProjectDiscountList() throws Exception{
		
		projectId = request.getParameter("projectId");
		
		//projectDiscountList = projectDiscountServices.findProjectDiscountByProjectId(Integer.parseInt(projectId));
		
		String out = DiscountManagerUtils.projectDiscountListJson(projectDiscountList);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 折扣的增加修改
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public String discountModify() throws Exception{
		
		String out = "true";
		
		try{
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					String someDetail = request.getParameter("someDetail");
					
					projectId = request.getParameter("projectId");
					
					//projectDiscountServices.deleteProjectDiscountByProjectId(Integer.parseInt(projectId));
					
					if(!CommonUtils.isStrEmpty(someDetail)){
						
						List<ProjectDiscount> tmpList = initForAddDiscountDetail(someDetail, Integer.parseInt(projectId));
						for(ProjectDiscount detail : tmpList){
							
							projectDiscountServices.addProjectDiscount(detail);
						}
						
					}
					
				}
			}.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
			out = "false";
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	private void init(String projectId){
		
		url = "./project_discount/manager/ajaxProjectDiscountList.action?projectId=" + projectId;
		
		selTypes = DescUtils.getInitSelForGuangZhou(selTypes, EnumCodeTypeName.SALEUNIT_DISCOUNT_TYPE);
		types = CommonUtils.getMapJsonSetUpKeyAndValueName(selTypes, "typeId", "name");
	}
	
	private List<ProjectDiscount> initForAddDiscountDetail(String someDetail, int projectId) throws Exception{
		//typeId1=3&percent1=99&remark1=&typeId2=4&percent2=97&remark2=&detailCount=2
		
		Map<String, String> map = new HashMap<String, String>();
		
		String[] details = someDetail.split("_");
		for(String detail : details){
			
			String[] tmp = detail.split("=");
			try{
				
				map.put(tmp[0], tmp[1]);
			}catch(Exception e){
				
				map.put(tmp[0], "");
			}
		}
		
		List<ProjectDiscount> retList = new ArrayList<ProjectDiscount>();
		int beanCount = Integer.parseInt(map.get("detailCount"));
		
		for(int i=1; i<=beanCount; i++){
			
			ProjectDiscount tmpDetail = new ProjectDiscount();
			
			String typeId = map.get("typeId" + i);
			String percent = map.get("percent" + i);
			String remark = map.get("remark" + i);
			
			if(CommonUtils.isStrEmpty(typeId) && CommonUtils.isStrEmpty(percent) && CommonUtils.isStrEmpty(remark))
				continue;
			
			tmpDetail.setDiscountType(typeId);
			tmpDetail.setDiscountPercent(CommonUtils.exceptionToZero(percent));
			tmpDetail.setRemark(remark);
			
			CommonPojoUtils.initPojoCommonFiled(tmpDetail);
			
			retList.add(tmpDetail);
			
		}
		
		return retList;
	}
	
	///
	
	private String projectId;
	
	private String types; //类型
	private LinkedHashMap<String, String> selTypes;
	
	private String url; //加载project_discount(楼盘折扣)的详细url
	
	private List<ProjectDiscount> projectDiscountList;
	
	public void setProjectDiscountList(List<ProjectDiscount> projectDiscountList) {
		this.projectDiscountList = projectDiscountList;
	}
	
	public List<ProjectDiscount> getProjectDiscountList() {
		return projectDiscountList;
	}
	
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectId() {
		return projectId;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public LinkedHashMap<String, String> getSelTypes() {
		return selTypes;
	}

	public void setSelTypes(LinkedHashMap<String, String> selTypes) {
		this.selTypes = selTypes;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
