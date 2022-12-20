package tk.leooresende.stateful.infra.util.values;

public enum RotasPath {
	LOGIN("/login"),
	ROOT_PATH("/"),
	CADASTRO("/cadastro"),
	DASHBOARD("/dashboard"),
	LOGGOUT("/loggout");
	
	private String path;

	RotasPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
}
