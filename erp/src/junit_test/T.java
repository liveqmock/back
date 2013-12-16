package junit_test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class T {

	
	
	public static void t(String ...a){
		System.out.println(a);
		System.out.println("public static void t(String ...a)");
	}
	public static void t(String a){
		System.out.println(a);
		System.out.println("public static void t(String a)");
	}
	public static void main(String[] args) throws Exception {
		t("a");
		throw new Exception("sss");
	}
	
	public void e(List<Integer> l){
		
	}
	public void e(ArrayList<?> l){
			
	}
	
	@Test
	public void test1(){
		List<String> list = new ArrayList<String>();
		list.add("a");
		
		list.remove("a");
		
		System.out.println(list.size());
	}
	
	
}


