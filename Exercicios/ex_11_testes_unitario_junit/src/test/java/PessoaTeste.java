import org.example.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PessoaTeste {

    //Notação de teste
    @Test
    void validarCalculoIdade(){
        Pessoa pessoa = new Pessoa("Julia", LocalDateTime.of(2020,1,1,5,10));
        Assertions.assertEquals(2,pessoa.getIdade()); //O resultado que se espera
    }
}
