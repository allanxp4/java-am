package com.edp.luma.beans;

import java.sql.Date;
import java.util.List;

public class Atendimento implements Validator{
	private int atendente_id;
	private int cliente_id;
	private int local_id;
	private int ocorrencia_id;
	private float temp_atendimento;
	private Date date;
	private String avaliacao;
	private Atendente atendente;
	private Ocorrencia ocorrencia;
	private Cliente cliente;

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getAtendente_id() {
		return atendente_id;
	}
	public void setAtendente_id(int atendente_id) {
		this.atendente_id = atendente_id;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public int getLocal_id() {
		return local_id;
	}
	public void setLocal_id(int local_id) {
		this.local_id = local_id;
	}
	public int getOcorrencia_id() {
		return ocorrencia_id;
	}
	public void setOcorrencia_id(int ocorrencia_id) {
		this.ocorrencia_id = ocorrencia_id;
	}
	public float getTemp_atendimento() {
		return temp_atendimento;
	}
	public void setTemp_atendimento(float temp_atendimento) {
		this.temp_atendimento = temp_atendimento;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public Atendimento() {
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
