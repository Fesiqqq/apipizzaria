package br.com.fernando.api_tuesday.service;

import br.com.fernando.api_tuesday.database.model.Fornecedor;
import br.com.fernando.api_tuesday.database.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> listar() {
        return repository.findAll();
    }

    public Fornecedor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado com o ID: " + id));
    }

    public Fornecedor salvar(Fornecedor obj) {
        return repository.save(obj);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não é possível excluir: Fornecedor não encontrado!");
        }
        repository.deleteById(id);
    }

    public Fornecedor atualizar(Long id, Fornecedor obj) {
        return repository.findById(id).map(fornecedorExistente -> {
            // Aqui você define os campos que quer atualizar (ex: Nome e CNPJ)
            fornecedorExistente.setNome(obj.getNome());
            // fornecedorExistente.setCnpj(obj.getCnpj());
            return repository.save(fornecedorExistente);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não é possível atualizar: Fornecedor não encontrado!"));
    }
}