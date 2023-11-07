import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Usuario extends Pessoa{

  public String endereco;
  public int codigoUsuario;
  public ArrayList<Emprest> hist = new ArrayList<Emprest>();
  
  //construtor
  public Usuario(String nome, String sobreNome, GregorianCalendar data, String CPF, float peso, float altura, String endereco, int codigoUsuario){
    super(nome, sobreNome, data, CPF, peso, altura);
    this.endereco = endereco;
    this.codigoUsuario = codigoUsuario;
  }
  
  //adiciona o livro ao historico do usuario
  public void addLivroHist(GregorianCalendar data, String codLiv){
    Emprest e = new Emprest(data, codLiv);
    hist.add(e);
  }
  
  //metodos get e set
  
  public String getEndereco(){
    return endereco;
  }

  public void setEndereco(String novoEndereco){
    endereco = novoEndereco;
  }
  
  public int getCodigoUsuario(){
    return codigoUsuario;
  }

  public void setCodigoUsuario(int novoCodigoUsuario){
    codigoUsuario = novoCodigoUsuario;
  }
  
  public ArrayList<Emprest> getHist(){
    return hist;
  }
  
  //metodo toString
  @Override
  public String toString(){
    return "[Classe Usuario]\nNome: " + nome + "\nSobreNome: " + sobreNome
      + "\nData de Nascimento: " + dataNasc.get(Calendar.DAY_OF_MONTH) + "/"
      + (dataNasc.get(Calendar.MONTH)+1) + "/" + dataNasc.get(Calendar.YEAR)
      + "\nNumero do CPF: " + numCPF + "\nPeso: " + peso + "\nAltura: " + altura
      + "\nEndereco: " + endereco + "\nCodigo de Usuario: " + codigoUsuario
      + "\nHistorico:\n" + hist;
  }
  

}