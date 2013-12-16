package com.ihk.user.data.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.user.data.IPrivMapper;
import com.ihk.user.data.IRolePrivMapper;
import com.ihk.user.data.pojo.Priv;
import com.ihk.user.data.pojo.RolePriv;
import com.ihk.user.data.pojo.RolePrivAdd;
import com.ihk.user.data.pojo.RolePrivCond;
import com.ihk.user.data.pojo.RolePrivTable;
import com.ihk.user.data.services.IRolePrivServices;
import com.ihk.utils.SessionUser;

@Service("rolePrivServices")
public class RolePrivServices implements IRolePrivServices {
	@Autowired	 IRolePrivMapper rolePrivMapper;
	@Autowired   IPrivMapper privMapper;
	
	public List<RolePrivTable> findRolePrivTable(){
		List<RolePriv> pr =  rolePrivMapper.findAll();
		List<Priv> priv = privMapper.findAll();
		
		
		ArrayList<RolePrivTable> table = new ArrayList<RolePrivTable>();
		RolePrivTable t = new RolePrivTable();
		ArrayList<Priv> tpriv = new ArrayList<Priv>();
		int temp = 0;
		temp = pr.get(0).getRoleId();
		t.setId(-1);
		t.setP(priv);
		for(int i = 0;pr.size() > i -1  ;i++){	
			if(i == pr.size()){
				t.setId(temp);
				t.setP(priv);
				table.add(t);
//				System.out.println("end!");
				break;
			}
			if(pr.get(i).getRoleId() != temp){
				t.setId(temp);
				t.setP(priv);
				table.add(t);
//				System.out.println("add!!");
				temp = pr.get(i).getRoleId();				
				tpriv = new ArrayList<Priv>();
				t = new RolePrivTable();
				priv = privMapper.findAll();
			}
			for(int j = 0;priv.size() > j; j++){
				//peter注释：因数据库字段变化
//				if(priv.get(j).getPrivCode() .equals( pr.get(i) .getPrivCode())){
//					priv.get(j).setIshave(true);
//					System.out.println("j="+j+"   roleid="+temp+">>>"+
//							"privCode="+priv.get(j).getPrivCode()+priv.get(j).getPrivName());
//				}
				
			}	
		
		}	
		return table;
	}
	public void addtr(RolePrivAdd add){
		int roleid = add.getRole_id();
		if(add.getAdd_customer().equals("1"))initRolePriv(roleid ,"add_customer");
		if(add.getAdd_presale().equals("1"))initRolePriv(roleid ,"add_presale");
		if(add.getAdd_sale().equals("1"))initRolePriv(roleid ,"add_sale");
		if(add.getAdd_user() .equals("1"))initRolePriv(roleid ,"add_user");
		
		if(add.getFind_customer() .equals("1"))initRolePriv(roleid ,"find_customer");
		if(add.getFind_presale().equals("1"))initRolePriv(roleid ,"find_presale");
		if(add.getFind_sale().equals("1"))initRolePriv(roleid ,"find_sale");
		
		if(add.getDelete_customer().equals("1"))initRolePriv(roleid ,"delete_customer");
		
		if(add.getEdit_customer() .equals("1"))initRolePriv(roleid ,"edit_customer");
		
		if(add.getSum_presale().equals("1"))initRolePriv(roleid ,"sum_presale");
		if(add.getSum_sale().equals("1"))initRolePriv(roleid ,"sum_sale");
		
		if(add.getLock_customer() .equals("1"))initRolePriv(roleid ,"lock_customer");
		if(add.getLock_presale().equals("1"))initRolePriv(roleid ,"lock_presale");
		if(add.getLock_sale() .equals("1"))initRolePriv(roleid ,"lock_sale");
		if(add.getLock_user() .equals("1"))initRolePriv(roleid ,"lock_user");
		
	}
	public RolePriv initRolePriv(int roleid,String rolecode){
		RolePriv rolePriv =new RolePriv();
		rolePriv.setRoleId(roleid);
		rolePriv.setIsDeleted("0");
		rolePriv.setIsHave("1");
		//peter注释：因数据库字段变化
//		rolePriv.setPrivCode(rolecode);
		rolePriv.setCreatedId(SessionUser.getUserId());
		rolePriv.setModId(SessionUser.getUserId());
		rolePriv.setCreatedTime(new Date(System.currentTimeMillis()));
		rolePriv.setModTime(new Date(System.currentTimeMillis()));
//		System.out.println(rolePriv.getRoleId());
		addRolePriv(rolePriv);
		return rolePriv;
	}
	public RolePriv initupdate(int roleid,String rolecode){
		RolePriv rolePriv =new RolePriv();
		rolePriv.setRoleId(roleid);
		rolePriv.setIsDeleted("0");
		rolePriv.setIsHave("1");
		//peter注释：因数据库字段变化
//		rolePriv.setPrivCode(rolecodee);
		rolePriv.setCreatedId(SessionUser.getUserId());
		rolePriv.setModId(SessionUser.getUserId());
		rolePriv.setCreatedTime(new Date(System.currentTimeMillis()));
		rolePriv.setModTime(new Date(System.currentTimeMillis()));
		//System.out.println(rolePriv.toString());
		//找到 有就不变 没有就加
		RolePriv code = new RolePriv();
		//peter注释：因数据库字段变化
//		code.setPrivCode(rolecode);
		code.setRoleId(roleid);
		int tp = rolePrivMapper.findBy_roleId_roleCode(code);
//		System.out.println("找到数据行数+"+tp);
		if(tp == 0 ){
//			System.out.println("添加"+rolePriv.getRoleId()+"code"+rolePriv.getPrivCode());
			addRolePriv(rolePriv);
		}
		return rolePriv;
	}
	private void uodate_delet(int roleid,String rolecode){
		//根据 传入删除 delBy_roleId_roleCode
	//	System.out.println("delet::"+"roleid = "+roleid+"  rolecode = "+rolecode);
		RolePriv code = new RolePriv();
		//		peter注释：因数据库字段变化
//		code.setPrivCode(rolecode);
		code.setRoleId(roleid);
		
		rolePrivMapper.delBy_roleId_roleCode(code);
	}
	public void updatetr (RolePrivAdd add){
		int roleid = add.getRole_id();
		if(add.getAdd_customer().equals("1"))initupdate(roleid ,"add_customer");else uodate_delet(roleid ,"add_customer");
	
		if(add.getAdd_presale().equals("1"))initupdate(roleid ,"add_presale");else uodate_delet(roleid ,"add_presale");
		if(add.getAdd_sale().equals("1"))initupdate(roleid ,"add_sale");else uodate_delet(roleid ,"add_sale");
		if(add.getAdd_user() .equals("1"))initupdate(roleid ,"add_user");else uodate_delet(roleid ,"add_user");
		
		if(add.getFind_customer() .equals("1"))initupdate(roleid ,"find_customer");else uodate_delet(roleid ,"find_customer");
		if(add.getFind_presale().equals("1"))initupdate(roleid ,"find_presale");else uodate_delet(roleid ,"find_presale");
		if(add.getFind_sale().equals("1"))initupdate(roleid ,"find_sale");else uodate_delet(roleid ,"find_sale");
		
		if(add.getDelete_customer().equals("1"))initupdate(roleid ,"delete_customer");else uodate_delet(roleid ,"delete_customer");
		
		if(add.getEdit_customer() .equals("1"))initupdate(roleid ,"edit_customer");else uodate_delet(roleid ,"edit_customer");
		
		if(add.getSum_presale().equals("1"))initupdate(roleid ,"sum_presale");else uodate_delet(roleid ,"sum_presale");
		if(add.getSum_sale().equals("1"))initupdate(roleid ,"sum_sale");else uodate_delet(roleid ,"sum_sale");
		
		if(add.getLock_customer() .equals("1"))initupdate(roleid ,"lock_customer");else uodate_delet(roleid ,"lock_customer");
		if(add.getLock_presale().equals("1"))initupdate(roleid ,"lock_presale");else uodate_delet(roleid ,"lock_presale");
		if(add.getLock_sale() .equals("1"))initupdate(roleid ,"lock_sale");else uodate_delet(roleid ,"lock_sale");
		if(add.getLock_user() .equals("1"))initupdate(roleid ,"lock_user");else uodate_delet(roleid ,"lock_user");
		
	}
	public void deleteRolePriv(int id) throws RuntimeException {
		rolePrivMapper.deleteRolePriv(id);
	}
    public void deleteRolePrivByRoleId(int id) throws RuntimeException {
        rolePrivMapper.deleteRolePrivByRoleId(id);
    }

	public void addRolePriv(RolePriv rolePriv) throws RuntimeException {		
		rolePrivMapper.addRolePriv(rolePriv);
	}

	@Override
	public RolePriv findRolePrivById(int id) throws RuntimeException {
		return rolePrivMapper.findRolePrivById(id);
	}

    @Override
    public List<RolePriv> findRolePrivByRoleId(int roleId) throws RuntimeException{
		return rolePrivMapper.findRolePrivByRoleId(roleId);
	}

	@Override
	public void updateRolePriv(RolePriv rolePriv) throws RuntimeException {
		rolePrivMapper.updateRolePriv(rolePriv);		
	}
	
	public List findRolePrivPage(RolePrivCond cond) throws RuntimeException {
		int recordCount = rolePrivMapper.findRolePrivCount(cond);
		
		cond.recordCount = recordCount;
				
		return rolePrivMapper.findRolePrivPage(cond);
	}
}
