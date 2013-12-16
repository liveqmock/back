package com.ihk.user.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.user.data.IInputMemoryMapper;
import com.ihk.user.data.pojo.InputMemory;
import com.ihk.user.data.pojo.InputMemoryCond;
import com.ihk.user.data.services.IInputMemoryServices;

@Service("inputMemoryServices")
public class InputMemoryServices implements IInputMemoryServices {
	@Autowired	 IInputMemoryMapper inputMemoryMapper;

	public void deleteInputMemory(int id) throws RuntimeException {
		inputMemoryMapper.deleteInputMemory(id);
	}

	public void addInputMemory(InputMemory inputMemory) throws RuntimeException {		
		inputMemoryMapper.addInputMemory(inputMemory);
	}

	@Override
	public InputMemory findInputMemoryById(int id) throws RuntimeException {
		return inputMemoryMapper.findInputMemoryById(id);
	}

	@Override
	public void updateInputMemory(InputMemory inputMemory) throws RuntimeException {
		inputMemoryMapper.updateInputMemory(inputMemory);		
	}
	
	public List<InputMemory> findInputMemoryPage(InputMemoryCond cond) throws RuntimeException {
		int recordCount = inputMemoryMapper.findInputMemoryCount(cond);
		
		cond.recordCount = recordCount;
				
		return inputMemoryMapper.findInputMemoryPage(cond);
	}
    
	public List<InputMemory> findInputMemory(InputMemoryCond cond) throws RuntimeException {
    	return inputMemoryMapper.findInputMemory(cond);
	}

	@Override
	public InputMemory findInputMemoryForNew(InputMemoryCond cond)
			throws RuntimeException {
		
		return inputMemoryMapper.findInputMemoryForNew(cond);
	}
}
