package com.ihk.customer.data.pojo;

import java.io.Serializable;

/**
 * CustomerFocus的实体类
 * @author 
 *
 */
public class CustomerFocus implements Serializable{
	private static final long serialVersionUID = 1L;
    
		private int id;
		private int customerId;
		private String focusPoint;

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
		 * 取得FocusPoint(关注点)
		 */
		public String getFocusPoint() {
			return focusPoint;
		}

		/**
		 * 设置focusPoint(关注点)
		 * @param focusPoint (关注点)
		 */
		public void setFocusPoint(String focusPoint) {
			this.focusPoint = focusPoint;
		}
	    
		
		public CustomerFocus(){};


		/**
		 * 
		 * @param id ()
		 * @param customerId ()
		 * @param focusPoint (关注点)
		 */
		public CustomerFocus(    
			int id,
	        		int customerId,
	        		String focusPoint
	        ) {
			super();  
			this.id = id;
			this.customerId = customerId;
			this.focusPoint = focusPoint;
		}
	    
		/**
		 * 
		 * @param customerId ()
		 * @param focusPoint (关注点)
		 */
		public CustomerFocus(    
			int customerId,
	        		String focusPoint
	        ) {
			super();		
			this.customerId = customerId;
			this.focusPoint = focusPoint;
		}
}
