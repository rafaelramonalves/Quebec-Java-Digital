package ex2;

import javax.swing.*;

public class ExceptionPersonalizada2 {
    public static void main(String[] args) {
        int[] numerador = {4,5,8,10};
        int[] demoninador = {2,4,0,2,8};

        for (int i =0; i<demoninador.length;i++){

                try {

                    //Quando é numero impar, por exemplo 5/4 da número quebrado
                    // e logo não aparece no tipo int
                    if(numerador[i] %2 !=0)
                        throw new DivisaoNaoExataException("Divisão não exata",numerador[i],demoninador[i]);
                    int resultado = numerador[i]/demoninador[i];
                    System.out.println(resultado);

                } catch (DivisaoNaoExataException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }catch (ArithmeticException e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }

        }
    }
}


