package com.frank.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frank.bean.User;
import com.frank.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private TransactinoUserService transactinoUserService; 
	
	
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public void testTransactional() throws Exception{
		
	    List<User> users = userMapper.selectAllUsers();
	    System.out.println("查询时的记录数："+users.size());
//	    Thread.sleep(5000);
//	    List<User> users2 = userMapper.selectAllUsers();
//	    System.out.println("第二次查询时的记录数："+users2.size());
	}
	

	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public  void testSelectAllUsers() throws RuntimeException{
		List<User> list = userMapper.selectAllUsers();
		System.out.println("线程"+Thread.currentThread().getName()+"读取到的名字是"+list.get(0).getName());
		
	}
	
	@Transactional
	public void testUnQueryCommit(){
		User user = new User();
		user.setName("测试事务未提交查询");
		userMapper.insertUser(user);
		
		
		transactinoUserService.testSelectAllUsers();
//		System.out.println("外层事务提交");
		
		
	}
	
	
	
}
