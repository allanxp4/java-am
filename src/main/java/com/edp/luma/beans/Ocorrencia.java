package com.edp.luma.beans;

import java.util.List;

public class Ocorrencia implements Validator {
	
	private int id_ocorrencia;
	private String tipoOcorrencia;
	private String criticidade;
	private String sintoma;
	private int local_id;
	private String tempoTratativa;
	private String data_formatada;
	private Atendimento atendimento;
	private Local local;
	private Cliente cliente;




	
	
	public Ocorrencia(String tipoOcorrencia, String criticidade, String sintoma, int local_id,
			String tempoTratativa) {
		super();
		this.tipoOcorrencia = tipoOcorrencia;
		this.criticidade = criticidade;
		this.sintoma = sintoma;
		this.local_id = local_id;
		this.tempoTratativa = tempoTratativa;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Ocorrencia() {
	}

	public int getLocal_id() {
		return local_id;
	}

	public void setLocal_id(int local_id) {
		this.local_id = local_id;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public int getId_ocorrencia(){
		return id_ocorrencia;
	}
	
	public void setId_ocorrencia(int id_ocorrencia){
		this.id_ocorrencia = id_ocorrencia;
	}

	public String getTipoOcorrencia() {
		return tipoOcorrencia;
	}
	
	public void setTipoOcorrencia(String tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}
	
	public String getCriticidade() {
		return criticidade;
	}
	
	public void setCriticidade(String criticidade) {
		this.criticidade = criticidade;
	}
	
	public String getSintoma() {
		return sintoma;
	}
	
	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}
	
	public int getLocal_ID() {
		return local_id;
	}
	
	public void setLocal_ID(int local_id) {
		this.local_id = local_id;
	}
	
	public String getData_formatada(){
		return data_formatada;
	}
	
	public void setData_formatada(String data_formatada) {
		this.data_formatada = data_formatada;
	}
	
	public String getTempoTratativa() {
		return tempoTratativa;
	}
	
	public void setTempoTratativa(String tempoTratativa) {
		this.tempoTratativa = tempoTratativa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

