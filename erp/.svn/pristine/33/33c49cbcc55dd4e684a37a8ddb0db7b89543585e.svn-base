package com.ihk.saleunit.action.new_;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.services.ISaleUnitLogServices;
import com.ihk.saleunit.log.pojo.Log;
import com.ihk.saleunit.log.pojo.LogCond;
import com.ihk.saleunit.log.services.ILogService;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 * @todo 用户操作记录
 * @jsp sale_unit_log.jsp
 * */
public class GuangZhouAppointNewSaleUnitLogAction extends SupperAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	ISaleUnitLogServices iSaleUnitLogServices;

	@Autowired
	ILogService logService;

	private List<Log> logs;

	/**
	 * 公司项目
	 */
	private int selectProId;

	/**
	 * 楼盘项目id
	 */
	private int priId;

	private int areaId;

	/**
	 * 楼栋id
	 */
	private int buildId;

	private int unitId;

	private String type;

	private String createdTime;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String unitTransactionLogInfo() {
		this.initUnitTransactionLog();
		return "sale_unit_log_info";
	}

	public String buildingAreaUnitInitLogInfo() {
		this.initBuildingAreaUnitInitLog();
		return "sale_unit_log_info";
	}

	private void initBuildingAreaUnitInitLog() {
		LogCond cond = new LogCond();
		cond.setModul("楼盘初始");
		if ("com".equals(type)) {
			cond.setCompanyProjectId(selectProId);
			cond.setType("楼盘");
		} else if ("pro".equals(type)) {
			cond.setType("分区");
			cond.setCompanyProjectId(selectProId);
			cond.setProjectId(priId);
		} else if ("area".equals(type)) {
			cond.setType("楼栋");
			cond.setCompanyProjectId(selectProId);
			cond.setProjectId(priId);
			cond.setAreaId(areaId);
		} else if ("build".equals(type)) {
			cond.setType("单元");
			cond.setCompanyProjectId(selectProId);
			cond.setProjectId(priId);
			cond.setBuildId(buildId);
			cond.setAreaId(areaId);
			// cond.setUnitId(unitId);
		} else if ("unit".equals(type)) {
			cond.setType("单元");
			cond.setUnitId(unitId);
		}
		logs = logService.findLogByCompanyProjectId(cond);
		if (logs == null)
			return;
		putRealName();
		putMoreLink();
		return;
	}

	private void initUnitTransactionLog() {
		LogCond cond = new LogCond();
		cond.setModul("销售中心");
		cond.setUnitId(unitId);
		logs = logService.findLogByUnitId(cond);
		if (logs == null)
			return;
		putRealName();
	}

	private void putMoreLink() {
		for (Log log : logs) {
			if (log.getType().startsWith("批量"))
				log.setOperationProcedure(log.getOperationProcedure()
						+ "<a onclick='more(\""
						+ log.getCreatedTime().toLocaleString()
						+ "\")' style='color: #1199FF'>详细</a>");

		}
	}

	private void putRealName() {
		for (int i = 0; i < logs.size(); i++) {
			logs.get(i).setRealName(
					DescUtils.getUserRealName(logs.get(i).getCreatedId()));
		}
	}

	public String more() throws Exception {
		LogCond cond = new LogCond();
		cond.setCreatedTime(DateTimeUtils.getDate(createdTime,
				"yyyy-MM-dd hh:mm:ss"));
		logs = logService.findLogByCreatedTime(cond);
		putRealName();
		return SUCCESS;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public int getSelectProId() {
		return selectProId;
	}

	public void setSelectProId(int selectProId) {
		this.selectProId = selectProId;
	}

	public int getPriId() {
		return priId;
	}

	public void setPriId(int priId) {
		this.priId = priId;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

}
