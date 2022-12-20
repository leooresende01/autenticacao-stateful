package tk.leooresende.stateful.infra.router;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.leooresende.stateful.infra.controller.LoginController;
import tk.leooresende.stateful.infra.dto.AutenticarUsuarioForm;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final String NEXT_URL = "nextUrl";
	private static final String LOGIN_FORM_USERNAME = "username";
	private static final String LOGIN_FORM_PASSWORD = "password";
	private LoginController loginController;

	public LoginServlet() {
		this.loginController = new LoginController();
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
		this.loginController.autenticarUsuario(req, resp, autenticarUsuarioForm);
		HttpSession session = req.getSession();

		Object nextUrl = session.getAttribute(LoginServlet.NEXT_URL);
		try {
			resp.sendRedirect(nextUrl.toString());
		} catch (Exception ex) {
			resp.sendRedirect("/dashboard");
		}
	}
}
