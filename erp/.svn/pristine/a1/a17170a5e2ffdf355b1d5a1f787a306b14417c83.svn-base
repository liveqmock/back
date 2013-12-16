package com.ihk.customer.data;

import java.util.List;

import com.ihk.customer.data.pojo.IdcardLocation;
import com.ihk.customer.data.pojo.IdcardLocationCond;

import com.ihk.utils.base.PojoDeleteCond;
 
public interface IIdcardLocationMapper {

	public void addIdcardLocation(IdcardLocation idcardLocation) ;

	public void deleteIdcardLocation(PojoDeleteCond cond) throws RuntimeException;

	public void updateIdcardLocation(IdcardLocation idcardLocation) throws RuntimeException;
	
	public IdcardLocation findIdcardLocationById(int id) throws RuntimeException;
	
	public List<IdcardLocation> findIdcardLocationPage(IdcardLocationCond cond) ;
    
	public List<IdcardLocation> findIdcardLocation(IdcardLocationCond cond) ;
    
	public int findIdcardLocationCount(IdcardLocationCond cond) ;
    
    /**
	 * ajax分页list
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<IdcardLocation> findIdcardLocationForAjax(IdcardLocationCond cond) ;
    
    /**
	 * ajax分页count
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findIdcardLocationCountForAjax(IdcardLocationCond cond) ;
}
