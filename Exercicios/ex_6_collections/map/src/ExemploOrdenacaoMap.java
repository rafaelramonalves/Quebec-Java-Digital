import java.util.*;

//Exemplo de ordenação dentro do map
public class ExemploOrdenacaoMap {
/*

    Dadas as seguintes infomações sobre meus livros favoritos e seus autores
    crie um dicionário e ordene este dicionário exibindo
    Nome autor, nome livro e número de páginas

    Autor: Hawkin, Stephen - Livro: Uma breve história do tempo - Páginas: 256
    Autor: Duhigg, Charles - Livro: O poder do hábito - Páginas: 408
    Autor: Harari, Yuval Noah - Livro: 21 lições para o século 21 - Páginas: 432

 */
    public static void main(String[] args) {

        System.out.println("--Ordem aleatória--(nome do autor e livro)");
        Map<String, Livro> meusLivros = new HashMap<>(){{
           put("Hawkin, Stephen", new Livro("Uma breve história do tempo",256));
           put("Duhigg, Charles", new Livro("O poder do hábito",408));
           put("Harari, Yuval Noah", new Livro("21 lições para o século 21",432));
        }};
        for(Map.Entry<String,Livro> livro :meusLivros.entrySet())
            System.out.println("Autor: "+livro.getKey()+" Nome livro: "+livro.getValue().getNomeLivro());

        System.out.println("----------------------------------------------------------");
        System.out.println("--Ordem de inserção--(nome do autor e livro)");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawkin, Stephen", new Livro("Uma breve história do tempo",256));
            put("Duhigg, Charles", new Livro("O poder do hábito",408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21",432));
        }};
        for(Map.Entry<String,Livro> livro :meusLivros1.entrySet())
            System.out.println("Autor: "+livro.getKey()+" Nome livro: "+livro.getValue().getNomeLivro());

        System.out.println("----------------------------------------------------------");
        System.out.println("--Ordem alfabética autores--(nome do autor e livro)");
        //Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros); tbm serve
        Map<String, Livro> meusLivros2 = new TreeMap<>(){{
            put("Hawkin, Stephen", new Livro("Uma breve história do tempo",256));
            put("Duhigg, Charles", new Livro("O poder do hábito",408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21",432));
        }};
        for(Map.Entry<String,Livro> livro :meusLivros2.entrySet())
        System.out.println("Autor: "+livro.getKey()+" Nome livro: "+livro.getValue().getNomeLivro());

        System.out.println("----------------------------------------------------------");
        System.out.println("--Ordem alfabética pelo nome dos livros--(nome do autor e livro)");
        //Precisa de um comparator
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet()); //Populando o Set
        for(Map.Entry<String,Livro> livro :meusLivros3)
            System.out.println("Autor: "+livro.getKey()+" Nome livro: "+livro.getValue().getNomeLivro());
    }
}

//Classe criada dentro da outra apenas para facilitar a vizualização
class Livro{
    private String nomeLivro;
    private Integer paginas;

    public Livro(String nomeLivro, Integer paginas) {
        this.nomeLivro = nomeLivro;
        this.paginas = paginas;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }


    @Override
    public String toString() {
        return "{" +
                "nomeLivro='" + nomeLivro + '\'' +
                ", paginas=" + paginas +
                '}';
    }

    //Sobrescrita do equals e Hascode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nomeLivro.equals(livro.nomeLivro) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeLivro, paginas);
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
        return livro1.getValue().getNomeLivro().compareToIgnoreCase(livro2.getValue().getNomeLivro());
    }
}
