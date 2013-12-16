package com.ihk.user.action;



import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.VildateInnerUserAccount;


/**
 * 绑定内网账号
 * */
public class BandAccountAction extends SupperAction{
	private static final long serialVersionUID = -7970166348714302653L;
	@Autowired IUserAccountServices iUserAccountServices;
	private String innerName;  //需要验证的内网账号
	private String innerPwd;   //需要验证的内网密码
	private String userName;   //已经绑定的内网账号
	private String oldInnerName;
	/**
	 * 绑定内网账号界面
	 * 如果已经绑定 显示出来
	 * */
	public String indexBand(){
		String inner = SessionUser.getSessionUser().getInnerUserName();
		this.userName = "";
		if(inner != null && !inner.trim().equals("")){
			this.userName = inner;	
		}
		return "suc";
	}
	
	/**
	 *绑定内网账户
	 *根据传入的 innerName innerPwd 去验证是否通过 通过则保存
	 *然后显示出来
	 * */
	public String band(){
		//判断是否已经被绑定过
		UserAccount tem = this.iUserAccountServices.loginInnerUser(innerName);
		if(tem != null){
			if(tem.getId() == SessionUser.getUserId()){
				addActionMessage("已绑定此内网账号.");
				return indexBand();
			}
			addActionMessage("此内网账号已经被另外的用户绑定,请联系管理员.");
			return indexBand();
		}//end
		
		
		VildateInnerUserAccount vi = new VildateInnerUserAccount();
		if(vi.valiPwdForBandAccount(innerName, innerPwd, "URL_1", request)){
			UserAccount tempUser = SessionUser.getSessionUser();
			tempUser.setInnerUserName(innerName);
			tempUser.setUserPwd("");
			iUserAccountServices.updateUserAccount(tempUser);
			addActionMessage("绑定成功");
			this.userName = innerName;
		}else{
			this.userName = this.oldInnerName;
			addActionMessage("绑定失败(验证失败,可能内网账户密码输入错误)");
		}
		return indexBand();
	}
	
	
	/**
	 * 解除绑定
	 * 
	 * */
	public String removeBand(){
		UserAccount tempUser = SessionUser.getSessionUser();
		tempUser.setInnerUserName(innerName);
		tempUser.setUserPwd("");
		iUserAccountServices.updateUserAccount(tempUser);
		addActionMessage("已解除绑定");
		SessionUser.getSessionUser().setInnerUserName("");
		this.userName = "";
		return indexBand();
	}
	
	
	/**
	 * 验证内网密码
	 * */
//	private boolean valiPwdForBandAccount(String userName ,String userPwd){
//		if(userName == null || userName.trim().equals("")){
//			return false;
//		}
//		if(userPwd == null || userPwd.trim().equals("")){
//			return false;
//		}
//		String urlStr = "http://test.hope733.com:6080/mail/principal.do?s=" + userName + "|" + userPwd;  
//        URL url;
//        try {
//            url = new URL(urlStr);
//            URLConnection URLconnection = url.openConnection();  
//            HttpURLConnection httpConnection = (HttpURLConnection)URLconnection;  
//            int responseCode = httpConnection.getResponseCode();  
//            if (responseCode == HttpURLConnection.HTTP_OK) {  
//                InputStream urlStream = httpConnection.getInputStream();  
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlStream));  
//                String sCurrentLine = "";  
//                String sTotalString = "";  
//                while ((sCurrentLine = bufferedReader.readLine()) != null) {  
//                    sTotalString += sCurrentLine;  
//                }
//               if (sTotalString.equals("result:0")) {
//            	   return true;
//               } else if(sTotalString.equals("result:-1")) {
//            	   return false;
//                }  
//            }else{
//                return false;
//             }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//		return false;
//	}

	
	public String getInnerName() {
		return innerName;
	}

	public void setInnerName(String innerName) {
		this.innerName = innerName;
	}

	public String getInnerPwd() {
		return innerPwd;
	}

	public void setInnerPwd(String innerPwd) {
		this.innerPwd = innerPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOldInnerName() {
		return oldInnerName;
	}

	public void setOldInnerName(String oldInnerName) {
		this.oldInnerName = oldInnerName;
	}

	
	
}
