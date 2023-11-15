import java.util.List;
import java.util.ArrayList;

public class Assinatura {
  private String codigoAssinatura;
  private String codigoApp;
  private String cpfCliente;
  private String mesInicioVigencia;
  private String anoInicioVigencia;
  private String mesFimVigencia;
  private String anoFimVigencia;
  private int contAplicativos;
  List<Cliente> listaClientes;
  List<Assinatura> listaAssinaturas;


  public Assinatura(String codigoAssinatura, String codigoApp, String cpfCliente, String mesInicioVigencia,
                    String anoInicioVigencia) {
    this.codigoAssinatura = codigoAssinatura;
    this.codigoApp = codigoApp;
    this.cpfCliente = cpfCliente;
    this.mesInicioVigencia = mesInicioVigencia;
    this.anoInicioVigencia = anoInicioVigencia;
    this.contAplicativos = 0;
    if(listaClientes == null){
      listaClientes = new ArrayList();
    }
  }

  public void adicionarAssinatura(Assinatura assinatura){
    listaAssinaturas.add(assinatura);
    contAplicativos++;
  }

  public void mostrarAssinantes(){
    listaClientes
    .stream()
    .filter()

  }

  public int getContAplicativos(){
    return contAplicativos;
  }

  public String getCodigoAssinatura() {
    return codigoAssinatura;
  }

  public void addCliente(Cliente cliente){
    listaClientes.add(cliente);
  }

  public void setCodigoAssinatura(String codigoAssinatura) {
    this.codigoAssinatura = codigoAssinatura;
  }


  public String getCodigoApp() {
    return codigoApp;
  }


  public void setCodigoApp(String codigoApp) {
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
    return mesFimVigencia;
  }


  public void setMesFimVigencia(String mesFimVigencia) {
    this.mesFimVigencia = mesFimVigencia;
  }


  public String getAnoFimVigencia() {
    return anoFimVigencia;
  }


  public void setAnoFimVigencia(String anoFimVigencia) {
    this.anoFimVigencia = anoFimVigencia;
  }
  
}
