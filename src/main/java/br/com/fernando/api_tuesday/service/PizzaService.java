package br.com.fernando.api_tuesday.service;

import br.com.fernando.api_tuesday.database.model.Pizza;
import br.com.fernando.api_tuesday.database.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository repository;

    public List<Pizza> listar() {
        return repository.findAll();
    }

    public Pizza buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Pizza salvar(Pizza obj) {
        return repository.save(obj);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}