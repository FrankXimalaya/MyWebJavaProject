package com.frank.service;

import org.springframework.stereotype.Service;

import com.frank.impl.Itest;

@Service
public class TestService implements Itest{
	
	
	
	

	@Override
	public void test() {
		System.out.println("测试");
		
	}

	
	
	
	
	
}
