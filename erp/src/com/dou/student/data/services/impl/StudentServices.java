package com.dou.student.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dou.student.data.IStudentMapper;
import com.dou.student.data.pojo.Student;
import com.dou.student.data.pojo.StudentCond;
import com.dou.student.data.services.IStudentServices;

/**
 * Student的Services实现(业务实现)
 * @author 
 *
 */
@Service("studentServices")
@SuppressWarnings("unchecked")
public class StudentServices implements IStudentServices {
	/**
	 * student数据访问接口
	 */
	@Autowired	 IStudentMapper studentMapper;

	/**
	 * 查找一条Student
	 * @return Student
	 * @param id 主键id
	 */
	public List findAllStudent() throws RuntimeException {
		return studentMapper.findAllStudent();
	}

	/**
	 * 删除一条Student
	 * @param id
	 */
	public void removeStudent(int id) throws RuntimeException {
		studentMapper.deleteStudent(id);
	}

	/**
	 * 新增Student
	 * @param student
	 */
	public void saveStudent(Student student) throws RuntimeException {
		studentMapper.saveStudent(student);
	}

	/**
	 * 查找一条Student
	 * @return Student
	 * @param id 主键id
	 */
	@Override
	public Student getStudentById(int id) throws RuntimeException {
		return studentMapper.findStudentById(id);
	}

	/**
	 * 修改Student
	 * @param student
	 */
	@Override
	public void updateStudent(Student student) throws RuntimeException {
		studentMapper.updateStudent(student);
		
	}

	/**
	 * 分页查找Student
	 * @param cond 查询条件
	 * @return Student列表
	 */
	public List findStudentPage(StudentCond map) throws RuntimeException {		
		int recordCount = studentMapper.findStudentCount(map);
		
		map.recordCount = recordCount;
		
		return studentMapper.findStudentPage(map);
	}
	





}
