package com.bootcampjava.facade;

import com.bootcampjava.subsistema1.CrmService;
import com.bootcampjava.subsistema2.CepApi;

public class Facade {

    public void migraCliente(String nome, String cep){

        String cidade = CepApi.getInstance().recuperarCidade(cep);
        String estado = CepApi.getInstance().recuperarCidade(cep);

        CrmService.gravarCliente(nome, cep,cidade, estado);

        System.out.println(nome);
        System.out.println(cidade);
        System.out.println(cep);
        System.out.println(estado);

    }
}
