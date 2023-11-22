package ecommerce.shoper.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Filters implements Filter{
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Interceptor");
		HttpSession session = ((HttpServletRequest) req).getSession();
		
		if (session.getAttribute("user")!= null) {
			chain.doFilter(req, res);
			
		} else {
			((HttpServletResponse) res).sendRedirect("Error.jsp");
		}
		
		
		
	}
}
