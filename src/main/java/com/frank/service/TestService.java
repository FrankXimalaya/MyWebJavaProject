package com.frank.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

import com.frank.impl.Itest;

@Service
public class TestService implements Itest,BeanFactoryAware{
	
	
	private BeanFactory beanFactory;
	
	

	@Override
	public void test() {
		System.out.println("测试");
		
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
	
		this.beanFactory = beanFactory;
		
	}

}
