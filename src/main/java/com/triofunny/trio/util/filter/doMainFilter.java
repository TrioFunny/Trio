package com.triofunny.trio.util.filter;

import org.springframework.core.annotation.Order;

import javax.naming.Name;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
//重点
@WebFilter(filterName = "MainFinter",urlPatterns = "/*")
public class doMainFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		arg2.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
