package com.ihk.user.action;

import java.util.LinkedHashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.user.data.pojo.FuncTree;
import com.ihk.user.data.pojo.Priv;
import com.ihk.user.data.pojo.PrivFunc;
import com.ihk.user.data.services.IFuncTreeServices;
import com.ihk.user.data.services.IPrivFuncServices;
import com.ihk.user.data.services.IPrivServices;
import com.ihk.utils.SupperAction;

/**
 * 
 * 数据库控制tree 已没有使用
 * */
@Deprecated
public class PrivFuncAction extends SupperAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IPrivFuncServices  iPrivFuncServices;
	@Autowired
	private IFuncTreeServices iFuncTreeServices;
	@Autowired
	private IPrivServices iPrivServices;
	
//	private List<PrivFuncName> list;
//	private PrivFuncName privFuncName;
	private PrivFunc privFunc;
	
	private List<FuncTree> privFunclist;
	private LinkedHashMap<String, String> selPrivFunc;
	private LinkedHashMap<String, String> selPriv;
	private FuncTree funcTree;
	
	private List<Priv> privList;
	private Priv priv;
	
	private List<LinkedHashMap<String, String>> list;
	private String suggestion;
	private String suggestion2;
	
	
//	public PrivFuncName getPrivFuncName() {
//		return privFuncName;
//	}
//
//	public void setPrivFuncName(PrivFuncName privFuncName) {
//		this.privFuncName = privFuncName;
//	}
	
	public String getSuggestion() {
		return suggestion;
	}

	public String getSuggestion2() {
		return suggestion2;
	}

	public void setSuggestion2(String suggestion2) {
		this.suggestion2 = suggestion2;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public LinkedHashMap<String, String> getSelPriv() {
		return selPriv;
	}

	public void setSelPriv(LinkedHashMap<String, String> selPriv) {
		this.selPriv = selPriv;
	}

	
	
	public void setSelPrivFunc(LinkedHashMap<String, String> selPrivFunc) {
		this.selPrivFunc = selPrivFunc;
	}
	
	public LinkedHashMap<String, String> getSelPrivFunc() {
		return selPrivFunc;
	}

	public List<Priv> getPrivList() {
		return privList;
	}

	public void setPrivList(List<Priv> privList) {
		this.privList = privList;
	}

	public Priv getPriv() {
		return priv;
	}

	public void setPriv(Priv priv) {
		this.priv = priv;
	}

	public FuncTree getFuncTree() {
		return funcTree;
	}

	public void setFuncTree(FuncTree funcTree) {
		this.funcTree = funcTree;
	}

	public List<FuncTree> getPrivFunclist() {
		return privFunclist;
	}

	public void setPrivFunclist(List<FuncTree> privFunclist) {
		this.privFunclist = privFunclist;
	}

	public PrivFunc getPrivFunc() {
		return privFunc;
	}

	public void setPrivFunc(PrivFunc privFunc) {
		this.privFunc = privFunc;
	}

//	public List<PrivFuncName> getList() {
//		return list;
//	}
//
//	public void setList(List<PrivFuncName> list) {
//		this.list = list;
//	}

	public String privfunc_list(){
		list =iPrivFuncServices.findAll();
		return "list"; 
     }
	public List<LinkedHashMap<String, String>> getList() {
		return list;
	}

	public void setList(List<LinkedHashMap<String, String>> list) {
		this.list = list;
	}

	public String queryTreeByName(){
	list = iPrivFuncServices.findListByName(priv);
		return "findbyname";
	}
	public String tree_update(){
		
		setSuggestion("");
		setSuggestion2("");
		selPrivFunc = new LinkedHashMap<String, String>();
		selPriv  = new LinkedHashMap<String, String>();
		privFunclist = iFuncTreeServices.findAll();
		for(FuncTree tree : privFunclist){
			selPrivFunc.put(tree.getTreeCode(), tree.getTreeName());
		}
		
		privList = iPrivServices.findAll();
		for(Priv priv : privList){
			selPriv.put(priv.getPrivCode(), priv.getPrivName());
		}
		request.getSession().setAttribute("selPrivFunc", selPrivFunc);
		request.getSession().setAttribute("selPriv", selPriv);
		String id = request.getParameter("id");
		privFunc =iPrivFuncServices.findPrivFuncById(Integer.parseInt(id));
		
		return "update";
	}
	
	public String tree_updated(){
		
		iPrivFuncServices.updatePrivFunc(privFunc);
		selPrivFunc =(LinkedHashMap<String, String>) request.getSession().getAttribute("selPrivFunc");
		selPriv=(LinkedHashMap<String, String>)request.getSession().getAttribute("selPriv");
		setSuggestion("修改成功");
		setSuggestion2("修改成功");
		request.getSession().setAttribute("suggestion", suggestion);
		return "updated";
		
	}
	
	public String tree_add(){
	
		setSuggestion("");
		setSuggestion2("");
		selPrivFunc = new LinkedHashMap<String, String>();
		selPriv  = new LinkedHashMap<String, String>();
		privFunclist = iFuncTreeServices.findAll();
		for(FuncTree tree : privFunclist){
			selPrivFunc.put(tree.getTreeCode(), tree.getTreeName());
		}
		
		privList = iPrivServices.findAll();
		for(Priv priv : privList){
			selPriv.put(priv.getPrivCode(), priv.getPrivName());
		}
		request.getSession().setAttribute("selPrivFunc", selPrivFunc);
		request.getSession().setAttribute("selPriv", selPriv);
		return "add";
	}
	
	public String tree_added(){
		selPrivFunc =(LinkedHashMap<String, String>) request.getSession().getAttribute("selPrivFunc");
		selPriv=(LinkedHashMap<String, String>)request.getSession().getAttribute("selPriv");
		setSuggestion("添加成功");
		setSuggestion2("添加成功");
		iPrivFuncServices.addPrivFunc(privFunc);
		return "added";
	}
}
