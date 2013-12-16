package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.constanttype.ContReportColumnMethod;
import com.ihk.constanttype.EnumReportShowTDMethod;

/**
 * 报表的条件分析：对report_define_column中的method_sql进行分析，方便进行比较数据
 */
public class ReportColumnCond implements Serializable{
	private static final long serialVersionUID = 1L;
    
	private String columnName = "";
	
	private String compareMethod = "";
	
	private String columnValue = "";

	private String columnValueStart = "";//起始值

	private String columnValueEnd = "";//结束值

	public String getColumnName() {
		return columnName;
	}


	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}


	public String getCompareMethod() {
		return compareMethod;
	}


	public void setCompareMethod(String compareMethod) {
		this.compareMethod = compareMethod;
	}


	public String getColumnValue() {
		return columnValue;
	}
	

	public int getColumnValueINT() {
		return Integer.parseInt(columnValue);
	}

	public BigDecimal getColumnValueDECIMAL() {
		return new BigDecimal(columnValue);
	}

	public String getColumnValueStart() {
		return columnValueStart;
	}


	public void setColumnValueStart(String columnValueStart) {
		this.columnValueStart = columnValueStart;
	}


	public String getColumnValueEnd() {
		return columnValueEnd;
	}


	public void setColumnValueEnd(String columnValueEnd) {
		this.columnValueEnd = columnValueEnd;
	}


	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}
	

	public int getColumnValueStartINT() {
		return Integer.parseInt(columnValueStart);
	}

	public BigDecimal getColumnValueStartDECIMAL() {
		return new BigDecimal(columnValueStart);
	}
	

	public int getColumnValueEndINT() {
		return Integer.parseInt(columnValueEnd);
	}

	public BigDecimal getColumnValueEndDECIMAL() {
		return new BigDecimal(columnValueEnd);
	}
	
	/**
	 * 是否在起止数值之内(包含起止数值)
	 * 起止数值，也返回true
	 * @param number
	 * @return
	 */
	public boolean isInStartEndDecimal(BigDecimal number){
		if(number==null){
			return false;
		}
		
		if(getColumnValueStartDECIMAL().compareTo(number)<=0
		&& getColumnValueEndDECIMAL().compareTo(number)>=0){
			return true;
		}
		return false;
	}


	public ReportColumnCond(){};
	

	public ReportColumnCond(String methodSql){
		//单运算的做法
		String[] str ;
		if(methodSql.indexOf(ContReportColumnMethod.EQ)>0){
			str = methodSql.split("\\"+ContReportColumnMethod.EQ);
			if(str.length==2){
				this.columnName = str[0].toLowerCase();
				this.compareMethod = ContReportColumnMethod.EQ;
				this.columnValue = str[1];
			}
		}
		else if(methodSql.indexOf(ContReportColumnMethod.GT)>0){
			str = methodSql.split("\\"+ContReportColumnMethod.GT);
			if(str.length==2){
				this.columnName = str[0].toLowerCase();
				this.compareMethod = ContReportColumnMethod.GT;
				this.columnValue = str[1];
			}
		}
		else if(methodSql.indexOf(ContReportColumnMethod.IN)>0){
			str = methodSql.split("\\"+ContReportColumnMethod.IN);
			if(str.length==2){
				this.columnName = str[0].toLowerCase();
				this.compareMethod = ContReportColumnMethod.IN;
				this.columnValue = str[1];
				
				if(this.columnValue.indexOf(ContReportColumnMethod.CONNECTOR)>0){
					String[] strTmp = this.columnValue.split("\\"+ContReportColumnMethod.CONNECTOR);
					if(strTmp.length==2){
						this.columnValueStart = strTmp[0];
						this.columnValueEnd = strTmp[1];
					}
				}
				else{
					this.columnValueStart = this.columnValue ;
					this.columnValueEnd = this.columnValue ;					
				}
			}
		}
		
	};
	
	
	
}
