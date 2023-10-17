package com.agenciadeviagem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agenciadeviagem.connection.Conexao;
import com.agenciadeviagem.principal.Clientes;

public class ClientesDAO {

	private Connection conexao;

	public ClientesDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void registrarClientes(Clientes clientes) {
		String sql = "INSERT INTO clientes(nome,cpf,idade,telefone,endereco) VALUES(?,?,?,?,?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, clientes.getNome());
			stmt.setString(2, clientes.getCpf());
			stmt.setInt(3, clientes.getIdade());
			stmt.setString(4, clientes.getTelefone());
			stmt.setString(5, clientes.getEndereco());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Clientes> listaClientes() {
		List<Clientes> Clientes = new ArrayList<>();
		String sql = "SELECT * FROM clientes";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet retorno = stmt.executeQuery();
			while (retorno.next()) {
				Clientes clientes = new Clientes();
				clientes.setId(retorno.getInt("Id_Cliente"));
				clientes.setNome(retorno.getString("nome"));
				clientes.setIdade(retorno.getInt("idade"));
				clientes.setCpf(retorno.getString("cpf"));
				clientes.setTelefone(retorno.getString("telefone"));
				clientes.setEndereco(retorno.getString("endereco"));
				Clientes.add(clientes);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Clientes;
	}

	public Clientes buscarClientes(int id) {
	    Clientes clientes = null;
	    String sql = "SELECT * FROM clientes WHERE Id_Cliente = ?";
	    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        ResultSet retorno = stmt.executeQuery();
	        if (retorno.next()) {
	            clientes = new Clientes();
	            clientes.setId(retorno.getInt("Id_Cliente"));
	            clientes.setNome(retorno.getString("nome"));
	            clientes.setIdade(retorno.getInt("idade"));
	            clientes.setCpf(retorno.getString("cpf"));
	            clientes.setTelefone(retorno.getString("telefone"));
	            clientes.setEndereco(retorno.getString("endereco"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return clientes;
	}


	public void atualizarRegistroCliente(Clientes clientes) {
	    String sql = "UPDATE clientes SET nome = ?, cpf = ?, idade = ?, telefone = ?, endereco = ? WHERE Id_Cliente = ?";
	    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        stmt.setString(1, clientes.getNome());
	        stmt.setString(2, clientes.getCpf());
	        stmt.setInt(3, clientes.getIdade());
	        stmt.setString(4, clientes.getTelefone());
	        stmt.setString(5, clientes.getEndereco());
	        stmt.setInt(6, clientes.getId()); 
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public void excluirRegistroClientes(int id) {
		String sql = "DELETE FROM clientes WHERE Id_Cliente = ?";
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
