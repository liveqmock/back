package com.kn.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * KN_CWGL_YSK的实体类
 * @author 
 *
 */
public class KN_CWGL_YSK implements Serializable{
	private static final long serialVersionUID = 1L;
    
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private BigDecimal 应收款id;
	private String 类别;
	private String 收费项目;
	private BigDecimal 期数;
	private Date 应收日期;
	private BigDecimal 应收外币金额;
	private String 币种;
	private BigDecimal 汇率;
	private BigDecimal 应收本币金额;
	private BigDecimal 已收金额;
	private String 备注;
	private String 状态;
	private BigDecimal 认购书id;
	private BigDecimal 审核;
	private String 业主姓名;
	private String oldmemo;
	private BigDecimal 房款比例O;
	private BigDecimal 房款比例;
	private BigDecimal 单元id;

	/**
	 * 取得应收款ID()
	 */
	public BigDecimal get应收款ID() {
		return 应收款id;
	}

	/**
	 * 设置应收款id()
	 * @param 应收款id ()
	 */
	public void set应收款ID(BigDecimal 应收款id) {
		this.应收款id = 应收款id;
	}
    
	/**
	 * 取得类别()
	 */
	public String get类别() {
		return 类别;
	}

	/**
	 * 设置类别()
	 * @param 类别 ()
	 */
	public void set类别(String 类别) {
		this.类别 = 类别;
	}
    
	/**
	 * 取得收费项目()
	 */
	public String get收费项目() {
		return 收费项目;
	}

	/**
	 * 设置收费项目()
	 * @param 收费项目 ()
	 */
	public void set收费项目(String 收费项目) {
		this.收费项目 = 收费项目;
	}
    
	/**
	 * 取得期数()
	 */
	public BigDecimal get期数() {
		return 期数;
	}

	/**
	 * 设置期数()
	 * @param 期数 ()
	 */
	public void set期数(BigDecimal 期数) {
		this.期数 = 期数;
	}
    
	/**
	 * 取得应收日期()
	 */
	public Date get应收日期() {
		return 应收日期;
	}

	/**
	 * 设置应收日期()
	 * @param 应收日期 ()
	 */
	public void set应收日期(Date 应收日期) {
		this.应收日期 = 应收日期;
	}
    
	/**
	 * 取得应收外币金额()
	 */
	public BigDecimal get应收外币金额() {
		return 应收外币金额;
	}

	/**
	 * 设置应收外币金额()
	 * @param 应收外币金额 ()
	 */
	public void set应收外币金额(BigDecimal 应收外币金额) {
		this.应收外币金额 = 应收外币金额;
	}
    
	/**
	 * 取得币种()
	 */
	public String get币种() {
		return 币种;
	}

	/**
	 * 设置币种()
	 * @param 币种 ()
	 */
	public void set币种(String 币种) {
		this.币种 = 币种;
	}
    
	/**
	 * 取得汇率()
	 */
	public BigDecimal get汇率() {
		return 汇率;
	}

	/**
	 * 设置汇率()
	 * @param 汇率 ()
	 */
	public void set汇率(BigDecimal 汇率) {
		this.汇率 = 汇率;
	}
    
	/**
	 * 取得应收本币金额()
	 */
	public BigDecimal get应收本币金额() {
		return 应收本币金额;
	}

	/**
	 * 设置应收本币金额()
	 * @param 应收本币金额 ()
	 */
	public void set应收本币金额(BigDecimal 应收本币金额) {
		this.应收本币金额 = 应收本币金额;
	}
    
	/**
	 * 取得已收金额()
	 */
	public BigDecimal get已收金额() {
		return 已收金额;
	}

	/**
	 * 设置已收金额()
	 * @param 已收金额 ()
	 */
	public void set已收金额(BigDecimal 已收金额) {
		this.已收金额 = 已收金额;
	}
    
	/**
	 * 取得备注()
	 */
	public String get备注() {
		return 备注;
	}

	/**
	 * 设置备注()
	 * @param 备注 ()
	 */
	public void set备注(String 备注) {
		this.备注 = 备注;
	}
    
	/**
	 * 取得状态()
	 */
	public String get状态() {
		return 状态;
	}

	/**
	 * 设置状态()
	 * @param 状态 ()
	 */
	public void set状态(String 状态) {
		this.状态 = 状态;
	}
    
	/**
	 * 取得认购书ID()
	 */
	public BigDecimal get认购书ID() {
		return 认购书id;
	}

	/**
	 * 设置认购书id()
	 * @param 认购书id ()
	 */
	public void set认购书ID(BigDecimal 认购书id) {
		this.认购书id = 认购书id;
	}
    
	/**
	 * 取得审核()
	 */
	public BigDecimal get审核() {
		return 审核;
	}

	/**
	 * 设置审核()
	 * @param 审核 ()
	 */
	public void set审核(BigDecimal 审核) {
		this.审核 = 审核;
	}
    
	/**
	 * 取得业主姓名()
	 */
	public String get业主姓名() {
		return 业主姓名;
	}

	/**
	 * 设置业主姓名()
	 * @param 业主姓名 ()
	 */
	public void set业主姓名(String 业主姓名) {
		this.业主姓名 = 业主姓名;
	}
    
	/**
	 * 取得OLDMEMO()
	 */
	public String getOLDMEMO() {
		return oldmemo;
	}

	/**
	 * 设置oldmemo()
	 * @param oldmemo ()
	 */
	public void setOLDMEMO(String oldmemo) {
		this.oldmemo = oldmemo;
	}
    
	/**
	 * 取得房款比例_O()
	 */
	public BigDecimal get房款比例_O() {
		return 房款比例O;
	}

	/**
	 * 设置房款比例O()
	 * @param 房款比例O ()
	 */
	public void set房款比例_O(BigDecimal 房款比例O) {
		this.房款比例O = 房款比例O;
	}
    
	/**
	 * 取得房款比例()
	 */
	public BigDecimal get房款比例() {
		return 房款比例;
	}

	/**
	 * 设置房款比例()
	 * @param 房款比例 ()
	 */
	public void set房款比例(BigDecimal 房款比例) {
		this.房款比例 = 房款比例;
	}
    
	/**
	 * 取得单元ID()
	 */
	public BigDecimal get单元ID() {
		return 单元id;
	}

	/**
	 * 设置单元id()
	 * @param 单元id ()
	 */
	public void set单元ID(BigDecimal 单元id) {
		this.单元id = 单元id;
	}
    
	
	public KN_CWGL_YSK(){};


	/**
	 * 
	 * @param 应收款id ()
	 * @param 类别 ()
	 * @param 收费项目 ()
	 * @param 期数 ()
	 * @param 应收日期 ()
	 * @param 应收外币金额 ()
	 * @param 币种 ()
	 * @param 汇率 ()
	 * @param 应收本币金额 ()
	 * @param 已收金额 ()
	 * @param 备注 ()
	 * @param 状态 ()
	 * @param 认购书id ()
	 * @param 审核 ()
	 * @param 业主姓名 ()
	 * @param oldmemo ()
	 * @param 房款比例O ()
	 * @param 房款比例 ()
	 * @param 单元id ()
	 */
	public KN_CWGL_YSK(    
		BigDecimal 应收款id,
        		String 类别,
        		String 收费项目,
        		BigDecimal 期数,
        		Date 应收日期,
        		BigDecimal 应收外币金额,
        		String 币种,
        		BigDecimal 汇率,
        		BigDecimal 应收本币金额,
        		BigDecimal 已收金额,
        		String 备注,
        		String 状态,
        		BigDecimal 认购书id,
        		BigDecimal 审核,
        		String 业主姓名,
        		String oldmemo,
        		BigDecimal 房款比例O,
        		BigDecimal 房款比例,
        		BigDecimal 单元id
        ) {
		super();  
		this.应收款id = 应收款id;
		this.类别 = 类别;
		this.收费项目 = 收费项目;
		this.期数 = 期数;
		this.应收日期 = 应收日期;
		this.应收外币金额 = 应收外币金额;
		this.币种 = 币种;
		this.汇率 = 汇率;
		this.应收本币金额 = 应收本币金额;
		this.已收金额 = 已收金额;
		this.备注 = 备注;
		this.状态 = 状态;
		this.认购书id = 认购书id;
		this.审核 = 审核;
		this.业主姓名 = 业主姓名;
		this.oldmemo = oldmemo;
		this.房款比例O = 房款比例O;
		this.房款比例 = 房款比例;
		this.单元id = 单元id;
	}
    
	/**
	 * 
	 * @param 类别 ()
	 * @param 收费项目 ()
	 * @param 期数 ()
	 * @param 应收日期 ()
	 * @param 应收外币金额 ()
	 * @param 币种 ()
	 * @param 汇率 ()
	 * @param 应收本币金额 ()
	 * @param 已收金额 ()
	 * @param 备注 ()
	 * @param 状态 ()
	 * @param 认购书id ()
	 * @param 审核 ()
	 * @param 业主姓名 ()
	 * @param oldmemo ()
	 * @param 房款比例O ()
	 * @param 房款比例 ()
	 * @param 单元id ()
	 */
	public KN_CWGL_YSK(    
		String 类别,
        		String 收费项目,
        		BigDecimal 期数,
        		Date 应收日期,
        		BigDecimal 应收外币金额,
        		String 币种,
        		BigDecimal 汇率,
        		BigDecimal 应收本币金额,
        		BigDecimal 已收金额,
        		String 备注,
        		String 状态,
        		BigDecimal 认购书id,
        		BigDecimal 审核,
        		String 业主姓名,
        		String oldmemo,
        		BigDecimal 房款比例O,
        		BigDecimal 房款比例,
        		BigDecimal 单元id
        ) {
		super();		
		this.类别 = 类别;
		this.收费项目 = 收费项目;
		this.期数 = 期数;
		this.应收日期 = 应收日期;
		this.应收外币金额 = 应收外币金额;
		this.币种 = 币种;
		this.汇率 = 汇率;
		this.应收本币金额 = 应收本币金额;
		this.已收金额 = 已收金额;
		this.备注 = 备注;
		this.状态 = 状态;
		this.认购书id = 认购书id;
		this.审核 = 审核;
		this.业主姓名 = 业主姓名;
		this.oldmemo = oldmemo;
		this.房款比例O = 房款比例O;
		this.房款比例 = 房款比例;
		this.单元id = 单元id;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
