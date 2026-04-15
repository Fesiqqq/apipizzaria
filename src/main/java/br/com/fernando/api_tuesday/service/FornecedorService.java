package br.com.fernando.api_tuesday.service;

import br.com.fernando.api_tuesday.database.model.Fornecedor;
import br.com.fernando.api_tuesday.database.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> listar() {
        return repository.findAll();
    }

    public Fornecedor buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Fornecedor salvar(Fornecedor obj) {
        return repository.save(obj);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}