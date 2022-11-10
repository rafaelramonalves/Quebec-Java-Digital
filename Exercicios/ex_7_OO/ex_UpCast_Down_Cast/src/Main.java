public class Main {
    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario();

        //UpCast --> Inplicito
        Funcionario gerente = new Gerente();
        Funcionario vendedor= new Vendedor();
        Funcionario faxineiro = new Faxineiro();

        //DownCast --> Explicito
        Vendedor vendedor1 = (Vendedor) new Funcionario();
        //--> O erro vem porque o Java não sabe fazer com oque tem em funcionário e não tem
        // em vendedor
    }
}