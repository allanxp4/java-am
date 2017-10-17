package com.edp.luma.bo;

import javax.swing.JOptionPane;

import com.edp.luma.beans.UserType;
import com.edp.luma.dao.UserTypeDao;



public class UserTypeBo {
	public static String novoTipoUsuario(UserType tipoUsuario) throws Exception {
		if( tipoUsuario.getUserTypeId() < 0){
			return "Voc� colocou um valor negativo, leia a documenta��o";
		} if (tipoUsuario.getUserType().length() > 11){
			return "Voc� colocou um tipo muito grande, leia a documenta��o";
		}
		UserTypeDao dao = new UserTypeDao();
		String x = dao.addUserType(tipoUsuario);
		dao.fechar();
		return x;
	}
	
	public static UserType lerTipoUsuarios(int numero) throws Exception {
		if ( numero < 0){
			JOptionPane.showMessageDialog(null, "Voc� colocou um valor negativo, leia a documenta��o", "Erro", JOptionPane.ERROR_MESSAGE);
			return new UserType();
		}
		 UserType tipoUsuario = new UserType();
		 UserTypeDao dao = new UserTypeDao();
		 tipoUsuario = dao.getUserType(numero);
		 dao.fechar();
		 return tipoUsuario;
	}
	
	public static int atualizarTipoUsuario(int numero, String tipoUsuario) throws Exception {
		if ( numero < 0){
			JOptionPane.showMessageDialog(null, "Voc� colocou um valor negativo, leia a documenta��o", "Erro", JOptionPane.ERROR_MESSAGE);
			return 0;
		} if( tipoUsuario.length() > 11 ) {
			JOptionPane.showMessageDialog(null, "Tipo de usuario invalido invalido, leia a documenta��o", "Erro", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		
		UserTypeDao dao = new UserTypeDao();
		
		dao.atualizarModoUsuario(numero, tipoUsuario);
		
		dao.fechar();
		return numero;
	}
	
	public static int apagarTipoUsuario(int numero) throws Exception {
		if ( numero < 0){
			JOptionPane.showMessageDialog(null, "Voc� colocou um valor negativo, leia a documenta��o", "Erro", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		UserTypeDao dao = new UserTypeDao();
		dao.apagarModoUsuario(numero);
		dao.fechar();
		return numero;
	}
}
