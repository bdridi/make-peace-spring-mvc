package com.get.revenge.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.get.revenge.dao.RevengeDAO;
import com.get.revenge.entities.Revenge;
import com.get.revenge.services.RevengeService;


//@ContextConfiguration("classpath:mvc-config.xml")
//@RunWith(SpringJUnit4ClassRunner.class)

public class TestServiceRevenge {
	
	public TestServiceRevenge() {
		System.out.println("------------------------------- SPRING UNIT TEST ---------------------");
	}
	
	@Autowired
	private RevengeService revengeService;
	@Autowired
	private RevengeDAO revengeDAO;
	
	//@Test
	public void test_service_revenge() {

		//System.out.println(" *** test_say_hello ***");	
		//assertThat(revengeService.sayHello(), "hello");
		assertEquals(2,revengeService.getAll().size());
	}
	
	//@Test
	public void test_repository_revenge() {
		
		System.out.println(" *** test_repository_revenge ***");	
		assertNotNull(revengeDAO);
	}
	
//	@Test
//	public void test_save_revenge() {
//		
//		
//		revengeService.save(new Revenge("foo","bar","lorem ipsum ..."));
//		assertEquals(3,revengeService.getAll().size());
//	
//			
//	}
	
		//@Test
		public void always_true() {
			
			assertTrue(1>0);
		}
	

}
