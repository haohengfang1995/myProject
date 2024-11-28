package com.example.demo.filter;

import jakarta.servlet.http.HttpFilter;


//@WebFilter(urlPatterns = {"/user","/users"})
public class LoginFilter extends HttpFilter{
//
//	@Override
//	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//
//		//編碼
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/plain;charset=utf-8");
//		
//		System.out.println("攔截過濾 URL:" + request.getRequestURL());
//		
//		//判斷是否有憑證
//		HttpSession session = request.getSession();
//		if(session.getAttribute("userCert") == null) {
//			response.getWriter().println("請先登入");
//			//記住這次請求的URL
//			session.setAttribute("redirectUrl", request.getRequestURI());
//			response.sendRedirect("/login");
//		}else {
//			chain.doFilter(request, response);
//		}
//
//	}
}
