package com.ihk.junit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.pojo.ChipCond;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.ConfirmBookCond;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.pojo.ContractSalesman;
import com.ihk.saleunit.data.services.IChipServices;
import com.ihk.saleunit.data.services.IConfirmBookServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractSalesmanServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.contract.sale.SaleUtils;

/**
 * 设置contract_salesman的值,从表chip,confirm_book,confirm及contract中获取
 * @author dtc
 * 2013-7-31,上午09:51:59
 */
public class SetUpContractSalesman extends SupperJunit{
	
	@Test
	public void setUp() throws Exception{
		
		final IContractSalesmanServices contractSalesmanServices = 
			(IContractSalesmanServices) factory.getBean("contractSalesmanServices");
		
		final IChipServices chipServices = 
			(IChipServices) factory.getBean("chipServices");
		
		final IConfirmBookServices confirmBookServices = 
			(IConfirmBookServices) factory.getBean("confirmBookServices");
		
		final IConfirmServices confirmServices =
			(IConfirmServices) factory.getBean("confirmServices");
		
		final IContractServices contractServices = 
			(IContractServices) factory.getBean("contractServices");
		
		
		new MyTransationTemplate() {
			
			@Override
			protected void doExecuteCallback() throws Exception {
				
				//认筹
				List<ContractSalesman> allChipSmanList = retChipSmanList(chipServices);
				
				//临定
				List<ContractSalesman> allConfirmBookSmanList = retConfirmBookSmanList(confirmBookServices);
				
				//成交
				List<ContractSalesman> allConfirmSmanList = retConfirmSmanList(confirmServices);
				
				//合同
				List<ContractSalesman> allContractSmanList = retContractSmanList(contractServices);
				
				//所有的
				List<ContractSalesman> allList = new ArrayList<ContractSalesman>();
				
				allList.addAll(allChipSmanList);
				allList.addAll(allConfirmBookSmanList);
				allList.addAll(allConfirmSmanList);
				allList.addAll(allContractSmanList);
				
				for(ContractSalesman sman : allList){
					
					contractSalesmanServices.addContractSalesman(sman);
					
				}
				
			}
		}.doExecuteCallback();
		
	}
	
	/**
	 * 认筹list
	 * @param chipServices
	 * @return
	 */
	private List<ContractSalesman> retChipSmanList(IChipServices chipServices){
		
		List<ContractSalesman> allChipSmanList = new ArrayList<ContractSalesman>();
		
		List<Chip> chipList = chipServices.findChip(new ChipCond());
		
		if(CommonUtils.isCollectionEmpty(chipList)){
			return allChipSmanList;
		}
		
		List<ContractSalesman> tmpContractSmanList = null;
		
		for(Chip chip : chipList){
			
			tmpContractSmanList = initPojo(chip);
			if(!CommonUtils.isCollectionEmpty(tmpContractSmanList)){
				
				allChipSmanList.addAll(tmpContractSmanList);
			}
		}
		
		return allChipSmanList;
	}
	
	/**
	 * 临定list
	 * @param confirmBookServices
	 * @return
	 */
	private List<ContractSalesman> retConfirmBookSmanList(IConfirmBookServices confirmBookServices){
		
		List<ContractSalesman> allContractSmanList = new ArrayList<ContractSalesman>();
		
		List<ConfirmBook> confirmBookList = confirmBookServices.findConfirmBook(new ConfirmBookCond());
		
		if(CommonUtils.isCollectionEmpty(confirmBookList)){
			return allContractSmanList;
		}
		
		List<ContractSalesman> tmpContractSmanList = null;
		
		for(ConfirmBook confirmBook : confirmBookList){
			
			tmpContractSmanList = initPojo(confirmBook);
			if(!CommonUtils.isCollectionEmpty(tmpContractSmanList)){
				
				allContractSmanList.addAll(tmpContractSmanList);
			}
		}
		
		return allContractSmanList;
	}
	
	/**
	 * 成交list
	 * @param confirmServices
	 * @return
	 */
	private List<ContractSalesman> retConfirmSmanList(IConfirmServices confirmServices){
		
		List<ContractSalesman> allConfirmSmanList = new ArrayList<ContractSalesman>();
		
		List<Confirm> confirmList = confirmServices.findConfirm(new ConfirmCond());
		
		if(CommonUtils.isCollectionEmpty(confirmList)){
			return allConfirmSmanList;
		}
		
		List<ContractSalesman> tmpConfirmSmanList = null;
		
		for(Confirm confirm : confirmList){
			
			tmpConfirmSmanList = initPojo(confirm);
			if(!CommonUtils.isCollectionEmpty(tmpConfirmSmanList)){
				
				allConfirmSmanList.addAll(tmpConfirmSmanList);
			}
		}
		
		return allConfirmSmanList;
	}
	
	/**
	 * 合同list
	 * @param contractServices
	 * @return
	 */
	private List<ContractSalesman> retContractSmanList(IContractServices contractServices){
		
		List<ContractSalesman> allContractSmanList = new ArrayList<ContractSalesman>();
		
		List<Contract> contractList = contractServices.findContract(new ContractCond());
		
		if(CommonUtils.isCollectionEmpty(contractList)){
			return allContractSmanList;
		}
		
		List<ContractSalesman> tmpContractSmanList = null;
		
		for(Contract contract : contractList){
			
			tmpContractSmanList = initPojo(contract);
			if(!CommonUtils.isCollectionEmpty(tmpContractSmanList)){
				
				allContractSmanList.addAll(tmpContractSmanList);
			}
		}
		
		return allContractSmanList;
	}
	
	/**
	 * 获取认筹的ContractSalesman
	 * @param chip
	 * @return
	 */
	private List<ContractSalesman> initPojo(Chip chip){
		
		if(chip == null){
			return null;
		}
		
		String salesId = chip.getSalesId();
		Map<Integer, BigDecimal> map = SaleUtils.initSalesPercentMap(salesId);
		
		if(CommonUtils.isMapEmpty(map)){
			return null;
		}
		
		List<ContractSalesman> retList = new ArrayList<ContractSalesman>();
		
		Set<Integer> keys = map.keySet();
		for(int key : keys){

			ContractSalesman sman = new ContractSalesman();
			sman.setConfirmType(ContConfirmType.CHIP);
			sman.setMainId(chip.getId());
			
			sman.setSalesId(key);
			sman.setSalesPercent(map.get(key));
			
			sman.setIsDeleted(CommonUtils.NORMAL);
			sman.setCreatedId(chip.getCreatedId());
			sman.setCreatedTime(chip.getCreatedTime());
			sman.setModId(chip.getCreatedId());
			sman.setModTime(chip.getModTime());
			
			retList.add(sman);
		}
		
		return retList;
	}
	
	/**
	 * 获取临定的ContractSalesman
	 * @param confirmBook
	 * @return
	 */
	private List<ContractSalesman> initPojo(ConfirmBook confirmBook){
		
		if(confirmBook == null){
			return null;
		}
		
		String salesId = confirmBook.getSalesId();
		Map<Integer, BigDecimal> map = SaleUtils.initSalesPercentMap(salesId);
		
		if(CommonUtils.isMapEmpty(map)){
			return null;
		}
		
		List<ContractSalesman> retList = new ArrayList<ContractSalesman>();
		
		Set<Integer> keys = map.keySet();
		for(int key : keys){

			ContractSalesman sman = new ContractSalesman();
			sman.setConfirmType(ContConfirmType.CONFIRM_BOOK);
			sman.setMainId(confirmBook.getId());
			
			sman.setSalesId(key);
			sman.setSalesPercent(map.get(key));
			
			sman.setIsDeleted(CommonUtils.NORMAL);
			sman.setCreatedId(confirmBook.getCreatedId());
			sman.setCreatedTime(confirmBook.getCreatedTime());
			sman.setModId(confirmBook.getCreatedId());
			sman.setModTime(confirmBook.getModTime());
			
			retList.add(sman);
		}
		
		return retList;
	}
	
	/**
	 * 获取成交的ContractSalesman
	 * @param confirm
	 * @return
	 */
	private List<ContractSalesman> initPojo(Confirm confirm){
		
		if(confirm == null){
			return null;
		}
		
		String salesId = confirm.getSalesId();
		Map<Integer, BigDecimal> map = SaleUtils.initSalesPercentMap(salesId);
		
		if(CommonUtils.isMapEmpty(map)){
			return null;
		}
		
		List<ContractSalesman> retList = new ArrayList<ContractSalesman>();
		
		Set<Integer> keys = map.keySet();
		for(int key : keys){

			ContractSalesman sman = new ContractSalesman();
			sman.setConfirmType(ContConfirmType.CONFIRM);
			sman.setMainId(confirm.getId());
			
			sman.setSalesId(key);
			sman.setSalesPercent(map.get(key));
			
			sman.setIsDeleted(CommonUtils.NORMAL);
			sman.setCreatedId(confirm.getCreatedId());
			sman.setCreatedTime(confirm.getCreatedTime());
			sman.setModId(confirm.getCreatedId());
			sman.setModTime(confirm.getModTime());
			
			retList.add(sman);
		}
		
		return retList;
	}
	
	/**
	 * 获取合同的ContractSalesman
	 * @param contract
	 * @return
	 */
	private List<ContractSalesman> initPojo(Contract contract){
		
		if(contract == null){
			return null;
		}
		
		String salesId = contract.getSalesId();
		Map<Integer, BigDecimal> map = SaleUtils.initSalesPercentMap(salesId);
		
		if(CommonUtils.isMapEmpty(map)){
			return null;
		}
		
		List<ContractSalesman> retList = new ArrayList<ContractSalesman>();
		
		Set<Integer> keys = map.keySet();
		for(int key : keys){

			ContractSalesman sman = new ContractSalesman();
			
			sman.setConfirmType(ContConfirmType.CONTRACT);
			sman.setMainId(contract.getId());
			
			sman.setSalesId(key);
			sman.setSalesPercent(map.get(key));
			
			sman.setIsDeleted(CommonUtils.NORMAL);
			sman.setCreatedId(contract.getCreatedId());
			sman.setCreatedTime(contract.getCreatedTime());
			sman.setModId(contract.getCreatedId());
			sman.setModTime(contract.getModTime());
			
			retList.add(sman);
		}
		
		return retList;
		
	}
	
}
