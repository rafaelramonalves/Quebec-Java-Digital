import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

//Exercicios de Stream API
public class ExStreamApi {
    public static void main(String[] args) {

        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2","3",
                "9","9","6","5");
        
        System.out.println("Imprima todos os elemtnso dessa lista de String");
        /*

        numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

         */

        //Usando lambda e método de referência
        numerosAleatorios.stream().forEach(System.out::println);

        System.out.println("---------------------------------------------------------");
        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set" +
                "(o Set não pega nº repetido");

        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);


        System.out.println("---------------------------------------------------------");
        System.out.println("Tranforme esta lista de String em uma lista de números inteiros");
        /*

        numerosAleatorios.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                })
         */

        /*

        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);

         */

        //colocando em uma variável
        List<Integer> collectList = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());//colocar dentro de uma lista
        System.out.println(collectList);


        System.out.println("---------------------------------------------------------");
        System.out.println("Peque os números pares e maiores que 2 e coloque em uma lista");

        /*

        List<Integer> listParesMaiorq2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) {
                        if (i % 2 == 0 && i > 2)
                            return true;
                        return false;
                    }
                }).collect(Collectors.toList());//colocar dentro de uma lista


         */

        List<Integer> listParesMaiorq2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i%2==0 && i>2)
                .collect(Collectors.toList());

        System.out.println(listParesMaiorq2);

        System.out.println("---------------------------------------------------------");
        System.out.println("Mostrar a média dos números");

        /*

        numerosAleatorios.stream()
                .mapToInt(new ToIntFunction<String>() { //map int pq irá fazer manipulações
                    @Override
                    public int applyAsInt(String s) {
                        return Integer.parseInt(s);
                    }
                });

         */

        /*

        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()//média
                .ifPresent(new DoubleConsumer() { //Verificar se não é null, e imprime
                    @Override
                    public void accept(double value) {
                        System.out.println(value);
                    }
                });

         */

        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);//Verificar se não é null, e imprime


        System.out.println("---------------------------------------------------------");
        System.out.println("Remova os valores impares");
        //Não da pra usar Stream pq ele não altera dados da fonte

        /*

        collectList.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer % 2 !=0)
                    return true;
                return false;
            }
        });

         */
        collectList.removeIf(integer -> integer % 2 !=0);

        System.out.println(collectList);
    }
}
