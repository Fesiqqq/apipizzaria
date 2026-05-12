package br.com.fernando.api_tuesday.service;

import br.com.fernando.api_tuesday.database.model.Cliente;
import br.com.fernando.api_tuesday.database.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com o ID: " + id));
    }

    public Cliente salvar(Cliente obj) {
        return repository.save(obj);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não é possível excluir: Cliente não encontrado!");
        }
        repository.deleteById(id);
    }

    public Cliente atualizar(Long id, Cliente obj) {
        return repository.findById(id).map(clienteExistente -> {
            clienteExistente.setNome(obj.getNome());
            clienteExistente.setEmail(obj.getEmail());
            return repository.save(clienteExistente);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não é possível atualizar: Cliente não encontrado!"));
    }
}