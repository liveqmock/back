package com.dou.student.data;

import java.util.List;
import java.util.Map;

import com.dou.student.data.pojo.Student;
import com.dou.student.data.pojo.StudentCond;


/**
 * Student数据访问接口Mapper
 * @author 
 *
 */ 
public interface IStudentMapper {


	/**
	 * 新增Student
	 * @param student
	 */
	public void saveStudent(Student student) ;

	/**
	 * 删除一条Student
	 * @param id 
	 */
	public void deleteStudent(int id) throws RuntimeException;


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
	public List<Student> findAllStudent() ;

	/**
	 * 查找一条Student
	 * @return Student
	 * @param id 主键id
	 */
	public Student findStudentById(int id) throws RuntimeException;

	/**
	 * 分页查找Student
	 * @param cond 查询条件
	 * @return Student列表
	 */
	public List<Student> findStudentPage(StudentCond cond) ;

	/**
	 * 查找符合条件的记录条数Student
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findStudentCount(StudentCond map) ;
}
