package view;

import controller.AutomovelController;
import model.Automovel;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AutomovelView {
    private AutomovelController controller;
    private Scanner scanner;

    public AutomovelView() {
        this.controller = new AutomovelController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n=== Gerenciador de Automóveis ===");
            System.out.println("1 - Incluir automóvel");
            System.out.println("2 - Remover automóvel");
            System.out.println("3 - Alterar dados de automóvel");
            System.out.println("4 - Consultar automóvel por placa");
            System.out.println("5 - Listar automóveis (ordenado)");
            System.out.println("6 - Salvar e sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1: incluirAutomovel(); break;
                case 2: removerAutomovel(); break;
                case 3: alterarAutomovel(); break;
                case 4: consultarAutomovel(); break;
                case 5: listarAutomoveis(); break;
                case 6: 
                    controller.salvarDados();
                    System.exit(0);
                    break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private void incluirAutomovel() {
        System.out.println("\n--- Inclusão de Automóvel ---");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        if (controller.adicionarAutomovel(placa, modelo, marca, ano, valor)) {
            System.out.println("Automóvel cadastrado com sucesso!");
        } else {
            System.out.println("Erro: Já existe um automóvel com esta placa!");
        }
    }

    private void removerAutomovel() {
        System.out.println("\n--- Remoção de Automóvel ---");
        System.out.print("Digite a placa do automóvel a ser removido: ");
        String placa = scanner.nextLine();

        if (controller.removerAutomovel(placa)) {
            System.out.println("Automóvel removido com sucesso!");
        } else {
            System.out.println("Automóvel não encontrado!");
        }
    }

    private void alterarAutomovel() {
        System.out.println("\n--- Alteração de Automóvel ---");
        System.out.print("Digite a placa do automóvel a ser alterado: ");
        String placa = scanner.nextLine();

        Optional<Automovel> autoOpt = controller.buscarAutomovel(placa);
        if (autoOpt.isEmpty()) {
            System.out.println("Automóvel não encontrado!");
            return;
        }

        Automovel auto = autoOpt.get();
        System.out.println("Dados atuais: " + auto);
        System.out.println("Informe os novos dados:");

        System.out.print("Modelo (" + auto.getModelo() + "): ");
        String modelo = scanner.nextLine();
        System.out.print("Marca (" + auto.getMarca() + "): ");
        String marca = scanner.nextLine();
        System.out.print("Ano (" + auto.getAno() + "): ");
        int ano = scanner.nextInt();
        System.out.print("Valor (" + auto.getValor() + "): ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        if (controller.atualizarAutomovel(placa, modelo, marca, ano, valor)) {
            System.out.println("Automóvel atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar automóvel!");
        }
    }

    private void consultarAutomovel() {
        System.out.println("\n--- Consulta de Automóvel ---");
        System.out.print("Digite a placa do automóvel a ser consultado: ");
        String placa = scanner.nextLine();

        Optional<Automovel> autoOpt = controller.buscarAutomovel(placa);
        if (autoOpt.isPresent()) {
            System.out.println("\nDados do Automóvel:");
            System.out.println(autoOpt.get());
        } else {
            System.out.println("Automóvel não encontrado!");
        }
    }

    private void listarAutomoveis() {
        System.out.println("\n--- Listagem de Automóveis ---");
        System.out.println("Ordenar por:");
        System.out.println("1 - Placa");
        System.out.println("2 - Modelo");
        System.out.println("3 - Marca");
        System.out.print("Escolha: ");
        int criterio = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        List<Automovel> lista = controller.listarAutomoveis(criterio);
        System.out.println("\nLista de Automóveis:");
        if (lista.isEmpty()) {
            System.out.println("Nenhum automóvel cadastrado.");
        } else {
            lista.forEach(System.out::println);
        }
    }
}