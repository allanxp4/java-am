package com.edp.luma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edp.luma.beans.Atendente;
import com.edp.luma.beans.Atendimento;
import com.edp.luma.connection.ConnectionFactory;

public class AtendenteDao {
private Connection conn;
	
	public AtendenteDao() throws Exception {
		conn =  ConnectionFactory.getConnection();
	}
	
	public boolean adicionar(Atendente atendente) throws SQLException{
		String sql = "INSERT INTO atendentes (nome, cpf, rg, endereco, ativo)"
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, atendente.getNome());
		stmt.setString(2, atendente.getCpf());
		stmt.setString(3, atendente.getRg());
		stmt.setString(4, atendente.getEndereco());
		stmt.setBoolean(5, atendente.isAtivo());
		return stmt.execute();

	}
	
	public boolean editar(Atendente atendente) throws SQLException{
		String sql = "UPDATE atendentes (nome, cpf, rg, endereco, ativo)"
				+ "SET (?, ?, ?, ?, ?) WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, atendente.getNome());
		stmt.setString(2, atendente.getCpf());
		stmt.setString(3, atendente.getRg());
		stmt.setString(4, atendente.getEndereco());
		stmt.setBoolean(5, atendente.isAtivo());
		return stmt.execute();
	}
	
	public boolean apagar(Atendente atendente) throws SQLException{
		String sql = "DELETE FROM atendentes WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		return stmt.execute();
	}
	
	public Atendente getAtendente(int id) throws SQLException{
		String sql = "SELECT * FROM atendentes WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet set = stmt.executeQuery();
	
		Atendente atendente = new Atendente();
		if(set.next()){
			atendente.setId(set.getInt("id"));
			atendente.setNome(set.getString("nome"));
			atendente.setCpf(set.getString("cpf"));
			atendente.setRg(set.getString("rg"));
			atendente.setEndereco(set.getString("endereco"));
			atendente.setAtivo(set.getBoolean("ativo"));
		}
		
		return atendente;
	}
	
	public List<Atendente> getAtendentes() throws SQLException{
		String sql = "SELECT * FROM atendentes";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet set = stmt.executeQuery();
        AtendimentoDao dao = null;
        try {
            dao = new AtendimentoDao();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Atendente> atendentes = new ArrayList<>();
		while(set.next()){
			Atendente atendente = new Atendente();
			atendente.setId(set.getInt("id"));
			atendente.setNome(set.getString("nome"));
			atendente.setCpf(set.getString("cpf"));
			atendente.setRg(set.getString("rg"));
			atendente.setEndereco(set.getString("endereco"));
			atendente.setAtivo(set.getBoolean("ativo"));
            List<Atendimento> atendimentosByAtendente = dao.getAtendimentosByAtendente(atendente.getId());
            atendente.setAtendimentos(atendimentosByAtendente);
            atendentes.add(atendente);
		}
		
		return atendentes;
	}
}
