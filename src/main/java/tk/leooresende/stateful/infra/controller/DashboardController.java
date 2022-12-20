package tk.leooresende.stateful.infra.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.leooresende.stateful.infra.dto.UsuarioDto;
import tk.leooresende.stateful.infra.service.UsuarioService;
import tk.leooresende.stateful.infra.util.values.RequestAttributes;
import tk.leooresende.stateful.infra.util.values.SessionAttributes;
import tk.leooresende.stateful.model.Usuario;

public class DashboardController {
	private static final String DASHBOARD_PAGE = "WEB-INF/dashboard/index.jsp";
	private UsuarioService usuarioService;
	
	public DashboardController() {
		this.usuarioService = new UsuarioService();
	}
	
	public void encaminharParaAPaginaInicialDeControle(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException, SQLException {
		String usernameUsuarioAutenticado = session.getAttribute(SessionAttributes.USERNAME_USUARIO_AUTENTICADO.getValue()).toString();
		Usuario usuario = this.usuarioService.buscarUsuarioPeloUsernameNoDB(usernameUsuarioAutenticado);
		UsuarioDto usuarioDto = new UsuarioDto(usuario);
		req.setAttribute(RequestAttributes.USUARIO_AUTENTICADO.getValue(), usuarioDto);
		req.getRequestDispatcher(DashboardController.DASHBOARD_PAGE).forward(req, resp);
	}

}
