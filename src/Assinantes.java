import java.util.ArrayList;
import java.util.List;

public class Assinantes {
  List<Assinatura> listaAssinaturas;
  private int contAssinaturas;

  public Assinantes(){
    listaAssinaturas = new ArrayList<>();
    contAssinaturas = 0;
  }

  public void adicionarAssinatura(Assinatura assinatura){
    listaAssinaturas.add(assinatura);
    contAssinaturas++;
  }

  public void mostrarAssinaturas(){
    for (Assinatura assin : listaAssinaturas) {
      System.out.println("Código Assinatura: " + getCodigoAssinatura() + ", Código do Aplicativo: " + 
      getCodigoApp() + ", CPF do Cliente: " + getCpfCliente() + ", Data de Início da Vigencia: " + 
      getMesInicioVigencia() + "/" + getAnoInicioVigencia());
    }
  }

}
