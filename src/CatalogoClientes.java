
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import Clientes.Cliente;

public class CatalogoClientes {
    private List<Cliente> clientes;

    public CatalogoClientes() {
        clientes = new ArrayList<>();
    }

    public void cadastra(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente getClienteNaLinha(int linha) {
        if (linha >= clientes.size()) {
            return null;
        }
        return clientes.get(linha);
    }

    public int getQtdade() {
        return clientes.size();
    }

    public Stream<Cliente> getStream() {
        return clientes.stream();
    }

    public void loadFromFile() {
        Path clientesFilePath = Path.of("clientes.txt");
        try (Stream<String> clientesStream = Files.lines(clientesFilePath)) {
            clientesStream.forEach(str -> clientes.add(Cliente.fromLineFile(str)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        Path clientesFilePath = Path.of("clientes.txt");
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(clientesFilePath, StandardCharsets.UTF_8))) {
            for (Cliente cliente : clientes) {
                writer.println(cliente.toLineFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
