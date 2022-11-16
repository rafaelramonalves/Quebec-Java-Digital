package bootcamp.apispringweb.handler;

public class CampoObrigatorioExpection extends BusinessException{
    public CampoObrigatorioExpection(String mensagem) {
        super("O campo é obrigatório");
    }
}
