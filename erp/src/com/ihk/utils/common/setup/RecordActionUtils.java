package com.ihk.utils.common.setup;

import java.util.LinkedHashMap;

public class RecordActionUtils {
	public static LinkedHashMap<String, String> recordAction;

	public static LinkedHashMap<String, String> getRecordAction() {
		return recordAction;
	}

	public void setRecordAction(LinkedHashMap<String, String> recordAction) {
		RecordActionUtils.recordAction = recordAction;
	}

	public static String getActionGBKName(String str) {
		if (RecordActionUtils.recordAction.containsKey(str))
			return RecordActionUtils.recordAction.get(str);
		return null;
	}

}
