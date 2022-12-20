package tk.leooresende.stateful.infra.config.filter;

import java.io.IOException;
import java.net.URL;

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

import tk.leooresende.stateful.infra.util.values.RotasPath;
import tk.leooresende.stateful.infra.util.values.SessionAttributes;

@WebFilter(urlPatterns = "/dashboard")
public class UsuarioNaoAutenticadoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		Object usernameUsuarioAutenticado = session.getAttribute(SessionAttributes.USERNAME_USUARIO_AUTENTICADO.getValue());
		if (usernameUsuarioAutenticado != null) {
			chain.doFilter(request, response);
			return;
		}
		String pathAtual = new URL(httpRequest.getRequestURL().toString()).getPath();
		((HttpServletResponse) response).sendRedirect(RotasPath.LOGIN.getPath() + "?nextUrl=" + pathAtual);
	}

	@Override
	public void destroy() {
	}
	
}
