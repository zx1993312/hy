package com.jlcc.cctp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SpirngSecurity配置
 * 
 * @author zx
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**")// 登录的主页面
				.antMatchers("/js/**")// 静态资源js
				.antMatchers("/img/**")// 静态资源img
				.antMatchers("/css/**")// 静态资源css
				.antMatchers("/movie/**");// 静态资源movie
	}

}
