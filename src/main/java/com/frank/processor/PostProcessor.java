package com.frank.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import com.frank.controller.TestController;

@Service
public class PostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		if ("testController".equals(beanName)) {// 过滤掉bean实例ID为narCodeService
			System.out.println("后置处理器处理bean=【" + beanName + "】开始");
			TestController testController = (TestController)bean;
			
			
			
			
			
			return bean;
		}else{
			return bean;	
		}
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		if ("testController".equals(beanName)) {// 过滤掉bean实例ID为narCodeService
			System.out.println("后置处理器处理bean=【" + beanName + "】完毕");
			return bean;
		}else{
			return bean;	
		}
	}

}
