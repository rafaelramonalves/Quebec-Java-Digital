public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco("banco1");

        Cliente cliente = new Cliente("Rafael");
        banco.addCliente(cliente);


        Conta contaCorrente = new ContaCorrente(cliente);
        Conta contaPoupanca = new ContaPoupanca(cliente);

        contaCorrente.depositar(100);
        contaCorrente.transferir(100,contaPoupanca);

        contaPoupanca.imprimirExtratos();
        contaCorrente.imprimirExtratos();

    }
}