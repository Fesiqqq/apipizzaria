package br.com.fernando.api_tuesday.service;

import br.com.fernando.api_tuesday.database.model.Bebida;
import br.com.fernando.api_tuesday.database.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository repository;

    public List<Bebida> listar() {
        return repository.findAll();
    }

    public Bebida buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Bebida salvar(Bebida obj) {
        return repository.save(obj);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}