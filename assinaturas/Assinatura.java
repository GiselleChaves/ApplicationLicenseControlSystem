package assinaturas;
import java.util.List;

import aplicativos.Aplicativo;

import java.util.ArrayList;

public class Assinatura {
  private String codigoAssinatura;
  private int codigoApp;
  private String cpfCliente;
  private String mesInicioVigencia;
  private String anoInicioVigencia;
  private String mesFimVigencia;
  private String anoFimVigencia;
  List<Assinatura> listaAssinaturas;



  public Assinatura(String codigoAssinatura, int codigoApp, String cpfCliente, String mesInicioVigencia,
                    String anoInicioVigencia) {
    this.codigoAssinatura = codigoAssinatura;
    this.codigoApp = codigoApp;
    this.cpfCliente = cpfCliente;
    this.mesInicioVigencia = mesInicioVigencia;
    this.anoInicioVigencia = anoInicioVigencia;
    if(listaAssinaturas == null){
      listaAssinaturas = new ArrayList<Assinatura>();
    }
  }

  public void adicionarAssinatura(Assinatura assinatura){
    listaAssinaturas.add(assinatura);
  }

  public void mostrarAssinantes(){
    for(Assinatura assinatura: listaAssinaturas){
      System.out.println(assinatura.getCpfCliente());
    }
  }

  public String getCodigoAssinatura() {
    return codigoAssinatura;
  }


  public void setCodigoAssinatura(String codigoAssinatura) {
    this.codigoAssinatura = codigoAssinatura;
  }


  public int getCodigoApp() {
    return codigoApp;
  }


  public void setCodigoApp(int codigoApp) {
    this.codigoApp = codigoApp;
  }


  public String getCpfCliente() {
    return cpfCliente;
  }


  public void setCpfCliente(String cpfCliente) {
    this.cpfCliente = cpfCliente;
  }


  public String getMesInicioVigencia() {
    return mesInicioVigencia;
  }


  public void setMesInicioVigencia(String mesInicioVigencia) {
    this.mesInicioVigencia = mesInicioVigencia;
  }


  public String getAnoInicioVigencia() {
    return anoInicioVigencia;
  }


  public void setAnoInicioVigencia(String anoInicioVigencia) {
    this.anoInicioVigencia = anoInicioVigencia;
  }


  public String getMesFimVigencia() {
    String informação = "Sem fim previsto.";
    return informação;
  }

  public void setMesFimVigencia(String mesFimVigencia) {
    this.mesFimVigencia = mesFimVigencia;
  }


  public String getAnoFimVigencia() {
    String informação = "Sem fim previsto.";
    return informação;
  }


  public void setAnoFimVigencia(String anoFimVigencia) {
    this.anoFimVigencia = anoFimVigencia;
  }

  public String toLineFile() {
      return codigoAssinatura+ ","+codigoApp+","+cpfCliente+","+mesInicioVigencia+","+anoInicioVigencia;
  }

  public static Assinatura fromLineFile(String line) {
    String[] tokens = line.split(",");
    
    String codigoAssinatura = tokens[0];
    int codigoApp = Integer.parseInt(tokens[1]);
    String cpfCliente = tokens[2];
    String mesInicio = tokens[3];
    String anoInicio = tokens[4];

    return new Assinatura(codigoAssinatura, codigoApp, cpfCliente, mesInicio, anoInicio);
  }
  
  
}