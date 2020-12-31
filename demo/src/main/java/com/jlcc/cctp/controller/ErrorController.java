package com.jlcc.cctp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Controller
@Api(tags = "跳转错误页面接口")
@RequestMapping("/error")
public class ErrorController {

	@RequestMapping("/goErr")
	public String goError() {
		return "demo_error";
	}

}
