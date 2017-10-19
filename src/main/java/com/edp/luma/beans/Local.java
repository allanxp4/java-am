package com.edp.luma.beans;

import java.util.List;

public class Local implements Validator{
	private String pais;
	private String cidade;
	private String bairro;
	private String rua;
	private int n_residencia;
	private int id;
	private List<Ocorrencia> ocorrencias;

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public String getpais(){
	  return  pais;
  }
   public void setpais(String pais){
	  this.pais = pais;
  }
   
   public String getcidade(){
	   return cidade;
   }
   public void setcidade(String cidade){
	   this.cidade = cidade;
   }
    
   public String getbairro(){
	   return bairro;
   }
   
   public void setbairro(String bairro){
	   this.bairro = bairro;
   }

    public String getrua(){
    	return rua;
    }
    public void setrua(String rua){
    	this.rua = rua;
    }
    
    public int getn_residencia(){
    	return n_residencia;
    }
    
    public void setn_residencia(int n_residencia){
    	this.n_residencia = n_residencia;
    }
    
    public int getid(){
    	return id;
    }
    public void setid(int id){
    	this.id = id;
    }
    
    
    public Local (String pais,String cidade, String bairro, String rua, int n_residencia){
    	super();
    	this.pais = pais;
    	this.cidade = cidade;
    	this.bairro = bairro;
    	this.rua = rua;
    	this.n_residencia = n_residencia;
    }
	public Local() {
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
