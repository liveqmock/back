package com.ihk.customer.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.autocomplete.AutoCompleteMapCallback;
import com.ihk.utils.autocomplete.AutoCompleteUtils;

/**
 * 销售智能提示框
 * @author dtc
 * 2013-2-1,下午04:10:45
 */
public class SaleListAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IUserAccountServices userAccountServices;
	
	/**
	 * 获取销售
	 * @return
	 * @throws Exception
	 */
	public String sales() throws Exception{
		
		/*AutoCompleteUtils.doComplete(this, "realName", "realName", new AutoCompleteCallback() {
			
			@Override
			public List<?> complete(String name) throws Exception {
				
				return userAccountServices.findUserAccountsLikeName(name);
			}
		});*/
		
		AutoCompleteUtils.doComplete(this, new AutoCompleteMapCallback() {
			
			@Override
			public Map<String, String> complete(String name) throws Exception {
				
				Map<String, String> map = new HashMap<String, String>();
				
				List<UserAccount> list = userAccountServices.findUserAccountsLikeName(name);
				
				if(!CommonUtils.isCollectionEmpty(list)){
					
					for(UserAccount user : list){
						
						map.put(user.getId()+"", user.getRealName() + "(" + user.getUserName() + ")");
					}
					
				}
				
				return map;
			}
		});
		
		return null;
	}

}
