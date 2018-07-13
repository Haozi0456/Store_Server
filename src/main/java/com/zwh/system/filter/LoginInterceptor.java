package com.zwh.system.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 登录拦截器
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		HttpSession session  = arg0.getSession();
		if (session == null || session.getAttribute("user") == null) {
			// 如果判断是 AJAX 请求,直接设置为session超时
			if (arg0.getHeader("x-requested-with") != null
					&& arg0.getHeader("x-requested-with").equals("XMLHttpRequest")) {
				arg1.setHeader("sessionstatus", "timeout");
			} else {
				arg1.sendRedirect("/");
			}
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

}
