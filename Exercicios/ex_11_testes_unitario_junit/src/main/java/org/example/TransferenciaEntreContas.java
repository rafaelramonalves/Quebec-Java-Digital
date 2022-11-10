package org.example;

//Classe para simular transferencia entr contas
public class TransferenciaEntreContas {

    public void transfere(Conta contaOrigem, Conta contaDestino, int valor){
        if(valor <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }
    }
}
