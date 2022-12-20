package tk.leooresende.stateful.infra.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.leooresende.stateful.infra.handler.exception.UsernameJaEstaSendoUsadoException;
import tk.leooresende.stateful.infra.util.UsuarioUtil.CamposValidados;

public class CadastroHandler extends DefaultHandler {
	private static final String USERNAME_JA_UTILIZADO = "usernameJaUtilizado";
	private static final String CADASTRO_PAGE = "WEB-INF/cadastro/index.jsp";

	public void tratarErroDeFormularioVazio(HttpServletRequest req, HttpServletResponse resp,
			List<CamposValidados> listaDeCamposInvalidos) throws ServletException, IOException {
		super.tratarErrosDeValidacao(req, resp, listaDeCamposInvalidos, CadastroHandler.CADASTRO_PAGE);
		this.encaminharPraPaginaDeCadastro(req, resp);
	}

	public void usernameJaEstaSendoUsado(HttpServletRequest req, HttpServletResponse resp,
			UsernameJaEstaSendoUsadoException e) throws ServletException, IOException {
		req.setAttribute(USERNAME_JA_UTILIZADO, true);
		this.encaminharPraPaginaDeCadastro(req, resp);
	}
	
	private void encaminharPraPaginaDeCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(CadastroHandler.CADASTRO_PAGE).forward(req, resp);
	}

}
