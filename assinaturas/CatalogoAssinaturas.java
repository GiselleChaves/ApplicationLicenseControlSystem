package assinaturas;

import java.util.ArrayList;
import java.util.List;

import clientes.*;
import assinaturas.*;
import aplicativos.*;

public class CatalogoAssinaturas {
  List<Aplicativo> listaAplicativos;
  private int contAplicativos;

  public CatalogoAssinaturas(){
    listaAplicativos = new ArrayList<>();
    this.contAplicativos = 0;
  }

  public int getContAplicativos() {
    return contAplicativos;
  }

  public void setContAplicativos(int cont) {
    this.contAplicativos = contAplicativos;
  }

  public void cadastraAppNoCatalogo(Aplicativo app){
    listaAplicativos.add(app);
    contAplicativos++;
  }

  public void mostraNomeAplicativos(){
    listaAplicativos
    .stream()
    .map(Aplicativo::getNome)
    .forEach(System.out::println);
  }            

  public void mostraAssinantesDoApp(){}

  public void alterarDadosAplicativo(Predicate<Aplicativo> condicao, Consumer<Aplicativo> oper){
    for(Aplicativo app: listaAplicativos){
      if(condicao.test(app)){
        oper.accept(app);
      }
    }
  }

  public double mostraFaturamentoAndroid(){
    return listaAplicativos
          .stream()
          .filter(a -> a.getSo().equals("android"))
          .mapToDouble(a -> a.getValorMensalAssinatura())
          .sum();
  }

  public void mostraFaturamentoIOS(){
    listaAplicativos
    .stream()
    .filter(a -> a.getSo().equals("ios"))
    .toList();
  }

  
}