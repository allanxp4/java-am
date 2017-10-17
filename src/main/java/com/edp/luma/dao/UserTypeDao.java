package com.edp.luma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.edp.luma.beans.UserType;
import com.edp.luma.connection.ConnectionFactory;


public class UserTypeDao {
	
	private Connection con;
	
	public UserTypeDao() throws Exception {
		con = ConnectionFactory.getConnection();
	}
	
	public void fechar() throws Exception {
		con.close();
	}
	
	public String addUserType(UserType type) throws Exception{
		PreparedStatement estrutura = con.prepareStatement("INSERT INTO EDP_USERTYPE (USERTYPEID, USERTYPE) VALUES (?,?)");
		estrutura.setInt(1, type.getUserTypeId());
		estrutura.setString(2, type.getUserType());
		
		
		int x = estrutura.executeUpdate();
		
		estrutura.close();
		
		return x + " Tipo(s) de usu�rio " + type.getUserType() + " gravado.";
	}
	
	public UserType getUserType(int idUserType) throws Exception {
		
		PreparedStatement estrutura 
		= con.prepareStatement("SELECT * FROM EDP_USERTYPE WHERE USERTYPEID = ?");
		estrutura.setInt(1, idUserType);
		
		ResultSet executar = estrutura.executeQuery();
		UserType userType = new UserType();
		
		if (executar.next()){
			userType.setUserTypeId(executar.getInt("USERTYPEID"));
			userType.setUserType(executar.getString("USERTYPE"));
		}
		
		executar.close();
		estrutura.close();
		return userType;
	}
	
	public int atualizarModoUsuario (int userTypeId, String userType) throws Exception{
		PreparedStatement estrutura = 
				con.prepareStatement("UPDATE EDP_USERTYPE SET USERTYPE = ? WHERE USERTYPEID = ?");
		estrutura.setString(1, userType);
		estrutura.setInt(2, userTypeId);
		int x = estrutura.executeUpdate();
		estrutura.close();
		return x;
	}
	
	public int apagarModoUsuario (int userTypeId) throws Exception {
		PreparedStatement estrutura = 
				con.prepareStatement("DELETE FROM EDP_USERTYPE WHERE USERTYPEID = ?");
		estrutura.setInt(1, userTypeId);
		int x = estrutura.executeUpdate();
		estrutura.close();
		return x;
	}
}
