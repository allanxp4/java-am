package com.edp.luma.bo;

import java.util.List;

import com.edp.luma.beans.Cliente;
import com.edp.luma.dao.ClienteDao;

public class ClienteBo {
	ClienteDao dao;
	
	public ClienteBo() throws Exception{
		dao = new ClienteDao();
	}
	
	public String novoCliente(Cliente cliente)throws Exception{
		if(cliente.getNome().length()>50){
			return "Nome execedeu a quantidade de caracteres";
		}
		if(cliente.getCpf().length()!=11){
			return "Cpf inv�lido";
		}
		if(cliente.getEmail().contentEquals("@")==false){
			return "E-mail inv�lido";
		}
		if(cliente.getId()<=0){
			return "Id inv�lido";
		}
		if(cliente.getTelefone().length()<8 || cliente.getTelefone().length()>22){
			return "Telefone inv�lido";
		}
		else{
		cliente.setNome(cliente.getNome().toUpperCase());
		String x = dao.adicionar(cliente, null);
		dao.fechar();
		return x;
		}
	}
	
	public String atualizarCliente(Cliente cliente)throws Exception{
		if(cliente.getNome().length()>50){
			return "Nome execedeu a quantidade de caracteres";
		}
		if(cliente.getCpf().length()!=11){
			return "Cpf inv�lido";
		}
		if(cliente.getEmail().contentEquals("@")==false){
			return "E-mail inv�lido";
		}
		if(cliente.getId()<=0){
			return "Id inv�lido";
		}
		if(cliente.getTelefone().length()<8 || cliente.getTelefone().length()>22){
			return "Telefone inv�lido";
		}
		else{
			cliente.setNome(cliente.getNome().toUpperCase());
			String x = dao.atualizar(cliente, null);
			dao.fechar();
			return x;
		}
	}
			
		public String removerCliente(Cliente cliente)throws Exception{
			if(cliente.getId()<=0){
				return "Id inv�lido";
			}else{
				cliente.setNome(cliente.getNome().toUpperCase());
				String x = dao.apagar(cliente);
				dao.fechar();
				return x;
			}
		}
		
		public Cliente buscarCliente(int id)throws Exception{
		{
				Cliente x = dao.getCliente(id);
				dao.fechar();
				return x;
				
			}
		
		}
		
		public List<Cliente> getTodosClientes() throws Exception{
			{
				return dao.getClientes();
			}
		
		}
	
		
	}
