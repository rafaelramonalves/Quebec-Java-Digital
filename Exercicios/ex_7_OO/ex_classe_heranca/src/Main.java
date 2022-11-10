public class Main {
    public static void main(String[] args) {

        Carro carro = new Carro();
        carro.setCor("Azul");
        carro.setModelo("BMW");
        carro.setCapacidadeTanque(59);

        System.out.println(carro.toString());
        System.out.println("Total valor tanque: "+carro.totalValorTanque(20));

        Carro carro1 = new Carro("Cinza","BMW",60);
        System.out.println(carro1.toString());
        System.out.println("Total valor tanque: "+carro1.totalValorTanque(30));

    }
}