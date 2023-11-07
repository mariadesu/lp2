import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmprestPara{
  
  public GregorianCalendar dataLoc, dataDev;
  public int codUsu;
  
  public EmprestPara(GregorianCalendar dataLoc, GregorianCalendar dataDev, int codUsu){
    this.dataLoc = dataLoc;
    this.dataDev = dataDev;
    this.codUsu = codUsu;
  }
  
  //metodos get e set
  
  public void setDataLoc(GregorianCalendar dataLoc){
    this.dataLoc = dataLoc;
  }
  
  public GregorianCalendar getDataLoc(){
    return dataLoc;
  }
  
  public void setDataDev(GregorianCalendar dataDev){
    this.dataDev = dataDev;
  }
  
  public GregorianCalendar getDataDev(){
    return dataDev;
  }
  
  public void setCodUsu(int codUsu){
    this.codUsu = codUsu;
  }
  
  public int getCodUsu(){
    return codUsu;
  }
  
  //metodo toString
  @Override
  public String toString(){
    return "[Classe EmprestPara]\nData de locacao: "
      + dataLoc.get(Calendar.DAY_OF_MONTH) + "/" + (dataLoc.get(Calendar.MONTH)+1) + "/" + dataLoc.get(Calendar.YEAR)
      + "\nData de devolucao: "
      + dataDev.get(Calendar.DAY_OF_MONTH) + "/" + (dataDev.get(Calendar.MONTH)+1) + "/" + dataDev.get(Calendar.YEAR)
      + "\nCodigo do usuario: " + codUsu +"\n";
  }
  
}