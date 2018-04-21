package com.hbjc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hbjc.domain.Users;
import com.hbjc.service.UsersService;

@Controller
@RequestMapping(value = "/regist")
public class Controllers {
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private UsersService service;

	@RequestMapping(value="/addUsers",method=RequestMethod.POST)
	public ModelAndView  save(Model model,Users users){
		int indicator = service.saveUsers(users);
		ModelAndView mv ;
        if(indicator > 0 )
        {
	         mv= new ModelAndView("success");
        }
        else
        {
             mv = new ModelAndView("error");
        }
		logger.info("addUsers:"+users.getUserName());
		return mv;
	}
}
