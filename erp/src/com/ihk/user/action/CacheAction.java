package com.ihk.user.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.utils.CacheFrontName;
import com.ihk.utils.CacheUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DownloadCache;
import com.ihk.utils.PermissionCacheName;
import com.ihk.utils.QuartzUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.common.listener.HttpSessionBindingListenerKeyBean;
import com.ihk.utils.listpage.ListPageUtils;

/**
 * 权限缓存
 * */
public class CacheAction extends SupperAction{
 
	private static final long serialVersionUID = 1L;
	
	private static final int pageSize = 10;
	
	private static List<String> roleNameList;
	static{
		roleNameList = new ArrayList<String>();
		
		roleNameList.add(PermissionCacheName.PRIV);
		roleNameList.add(PermissionCacheName.ROLE);
		roleNameList.add(PermissionCacheName.ROLE_PRIV);
		roleNameList.add(PermissionCacheName.USER_ROEL);
		
	}
	
	private String message="";
	private LinkedHashMap<String, String> caches;
	
	private LinkedHashMap<String, String> roleCaches;
	
	private LinkedHashMap<String, String> downloadCaches;
	
	private List<List<Object>> showCaches;
	private String showCacheName;
	
	public String getShowCacheName() {
		return showCacheName;
	}
	
	public void setShowCacheName(String showCacheName) {
		this.showCacheName = showCacheName;
	}
	
	public List<List<Object>> getShowCaches() {
		return showCaches;
	}
	
	public void setShowCaches(List<List<Object>> showCaches) {
		this.showCaches = showCaches;
	}
	
	public LinkedHashMap<String, String> getRoleCaches() {
		return roleCaches;
	}
	
	public void setRoleCaches(LinkedHashMap<String, String> roleCaches) {
		this.roleCaches = roleCaches;
	}
	
	public LinkedHashMap<String, String> getDownloadCaches() {
		return downloadCaches;
	}

	public void setDownloadCaches(LinkedHashMap<String, String> downloadCaches) {
		this.downloadCaches = downloadCaches;
	}

	public void setCaches(LinkedHashMap<String, String> caches) {
		this.caches = caches;
	}
	
	public LinkedHashMap<String, String> getCaches() {
		return caches;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 缓存管理页面
	 * */
	public String toCachePage(){
		String quartzDate = QuartzUtils.getQuartzDateForString();  //当前日期减一天
		request.getSession().setAttribute("quartzDate", quartzDate);
		
		initCaches();
		
		return "cleancache";
	}
	
	public String cleanCache(){
		
		//CacheUtils.removeAllCache();
		
		String cacheName = request.getParameter("cacheName");
		
		if(CustomerUtils.isStrEmpty(cacheName)){
			
			CacheUtils.removeAllCache();
		}else{
			
			CacheUtils.removeCacheByCacheName(cacheName);
		}
		
		initCaches();
		
		setMessage(CommonUtils.SUCCSUGG);
		
		return "cleancache";
	}
	
	public String cleanRoleCache(){
		
		String cacheName = request.getParameter("cacheName");
		
		CacheUtils.removeCacheByLikeCacheName(cacheName);
		
		initCaches();
		
		setMessage(CommonUtils.SUCCSUGG);
		
		return "cleanRoleCache";
	}
	
	public String initDownloadCache(){
		
		String downloadCacheName = request.getParameter("downloadCacheName");
		
		try {
			
			DownloadCache.initCache(downloadCacheName);
			setMessage(CommonUtils.SUCCSUGG);
		} catch (Exception e) {
			e.printStackTrace();
			setMessage(CommonUtils.FAILSUGG);
		}
		
		initCaches();
		
		return "initDownloadCache";
	}
	
	@SuppressWarnings("unchecked")
	public String showCaches(){
		
		showCacheName = request.getParameter("showCacheName");
		
		if(!CommonUtils.isStrEmpty(showCacheName)){
			
			if(showCaches == null){
				showCaches = new ArrayList<List<Object>>();
			}

			List<Object> rows = null;
			
			Cache cache = CacheUtils.getCacheByName(showCacheName);
			List<Object> keys = cache.getKeys();
			//keys = keys.subList(0, 10);
			Object value = null;
			
			for(Object key : keys){
				value = CacheUtils.getValueByCacheNameAndKey(showCacheName, key.toString());
				
				rows = new ArrayList<Object>();

				rows.add(showCacheName);
				rows.add(key);
				rows.add(value);
				
				showCaches.add(rows);
			}
			
			request.getSession().setAttribute("showCaches", showCaches);
			int count = showCaches.size();
			int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			request.getSession().setAttribute("pageCount", pageCount);
			
			int endIndex = showCaches.size()>=10 ? 10 : showCaches.size();
			showCaches = showCaches.subList(0, endIndex);
			
		}
		
		initCaches();
		
		return "showCaches";
	}
	
	@SuppressWarnings("unchecked")
	public String ajaxShowCaches() throws Exception{
		
		List<List<Object>> getShowCaches = (List<List<Object>>) request.getSession().getAttribute("showCaches");
		
		if(CommonUtils.isCollectionEmpty(getShowCaches)){
			
			CustomerUtils.writeResponse(response, "");
			return null;
		}
		
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int count = getShowCaches.size();
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		
		if(pageNo <= 0){
			pageNo = 1;
		}
		if(pageNo >= pageCount){
			pageNo = pageCount;
		}
		
		int fromIndex = (pageNo-1) * pageSize;
		int toIndex = pageNo * pageSize >= count ? count : pageNo * pageSize;
		
		List<List<Object>> getList = getShowCaches.subList(fromIndex, toIndex);
		
		String out = ListPageUtils.page(getList, pageNo, pageCount);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private void initCaches(){
		
		String[] cacheNames = CacheUtils.getAllCacheName();
		
		if(caches == null){
			caches = new LinkedHashMap<String, String>();
			caches.put("", CommonUtils.ALL);
			for(String cacheName : cacheNames){
				
				if("MySimplePageCachingFilter".equals(cacheName))
					continue;
				
				caches.put(cacheName, cacheName);
				
			}
		}
		request.setAttribute("cacheSize", cacheNames.length);
		
		if(roleCaches == null){
			roleCaches = new LinkedHashMap<String, String>();
			
			for(String cacheName : roleNameList){
				roleCaches.put(cacheName, cacheName);
				
			}
			
		}
		
		if(downloadCaches == null){
			downloadCaches = new LinkedHashMap<String, String>();
			downloadCaches.put("", CommonUtils.ALL);
			
			List<String> fronts = new ArrayList<String>();
			
			fronts.add(CacheFrontName.PROVINCE_CACHE);
			fronts.add(CacheFrontName.CITY_CACHE);
			fronts.add(CacheFrontName.REGION_CACHE);
			
			fronts.add(CacheFrontName.CODE_TYPE_CACHE);
			fronts.add(CacheFrontName.CODE_DTL_CACHE);
			fronts.add(CacheFrontName.PROJECT_CODE_CACHE);
			
			fronts.add(CacheFrontName.CUSTOMER_KNOWN_CACHE);
			fronts.add(CacheFrontName.CUSTOMER_FOCUS_CACHE);
			
			fronts.add(CacheFrontName.COMPANY_PROJECT_CACHE);
			fronts.add(CacheFrontName.USER_ACCOUNT_CACHE);

			Object[] frontObjArrs = fronts.toArray();
			Arrays.sort(frontObjArrs);
			
			for(Object front : frontObjArrs){
				downloadCaches.put(front.toString(), front.toString());
			}
			
		}
		
		int count = 0;
		Object obj = request.getSession().getServletContext().getAttribute(CommonUtils.APPLICATION_KEY);
		if(obj != null){
			Map<HttpSessionBindingListenerKeyBean, UserAccount> map = (Map<HttpSessionBindingListenerKeyBean, UserAccount>) obj;
			count = map.size();
		}
		
		request.setAttribute("applicationUserCount", count);
		
	}
	
}

