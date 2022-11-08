import java.util.*;
import java.util.function.Function;

//Execicio da materia de Map que irá ajudar na construção do execicio de Stream API

/*
    Dadas as seguintes informações  de id e contato, crie um dicionário e
    ordene este dicionário exibindo (Nome id - Nome contato);
    id = 1 - Contato = nome: Simba, numero: 2222;
    id = 4 - Contato = nome: Cami, numero: 5555;
    id = 3 - Contato = nome: Jon, numero: 1111;
*/

public class ExPropostoMap {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, ContatoMap> agenda = new HashMap<>() {{
            put(1, new ContatoMap("Simba", 5555));
            put(4, new ContatoMap("Cami", 1111));
            put(3, new ContatoMap("Jon", 2222));
        }};
        System.out.println(agenda);
        for (Map.Entry<Integer, ContatoMap> entry: agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, ContatoMap> agenda1 = new LinkedHashMap<>() {{
            put(1, new ContatoMap("Simba", 5555));
            put(4, new ContatoMap("Cami", 1111));
            put(3, new ContatoMap("Jon", 2222));
        }};
        System.out.println(agenda1);
        for (Map.Entry<Integer, ContatoMap> entry: agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem id\t--");
        Map<Integer, ContatoMap> agenda2 = new TreeMap<>(agenda);
        System.out.println(agenda2);
        for (Map.Entry<Integer, ContatoMap> entry: agenda2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem número telefone\t--");

        /*

        --> Sem classe anônima

        //precisamos organizar os valores. Logo:
        Set<Map.Entry<Integer, ContatoMap>> set = new TreeSet<>(new ComparatorOrdemNumerica());
        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, ContatoMap> entry: set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() +
                    ": " +entry.getValue().getNome());
        }

         */

        /*

        --> Usando classe anônima

        Set<Map.Entry<Integer, ContatoMap>> set1 = new TreeSet<>(new Comparator<Map.Entry<Integer, ContatoMap>>() {
            @Override
            public int compare(Map.Entry<Integer, ContatoMap> cont1, Map.Entry<Integer, ContatoMap> cont2) {
                return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
            }
        });
        set1.addAll(agenda.entrySet());
        for (Map.Entry<Integer, ContatoMap> entry: set1) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() +
                    ": " +entry.getValue().getNome());
        }

         */


        /*

         --> Usando método stático do comparater

        Set<Map.Entry<Integer, ContatoMap>> set = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer,ContatoMap>, Integer>() { //Interface funcional
                    @Override
                    public Integer apply(Map.Entry<Integer, ContatoMap> cont) {
                        return cont.getValue().getNumero();
                    }
                }
                )
        );

        */

        // --> Usando o Lambda

        Set<Map.Entry<Integer, ContatoMap>> set = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNumero()));

        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, ContatoMap> entry: set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() +
                    ": " +entry.getValue().getNome());
        }



        System.out.println("--\tOrdem nome contato\t--");
        /*

        //Sem classe anônima

        Set<Map.Entry<Integer, ContatoMap>> set1 = new TreeSet<>(new ComparatorOrdemNomeContato());
        set1.addAll(agenda.entrySet());
        for (Map.Entry<Integer, ContatoMap> entry: set1) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

         */

        //Usando classe anônima
        Set<Map.Entry<Integer,ContatoMap>> set2 = new TreeSet<>(new Comparator<Map.Entry<Integer, ContatoMap>>() {
            @Override
            public int compare(Map.Entry<Integer, ContatoMap> cont1, Map.Entry<Integer, ContatoMap> cont2) {
                return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
            }
        });
        set2.addAll(agenda.entrySet());
        for (Map.Entry<Integer, ContatoMap> entry: set2) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() +
                    ": " +entry.getValue().getNumero());
        }


    }
}

/*

// Usando a classe anônima, não precisa de uma classe Comparator

class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, ContatoMap>> {
    @Override
    public int compare(Map.Entry<Integer, ContatoMap> cont1, Map.Entry<Integer, ContatoMap> cont2) {
        return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
    }
}

*/

class ComparatorOrdemNomeContato implements Comparator<Map.Entry<Integer, ContatoMap>> {
    @Override
    public int compare(Map.Entry<Integer, ContatoMap> cont1, Map.Entry<Integer, ContatoMap> cont2) {
        return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
    }
}
