package tk.leooresende.stateful.infra.handler.exception;

import java.util.List;

import tk.leooresende.stateful.infra.util.UsuarioUtil.CamposValidados;

public class FormularioInvalidoException extends RuntimeException {
	private String mensagem = "Alguns Campos sao nulos";
	private List<CamposValidados> listaDeCamposValidados;

	public FormularioInvalidoException(List<CamposValidados> listaDeCamposValidados) {
		this.listaDeCamposValidados = listaDeCamposValidados;
	}

	@Override
	public String getMessage() {
		return this.mensagem;
	}
	
	public List<CamposValidados> getListaDeCamposValidados() {
		return this.listaDeCamposValidados;
	}
}
