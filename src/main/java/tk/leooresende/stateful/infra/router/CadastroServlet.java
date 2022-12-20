package tk.leooresende.stateful.infra.router;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.leooresende.stateful.infra.controller.CadastroController;
import tk.leooresende.stateful.infra.dto.formulario.RegistrarUsuarioForm;
import tk.leooresende.stateful.infra.handler.CadastroHandler;
import tk.leooresende.stateful.infra.handler.exception.FormularioInvalidoException;
import tk.leooresende.stateful.infra.handler.exception.UsernameJaEstaSendoUsadoException;
import tk.leooresende.stateful.infra.util.UsuarioUtil;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final String LOGIN_PATH = "/login";
	private static final String FORMULARIO_CADASTRO_USERNAME = "username";
	private static final String FORMULARIO_CADASTRO_PASSWORD = "password";
	private static final String FORMULARIO_CADASTRO_NOME_COMPLETO = "nomeCompleto";
	private CadastroController cadastroController;
	private CadastroHandler handler;
	
	public CadastroServlet() {
		this.cadastroController = new CadastroController();
		this.handler = new CadastroHandler();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.cadastroController.encaminharParaAPaginaDeCadastro(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String formCadastroUsername = req.getParameter(CadastroServlet.FORMULARIO_CADASTRO_USERNAME);
		String formCadastroPassword = req.getParameter(CadastroServlet.FORMULARIO_CADASTRO_PASSWORD);
		String formCadastroNomeCompleto = req.getParameter(CadastroServlet.FORMULARIO_CADASTRO_NOME_COMPLETO);
		RegistrarUsuarioForm cadastroForm = new RegistrarUsuarioForm(formCadastroUsername, formCadastroPassword, formCadastroNomeCompleto);
		try {
			UsuarioUtil.validarFormularioDeRegistroDeUsuario(cadastroForm);
			this.cadastroController.registrarUsuario(req, resp, cadastroForm);
			resp.sendRedirect(CadastroServlet.LOGIN_PATH);
		} catch (SQLException e) {} 
		catch (FormularioInvalidoException e) {
			this.handler.tratarErroDeFormularioVazio(req, resp, e.getListaDeCamposValidados());
		}
		catch (UsernameJaEstaSendoUsadoException e) {
			this.handler.usernameJaEstaSendoUsado(req, resp, e);
		}
	}
}
