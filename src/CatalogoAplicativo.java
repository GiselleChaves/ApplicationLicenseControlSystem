import java.util.ArrayList;
import java.util.List;

public class CatalogoAplicativo {
  List<Aplicativo> listaAplicativos;
  private int contAplicativos;

  public CatalogoAplicativo(){
    listaAplicativos = new ArrayList<>();
    this.contAplicativos = 0;
  }

  public int getContAplicativos() {
    return contAplicativos;
  }

  public void cadastraAppNoCatalogo(Aplicativo app){
    listaAplicativos.add(app);
    contAplicativos++;
  }

  //OK, FUNCIONANDO!
  public void mostraNomeAplicativos(){
    listaAplicativos
    .stream()
    .map(Aplicativo::getNome)
    .forEach(System.out::println);
  }            

  //OK, FUNCIONANDO!
  public boolean alterarNomeAplicativo(int codigo, String nome){
    for (Aplicativo app : listaAplicativos){
      if(app.getCodigo() == codigo){
        app.setNome(nome);
        return true;
      }
    }
    return false;
  }

  //OK, FUNCIONANDO!
  public double mostraFaturamentoAndroid(){
    return listaAplicativos
          .stream()
          .filter(item -> item instanceof Aplicativo && ((Aplicativo)item).getSo().equals("android"))
          .mapToDouble(item -> ((Aplicativo) item).getTotalFaturamentoAndroid())
          .sum();
  }

  //OK, FUNCIONANDO!
  public double mostraFaturamentoIOS(){
    return listaAplicativos
          .stream()
          .filter(item -> item instanceof Aplicativo && ((Aplicativo)item).getSo().equals("ios"))
          .mapToDouble(item -> ((Aplicativo) item).getTotalFaturamentoIOS())
          .sum();
  }

  
}
/*public void alterarDadosAplicativo(Predicate<Aplicativo> condicao, Function<Aplicativo, T> oper){
    for (int i = 0; i < listaAplicativos.size(); i++) {
      Aplicativo app = listaAplicativos.get(i);
      if (condicao.test(app)) {
          app.oper(i, oper.apply(app));
      }
    }
  } */