import javax.swing.*;

public class UncheckedException {
    //Fazer a divisão de 2 valores inteiros


    public static void main(String[] args) {

        boolean continueLopping=true;

        do{
            //Caixa de diálogo
            String a = JOptionPane.showInputDialog("Numerador");
            String b = JOptionPane.showInputDialog("Denominador");

            try {
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: "+resultado);
                continueLopping=false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Entrada inválida," +
                        " informe um número inteiro");
            }catch (ArithmeticException e){
                JOptionPane.showMessageDialog(null,"impossivel dividir," +
                        " por 0");
            }
            finally {
                System.out.println("Chegou no finally");
            }

        }while(continueLopping);

    }

    public static int dividir(int a, int b){
        return a/b;
    }
}