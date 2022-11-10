public class Main {
    public static void main(String[] args) {

        //vetor de classeMãe
        ClasseMae [] classes = new ClasseMae[]{
                new ClasseFilha1(),
                new ClasseFilha2(),
                new ClasseMae()
        };

        //Polimorfismos
        for (ClasseMae classe : classes){
            classe.metodo1();
        }

        System.out.println("---------------");

        //Polimorfismos
        for (ClasseMae classe : classes){
            classe.metodo2();
        }

        System.out.println("---------------");

        //Sobrescrita
        ClasseFilha2 classeFilha2 = new ClasseFilha2();
        classeFilha2.metodo2();

    }
}