package junit_test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.PropertyUtils;

import com.ihk.constanttype.EnumChangeType;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.utils.DateTimeUtils;

public class JunitTest {

	private static void test(EnumChangeType ct) {
		System.out.println(ct);
	}

	private static void t() {
		ConfirmBook book = new ConfirmBook();
		try {
			PropertyUtils.setProperty(book, "id", 10);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(PropertyUtils.getProperty(book, "id"));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void m() {
		Date date = new Date();
		System.out.println(date.toLocaleString());
	}

	private static void n() {
		List<Integer> list1 = new ArrayList<Integer>();// 前
		List<Integer> list2 = new ArrayList<Integer>();// 后

		List<Integer> list3 = new ArrayList<Integer>();// 中间

		list1.add(1);
		list1.add(2);

		list2.add(2);
		list2.add(3);

		list3.addAll(list2);

		list3.retainAll(list1);// 交集

		list2.removeAll(list3);// 追加

		list1.removeAll(list3);// 删除

		System.out.println(list3.toString());

		System.out.println(list2.toString());

		System.out.println(list1.toString());
	}

	public static void Config() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress().toString(); // 获取本机ip
			String hostName = addr.getHostName().toString(); // 获取本机计算机名称
			System.out.println("本机IP：" + ip + "\n本机名称:" + hostName);
			Properties props = System.getProperties();
			System.out.println("操作系统的名称：" + props.getProperty("os.name"));
			System.out.println("操作系统的版本：" + props.getProperty("os.version"));
			System.out.println("用户名" + props.getProperty("user.name"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static  void  getCaller(){   
        StackTraceElement stack[] = Thread.currentThread().getStackTrace();  
        for (StackTraceElement ste:stack){   
//         if((ste.getClassName().indexOf("T1"))!=-1){
             System.out.println("called by "+ste.getClassName()+"."+ste.getMethodName()+"/"+ste.getFileName());
//         }
        }   
      }  
	
	public static void main(String[] args) throws SocketException,
			UnknownHostException, SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		// NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress
		// .getByAddress(new byte[]{(byte)172,(byte)16,(byte)6,(byte)1}));
		// byte[] macs = ni.getHardwareAddress();
		// String mac = "";
		// StringBuilder sb = new StringBuilder();
		// for (int i = 0; i < macs.length; i++) {
		// mac = Integer.toHexString(macs[i] & 0xFF);
		//
		// if (mac.length() == 1) {
		// mac = '0' + mac;
		// }
		//
		// sb.append(mac + "-");
		// }
		// mac = sb.toString();
		// mac = mac.substring(0, mac.length()-1);
		// System.out.println(mac);
		//
		// Method method = JunitTest.class.getMethod("Config", null);
		// method.invoke(JunitTest.class, null);
		//
		// if(null instanceof String){
		// System.out.println(true);
		// }
//		getCaller();
		
		System.out.println (DateTimeUtils.getDate("2012-10-01 13:22:22", "yyyy-MM-dd hh:mm:ss"));
	}
	
	
}
