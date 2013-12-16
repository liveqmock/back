package com.ihk.saleunit.action.new_financial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumProjectTextType;
import com.ihk.setting.data.pojo.ProjectText;
import com.ihk.setting.data.services.IProjectTextServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.common.setup.PayTypeUtils;
import com.ihk.utils.projecttext.ProjectTextUtils;

/**
 * 关于财务一些
 * @author dtc
 * 2013-1-9,上午10:47:45
 */
public class CommonUtilsAction extends SupperAction{
	
	private static final long serialVersionUID = -6830273317239786495L;
	
	@Autowired
	IProjectTextServices textServices;

	/**
	 * 收款类别及收款内容的级联
	 * @return
	 * @throws Exception
	 */
	public String payTypeToFeeType() throws Exception{
		
		String payTypeId = request.getParameter("payTypeId");
		String defaultValue = request.getParameter("default");
		
		List<ProjectText> projectTextList = ProjectTextUtils.getProjectTextListByTypeName(payTypeId);
		
		String out = ProjectTextUtils.getComboBoxContextByProjectTextList(projectTextList, defaultValue);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 根据收款类别及付款方式id设置,收款类别及收款内容的级联
	 * @return
	 * @throws Exception
	 */
	public String payTypeToFeeTypeAndWayId() throws Exception{
		
		String typeName = request.getParameter("payTypeId"); //收费类别
		String defaultValue = request.getParameter("default"); //收款内容默认值
		int wayId = Integer.parseInt(request.getParameter("wayId")); //付款方式id
		
		List<ProjectText> projectTextList = ProjectTextUtils
			.getProjectTextListByTypeNameAndTextTypeAndMainId(typeName, EnumProjectTextType.PAY_WAY.getType(), wayId);
		
		String out = ProjectTextUtils.getComboBoxContextByProjectTextList(projectTextList, defaultValue);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 收款类别的值转成对应的key
	 * @return
	 * @throws Exception
	 */
	public String payTypeValueToKey() throws Exception{
		
		String payTypeValue = request.getParameter("payTypeValue");
		
		String key = PayTypeUtils.getPayTypeKeyByValue(payTypeValue);
		
		CustomerUtils.writeResponse(response, key);
		
		return null;
	}
	
	/**
	 * 根据收费类别获取固定的收款内容
	 * @return
	 * @throws Exception
	 */
	public String getFixedFeeByType() throws Exception{
		
		String payTypeValue = request.getParameter("payTypeValue");
		String feeValue = request.getParameter("feeValue");
		
		String out = PayTypeUtils.getFixedFeeRadioHtmlByType(payTypeValue, feeValue);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}

}
