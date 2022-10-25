public class Main {
    public static void main(String[] args) {

        //Calculadora
        System.out.println("Calculadora");
        Calculadora.soma(10,15);
        Calculadora.subtracao(25,5);
        Calculadora.divisao(80,4);
        Calculadora.multiplicacao(7,8);

        //Mensagem de saudação
        Mensagem.obtemHora(9);
        Mensagem.obtemHora(17);
        Mensagem.obtemHora(20);

        //Emprestimo
        Emprestimo.calculaValor(1000,0);
        Emprestimo.calculaValor(1000,3);
        Emprestimo.calculaValor(1000,5);
        Emprestimo.calculaValor(1000,10);
    }
}