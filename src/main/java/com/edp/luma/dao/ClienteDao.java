package com.edp.luma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edp.luma.beans.Cliente;
import com.edp.luma.beans.Local;
import com.edp.luma.connection.ConnectionFactory;

public class ClienteDao {
	private Connection con;
	
	public ClienteDao() throws Exception {
		con =  ConnectionFactory.getConnection();
	}
	public void fechar()throws Exception{
		con.close();
	}
	
	public String adicionar(Cliente cliente, Local local) throws SQLException{
		String sql = "INSERT INTO cliente (id, nome, email, telefone, cpf, login, senha, local)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement estrutura = con.prepareStatement(sql);
		estrutura.setInt(1, cliente.getId());
		estrutura.setString(2, cliente.getNome());
		estrutura.setString(3, cliente.getEmail());
		estrutura.setString(4, cliente.getTelefone());
		estrutura.setString(5, cliente.getCpf());
		estrutura.setString(6, cliente.getLogin());
		estrutura.setString(7, cliente.getSenha());
		estrutura.setInt(8, local.getid());
		int x = estrutura.executeUpdate();
		estrutura.close();
		return x + " cliente(s) foi(ram) adicionado(s)";
	}
	
	public String atualizar(Cliente cliente,Local local) throws SQLException{
		String sql = "UPDATE cliente (id, nome, email, telefone, cpf, login, senha, local)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement estrutura = con.prepareStatement(sql);
		estrutura.setInt(1, cliente.getId());
		estrutura.setString(2, cliente.getNome());
		estrutura.setString(3, cliente.getEmail());
		estrutura.setString(4, cliente.getTelefone());
		estrutura.setString(5, cliente.getCpf());
		estrutura.setString(6, cliente.getLogin());
		estrutura.setString(7, cliente.getSenha());
		estrutura.setInt(8, local.getid());
		int x = estrutura.executeUpdate();
		estrutura.close();		
		return x + " cliente(s) foi(ram) atualizado(s)";

	}
	public String apagar(Cliente cliente) throws SQLException{
		String sql = "DELETE FROM cliente WHERE id = ?";
		PreparedStatement estrutura = con.prepareStatement(sql);
		int x = estrutura.executeUpdate();
		estrutura.close();
		return x + "cliente(s) foi(ram) apagado(s)";
	}
	public Cliente getCliente(int id) throws SQLException{
		String sql = "SELECT * FROM cliente WHERE id = ?";
		PreparedStatement estrutura = con.prepareStatement(sql);
		estrutura.setInt(1, id);
		ResultSet set = estrutura.executeQuery();
	
		Cliente cliente = new Cliente();
		Local local = new Local();
		if(set.next()){
			cliente.setId(set.getInt("id"));
			cliente.setNome(set.getString("nome"));
			cliente.setEmail(set.getString("email"));
			cliente.setTelefone(set.getString("telefone"));
			cliente.setCpf(set.getString("cpf"));
			local.setid(set.getInt("local Id"));
		}
		estrutura.close();
		set.close();
		return cliente;
	}
		public List<Cliente> getClientes() throws SQLException{
			String sql = "SELECT * FROM clientes";
			PreparedStatement estrutura = con.prepareStatement(sql);
			ResultSet set = estrutura.executeQuery();
		
			List<Cliente> clientes = new ArrayList<>();
			while(set.next()){
				Cliente cliente = new Cliente();
				Local local = new Local();
				cliente.setId(set.getInt("id"));
				cliente.setNome(set.getString("nome"));
				cliente.setEmail(set.getString("email"));
				cliente.setTelefone(set.getString("telefone"));
				cliente.setCpf(set.getString("cpf"));
				local.setid(set.getInt("local id"));
				clientes.add(cliente);
			}
		
		return clientes;
	}
}