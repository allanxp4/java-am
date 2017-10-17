package com.edp.luma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.edp.luma.beans.UserPermission;
import com.edp.luma.connection.ConnectionFactory;

public class UserPermissionDao {
	private Connection conn;

		public UserPermissionDao() throws Exception{
			conn = ConnectionFactory.getConnection();
			
		}
		public boolean avaliar(UserPermission permissao) throws SQLException{
			String sql = "SELECT ID FROM USER_PERMISSIONS WHERE ID = ? AND TIPO_PESSOA =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, permissao.getUserId());
			stmt.setString(2, permissao.getTipoPessoa());
			return stmt.execute();
		}
	
		public boolean adicionarPermissao(UserPermission permissao) throws SQLException{
			String sql = "INSERT INTO USER_PERMISSIONS (TIPO_PERMISSAO, TIPO_PESSOA)"
					+ "VALUES (?, ?)";;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, permissao.getNivelPermissao());
			stmt.setString(2, permissao.getTipoPessoa());
			return stmt.execute();
		}
		
		public boolean alterarPermissao(UserPermission permissao) throws SQLException{
			String sql = "UPDATE USER_PERMISSIONS SET TIPO_PERMISSAO = ?"
					+ " WHERE ID = ? AND TIPO_PESSOA = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(2, permissao.getUserId());
			stmt.setInt(1, permissao.getNivelPermissao());
			stmt.setString(3, permissao.getTipoPessoa());
			return stmt.execute();
		}
		
		public boolean removerPermissao(UserPermission permissao) throws SQLException{
			String sql = "DELETE FROM USER_PERMISSIONS WHERE ID = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, permissao.getUserId());
			return stmt.execute();
		}
		
		
		
}
