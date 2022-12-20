package tk.leooresende.stateful.infra.util.values;

public enum UsuarioTable {
	USUARIO_ID("usuario_id"),
	USERNAME("username"),
	PASSWORD("password"),
	NOME_COMPLETO("nome_completo");

	private String value;

	UsuarioTable(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
