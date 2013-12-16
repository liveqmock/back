package com.ihk.demo.action.easyui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.demo.data.pojo.DemoTable;
import com.ihk.demo.data.pojo.DemoTableCond;
import com.ihk.demo.data.services.IDemoTableServices;
import com.ihk.utils.ActionPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.SupperAction;

/**
 * demo(数据表table)的基本操作
 * 仅涉及基本增删改查特殊处理
 * 基本代码框架由代码生成器生成
 * 2012-8-29
 */
public class DemoTableAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IDemoTableServices demoTableServices;
	
	/**
	 * 主页面
	 * @return
	 * @throws Exception
	 */
	public String layout() throws Exception{
		
		return "layout";
	}
	
	/**
	 * 查询列表
	 * @return
	 * @throws Exception
	 */
	public String searchList() throws Exception{
		
		if(cond == null){
			cond = new DemoTableCond();
		}
		
		ActionTemplate actionTemplate = new ActionTemplate(this, cond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				demoTableList = demoTableServices.findDemoTablePage(cond);
			}
		});
		
		return "finish";
	}
	
	/**
	 * 查询排序列表
	 * @return
	 * @throws Exception
	 */
	public String searchOrderBy() throws Exception{
		
		final ActionTemplate actionTemplate = new ActionTemplate(this, cond, true);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				demoTableList = demoTableServices.findDemoTablePage((DemoTableCond) actionTemplate.getCond());
				
			}
		});
		
		return "finish";
	}
	
	/**
	 * 新增数据提交前的页面
	 * @return
	 * @throws Exception
	 */
	public String forInput() throws Exception{
		
		removeSuggestion();
		
		return "finish";
	}
	
	/**
	 * 新增数据提交后的处理与页面
	 * @return
	 * @throws Exception
	 */
	public String inputData() throws Exception{
		try{
			
			CommonPojoUtils.initPojoCommonFiled(demoTable);
			demoTableServices.addDemoTable(demoTable);

			setUpMarkToClose();
			setSuggestion_Success();
			
		}
		catch(Exception e){			
			setSuggestion_Fail();
		}
		
		return "finish";
	}
	
	/**
	 * 取得一条数据显示的页面
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception{
		
		demoTable = demoTableServices.findDemoTableById(Integer.parseInt(request.getParameter("id")));
		
		removeSuggestion();
		
		return "finish";
	}
	
	/**
	 * 执行修改数据的处理与页面
	 * @return
	 * @throws Exception
	 */
	public String updateData() throws Exception{
		
		try{
			
			DemoTable oldDemoTable = demoTableServices.findDemoTableById(demoTable.getId());
			CommonPojoUtils.initPojoForUpdate(oldDemoTable, demoTable);
			demoTableServices.updateDemoTable(demoTable);
			
			setUpMarkToClose();
			setSuggestion_Success();
			
		}
		catch(Exception e){			
			setSuggestion_Fail();
		}
		
		return "finish";
	}
	
	/**
	 * 执行删除数据的处理与页面
	 * @return
	 * @throws Exception
	 */
	public String deleteData() throws Exception{
		
		try{
			
			demoTableServices.deleteDemoTable(Integer.parseInt(request.getParameter("id")));

			setUpMarkToClose();
			setSuggestion_Success();
			
		}
		catch(Exception e){			
			setSuggestion_Fail();
		}
		
		return searchList();
	}
	
	
	//
	
	private DemoTable demoTable;
	private DemoTableCond cond;
	private List<DemoTable> demoTableList;

	public DemoTable getDemoTable() {
		return demoTable;
	}

	public void setDemoTable(DemoTable demoTable) {
		this.demoTable = demoTable;
	}

	public DemoTableCond getCond() {
		return cond;
	}

	public void setCond(DemoTableCond cond) {
		this.cond = cond;
	}

	public List<DemoTable> getDemoTableList() {
		return demoTableList;
	}

	public void setDemoTableList(List<DemoTable> demoTableList) {
		this.demoTableList = demoTableList;
	}

	
}
