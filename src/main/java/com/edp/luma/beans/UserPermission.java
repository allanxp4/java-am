package com.edp.luma.beans;

import java.util.List;

public class UserPermission implements Validator{
	private int userId;
	private int nivelPermissao;
	private String tipoPessoa;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNivelPermissao() {
		return nivelPermissao;
	}
	public void setNivelPermissao(int nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	
	public UserPermission(int userId, int nivelPermissao, String tipoPessoa) {
		super();
		this.userId = userId;
		this.nivelPermissao = nivelPermissao;
		this.tipoPessoa = tipoPessoa;
	}
	public UserPermission() {
		super();
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
