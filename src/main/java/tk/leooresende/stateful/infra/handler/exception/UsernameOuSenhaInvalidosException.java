package tk.leooresende.stateful.infra.handler.exception;

public class UsernameOuSenhaInvalidosException extends RuntimeException {
	private String mensagem = "Usuario e/ou senha invalidos";
	
	public String getMensagem() {
		return this.mensagem;
	}
}
