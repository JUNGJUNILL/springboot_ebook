package com.mysite.ssb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello world world world"; 
	}
	
}
