package com.ihk.user.data.services.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.user.data.IRolePrivRefMapper;
import com.ihk.user.data.pojo.RolePrivRef;
import com.ihk.user.data.pojo.RolePrivRefCond;
import com.ihk.user.data.services.IRolePrivRefServices;
import com.ihk.utils.SessionUser;

@Service("rolePrivRefServices")
@SuppressWarnings("unchecked")
public class RolePrivRefServices implements IRolePrivRefServices {
	@Autowired
	IRolePrivRefMapper rolePrivRefMapper;

	public void deleteRolePrivRef(int id) throws RuntimeException {
		rolePrivRefMapper.deleteRolePrivRef(id);
	}

	public void addRolePrivRef(RolePrivRef rolePrivRef) throws RuntimeException {
		rolePrivRef.setCreatedId(SessionUser.getUserId());
		rolePrivRef.setCreatedTime(new Date(System.currentTimeMillis()));
		rolePrivRef.setModId(SessionUser.getUserId());
		rolePrivRef.setModTime(new Date(System.currentTimeMillis()));
		rolePrivRef.setIsDeleted("0");
		rolePrivRefMapper.addRolePrivRef(rolePrivRef);
	}

	@Override
	public RolePrivRef findRolePrivRefById(int id) throws RuntimeException {
		return rolePrivRefMapper.findRolePrivRefById(id);
	}

	@Override
	public void updateRolePrivRef(RolePrivRef rolePrivRef)
			throws RuntimeException {
		rolePrivRefMapper.updateRolePrivRef(rolePrivRef);
	}

	public List findRolePrivRefPage(RolePrivRefCond cond)
			throws RuntimeException {
		int recordCount = rolePrivRefMapper.findRolePrivRefCount(cond);

		cond.recordCount = recordCount;

		return rolePrivRefMapper.findRolePrivRefPage(cond);
	}

	@Override
	public List<RolePrivRef> findAll() throws RuntimeException {
		return rolePrivRefMapper.findAllRolePrivRef();

	}

	@Override
	public int findRolePrivRefCount(RolePrivRefCond cond)
			throws RuntimeException {
		return rolePrivRefMapper.findRolePrivRefCount(cond);
	}


}
