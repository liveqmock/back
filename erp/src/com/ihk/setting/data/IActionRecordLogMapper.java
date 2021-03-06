package com.ihk.setting.data;

import java.util.List;

import com.ihk.setting.data.pojo.ActionRecordLog;
import com.ihk.setting.data.pojo.ActionRecordLogCond;

public interface IActionRecordLogMapper {

	public void addActionRecordLog(ActionRecordLog actionRecordLog)
			throws RuntimeException;

	public void deleteActionRecordLog(int id) throws RuntimeException;

	public void updateActionRecordLog(ActionRecordLog actionRecordLog)
			throws RuntimeException;

	public List<ActionRecordLog> findActionRecordLogPage(
			ActionRecordLogCond cond) throws RuntimeException;

	public int findActionRecordLogCount(ActionRecordLogCond cond)
			throws RuntimeException;
}
