package com.edp.luma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edp.luma.beans.User;
import com.edp.luma.connection.ConnectionFactory;

public class UserDao {
private Connection conn;
	
	public UserDao() throws Exception {
		conn =  ConnectionFactory.getConnection();
	}
	
	public boolean adicionar(User user) throws SQLException{
		String sql = "INSERT INTO Users (id, nome, login, senha, ativo, tipo)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, user.getId());
		stmt.setString(2, user.getNome());
		stmt.setString(3, user.getLogin());
		stmt.setString(4, user.getSenha());
		stmt.setBoolean(5, user.isAtivo());
		stmt.setBoolean(6, user.isTipo());
		return stmt.execute();
	}
	
	public boolean editar(User user) throws SQLException{
		String sql = "UPDATE Users (nome, login, senha, ativo, tipo)"
				+ "SET (?, ?, ?, ?, ?, ?) WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, user.getId());
		stmt.setString(2, user.getNome());
		stmt.setString(3, user.getLogin());
		stmt.setString(4, user.getSenha());
		stmt.setBoolean(5, user.isAtivo());
		stmt.setBoolean(6, user.isTipo());
		return stmt.execute();
	}
	
	public boolean apagar(User user) throws SQLException{
		String sql = "DELETE FROM Users WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		return stmt.execute();
	}
	
	public User getUser(int id) throws SQLException{
		String sql = "SELECT * FROM Users WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet set = stmt.executeQuery();
	
		User user = new User();
		if(set.next()){
			user.setId(set.getInt("id"));
			user.setNome(set.getString("nome"));
			user.setLogin(set.getString("login"));
			user.setSenha(set.getString("senha"));
			user.setAtivo(set.getBoolean("ativo"));
			user.setTipo(set.getBoolean("tipo"));
		}
		
		return user;
	}
	
	public List<User> getUsers() throws SQLException{
		String sql = "SELECT * FROM Users";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet set = stmt.executeQuery();
	
		List<User> Users = new ArrayList<>();
		while(set.next()){
			User user = new User();
			user.setId(set.getInt("id"));
			user.setNome(set.getString("nome"));
			user.setLogin(set.getString("login"));
			user.setSenha(set.getString("senha"));
			user.setAtivo(set.getBoolean("ativo"));
			user.setTipo(set.getBoolean("tipo"));
			Users.add(user);
		}
		
		return Users;
	}
}
