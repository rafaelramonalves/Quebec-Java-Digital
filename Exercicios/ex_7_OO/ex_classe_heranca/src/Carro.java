//Exercicio de orientação Objeto
//Carro é um veiculo

//Classe
public class Carro extends Veiculo{

    //Atributos
    String cor;
    String modelo;
    int capacidadeTanque;

    //Construtor
    Carro(){

    }

    Carro(String cor, String modelo, int capacidadeTanque){
        this.cor = cor;
        this.modelo = modelo;
        this.capacidadeTanque =capacidadeTanque;
    }

    //Gets and Sets
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(int capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    //Método calcular valor para encher o tanque
    double totalValorTanque(double valorCombustivel){
        return capacidadeTanque*valorCombustivel;
    };

    //Sobreposição do método toString (não devolver endereço de memória)
    @Override
    public String toString() {
        return "Carro{" +
                "cor='" + cor + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidadeTanque=" + capacidadeTanque +
                '}';
    }
}
