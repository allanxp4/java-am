package com.edp.luma.bo;

import java.sql.SQLException;
import java.util.List;

import com.edp.luma.beans.Atendimento;
import com.edp.luma.dao.AtendimentoDao;
import com.google.gson.Gson;

public class AtendimentoBo {
	AtendimentoDao dao;
	Gson gson = new Gson();
	
	public AtendimentoBo() throws Exception{
		dao = new AtendimentoDao();
	}
	
	public String adicionarAtendimento(Atendimento atendimento){
	    if(atendimento.getAtendente_id() <= 0){
	        return "Atendente inválido.";
        }
        if(atendimento.getCliente_id() <= 0){
	        return "Cliente invalido.";
        }
		try {
            dao.adicionar(atendimento);
            return "Adicionado com sucesso.";
		} catch (SQLException e) {
		}
		return "Erro ao adicionar.";
	}

	public String adicionarAtendimento(String json){
		return adicionarAtendimento(gson.fromJson(json, Atendimento.class));
	}
	
	public boolean editarAtendimento(Atendimento atendimento){
		try {
			return dao.adicionar(atendimento);
		} catch (SQLException e) {	
		}
		return false;
	}
	
	public boolean removerAtendimento(Atendimento atendimento){
		try{
			return dao.apagar(atendimento);
		}
		catch(SQLException e){
			
		}
		return false;
	}
	
	public Atendimento buscarAtendimento(int id){
		try{
			return dao.getAtendimento(id);
		}
		catch(SQLException e){
			
		}
		return null;
	}
	
	public List<Atendimento> getTodosAtendimentos(){
		try{
			return dao.getAtendimentos();
		}
		catch(SQLException e){
			
		}
		return null;
	}
}
