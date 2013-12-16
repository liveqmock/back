package com.ihk.setting.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.setting.data.IActionRecordLogMapper;
import com.ihk.setting.data.pojo.ActionRecordLog;
import com.ihk.setting.data.pojo.ActionRecordLogCond;
import com.ihk.setting.data.services.IActionRecordLogServices;
@Service("actionRecordLogServices")
public class ActionRecordLogServices implements IActionRecordLogServices {
	@Autowired
	IActionRecordLogMapper actionRecordLogMapper;

	@Override
	public void addActionRecordLog(ActionRecordLog actionRecordLog) throws RuntimeException {

		actionRecordLogMapper.addActionRecordLog(actionRecordLog);
	}

	@Override
	public void deleteActionRecordLog(int id) throws RuntimeException {

		actionRecordLogMapper.deleteActionRecordLog(id);
	}

	@Override
	public void updateActionRecordLog(ActionRecordLog actionRecordLog) throws RuntimeException {

		actionRecordLogMapper.updateActionRecordLog(actionRecordLog);
	}


	@Override
	public List<ActionRecordLog> findActionRecordLogPage(
			ActionRecordLogCond cond) throws RuntimeException {

		return actionRecordLogMapper.findActionRecordLogPage(cond);
	}
	
	@Override
	public int findActionRecordLogCount(ActionRecordLogCond cond)
			throws RuntimeException {
		
		return actionRecordLogMapper.findActionRecordLogCount(cond);
	}
}
