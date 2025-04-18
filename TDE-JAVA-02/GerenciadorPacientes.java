import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorPacientes {
    private static final String FILE_NAME = "pacientes.txt";

    public static void incluirPaciente(Paciente paciente) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(paciente.toString());
            writer.newLine();
        }
    }

    public static List<Paciente> carregarPacientes() throws IOException {
        List<Paciente> pacientes = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    int numero = Integer.parseInt(parts[0]);
                    double peso = Double.parseDouble(parts[1]);
                    double altura = Double.parseDouble(parts[2]);
                    pacientes.add(new Paciente(numero, peso, altura));
                }
            }
        }
        return pacientes;
    }

    public static void salvarPacientes(List<Paciente> pacientes) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Paciente paciente : pacientes) {
                writer.write(paciente.toString());
                writer.newLine();
            }
        }
    }

    public static void alterarPaciente(int numero, double novoPeso, double novaAltura) throws IOException {
        List<Paciente> pacientes = carregarPacientes();
        for (Paciente paciente : pacientes) {
            if (paciente.getNumero() == numero) {
                paciente.setPeso(novoPeso);
                paciente.setAltura(novaAltura);
                salvarPacientes(pacientes);
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    public static void excluirPaciente(int numero) throws IOException {
        List<Paciente> pacientes = carregarPacientes();
        pacientes.removeIf(paciente -> paciente.getNumero() == numero);
        salvarPacientes(pacientes);
    }

    public static void consultarPaciente(int numero) throws IOException {
        List<Paciente> pacientes = carregarPacientes();
        for (Paciente paciente : pacientes) {
            if (paciente.getNumero() == numero) {
                paciente.listarPaciente();
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    public static void listarTodosPacientes() throws IOException {
        List<Paciente> pacientes = carregarPacientes();
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            for (Paciente paciente : pacientes) {
                paciente.listarPaciente();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Gerenciador de Pacientes ===");
            System.out.println("1. Incluir Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Excluir Paciente");
            System.out.println("4. Consultar Paciente");
            System.out.println("5. Listar Todos os Pacientes");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Número: ");
                    int numero = scanner.nextInt();
                    System.out.print("Peso: ");
                    double peso = scanner.nextDouble();
                    System.out.print("Altura: ");
                    double altura = scanner.nextDouble();
                    incluirPaciente(new Paciente(numero, peso, altura));
                    break;
                case 2:
                    System.out.print("Número do paciente a alterar: ");
                    numero = scanner.nextInt();
                    System.out.print("Novo peso: ");
                    peso = scanner.nextDouble();
                    System.out.print("Nova altura: ");
                    altura = scanner.nextDouble();
                    alterarPaciente(numero, peso, altura);
                    break;
                case 3:
                    System.out.print("Número do paciente a excluir: ");
                    numero = scanner.nextInt();
                    excluirPaciente(numero);
                    break;
                case 4:
                    System.out.print("Número do paciente a consultar: ");
                    numero = scanner.nextInt();
                    consultarPaciente(numero);
                    break;
                case 5:
                    listarTodosPacientes();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
