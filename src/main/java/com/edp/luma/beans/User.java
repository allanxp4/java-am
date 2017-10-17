package com.edp.luma.beans;

import java.util.List;

public class User implements Validator{
	private int id;
	private String nome;
	private String login;
	private String senha;
	private boolean ativo;
	private boolean tipo;
	
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	public User(int id, String nome, String login, String senha, boolean ativo, boolean tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.ativo = ativo;
		this.tipo = tipo;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<String> validationErrors() {
		return null;
	}

	@Override
	public boolean checkValidation() {
		return false;
	}
}
