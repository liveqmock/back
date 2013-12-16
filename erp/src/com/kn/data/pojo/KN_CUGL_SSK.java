package com.kn.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * KN_CUGL_SSK的实体类
 * @author 
 *
 */
public class KN_CUGL_SSK implements Serializable{
	private static final long serialVersionUID = 1L;
    
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private BigDecimal 应收款id;
	private BigDecimal 收据id;
	private BigDecimal 已收金额;
	private BigDecimal 本次收款;

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
	 * 取得收据ID()
	 */
	public BigDecimal get收据ID() {
		return 收据id;
	}

	/**
	 * 设置收据id()
	 * @param 收据id ()
	 */
	public void set收据ID(BigDecimal 收据id) {
		this.收据id = 收据id;
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
	 * 取得本次收款()
	 */
	public BigDecimal get本次收款() {
		return 本次收款;
	}

	/**
	 * 设置本次收款()
	 * @param 本次收款 ()
	 */
	public void set本次收款(BigDecimal 本次收款) {
		this.本次收款 = 本次收款;
	}
    
	
	public KN_CUGL_SSK(){};


	/**
	 * 
	 * @param 应收款id ()
	 * @param 收据id ()
	 * @param 已收金额 ()
	 * @param 本次收款 ()
	 */
	public KN_CUGL_SSK(    
		BigDecimal 应收款id,
        		BigDecimal 收据id,
        		BigDecimal 已收金额,
        		BigDecimal 本次收款
        ) {
		super();  
		this.应收款id = 应收款id;
		this.收据id = 收据id;
		this.已收金额 = 已收金额;
		this.本次收款 = 本次收款;
	}
    
	/**
	 * 
	 * @param 收据id ()
	 * @param 已收金额 ()
	 * @param 本次收款 ()
	 */
	public KN_CUGL_SSK(    
		BigDecimal 收据id,
        		BigDecimal 已收金额,
        		BigDecimal 本次收款
        ) {
		super();		
		this.收据id = 收据id;
		this.已收金额 = 已收金额;
		this.本次收款 = 本次收款;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
