package com.ihk.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts2.ServletActionContext;

import com.ihk.constanttype.ContCacheAndCode;
import com.ihk.utils.common.log.BaseLogger;

/**
 * 缓存的静态类
 * 使用MyCacheTemplate.java对该类进行使用
 * @author dtc
 * 2012-9-3
 */
public class CacheUtils {
	
	private static final MemoryStoreEvictionPolicy memoryStoreEvictionPolicy = MemoryStoreEvictionPolicy.LRU;
	
	/**
	 * 清理缓存(主要是针对客户的,要清除对应的列表缓存)
	 * @param cacheName
	 * @param key
	 */
	public static void removeCache(String cacheName,Object key){		
		//Cache cache= CacheManager.getInstance().getCache(cacheName); //这样可能会出现空指针
		/*Cache cache = getCacheByName(cacheName); //
	    if(cache.get(key)!=null){
	    	cache.remove(key);
	    }*/
	    
	    removeCacheByCacheNameAndKey(cacheName, key.toString());
	    
	    //清除列表的缓存 
	    String cacheListName = cacheName.replace(".one",".list");
		Cache cacheList = CacheManager.getInstance().getCache(cacheListName);
		if(cacheList!=null){
			cacheList.removeAll();
		}
	}
	
	
	/**
	 * 清理所有缓存
	 */
	public static void removeAllCache(){
		
		BaseLogger.debug(CacheUtils.class, "清空所有的缓存");
		
		CacheManager.getInstance().removalAll();
	}
	
	
	/**
	 * 获取CacheManager,其底层实现利用了单例模式
	 * @return
	 */
	public static CacheManager getCacheManager(){
		return CacheManager.getInstance();
	}
	
	/**
	 * 根据cacheName获取一个默认的cache,没有RegisteredEventListeners
	 * @param cacheName
	 * @return
	 */
	public static Cache initCache(String cacheName){
		
		Cache cache = new Cache(cacheName, 1000000, memoryStoreEvictionPolicy, 
				true, null, false, 2880, 
				1440, false, 
				120, null
		);
		
		return cache;
	}
	
	/**
	 * isAddForNot为false时,可能返回null
	 * @param cacheName
	 * @param isAddIfNot,如果没有对应的cache是否增加新的
	 * @return
	 */
	public static Cache getCacheByName(String cacheName, boolean isAddIfNot){
		
		CacheManager cacheManager = getCacheManager();
		Cache cache = cacheManager.getCache(cacheName);		
		//Cache cache = (Cache) getCacheManager().getEhcache(cacheName);

		//判断该cache是否存在
		boolean isExists = cacheManager.cacheExists(cacheName);
		
		if(isExists){
			
			if(isAddIfNot){
				
				//表示配置文件没有该Cache的配置(等于null并不代表不存在,)
				if(cache == null){
					
					cache = initCache(cacheName);
					
					cacheManager.removeCache(cacheName); //如果存在就先删了再增加
					//cacheManager.addCache(cache);
					cacheManager.addCacheIfAbsent(cache); //不严格判断是否存在,即如果存在对应的cache增加也不会报错
					
				}
			}
			
		}else{
			
			if(isAddIfNot){
				
				cache = initCache(cacheName);
				
				//cacheManager.addCache(cache);
				cacheManager.addCacheIfAbsent(cache);
			}
			
		}
		
		/*if(isAddIfNot){
			//表示配置文件没有该Cache的配置(等于null并不代表不存在,)
			
			if(cache == null){
				
				//该方法为配置文件中的配置
				cache = new Cache(cacheName, 10000, memoryStoreEvictionPolicy, 
						false, null, false, 2880, 
						1440, false, 
						120, 
						new RegisteredEventListeners(cache)
				);
				
				//该方法为源码中的默认方法
				*//**
				 public Cache(String name, int maxElementsInMemory, MemoryStoreEvictionPolicy memoryStoreEvictionPolicy,
		                 boolean overflowToDisk, String diskStorePath, boolean eternal, long timeToLiveSeconds,
		                 long timeToIdleSeconds, boolean diskPersistent, long diskExpiryThreadIntervalSeconds,
		                 RegisteredEventListeners registeredEventListeners, BootstrapCacheLoader bootstrapCacheLoader,
		                 int maxElementsOnDisk, int diskSpoolBufferSizeMB)
		        *//*
				//cache = new Cache(cacheName, 10000, memoryStoreEvictionPolicy, true, null, false, 120, 120,
						//false, 120, null, null, 10000, 0);
				
				cacheManager.addCache(cache);
				
			}
		}*/
		
		return cache;
		
	}
	
	/**
	 * 根据cacheName获取Cache,默认不返回null,如果在配置文件没有,就手工new一个默认配置的并添加到CacheManager中
	 * @param cacheName
	 * @return
	 */
	public static Cache getCacheByName(String cacheName){
		
		return getCacheByName(cacheName, true);
	}
	
	/**
	 * 获取所有的cacheName,并进行排序
	 * @return
	 */
	public static String[] getAllCacheName(){
		
		String[] names = getCacheManager().getCacheNames();
		
		Arrays.sort(names);
		
		return names;
		
	}
	
	/**
	 * 新建永久cache
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	private static void addCacheByNameForEternal(String cacheName, String key, Object value) {
		
		CacheManager cacheManager = getCacheManager();
		Cache cache = cacheManager.getCache(cacheName);
		
		if(cache == null){
			
			/*cache = new Cache(cacheName, 10000, memoryStoreEvictionPolicy, 
					false, null, false, 2880, 
					1440, false, 
					120, new RegisteredEventListeners(cache));
			*/
			
			CacheConfiguration config = new CacheConfiguration();
			config.setEternal(true);
			config.setName(cacheName);
			config.setMemoryStoreEvictionPolicyFromObject(memoryStoreEvictionPolicy);
			config.setMaxElementsInMemory(40000);
			config.setDiskExpiryThreadIntervalSeconds(120);
			config.setOverflowToDisk(true);
			
			cache = new Cache(config);
			
			cacheManager.addCache(cache);
		}
		
		Element element = new Element(key, value);

		cache.getCacheConfiguration().setEternal(true); //如果已经存在也要把对应的cache设置eternal为true,
		cache.put(element);
		
	}
	
	
	/**
	 * 把一个Element放入名为cacheName的Cache中
	 * @param cacheName
	 * @param element
	 */
	public static void put(String cacheName, Element element){
		
		Cache cache = getCacheByName(cacheName);
		
		cache.put(element);
			
	}
	
	/**
	 * 根据key和value组成一个Element,然后放入名为cacheName的Cache中
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public static void put(String cacheName, String key, Object value){
		
		//BaseLogger.debug(CacheUtils.class, "增加缓存: " + cacheName + "-->" + key);
		
		Element element = new Element(key, value);
		
		put(cacheName, element);
		
	}
	
	/**
	 * 根据key和value组成一个Element,然后放入名为cacheName的Cache中,且设置改Cache为eternal(永久),timeout设置失效
	 * @param cacheName
	 * @param key
	 * @param value
	 * @param eternal
	 */
	public static void put(String cacheName, String key, Object value, boolean eternal){
		
		if(eternal){
			
			addCacheByNameForEternal(cacheName, key, value);
			//BaseLogger.debug(CacheUtils.class, "增加永久缓存: " + cacheName + "-->" + key);
		}else{
			
			put(cacheName, key, value);
		}
	}
	
	/**
	 * 增加一个永久缓存
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public static void add(String cacheName, String key, Object value){
		
		put(cacheName, key, value, true);
	}
	
	/**
	 * 删除某个cache
	 * @param cacheName
	 */
	public static void removeCacheByCacheName(String cacheName){
		
		BaseLogger.debug(CacheUtils.class, "清空缓存: " + cacheName);
		getCacheManager().removeCache(cacheName);
	}
	
	/**
	 * 删除所有以likeCacheName开头的cache
	 * @param likeCacheName
	 */
	public static void removeCacheByLikeCacheName(String likeCacheName){
		CacheManager manager = getCacheManager();
		String[] names = manager.getCacheNames();
		
		for(String name : names){
			if(name.startsWith(likeCacheName)){
				manager.removeCache(name);				
				BaseLogger.debug(CacheUtils.class, "清空缓存: " + name);
			}
		}
		
	}
	
	/**
	 * 删除某个cache中的一个key
	 * @param cacheName
	 * @param key
	 */
	public static void removeCacheByCacheNameAndKey(String cacheName, String key){
		getCacheByName(cacheName).remove(key);
	}
	
	/**
	 * 删除某个cache中的所有包含likeKey的key
	 * @param cacheName
	 * @param likeKey
	 */
	@SuppressWarnings("unchecked")
	public static void removeCacheByCacheNameAndLikeKey(String cacheName, String likeKey){
		Cache cache = getCacheByName(cacheName);
		List<String> keys = cache.getKeys();
		
		for(String key : keys){
			if(key.contains(likeKey)){
				cache.remove(key);
			}
		}
		
	}
	
	/**
	 * 根据cacheName来更新某个key的值,如果没有就新增
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public static void updateCacheByCacheNameAndKey(String cacheName, String key, Object value){
		
		put(cacheName, key, value);
	}
	
	/**
	 * 根据cacheName, key 获取其Element
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public static Element getElementByCacheNameAndKey(String cacheName, String key){
		
		return getCacheByName(cacheName).get(key);
	}
	
	/**
	 * 根据cacheName, key 获取其值<br/>
	 * action与service不要直接调用,请使用MyCacheTemplate.java
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public static Object getValueByCacheNameAndKey(String cacheName, String key){
		
		Element element = getElementByCacheNameAndKey(cacheName, key);
		
		if(element != null){
			
			//BaseLogger.debug(CacheUtils.class, "读取缓存: " + cacheName + "-->" + key);
			return element.getValue();
		}else{
			
			return null;
		}
	}
	
	/**
	 * 获取所有的cache
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, List<Element>> getAllCacheAndElement(){
		
		Map<String, List<Element>> map = new HashMap<String, List<Element>>();
		
		String[] allCacheNames = getAllCacheName();
		
		for(String cacheName : allCacheNames){
			Cache cache = getCacheByName(cacheName, false);
			if(cache != null){
				
				List<Element> elementList = new ArrayList<Element>();
				List<Object> keys = cache.getKeys();
				for(Object key : keys){
					
					Element element = cache.get(key);
					elementList.add(element);
				}
				
				map.put(cacheName, elementList);
			}
			
		}
		
		return map;
	}
	
	/**
	 * 获取cache的key
	 * 利用方法参数及下面的参数组合成字符串来确定一个key,为了通用性不用MethodInvocation invocation做参数
	 * @param args
	 * @return
	 * @throws RuntimeException
	 */
	public static String getCacheKey(String args) throws RuntimeException{
		
		String userId = SessionUser.getUserIdStr();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String key = args + "&userId=" + userId + "&" + getUriAndQuery(request);
		return Md5Security.encString(key);
		
	}
	
	/**
	 * 根据HttpServletRequest获取cache的key
	 * @param request
	 * @return
	 * @throws RuntimeException
	 */
	public static String getCacheKey(HttpServletRequest request) throws RuntimeException{
		
		return getCacheKey(request, false);
	}
	
	/**
	 * 根据HttpServletRequest和isUser(是否把用户的id加进来)获取cache的key
	 * @param request
	 * @param isUser
	 * @return
	 * @throws RuntimeException
	 */
	public static String getCacheKey(HttpServletRequest request, boolean isUser) throws RuntimeException{
		
		if(isUser){
			
			String userId = SessionUser.getUserIdStr();
			String key = "userId=" + userId + "&" + getUriAndQuery(request);
			
			return Md5Security.encString(key);
		}else{
			
			String key = getUriAndQuery(request);
			
			return Md5Security.encString(key);
		}
		
	}
	
	/**
	 * 根据HttpServletRequest获取uri和query组成的String
	 * @param request
	 * @return
	 * @throws RuntimeException
	 */
	@SuppressWarnings("unchecked")
	private static String getUriAndQuery(HttpServletRequest request) throws RuntimeException{
		
		String method = request.getMethod();
		
		String uri = request.getRequestURI();  //端口后到.action,(如:/crm/sale_hengda/search/all.action)
		String query = "";
		
		if("get".equalsIgnoreCase(method)){
			
			//query = request.getQueryString(); //?后的所有内容,(如:saleCond.monitorDate=2011-12-14&saleCond.companyId=&saleCond.projectId=)
			query = delQueryArg(request, ContCacheAndCode.NO_CACHE_SIGN);
		}else{
			//POST
			Map<String, String[]> map = request.getParameterMap();
			query = parMapToQueryString(map);
		}
		
		return "uri=" + uri + "&query=" + query;
	}
	
	/**
	 * 删除请求url中的ts参数(ts是为了避免代理服务器的缓存)
	 * @param request
	 * @param queryArg
	 * @return
	 */
	private static String delQueryArg(HttpServletRequest request, String queryArg){
		
		String query = request.getQueryString();
		
		String link = "&";
		
		if(query == null || "".equals(query))
			return "";
		
		String delArg = request.getParameter(ContCacheAndCode.NO_CACHE_SIGN);
		if(delArg == null)
			return query;
		
		int tsIndex = query.indexOf(queryArg);
		int tsEnd = 0;
		
		if(tsIndex != -1){
			//包含ts参数,
			//如:saleCond.monitorDate=2011-12-14&saleCond.companyId=&saleCond.projectId=1&ts=xxxxxx&other=
			//或:saleCond.monitorDate=2011-12-14&saleCond.companyId=&saleCond.projectId=1&ts=xxxxxx
			//或:ts=xxxxxx&other=
			//或:ts=xxxxxx(此种情况返回空字符串)
			String tmpQuery = query.substring(tsIndex);
			int _index = tmpQuery.indexOf(link);
			if(_index == -1){
				
				tsEnd = query.length();
			}else{
				
				tsEnd = tsIndex + _index + 1;
			}
			
		}
		
		String delQuery = query.substring(tsIndex, tsEnd);
		query = query.replace(delQuery, "");
		if(query.endsWith(link)){
			query = query.substring(0, query.length() - 1);
		}
		
		return query;
	}
	
	/**
	 * 转换object数组成String
	 * @param arrs
	 * @return
	 */
	public static String objArrToString(Object[] arrs){
		//参数arrs为invocation.getArguments()的值,当为bean是就返回""(因为bean中没有重写toString()方法,所以只能返回"")
		String ret = "";
		
		for(Object arr : arrs){
			if(arr instanceof String || arr instanceof Number){//可以跟最后的else合并,
				
				ret += arr.toString() + "_";
			}else if(arr instanceof SearchCond){
				
				ret += condToString((SearchCond) arr);
			}else if(arr!=null){
				
				ret += arr.toString() + "_";
			}
			
		}
		
		return ret.length() > 0 ? ret.substring(0, ret.length()-1) : ret;
	}
	
	/**
	 * 把cond转成String,分页使用等
	 * @param cond
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String condToString(SearchCond cond){
		
		StringBuffer sb = new StringBuffer(); 
		
		Class clazz = cond.getClass();
		Field[] ifFs = clazz.getFields(); //接口的字段
		Field[] implFs = clazz.getDeclaredFields();  //实现类的字段
		
		List<Field> fsList = new ArrayList<Field>();
		for(Field fs : ifFs){
			fsList.add(fs);
		}
		for(Field fs : implFs){
			fsList.add(fs);
		}
		
		//还要考虑没有set,get方法字段值的获取
		for(Field f : fsList){
			
			String name = f.getName();
			try {
				
				if("serialVersionUID".equalsIgnoreCase(name))
					continue;
				
				sb.append(name).append("=");
				
				//为了效率上的考虑,参照BeanUtilsBean的getArrayProperty来写下面的代码
				Object objValue = PropertyUtils.getProperty(cond, name);
				
				if(objValue != null){
					
					//也可以实现org.apache.commons.beanutils.Converter接口自定义类型之间的转化,而不只是获取其toString()
					if (objValue instanceof Collection) {
						 List<String> values = new ArrayList<String>();
						 Iterator<String> items = ((Collection) objValue).iterator();
						 while (items.hasNext()) {
							 Object item = items.next();
							 if (item == null) {
								 values.add("null");
							 } else {
								 values.add(item.toString());
							 }
						 }
						 
						 sb.append(objArrToString(values.toArray()));
						 
					}else if (objValue.getClass().isArray()) {
			            int n = Array.getLength(objValue);
			            String[] results = new String[n];
			            for (int i = 0; i < n; i++) {
			                Object item = Array.get(objValue, i);
			                if (item == null) {
			                    results[i] = "null";
			                } else {
			                    results[i] = item.toString();
			                }
			            }
			            
			            sb.append(objArrToString(results));
					
					}else {
						
						sb.append(objValue.toString());
			        }
					
				}else{
					
					sb.append("null");
				}
				
				
				/*
				 * 之前的代码利用BeanUtils去获取值,效率比较低
				 * 
				BeanUtilsBean bub = new BeanUtilsBean();
				
				String[] s = bub.getArrayProperty(cond, name);
				
				if(s != null){
					
					sb.append(objArrToString(s));
				}*/
				
				sb.append("&");
				
			} catch (Exception e) {
				
				try {
					
					Field fi = clazz.getDeclaredField(name); //获取该字段,并设置为可访问
					boolean isCanAccess = fi.isAccessible(); 
					if(!isCanAccess){
						fi.setAccessible(true);
					}
					
					Object objValue = fi.get(cond); 
					sb.append(objValue);
					
				} catch (Exception en){
					//en.printStackTrace();
					
					//如果为接口中的字段会抛出异常而跳动这里
					try {
						Field fi = clazz.getField(name);
						boolean isCanAccess = fi.isAccessible(); 
						if(!isCanAccess){
							fi.setAccessible(true);
						}
						
						Object objValue = fi.get(cond); 
						sb.append(objValue);
						
					} catch (Exception en2){
						//en2.printStackTrace();
						//异常是会因为缓存读不到值,用一个uuid去避免
						String uuid = UUID.randomUUID().toString();
						sb.append(uuid);
					}
					
				}
				
				//e.printStackTrace();
				sb.append("&");
			}
				
		}
	
		String ret = sb.toString();
		return ret.length() > 0 ? ret.substring(0, ret.length()-1) : ret;
	}
	
	/**
	 * 把post中的请求参数拼接成类似get的请求url
	 * @param map
	 * @return
	 */
	public static String parMapToQueryString(Map<String, String[]> map){
		
		StringBuffer sb = new StringBuffer();
		
		Set<String> keys = map.keySet();
		for(String key : keys){
			
			if(ContCacheAndCode.NO_CACHE_SIGN.equals(key))
				continue;
			
			sb.append(key).append("=").append(objArrToString(map.get(key))).append("&");
		}
		
		String ret = sb.toString();
		return ret.length() > 0 ? ret.substring(0, ret.length()-1) : ret;
	}
	
	/**
	 * 
	 * 一些services的方法中不能用interceptor去缓存,可以通过该方法对其mapper进行缓存,(CodeTypeServices.java)
	 * @param mapper
	 * @param methodName
	 * @param args
	 * @param cacheFrontName
	 * @return
	 * @throws Exception
	 */
	public static Object cacheMapper(Object mapper, String methodName, Object[] args, String cacheFrontName) throws Exception{
		
		String cacheName = cacheFrontName + methodName;
		String key = getCacheKey(objArrToString(args));
		Object obj = getValueByCacheNameAndKey(cacheName, key);
		
		if(obj == null){
			
			Class<?>[] argsClass = new Class<?>[args.length];
			for(int i=0; i<args.length; i++){
				argsClass[i] = args[i].getClass();
			}
			
			Method method = mapper.getClass().getMethod(methodName, argsClass);
			Object value = method.invoke(mapper, args);
			
			CacheUtils.put(cacheName, key, value); 
			
			return value;
			
		}else{
			
			return obj;
		}
		
	}
	/**
	 * 地址栏的时间戳,避免浏览器或者代理服务器缓存
	 * @return
	 */
	public static String getUrlTimeStamp(){
		return SessionUser.getUserIdStr()+"_"+DateTimeUtils.getNow().toString("yyDHHmmssSSS");
	}
	
}

