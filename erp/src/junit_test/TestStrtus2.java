package junit_test;

import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

import com.ihk.customer.action.GuangZhouSearchAction;
import com.opensymphony.xwork2.ActionProxy;

public class TestStrtus2 extends StrutsTestCase {
	@Test
	public void testExecute() throws Exception {
		ActionProxy proxy = null;
		GuangZhouSearchAction test = null;
//		request.setParameter("param", "test...");
//		proxy = getActionProxy("/test.action");
//		test = (GuangZhouSearchAction) proxy.getAction();
	}
}
