package com.jlcc.cctp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;

/**
 * 自定义filter处理系统异常
 * 
 * @author zx
 *
 */
@Log4j
@WebFilter(filterName = "responseFilter", urlPatterns = "/*")
public class ResponseFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		try {
			chain.doFilter(req, res);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			req.getRequestDispatcher("/error/goErr").forward(req, res);
		}

	}

}
