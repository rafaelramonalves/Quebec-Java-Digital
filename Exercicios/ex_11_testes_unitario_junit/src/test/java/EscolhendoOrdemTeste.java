import org.junit.jupiter.api.*;

//Exemplo de como colcoar a ordem de execução dos testes

/*

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //Segue a ordem dada (@Order)
@TestMethodOrder(MethodOrderer.MethodName.class)//Segue a ordem alfabética
@TestMethodOrder(MethodOrderer.Random.class)//Segue a ordem randomica
@TestMethodOrder(MethodOrderer.DisplayName.class)//Segue a ordem do Display (@DisplayName("A"))

 */
public class EscolhendoOrdemTeste {

    @Order(2) //Indica a ordem em que ele vai ser execuado
    @DisplayName("A") //Indica a ordem em que ele vai ser execuado pelo displayName
    @Test
    void validaFluxoA(){
        Assertions.assertTrue(true);

    }

    @Order(1) //Indica a ordem em que ele vai ser execuado
    @Test
    void validaFluxoB(){
        Assertions.assertTrue(true);
    }

    @Order(3) //Indica a ordem em que ele vai ser execuado
    @Test
    void validaFluxoC(){
        Assertions.assertTrue(true);
    }

    @Order(1) //Indica a ordem em que ele vai ser execuado
    @Test
    void validaFluxoD(){
        Assertions.assertTrue(true);
    }

}
