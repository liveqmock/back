package com.dou.student.action;

import java.util.HashMap; 
import java.util.List;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import com.dou.student.data.pojo.Student;
import com.dou.student.data.pojo.StudentCond;
import com.dou.student.data.services.IStudentServices;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.setting.data.pojo.CodeType;
import com.ihk.setting.data.services.ICodeTypeServices;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

import org.apache.log4j.Logger;   
import org.apache.log4j.PropertyConfigurator;  


import com.ihk.utils.Pager; 
import com.ihk.utils.SupperAction; 
import org.apache.struts2.ServletActionContext;

/**
 * Student(学生)对应的页面Action
 * @author peter.kuang
 *
 */
@SuppressWarnings("unchecked")
public class StudentAction extends SupperAction{
	@Autowired
	IStudentServices studentServices;
	
	@Autowired
	ICodeTypeServices codeTypeServices;
	//@Autowired
	private Student student;
	private String tips;
	private String id;
	private List studentList;
	
	private int projectId= 1;
	
	
	public String[] getDefaultGender(){
		return new String [] {"1", "0"};
	}
	
	private LinkedHashMap selGender; 
	
	public LinkedHashMap getSelGender() { 
		return selGender; 
	} 
	
	public void setSelGender(LinkedHashMap selGender) { 
		this.selGender = selGender; 
	} 
	
	public void initSelGender() {  
		if(this.selGender==null){
			this.selGender = codeTypeServices.findCodeListForSel(EnumCodeTypeName.GENDER,projectId);
		}
	} 
	
	public StudentAction(){
		//初始化下拉框
		searchEngine = new java.util.LinkedHashMap();
		searchEngine.put(1,"aaa");
		searchEngine.put(2,"bbb");
		searchEngine.put(3,"ccc");		
	}	
	
	private HashMap searchEngine; 	
	
	public HashMap getSearchEngine() { 
		return searchEngine; 
	} 
	
	public void setSearchEngine(HashMap searchEngine) { 
		this.searchEngine = searchEngine; 
	} 

	public String addStudent() {
		String result = "error";
		try {
			studentServices.saveStudent(student);
			this.setTips("add-ok");
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("system error");
		}
		return result;
	}
	
	
	public String queryStudent() {
		String result = "error";
		try {			
			Pager page = new Pager(ActionContext.getContext(),5,"queryStudent.action");
								
			Map<String, String> map = null;//page.getConditionMap();
			map.put("studentName","我1");
			
			StudentCond sp = new StudentCond();
			sp.studentName = "我";
			sp.startLine = Integer.valueOf(map.get("startLine"));
			sp.pageSize = 5;
			studentList = studentServices.findStudentPage(sp);  
			
			map.put("recordCount", String.valueOf(sp.recordCount));
			
			this.setShowPage(page.toHtmlString());
		
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("system error,please wait");
		}
		
		return result;
	}

	public String findStudent() {
		initSelGender();
		String result = "error";
		System.out.println("studentID:"+id);		
		
		System.out.println("enum:"+EnumCodeTypeName.GENDER);	
		System.out.println("enumString:"+EnumCodeTypeName.GENDER.toString());	
		
		try {
			student = studentServices.getStudentById(Integer
					.parseInt(this.getId()));
			System.out.println("titlex:");
			
			CodeType c = codeTypeServices.findCodeTypeByName("gender");
			System.out.println("1:"+c.getTypeName());
			
			List l = codeTypeServices.findCodeList("gender",1);
			codeTypeServices.findCodeListForSel(EnumCodeTypeName.GENDER,projectId);
			System.out.println("2:"+l.size());
			
			System.out.println("3:"+codeTypeServices.findCodeDescByCodeVal(EnumCodeTypeName.GENDER,"11",1));
			
			System.out.println("titley:");
			
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("system error");
		}
		return result;
	}
	
	public String newStudent(){
		String result = "error";
		System.out.println("newStudent:");
		
		try {
			student = new Student();
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("system error");
		}
		return result;
	}

	public String updateStudent() {
		String result = "error";
		try {
			studentServices.updateStudent(student);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("update error");
		}
		return result;
	}
	
	public String deleteStudent() {
		String result = "error";
		System.out.println("id:"+this.getId());
		try {
			studentServices.removeStudent(Integer.parseInt(this.getId()));
			System.out.println("id:"+this.getId());
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("delete error");
		}
		return result;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List getStudentList() {
		return studentList;
	}

	public void setStudentList(List studentList) {
		this.studentList = studentList;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
