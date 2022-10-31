package Excecao_customizada;

//Classe que irá formatar o cep
public class FormatadorCepExemplo {
    public static void main(String[] args) {
        try {
            String  meuCepFormatado = formatarCep("7143304");
            System.out.println(meuCepFormatado);
        } catch (CepInvalidoException e) {
            //throw new RuntimeException(e);
            System.out.println("O cep está incorreto");
        }
    }
    static String formatarCep(String cep) throws CepInvalidoException{
        if(cep.length()!=8)
            throw new CepInvalidoException();

        //simulando um cep formatado
        return "23789-307";
    }
}
