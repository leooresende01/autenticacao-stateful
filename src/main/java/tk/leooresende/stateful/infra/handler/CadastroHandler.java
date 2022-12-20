package tk.leooresende.stateful.infra.handler;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.leooresende.stateful.infra.handler.exception.UsernameJaEstaSendoUsadoException;
import tk.leooresende.stateful.infra.util.UsuarioUtil.CamposValidados;

public class CadastroHandler {
	private static final String USERNAME_JA_UTILIZADO = "usernameJaUtilizado";
	private static final String DELIMITADOR_DAS_MENSAGENS_DE_ERROS = " e ";
	private static final String CADASTRO_PAGE = "WEB-INF/cadastro/index.jsp";
	private static final String ERROR_FORM_VAZIO = "errorFormVazio";
	private static final String CLASS_FORM_INVALID = "is-invalid";
	private static final String CLASS_FORM_VALID = "is-valid";

	public void tratarErroDeFormularioVazio(HttpServletRequest req, HttpServletResponse resp,
			List<CamposValidados> listaDeCamposInvalidos) throws ServletException, IOException {
		listaDeCamposInvalidos.forEach(camposInvalidos -> {
			req.setAttribute("%sHaveErros".formatted(camposInvalidos.getCampo()), camposInvalidos.getTemAlgumErro());
			req.setAttribute("%sValue".formatted(camposInvalidos.getCampo()), camposInvalidos.getValorAtual());
			req.setAttribute("%sErrosMessage".formatted(camposInvalidos.getCampo()), camposInvalidos.getMensagemDeErro()
					.stream().collect(Collectors.joining(CadastroHandler.DELIMITADOR_DAS_MENSAGENS_DE_ERROS)));
			if (camposInvalidos.getTemAlgumErro())
				req.setAttribute("%sClass".formatted(camposInvalidos.getCampo()), CadastroHandler.CLASS_FORM_INVALID);
			else
				req.setAttribute("%sClass".formatted(camposInvalidos.getCampo()), CadastroHandler.CLASS_FORM_VALID);
		});
		req.setAttribute(CadastroHandler.ERROR_FORM_VAZIO, true);
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
