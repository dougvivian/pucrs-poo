import java.util.ArrayList;
import java.util.Scanner;

public class ACMEImobiliaria {
    private Condominio condominio;
    private Scanner entrada;
    public Clientela clientela;

    public ACMEImobiliaria() {
        condominio = new Condominio();
        entrada = new Scanner(System.in);
        clientela = new Clientela();
    }

    public void executar() {
        int opcao;
        do {
            menuOpcoes();
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarCasa();
                    break;
                case 2:
                    consultarCasaEndereco();
                    break;
                case 3:
                    listarCasasCondominio();
                    break;
                case 4:
                    mostrarMaisCara();
                    break;
                case 5:
                    removerCasa();
                    break; 
                case 6:
                    cadastrarCliente();
                    break;
                case 7:
                    consultarClienteCadastrado();
                    break;
                case 8:
                    cadastrarCompraCliente();
                    break;
                case 9:
                    consultarCasasDeUmCliente();
                    break;
                case 10:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 10);
    }

    public void menuOpcoes() {
        System.out.println("\n--- ACME Imobiliária ---");
        System.out.println("[1] Cadastrar uma casa");
        System.out.println("[2] Consultar por endereço");
        System.out.println("[3] Listar todas as casas");
        System.out.println("[4] Ver a casa mais cara");
        System.out.println("[5] Remover uma casa");
        System.out.println("[6] Cadastrar um cliente");
        System.out.println("[7] Consultar clientes cadastrados");
        System.out.println("[8] Cadastrar compra de cliente");
        System.out.println("[9] Listar casas de um cliente");
        System.out.println("[10] Sair");
    }

    // --- MÉTODOS DE APOIO ---
    private void listarCasasCondominio() {
        System.out.println("Lista de casas do condomínio");
        condominio.listarCasas();
    }
    
    
    private void consultarCasasDeUmCliente() {
        System.out.print("Digite o nome do cliente para ver as compras: ");
        String nome = entrada.nextLine();

        // 1. Busca o cliente
        Cliente c = clientela.consultarClientePorNome(nome);

        if (c != null) {
            // 2. Chama o método que retorna o ArrayList
            ArrayList<Casa> listaX = c.getCompradas();

            // 3. Verifica se ele já comprou algo
            if (listaX.isEmpty()) {
                System.out.println("Este cliente ainda não comprou nenhuma casa.");
            } else {
                System.out.println("Casas compradas por " + c.getNome() + ":");
                // 4. Percorre a lista que o objeto Cliente nos devolveu
                for (Casa casa : listaX) {
                    System.out.println("- Endereço: " + casa.getEndereco() + " | Valor: R$ " + casa.getValor());
                }
            }
        } else {
            System.out.println("Erro: Cliente não encontrado.");
        }
    }

    private void cadastrarCompraCliente() {
        System.out.println("--- Cadastro de Compra ---");
        System.out.print("Digite o nome do cliente: ");
        String nome = entrada.nextLine();

        System.out.print("Digite o endereço da casa: ");
        String endereco = entrada.nextLine();

        // 1. Usamos as auxiliares para receber o que os métodos de consulta retornam
        Cliente clienteAux = clientela.consultarClientePorNome(nome);
        Casa casaAux = condominio.consultarCasaEndereco(endereco);

        // 2. Verificamos se ambos existem
        if (clienteAux == null) {
            System.out.println("Erro: Cliente '" + nome + "' não encontrado.");
        } else if (casaAux == null) {
            System.out.println("Erro: Casa no endereço '" + endereco + "' não encontrada.");
        } else {
            // 3. SE AMBOS EXISTEM: Usamos o método do objeto cliente para adicionar a casa
            // Aqui passamos a 'casaAux' para dentro do método do 'clienteAux'
            clienteAux.comprarCasa(casaAux);

            System.out.println("Sucesso: A casa foi adicionada à lista de " + clienteAux.getNome());
        }
    }

    private void consultarClienteCadastrado() {
        System.out.println("Lista de Clientes:");
        clientela.listarClientes();

    }

    private void cadastrarCliente() {
        System.out.print("Nome do Cliente ");
        String nome = entrada.nextLine();
        Cliente novo = new Cliente(nome);
        clientela.cadastrarCliente(novo);
        System.out.println("Cliente cadastrado");
    }

    private void cadastrarCasa() {
        System.out.print("Tamanho (m²): ");
        int tam = entrada.nextInt();
        System.out.print("Valor: ");
        double val = entrada.nextDouble();
        entrada.nextLine(); // Limpa buffer
        System.out.print("Endereço: ");
        String end = entrada.nextLine();

        Casa nova = new Casa(tam, val, end);
        condominio.cadastrarCasa(nova);
        System.out.println("Casa salva!");
    }

    private void consultarCasaEndereco() {
        System.out.print("Digite o endereço para busca: ");
        String end = entrada.nextLine();
        Casa c = condominio.consultarCasaEndereco(end);

        if (c != null) {
            System.out.println("Achamos: " + c.getEndereco() + " | R$ " + c.getValor());
        } else {
            System.out.println("Endereço não encontrado.");
        }
    }

    private void mostrarMaisCara() {
        Casa c = condominio.consultarCasaMaisCara();
        if (c != null) {
            System.out.println("A campeã de preço é: " + c.getEndereco() + " por R$ " + c.getValor());
        } else {
            System.out.println("Lista vazia.");
        }
    }

    private void removerCasa() {
        System.out.print("Digite o endereço da casa a ser removida: ");
        String end = entrada.nextLine();
        boolean sucesso = condominio.removerCasa(end);

        if (sucesso) {
            System.out.println("Removida com sucesso!");
        } else {
            System.out.println("Não encontramos nenhuma casa nesse endereço.");
        }
    }
}