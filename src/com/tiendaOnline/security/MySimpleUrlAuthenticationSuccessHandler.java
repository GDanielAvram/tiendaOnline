package com.tiendaOnline.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.tiendaOnline.model.ClienteEntity;
import com.tiendaOnline.service.ClienteEntityService;

public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private ClienteEntityService clienteService;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	private String targetUrl;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {

		HttpSession session = request.getSession();

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ClienteEntity authUser = clienteService.findByUsername(userDetails.getUsername());
		session.setAttribute("cliente", authUser);

		boolean isUser = false;
		boolean isAdmin = false;

		final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROL_CLIENTE")) {
				isUser = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROL_ADMIN")) {
				isAdmin = true;
				break;
			}
		}

		if (isUser) {
			targetUrl = "/producto/inicio";
		} else if (isAdmin) {
			targetUrl = "/producto/inicio";
		} else {
			throw new IllegalStateException();
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected void handle(final HttpServletRequest request, final HttpServletResponse response,
			final Authentication authentication) throws IOException {
		final String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(final Authentication authentication) {
		boolean isCliente = false;
		boolean isAdmin = false;
		final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROL_CLIENTE")) {
				isCliente = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROL_ADMIN")) {
				isAdmin = true;
				break;
			}
		}

		if (isCliente) {
			// pagina de inicio del cliente
			return "/inicio";
		} else if (isAdmin) {
			// pagina de inicio del admin
			return "/admin";
		} else {
			throw new IllegalStateException();
		}
	}

	protected final void clearAuthenticationAttributes(final HttpServletRequest request) {
		final HttpSession session = request.getSession(false);

		if (session == null) {
			return;
		}

		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
