package org.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/demo")
public class Demo1 {
	@RequestMapping({"/","test1.do"})
	public String test1(HttpServletRequest request){
		String userid=request.getParameter("userID");
		String userPw=request.getParameter("userPw");
		System.err.println(userid+":"+userPw);
		return "hello";
	}
	@RequestMapping(value="test2/{username}",method=RequestMethod.GET)
	public String test2(@PathVariable("username") String userName){
		
		System.err.println(userName);
		return "hello";
	}
	@RequestMapping(value="/test3/{username}",method=RequestMethod.GET)
	public String test3(@PathVariable("username") String userName,
			Map<String, Object> map){
		map.put("username", userName);
		System.err.println(userName);
		return "hello";
	}
	@RequestMapping(value="test4/{username}",method=RequestMethod.GET)
	public String test4(@PathVariable("username") String userName,Model model){
		model.addAttribute(userName);
		model.addAttribute("username", userName);
		System.err.println(userName);
		return "hello";
	}
}
