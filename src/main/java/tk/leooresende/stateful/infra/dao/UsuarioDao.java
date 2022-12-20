package tk.leooresende.stateful.infra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import tk.leooresende.stateful.infra.handler.exception.UsernameJaEstaSendoUsadoException;
import tk.leooresende.stateful.infra.handler.exception.UsernameOuSenhaInvalidosException;
import tk.leooresende.stateful.infra.util.factory.ConnectionDBFatory;
import tk.leooresende.stateful.infra.util.values.UsuarioTable;
import tk.leooresende.stateful.model.Usuario;

public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() {
		this.connection = ConnectionDBFatory.getConnection();
	}

	public Usuario save(Usuario usuario) throws SQLException {
		String query = """
				INSERT INTO usuarios (
					username,
					password,
					nome_completo
				)
				  SELECT * FROM (SELECT ?, ?, ?) AS tmp
				  WHERE NOT EXISTS
				(SELECT u.username FROM usuarios u WHERE u.username = ?) RETURNING *""";
		try (PreparedStatement prepareStatement = this.connection.prepareStatement(query)) {
			prepareStatement.setString(1, usuario.getUsername());
			prepareStatement.setString(2, usuario.getPassword());
			prepareStatement.setString(3, usuario.getNomeCompleto());
			prepareStatement.setString(4, usuario.getUsername());
			boolean retornouAlgumRegistro = prepareStatement.execute();
			this.connection.commit();
			if (retornouAlgumRegistro) {
				ResultSet resultadoDasConsultas = prepareStatement.getResultSet();
				return this.pegarUmUnicoUsuarioNoResultadoDaConsulta(resultadoDasConsultas);
			} else
				throw new UsernameJaEstaSendoUsadoException();
		} catch (SQLException e) {
			this.connection.rollback();
			throw new UsernameJaEstaSendoUsadoException();
		}
	}

	public Usuario findUsuarioByUsername(String username) throws SQLException {
		try {
			PreparedStatement consulta = this.connection.prepareStatement("""
					SELECT * FROM usuarios u WHERE u.username = ?;
					""");
			consulta.setString(1, username);
			boolean encontrouAlgumResultado = consulta.execute();
			connection.commit();
			if (encontrouAlgumResultado) {
				ResultSet resultadoDasConsultas = consulta.getResultSet();
				return this.pegarUmUnicoUsuarioNoResultadoDaConsulta(resultadoDasConsultas);
			} else
				throw new UsernameOuSenhaInvalidosException();
		} catch (SQLException e) {
			connection.rollback();
			throw new UsernameOuSenhaInvalidosException();
		}
	}

	private Usuario pegarUmUnicoUsuarioNoResultadoDaConsulta(ResultSet resultadoDasConsultas) throws SQLException {
		resultadoDasConsultas.next();
		Integer usuarioId = resultadoDasConsultas.getInt(UsuarioTable.USUARIO_ID.getValue());
		String username = resultadoDasConsultas.getString(UsuarioTable.USERNAME.getValue());
		String password = resultadoDasConsultas.getString(UsuarioTable.PASSWORD.getValue());
		String nomeCompleto = resultadoDasConsultas.getString(UsuarioTable.NOME_COMPLETO.getValue());
		return new Usuario(usuarioId, username, password, nomeCompleto);
	}

}
