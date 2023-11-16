package clientes;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class CatalogoClientes {
    private List<Cliente> listaClientes;

    public CatalogoClientes() {
        if(listaClientes == null){
            listaClientes = new ArrayList<>();
        }
    }

    public void cadastrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Cliente getClienteNaLinha(int linha) {
        if (linha >= listaClientes.size()) {
            return null;
        }
        return listaClientes.get(linha);
    }

    public int getQuantidade() {
        return listaClientes.size();
    }

    public Stream<Cliente> getStream() {
        return listaClientes.stream();
    }

    public Cliente getClienteByCpf(String cpf) {
        return listaClientes.stream()
                .filter(cliente -> cliente.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
    

    public void loadFromFile() {
        Path clientesFilePath = Path.of("clientes/clientes.txt");
        try (Stream<String> clientesStream = Files.lines(clientesFilePath)) {
            clientesStream.forEach(str -> listaClientes.add(Cliente.fromLineFile(str)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        Path clientesFilePath = Path.of("clientes/clientes.txt");
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(clientesFilePath, StandardCharsets.UTF_8))) {
            for (Cliente cliente : listaClientes) {
                writer.println(cliente.toLineFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
