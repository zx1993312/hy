package com.jlcc.cctp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 控制页面跳转的Controller
 * 
 * @author zx
 *
 */
@Controller
@Api(tags = "跳转页面接口")
@RequestMapping("/")
public class SkipController {

	/**
	 * 进入登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	@ApiOperation("进入登录页面的接口")
	public String demoLogin() {
		return "login";
	}

	/**
	 * 进入注册页面
	 * 
	 * @return
	 */
	@RequestMapping("/goRegister")
	@ApiOperation("进入注册页面的接口")
	public String goRegister() {
		return "demo_register";
	}

	/**
	 * 进入密码找回页面
	 * 
	 * @return
	 */
	@RequestMapping("/findPass")
	@ApiOperation("进入密码找回页面的接口")
	public String findPass() {
		return "demo_pass";
	}

	@RequestMapping("/userHome")
	public String goUserHome() {
		return "demo_userhome";
	}

}
