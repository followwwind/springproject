package com.wind.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@RequestMapping(value = "/getJson", method = RequestMethod.POST)
	@ResponseBody
	public String getJson(HttpServletRequest request){
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		JSONObject result = new JSONObject();
		result.put("str", "str");
		result.put("name", name);
		result.put("age", age);
		result.put("array", new int[]{1, 2, 3});
		return result.toString();
	}
	
}
