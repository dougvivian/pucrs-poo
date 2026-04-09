import java.util.ArrayList;

public class Clientela {
    private ArrayList<Cliente> clientes;

    public Clientela() {
        clientes = new ArrayList<Cliente>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente consultarClientePorNome(String nome) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente aux = clientes.get(i);
            if (aux.getNome().equals(nome)) {
                return aux;
            }
        }
        return null;
    }

    public void listarClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("Nome: " + clientes.get(i).getNome());

        }
    }
}
