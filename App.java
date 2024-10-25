import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("==== Menu Principal ====");
            System.out.println("1- Cadastrar Usuário");
            System.out.println("2- Acessar Conta");
            System.out.println("3- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    acessarConta();
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);
    }

    private static void cadastrarUsuario() {
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Número da Conta: ");
        int numConta = scanner.nextInt();
        System.out.print("Senha: ");
        int senha = scanner.nextInt();
        System.out.print("Saldo Inicial: ");
        double saldo = scanner.nextDouble();

        Cliente cliente = new Cliente(nome, cpf, email, telefone, numConta, senha, saldo);
        clientes.add(cliente);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void acessarConta() {
        System.out.print("Digite o número da conta: ");
        int numConta = scanner.nextInt();
        System.out.print("Digite a senha: ");
        int senha = scanner.nextInt();

        Cliente cliente = autenticar(numConta, senha);
        if (cliente != null) {
            System.out.println("Acesso permitido!");
            menuConta(cliente);
        } else {
            System.out.println("Número da conta ou senha incorretos!");
        }
    }

    private static Cliente autenticar(int numConta, int senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getNumConta() == numConta && cliente.getSenha() == senha) {
                return cliente;
            }
        }
        return null;
    }

    private static void menuConta(Cliente cliente) {
        int opcao;
        do {
            System.out.println("\n==== Menu da Conta ====");
            System.out.println("1- Sacar");
            System.out.println("2- Depositar");
            System.out.println("3- Informações");
            System.out.println("4- Ver Extrato");
            System.out.println("5- Sair da Conta");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    cliente.saque(valorSaque);
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    cliente.depositar(valorDeposito);
                    break;
                case 3:
                    cliente.informacoes();
                    break;
                case 4:
                    cliente.verExtrato();
                    break;
                case 5:
                    System.out.println("Saindo da conta...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
    }
}
