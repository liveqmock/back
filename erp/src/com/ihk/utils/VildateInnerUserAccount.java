package com.ihk.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

import com.ihk.constanttype.EnumOperLogType;
import com.ihk.utils.log.OperLogUtils;

/**
 * 判断内网账号是否正确
 * @author dtc
 * 2012-9-29
 */
public class VildateInnerUserAccount {
	String URL_1 = "http://10.10.3.151:8081/mail/principal.do?s=";
	String URL_2 = "http://10.10.3.151:8081/mail/principal.do?s=";
	
	/**
	 * @param type = URL_1   "http://test.hope733.com:6080/mail/principal.do
	 * 
	 * @param type = URL_2   "http://m.hope733.com/mail/principal.do
	 * */
	public boolean valiPwdForBandAccount(String userName ,String userPwd , String type, HttpServletRequest request){
		if(userName == null || userName.trim().equals("")){
			return false;
		}
		if(userPwd == null || userPwd.trim().equals("")){
			return false;
		}
		String urlStr = "";
		if(type.equals("URL_1")){
			urlStr = URL_1 + userName + "|" + userPwd;  
		}else if(type.equals("URL_2")){
			urlStr = URL_2 + userName + "|" + userPwd;  
		}else{
			return false;
		}
		
        URL url;
        try {
            url = new URL(urlStr);
            URLConnection URLconnection = url.openConnection();  
            HttpURLConnection httpConnection = (HttpURLConnection)URLconnection;  
            int responseCode = httpConnection.getResponseCode();  
            if (responseCode == HttpURLConnection.HTTP_OK) {  
                InputStream urlStream = httpConnection.getInputStream();  
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlStream));  
                String sCurrentLine = "";  
                String sTotalString = "";  
                while ((sCurrentLine = bufferedReader.readLine()) != null) {  
                    sTotalString += sCurrentLine;  
                }
               if (sTotalString.equals("result:0")) {
            	   return true;
               } else if(sTotalString.equals("result:-1")) {
            	   return false;
                }  
            }else{
                return false;
             }
        } catch (Exception e) {
            e.printStackTrace();
            
            OperLogUtils.addLoginLog(SessionUser.getSessionUser(), "", EnumOperLogType.INNER_REQUEST_ERR, request);
            
            return false;
        }
		return false;
	}
}
