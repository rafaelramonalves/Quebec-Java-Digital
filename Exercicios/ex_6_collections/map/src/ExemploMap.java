import java.util.*;

//Exemplo de uso de map
public class ExemploMap {
    public static void main(String[] args) {
        /*

        Dado os modelos dos carros e seus repectivos consumos na estrada, faça:

        modelo: gol - consumo: 14,4 km/l
        modelo: uno - consumo: 15,6 km/l
        modelo: mobi - consumo: 16,1 km/l
        modelo: hb20 - consumo: 14,5 km/l
        modelo: kwid - consumo: 15,6 km/l

         */

        //Map carrosPopulares2020 = new HasMap(); --> Anted do java 5

        //Map<String, Double> carrosPopulares = new HasMap<>(); --> Generics (jdk5) -- Diomonts (jdk 7)

        //HashMap<String, Double> carrosPopulares = new HashMap<>();

        //Map<String, Double> carrosPopulares = Map.of("gol",14.4, ...)

        System.out.println("Crie um dicionário que relacione os modelos e seus consumos");
        Map<String,Double> carrosPopulares = new HashMap<>(){{ //HasMap n deixa na ordem que foi inserido
           put("gol",14.4);
           put("uno",15.6);
           put("mobi",16.1);
           put("hb20",14.5);
           put("kwid",15.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("-------------------------------------------------------------");
        System.out.println("substitua o consumo do gol por 15,2 km/l");
        carrosPopulares.put("gol",15.2); //Não pode ter chaves iguais, então o valor é substituido
        System.out.println(carrosPopulares.toString());

        System.out.println("-------------------------------------------------------------");
        System.out.println("Confira se o modelo tucson está no dicionário: "+carrosPopulares.containsKey("tucson"));

        System.out.println("-------------------------------------------------------------");
        System.out.println("Exiba o consumo do uno: "+carrosPopulares.get("uno"));

        System.out.println("-------------------------------------------------------------");
        //Set<String> modelos = carrosPopulares.keySet();
        System.out.println("Exibir os modelos: "+carrosPopulares.keySet());

        System.out.println("-------------------------------------------------------------");
        //Collection<Double> consumo = carrosPopulares.values();
        System.out.println("Exiba os consumos dos carros: "+carrosPopulares.values());

        System.out.println("-------------------------------------------------------------");
        System.out.print("Exiba o modelo mais economico e seu nome: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String,Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";
        for (Map.Entry<String,Double> entry: entries){
            if(entry.getValue().equals(consumoMaisEficiente))
                modeloMaisEficiente=entry.getKey();
        }
        System.out.print("Modelo mais eficiente: "+modeloMaisEficiente);
        System.out.println(" Consumo: "+consumoMaisEficiente);

        System.out.println("-------------------------------------------------------------");
        System.out.print("Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0.0;
        while (iterator.hasNext())
            soma+= iterator.next();
        System.out.println(soma);

        System.out.println("-------------------------------------------------------------");
        System.out.println("Exiba a media dos consumos deste dicionário de carros "+
                (soma/carrosPopulares.size()));

        System.out.println("-------------------------------------------------------------");
        System.out.print("Remover os modelos com consumo igual 15,6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext())
            if(iterator1.next().equals(15.6))
                iterator1.remove();
        System.out.println(carrosPopulares);

        System.out.println("-------------------------------------------------------------");
        System.out.print("Exibir todos os carros na ordem em que foram infomados: ");
        Map<String,Double> carrosPopulares1 = new LinkedHashMap<>(){{ //LinkedHasMap na ordem que foi inserido
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",14.5);
            put("kwid",15.6);
        }};
        System.out.println(carrosPopulares1.toString());

        System.out.println("-------------------------------------------------------------");
        System.out.println("Exibir o dicionário ordenado pelo modelo ");
       // Map<String,Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1) tbm serve
        Map<String,Double> carrosPopulares2 = new TreeMap<>(){{ //TreeMap na ordem natural
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",14.5);
            put("kwid",15.6);
        }};
        System.out.println(carrosPopulares2.toString());

        System.out.println("-------------------------------------------------------------");
        System.out.println("Apagar o dicionário ");
        carrosPopulares.clear();

        System.out.println("-------------------------------------------------------------");
        System.out.println("Confira se o dicionário está vazio: "+carrosPopulares.isEmpty());

    }

}
