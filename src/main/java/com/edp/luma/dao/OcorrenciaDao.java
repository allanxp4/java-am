package com.edp.luma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edp.luma.beans.Ocorrencia;
import com.edp.luma.connection.ConnectionFactory;

public class OcorrenciaDao {
	private Connection con;
	
	//M�todo para conectar no banco
	public OcorrenciaDao() throws Exception {
		con =  ConnectionFactory.getConnection();
	}
	
	//M�todo para desconectar do banco
	public void fechar() throws Exception{
		con.close();
	}
	
	//M�todo para adicionar ocorr�ncia
	public boolean adicionar(Ocorrencia ocorrencia) throws Exception{
		int x;
		
		PreparedStatement estrutura = con.prepareStatement
											("INSERT INTO OCORRENCIAS" +
											"(TIPO_OCORRENCIA, CRITICIDADE, " +
											"SINTOMA, LOCAL_ID, DATA, TEMPO_TRATATIVA)" +
											"VALUES (?,?,?,?,?,?)");
		estrutura.setString(1, ocorrencia.getTipoOcorrencia());
		estrutura.setString(2, ocorrencia.getCriticidade());
		estrutura.setString(3, ocorrencia.getSintoma());
		estrutura.setInt(4, ocorrencia.getLocal_ID());
		estrutura.setString(5, ocorrencia.getData_formatada());
		estrutura.setString(6, ocorrencia.getTempoTratativa());
		//Pegar quantas linhas foram alteradas
		return estrutura.execute();
	}
	
	//M�todo para apagar ocorr�ncia
	public String apagarPorID(int id_ocorrencia) throws Exception{
		int x;
		
		PreparedStatement estrutura = con.prepareStatement("DELETE FROM OCORRENCIAS"+
										"WHERE OCORRENCIAS_ID = ?");
		estrutura.setInt(1, id_ocorrencia);
		x = estrutura.executeUpdate();
		
		return x + " ocorrencia(s) foi(ram) apagados(s)";
	}
	
	//M�todo para pepgar informa��es sobre uma ocorr�ncia
	public Ocorrencia getOcorrencia(int id_ocorrencia) throws Exception{
		Ocorrencia ocorrencia = new Ocorrencia();
		
		PreparedStatement estrutura = con.prepareStatement("SELECT * FROM OCORRENCIAS"+
										"WHERE OCORRENCIA_ID = ?");
		estrutura.setInt(1, id_ocorrencia);
		ResultSet resultado = estrutura.executeQuery();
		if(resultado.next()){
			ocorrencia.setTipoOcorrencia(resultado.getString("TIPO_OCORRENCIA"));
			ocorrencia.setCriticidade(resultado.getString("CRITICIDADE"));
			ocorrencia.setSintoma(resultado.getString("SINTOMA"));
			ocorrencia.setLocal_ID(resultado.getInt("LOCAL_ID"));
			ocorrencia.setData_formatada(resultado.getString("DATA"));
			ocorrencia.setTempoTratativa(resultado.getString("TEMPO_TRATATIVA"));
		}
		
		return ocorrencia;
	}

	public List<Ocorrencia> getAllOcorrencias() throws SQLException {
		List<Ocorrencia> ocorrencias = new ArrayList<>();

		LocalDao localDao = null;
		try {
			localDao = new LocalDao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		PreparedStatement estrutura = con.prepareStatement("SELECT * FROM OCORRENCIAS");
		ResultSet resultado = estrutura.executeQuery();
		while(resultado.next()){
			Ocorrencia ocorrencia = new Ocorrencia();
			ocorrencia.setTipoOcorrencia(resultado.getString("TIPO_OCORRENCIA"));
			ocorrencia.setCriticidade(resultado.getString("CRITICIDADE"));
			ocorrencia.setSintoma(resultado.getString("SINTOMA"));
			ocorrencia.setLocal_ID(resultado.getInt("LOCAL_ID"));
			ocorrencia.setData_formatada(resultado.getString("DATA"));
			ocorrencia.setTempoTratativa(resultado.getString("TEMPO_TRATATIVA"));
			ocorrencia.setLocal(localDao.getLocal(ocorrencia.getLocal_ID()));
			ocorrencias.add(ocorrencia);
		}
		return ocorrencias;


	}

	public String editar(Ocorrencia ocorrencia) throws Exception{
		
		int x;
		
		PreparedStatement estrutura = con.prepareStatement
				("UPDATE OCORRENCIAS" +
				"(TIPO_OCORRENCIA, CRITICIDADE, " +
				"SINTOMA, LOCAL_ID, DATA, TEMPO_TRATATIVA)" +
				"SET (?,?,?,?,?,?) WHERE OCORRENCIA_ID = ?");
		estrutura.setString(1, ocorrencia.getTipoOcorrencia());
		estrutura.setString(2, ocorrencia.getCriticidade());
		estrutura.setString(3, ocorrencia.getSintoma());
		estrutura.setInt(4, ocorrencia.getLocal_ID());
		estrutura.setString(5, ocorrencia.getData_formatada());
		estrutura.setString(6, ocorrencia.getTempoTratativa());
		estrutura.setInt(7, ocorrencia.getId_ocorrencia());

		//Pegar quantas linhas foram alteradas
		x = estrutura.executeUpdate();
		estrutura.close();

		return x+ " ocorrencia(s) foi(ram) adicionado(s)";
		
		
	}

	public List<Ocorrencia> getOcorrenciaByLocal() throws SQLException {
		List<Ocorrencia> ocorrencias = new ArrayList<>();

		LocalDao localDao = null;
		try {
			localDao = new LocalDao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		PreparedStatement estrutura = con.prepareStatement("SELECT * FROM OCORRENCIAS WHERE LOCAL_ID = ?");
		ResultSet resultado = estrutura.executeQuery();
		while(resultado.next()){
			Ocorrencia ocorrencia = new Ocorrencia();
			ocorrencia.setTipoOcorrencia(resultado.getString("TIPO_OCORRENCIA"));
			ocorrencia.setCriticidade(resultado.getString("CRITICIDADE"));
			ocorrencia.setSintoma(resultado.getString("SINTOMA"));
			ocorrencia.setLocal_ID(resultado.getInt("LOCAL_ID"));
			ocorrencia.setData_formatada(resultado.getString("DATA"));
			ocorrencia.setTempoTratativa(resultado.getString("TEMPO_TRATATIVA"));
			ocorrencia.setLocal(localDao.getLocal(ocorrencia.getLocal_ID()));
			ocorrencias.add(ocorrencia);
		}
		return ocorrencias;

	}
}
