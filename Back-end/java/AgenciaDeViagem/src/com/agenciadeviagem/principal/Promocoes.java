package com.agenciadeviagem.principal;

import java.sql.Date;

public class Promocoes {

	private int id;
	private String nome;
	private Date dataValidade;
	private int desconto;
	private Destinos destinos;

	

	public Promocoes(int id, String nome, Date dataValidade, int desconto, Destinos destinos) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataValidade = dataValidade;
		this.desconto = desconto;
		this.destinos = destinos;
	}

	public Promocoes() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public Destinos getDestinos() {
		return destinos;
	}

	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}



}
