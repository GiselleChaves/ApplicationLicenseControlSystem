package aplicativos;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CatalogoAplicativos {
    List<Aplicativo> listaAplicativos;
    private int contAplicativos;

    public CatalogoAplicativos(){
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

    public void alterarNomeAplicativo(Predicate<Aplicativo> condicao, Consumer<Aplicativo> oper){
        for (Aplicativo app : listaAplicativos){
        if (condicao.test(app)) {
            oper.accept(app);
        }
        }
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

    public Aplicativo getProdutoNaLinha(int linha) {
        if (linha >= listaAplicativos.size()) {
            return null;
        }
        return listaAplicativos.get(linha);
    }

    public int getQtdade() {
        return listaAplicativos.size();
    }

    public Stream<Aplicativo> getStream() {
        return listaAplicativos.stream();
    }

    public void loadFromFile() {
        Path appsFilePath = Path.of("aplicativos/apps.txt");
        try (Stream<String> appsStream = Files.lines(appsFilePath)) {
            appsStream.forEach(str -> listaAplicativos.add(Aplicativo.fromLineFile(str)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        Path appsFilePath = Path.of("aplicativos/apps.txt");
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(appsFilePath, StandardCharsets.UTF_8))) {
            for (Aplicativo app : listaAplicativos) {
                writer.println(app.toLineFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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