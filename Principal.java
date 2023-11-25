import java.util.Scanner;

public class Principal {
    private static Voo vooAtual;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo à Empresa Aérea Queda Livre");
        System.out.print("Digite o destino do voo (BH-RIO, BH-SP, BH-BRASILIA): ");
        String nomeVoo = scanner.nextLine();

        // Carregar dados do arquivo
        vooAtual = Voo.carregarDadosDoArquivo(nomeVoo);

        int opcao;
        do {
            mostrarMenu();
            System.out.print("Digite sua opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    vooAtual.mostrarListaPassageiros();
                    break;
                case 2:
                    pesquisarPassageiroPorCPF();
                    break;
                case 3:
                    pesquisarPassageiroByNome();
                    break;
                case 4:
                    cadastrarPassageiro();
                    break;
                case 5:
                    removerPassageiro();
                    break;
                case 6:
                    vooAtual.mostrarFilaEspera();
                    break;
                case 9:
                    System.out.println("Saindo do programa. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 9);

        // Salvar dados no arquivo ao encerrar o programa
        vooAtual.salvarDadosNoArquivo();
    }

    private static void pesquisarPassageiroPorCPF() {
        System.out.print("Digite o CPF do passageiro: ");
        String cpf = scanner.nextLine();
        boolean encontrado = false;
        for (Passageiro passageiro : vooAtual.getListaPassageiros()) {
            if (passageiro.getCPF().equals(cpf)) {
                exibirDetalhesPassageiro(passageiro);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Passageiro não consta neste voo.");
        }
    }

    private static void pesquisarPassageiroByNome() {
        System.out.print("Digite o Nome do passageiro: ");
        String nome = scanner.nextLine();
        boolean encontrado = false;
        for (Passageiro passageiro : vooAtual.getListaPassageiros()) {
            if (passageiro.getNome().equals(nome)) {
                exibirDetalhesPassageiro(passageiro);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Passageiro não consta neste voo.");
        }
    }

    private static void cadastrarPassageiro() {
        if (vooAtual.getListaPassageiros().size() < 10) {
            System.out.print("Digite o CPF do passageiro: ");
            String cpf = scanner.nextLine();
            System.out.print("Digite o Nome do passageiro: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o Número da Passagem: ");
            String numeroPassagem = scanner.nextLine();
            System.out.print("Digite o Número da Poltrona: ");
            String numeroPoltrona = scanner.nextLine();
            System.out.print("Digite o Endereço do passageiro: ");
            String endereco = scanner.nextLine();
            System.out.print("Digite o Telefone do passageiro: ");
            String telefone = scanner.nextLine();
            System.out.print("Digite o Número do Voo: ");
            String numeroVoo = scanner.nextLine();
            System.out.print("Digite o Horário do Voo: ");
            String horario = scanner.nextLine();

            Passageiro novoPassageiro = new Passageiro(cpf, nome, endereco, telefone, numeroPassagem, numeroPoltrona, numeroVoo, horario);
            vooAtual.adicionarPassageiro(novoPassageiro);
            System.out.println("Passageiro cadastrado com sucesso.");
        } else {
            System.out.println("A lista de passageiros está cheia. O passageiro não pode ser cadastrado.");
        }
    }

    private static void removerPassageiro() {
        System.out.print("Digite o CPF do passageiro a ser removido: ");
        String cpf = scanner.nextLine();
        for (Passageiro passageiro : vooAtual.getListaPassageiros()) {
            if (passageiro.getCPF().equals(cpf)) {
                vooAtual.removerPassageiro(passageiro);
                System.out.println("Passageiro removido com sucesso.");
                return;
            }
        }
        System.out.println("Passageiro não consta neste voo.");
    }

    private static void exibirDetalhesPassageiro(Passageiro passageiro) {
        System.out.println("\n========== Detalhes do Passageiro ==========\n");
        System.out.println("CPF: " + passageiro.getCPF());
        System.out.println("Nome: " + passageiro.getNome());
        System.out.println("Número da Passagem: " + passageiro.getNumeroPassagem());
        System.out.println("Número da Poltrona: " + passageiro.getNumeroPoltrona());
        System.out.println("Endereço: " + passageiro.getEndereco());
        System.out.println("Telefone: " + passageiro.getTelefone());
        System.out.println("Número do Voo: " + passageiro.getNumeroVoo());
        System.out.println("Horário: " + passageiro.getHorario());
    }

    private static void mostrarMenu() {
        System.out.println("EMPRESA AÉREA QUEDA LIVRE - VOO " + vooAtual.getNome());
        System.out.println("\n =============== MENU DE OPÇÕES ===================\n" );
        System.out.println("[1] Mostrar Lista de Passageiros");
        System.out.println("[2] Pesquisar Passageiro por CPF");
        System.out.println("[3] Pesquisar Passageiro por Nome");
        System.out.println("[4] Cadastrar Passageiro");
        System.out.println("[5] Remover Passageiro");
        System.out.println("[6] Mostrar Fila de Espera");
        System.out.println("[9] Sair");
    }
}
