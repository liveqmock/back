package com.ihk.utils;

import javax.servlet.http.HttpServletRequest;

import com.ihk.user.data.pojo.UserAccount;
import com.opensymphony.xwork2.ActionContext;

/**
 * 登陆用户session帮助类
 * @author dtc
 * 2012-9-29
 */
public class SessionUser {   
  
//    @SuppressWarnings("unchecked")  
//    static ThreadLocal sessionUser = new ThreadLocal();  
      
//    @SuppressWarnings("unchecked")  
//    public static void setSessionUser(UserAccount userAccount) {  
//        sessionUser.set(userAccount);  
//    }  
      
    public static UserAccount getSessionUser(){  
//    	ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
    	HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
    	return (UserAccount)request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
//        return (UserAccount )sessionUser.get();  
    }  
      
    public static int getUserId(){  
    	UserAccount sessionUser = getSessionUser();
    	if(sessionUser==null){
    		return 0;
    	}
        return sessionUser.getId();  
    } 
    
    public static String getUserIdStr(){  
    	UserAccount getUser = getSessionUser();
    	if(getUser != null){
    		
    		return String.valueOf(getUser.getId());
    	}else{
    		
    		return ""; //定时器中会出现null的情况
    	}
          
    }
      
    public static String getUserName(){  
        return getSessionUser().getUserName();  
    }  
    
    @Deprecated
    public static boolean isAdmin(){  
        return getSessionUser().isAdmin();  
    } 
    
    public static boolean isLogined(){  
    		if( getUserId()>0){
    			return true;
    		}
    		return false;
    }
    
    /**
     * 在可以自选择公司项目页面的地方,使用PropertyTreeUtils.java的getLeftTreeProjectIdSession()来代替该方法
     * 旧的方法不用变
     * @return
     */
    public static int getProjectId(){  
        return getSessionUser().getProjectId();  
    } 
    
    public static int getCompanyId(){  
        return getSessionUser().getCompanyId();  
    } 
}  