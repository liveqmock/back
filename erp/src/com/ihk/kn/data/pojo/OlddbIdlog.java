package com.ihk.kn.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * OlddbIdlog的实体类
 * @author 
 *
 */
public class OlddbIdlog implements Serializable{
	private static final long serialVersionUID = 1L;
    
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String myTable;
	private String myId;
	private String olddbId;

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
	 * 取得MyTable(表名)
	 */
	public String getMyTable() {
		return myTable;
	}

	/**
	 * 设置myTable(表名)
	 * @param myTable (表名)
	 */
	public void setMyTable(String myTable) {
		this.myTable = myTable;
	}
    
	/**
	 * 取得MyId(我方id)
	 */
	public String getMyId() {
		return myId;
	}

	/**
	 * 设置myId(我方id)
	 * @param myId (我方id)
	 */
	public void setMyId(String myId) {
		this.myId = myId;
	}
    
	/**
	 * 取得OlddbId(对方id)
	 */
	public String getOlddbId() {
		return olddbId;
	}

	/**
	 * 设置olddbId(对方id)
	 * @param olddbId (对方id)
	 */
	public void setOlddbId(String olddbId) {
		this.olddbId = olddbId;
	}
    
	
	public OlddbIdlog(){};


	/**
	 * 
	 * @param id ()
	 * @param myTable (表名)
	 * @param myId (我方id)
	 * @param olddbId (对方id)
	 */
	public OlddbIdlog(    
		int id,
        		String myTable,
        		String myId,
        		String olddbId
        ) {
		super();  
		this.id = id;
		this.myTable = myTable;
		this.myId = myId;
		this.olddbId = olddbId;
	}
    
	/**
	 * 
	 * @param myTable (表名)
	 * @param myId (我方id)
	 * @param olddbId (对方id)
	 */
	public OlddbIdlog(    
		String myTable,
        		String myId,
        		String olddbId
        ) {
		super();		
		this.myTable = myTable;
		this.myId = myId;
		this.olddbId = olddbId;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
