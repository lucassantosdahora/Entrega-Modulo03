package com.agenciadeviagem.DAO;

import com.agenciadeviagem.principal.Clientes;
import com.agenciadeviagem.principal.Destinos;
import com.agenciadeviagem.principal.Reservas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agenciadeviagem.connection.Conexao;

public class ReservasDAO {

	private Connection conexao;

	ClientesDAO clientesDAO = new ClientesDAO();
	DestinosDAO destinosDAO = new DestinosDAO();

	public ReservasDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void registrarReservas(Reservas reservas) {
		String sql = "INSERT INTO reservas(dataReserva,Id_Cliente,Id_Destino,valor) VALUES(?,?,?,?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setTimestamp(1, new java.sql.Timestamp(reservas.getDataReserva().getTime()));
			stmt.setInt(2, reservas.getClientes().getId());
			stmt.setInt(3, reservas.getDestinos().getId());
			stmt.setInt(4, reservas.getValor());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Reservas> listaReservas() {
		List<Reservas> reservas = new ArrayList<>();
		String sql = "SELECT * FROM reservas";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet retorno = stmt.executeQuery();

			while (retorno.next()) {
				Reservas reserva = new Reservas();
				int reservaId = retorno.getInt("Id_Reserva");
				reserva.setId(reservaId);
				reserva.setDataReserva(retorno.getDate("dataReserva"));
				int clienteId = retorno.getInt("Id_Cliente");
				int destinoId = retorno.getInt("Id_Destino");
				Clientes cliente = clientesDAO.buscarClientes(clienteId);
				Destinos destino = destinosDAO.buscarDestinos(destinoId);
				reserva.setClientes(cliente);
				reserva.setDestinos(destino);
				reserva.setValor(retorno.getInt("valor"));
				reservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reservas;
	}

	public Reservas buscarReservas(int id) {
		Reservas reserva = null;
		String sql = "SELECT * FROM reservas WHERE Id_Reserva = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet retorno = stmt.executeQuery();
			if (retorno.next()) {
				reserva = new Reservas();
				reserva.setId(id);
				reserva.setDataReserva(retorno.getDate("dataReserva"));
				int clienteId = retorno.getInt("Id_Cliente");
				Clientes cliente = clientesDAO.buscarClientes(clienteId);
				reserva.setClientes(cliente);
				int destinoId = retorno.getInt("Id_Destino");
				Destinos destino = destinosDAO.buscarDestinos(destinoId);
				reserva.setDestinos(destino);
				reserva.setValor(retorno.getInt("valor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reserva;
	}

	public void atualizarReservas(Reservas reservas) {
		String sql = "UPDATE reservas SET dataReserva = ?, Id_Cliente = ?, Id_Destino = ?, valor = ? WHERE Id_Reserva= ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setTimestamp(1, new java.sql.Timestamp(reservas.getDataReserva().getTime()));
			stmt.setInt(2, reservas.getClientes().getId());
			stmt.setInt(3, reservas.getDestinos().getId());
			stmt.setInt(4, reservas.getValor());
			stmt.setInt(5, reservas.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirReserva(int id) {
		String sql = "DELETE FROM reservas WHERE Id_Reserva = ?";
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
