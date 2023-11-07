import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pessoa{

  public String nome;
  public String sobreNome;
  public GregorianCalendar dataNasc;
  public String numCPF;
  public float peso;
  public float altura;
  private static int num = 0;
  
  // construtores
  public Pessoa(String nomeC, String sobreNomeC, GregorianCalendar data){
    nome = nomeC;
    sobreNome = sobreNomeC;
    dataNasc = data; //n esquecer que GregorianCalendar(anoC, (mesC-1), diaC)
    num++;
  }

  public Pessoa(String nomeC, String sobreNomeC, GregorianCalendar data, String CPF, float pesoC, float alturaC){
    nome = nomeC;
    sobreNome = sobreNomeC;
    dataNasc = data;
    numCPF = CPF;
    peso = pesoC;
    altura = alturaC;
    num++;
  }

  //metodos get e set

  public String getNome(){
    return nome;
  }

  public void setNome(String novoNome){
    nome = novoNome;
  }

  public String getSobreNome(){
    return sobreNome;
  }

  public void setSobreNome(String novoSobreNome){
    sobreNome = novoSobreNome;
  }

  public GregorianCalendar getDataNasc(){
    return dataNasc;
  }

  public void setDataNasc(GregorianCalendar novaDataNasc){
    dataNasc = novaDataNasc;
  }
  
  public String getNumCPF(){
    return numCPF;
  }

  public void setNumCPF(String novoCPF){
    numCPF = novoCPF;
  }

  public float getPeso(){
    return peso;
  }

  public void setPeso(float novoPeso){
    peso = novoPeso;
  }

  public float getAltura(){
    return altura;
  }

  public void setAltura(float novoAltura){
    altura = novoAltura;
  }


  //metodo to String
  @Override
  public String toString(){
    String str = "[Classe Pessoa]\nNome: " + nome + "\nSobreNome: " + sobreNome
      + "\nData de Nascimento: " + dataNasc.get(Calendar.DAY_OF_MONTH) + "/"
      + (dataNasc.get(Calendar.MONTH)+1) + "/" + dataNasc.get(Calendar.YEAR)
      + "\nNumero do CPF: " + numCPF + "\nPeso: " + peso + "\nAltura: " + altura;
    return str;
  }

  //metodo para devolver quantos objetos Pessoa foram criados
  public static int numPessoas(){
      return num;
    }
  
}