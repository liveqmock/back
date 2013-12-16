package com.ihk.user.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.IPrivMapper;
import com.ihk.user.data.IRolePrivMapper;
import com.ihk.user.data.pojo.Priv;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.RolePriv;
import com.ihk.user.data.pojo.RolePrivAdd;
import com.ihk.user.data.pojo.RolePrivCond;
import com.ihk.user.data.pojo.RolePrivRef;
import com.ihk.user.data.pojo.RolePrivRefCond;
import com.ihk.user.data.pojo.RolePrivTable;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IRoleServices;
import com.ihk.user.data.services.impl.RolePrivRefServices;
import com.ihk.user.data.services.impl.RolePrivServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 2011  控制权限设计  已没有使用
 * 
 * 已修改设计
 * */
@Deprecated
public class RolePrivAction extends SupperAction {
	@Autowired
	RolePrivServices rolePrivServices;
	@Autowired
	IPrivMapper privMapper;
	@Autowired
	RolePrivRefServices rolePrivRefServices;
	@Autowired IRolePrivMapper rolePrivMapper;
	@Autowired IRoleServices roleSevices;
	RolePrivCond cond;
	List<RolePriv> listRolePriv;
	List<RolePrivTable> listtable;
	List<Priv> listpriv;
	List<RolePrivRef> listRolePrivRef;
	List<Role> listRole;
	int id;
	RolePrivAdd add;
	RolePrivRef ref;
	RolePrivRefCond recond;
	List<Map<String,String>> refList;
	
	
	public List<Role> getListRole() {
		return listRole;
	}

	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}

	public List<Map<String, String>> getRefList() {
		return refList;
	}

	public void setRefList(List<Map<String, String>> refList) {
		this.refList = refList;
	}

	public RolePrivRef getRef() {
		return ref;
	}

	public void setRef(RolePrivRef ref) {
		this.ref = ref;
	}

	public RolePrivRefCond getRecond() {
		return recond;
	}

	public void setRecond(RolePrivRefCond recond) {
		this.recond = recond;
	}

	public List<RolePrivRef> getListRolePrivRef() {
		return listRolePrivRef;
	}

	public void setListRolePrivRef(List<RolePrivRef> listRolePrivRef) {
		this.listRolePrivRef = listRolePrivRef;
	}

	public RolePrivAdd getAdd() {
		return add;
	}

	public void setAdd(RolePrivAdd add) {
		this.add = add;
	}

	public List<Priv> getListpriv() {
		return listpriv;
	}

	public void setListpriv(List<Priv> listpriv) {
		this.listpriv = listpriv;
	}

	public List<RolePrivTable> getListtable() {
		return listtable;
	}

	public void setListtable(List<RolePrivTable> listtable) {
		this.listtable = listtable;
	}

	public RolePrivCond getCond() {
		return cond;
	}

	public void setCond(RolePrivCond cond) {
		this.cond = cond;
	}

	public List<RolePriv> getListRolePriv() {
		return listRolePriv;
	}

	public void setListRolePriv(List<RolePriv> listRolePriv) {
		this.listRolePriv = listRolePriv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ////////role-priv-index
	public String rolePriv_index() {
		// 1.加载role_priv
		// list role_priv role role_priv_ref
		listtable = rolePrivServices.findRolePrivTable();
		listpriv = privMapper.findAll();

		// cond = new RolePrivCond();
		// listRolePriv = rolePrivServices.findRolePrivPage(cond);
		// System.out.println("===="+listRolePriv.size());
		return "role_priv_index";
	}

	public String rolePriv_add() {
		
		// try{
		// if(add.getRole_id() == 0){addActionMessage("role id 请输入有效值");return
		// "role_priv_index";}
		// } catch (Exception e) {
		// e.printStackTrace();
		// return "role_priv_index";
		// }
		
		rolePrivServices.addtr(add);
		listtable = rolePrivServices.findRolePrivTable();
		listpriv = privMapper.findAll();
		addActionMessage("新建成功");
		return "role_priv_index";
	}

	public String rolePriv_update() {
		//点击每行后面保存
		
//		System.out.println("add.getAdd_customer()="+add.getAdd_customer()+""
//				+"add.getAdd_customer()="+""+add.getAdd_presale()
//				+"add.getAdd_sale()="+""+add.getAdd_sale()
//				+"add.getAdd_user()="+""+add.getAdd_user()
//				+"getDelete_customer()="+""+add.getDelete_customer()
//				+"getEdit_customer()="+""+add.getEdit_customer()
//				+"getFind_customer()="+""+add.getFind_customer()
//				+"getFind_presale()="+""+add.getFind_presale()
//				+"getFind_sale()="+""+add.getFind_sale()
//				+"getLock_customer()="+""+add.getLock_customer());
		rolePrivServices.updatetr(add);
		listtable = rolePrivServices.findRolePrivTable();
		listpriv = privMapper.findAll();
		addActionMessage("保存成功");
		return "role_priv_index";
	}



	// /////////role-priv-ref-index
	public String rolePrivRef_index() {													
		recond = new RolePrivRefCond();
		setpage();
		

		return "role_priv_ref_index";
	}

	private void setpage() {
		String action = CustomerUtils.getActionNameFromRequest(request);

		Pager page = new Pager(ActionContext.getContext(), 10, action);
		recond.recordCount = rolePrivRefServices.findRolePrivRefCount(recond);
		page.setCond(recond);
		this.setShowPage(page.toHtmlString());
		listRolePrivRef = rolePrivRefServices.findRolePrivRefPage(recond);
	}

	public String findRolePrivRef() throws Exception {
		setpage();
	
		return "role_priv_ref_index";
	}
	//参照表的update add之类
	public String addRefRolePriv_jsp() {
		//参照权限所有的列表  去重复id的列表
		listRolePriv = rolePrivServices.findRolePrivPage(new RolePrivCond());
		
		return "role_priv_ref_add";
	}

	public String addRefRolePriv() throws Exception {
		//根据去重复id列表的选择 显示该id所有的权限  
		//仿照表仿照该id的权限 （right select）  role表去掉参照权限id 去掉已经在right select有的显示在左边select(left select)
		//点击保存的时候 把右边的select传回来 listrole 按照参照表 没有就加  有了不便 没有的话就删除
		
		listRole =  roleSevices.findRole();
//		rolePrivRefServices.addRolePrivRef(ref);
		RolePrivCond cond = new RolePrivCond();
		List list = new ArrayList();
		list.add( ref.getRefRoleId());
		cond.setRoleIds(list);
		listRolePriv = rolePrivServices.findRolePrivPage(cond);
		
		System.out.println(listRolePriv.size()+"....."+ref.getRefRoleId());
		
		addActionMessage("保存成功");
		return "role_priv_ref_add";
	}

	public String updateRefRolePriv() {
		//System.out.println("id=" + id);
		ref = rolePrivRefServices.findRolePrivRefById(id);

		return "role_priv_ref_update";
	}

	public String updateRefRolePrivAction() {
		rolePrivRefServices.updateRolePrivRef(ref);
		addActionMessage("保存成功");
		return "role_priv_ref_update";
	}
	
	public String initRolePriv() throws IOException{
        StringBuffer sb = new StringBuffer();
		
        String hoo = request.getParameter("q");
		
		List<Map<String,String>> tempro = rolePrivMapper.find_roleId_roleName_likeRoleName(hoo);
		for(Map<String,String> tm : tempro){
			sb.append(tm.get("roleName"))
				.append("(")  
//				.append(tm.get("roleId"))				
				.append(")\n")
				;
		}
		
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	public String priv_index(){
		listpriv = privMapper.findAll();
		return "priv_index";
	}
}












