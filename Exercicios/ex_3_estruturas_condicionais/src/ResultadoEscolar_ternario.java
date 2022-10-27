// Condicional ternária

public class ResultadoEscolar_ternario {
    public static void main(String[] args) {
        int nota =6;

      String resultado = nota >=7? "Aprovado" : "Reprovado";
      System.out.println(resultado);

        //Complementando

      String resultado2 = nota >=7? "Aprovado" : nota >=5 && nota <7 ? "Recuperação" : "Reprovado";
      System.out.println(resultado2);
    }



}
