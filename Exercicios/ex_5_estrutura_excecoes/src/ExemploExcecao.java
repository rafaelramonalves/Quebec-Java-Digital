import java.text.NumberFormat;
import java.text.ParseException;

/*
Exemplo de exceção

Precisamos realizar duas maneiras a conversão de uma String
para um número, porém o texto contém alfanuméricos.

*/
public class ExemploExcecao {
    public static void main(String[] args) {
        Number valor;

        // Number valor = Double.valueOf("a1.75");

        //Foi obrigatório o uso do try_catch
        try {
            valor = NumberFormat.getInstance().parse("a1.75");
            System.out.println(valor);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
