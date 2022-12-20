package tk.leooresende.stateful.infra.handler.exception;

public class UsernameJaEstaSendoUsadoException extends RuntimeException {
	private String mensagem = "Esse nome de usuario já está sendo usado";
	
	
	public String getMensagem() {
		return this.mensagem;
	}
}
