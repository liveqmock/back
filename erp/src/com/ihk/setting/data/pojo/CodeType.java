package com.ihk.setting.data.pojo;

import java.io.Serializable;


/**
 * CodeType的实体类
 * @author 
 *
 * isAllsame=2 表示要读project_text
 */
public class CodeType implements Serializable{
    
	private static final long serialVersionUID = -4708563293702116916L;
	
	private String typeName;
	private String typeDesc;
	/**
	 * =2 表示要读project_text
	 * */
	private String isAllsame;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
    
	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
    
	public String getIsAllsame() {
		return isAllsame;
	}

	public void setIsAllsame(String isAllsame) {
		this.isAllsame = isAllsame;
	}
	
	public boolean isAllsame(){
		if("1".equals(getIsAllsame())){
			return true;
		}
		
		return false;
	}
    
	
	public CodeType(){};

	public CodeType(    
		String typeName,
        		String typeDesc,
        		String isAllsame
        ) {
		super();  
		this.typeName = typeName;
		this.typeDesc = typeDesc;
		this.isAllsame = isAllsame;
	}
	public CodeType(    
		String typeDesc,
        		String isAllsame
        ) {
		super();		
		this.typeDesc = typeDesc;
		this.isAllsame = isAllsame;
	}
}
