package assinaturas;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import clientes.*;
import assinaturas.*;
import aplicativos.*;

public class CatalogoAssinaturas {
  List<Assinatura> listaAssinaturas;
  private int contAssinaturas;

  public CatalogoAssinaturas(){
    listaAssinaturas = new ArrayList<>();
    this.contAssinaturas = 0;
  }

  public int getContAssinaturas() {
    return contAssinaturas;
  }

  public void setContAssinaturas(int cont) {
    this.contAssinaturas = contAssinaturas;
  }

  public void cadastraAssinaturaNoCatalogo(Assinatura app){
    listaAssinaturas.add(app);
    contAssinaturas++;
  }

  public void removerAssinatura(Assinatura assinaturaParaRemover) {
    listaAssinaturas.remove(assinaturaParaRemover);
    contAssinaturas--;
  }

  public Assinatura getAssinaturaNaLinha(int linha) {
    if (linha >= listaAssinaturas.size()) {
        return null;
    }
    return listaAssinaturas.get(linha);
  }

  public Assinatura getAssinaturaPorCPFECodigoApp(String cpf, int codigoApp) {
    Optional<Assinatura> assinaturaEncontrada = listaAssinaturas.stream()
        .filter(a -> a.getCpfCliente().equals(cpf) && a.getCodigoApp() == codigoApp)
        .findFirst();

    return assinaturaEncontrada.orElse(null);
  }

  public void loadFromFile() {
        Path appsFilePath = Path.of("assinaturas/assinaturas.txt");
        try (Stream<String> appsStream = Files.lines(appsFilePath)) {
            appsStream.forEach(str -> listaAssinaturas.add(Assinatura.fromLineFile(str)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        Path appsFilePath = Path.of("assinaturas/assinaturas.txt");
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(appsFilePath, StandardCharsets.UTF_8))) {
            for (Assinatura assinatura : listaAssinaturas) {
                writer.println(assinatura.toLineFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
}