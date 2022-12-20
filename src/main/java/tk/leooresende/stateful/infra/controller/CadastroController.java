package tk.leooresende.stateful.infra.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import tk.leooresende.stateful.infra.dto.formulario.RegistrarUsuarioForm;
import tk.leooresende.stateful.infra.service.UsuarioService;

public class CadastroController {

	private static final String CADASTRO_PAGE = "WEB-INF/cadastro/index.jsp";
	
	private UsuarioService userService;
	
	public CadastroController() {
		this.userService = new UsuarioService();
	}
	
	public void encaminharParaAPaginaDeCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(CadastroController.CADASTRO_PAGE).forward(req, resp);
	}

	public void registrarUsuario(HttpServletRequest req, HttpServletResponse resp, RegistrarUsuarioForm cadastroForm) throws SQLException {
		this.userService.salvarUsuario(cadastroForm);
	}
	
}
