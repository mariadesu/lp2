import java.util.Calendar;
import java.util.GregorianCalendar;

public class Emprest{

  public GregorianCalendar dataEmp;
  public GregorianCalendar dataDev = new GregorianCalendar(1000, 0, 1);
  public String codLiv;
  
  //construtor
  public Emprest(GregorianCalendar data, String codLiv){
    dataEmp = data;
    this.codLiv = codLiv;
  }
  
  //metodos get e set
  public GregorianCalendar getDataEmp(){
    return dataEmp;
  }

  public void setDataEmp(GregorianCalendar novaDataEmp){
    dataEmp = novaDataEmp;
  }
  
  public GregorianCalendar getDataDev(){
    return dataDev;
  }

  public void setDataDev(GregorianCalendar novaDataDev){
    dataDev = novaDataDev;
  }
  
  public String getCodLiv(){
    return codLiv;
  }

  public void setCodLiv(String novoCodLiv){
    codLiv = novoCodLiv;
  }
  
  //metodo toString
  @Override
  public String toString(){
    if (dataDev.equals(new GregorianCalendar(1000, 0, 1))){
      return "[Classe Emprest]\nData do emprestimo: " + dataEmp.get(Calendar.DAY_OF_MONTH) + "/"
      + (dataEmp.get(Calendar.MONTH)+1) + "/" + dataEmp.get(Calendar.YEAR) + "\nData de devolucao: Nao devolvido.\nCodigo do livro: " + codLiv +"\n";
    }
    else{
      return "[Classe Emprest]\nData do emprestimo: " + dataEmp.get(Calendar.DAY_OF_MONTH) + "/"
        + (dataEmp.get(Calendar.MONTH)+1) + "/" + dataEmp.get(Calendar.YEAR) + "\nData de devolucao: "
        + dataDev.get(Calendar.DAY_OF_MONTH) + "/" + (dataDev.get(Calendar.MONTH)+1) + "/"
        + dataDev.get(Calendar.YEAR) + "\nCodigo do livro: " + codLiv +"\n";
    }
  }

}