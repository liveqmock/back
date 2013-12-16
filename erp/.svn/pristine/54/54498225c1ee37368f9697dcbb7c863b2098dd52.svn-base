package com.ihk.customer.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.IdcardLocation;
import com.ihk.customer.data.pojo.IdcardLocationCond;

@Transactional 
public interface IIdcardLocationServices {
	public void addIdcardLocation(IdcardLocation idcardLocation) throws RuntimeException;

	public void deleteIdcardLocation(int id) throws RuntimeException;

	public void updateIdcardLocation(IdcardLocation idcardLocation) throws RuntimeException;

	public IdcardLocation findIdcardLocationById(int id) throws RuntimeException;
    
	public List<IdcardLocation> findIdcardLocationPage(IdcardLocationCond cond) throws RuntimeException;
    
	public List<IdcardLocation> findIdcardLocation(IdcardLocationCond cond) throws RuntimeException;
    
	public int findIdcardLocationCount(IdcardLocationCond cond) throws RuntimeException;
    /**
	 * ajax分页list
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<IdcardLocation> findIdcardLocationForAjax(IdcardLocationCond cond) throws RuntimeException;
    
    /**
	 * ajax分页count
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findIdcardLocationCountForAjax(IdcardLocationCond cond) throws RuntimeException;
    
}