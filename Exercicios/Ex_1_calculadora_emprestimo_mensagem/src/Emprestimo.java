public class Emprestimo {

    private static double jurosParcela1 = 1.50;
    private static double jurosParcela2 = 2.50;
    private static double jurosParcela3 = 3.50;

    public static double getJurosParcela3() {
        return jurosParcela3;
    }

    public static double getJurosParcela2() {
        return jurosParcela2;
    }


    public static double getJurosParcela1() {
        return jurosParcela1;
    }




    public static void calculaValor( double valor, int quantidadeParcelas){
        double valorFinal;

        if(quantidadeParcelas<1){
            System.out.println("Quantidade de parcelas inválido");
            return;
        }else if(quantidadeParcelas<=2){
            valorFinal= valor*quantidadeParcelas*Emprestimo.getJurosParcela1();
        }else  if (quantidadeParcelas >=3 && quantidadeParcelas<=5){
            valorFinal= valor*quantidadeParcelas*Emprestimo.getJurosParcela2();
        }else{
            valorFinal= valor*quantidadeParcelas*Emprestimo.getJurosParcela3();
        }

        System.out.println("Valor total final do emprestimo: R$ "+valorFinal);
    }
}
