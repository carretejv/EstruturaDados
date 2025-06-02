package model;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AutomovelRepository {
    private static final String ARQUIVO_DADOS = "automoveis.txt";
    private List<Automovel> automoveis = new ArrayList<>();

    public AutomovelRepository() {
        carregarDados();
    }

    public void adicionar(Automovel automovel) {
        automoveis.add(automovel);
    }

    public boolean remover(String placa) {
        return automoveis.removeIf(a -> a.getPlaca().equalsIgnoreCase(placa));
    }

    public Optional<Automovel> buscarPorPlaca(String placa) {
        return automoveis.stream()
                .filter(a -> a.getPlaca().equalsIgnoreCase(placa))
                .findFirst();
    }

    public List<Automovel> listarPorPlaca() {
        return automoveis.stream()
                .sorted(Comparator.comparing(Automovel::getPlaca))
                .collect(Collectors.toList());
    }

    public List<Automovel> listarPorModelo() {
        return automoveis.stream()
                .sorted(Comparator.comparing(Automovel::getModelo))
                .collect(Collectors.toList());
    }

    public List<Automovel> listarPorMarca() {
        return automoveis.stream()
                .sorted(Comparator.comparing(Automovel::getMarca))
                .collect(Collectors.toList());
    }

    public void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_DADOS))) {
            for (Automovel auto : automoveis) {
                writer.write(String.format("%s,%s,%s,%d,%.2f",
                        auto.getPlaca(),
                        auto.getModelo(),
                        auto.getMarca(),
                        auto.getAno(),
                        auto.getValor()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    private void carregarDados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_DADOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                Automovel auto = new Automovel(
                        dados[0],
                        dados[1],
                        dados[2],
                        Integer.parseInt(dados[3]),
                        Double.parseDouble(dados[4]));
                automoveis.add(auto);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de dados não encontrado. Será criado um novo ao sair.");
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
}