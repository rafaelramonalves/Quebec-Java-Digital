public class Quadrilateros {

    public static void calculaArea(double lado){
        System.out.println("O tamanho da área é do quadrado: "+lado*lado);
    }

    public static void calculaArea(double lado1, double lado2){
        System.out.println("O tamanho da área é do retângulo: "+lado1*lado2);
    }

    public static void calculaArea(double baseMaior, double baseMenor, double altura){
        System.out.println("O tamanho da área é do trapézio: "+((baseMaior+baseMenor)*altura)/2);
    }
}
