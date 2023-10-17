package com.agenciadeviagem.principal;

public class Destinos {

	private int id;
	private String nome;
	private String descricao;
	private String pais;
	

	public Destinos(int id, String nome, String descricao, String pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.pais = pais;
	}

	public Destinos() {

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
