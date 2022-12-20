package tk.leooresende.stateful.infra.service;

import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import tk.leooresende.stateful.infra.dao.UsuarioDao;
import tk.leooresende.stateful.infra.dto.formulario.RegistrarUsuarioForm;
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

	private void hashearSenhaDoUsuario(Usuario usuario) {
		String senhaHasheada = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(senhaHasheada);
	}
	
}
