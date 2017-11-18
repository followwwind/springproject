package com.wind.controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wind
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@RequestMapping(value = "/getJson", method = RequestMethod.GET)
	@ResponseBody
	public String getJson(HttpServletRequest request){
		JSONObject result = new JSONObject();
		result.put("str", "str");
		result.put("name", "wind");
		result.put("age", 18);
		result.put("array", new int[]{1, 2, 3});
		return result.toString();
	}
	
}
