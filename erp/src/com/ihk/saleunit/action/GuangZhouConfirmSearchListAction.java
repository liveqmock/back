package com.ihk.saleunit.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.utils.ActionPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 *  认购查询列表
 */
public class GuangZhouConfirmSearchListAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IConfirmServices confirmServices; 
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IPropertyBuildServices buildServices;

	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String searchList() throws Exception{
		
		if(cond == null){
			cond = new ConfirmCond();
		}
		
		//对cond进行相关的处理,看是否需要查数据库
		boolean isSearch = initCondForSearchDb(cond);
		if(!isSearch){
			
			confirmList = new ArrayList<Confirm>();
		}else{

			ActionTemplate actionTemplate = new ActionTemplate(this, cond);
			actionTemplate.executePage(new ActionPageCallback() {
				
				@Override
				public void initActionPageList() {
					
					confirmList = confirmServices.findConfirmPage(cond);
				}
			});
		}
		
		String deleteSession = request.getParameter("deleteSession");
		
		if(!"false".equals(deleteSession)){
			removeSuggestion();
		}
		
		return "searchList";
	}
	
	/**
	 * 排序
	 * @return
	 */
	public String searchOrderBy(){

		final ActionTemplate actionTemplate = new ActionTemplate(this, cond, true);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				confirmList = confirmServices.findConfirmPage((ConfirmCond) actionTemplate.getCond());
				//confirmList = confirmServices.findConfirmPage(cond); //这样会出现null的情况
			}
		});
		
		return "searchList";
	}
	
	/**
	 * 初始化cond,根据返回判断要不要去查询数据库,因为一些情况可能查数据库得到的list也是为空
	 * @param cond
	 * @return false表示不用去查数据库
	 */
	private boolean initCondForSearchDb(ConfirmCond cond){
		
		if(cond.getUnitIds() == null){
			cond.setUnitIds(new ArrayList<String>());
		}
		
		if(CommonUtils.isStrZeroEmpty(cond.getUnitId())){
			
			if(CommonUtils.isStrZeroEmpty(cond.getBuildId())){
				
				if(!CommonUtils.isStrZeroEmpty(cond.getPropertyId())){
					
					String propertyId = cond.getPropertyId();
					
					List<PropertyBuild> buildList = buildServices.findPropertyBuildByPropertyId(Integer.parseInt(propertyId));
					if(CommonUtils.isCollectionEmpty(buildList)){
						
						return false;
					}
					
					for(PropertyBuild build : buildList){
						
						List<PropertyUnit> unitList = unitServices.findUnitsByBuildId(build.getId());
						for(PropertyUnit unit : unitList){
							
							cond.getUnitIds().add(unit.getId() + "");
						}
					}
					
					if(CommonUtils.isCollectionEmpty(cond.getUnitIds())){
						
						return false;
					}
					
				}
				
			}else{
				
				String buildId = cond.getBuildId();
				
				List<PropertyUnit> unitList = unitServices.findUnitsByBuildId(Integer.parseInt(buildId));
				for(PropertyUnit unit : unitList){
					
					cond.getUnitIds().add(unit.getId() + "");
				}
				
				if(CommonUtils.isCollectionEmpty(cond.getUnitIds())){
					
					return false;
				}
				
			}
			
		}else{
			
			cond.setUnitId(cond.getUnitId());
		}
		
		return true;
	}
	
	
	////////////////////
	
	private List<Confirm> confirmList;
	private ConfirmCond cond;

	public List<Confirm> getConfirmList() {
		return confirmList;
	}

	public void setConfirmList(List<Confirm> confirmList) {
		this.confirmList = confirmList;
	}

	public ConfirmCond getCond() {
		return cond;
	}

	public void setCond(ConfirmCond cond) {
		this.cond = cond;
	}
	
	
}
