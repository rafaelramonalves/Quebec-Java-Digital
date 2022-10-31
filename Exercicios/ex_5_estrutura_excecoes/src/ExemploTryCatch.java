// Exemplo lançamento de exceções

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ExemploTryCatch {
    public static void main(String[] args) {
       try {
           //Criando o objeto scanner
           Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

           System.out.println("Digite o seu nome");
           String nome = scanner.next();

           System.out.println("Digite o seu sobrenome");
           String sobrenome = scanner.next();

           System.out.println("Digite sua idade");
           int idade = scanner.nextInt();

           System.out.println("Digite sua altura");
           int altura = scanner.nextInt();

           //Imprimindo os dados obtidos
           System.out.println("Nome: "+nome.toUpperCase());
           System.out.println("Idade: "+idade);
           System.out.println("Altura: "+altura);

           scanner.close();
       }catch (InputMismatchException e){
           System.out.println("Os campos idade e altura precisam ser numéricos");
           //Pode ser escrito de uma outra fora também (as letras ficam vermelhas)
           System.err.println("Os campos idade e altura precisam ser numéricos 2");
       }
    }
}
