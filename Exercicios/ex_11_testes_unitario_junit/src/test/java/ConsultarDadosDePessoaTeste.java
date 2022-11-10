import org.example.BancoDeDados;
import org.example.Pessoa;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConsultarDadosDePessoaTeste {

    //Testar antes de iniciar a conexão - Execução única
    @BeforeAll
    static void configurarConexao(){
        BancoDeDados.iniciarConexao();
    }

    //testar antes do teste executar - de cada teste
    @BeforeEach
    void insereDadosParaTete(){
        BancoDeDados.insereDados(new Pessoa("João", LocalDateTime.of(2000,1,1,10,20)));
    }

    //depois de executar o teste - de cada teste
    @AfterEach
    void removeDadosDoTeste(){
        BancoDeDados.removeDados(new Pessoa("João", LocalDateTime.of(2000,1,1,10,20)));
    }

    @Test
    static void validarDadosDeRetorno(){
        Assertions.assertTrue(true);
    }

    // Depois de tudo, teste - Execução única
    @AfterAll
    static void finalizarConexao(){
        BancoDeDados.finalizaConexao();
        System.out.println("Rodou o finalizar a execução");
    }
}
