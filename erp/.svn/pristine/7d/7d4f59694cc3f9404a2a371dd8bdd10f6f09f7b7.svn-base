package com.ihk.user.action;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ihk.user.data.pojo.FuncTree;
import com.ihk.user.data.services.IFuncTreeServices;
import com.ihk.utils.SupperAction;

/**
 * 数据库控制tree 
 * 已经没有使用
 * @author Administrator
 *
 */
@Deprecated
public class FuncTreeAction extends SupperAction{
   
	private static final long serialVersionUID = 9064023490475628157L;
	@Autowired
	private IFuncTreeServices iFuncTreeServices;
	
	private List<FuncTree> treeList;
	
	private  FuncTree tree ;
	private String suggestion;
	private String suggestion2;

	


	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getSuggestion2() {
		return suggestion2;
	}

	public void setSuggestion2(String suggestion2) {
		this.suggestion2 = suggestion2;
	}

	public FuncTree getTree() {
		return tree;
	}

	public void setTree(FuncTree tree) {
		this.tree = tree;
	}

	public List<FuncTree> getTreeList() {
		return treeList;
	}

	public void setTreeList(List<FuncTree> treeList) {
		this.treeList = treeList;
	}

	public String tree_list(){
		treeList =iFuncTreeServices.findAll();
		return "list"; 
     }
	
	/**
	 * 2011年最初设计 数据库控制树  已没使用
	 * */
	@Deprecated
	public String queryTreeByName(){
		treeList = iFuncTreeServices.findListByName(tree);
		return "findbyname";
	}
	public String tree_updated(){
		setSuggestion("修改成功");
		setSuggestion2("修改成功");
		iFuncTreeServices.updateFuncTree(tree);
		return "updated";
		
	}
		
	
	public String tree_update(){
		setSuggestion("");
		setSuggestion2("");
		String treecode = request.getParameter("treeCode");
		 tree =iFuncTreeServices.findFuncTreeById(treecode);
		
		return "update";
	}
		
}
