package com.ihk.customer.data.pojo;

/**
 * CustomerKnown的实体类
 * @author 
 *
 */
public class CustomerKnown {
	private static final long serialVersionUID = 1L;
    
	private int id;
	private int customerId;
	private String knownFrom;

	/**
	 * 取得Id()
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置id()
	 * @param id ()
	 */
	public void setId(int id) {
		this.id = id;
	}
    
	/**
	 * 取得CustomerId()
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * 设置customerId()
	 * @param customerId ()
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
    
	/**
	 * 取得KnownFrom(获知途径)
	 */
	public String getKnownFrom() {
		return knownFrom;
	}

	/**
	 * 设置knownFrom(获知途径)
	 * @param knownFrom (获知途径)
	 */
	public void setKnownFrom(String knownFrom) {
		this.knownFrom = knownFrom;
	}
    
	
	public CustomerKnown(){};


	/**
	 * 
	 * @param id ()
	 * @param customerId ()
	 * @param knownFrom (获知途径)
	 */
	public CustomerKnown(    
		int id,
        		int customerId,
        		String knownFrom
        ) {
		super();  
		this.id = id;
		this.customerId = customerId;
		this.knownFrom = knownFrom;
	}
    
	/**
	 * 
	 * @param customerId ()
	 * @param knownFrom (获知途径)
	 */
	public CustomerKnown(    
		int customerId,
        		String knownFrom
        ) {
		super();		
		this.customerId = customerId;
		this.knownFrom = knownFrom;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖
}
