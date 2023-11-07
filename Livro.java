import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Livro{
  
  String codigoLivro, tituloLivro, categoria;
  int quantidade, emprestados;
  public ArrayList<EmprestPara> hist = new ArrayList<EmprestPara>();
  
  //construtor
  public Livro(String codigoLivro, String tituloLivro, String categoria, int quantidade, int emprestados){
    this.codigoLivro = codigoLivro;
    this.tituloLivro = tituloLivro;
    this.categoria = categoria;
    this.quantidade = quantidade;
    this.emprestados = emprestados;
  }
  
  //metodos empresta e devolve
  
  public void empresta() throws CopiaNaoDisponivelEx{
    if(quantidade - emprestados <= 0) throw new CopiaNaoDisponivelEx();
    else{
      emprestados++;
    }
  }
  
  public void devolve() throws NenhumaCopiaEmprestadaEx{
    if(emprestados <= 0) throw new NenhumaCopiaEmprestadaEx();
    else{
      emprestados--;
    }
  }

  //adiciona ao historico do livro os usuarios que o pegaram emprestado
  public void addUsuarioHist(GregorianCalendar dataLoc, GregorianCalendar dataDev, int codUsu){
    EmprestPara e = new EmprestPara(dataLoc, dataDev, codUsu);
    hist.add(e);
  }
  
  //metodos get e set
  
  public void setCodigoLivro(String codigoLivro){
    this.codigoLivro = codigoLivro;
  }
  
  public String getCodigoLivro(){
    return codigoLivro;
  }
  
  public void setTituloLivro(String tituloLivro){
    this.tituloLivro = tituloLivro;
  }
  
  public String getTituloLivro(){
    return tituloLivro;
  }
  
  public void setCategoria(String categoria){
    this.categoria = categoria;
  }
  
  public String getCategoria(){
    return categoria;
  }
  
  public void setQuantidade(int quantidade){
    this.quantidade = quantidade;
  }
  
  public int getQuantidade(){
    return quantidade;
  }
  
  public void setEmprestados(int emprestados){
    this.emprestados = emprestados;
  }
  
  public int getEmprestados(){
    return emprestados;
  }
  
  public ArrayList<EmprestPara> getHist(){
    return hist;
  }
  
  //metodo toString
  @Override
  public String toString(){
    return "[Classe Livro]\nCodigo do Livro: " + codigoLivro + "\nTitulo do Livro: " + tituloLivro + "\nCategoria: " +categoria
    + "\nQuantidade: " + quantidade + "\nEmprestados: " + emprestados + "\nHistorico:\n" + hist;
  }
  
}