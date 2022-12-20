package tk.leooresende.stateful.infra.dto.formulario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import tk.leooresende.stateful.infra.handler.exception.FormularioInvalidoException;
import tk.leooresende.stateful.model.Usuario;

public class RegistrarUsuarioForm {
	@NotBlank
	@Size(max = 25, min = 8)
	private String username;
	@NotBlank
	@Size(max = 25, min = 8)
	private String password;
	@NotBlank
	private String nomeCompleto;

	public RegistrarUsuarioForm(@NotBlank @Size(max = 25, min = 8) String username,
			@NotBlank @Size(max = 25, min = 8) String password, @NotBlank String nomeCompleto) {
		this.username = username;
		this.password = password;
		this.nomeCompleto = nomeCompleto;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Usuario pegarCadastroComoUsuario() {
		return new Usuario(this.username, this.password, this.nomeCompleto);
	}
}
