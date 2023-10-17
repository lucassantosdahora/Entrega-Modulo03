package com.agenciadeviagem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agenciadeviagem.connection.Conexao;
import com.agenciadeviagem.principal.Destinos;

public class DestinosDAO {

	private Connection conexao;

	public DestinosDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void registrarDestinos(Destinos destinos) {
		String sql = "INSERT INTO destinos(nome,descricao,pais) VALUES(?,?,?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, destinos.getNome());
			stmt.setString(2, destinos.getDescricao());
			stmt.setString(3, destinos.getPais());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Destinos> listaDestinos() {
		List<Destinos> Destinos = new ArrayList<>();
		String sql = "SELECT * FROM destinos";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet retorno = stmt.executeQuery();
			while (retorno.next()) {
				Destinos destinos = new Destinos();
				destinos.setId(retorno.getInt("Id_Destino"));
				destinos.setNome(retorno.getNString("nome"));
				destinos.setDescricao(retorno.getString("descricao"));
				destinos.setPais(retorno.getNString("pais"));
				Destinos.add(destinos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Destinos;
	}

	public Destinos buscarDestinos(int id) {
		Destinos destinos = null;
		String sql = "SELECT * FROM destinos WHERE Id_Destino = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet retorno = stmt.executeQuery();
			if (retorno.next()) {
				destinos = new Destinos();
				destinos.setId(retorno.getInt("Id_Destino"));
				destinos.setNome(retorno.getString("nome"));
				destinos.setDescricao(retorno.getString("descricao"));
				destinos.setPais(retorno.getString("pais"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return destinos;
	}

	public void atualizarDestinos(Destinos destinos) {
		String sql = "UPDATE destinos SET nome = ?, descricao = ?, pais = ? WHERE Id_Destino = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, destinos.getNome());
			stmt.setString(2, destinos.getDescricao());
			stmt.setString(3, destinos.getPais());
			stmt.setInt(4, destinos.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirRegistroDestinos(int id) {
		String sql = "DELETE FROM destinos WHERE Id_Destino = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void fecharConexao() {
		try {
			if (conexao != null && !conexao.isClosed()) {
				conexao.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
