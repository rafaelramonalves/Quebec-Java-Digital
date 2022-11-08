import java.util.*;

//Exemplo de ordenação usando o Set
public class ExemploOrdenacaoSet {

    /*
   Dadas as seguintes informações sibre séries crie um conjunte
   e ordene este conjunto exibindo nome, genero e tempo de episódio

   Serie 1: nome: got, genero: fantasia, tempoEpisodio: 60
   Serie 2: nome: dark, genero: drama, tempoEpisodio: 60
   Serie 3: nome: that '70s show, genero: comédia, tempoEpisodio: 25

    */

    public static void main(String[] args) {

        System.out.println("--Ordem aleatória--");
        Set<Serie> minhasSeries = new HashSet<>(){{
           add(new Serie("got", "fantasia",60));
            add(new Serie("dar", "drama",60));
            add(new Serie("that '70s show", "comédia",25));
        }};
        for (Serie serie:minhasSeries) {
            System.out.println("Nome: "+serie.getNome()+"- genero: "+serie.getGenero()+
                    " - Tempo de episódio: "+serie.getTempoEpisodio());
        }

        System.out.println("------------------------------------------------------");

        System.out.println("--Ordem de inserção-");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia",60));
            add(new Serie("dar", "drama",60));
            add(new Serie("that '70s show", "comédia",25));
        }};
        for (Serie serie:minhasSeries1) {
            System.out.println("Nome: "+serie.getNome()+"- genero: "+serie.getGenero()+
                    " - Tempo de episódio: "+serie.getTempoEpisodio());
        }

        System.out.println("------------------------------------------------------");

        //Precisa da implementação de um COMPARABLE, implementando na classe
        System.out.println("--Ordem natural (Tempo de episódio) -");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie:minhasSeries2) {
            System.out.println("Nome: "+serie.getNome()+"- genero: "+serie.getGenero()+
                    " - Tempo de episódio: "+serie.getTempoEpisodio());
        }

        System.out.println("------------------------------------------------------");
        //Precisa da implementação de um COMPARATER, implementando na classe
        System.out.println("--Ordem nome, gênero e tempo de episódio --");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomegeneroTempo());
        minhasSeries3.addAll(minhasSeries);//populando o Set
        for (Serie serie:minhasSeries3) {
            System.out.println("Nome: "+serie.getNome()+"- genero: "+serie.getGenero()+
                    " - Tempo de episódio: "+serie.getTempoEpisodio());
        }
    }
}

//Classe criada dentro da outra somente para facilitar a vizualização
class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    //Sobrescrita do equals and hasCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    //Implementação do comparable
    //É preciso colocar um critério de desempate, se não irá aparecer apenas
    // um dos elementos que tem o elemento de comparação repetido
    @Override
    public int compareTo(Serie serie) {
        // return Integer.compare(this.tempoEpisodio, serie.tempoEpisodio); *Exclui elemento repetido

        int tempoEpisodio = Integer.compare(this.tempoEpisodio, serie.tempoEpisodio);
        if(tempoEpisodio!=0) //verificando se é igual o tempo
            return tempoEpisodio;
         return this.genero.compareTo(serie.getGenero()); //*critério de desempate é o genero
    }
}
class ComparatorNomegeneroTempo implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {

        //Compara o nome
        int nome = s1.getNome().compareTo(s2.getNome());
        if(nome!=0)
            return nome;

        //Compara o genero
        int genero = s1.getGenero().compareTo(s2.getGenero());
        if(genero!=0)
            return genero;

        //Compara o tempo de episódio, se for igual tbm é pq é a mesma série
        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());

    }
}
