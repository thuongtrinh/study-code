package edu.txt.service;

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

import edu.txt.utils.SecurityUtils;

@Component
public class MySuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targetUrl = determineTargetUrl(authentication);
		if(response.isCommitted()) {
			logger.error("Can't redirect");
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> roles = SecurityUtils.getAuthorities();
		if(isManager(roles)) {
			url = "/manager";
		} else if(isAdmin(roles)) {
			url = "/admin";
		} else if(isUser(roles)) {
			url = "/user";
		}
		return url;
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	private boolean isUser(List<String> roles) {
		if(roles.contains("USER")) {
			return true;
		}
		return false;
	}

	private boolean isAdmin(List<String> roles) {
		if(roles.contains("ADMIN")) {
			return true;
		}
		return false;
	}

	private boolean isManager(List<String> roles) {
		if(roles.contains("MANAGER")) {
			return true;
		}
		return false;
	}

}

