package excps;
public class LivroNaoCadastradoEx extends Exception{

  public LivroNaoCadastradoEx(){
    super("ERRO: Livro nao cadastrado.");
  }

}