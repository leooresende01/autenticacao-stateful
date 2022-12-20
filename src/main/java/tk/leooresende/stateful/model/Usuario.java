package tk.leooresende.stateful.model;

public class Usuario {
	private Integer id;
	private String username;
	private String password;
	private String nomeCompleto;

	public Usuario() {
	}

	public Usuario(Integer id, String username, String password, String nomeCompleto) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.nomeCompleto = nomeCompleto;
	}

	public Usuario(String username, String password, String nomeCompleto) {
		this.username = username;
		this.password = password;
		this.nomeCompleto = nomeCompleto;
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
