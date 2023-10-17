package com.agenciadeviagem.principal;

import java.sql.Date;

public class Reservas {

	private int id;
	private Date dataReserva;
	private Clientes clientes;
	private Destinos destinos;
	private int valor;

	public Reservas(int id, Date dataReserva, Clientes clientes, Destinos destinos, int valor) {
		super();
		this.id = id;
		this.dataReserva = dataReserva;
		this.clientes = clientes;
		this.destinos = destinos;
		this.valor = valor;
	}

	public Reservas() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Destinos getDestinos() {
		return destinos;
	}

	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
