import javax.swing.*;
import java.io.*;

public class CheckedException {

    //Imprimir um arquivo no console

    public static void main(String[] args) {

        String nomeDoArquivo = "teste.txt";

        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
            //Erro relacionado ao arquivo
        }catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Revise o nome do arquivo");
        }
        //Capturar ume exeção relacionada ao arquivo, como abrir ou fechar
        //IOExeception é uma classe muito abrangente (genérica)
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro inesperado");

        }
        System.out.println("Apesar da exception ou não, o programa continua");
    }

    //A IOException pegou a FileExpetion tbm porque ela é mãe
    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        //O tratamento de Excepetion é obrigatório
        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        //O tratamento de Excepetion é obrigatório
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do{
            //O tratamento de Excepetion é obrigatório
            bw.write(line);
            bw.newLine();
            line=br.readLine();
        }while (line != null);
        //O tratamento de Excepetion é obrigatório
        bw.flush();
        bw.close();
    }
}