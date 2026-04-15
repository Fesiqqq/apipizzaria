package br.com.fernando.api_tuesday.service;

import br.com.fernando.api_tuesday.database.model.Funcionario;
import br.com.fernando.api_tuesday.database.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> listar() {
        return repository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Funcionario salvar(Funcionario obj) {
        return repository.save(obj);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}