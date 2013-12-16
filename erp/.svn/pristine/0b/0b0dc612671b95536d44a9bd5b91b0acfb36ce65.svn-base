package com.ihk.saleunit.action.sale;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.autocomplete.AutoCompleteUtils;
import com.ihk.utils.saleunitnew.PropertyTreeUtils;

/**
 * 关于销售的action
 * @author dtc
 * 2012-9-21
 */
public class SaleAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	private static final String deleted = "1";
	
	private static final String deleted_str = "(已删除)";
	@Autowired
	IUserAccountServices userAccountServices;
	
	@Deprecated
	public String searchSale() throws Exception{
		
		userList = userAccountServices.findUserAccountListByProjectId(SessionUser.getProjectId());
		
		trList = initTrList(userList);
		
		return "searchSale";
	}
	
	public String searchSaleForCompany() throws Exception{
		
		new AutoCompleteUtils(this, "realName", "id", "isDeleted"){
			
			@Override
			public List<?> complete() throws Exception {
				
				return userAccountServices.findUserAccountsLikeNameByCompanyIdIncludeDelete(search);
			}
		};
		
		return null;
	}
	
	@Deprecated
	public String deleteSale() throws Exception{
		
		String salesId = request.getParameter("salesId");
		String salesName = request.getParameter("salesName");
		
		String[] ids = salesId.split(",");
		String[] names = salesName.split(",");
		
		int length = ids.length;
		
		userList = new ArrayList<UserAccount>();
		UserAccount tmpUser = null;
		
		for(int i=0; i<length; i++){
			
			tmpUser = new UserAccount();
			tmpUser.setId(Integer.parseInt(ids[i]));
			tmpUser.setRealName(names[i]);
			
			userList.add(tmpUser);
			
		}
		
		trList = initTrList(userList);
		
		return "deleteSale";
	}
	
	/**
	 * 管理销售的弹出框
	 * @return
	 * @throws Exception
	 */
	public String modifySale() throws Exception{
		
		String salesId = request.getParameter("salesId");
		String salesName = request.getParameter("salesName");
		
		int projectId = PropertyTreeUtils.getLeftTreeProjectIdSession(request);
		userList = userAccountServices.findUserAccountListByProjectId(projectId); //该项目的所有销售
		
		if(CommonUtils.isStrEmpty(salesId)){
			//表示没有选择销售			
			
			proBeanTrList = initBeanTrList(userList);
			return "modifySale";
		}

		//因salesId前后都加了','所以要处理这种情况
		String[] tmpIds = salesId.split(",");
		List<String> idList = new ArrayList<String>();
		for(String id : tmpIds){
			
			if(!CommonUtils.isStrEmpty(id)){
				
				idList.add(id);
			}
		}
		
		Object[] idObj = idList.toArray();
		int objLength = idObj.length;
		
		String[] ids = new String[objLength];
		for(int i=0; i<objLength; i++){
			
			ids[i] = idObj[i].toString();
		}
		
		String[] names = salesName.split(",");
		
		int length = ids.length;
		
		List<SaleTagBean> tmpComBeanList = new ArrayList<SaleTagBean>(); //页面回传的已选择的销售(同公司不同项目)
		List<SaleTagBean> tmpProBeanList = new ArrayList<SaleTagBean>(); //页面回传的已选择的销售(同项目)
		SaleTagBean tmpBean = null;
		
		for(int i=0; i<length; i++){
			
			tmpBean = new SaleTagBean();
			tmpBean.setId(ids[i]);
			//判断是否已删除用户
			if(deleted.equals(userAccountServices.findUserAccountById(Integer.valueOf(ids[i])).getIsDeleted())){
				tmpBean.setName(names[i] + deleted_str);
			}else{
				tmpBean.setName(names[i]);
			}
			if(isListIncludeId(userList, ids[i])){
				
				tmpProBeanList.add(tmpBean);
			}else{
				
				tmpBean.setCheck("true");
				tmpComBeanList.add(tmpBean);
			}
			
		}
		
		comBeanTrList = initSaleTagTrList(tmpComBeanList);
		
		List<SaleTagBean> proBeanList = initSaleTagBean(userList, tmpProBeanList);
		proBeanTrList = initSaleTagTrList(proBeanList);
		
		return "modifySale";
	}
	
	/**
	 * @param userList
	 * @param bean
	 * @return
	 */
	private  List<SaleTagBean> initSaleTagBean(List<UserAccount> userList, List<SaleTagBean> tmpProBeanList){
		
		if(CommonUtils.isCollectionEmpty(userList))
			return tmpProBeanList;
		
		List<SaleTagBean> proBeanList = new ArrayList<SaleTagBean>();
		
		SaleTagBean bean = null;
		for(UserAccount user : userList){
			
			bean = userToBean(user, tmpProBeanList);
			proBeanList.add(bean);
		}
		
		return proBeanList;
	}
	
	/**
	 * 把beanList转成显示的list
	 * @param beanList
	 * @return
	 */
	private List<SaleTagBean[]> initSaleTagTrList(List<SaleTagBean> beanList) {
		
		List<SaleTagBean[]> retList = new ArrayList<SaleTagBean[]>();
		
		if(CommonUtils.isCollectionEmpty(beanList))
			return retList;
		
		int listCount = beanList.size();
		int trCount = listCount/2 + (listCount%2 == 0 ? 0 : 1);
		
		for(int i=1; i<=trCount; i++){
			
			SaleTagBean[] tmp = new SaleTagBean[2];
			
			SaleTagBean tmpBean = beanList.get((i-1)*2);
			tmp[0] = tmpBean;
			
			if(i*2 <= listCount){
				tmp[1] = beanList.get(i*2-1);
			}
			
			retList.add(tmp);
			
		}
		
		return retList;
	}

	/**
	 * 是否包含
	 * @param userList
	 * @param id
	 * @return
	 */
	private boolean isListIncludeId(List<UserAccount> userList, String id){
		
		boolean isInclude = false;
		
		for(UserAccount user : userList){
			
			String userId = user.getId() + "";
			if(userId.equals(id)){
				
				isInclude = true;
				break;
			}
			
		}
		
		return isInclude;
	}
	
	/**
	 * 废弃该方法
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public String oldModifySale() throws Exception{
		
		String salesId = request.getParameter("salesId");
		String salesName = request.getParameter("salesName");
		
		userList = userAccountServices.findUserAccountListByProjectId(SessionUser.getProjectId()); //该项目的所有销售
		
		if(CommonUtils.isStrEmpty(salesId)){
			//表示没有选择销售			
			
			beanTrList = initBeanTrList(userList);
			return "modifySale";
		}
		
		String[] ids = salesId.split(",");
		String[] names = salesName.split(",");
		
		int length = ids.length;
		
		List<SaleTagBean> tmpBeanList = new ArrayList<SaleTagBean>(); //页面回传的已选择的销售
		SaleTagBean tmpBean = null;
		
		for(int i=0; i<length; i++){
			
			tmpBean = new SaleTagBean();
			tmpBean.setId(ids[i]);
			tmpBean.setName(names[i]);
			
			tmpBeanList.add(tmpBean);
			
		}
		
		beanTrList = initBeanTrList(userList, tmpBeanList);
		
		return "modifySale";
	}
	
	/**
	 * 根据beanList设置SaleTagBean list的选择
	 * @param userList
	 * @param beanList,要设置为选择的bean
	 * @return
	 */
	private List<SaleTagBean[]> initBeanTrList(List<UserAccount> userList, List<SaleTagBean> beanList){
		
		if(CommonUtils.isCollectionEmpty(beanList)){
			
			return initBeanTrList(userList);
		}
		
		//先判断beanList中是否包含userList中没有的数据,(也就是从智能提示框中获取的数据)
		
		List<UserAccount> allUserList = new ArrayList<UserAccount>(); //最终要显示的用户
		
		if(userList == null){
			userList = new ArrayList<UserAccount>(); //避免空指针
		}
		allUserList.addAll(userList); 
		
		for(SaleTagBean bean : beanList){
			
			UserAccount exUser = getExUserAccount(userList, bean); //同公司不同项目的销售,(也就是上个页面从智能提示框中获取的数据)
			if(exUser != null){
				allUserList.add(exUser);
			}
		}
		
		//初始化步骤
		
		List<SaleTagBean[]> beanTrList = new ArrayList<SaleTagBean[]>();
		
		if(!CommonUtils.isCollectionEmpty(allUserList)){
			
			int listCount = allUserList.size();
			int trCount = listCount/2 + (listCount%2 == 0 ? 0 : 1);
			
			for(int i=1; i<=trCount; i++){
				
				SaleTagBean[] tmp = new SaleTagBean[2];
				
				UserAccount tmpUser = allUserList.get((i-1)*2);
				tmp[0] = userToBean(tmpUser, beanList);
				
				if(i*2 <= listCount){
					tmpUser = allUserList.get(i*2-1);
					tmp[1] = userToBean(tmpUser, beanList);
				}
				
				beanTrList.add(tmp);
				
			}
			
		}
		
		return beanTrList;
		
	}
	
	/**
	 * 判断userList是否包含bean对应的id userAccount,如果userList不包含bean对应的id就返回null,否则返回对应的userAccount
	 * @param userList
	 * @param bean
	 * @return 返回null表示userList包含了bean,非null表示userList没包含bean
	 */
	private UserAccount getExUserAccount(List<UserAccount> userList, SaleTagBean bean){
		
		String beanId = bean.getId();
		for(UserAccount user : userList){
			
			String userId = user.getId() + "";
			if(beanId.equals(userId)){
				
				return null;
			}
			
		}
		
		UserAccount retUser = new UserAccount();
		retUser.setId(Integer.parseInt(bean.getId()));
		retUser.setRealName(bean.getName());
		
		return retUser;
	}
	
	/**
	 * 根据userList转成页面显示的SaleTagBean list
	 * @param userList
	 * @return
	 */
	private List<SaleTagBean[]> initBeanTrList(List<UserAccount> userList){
		
		List<SaleTagBean[]> beanTrList = new ArrayList<SaleTagBean[]>();
		
		if(!CommonUtils.isCollectionEmpty(userList)){
			
			int listCount = userList.size();
			int trCount = listCount/2 + (listCount%2 == 0 ? 0 : 1);
			
			for(int i=1; i<=trCount; i++){
				
				SaleTagBean[] tmp = new SaleTagBean[2];
				
				UserAccount tmpUser = userList.get((i-1)*2);
				tmp[0] = userToBean(tmpUser, null);
				
				if(i*2 <= listCount){
					tmpUser = userList.get(i*2-1);
					tmp[1] = userToBean(tmpUser, null);
				}
				
				beanTrList.add(tmp);
				
			}
			
		}
		
		return beanTrList;
		
	}
	
	/**
	 * 把UserAccount转成SaleTagBean,beanList用来判断返回的bean是否处于选择状态
	 * @param user
	 * @param beanList
	 * @return
	 */
	private SaleTagBean userToBean(UserAccount user, List<SaleTagBean> beanList){
		
		SaleTagBean bean = new SaleTagBean();
		if(user == null)
			return bean;
		
		bean.setId(user.getId() + "");
		bean.setName(user.getRealName());
		
		if(CommonUtils.isCollectionEmpty(beanList))
			return bean;
		
		for(SaleTagBean tmpBean : beanList){
			
			String beanId = tmpBean.getId();
			String userId = user.getId() + "";
			
			if(beanId.equals(userId)){
				
				bean.setCheck("true");
				break;
			}
			
		}
		
		return bean;
		
	}
	
	/**
	 * 初始化trList
	 * @param userList
	 * @return
	 */
	private List<UserAccount[]> initTrList(List<UserAccount> userList){
		
		List<UserAccount[]> trList = new ArrayList<UserAccount[]>();
		
		if(!CommonUtils.isCollectionEmpty(userList)){
			
			int listCount = userList.size();
			int trCount = listCount/2 + (listCount%2 == 0 ? 0 : 1);
			
			for(int i=1; i<=trCount; i++){
				
				UserAccount[] tmp = new UserAccount[2];
				
				tmp[0] = userList.get((i-1)*2);
				
				if(i*2 <= listCount){
					tmp[1] = userList.get(i*2-1);
				}
				
				trList.add(tmp);
				
			}
			
		}
		
		return trList;
	}
	
	///
	
	private List<UserAccount[]> trList; //页面显示list(UserAccount)
	private List<SaleTagBean[]> beanTrList; //页面显示list(SaleTagBean)
	
	private List<SaleTagBean[]> proBeanTrList; //同项目的
	private List<SaleTagBean[]> comBeanTrList; //同公司不同项目的
	
	private List<UserAccount> userList;

	public List<UserAccount[]> getTrList() {
		return trList;
	}

	public void setTrList(List<UserAccount[]> trList) {
		this.trList = trList;
	}

	public List<SaleTagBean[]> getBeanTrList() {
		return beanTrList;
	}

	public void setBeanTrList(List<SaleTagBean[]> beanTrList) {
		this.beanTrList = beanTrList;
	}

	public List<SaleTagBean[]> getProBeanTrList() {
		return proBeanTrList;
	}

	public void setProBeanTrList(List<SaleTagBean[]> proBeanTrList) {
		this.proBeanTrList = proBeanTrList;
	}

	public List<SaleTagBean[]> getComBeanTrList() {
		return comBeanTrList;
	}

	public void setComBeanTrList(List<SaleTagBean[]> comBeanTrList) {
		this.comBeanTrList = comBeanTrList;
	}

	public List<UserAccount> getUserList() {
		return userList;
	}

	public void setUserList(List<UserAccount> userList) {
		this.userList = userList;
	}
	
}
