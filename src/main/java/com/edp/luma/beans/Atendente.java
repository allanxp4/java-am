package com.edp.luma.beans;

import java.util.List;

public class Atendente implements Validator {
	private int id;
	private String nome;
	private String cpf;
	private String rg;
	private String endereco;
	private boolean ativo;
	private List<Atendimento> atendimentos;

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Atendente(String nome, String cpf, String rg, String endereco, boolean ativo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.ativo = ativo;
	}
	public Atendente() {
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
