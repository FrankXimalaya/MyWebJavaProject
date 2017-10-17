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
public class TransactinoUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRES_NEW)
	public  void testSelectAllUsers() throws RuntimeException{
		List<User> list = userMapper.selectAllUsers();
		System.out.println("list列表中元素个数为"+list.size());
		
	}
}
