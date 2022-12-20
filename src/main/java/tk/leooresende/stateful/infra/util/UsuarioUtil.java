package tk.leooresende.stateful.infra.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import tk.leooresende.stateful.infra.dto.formulario.RegistrarUsuarioForm;
import tk.leooresende.stateful.infra.handler.exception.FormularioInvalidoException;

public class UsuarioUtil {

	private static final String CAMPO_NOME_COMPLETO = "nomeCompleto";

	public static void validarFormularioDeRegistroDeUsuario(Object form) {
		List<CamposValidados> listaDeCamposValidados = Stream.of(form.getClass().getDeclaredFields())
				.map(atributo -> UsuarioUtil.verificarSeOCampoEhValido(atributo, form)).toList();
		if (listaDeCamposValidados.stream().filter(camposValidados -> camposValidados.temAlgumErro).toList().size() >= 1) {
			throw new FormularioInvalidoException(listaDeCamposValidados);
		}	
	}

	private static CamposValidados verificarSeOCampoEhValido(Field atributo, Object form) {
		atributo.setAccessible(true);
		String nomeDoAtributo = atributo.getName();
		CamposValidados camposValidados = new CamposValidados(nomeDoAtributo);
		String valorDoAtributo = null;
		try {
			valorDoAtributo = atributo.get(form).toString();
			camposValidados.valorAtual = valorDoAtributo;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		if (valorDoAtributo.isBlank()) {
			camposValidados.temAlgumErro = true;
			camposValidados.mensagemDeErro.add("Esse campo não pode ser vazio".formatted(nomeDoAtributo));
		}
		if (valorDoAtributo.length() < 8 && !nomeDoAtributo.equals(UsuarioUtil.CAMPO_NOME_COMPLETO)) {
			camposValidados.temAlgumErro = true;
			camposValidados.mensagemDeErro
					.add("Esse campo deve conter mais que 8 caracteres".formatted(nomeDoAtributo));
		}
		if (valorDoAtributo.length() > 25 && !nomeDoAtributo.equals(UsuarioUtil.CAMPO_NOME_COMPLETO)) {
			camposValidados.temAlgumErro = true;
			camposValidados.mensagemDeErro
					.add("Esse campo deve conter menos que 25 caracteres".formatted(nomeDoAtributo));
		}
		return camposValidados;
	}

	public static class CamposValidados {
		private String campo;
		private Boolean temAlgumErro = false;
		private List<String> mensagemDeErro = new ArrayList<>();
		private String valorAtual;

		public CamposValidados(String nomeDoAtributo) {
			this.campo = nomeDoAtributo;
		}

		public String getCampo() {
			return campo;
		}

		public Boolean getTemAlgumErro() {
			return temAlgumErro;
		}

		public void setTemAlgumErro(Boolean temAlgumErro) {
			this.temAlgumErro = temAlgumErro;
		}

		public List<String> getMensagemDeErro() {
			return mensagemDeErro;
		}

		public void setMensagemDeErro(List<String> mensagemDeErro) {
			this.mensagemDeErro = mensagemDeErro;
		}

		public String getValorAtual() {
			return valorAtual;
		}

	}
}
