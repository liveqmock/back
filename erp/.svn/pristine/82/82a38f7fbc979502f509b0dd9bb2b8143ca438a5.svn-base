package com.ihk.user.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.user.data.IFuncTreeMapper;
import com.ihk.user.data.pojo.FuncTree;
import com.ihk.user.data.pojo.FuncTreeCond;
import com.ihk.user.data.services.IFuncTreeServices;

@Service("funcTreeServices")
public class FuncTreeServices implements IFuncTreeServices {
	@Autowired	 IFuncTreeMapper funcTreeMapper;

	public void deleteFuncTree(int id) throws RuntimeException {
		funcTreeMapper.deleteFuncTree(id);
	}

	public void addFuncTree(FuncTree funcTree) throws RuntimeException {		
		funcTreeMapper.addFuncTree(funcTree);
	}

	@Override
	public FuncTree findFuncTreeById(String id) throws RuntimeException {
		return funcTreeMapper.findFuncTreeById(id);
	}

	@Override
	public void updateFuncTree(FuncTree funcTree) throws RuntimeException {
		funcTreeMapper.updateFuncTree(funcTree);		
	}
	
	@SuppressWarnings("rawtypes")
	public List findFuncTreePage(FuncTreeCond cond) throws RuntimeException {
		int recordCount = funcTreeMapper.findFuncTreeCount(cond);
		
		cond.recordCount = recordCount;
				
		return funcTreeMapper.findFuncTreePage(cond);
	}
	public List<FuncTree> findAll(){
		
		return funcTreeMapper.findAll();
	}

	@Override
	public List<FuncTree> findListByName(FuncTree tree) {
//		FuncTree tree = new FuncTree();
//		tree.setTreeName(name);
		
		return funcTreeMapper.findListByName(tree);
	}


}
