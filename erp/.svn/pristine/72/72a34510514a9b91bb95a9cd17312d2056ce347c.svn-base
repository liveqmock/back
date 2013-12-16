package com.ihk.setup.payway;

import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunitnew.PropertyTreeUtils;

/**
 * 项目付款方式action
 * @author dtc
 * 2012-11-1,下午02:16:50
 */
public class ProjectPayWayAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	public String left() throws Exception{
		
		String treeJson = PropertyTreeUtils.getLayoutLeftTreeOnlyPropertyProjectBySelectProId(request);
		
		CustomerUtils.writeResponse(response, treeJson);
		
		return null;
	}
	
	

}
