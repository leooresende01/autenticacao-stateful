package tk.leooresende.stateful.infra.util.values;

public enum RequestAttributes {
	USUARIO_AUTENTICADO("usuarioAutenticado");
	
	private String value;

	RequestAttributes(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
