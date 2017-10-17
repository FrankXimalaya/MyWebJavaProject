package com.frank.mapper;

import java.util.List;

import com.frank.bean.User;


public interface UserMapper {

    public void insertUser(User user);
    
    public List<User> selectAllUsers();
    
    public void update(User user);

}
