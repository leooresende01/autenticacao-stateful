package tk.leooresende.stateful.infra.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.leooresende.stateful.infra.util.UsuarioUtil.CamposValidados;

public class LoginHandler extends DefaultHandler {
	private static final String LOGIN_PAGE = "WEB-INF/login/index.jsp";
	
	public void tratarErroDeFormularioVazio(HttpServletRequest req, HttpServletResponse resp,
			List<CamposValidados> listaDeCamposInvalidos) throws ServletException, IOException {
		super.tratarErrosDeValidacao(req, resp, listaDeCamposInvalidos, LoginHandler.LOGIN_PAGE);
		this.encaminharParaAPaginaDeLogin(req, resp);
	}


	public void tratarErroDeUsernameOuSenhaInvalidos(HttpServletRequest req, HttpServletResponse resp, Exception ex) throws ServletException, IOException {
		req.setAttribute("loginErrorMessage", ex.getMessage());
		req.setAttribute("loginHasErrors", true);
		this.encaminharParaAPaginaDeLogin(req, resp);
	}
	
	private void encaminharParaAPaginaDeLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(LoginHandler.LOGIN_PAGE).forward(req, resp);
	}
}
