package com.ihk.setting.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.setting.data.pojo.ProjectText;
import com.ihk.setting.data.services.IProjectTextServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.projecttext.ProjectTextUtils;

/**
 * 自定义文本下拉框
 * @author dtc
 * 2012-8-10
 */
public class ProjectTextAction extends SupperAction{
	
	private static final long serialVersionUID = 6945640661936837100L;
	
	@Autowired
	IProjectTextServices projectTextServices;
	
	/**
	 * 加载datagrid的值
	 * @return
	 * @throws Exception
	 */
	public String getProjectTextListByTypeNameForDataGrid() throws Exception{
		
		List<ProjectText> projectTextList = ProjectTextUtils.getProjectTextListByRequest(request);
		
		String out = ProjectTextUtils.getDataGridContextByProjectTextList(projectTextList);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 重新初始化下拉框combobox的值
	 * @return
	 * @throws Exception
	 */
	public String getProjectTextListByTypeNameForComboBox() throws Exception{
		
		List<ProjectText> projectTextList = ProjectTextUtils.getProjectTextListByRequest(request);
		
		String out = ProjectTextUtils.getComboBoxContextByProjectTextList(projectTextList);
		
		/**
		 * String out = "[{\"projectTextValue\":\"\",\"projectTextText\":\"请选择\",\"selected\":\"true\"}," +
			"{\"projectTextValue\":\"1\",\"projectTextText\":\"Java\"},{\"projectTextValue\":\"__limit__\",\"projectTextText\":\"(管理)\"}]";
		 */
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 保存project_text
	 * @return
	 * @throws Exception
	 */
	public String saveProjectText() throws Exception{
		
		String idCode = request.getParameter("idCode"); //1|东_0|西_;0表示新增,>0表示更新,且为其对应的id
		String typeName = request.getParameter("typeName"); //对应的typeName
		
		List<ProjectText> textList = new ArrayList<ProjectText>(); //处理完字符串后,如果为空,就应该清空对应的typeName的记录
		ProjectText text = null;
		
		if(!CommonUtils.isStrEmpty(idCode)){
			
			String[] idAndCodes = idCode.split("_"); //[1|东,0|西]
			for(String idAndCode : idAndCodes){
				
				if(!CommonUtils.isStrEmpty(idAndCode)){
					
					text = new ProjectText();
					
					String[] oneIdCode = idAndCode.split("\\|");
					String id = oneIdCode[0];
					String code = oneIdCode[1];
					
					//新增空的值就跳过
					if("0".equals(id) && CommonUtils.isStrEmpty(code)){
						
						continue;
					}
					
					text.setId(Integer.parseInt(id));
					text.setCodeDesc(code);
					
					textList.add(text);
					
				}
				
			}
			
		}
		
		if(CommonUtils.isCollectionEmpty(textList)){
			//删除对应typeName的projectText
			
			try{
				
				projectTextServices.deleteProjectTextByTypeName(typeName);
				CustomerUtils.writeResponse(response, "{\"type\":\"true\"}");
			}catch(Exception e){
				CustomerUtils.writeResponse(response, "{\"type\":\"false\"}");
			}
			
		}else{
			//如果projectText的id为0表示增加,不为0表示更新
			
			ProjectText maxOrderText = projectTextServices.findMaxOrderProjectTextByProjectIdAndTypeName(SessionUser.getProjectId(), typeName);
			int order = 0;
			if(maxOrderText != null){
				order = maxOrderText.getCodeOrder();
			}
			
			final List<ProjectText> updateTextList = new ArrayList<ProjectText>();
			final List<ProjectText> deleteTextList = new ArrayList<ProjectText>();
			final List<ProjectText> addTextList = new ArrayList<ProjectText>();
			
			String textType = request.getParameter("textType");
			String mainId = request.getParameter("mainId");
			
			for(ProjectText tmpText : textList){
				
				if(tmpText.getId() != 0){
					
					updateTextList.add(tmpText);
				}else{
					
					order++;
					tmpText.setCodeOrder(order);
					
					if(CommonUtils.isStrZeroJsEmpty(textType) || CommonUtils.isStrZeroJsEmpty(mainId)){
						//没有对应的text_type及main_id就设置登陆者的公司项目id
						tmpText.setProjectId(SessionUser.getProjectId());						
					}else{
						//否则就设置对应的text_type及main_id,但是不用设定公司项目id
						tmpText.setTextType(Integer.parseInt(textType));
						tmpText.setMainId(Integer.parseInt(mainId));
					}
					
					
					tmpText.setTypeName(typeName);
					
					addTextList.add(tmpText);
				}
			}
			
			List<ProjectText> projectTextList = ProjectTextUtils.getProjectTextListByTypeName(typeName);
			if(projectTextList.size() > updateTextList.size()){
				
				for(ProjectText deteleText : projectTextList){
					
					if(!ProjectTextUtils.isListHave(updateTextList, deteleText.getId())){
						
						deleteTextList.add(deteleText);
					}
				}
			}
			
			//进行增加,删除或更新
			
			boolean isSucc = true;
			try{
				new MyTransationTemplate() {
					
					@Override
					protected void doExecuteCallback() throws Exception {
						
						if(!CommonUtils.isCollectionEmpty(updateTextList)){
							
							for(ProjectText updateText : updateTextList){
								
								projectTextServices.updateProjectTextCodeDesc(updateText);
								
							}
							
						}
						
						if(!CommonUtils.isCollectionEmpty(deleteTextList)){
							
							for(ProjectText deleteText : deleteTextList){
								
								projectTextServices.deleteProjectText(deleteText.getId());
							}
						}
						
						if(!CommonUtils.isCollectionEmpty(addTextList)){
							
							for(ProjectText addText : addTextList){
								
								CommonPojoUtils.initPojoCommonFiled(addText);
								
								projectTextServices.addProjectText(addText);
							}
							
						}
						
					}
				}.execute();
				
			}catch(Exception e){
				isSucc = false;
			}
			
			if(isSucc){
				
				CustomerUtils.writeResponse(response, "{\"type\":\"true\"}");
			}else{
				
				CustomerUtils.writeResponse(response, "{\"type\":\"false\"}");
			}
			
		}
		
		return null;
	}
	
}
