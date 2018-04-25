package com.frank.processor;

import java.lang.reflect.Proxy;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import com.frank.impl.Itest;
import com.frank.invocationHandler.LogHandler;
import com.frank.service.TestService;

@Service
public class PostProcessor implements BeanPostProcessor{

	
	
	
	@PostConstruct
	public void init(){
		
		System.out.println("开始进行一些初始化的工作----------------------------------");
		
		
	}
	
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		if ("testService".equals(beanName)) {// 过滤掉bean实例ID为narCodeService
			System.out.println("后置处理器处理bean=【" + beanName + "】开始");
			TestService service = (TestService)bean;
			Itest itest = (Itest)Proxy.newProxyInstance(bean.getClass().getClassLoader(), service.getClass().getInterfaces(), new LogHandler(service));
			itest.test();
			return bean;
		}else{
			return bean;	
		}
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		if ("testService".equals(beanName)) {// 过滤掉bean实例ID为narCodeService
			System.out.println("后置处理器处理bean=【" + beanName + "】完毕");
			return bean;
		}else{
			return bean;	
		}
	}

}
