import java.util.Hashtable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collections;


public class Biblioteca{

  Hashtable<Integer, Usuario> cadastroUsuarios;
  Hashtable<String, Livro> cadastroLivros;
  
  //construtores
  public Biblioteca(){
    cadastroUsuarios = new Hashtable<>();
    cadastroLivros = new Hashtable<>();
  }
  
  //metodos
  //cadastro
  public void cadastraUsuario(int cod, Usuario u){
    cadastroUsuarios.put(cod, u);
  }
  
  public void cadastraLivro(String cod, Livro l){
    cadastroLivros.put(cod, l);
  }
  
  //empresta livro para usuario
  public void emprestaLivro(Usuario usu, Livro liv) throws CopiaNaoDisponivelEx{
    liv.empresta();
    
    Calendar calendar = Calendar.getInstance();
    int ano = calendar.get(Calendar.YEAR);
    int mes = calendar.get(Calendar.MONTH);
    int dia = calendar.get(Calendar.DAY_OF_MONTH);
    usu.addLivroHist(new GregorianCalendar(ano, mes, dia), liv.getCodigoLivro());
  }
  
  //devolve livro
  public void devolveLivro(Usuario usu, Livro liv)throws NenhumaCopiaEmprestadaEx{
    liv.devolve();
    
    //adiciona ao historico do livro os usuarios que o pegaram emprestado
    Calendar calendar = Calendar.getInstance();
    int ano = calendar.get(Calendar.YEAR);
    int mes = calendar.get(Calendar.MONTH);
    int dia = calendar.get(Calendar.DAY_OF_MONTH);
    GregorianCalendar dataD = new GregorianCalendar(ano, mes, dia);
    
    GregorianCalendar dataL = null;
    ArrayList<Emprest> arrayHist = usu.getHist();
    for(int i = 0; i < arrayHist.size(); ++i){
      if(liv.getCodigoLivro().equals(arrayHist.get(i).getCodLiv())){
        dataL = arrayHist.get(i).getDataEmp();
        usu.getHist().get(i).setDataDev(dataD);
      }
    }
    if (dataL == null) throw new NenhumaCopiaEmprestadaEx();
    
    liv.addUsuarioHist(dataL, dataD, usu.getCodigoUsuario());
    
    long dataMulta = TimeUnit.MILLISECONDS.toDays(dataD.getTimeInMillis() - dataL.getTimeInMillis());
    if(dataMulta > 10){
      System.out.println("Livro devolvido com mais de 10 dias de atraso. Multa de 50 reais.");
    }
  }
  
  // imprime livros
  public String imprimeLivros(){
    String str = "";
    ArrayList<String> titulos = new ArrayList<>();
    
    for(String chave : cadastroLivros.keySet()){
      titulos.add(cadastroLivros.get(chave).getTituloLivro());
    }
    Collections.sort(titulos);
    
    for(String titulo : titulos){
      str = str + titulo + "\n";
    }
    
    return str;
  }
  
  //imprime usuarios
  public String imprimeUsuarios(){
    String str = "";
    ArrayList<String> usuarios = new ArrayList<>();
    
    for(int chave : cadastroUsuarios.keySet()){
      usuarios.add(cadastroUsuarios.get(chave).getNome());
    }
    Collections.sort(usuarios);
    
    for(String usuario : usuarios){
      str = str + usuario + "\n";
    }
    
    return str;
  }
  
  //pega um livro especifico
  public Livro getLivro(String cod) throws LivroNaoCadastradoEx{
    if (cadastroLivros.containsKey(cod)) {
        return cadastroLivros.get(cod);
    } else throw new LivroNaoCadastradoEx();
  }
  
  //pega um usuario especifico
  public Usuario getUsuario(int cod) throws UsuarioNaoCadastradoEx{
    if (cadastroUsuarios.containsKey(cod)) {
        return cadastroUsuarios.get(cod);
    } else throw new UsuarioNaoCadastradoEx();
  }
  
  //metodos get para as hashtables
  public Hashtable<Integer, Usuario> getCadastroUsuarios(){
    return cadastroUsuarios;
  }
  
  public Hashtable<String, Livro> getCadastroLivros(){
    return cadastroLivros;
  }
  
}