package com.ihk.saleunit.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ihk.constanttype.EnumReportShowTDMethod;

/**
 * 报表显示的每个TD定义，用于直接构建报表的table，以及填充报表显示的表格
 * @author Administrator
 * 每个TD理解成对应table中的x轴与y轴
 * 顺序从左上角开始为0,0
 */
public class ReportShowTD implements Serializable{
	private static final long serialVersionUID = 1L;
    	
	/**
	 * y轴分类名称
	 */
	private String yTypeName="";
	

	/**
	 * x轴分类名称
	 */
	private String xTypeName="";

	/**
	 * y轴显示名称
	 */
	private String yShowName="";
	
	/**
	 * x轴显示标题
	 */
	private String xTheadText="";
	
	/**
	 * 对应的算法
	 */
	private EnumReportShowTDMethod xyMethod;

	/**
	 * 对应计算的模拟sql方法
	 */
	private String xyMethodSql;

	/**
	 * 格式化的写法
	 */
	private String xyValueFormatText="%1$,.0f";
	
	/**
	 * td显示的值（字符串类型）
	 */
	private String xyValueText="";
	
	/**
	 * td实际的数据值
	 */
	private BigDecimal xyValue;
	
	
	/**
	 * td的跨x多少列
	 */
	private int colspan=0;
	

	/**
	 * td的跨y多少行,相当于rowSpan
	 */
	private int rowspan=0;
	
	/**
	 * 是否可见
	 */
	private boolean visiable=true;	
	

	public boolean isVisiable() {
		return visiable;
	}

	public void setVisiable(boolean visiable) {
		this.visiable = visiable;
	}


	public ReportShowTD(){}



	public String getxTypeName() {
		return xTypeName;
	}




	public void setxTypeName(String xTypeName) {
		this.xTypeName = xTypeName;
	}


	public String getyTypeName() {
		return yTypeName;
	}




	public void setyTypeName(String yTypeName) {
		this.yTypeName = yTypeName;
	}




	public String getyShowName() {
		return yShowName;
	}




	public void setyShowName(String yShowName) {
		this.yShowName = yShowName;
	}




	public String getxTheadText() {
		return xTheadText;
	}




	public void setxTheadText(String xTheadText) {
		this.xTheadText = xTheadText;
	}




	public EnumReportShowTDMethod getXyMethod() {
		return xyMethod;
	}




	public void setXyMethod(EnumReportShowTDMethod xyMethod) {
		this.xyMethod = xyMethod;
	}




	public String getXyMethodSql() {
		return xyMethodSql;
	}




	public void setXyMethodSql(String xyMethodSql) {
		this.xyMethodSql = xyMethodSql;
	}




	public String getXyValueFormatText() {
		return xyValueFormatText;
	}

	public void setXyValueFormatText(String xyValueFormatText) {
		this.xyValueFormatText = xyValueFormatText;
	}

	public String getXyValueText() {
//		return String.format("%1$,09d", xyValueText);
		return xyValueText;
	}




	public void setXyValueText(String xyValueText) {
		this.xyValueText = xyValueText;
	}




	public BigDecimal getXyValue() {
		return xyValue;
	}




	public void setXyValue(BigDecimal xyValue) {
		this.xyValue = xyValue;
		if(xyValueFormatText.indexOf("%%")>0){//百分比计算，要乘以100
			setXyValueText(String.format(xyValueFormatText,this.xyValue.multiply(BigDecimal.valueOf(100))));
		}
		else{
			setXyValueText(String.format(xyValueFormatText,this.xyValue));
		}
	}




	public int getColspan() {
		return colspan;
	}




	public void setColspan(int colspan) {
		this.colspan = colspan;
	}




	public int getRowspan() {
		return rowspan;
	}




	public void setRowspan(int rowspan) {
		this.rowspan = rowspan;
	}




	public ReportShowTD(String yTypeName, String yShowName, String xTheadText,
			EnumReportShowTDMethod xyMethod, String xyMethodSql,
			String xyValueText, BigDecimal xyValue, int colspan, int rowspan) {
		super();
		this.yTypeName = yTypeName;
		this.yShowName = yShowName;
		this.xTheadText = xTheadText;
		this.xyMethod = xyMethod;
		this.xyMethodSql = xyMethodSql;
		this.xyValueText = xyValueText;
		this.xyValue = xyValue;
		this.colspan = colspan;
		this.rowspan = rowspan;
	};
	

	public ReportShowTD(String xyValueText) {
		this.xyValueText = xyValueText;
		this.yTypeName = xyValueText;
		this.xTypeName = xyValueText;
	};
	
	
	
	
	
}
