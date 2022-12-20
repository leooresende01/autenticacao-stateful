package tk.leooresende.stateful.infra.service;

import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import tk.leooresende.stateful.infra.dao.UsuarioDao;
import tk.leooresende.stateful.infra.dto.AutenticarUsuarioForm;
import tk.leooresende.stateful.infra.dto.formulario.RegistrarUsuarioForm;
import tk.leooresende.stateful.infra.handler.exception.UsernameOuSenhaInvalidosException;
import tk.leooresende.stateful.model.Usuario;

public class UsuarioService {
	private UsuarioDao usuarioDao;
	
	public UsuarioService() {
		this.usuarioDao = new UsuarioDao();
	}

	public void salvarUsuario(RegistrarUsuarioForm cadastroForm) throws SQLException {
		Usuario usuario = cadastroForm.pegarCadastroComoUsuario();
		this.hashearSenhaDoUsuario(usuario);
		this.usuarioDao.save(usuario);
	}
	
	public Usuario verificaSeOsDadosDoUsuarioSaoValidos(AutenticarUsuarioForm authUsuarioForm) throws SQLException {
		Usuario usuario = buscarUsuarioPeloUsernameNoDB(authUsuarioForm.getUsername());
		this.verificaSeASenhaEnviadaEhValida(usuario.getPassword(), authUsuarioForm.getPassword());
		return usuario;
	}

	public Usuario buscarUsuarioPeloUsernameNoDB(String username) throws SQLException {
		return this.usuarioDao.findUsuarioByUsername(username);
	}
	
	private void hashearSenhaDoUsuario(Usuario usuario) {
		String senhaHasheada = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(senhaHasheada);
	}

	private void verificaSeASenhaEnviadaEhValida(String senhaHasheada, String senhaEnviadaPeloUsuario) {
		Boolean aSenhaNaoEhValida = !BCrypt.checkpw(senhaEnviadaPeloUsuario, senhaHasheada);
		if (aSenhaNaoEhValida) throw new UsernameOuSenhaInvalidosException();
	}
	
}
