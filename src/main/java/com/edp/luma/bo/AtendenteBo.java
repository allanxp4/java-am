package com.edp.luma.bo;

import java.sql.SQLException;
import java.util.List;

import com.edp.luma.beans.Atendente;
import com.edp.luma.dao.AtendenteDao;

public class AtendenteBo {
	AtendenteDao dao;
	
	public AtendenteBo() throws Exception{
		dao = new AtendenteDao();
	}
	
	public boolean adicionarAtendente(Atendente atendente){
		try {
			return dao.adicionar(atendente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean editarAtendente(Atendente atendente){
		try {
			return dao.adicionar(atendente);
		} catch (SQLException e) {	
		}
		return false;
	}
	
	public boolean removerAtendente(Atendente atendente){
		try{
			return dao.apagar(atendente);
		}
		catch(SQLException e){
			
		}
		return false;
	}
	
	public Atendente buscarAtendente(int id){
		try{
			return dao.getAtendente(id);
		}
		catch(SQLException e){
			
		}
		return null;
	}
	
	public List<Atendente> getTodosAtendentes(){
		try{
			return dao.getAtendentes();
		}
		catch(SQLException e){
			
		}
		return null;
	}
}
