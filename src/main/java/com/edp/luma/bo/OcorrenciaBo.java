package com.edp.luma.bo;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.edp.luma.beans.Ocorrencia;
import com.edp.luma.dao.OcorrenciaDao;

public class OcorrenciaBo {
	
	public static String adicionarOcorrencia(Ocorrencia ocorrencia) throws Exception{
		
		//PADRONIZA��O
		ocorrencia.setCriticidade(ocorrencia.getCriticidade().toUpperCase());
		ocorrencia.setSintoma(ocorrencia.getSintoma().toUpperCase());
		ocorrencia.setTipoOcorrencia(ocorrencia.getTipoOcorrencia().toUpperCase());
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String data = formatador.format( new Date() );
		ocorrencia.setData_formatada(data);
		
		//REGRA DE NEG�CIO
		//Valida��o quantidade de caracteres do sintoma
		if (ocorrencia.getSintoma().length() > 50 ){
			return "Sintoma excedeu a quantidade de caracteres";
		}
		
		String[] ArrayCriticidade = {"BAIXO","M�DIO" ,"ALTO" ,"CR�TICO"};
		
		List<String> lista = Arrays.asList(ArrayCriticidade);
		
		if(ocorrencia.getCriticidade() == "" || !lista.contains(ocorrencia.getCriticidade())){
			return "Criticidade informada est� inv�lida";
		}
		
		OcorrenciaDao dao = new OcorrenciaDao();
		dao.adicionar(ocorrencia);
		dao.fechar();
		return "Ok";
		
	}
	
	public static String apagarOcorrencia(int id_ocorrencia) throws Exception{
		
		if(id_ocorrencia <= 0){
			return "N�mero da ocorrencia incorreto";
		}
		
		OcorrenciaDao dao = new OcorrenciaDao();
		String retorno = dao.apagarPorID(id_ocorrencia);
		dao.fechar();
		return retorno;
		
	}
	
	public static Ocorrencia consultarOcorrencia(int id_ocorrencia) throws Exception{
		
		if(id_ocorrencia <= 0){
			return new Ocorrencia();
		}
		
		OcorrenciaDao dao = new OcorrenciaDao();
		Ocorrencia retorno = dao.getOcorrencia(id_ocorrencia);
		dao.fechar();
		return retorno;
			
	}
	
	
	public static String editarOcorrencia(Ocorrencia ocorrencia) throws Exception{
		
		//PADRONIZA��O
		ocorrencia.setCriticidade(ocorrencia.getCriticidade().toUpperCase());
		ocorrencia.setSintoma(ocorrencia.getSintoma().toUpperCase());
		ocorrencia.setTipoOcorrencia(ocorrencia.getTipoOcorrencia().toUpperCase());
					
				
				
				
		//Validar se ID da ocorr�ncia � v�lido
		if(ocorrencia.getId_ocorrencia() <= 0){
			return "ID da ocorr�ncia inv�lido";
		}
		
		
		//Validar formata��o da data	
		Integer.parseInt(ocorrencia.getData_formatada().substring(0, 2));
		if(ocorrencia.getData_formatada().substring(2, 2) != "/"){
			return "Data informada inv�lida";
		}
		Integer.parseInt(ocorrencia.getData_formatada().substring(3, 5));
		if(ocorrencia.getData_formatada().substring(5, 5) != "/"){
			return "Data informada inv�lida";
		}
		Integer.parseInt(ocorrencia.getData_formatada().substring(6, 10));
		
		
		//Verificar se h� algo no sintoma
		if(ocorrencia.getSintoma() == "" ){
			return "Sintoma inv�lido";
		}
		
		//Verificar se sintoma n�o tem mais de 50 caracteres
		if (ocorrencia.getSintoma().length() > 50 ){
			return "Sintoma excedeu a quantidade de caracteres";
		}
		
		
		//Validar se a criticidade setada est� nos par�metros exigidos
		String[] ArrayCriticidade = {"BAIXO","M�DIO" ,"ALTO" ,"CR�TICO"};
		
		List<String> lista = Arrays.asList(ArrayCriticidade);
		
		if(ocorrencia.getCriticidade() == "" || lista.contains(ocorrencia.getCriticidade())){
			return "Criticidade informada est� inv�lida";
		}
		
		
		
			
		OcorrenciaDao dao = new OcorrenciaDao();
		String x = dao.editar(ocorrencia);
		dao.fechar();
		return x;
		
	}
		

}


