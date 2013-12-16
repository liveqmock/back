package com.ihk.permission;

import java.util.ArrayList;
import java.util.List;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SearchCond;

/**
 * 公司项目数据权限的查询条件
 * 作为父类
 * @author peter.kuang
 *
 */
public class CompanyProjectPermissionCond extends SearchCond{

	private static final long serialVersionUID = 1383546099270995466L;

	/**
	 * 公司项目id权限
	 */
	private List<Integer> privCompanyProjectIds;

	/**
	 * 传入mapper查询的公司项目id(sql语句用)
	 */
	private List<Integer> companyProjectIds;
	
	/**
	 * 传入mapper查询的公司id(sql语句用)
	 */
	private List<Integer> companyIds;

	/**
	 * 页面查询的公司id
	 */
	private List<Integer> searchCompanyIds;

	/**
	 * 查询公司id的的字符串,以逗号分隔
	 */
	private String strSearchCompanyIds;

	/**
	 * 查询公司名称的的字符串,以逗号分隔
	 */
	private String strSearchCompanyNames;
	
	/**
	 * 页面查询的公司项目id
	 */
	private List<Integer> searchCompanyProjectIds;

	/**
	 * 查询项目id的的字符串,以逗号分隔
	 */
	private String strSearchCompanyProjectIds;

	/**
	 * 查询项目名称的的字符串,以逗号分隔
	 */
	private String strSearchCompanyProjectNames;


	/**
	 * @return 公司项目id权限
	 */
	public List<Integer> getPrivCompanyProjectIds() {
		return privCompanyProjectIds;
	}


	/**
	 * @param 公司项目id权限
	 */
	public void setPrivCompanyProjectIds(List<Integer> privCompanyProjectIds) {
		this.privCompanyProjectIds = privCompanyProjectIds;

		autoSetCompanyProjectIds();
	}

	public List<Integer> getCompanyProjectIds() {
		return companyProjectIds;
	}

	public void setCompanyProjectIds(List<Integer> companyProjectIds) {
		 this.companyProjectIds=CommonUtils.getListCopy(companyProjectIds);		
	}
	
	public List<Integer> getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(List<Integer> companyIds) {
		 this.companyIds=CommonUtils.getListCopy(companyIds);		
	}
	

	public List<Integer> getSearchCompanyIds() {
		return searchCompanyIds;
	}

	public void setSearchCompanyIds(List<Integer> asearchCompanyIds) {
		this.searchCompanyIds = CommonUtils.getListCopy(asearchCompanyIds);		

		strSearchCompanyIds = CommonUtils.ListToString(this.searchCompanyIds);
		
		//设置项目id的列表为,公司下属的所有项目
		List<Integer> listProjectIds = PermissionUtils.getCompanyAllProjectIdsByCompanys(asearchCompanyIds);
//		setCompanyProjectIds(listProjectIds);
		setSearchCompanyProjectIds(listProjectIds);	
		
		autoSetCompanyProjectIds();
	}

	public List<Integer> getSearchCompanyProjectIds() {
		return searchCompanyProjectIds;
	}

	public void setSearchCompanyProjectIds(List<Integer> asearchCompanyProjectIds) {
		this.searchCompanyProjectIds = CommonUtils.getListCopy(asearchCompanyProjectIds);		

		strSearchCompanyProjectIds = CommonUtils.ListToString(this.searchCompanyProjectIds);
		autoSetCompanyProjectIds();
	}	


	/**
	 * 页面查询公司的id列表
	 * @return
	 */
	public String getStrSearchCompanyIds() {
		return strSearchCompanyIds;
	}

	/**
	 * 页面查询公司的公司名称列表
	 * @return
	 */
	public String getStrSearchCompanyNames() {	
		StringBuffer sb = new StringBuffer();
		if(searchCompanyIds!=null){
			for (int i = 0; i < searchCompanyIds.size(); i++) {
				sb.append(DescUtils.getCompanyRealName(searchCompanyIds.get(i)));
				if(i<searchCompanyIds.size()-1){
					sb.append(",");					
				}
			}
		}
		strSearchCompanyNames = sb.toString();
		return strSearchCompanyNames;
	}		

	public void setStrSearchCompanyIds(String strSearchCompanyIds) {
		this.strSearchCompanyIds = strSearchCompanyIds;
		String[] strs = this.strSearchCompanyIds.split(",");
		if(searchCompanyIds==null){
			searchCompanyIds = new ArrayList<Integer>();
		}
		searchCompanyIds.clear();
		for(int i=0; i<strs.length; i++){
			try{
				searchCompanyIds.add(Integer.valueOf(strs[i]));
			}
			catch(Exception ex){
				continue;
			}
		}
		companyIds=CommonUtils.stringToList(strSearchCompanyIds);
		setSearchCompanyIds(searchCompanyIds);
	}

	public void setStrSearchCompanyNames(String strSearchCompanyNames) {
		this.strSearchCompanyNames = strSearchCompanyNames;
	}

	/**
	 * 页面查询公司项目的项目id列表
	 * @return
	 */
	public String getStrSearchCompanyProjectIds() {
		return strSearchCompanyProjectIds;
	}

	/**
	 * 页面查询项目的公司项目名称列表
	 * @return
	 */
	public String getStrSearchCompanyProjectNames() {	
		StringBuffer sb = new StringBuffer();
		if(searchCompanyProjectIds!=null){
			for (int i = 0; i < searchCompanyProjectIds.size(); i++) {
				sb.append(DescUtils.getProjectNameByProjectId(searchCompanyProjectIds.get(i)));
				if(i<searchCompanyProjectIds.size()-1){
					sb.append(",");					
				}
			}
		}
		strSearchCompanyProjectNames = sb.toString();
		return strSearchCompanyProjectNames;
	}		

	public void setStrSearchCompanyProjectIds(String strSearchCompanyProjectIds) {
		this.strSearchCompanyProjectIds = strSearchCompanyProjectIds;
		String[] strs = this.strSearchCompanyProjectIds.split(",");
		if(searchCompanyProjectIds==null){
			searchCompanyProjectIds = new ArrayList<Integer>();
		}
		searchCompanyProjectIds.clear();
		for(int i=0; i<strs.length; i++){
			try{
				searchCompanyProjectIds.add(Integer.valueOf(strs[i]));
			}
			catch(Exception ex){
				continue;
			}
		}
		setSearchCompanyProjectIds(searchCompanyProjectIds);
	}

	public void setStrSearchCompanyProjectNames(String strSearchCompanyProjectNames) {
		this.strSearchCompanyProjectNames = strSearchCompanyProjectNames;
	}


	/**
	 * 自动设置companyProjectIds的属性
	 */
	private void autoSetCompanyProjectIds() {
		if(companyProjectIds==null){
			companyProjectIds = new ArrayList<Integer>();
		}
		
		companyProjectIds.clear();

		if(privCompanyProjectIds!=null && searchCompanyProjectIds!=null && searchCompanyProjectIds.size()>0){//取得交集；有查询条件且已经设置权限
			for(int i=0;i<privCompanyProjectIds.size();i++){
				if(this.searchCompanyProjectIds.contains(privCompanyProjectIds.get(i)) && !this.companyProjectIds.contains(privCompanyProjectIds.get(i))){
					this.companyProjectIds.add(privCompanyProjectIds.get(i));
				}				
			}
		}
		else{
			 this.companyProjectIds = CommonUtils.getListCopy(privCompanyProjectIds);//默认等于数据权限
		}	
		
		//确保companyProjectIds不为空，为空则会导致查全数据库的数据，这是非常不对的
		if(this.companyProjectIds==null || this.companyProjectIds.size()==0){
			List<Integer> emptyList = new ArrayList<Integer>();
			emptyList.add(Integer.parseInt("-1"));
			this.companyProjectIds = emptyList;//如果不查询,则相当于直接设置一个不存在的projectId值	
		}		
	}
	

	/**
	 * 跟进权限，追加能查看的项目id<br>
	 * 举例:listIds可以使用PermissionUtils.getProjectIdListByXKZX()使用销控中心的权限<br>
	 * 也可以使用PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD)得到售前客户的查询条件
	 */
	public void addPermissionCompanyProjectIds(List<Integer> listIds){
		if(listIds.size()==0){
			//如果没有设置公司项目权限，则限制不能看
			listIds.add(-1);
		}
		for(int i=0;i<listIds.size();i++){
			if(privCompanyProjectIds==null){
				privCompanyProjectIds = new ArrayList<Integer>();
			}
			if(!this.privCompanyProjectIds.contains(listIds.get(i))){
				this.privCompanyProjectIds.add(listIds.get(i));
			}
		}
		
		autoSetCompanyProjectIds();
	}


	
}
