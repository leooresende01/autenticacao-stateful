package tk.leooresende.stateful.infra.dto;

import tk.leooresende.stateful.model.Usuario;

public class UsuarioDto {
	private Integer id;
	private String username;
	private String password;
	private String nomeCompleto;

	public UsuarioDto() {
	}

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.username = usuario.getUsername();
		this.password = usuario.getPassword();
		this.nomeCompleto = usuario.getNomeCompleto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
