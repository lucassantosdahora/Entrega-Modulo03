package com.agenciadeviagem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agenciadeviagem.principal.Destinos;
import com.agenciadeviagem.principal.Promocoes;
import com.agenciadeviagem.connection.Conexao;

public class PromocoesDAO {

	private Connection conexao;

	DestinosDAO destinoDAO = new DestinosDAO();

	public PromocoesDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void registroPromocoes(Promocoes promocoes) {
		String sql = "INSERT INTO promocoes (nome, dataValidade, desconto, Id_Destino) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, promocoes.getNome());
			stmt.setTimestamp(2, new java.sql.Timestamp(promocoes.getDataValidade().getTime()));
			stmt.setInt(3, promocoes.getDesconto());
			stmt.setInt(4, promocoes.getDestinos().getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Promocoes> listaPromocoes() {
		List<Promocoes> Promocoes = new ArrayList<>();
		String sql = "SELECT * FROM promocoes";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet retorno = stmt.executeQuery();
			while (retorno.next()) {
				Promocoes promocoes = new Promocoes();
				promocoes.setId(retorno.getInt("Id_Promocao"));
				promocoes.setNome(retorno.getString("nome"));
				promocoes.setDataValidade(retorno.getDate("dataValidade"));
				promocoes.setDesconto(retorno.getInt("desconto"));
				int idDestino = retorno.getInt("Id_Destino");
				Destinos destino = destinoDAO.buscarDestinos(idDestino);
				promocoes.setDestinos(destino);

				Promocoes.add(promocoes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Promocoes;
	}

	public Promocoes buscarPromocoes(int id) {
		Promocoes promocoes = null;
		String sql = "SELECT * FROM promocoes WHERE Id_Promocao = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet retorno = stmt.executeQuery();
			if (retorno.next()) {
				promocoes = new Promocoes();
				promocoes.setId(retorno.getInt("Id_Promocao"));
				promocoes.setNome(retorno.getString("nome"));
				promocoes.setDataValidade(retorno.getDate("dataValidade"));
				promocoes.setDesconto(retorno.getInt("desconto"));
				int idDestino = retorno.getInt("Id_Destino");
				Destinos destino = destinoDAO.buscarDestinos(idDestino);
				promocoes.setDestinos(destino);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return promocoes;
	}

	public void atualizarPromocoes(Promocoes promocoes) {
		String sql = "UPDATE promocoes SET nome = ?, dataValidade = ?, desconto = ?, Id_Destino = ? WHERE Id_Promocao = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, promocoes.getNome());
			stmt.setTimestamp(2, new java.sql.Timestamp(promocoes.getDataValidade().getTime()));
			stmt.setInt(3, promocoes.getDesconto());
			stmt.setInt(4, promocoes.getDestinos().getId());
			stmt.setInt(5, promocoes.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirPromocao(int id) {
		String sql = "DELETE FROM promocoes WHERE Id_Promocao = ?";
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
