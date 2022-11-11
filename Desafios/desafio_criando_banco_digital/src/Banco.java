import java.util.ArrayList;
import java.util.List;

public class Banco {

    private  String nome;
    private List<Cliente> clientes = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void addCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

}
