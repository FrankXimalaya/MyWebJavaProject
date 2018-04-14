package com.frank.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frank.mapper.UserMapper;

@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserMapper mapper;
    
   

    @RequestMapping("/firstTest")
    @ResponseBody
    public Map firstTest(){

//        User user = new User();
//        user.setName("frank");
//        mapper.insertUser(user);


        Map map = new HashMap();
        map.put("s","s");

        return map;
    }
    
//    @RequestMapping("/testTransaction")
//    @ResponseBody
//    public Map testTransaction() throws Exception{
//
//
//    	userService.testUnQueryCommit();
//        Map map = new HashMap();
//        map.put("s","s");
//        
//        return map;
//    }
    
    

}
