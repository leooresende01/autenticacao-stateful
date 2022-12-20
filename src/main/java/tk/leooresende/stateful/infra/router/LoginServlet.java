package tk.leooresende.stateful.infra.router;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.leooresende.stateful.infra.controller.LoginController;
import tk.leooresende.stateful.infra.dto.AutenticarUsuarioForm;
import tk.leooresende.stateful.infra.dto.formulario.RegistrarUsuarioForm;
import tk.leooresende.stateful.infra.handler.CadastroHandler;
import tk.leooresende.stateful.infra.handler.LoginHandler;
import tk.leooresende.stateful.infra.handler.exception.FormularioInvalidoException;
import tk.leooresende.stateful.infra.handler.exception.UsernameOuSenhaInvalidosException;
import tk.leooresende.stateful.infra.util.UsuarioUtil;
import tk.leooresende.stateful.infra.util.values.RotasPath;
import tk.leooresende.stateful.infra.util.values.SessionAttributes;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final String LOGIN_FORM_USERNAME = "username";
	private static final String LOGIN_FORM_PASSWORD = "password";
	private LoginController loginController;
	private LoginHandler handler;

	public LoginServlet() {
		this.loginController = new LoginController();
		this.handler = new LoginHandler();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.loginController.encaminharParaAPaginaDeLogin(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter(LoginServlet.LOGIN_FORM_USERNAME);
		String password = req.getParameter(LoginServlet.LOGIN_FORM_PASSWORD);
		AutenticarUsuarioForm autenticarUsuarioForm = new AutenticarUsuarioForm(username, password);
		HttpSession session = req.getSession();
		Object nextUrl = session.getAttribute(SessionAttributes.NEXT_URL.name());
		try {
			UsuarioUtil.validarFormularioDeRegistroDeUsuario(autenticarUsuarioForm);
			this.loginController.autenticarUsuario(req, resp, session, autenticarUsuarioForm);
			try {
				resp.sendRedirect(nextUrl.toString());
			} catch (Exception ex) {
				resp.sendRedirect(RotasPath.DASHBOARD.getPath());
			}
		} catch (IOException | SQLException | UsernameOuSenhaInvalidosException ex) {
			this.handler.tratarErroDeUsernameOuSenhaInvalidos(req, resp, ex);
		}
		catch (FormularioInvalidoException e) {
			this.handler.tratarErroDeFormularioVazio(req, resp, e.getListaDeCamposValidados());
		}
	}
}
