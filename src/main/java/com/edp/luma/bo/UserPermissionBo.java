package com.edp.luma.bo;

import com.edp.luma.beans.UserPermission;
import com.edp.luma.dao.UserPermissionDao;

public class UserPermissionBo {
	
	
	
	public boolean avaliar(UserPermission permission) throws Exception{
		
		UserPermission userPermission = new UserPermission();
		
		UserPermissionDao dao = new UserPermissionDao();
		return dao.avaliar(permission);
		
	}
		
		public boolean adicionarPermissao(UserPermission permissao) throws Exception{
			UserPermissionDao dao = new UserPermissionDao();
			
			if(permissao != null){
				return dao.adicionarPermissao(permissao);
			}
			return false;
		
		}
		
		public boolean removerPermissao(UserPermission permissao) throws Exception{
			UserPermissionDao dao = new UserPermissionDao();
			
			if(permissao != null){
				return dao.removerPermissao(permissao);
			}
			return false;
		
		}
		
		
	
		
	}

