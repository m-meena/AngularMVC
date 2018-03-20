package com.niit.chat.chatterboxback.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.chat");
		context.refresh();
	}
	
	@Test
	public void test()
	{
		System.out.println("tested");
	}
}
