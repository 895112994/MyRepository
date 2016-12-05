package org.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springmvc.entity.User;


@Controller
@RequestMapping("/user")
public class UserController {
	
	private Map<String,Object> map=new HashMap<String,Object>();
	

	public UserController() {
		map.put("zs", new User("杨振","12333","183","123@163.com"));
		map.put("chy", new User("曹海洋","12343","182","123@163.com"));
		map.put("zhy", new User("张弘扬","12353","181","123@163.com"));
		map.put("lpp", new User("刘萍萍","12363","184","123@163.com"));
	}
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	/**
	 * 查询用户列表
	 */
	@RequestMapping("/userList")
	public String getUser(Model model){
		model.addAttribute("userList", map);
		System.err.println("getUser------------");
		return "user/list";
	}
	/**
	 * 查询用户信息
	 */
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String viewUser(@PathVariable("username") String userName,
			Model model){
		model.addAttribute("user",map.get(userName));
		System.err.println("viewUser-------------------");
		return "user/view";
	}
	
}
