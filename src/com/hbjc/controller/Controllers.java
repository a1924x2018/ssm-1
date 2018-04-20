package com.hbjc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hbjc.domain.Users;
import com.hbjc.service.UsersService;

@Controller
@RequestMapping(value="/regist")
public class Controllers {
	private Logger logger = Logger.getLogger(getClass());  
	@Autowired
	private UsersService service;
	public void setService(UsersService service) {  //通过set方法注入属性
		this.service = service;
	}
	
	@RequestMapping(value="/addUsers",method=RequestMethod.POST)
	public String save(Model model,Users users){
		logger.info("addUsers:"+users.getUserName());
		service.saveUsers(users);
		return "success";
	}
	
}
