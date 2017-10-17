package com.edp.luma.bo;

import java.sql.SQLException;
import java.util.List;

import com.edp.luma.beans.Local;
import com.edp.luma.dao.LocalDao;

public class LocalBo {
   LocalDao dao = new LocalDao();
   
     public LocalBo() throws Exception{
    	 dao =  new LocalDao();
     }
     public boolean adicionarLocal (Local local ){
    	 
    	 try{
    		 return dao.adicionar(local);
    		 }catch (SQLException e){
    		 }
    	         return false;
             }
     
     public boolean editarLocal(Local local){
    	 try{
    		 return dao.editar(local);
    	 } catch (SQLException e){
    		 
    	 }
    	 return false;
         }
     
     public boolean removerLocal (Local local){
    	 try{
    		 return dao.remover(local);
    		 
    	    } catch (SQLException e ){
    		}
    	      return false;
            }

      public Local  buscarLocal (int Id){
    	  try{
    		  return dao.getLocal(Id);
    	 
    	  } catch(SQLException e){
    		  
    	  }
    	    return null;
    	  
      }
       
      public List<Local> getLocal(){
    	  try{
    		  return dao.getLocal();
    	  } catch (SQLException e){
    		  
    	  }
    	  return null;
      }



}
