package com.txt.spring.di.test;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.txt.spring.di.consumer.MyApplication;
import com.txt.spring.di.services.MessageService;

@Configuration
@ComponentScan(value="com.txt.spring.di.consumer")
public class MyApplicationTest {

	private AnnotationConfigApplicationContext context = null;

	@Bean
	public MessageService getMessageService() {
		return new MessageService(){

			public boolean sendMessage(String msg, String rec) {
				System.out.println("Mock Service");
				return true;
			}
		};
	}

	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(MyApplicationTest.class);
	}

	@After
	public void tearDown() throws Exception {
		context.close();
		System.out.println("Closed AnnotationConfigApplicationContext");
	}

	@Test
	public void test() {
		MyApplication app = context.getBean(MyApplication.class);
		Assert.assertTrue(app.processMessage("Hi Smitn", "smith@abc.com"));
		System.out.println("test01");
	}

}

