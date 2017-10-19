package com.edp.luma.test;

import com.edp.luma.beans.*;
import com.edp.luma.bo.*;
import com.google.gson.Gson;

import javax.swing.*;
import java.sql.Date;
import java.util.Calendar;

public class Relacionamentos {
    public static void main(String[] args){


        try {
            Gson gson = new Gson();

            AtendenteBo atendenteBo = new AtendenteBo();
            atendenteBo.adicionarAtendente(new Atendente("teste", "02128", "9894894", "iufhifhf", true));
            System.out.println(atendenteBo.getTodosAtendentes());
            AtendimentoBo bo = new AtendimentoBo();
            bo.adicionarAtendimento(new Atendimento(1, 0, 1.0f, null, "5"));
            System.out.println(gson.toJson(bo.getTodosAtendimentos()));

            LocalBo localBo = new LocalBo();
            localBo.adicionarLocal(new Local("cidade", "cidade", "bairro", "rua", 22));

            OcorrenciaBo.adicionarOcorrencia(new Ocorrencia("um tipo", "uma criticidade", "um sintoma", 1, "um tempo"));
            System.out.println(gson.toJson(OcorrenciaBo.consultarOcorrencia(1)));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
