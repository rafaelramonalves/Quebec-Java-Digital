package org.example;

import java.util.logging.Logger;

//Imagine que é uma classe de conexão de banco de dados
public class BancoDeDados {

    private static  final Logger LOGGER = Logger.getLogger(BancoDeDados.class.getName());

    public static void iniciarConexao(){
        //Simulando uma operação
        LOGGER.info("Iniciou a conexão");

    }

    public static void finalizaConexao(){
        //Simulando uma operação
        LOGGER.info("finalizou a conexão");
    }

    public static  void insereDados(Pessoa pessoa){
        //insere a pessoa no bando de dados
        LOGGER.info("Inseriu a pessoa no banco");
    }

    public static  void removeDados(Pessoa pessoa){
        //remove a pessoa no bando de dados
        LOGGER.info("removeu a pessoa no banco");
    }
}
