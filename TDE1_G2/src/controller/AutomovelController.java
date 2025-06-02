package controller;

import model.Automovel;
import model.AutomovelRepository;
import java.util.List;
import java.util.Optional;

public class AutomovelController {
    private AutomovelRepository repository;

    public AutomovelController() {
        this.repository = new AutomovelRepository();
    }

    public boolean adicionarAutomovel(String placa, String modelo, String marca, int ano, double valor) {
        if (repository.buscarPorPlaca(placa).isPresent()) {
            return false;
        }
        repository.adicionar(new Automovel(placa, modelo, marca, ano, valor));
        return true;
    }

    public boolean removerAutomovel(String placa) {
        return repository.remover(placa);
    }

    public Optional<Automovel> buscarAutomovel(String placa) {
        return repository.buscarPorPlaca(placa);
    }

    public boolean atualizarAutomovel(String placa, String modelo, String marca, int ano, double valor) {
        Optional<Automovel> automovelOpt = repository.buscarPorPlaca(placa);
        if (automovelOpt.isPresent()) {
            Automovel auto = automovelOpt.get();
            auto.setModelo(modelo);
            auto.setMarca(marca);
            auto.setAno(ano);
            auto.setValor(valor);
            return true;
        }
        return false;
    }

    public List<Automovel> listarAutomoveis(int criterio) {
        switch (criterio) {
            case 1: return repository.listarPorPlaca();
            case 2: return repository.listarPorModelo();
            case 3: return repository.listarPorMarca();
            default: return repository.listarPorPlaca();
        }
    }

    public void salvarDados() {
        repository.salvarDados();
    }
}