package excps;
public class UsuarioNaoCadastradoEx extends Exception{

  public UsuarioNaoCadastradoEx(){
    super("ERRO: Usuario nao cadastrado.");
  }

}