// Exemplo de utilização do For em Arrays
public class ExemploForArray {
    public static void main(String[] args) {
        //Em arrays indices se iniciam no 0
        String alunos [] = {"FELIPE", "JONAS", "JULIA", "MARCOS"};

        for (int x=0; x<alunos.length;x++){
            System.out.println("O aluno no indice x = "+x+" é "+alunos[x]);
        }

    // Usando o For...Each
        System.out.println("Usando For Each");
        for(String aluno: alunos){
            System.out.println("Nome do aluno é: "+aluno);
        }
    }
}
