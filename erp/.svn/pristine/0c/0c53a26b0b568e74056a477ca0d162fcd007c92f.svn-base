package com.ihk.utils.contract.sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractSalesman;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 认购签约的销售
 * @author dtc
 * 2013-3-18,下午04:43:27
 */
public class SaleUtils {
	
	/**
	 * 为认筹的销售前后加上逗号
	 * @param chip
	 * @return
	 */
	public static Chip initSalesId(Chip chip){
		
		chip.setSalesId(initSalesId(chip.getSalesId()));
		
		return chip;
	}
	
	/**
	 * 为临定的销售id前后加上逗号
	 * @param confirmBook
	 * @return
	 */
	public static ConfirmBook initSalesId(ConfirmBook confirmBook){
		
		confirmBook.setSalesId(initSalesId(confirmBook.getSalesId()));
		
		return confirmBook;
	}
	
	/**
	 * 为成交的销售id前后加上逗号
	 * @param confirm
	 * @return
	 */
	public static Confirm initSalesId(Confirm confirm){
		
		confirm.setSalesId(initSalesId(confirm.getSalesId()));
		
		return confirm;
	}
	
	/**
	 * 为合同的销售id前后加上逗号
	 * @param contract
	 * @return
	 */
	public static Contract initSalesId(Contract contract){
		
		contract.setSalesId(initSalesId(contract.getSalesId()));
		
		return contract;
	}
	
	/**
	 * 增加临定的销售表
	 * @param confirmBook
	 * @throws RuntimeException 
	 */
	public static void addContractSalesman(ConfirmBook confirmBook) throws RuntimeException{
		
		try{
		
			if(confirmBook == null || CommonUtils.isStrZeroEmpty(confirmBook.getSalesId())){
				return ;
			}
			
			Map<Integer, BigDecimal> map = initSalesPercentMap(confirmBook.getSalesId());
			
			if(CommonUtils.isMapEmpty(map)){
				return ;
			}
			
			Set<Integer> keys = map.keySet();
			
			for(int key : keys){
	
				ContractSalesman sman = new ContractSalesman();
				
				sman.setConfirmType(ContConfirmType.CONFIRM_BOOK);
				sman.setMainId(confirmBook.getId());
				
				sman.setSalesId(key);
				sman.setSalesPercent(map.get(key));
				
				CommonPojoUtils.initPojoCommonFiled(sman);
				
				MyPropertyUtils.getContractSalesmanServices().addContractSalesman(sman);
				
			}
			
		}catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 增加认筹的销售表
	 * @param chip
	 * @throws RuntimeException
	 */
	public static void addContractSalesman(Chip chip) throws RuntimeException{
		
		try{
			
			if(chip == null || CommonUtils.isStrZeroEmpty(chip.getSalesId())){
				return ;
			}
			
			Map<Integer, BigDecimal> map = initSalesPercentMap(chip.getSalesId());
			
			if(CommonUtils.isMapEmpty(map)){
				return ;
			}
			
			Set<Integer> keys = map.keySet();
			
			for(int key : keys){
		
				ContractSalesman sman = new ContractSalesman();
				
				sman.setConfirmType(ContConfirmType.CHIP);
				sman.setMainId(chip.getId());
				
				sman.setSalesId(key);
				sman.setSalesPercent(map.get(key));
				
				CommonPojoUtils.initPojoCommonFiled(sman);
				
				MyPropertyUtils.getContractSalesmanServices().addContractSalesman(sman);
				
			}
		}catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	
	}
	
	/**
	 * 增加成交的销售表
	 * @param confirm
	 * @throws RuntimeException
	 */
	public static void addContractSalesman(Confirm confirm) throws RuntimeException{
		
		try{
					
			if(confirm == null || CommonUtils.isStrZeroEmpty(confirm.getSalesId())){
				return ;
			}
			
			Map<Integer, BigDecimal> map = initSalesPercentMap(confirm.getSalesId());
			
			if(CommonUtils.isMapEmpty(map)){
				return ;
			}
			
			Set<Integer> keys = map.keySet();
			
			for(int key : keys){
		
				ContractSalesman sman = new ContractSalesman();
				
				sman.setConfirmType(ContConfirmType.CONFIRM);
				sman.setMainId(confirm.getId());
				
				sman.setSalesId(key);
				sman.setSalesPercent(map.get(key));
				
				CommonPojoUtils.initPojoCommonFiled(sman);
				
				MyPropertyUtils.getContractSalesmanServices().addContractSalesman(sman);
				
			}
		}catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 增加合同的销售表
	 * @param confirm
	 * @throws RuntimeException
	 */
	public static void addContractSalesman(Contract contract) throws RuntimeException{
		
		try{
			
			if(contract == null || CommonUtils.isStrZeroEmpty(contract.getSalesId())){
				return ;
			}
			
			Map<Integer, BigDecimal> map = initSalesPercentMap(contract.getSalesId());
			
			if(CommonUtils.isMapEmpty(map)){
				return ;
			}
			
			Set<Integer> keys = map.keySet();
			
			for(int key : keys){
		
				ContractSalesman sman = new ContractSalesman();
				
				sman.setConfirmType(ContConfirmType.CONTRACT);
				sman.setMainId(contract.getId());
				
				sman.setSalesId(key);
				sman.setSalesPercent(map.get(key));
				
				CommonPojoUtils.initPojoCommonFiled(sman);
				
				MyPropertyUtils.getContractSalesmanServices().addContractSalesman(sman);
				
			}
		}catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	
	}
	
	/**
	 * 临定销售的修改
	 * @param confirmBook
	 * @throws RuntimeException
	 */
	public static void updateContractSalesman(ConfirmBook confirmBook) throws RuntimeException{
		
		if(confirmBook == null){
			throw new NullPointerException();
		}
		
		ConfirmBook oldConfirmBook = MyPropertyUtils.getConfirmBookServices().findConfirmBookById(confirmBook.getId());
		
		String oldSalesId = oldConfirmBook.getSalesId();
		String salesId = confirmBook.getSalesId();
		
		if(salesId.equals(oldSalesId)){
			//表示没有变化
			return ;
		}
		
		//如果有变化,就先删除旧的,然后新增新的
		List<Integer> oldIds = CommonUtils.stringToList(oldSalesId);
		if(!CommonUtils.isCollectionEmpty(oldIds)){
			//删除旧的
			
			for(int id : oldIds){
				
				MyPropertyUtils.getConfirmBookServices().deleteConfirmBook(id);
			}
			
		}
		
		//新增新的
		addContractSalesman(confirmBook);
		
	}
	
	/**
	 * 认筹销售的修改
	 * @param chip
	 * @throws RuntimeException
	 */
	public static void updateContractSalesman(Chip chip) throws RuntimeException{
		
		if(chip == null){
			throw new NullPointerException();
		}
		
		Chip oldChip = MyPropertyUtils.getChipServices().findChipById(chip.getId());
		
		String oldSalesId = oldChip.getSalesId();
		String salesId = chip.getSalesId();
		
		if(salesId.equals(oldSalesId)){
			//表示没有变化
			return ;
		}
		
		//如果有变化,就先删除旧的,然后新增新的
		List<Integer> oldIds = CommonUtils.stringToList(oldSalesId);
		if(!CommonUtils.isCollectionEmpty(oldIds)){
			//删除旧的
			
			for(int id : oldIds){
				
				MyPropertyUtils.getChipServices().deleteChip(id);
			}
			
		}
		
		//新增新的
		addContractSalesman(chip);
		
	}
	
	/**
	 * 成交销售的修改
	 * @param confirm
	 * @throws RuntimeException
	 */
	public static void updateContractSalesman(Confirm confirm) throws RuntimeException{
		
		if(confirm == null){
			throw new NullPointerException();
		}
		
		Confirm oldConfirm = MyPropertyUtils.getConfirmServices().findConfirmById(confirm.getId());
		
		String oldSalesId = oldConfirm.getSalesId();
		String salesId = confirm.getSalesId();
		
		if(salesId.equals(oldSalesId)){
			//表示没有变化
			return ;
		}
		
		//如果有变化,就先删除旧的,然后新增新的
		List<Integer> oldIds = CommonUtils.stringToList(oldSalesId);
		if(!CommonUtils.isCollectionEmpty(oldIds)){
			//删除旧的
			
			for(int id : oldIds){
				
				MyPropertyUtils.getConfirmServices().deleteConfirm(id);
			}
			
		}
		
		//新增新的
		addContractSalesman(confirm);
		
	}
	
	/**
	 * 合同销售的修改
	 * @param contract
	 * @throws RuntimeException
	 */
	public static void updateContractSalesman(Contract contract) throws RuntimeException{
		
		if(contract == null){
			throw new NullPointerException();
		}
		
		Contract oldContract = MyPropertyUtils.getContractServices().findContractById(contract.getId());
		
		String oldSalesId = oldContract.getSalesId();
		String salesId = contract.getSalesId();
		
		if(salesId.equals(oldSalesId)){
			//表示没有变化
			return ;
		}
		
		//如果有变化,就先删除旧的,然后新增新的
		List<Integer> oldIds = CommonUtils.stringToList(oldSalesId);
		if(!CommonUtils.isCollectionEmpty(oldIds)){
			//删除旧的
			
			for(int id : oldIds){
				
				MyPropertyUtils.getContractServices().deleteContract(id);
			}
			
		}
		
		//新增新的
		addContractSalesman(contract);
		
	}
	
	/**
	 * 根据salesId字符串,设置对应销售的比例
	 * @param salesId
	 * @return
	 */
	public static Map<Integer, BigDecimal> initSalesPercentMap(String salesId){
		
		if(CommonUtils.isStrZeroEmpty(salesId)){
			return null;
		}
		
		List<Integer> list = CommonUtils.stringToList(salesId);
		if(CommonUtils.isCollectionEmpty(list)){
			return null;
		}
		
		List<Integer> realList = new ArrayList<Integer>();
		for(int id : list){
			
			if(id <= 0){
				continue;
			}
			
			realList.add(id);
		}
		
		if(CommonUtils.isCollectionEmpty(realList)){
			return null;
		}
		
		Map<Integer, BigDecimal> retMap = new LinkedHashMap<Integer, BigDecimal>();
		
		int size = realList.size();
		switch (size) {
		case 1:
			{
				retMap.put(list.get(0), new BigDecimal(100));
			}		
			break;
			
		case 2:
			{
				retMap.put(list.get(0), new BigDecimal(50));
				retMap.put(list.get(1), new BigDecimal(50));
			}
			break;
			
		case 3:
			{
				retMap.put(list.get(0), new BigDecimal(33.4));
				retMap.put(list.get(1), new BigDecimal(33.3));
				retMap.put(list.get(2), new BigDecimal(33.3));
			}
			break;
			
		case 4:
			{
				for(int i=0; i<size; i++){
					retMap.put(list.get(i), new BigDecimal(25));
				}
			}
			break;
			
		case 5:
			{
				for(int i=0; i<size; i++){
					retMap.put(list.get(i), new BigDecimal(20));
				}
			}
			break;
			
		default:
			retMap = null;
			break;
		}
		
		return retMap;
		
	}
	
	/**
	 * 加上前后逗号
	 * @param oldSalesId
	 * @return
	 */
	private static String initSalesId(String oldSalesId){
		
		if(!CommonUtils.isStrZeroEmpty(oldSalesId)){
			
			if(!oldSalesId.startsWith(",")){
				
				oldSalesId = "," + oldSalesId;
			}
			
			if(!oldSalesId.endsWith(",")){
				
				oldSalesId = oldSalesId + ",";
			}
			
		}
		
		return oldSalesId;
	}

}
