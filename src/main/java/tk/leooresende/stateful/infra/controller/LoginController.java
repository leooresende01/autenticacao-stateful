package tk.leooresende.stateful.infra.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import tk.leooresende.stateful.infra.dto.AutenticarUsuarioForm;

public class LoginController {
	private static final String USERNAME_USUARIO_AUTENTICADO = "usernameUsuarioAutenticado";
	private static final String LOGIN_PAGE = "WEB-INF/login/index.jsp";

	public void encaminharParaAPaginaDeLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nextUrl = req.getParameter("nextUrl");
		if (nextUrl == null) nextUrl = "/dashboard";
		req.getSession().setAttribute("nextUrl", nextUrl);
		req.getRequestDispatcher(LoginController.LOGIN_PAGE).forward(req, resp);
	}

	public void autenticarUsuario(HttpServletRequest req, HttpServletResponse resp, @Valid AutenticarUsuarioForm authUsuarioForm) throws IOException {
		HttpSession session = req.getSession();
		session.setAttribute(LoginController.USERNAME_USUARIO_AUTENTICADO, authUsuarioForm.getUsername());
	}
}
