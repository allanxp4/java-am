package com.edp.luma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edp.luma.beans.Atendente;
import com.edp.luma.beans.Local;
import com.edp.luma.connection.ConnectionFactory;

public class LocalDao {
	private Connection conn;
	
	public LocalDao() throws Exception {
		conn = ConnectionFactory.getConnection();
	}
	  public boolean adicionar( Local local) throws SQLException{
		  String sql = "INSERT INTO locais (pais,cidade,bairro,rua,n_residencia)"
				       + "VALUES (?,?,?,?,?)";
		  
		  PreparedStatement stmt = conn.prepareStatement(sql);
		  stmt.setString(1, local.getpais());
			stmt.setString(2, local.getcidade());
			stmt.setString(3, local.getbairro());
			stmt.setString(4, local.getrua());
			stmt.setInt(5, local.getn_residencia());
			return stmt.execute();
	  }

	  public boolean editar(Local local) throws SQLException{
			String sql = "UPDATE locais (pais,cidade,bairro,rua,n_residencia,id)"
					+ "SET (?, ?, ?, ?, ?) WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, local.getpais());
			stmt.setString(2, local.getcidade());
			stmt.setString(3, local.getbairro());
			stmt.setString(4, local.getrua());
			stmt.setInt(5, local.getn_residencia());
			return stmt.execute();
		}


	  public boolean remover(Local local) throws SQLException{
			String sql = "DELETE FROM locais WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			return stmt.execute();
		}

	  
	  public Local getLocal(int id) throws SQLException{

		  OcorrenciaDao dao = null;
		  try {
			  dao = new OcorrenciaDao();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }

		  String sql = "SELECT * FROM locais WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet set = stmt.executeQuery();
		
			Local local = new Local();
			if(set.next()){
				local.setpais(set.getString("pais"));
				local.setcidade(set.getString("cidade"));
				local.setbairro(set.getString("bairro"));
				local.setrua(set.getString("rua"));
				local.setn_residencia(set.getInt("n_residencia"));
				local.setid(set.getInt("id"));
				local.setOcorrencias(dao.getOcorrenciaByLocal());
			}
			
			return local;
		}
	  public List<Local> getLocal() throws SQLException{
			String sql = "SELECT * FROM locais";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet set = stmt.executeQuery();
		
			List<Local> locais = new ArrayList<>();
			while(set.next()){
				Local local = new Local();				
				local.setpais(set.getString("pais"));
				local.setcidade(set.getString("cidade"));
				local.setbairro(set.getString("bairro"));
				local.setrua(set.getString("rua"));
				local.setn_residencia(set.getInt("n_residencia"));
				local.setid(set.getInt("id"));
				
				locais.add(local);
				
			}
			
			return  locais;
		}
            

}
