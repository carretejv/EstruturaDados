import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- Sistema de Gestão de Pacientes ---");
            System.out.println("1. Incluir Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Excluir Paciente");
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    incluirPaciente();
                    break;
                case 2:
                    alterarPaciente();
                    break;
                case 3:
                    excluirPaciente();
                    break;
                case 4:
                    listarPacientes();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static void incluirPaciente() {
        System.out.print("ID do paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Peso do paciente: ");
        double peso = scanner.nextDouble();

        System.out.print("Altura do paciente: ");
        double altura = scanner.nextDouble();

        System.out.print("Sexo do paciente (1 para Masculino, 2 para Feminino): ");
        int sexo = scanner.nextInt();

        Paciente paciente = new Paciente(id, nome, peso, altura, sexo);
        pacientes.add(paciente);
        System.out.println("Paciente incluído com sucesso!");
    }

    private static void alterarPaciente() {
        System.out.print("ID do paciente a ser alterado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                System.out.print("Novo nome: ");
                paciente.setNome(scanner.nextLine());

                System.out.print("Novo peso: ");
                paciente.setPeso(scanner.nextDouble());

                System.out.print("Nova altura: ");
                paciente.setAltura(scanner.nextDouble());

                System.out.print("Novo sexo (1 para Masculino, 2 para Feminino): ");
                paciente.setSexo(scanner.nextInt());

                System.out.println("Paciente alterado com sucesso!");
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    private static void excluirPaciente() {
        System.out.print("ID do paciente a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                pacientes.remove(paciente);
                System.out.println("Paciente excluído com sucesso!");
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    private static void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Não há pacientes cadastrados.");
        } else {
            System.out.println("\n--- Lista de Pacientes ---");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }
}
