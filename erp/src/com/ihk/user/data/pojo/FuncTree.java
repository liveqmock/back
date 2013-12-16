package com.ihk.user.data.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * FuncTree的实体类
 * @author 
 *
 */
public class FuncTree implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private String treeCode;
	private String treeName;
	private String actionUrl;
	private int orderIndex;

	/**
	 * 取得TreeCode(节点代号)
	 */
	public String getTreeCode() {
		return treeCode;
	}

	/**
	 * 设置treeCode(节点代号)
	 * @param treeCode (节点代号)
	 */
	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}
    
	/**
	 * 取得TreeName(节点中文名)
	 */
	public String getTreeName() {
		return treeName;
	}

	/**
	 * 设置treeName(节点中文名)
	 * @param treeName (节点中文名)
	 */
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
    
	/**
	 * 取得ActionUrl(地址)
	 */
	public String getActionUrl() {
		return actionUrl;
	}

	/**
	 * 设置actionUrl(地址)
	 * @param actionUrl (地址)
	 */
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
    
	/**
	 * 取得OrderIndex(顺序)
	 */
	public int getOrderIndex() {
		return orderIndex;
	}

	/**
	 * 设置orderIndex(顺序)
	 * @param orderIndex (顺序)
	 */
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}
    
	
	public FuncTree(){};


	/**
	 * 
	 * @param treeCode (节点代号)
	 * @param treeName (节点中文名)
	 * @param actionUrl (地址)
	 * @param orderIndex (顺序)
	 */
	public FuncTree(    
		String treeCode,
        		String treeName,
        		String actionUrl,
        		int orderIndex
        ) {
		super();  
		this.treeCode = treeCode;
		this.treeName = treeName;
		this.actionUrl = actionUrl;
		this.orderIndex = orderIndex;
	}
    
	/**
	 * 
	 * @param treeName (节点中文名)
	 * @param actionUrl (地址)
	 * @param orderIndex (顺序)
	 */
	public FuncTree(    
		String treeName,
        		String actionUrl,
        		int orderIndex
        ) {
		super();		
		this.treeName = treeName;
		this.actionUrl = actionUrl;
		this.orderIndex = orderIndex;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
