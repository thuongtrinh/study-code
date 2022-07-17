package com.txt.eshopperboot.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

//@Component
public class MySuccessHandler {// extends SimpleUrlAuthenticationSuccessHandler {
//
//	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//	@Override
//	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//			throws IOException, ServletException {
////		super.handle(request, response, authentication);
//		String targetUrl = determineTargetUrl(authentication);
//		if (response.isCommitted()) {
//			logger.error("Cannot redirect");
//			return;
//		}
//		redirectStrategy.sendRedirect(request, response, targetUrl);
//	}
//
//	private String determineTargetUrl(Authentication authentication) {
//		String url = "";
//		List<String> roles = SecurityUtil.getAuthorities();
//		if (isAdmin(roles)) {
//			url = "/cart";
//		} else if (isUser(roles)) {
//			url = "/home";
//		} else {
//			throw new IllegalStateException("Not found role of username");
//		}
//		return url;
//	}
//
//	private boolean isUser(List<String> roles) {
//		if (roles.contains("USER")) {
//			return true;
//		}
//		return false;
//	}
//
//	private boolean isAdmin(List<String> roles) {
//		if (roles.contains("ADMIN")) {
//			return true;
//		}
//		return false;
//	}
//
//	public RedirectStrategy getRedirectStrategy() {
//		return redirectStrategy;
//	}
//
//	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
//		this.redirectStrategy = redirectStrategy;
//	}
//
}
