package com.bootcampjava.subsistema2;

public class CepApi {

    private static CepApi instacia = new CepApi();

    private  CepApi(){
        super();
    }

    public static CepApi getInstance(){
        return instacia;
    }

    public  String recuperarCidade(String cep){
     return "cidade A";
    }

    public  String recuperarEstado(String cep){
        return "Estado A";
    }
}
