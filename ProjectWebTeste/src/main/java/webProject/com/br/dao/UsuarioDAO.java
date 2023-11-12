package webProject.com.br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webProject.com.br.connection.ConnectionManager;
import webProject.com.br.model.Usuario;

public class UsuarioDAO {

	private Connection conexao;

	public void adiciona(Usuario usuario) throws SQLException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "insert into usuario(nome, email, telefone, senha, dataCadastro) values (?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getTelefone());
			stmt.setString(4, usuario.getSenha());
			stmt.setDate(5, usuario.getDataCadastro());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Usuario> selectAll() throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "select * from usuario order by id";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
              
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setDataCadastro(rs.getDate("datacadastro"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}
}