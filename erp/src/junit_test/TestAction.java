package junit_test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.struts2.StrutsSpringTestCase;
import org.springframework.test.context.support.GenericXmlContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.ihk.saleunit.action.new_.GuangzhouAppointCustomerEventAction;
import com.opensymphony.xwork2.ActionProxy;

public class TestAction extends StrutsSpringTestCase {
	private ActionProxy proxy;  
	
	@Override  
    public void setUp() throws Exception {  
        super.setUp();  
    }  
    @Override  
    protected void setupBeforeInitDispatcher() throws Exception {  
        GenericXmlContextLoader xmlContextLoader = new GenericXmlContextLoader();  
        applicationContext = xmlContextLoader.loadContext(getContextLocation());  
        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, applicationContext);  
    }  
    public String[] getContextLocation(){  
        URL classUrl = TestAction.class.getResource("");  
        String path = classUrl.getPath();  
        try {  
            path = URLDecoder.decode(path, "UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        path =  path.substring(1 , path.indexOf("WEB-INF"))+ "WEB-INF/classes/";  
        File configPath = new File(path);  
        String[] applicationContexts = configPath.list(new FilenameFilter(){  
            public boolean accept(File dir, String name){  
                if(name.toLowerCase().startsWith("applicationContext".toLowerCase())){  
                    return true;  
                }  
                return false;  
            }                 
        });
        List<String> list =new ArrayList<String>();
        for (int i = 0; i < applicationContexts.length; i++) {
        	if(applicationContexts[i].toLowerCase().startsWith("applicationContext-cache".toLowerCase())){
        		continue;
        	}
			list.add(applicationContexts[i]);
		}
        applicationContexts = list.toArray(new String[]{});
        for(int i=0;i<applicationContexts.length;i++){  
            applicationContexts[i] = "file:"+path +  applicationContexts[i];  
        }  
        return applicationContexts;  
    }  
	
	
	public void testAction() throws Exception{
		proxy = getActionProxy("/saleunit_new/appoint/guangzhou/customerEventExport.action");
		System.out.println(proxy.getAction().getClass().getName());
		GuangzhouAppointCustomerEventAction action = (GuangzhouAppointCustomerEventAction)proxy.getAction();
//		System.out.println(request);
//		action.downLoad();
	}
}
