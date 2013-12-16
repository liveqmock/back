package com.dou.student.data.pojo;

import java.sql.Date;

/**
 * Student的实体类
 * @author 
 *
 */
public class Student {
	private int id;
	private String studentName;
	private String className;
	private int schoolId;

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
	 * 取得StudentName()
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * 设置studentName()
	 * @param studentName ()
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
    
	/**
	 * 取得ClassName()
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * 设置className()
	 * @param className ()
	 */
	public void setClassName(String className) {
		this.className = className;
	}
    
	/**
	 * 取得SchoolId()
	 */
	public int getSchoolId() {
		return schoolId;
	}

	/**
	 * 设置schoolId()
	 * @param schoolId ()
	 */
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
    
	
	public Student(){};


	/**
	 * 
	 * @param id ()
	 * @param studentName ()
	 * @param className ()
	 * @param schoolId ()
	 */
	public Student(    
		int id,
        		String studentName,
        		String className,
        		int schoolId
        ) {
		super();  
		this.id = id;
		this.studentName = studentName;
		this.className = className;
		this.schoolId = schoolId;
	}
    
	/**
	 * 
	 * @param studentName ()
	 * @param className ()
	 * @param schoolId ()
	 */
	public Student(    
		String studentName,
        		String className,
        		int schoolId
        ) {
		super();		
		this.studentName = studentName;
		this.className = className;
		this.schoolId = schoolId;
	}
}


