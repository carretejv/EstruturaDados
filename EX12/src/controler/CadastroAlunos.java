package controler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroAlunos {
    private static final String ARQUIVO = "alunos.txt";
    private static List<Aluno> alunos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        carregarDados();
        
        System.out.println("Caminho do arquivo: " + new File("alunos.txt").getAbsolutePath());
        
        int opcao;
        do {
            System.out.println("\n--- SISTEMA DE CADASTRO DE ALUNOS ---");
            System.out.println("1. Cadastrar novo aluno");
            System.out.println("2. Listar todos os alunos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    salvarDados();
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    private static void cadastrarAluno() {
        System.out.println("\n--- CADASTRO DE ALUNO ---");
        
        System.out.print("Matrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Coeficiente de Rendimento: ");
        double cr = scanner.nextDouble();
        scanner.nextLine(); 
        
        Aluno aluno = new Aluno(matricula, nome, cr);
        alunos.add(aluno);
        
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void listarAlunos() {
        System.out.println("\n--- LISTA DE ALUNOS CADASTRADOS ---");
        
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    private static void carregarDados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    int matricula = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    double cr = Double.parseDouble(dados[2]);
                    alunos.add(new Aluno(matricula, nome, cr));
                }
            }
            System.out.println("Dados carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando novo arquivo...");
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    private static void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Aluno aluno : alunos) {
                writer.write(aluno.getMatricula() + ";" + aluno.getNome() + ";" + aluno.getCr());
                writer.newLine();
            }
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}

class Aluno {
    private int matricula;
    private String nome;
    private double cr;

    public Aluno(int matricula, String nome, double cr) {
        this.matricula = matricula;
        this.nome = nome;
        this.cr = cr;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getCr() {
        return cr;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + " | Nome: " + nome + " | CR: " + cr;
    }
    
}