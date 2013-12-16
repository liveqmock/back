package com.ihk.utils.common.setup;

import java.util.LinkedHashMap;

public class ExportExcelLogUtils {
	public static LinkedHashMap<String, String> exportExcelLog;

	public static String getActionGBKName(String str) {
		if (ExportExcelLogUtils.exportExcelLog.containsKey(str))
			return ExportExcelLogUtils.exportExcelLog.get(str);
		return null;
	}

	public static LinkedHashMap<String, String> getExportExcelLog() {
		return exportExcelLog;
	}

	public void setExportExcelLog(
			LinkedHashMap<String, String> exportExcelLog) {
		ExportExcelLogUtils.exportExcelLog = exportExcelLog;
	}
}
