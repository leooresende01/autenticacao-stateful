package tk.leooresende.stateful.infra.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.leooresende.stateful.infra.dto.AutenticarUsuarioForm;
import tk.leooresende.stateful.infra.service.UsuarioService;
import tk.leooresende.stateful.infra.util.values.RotasPath;
import tk.leooresende.stateful.infra.util.values.SessionAttributes;
import tk.leooresende.stateful.model.Usuario;

public class LoginController {
	private static final String LOGIN_PAGE = "WEB-INF/login/index.jsp";
	private UsuarioService usuarioService;
	
	public LoginController() {
		this.usuarioService = new UsuarioService();
	}
	
	public void encaminharParaAPaginaDeLogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nextUrl = req.getParameter(SessionAttributes.NEXT_URL.name());
		if (nextUrl == null)
			nextUrl = RotasPath.DASHBOARD.getPath();
		req.getSession().setAttribute(SessionAttributes.NEXT_URL.name(), nextUrl);
		req.getRequestDispatcher(LoginController.LOGIN_PAGE).forward(req, resp);
	}

	public void autenticarUsuario(HttpServletRequest req, HttpServletResponse resp, HttpSession session,
			AutenticarUsuarioForm authUsuarioForm) throws IOException, SQLException {
		Usuario usuario = this.usuarioService.verificaSeOsDadosDoUsuarioSaoValidos(authUsuarioForm);
		session.setAttribute(SessionAttributes.USERNAME_USUARIO_AUTENTICADO.getValue(), usuario.getUsername());
	}
}
