package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.AppointBillDetail;
import com.ihk.saleunit.data.pojo.AppointBillDetailCond;

/**
 * AppointBillDetail数据访问接口Mapper
 * @author 
 *
 */ 
public interface IAppointBillDetailMapper {

	/**
	 * 新增AppointBillDetail
	 * @param appointBillDetail
	 */
	public void addAppointBillDetail(AppointBillDetail appointBillDetail) ;

	/**
	 * 根据条件删除AppointBillDetail
	 * @param cond 删除条件
	 */
	public void deleteAppointBillDetail(int id) throws RuntimeException;

	/**
	 * 修改AppointBillDetail
	 * @param appointBillDetail
	 */
	public void updateAppointBillDetail(AppointBillDetail appointBillDetail) throws RuntimeException;

	/**
	 * 查找一条AppointBillDetail
	 * @return AppointBillDetail
	 * @param id 主键id
	 */
	public AppointBillDetail findAppointBillDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找AppointBillDetail
	 * @param cond 查询条件
	 * @return AppointBillDetail列表
	 */
	public List<AppointBillDetail> findAppointBillDetailPage(AppointBillDetailCond cond) ;

	/**
	 * 查找全部AppointBillDetail
	 * @param cond 查询条件
	 * @return AppointBillDetail列表
	 */
	public List<AppointBillDetail> findAppointBillDetail(AppointBillDetailCond cond) ;

	/**
	 * 查找符合条件的记录条数AppointBillDetail
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findAppointBillDetailCount(AppointBillDetailCond cond) ;
	
	/**
	 * 根据BillId查找
	 * @param billId
	 * @return
	 * @throws RuntimeException
	 */
	public List<AppointBillDetail> findDetailByAppointBillId(int billId) throws RuntimeException;
}
