package com.jlcc.cctp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jlcc.cctp.model.vo.UserVo;
import com.jlcc.cctp.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 用户操作的Controller
 * 
 * @author zx
 *
 */
@Controller
@Api(tags = "用户操作的接口")
public class UserController {

	@Autowired
	private UserService service;// 注入UserService

	@RequestMapping(value = "/userLogin")
	@ApiOperation("检测用户信息的接口")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "username", value = "用户名", required = true),
		@ApiImplicitParam(name = "password", value = "密码",  required = true) 
	})
	public ModelAndView check(@Valid UserVo user, BindingResult bindingResult, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		if (bindingResult.hasErrors() && bindingResult.getErrorCount() > 2) {
			mav.setViewName("login");
			mav.addObject("msg", "用户名密码不能含有空格！");
		} else {
			boolean result = service.checkUserPassword(user.getUsername(), user.getPassword());// 检验用户名密码
			if (result) {
				mav.setViewName("index");
				mav.addObject("code", 200);
				mav.addObject("username", user.getUsername());
				if (user.getRememberMe()) { // true表示用户勾选记住密码
					String loginInfo = user.getUsername() + "-" + user.getPassword();
					Cookie userCookie = new Cookie("loginInfo", loginInfo);

					userCookie.setMaxAge(30 * 24 * 60 * 60); // 存活期为一个月 30*24*60*60
					userCookie.setPath("/");
					response.addCookie(userCookie);// 添加cookie
				}
			} else {
				mav.setViewName("login");
				mav.addObject("msg", "用户名或密码错误！");
			}
		}
		return mav;
	}

	@RequestMapping(value = "/userRegister")
	public ModelAndView register(@Valid UserVo user, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mav.addObject("msg", "用户信息输入错误！");
			mav.setViewName("demo_register");
		} else {
			mav.setViewName("demo_login");
		}
		return mav;
	}

}
