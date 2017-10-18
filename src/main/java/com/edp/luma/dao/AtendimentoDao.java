package com.edp.luma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edp.luma.beans.Atendente;
import com.edp.luma.beans.Atendimento;
import com.edp.luma.beans.Cliente;
import com.edp.luma.beans.Local;
import com.edp.luma.beans.Ocorrencia;
import com.edp.luma.connection.ConnectionFactory;

public class AtendimentoDao {
private Connection conn;
	
	public AtendimentoDao() throws Exception {
		conn =  ConnectionFactory.getConnection();
	}
	
	public boolean adicionar(Atendimento atendimento) throws SQLException{
		String sql = "INSERT INTO atendimentos (atendente_id,cliente_id,local_id,ocorrencia_id,temp_atendimento,data,avaliacao)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, atendimento.getAtendente_id());
		stmt.setInt(2, atendimento.getCliente_id());
		stmt.setInt(3, atendimento.getLocal_id());
		stmt.setInt(4, atendimento.getOcorrencia_id());
		stmt.setFloat(5, atendimento.getTemp_atendimento());
		stmt.setDate(6, atendimento.getDate());
		stmt.setString(7, atendimento.getAvaliacao());
		return stmt.execute();
	}
	
	public boolean editar(Atendimento atendimento) throws SQLException{
		String sql = "UPDATE atendimentos (atendente_id,cliente_id,local_id,ocorrencia_id,temp_atendimento,data,avaliacao)"
				+ "SET (?, ?, ?, ?, ?, ?, ?) WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, atendimento.getAtendente_id());
		stmt.setInt(2, atendimento.getCliente_id());
		stmt.setInt(3, atendimento.getLocal_id());
		stmt.setInt(4, atendimento.getOcorrencia_id());
		stmt.setFloat(5, atendimento.getTemp_atendimento());
		stmt.setDate(6, atendimento.getDate());
		stmt.setString(7, atendimento.getAvaliacao());
		return stmt.execute();
	}
	
	public boolean apagar(Atendimento atendimento) throws SQLException{
		String sql = "DELETE FROM atendimentos WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		return stmt.execute();
	}
	
	public Atendimento getAtendimento(int id) throws SQLException{
		String sql = "SELECT * FROM atendimentos WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet set = stmt.executeQuery();
	
		Atendimento atendimento = new Atendimento();
		if(set.next()){
			atendimento.setAtendente_id(set.getInt("antendente_id"));
			atendimento.setCliente_id(set.getInt("cliente_id"));
			atendimento.setLocal_id(set.getInt("local_id"));
			atendimento.setOcorrencia_id(set.getInt("ocorrencia_id"));
			atendimento.setTemp_atendimento(set.getFloat("temp_atendimento"));
			atendimento.setDate(set.getDate("date"));
		}
		
		return atendimento;
	}
	
	public List<Atendimento> getAtendimentos() throws SQLException{
		String sql = "SELECT * FROM atendimentos";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet set = stmt.executeQuery();
	
		List<Atendimento> atendimentos = new ArrayList<>();
		while(set.next()){
			Atendimento atendimento = new Atendimento();
			atendimento.setAtendente_id(set.getInt("atendente_id"));
			atendimento.setCliente_id(set.getInt("cliente_id"));
			atendimento.setLocal_id(set.getInt("local_id"));
			atendimento.setOcorrencia_id(set.getInt("ocorrencia_id"));
			atendimento.setTemp_atendimento(set.getFloat("temp_atendimento"));
			atendimento.setDate(set.getDate("data"));
			atendimentos.add(atendimento);
		}
		
		return atendimentos;
	}
}
