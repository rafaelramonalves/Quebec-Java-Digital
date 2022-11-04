import java.util.*;

//Ex de exemplo de ordenação de uma lista
public class ExemploOrdenacaoList {

    /*
    Dada as seguintes informações, crie uma lista e ordene exibindo
    * nome
    * Idade
    * cor

    Gato 1 = nome: Jhon, idade: 18, cor: preto
    Gato 2 = nome: Simba, idade: 6, cor: tigrado
    Gato 3 = nome: Garfild, idade: 12, cor: amarelo
     */
    public static void main(String[] args) {

        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jhon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Garfild", 12, "amarelo"));
        }};

        System.out.println("-- Ordem de inserção--");
        System.out.println(meusGatos);

        System.out.println("-- Ordem aleatória--");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("-- Ordenar pelo nome (natural)--");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("-- Ordenar por idade --");
        meusGatos.sort(new CompatorIdade());
        //Collections.sort(meusGatos, new CompatorIdade()); --> Segunda forma
        System.out.println(meusGatos);

        System.out.println("-- Ordenar por nome/cor/idade ");//caso um item seja igual é avaliado o proximo
        meusGatos.sort(new ComparatorNomeCorIdade());

    }

    //Classe criada aqui mesmo para facilitar a vizualização
    // Comparable é usado para classificar os objetos com ordem natural (nomes)
    static class Gato implements Comparable<Gato>{
        private String nome;
        private Integer idade;
        private String cor;

        public Gato(String nome, Integer idade, String cor) {
            this.nome = nome;
            this.idade = idade;
            this.cor = cor;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Integer getIdade() {
            return idade;
        }

        public void setIdade(Integer idade) {
            this.idade = idade;
        }

        public String getCor() {
            return cor;
        }

        public void setCor(String cor) {
            this.cor = cor;
        }


        //Para na impressão não devolver o endereço de memória
        @Override
        public String toString() {
            return "{" +
                    "nome='" + nome + '\'' +
                    ", idade=" + idade +
                    ", cor='" + cor + '\'' +
                    '}';
        }

        //Método de sobrescrita de comparação (implements da classe)
        // e esse metodo retorna int para comparar
        // retorno 0 = nomes iguais,
        // 1 = o elemento que chegou é maior do que se está comparando
        // -1 = O elemento que chegou é menor do que se esta comparando
        @Override
        public int compareTo(Gato gato) {
            //Como a comparação é de Strings usa o proprio método de comparação
            return this.getNome().compareToIgnoreCase(gato.getNome());
        }

    }

    //Classe de comparação, criado aqui apenas para melhor vizualização
    //Comparator é usado para comparar ous objetos que não seja de ordenação natural (nomes)
    static class CompatorIdade implements Comparator<Gato> {

        @Override
        public int compare(Gato gato, Gato gato2) {
            return Integer.compare(gato.getIdade(),gato2.getIdade());
        }
    }

    static class ComparatorNomeCorIdade implements Comparator<Gato> {

        @Override
        public int compare(Gato gato, Gato gato2) {
            //Se os nomes forem diferentes ordena pelo nome
            int nome = gato.getNome().compareToIgnoreCase(gato2.getNome());
            if(nome != 0)
             return nome;

            //se as cores são diferentes, ordena pela cor
            int cor = gato.getCor().compareToIgnoreCase(gato2.getCor());
            if(cor !=0)
             return cor;

            //se a idade for diferente, ordena pela idade
            return Integer.compare(gato.getIdade(),gato2.getIdade());
        }
    }
}
