package tk.leooresende.stateful.infra.util.values;

public enum SessionAttributes {
	NEXT_URL("nextUrl"), USERNAME_USUARIO_AUTENTICADO("usernameUsuarioAutenticado");

	private String value;

	SessionAttributes(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
