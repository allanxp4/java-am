package com.edp.luma.beans;

import java.util.List;

public class Cliente implements Validator{
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private String login;
	private String senha;
	private Local local;
	private List<Ocorrencia> ocorrencias;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public Cliente(int id, String nome, String email, String telefone, String cpf,String login ,String senha, Local local) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		this.local = local;
	}
	public Cliente() {
		super();
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
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
