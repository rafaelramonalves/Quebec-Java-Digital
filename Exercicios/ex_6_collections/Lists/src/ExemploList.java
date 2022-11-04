// Exemplo do uso de list para resolução de problema

import java.util.*;

public class ExemploList {

    /*
    Criar uma lista

    Forma 1
    List notas = new ArrayList(); // --> Antes do Java 5

    Forma 2
    List<Double> notas2 = new ArrayList<Double>(); // --> Generics (JDK 5)

    Forma 3
    List<Double> notas3 = new ArrayList<>(); // -->Diomond Operator (JDK 7)

    Forma 4 --> Nessa forma não é possivel add nem remover itens da lista (imutável)
    List<Double> notas4 = List.of(7d, 8.5, 9.3, 4d, 7d, 0d, 3.6);

     */
    public static void main(String[] args) {
        List<Double> notas = new ArrayList<Double>();
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7d);
        notas.add(0d);
        notas.add(3.6);

        //Exibir lista completa
        System.out.println("Lista: " + notas.toString());

        //Exibir posição de um elemento dentro da lista
        System.out.println("Posição de um elemento na lista: " + notas.indexOf(5d));

        //Adicionar na lista uma nota em determinada posição (posição, elemento)
        notas.add(4, 8d);
        System.out.println("Adicionar na lista a nota 8.0 na posição 4: " + notas);

        //Substituição de valor dentro da lista
        notas.set(notas.indexOf(5d), 6d);
        System.out.println("Substituição da nota 5.0 pela nota 6.0: " + notas);

        //Verificar se o elemento está na lista
        System.out.println("Se a nota 5.0 está na lista: " + notas.contains(5d));

        //Verificar quando aquele elemento foi adicionado
        System.out.println("Exibir a terceira nota adiciona: " + notas.get(2));

        //Achar menor elemento dentro do array, não tem metodo nativo então usa Collections
        System.out.println("Exibir a menor nota: " + Collections.min(notas));

        //Achar maior elemento dentro do array, não tem metodo nativo então usa Collections
        System.out.println("Exibir a maior nota: " + Collections.max(notas));

        //Soma dos valores dentro do array
            Iterator<Double> interator = notas.iterator();
            Double soma = 0d;
            while (interator.hasNext()) { //Has next verifica se tem um proximo elemento
                Double next = interator.next();
                soma += next;
            }
        System.out.println("Exibir a soma dos valores: "+soma);

        //obter a média
        System.out.println("Exibir a média das notas:" + (soma/notas.size()));

        //Remover elemento, pode passar tanto a posição quanto o objeto
        System.out.println("Remover a nota 0 ");
        notas.remove(0); //remove o elemento no index 0
        notas.remove(0d); // remove o elemtento 0

        //Remover elementos com uma condição
        System.out.println("Remover elemento menores que 7");
        Iterator<Double> iterator1 = notas.iterator();
        while (interator.hasNext()){
          Double next =  iterator1.next();
          if(next<7)
              iterator1.remove();
        }

        //Remover todos os elementos
        System.out.println("Remover todos os elementos da lista");
        notas.clear();

        //Verificar se a lista está fazia
        System.out.println("A lista está vazia? "+notas.isEmpty());
    }
}
