package tk.leooresende.stateful.infra.handler;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.leooresende.stateful.infra.util.UsuarioUtil.CamposValidados;

public class DefaultHandler {
	private static final String DELIMITADOR_DAS_MENSAGENS_DE_ERROS = " e ";
	private static final String ERROR_FORM_VAZIO = "errorFormVazio";
	private static final String CLASS_FORM_INVALID = "is-invalid";
	private static final String CLASS_FORM_VALID = "is-valid";
	
	public void tratarErrosDeValidacao(HttpServletRequest req, HttpServletResponse resp, List<CamposValidados> listaDeCamposInvalidos, String cadastroPage) {
		listaDeCamposInvalidos.forEach(camposInvalidos -> {
			req.setAttribute("%sHaveErros".formatted(camposInvalidos.getCampo()), camposInvalidos.getTemAlgumErro());
			req.setAttribute("%sValue".formatted(camposInvalidos.getCampo()), camposInvalidos.getValorAtual());
			req.setAttribute("%sErrosMessage".formatted(camposInvalidos.getCampo()), camposInvalidos.getMensagemDeErro()
					.stream().collect(Collectors.joining(DefaultHandler.DELIMITADOR_DAS_MENSAGENS_DE_ERROS)));
			if (camposInvalidos.getTemAlgumErro())
				req.setAttribute("%sClass".formatted(camposInvalidos.getCampo()), DefaultHandler.CLASS_FORM_INVALID);
			else
				req.setAttribute("%sClass".formatted(camposInvalidos.getCampo()), DefaultHandler.CLASS_FORM_VALID);
		});
		req.setAttribute(DefaultHandler.ERROR_FORM_VAZIO, true);
	}
	
}
