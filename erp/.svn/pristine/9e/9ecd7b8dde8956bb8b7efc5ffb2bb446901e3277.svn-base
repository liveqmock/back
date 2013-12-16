package com.ihk.saleunit.log.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.log.ILogMapper;
import com.ihk.saleunit.log.pojo.Log;
import com.ihk.saleunit.log.pojo.LogCond;
import com.ihk.saleunit.log.services.ILogService;

@Service("logService")
public class LogService implements ILogService {
	@Autowired
	ILogMapper logMapper;

	@Override
	public void addLog(Log log) throws RuntimeException {
		// TODO Auto-generated method stub
		logMapper.addLog(log);
	}

	@Override
	public void deleteLog(int id) throws RuntimeException {
		// TODO Auto-generated method stub
		logMapper.deleteLog(id);
	}

	@Override
	public void updateLog(Log log) throws RuntimeException {
		// TODO Auto-generated method stub
		logMapper.updateLog(log);
	}

	@Override
	public List<Log> findLogByUnitId(LogCond cond) throws RuntimeException {
		return logMapper.findLogByUnitId(cond);
	}
	@Override
	public List<Log> findLogByCompanyProjectId(LogCond cond)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return logMapper.findLogByCompanyProjectId(cond);
	}
	
	@Override
	public List<Log> findLogByCreatedTime(LogCond cond) throws RuntimeException {
		// TODO Auto-generated method stub
		return logMapper.findLogByCreatedTime(cond);
	}
}
