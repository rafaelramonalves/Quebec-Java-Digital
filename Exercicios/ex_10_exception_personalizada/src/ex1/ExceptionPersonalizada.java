package ex1;

import javax.swing.*;
import java.io.*;

public class ExceptionPersonalizada {
    public static void main(String[] args) {
        
        String nomeDoArquivo = JOptionPane.showInputDialog("Nome do arquivo a ser exibido");
        
        imprimirArquivoNoConsole(nomeDoArquivo);
    }

    private static void imprimirArquivoNoConsole(String nomeDoArquivo) {
        try {
            BufferedReader br = lerArquivo(nomeDoArquivo);
            String line = br.readLine();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            do {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }while (line != null);
        } catch (ImpossivelAberturaDeArquivoException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage()
            );
           //IOException tem que sermpre a ultima, por ela ser muito genérica nada passa dela
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro não esperado."
            );
        }
    }

    private static BufferedReader lerArquivo(String nomeDoArquivo) throws ImpossivelAberturaDeArquivoException {
        File file = new File(nomeDoArquivo);
        try {
            return new BufferedReader(new FileReader(nomeDoArquivo));
        } catch (FileNotFoundException e) {
            throw  new ImpossivelAberturaDeArquivoException(file.getName(), file.getPath());
        }
    };
}

//Classe de Exception customizada
class ImpossivelAberturaDeArquivoException extends Exception{

    private String nomeDoArquivo;
    private String diretorio;

    public ImpossivelAberturaDeArquivoException(String nomeDoArquivo, String diretorio) {
        super("O arquivo "+nomeDoArquivo+" não foi encontrado no diretório "+diretorio);
        this.nomeDoArquivo = nomeDoArquivo;
        this.diretorio = diretorio;
    }

    //Precisa sobreescrever o toString para apresentar a chamada personalizada
    @Override
    public String toString() {
        return "Ex1.ImpossivelAberturaDeArquivoException{" +
                "nomeDoArquivo='" + nomeDoArquivo + '\'' +
                ", diretorio='" + diretorio + '\'' +
                '}';
    }
}