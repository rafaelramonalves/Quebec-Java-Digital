import org.example.Conta;
import org.example.TransferenciaEntreContas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//Teste de Exception da classe transferência entre contas
public class ExceptionsTeste {

    @Test
     void validarCenarioDeExcecaoNaTransferencia(){
        Conta contaOrigem = new Conta("12345",0);
        Conta contaDestinho = new Conta("654321",100);

        TransferenciaEntreContas transferenciaEntreContas = new TransferenciaEntreContas();

        //Testando se a exceção foi lançada
        Assertions.assertThrows(IllegalArgumentException.class, ()->
                transferenciaEntreContas.transfere(contaOrigem,contaDestinho,-1));

        //Testando se uma execeção NÃO foi lançada
        Assertions.assertDoesNotThrow(()->
                transferenciaEntreContas.transfere(contaOrigem,contaDestinho,-1));
    }

}
