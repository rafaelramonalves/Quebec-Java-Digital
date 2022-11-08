import java.util.*;

//Exemplo implementação collection Set
public class ExemploSet {
    public static void main(String[] args) {
        //Dada uma lista com 7 notas de um aluno [7,8.5, 9.3, 7, 0, 3.6 ]

        /*
        Formas de inicializar o Set

        Set notas = new HashSet(); //antes do Java 5

        HasSet<Double> notas = new HashSet<>();

        Set<Double> notas = new HashSet<>(); //Genercis (jdk 5) - Diamont Operator (jdk 7)

        Set<Double> notas = Set.of (7d, 8.5, 9.3, 7d, 0d, 3.6 );


         */

        System.out.println("Crie um conjunto e adiciona as notas");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 7d, 0d, 3.6));
        System.out.println(notas.toString());


        System.out.println("Conferir se a nota 5.0 está no conjunto: "+notas.contains(5d));

        System.out.println("Exibir a menor nota: "+ Collections.min(notas));

        System.out.print("Exiba a soma dos valores: ");
        Iterator<Double> iterator = notas.iterator();
        double soma =0.0;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma +=next;
        }
        System.out.println(soma);

        System.out.println("Exibir a média das notas: "+(soma/notas.size()));

        System.out.println("Remover a nota 0: ");
        notas.remove(0d);

        System.out.println("Remover as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if(next<7)
                iterator1.remove();
        }

        System.out.println("Exibir todas as notas na ordem em que foram informadas");
        //É usado o LinkedHashSet
        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 7d, 0d, 3.6));
        System.out.println(notas2);

        System.out.println("Exibir todas as notas na ordem crescente: ");
        //O treeSet adiciona os elementos em ordem natural
        Set<Double> notas3 = new TreeSet<>(notas2); //Precisa ter um comparater
        System.out.println(notas3);

        System.out.println("Apagar todo o conjunto");
        notas.clear();

        System.out.println("Conferir se o conujunto está vazio: "+notas.isEmpty());
    }
}
