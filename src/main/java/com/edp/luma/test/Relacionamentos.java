package com.edp.luma.test;

import com.edp.luma.beans.Atendente;
import com.edp.luma.beans.Atendimento;
import com.edp.luma.beans.Cliente;
import com.edp.luma.bo.AtendenteBo;
import com.edp.luma.bo.AtendimentoBo;
import com.edp.luma.bo.ClienteBo;

import javax.swing.*;

public class Relacionamentos {
    public static void main(String[] args){
        try {
            AtendimentoBo bo = new AtendimentoBo();
            System.out.println(bo.getTodosAtendimentos());
            AtendenteBo atendenteBo = new AtendenteBo();
            atendenteBo.adicionarAtendente(new Atendente("teste", "02128", "9894894", "iufhifhf", true));
            System.out.println(atendenteBo.getTodosAtendentes());
            ClienteBo clienteBo = new ClienteBo();
            clienteBo.novoCliente(new Cliente("ioadjaoidj", "djodaj", "oidjadaj", "ojoidajdo", "OIjda", "odjaodjaod"));
            System.out.println(clienteBo.getTodosClientes());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
