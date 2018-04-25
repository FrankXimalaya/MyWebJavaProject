package com.frank.controller;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.frank.impl.Itest;

public abstract class AbstractTest implements Itest{
	
	public abstract void abstractMethod();
	
	@Override
	public void test() {
		System.out.println("测试环境开始运行---------------");
	}
	
	
	@Primary
	@Service
	private static class AbstractTestImpl extends AbstractTest{

		public AbstractTestImpl() {
			
			System.out.println("spring 开始");
		}
		

		@Override
		public void abstractMethod() {
			
			
			
		}
		
		
		
		
	}
	
	

}
