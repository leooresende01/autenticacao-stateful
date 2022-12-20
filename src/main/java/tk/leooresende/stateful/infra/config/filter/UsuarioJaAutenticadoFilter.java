package tk.leooresende.stateful.infra.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"", "/login", "/cadastro"})
public class UsuarioJaAutenticadoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		Object usernameUsuarioAutenticado = session.getAttribute("usernameUsuarioAutenticado");
		if (usernameUsuarioAutenticado == null) {
			chain.doFilter(request, response);
			return;
		} ((HttpServletResponse) response).sendRedirect("/dashboard");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
