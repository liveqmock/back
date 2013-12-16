package com.dou.student.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.dou.student.data.pojo.Student;
import com.dou.student.data.pojo.StudentCond;

/**
 * Student的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IStudentServices {
	

	/**
	 * 新增Student
	 * @param student
	 */
	public void saveStudent(Student student) throws RuntimeException;

	/**
	 * 删除一条Student
	 * @param id
	 */
	public void removeStudent(int id) throws RuntimeException;

	/**
	 * 修改Student
	 * @param student
	 */
	public void updateStudent(Student student) throws RuntimeException;
	   
	/**
	 * 查找全部Student
	 * @param cond 查询条件
	 * @return Student列表
	 */
	public List findAllStudent() throws RuntimeException;

	/**
	 * 查找一条Student
	 * @return Student
	 * @param id 主键id
	 */
	public Student getStudentById(int id) throws RuntimeException;

	/**
	 * 分页查找Student
	 * @param cond 查询条件
	 * @return Student列表
	 */
	public List findStudentPage(StudentCond condition) throws RuntimeException;
}
