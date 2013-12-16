package com.ihk.junit;

import org.junit.BeforeClass;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SupperJunit {
	
	protected static FileSystemXmlApplicationContext factory;
	
	@BeforeClass
	public static void init(){
		
		factory = new FileSystemXmlApplicationContext("src/Junit-applicationContext.xml");
		
	}

}
