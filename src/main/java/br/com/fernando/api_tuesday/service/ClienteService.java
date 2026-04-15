package br.com.fernando.api_tuesday.service;

import br.com.fernando.api_tuesday.database.model.Cliente;
import br.com.fernando.api_tuesday.database.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listar() {
        return repository.findAll();
    }

    // MUDANÇA AQUI: Agora ele lança um erro se não encontrar o ID
    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + id));
    }

    public Cliente salvar(Cliente obj) {
        return repository.save(obj);
    }

    public void excluir(Long id) {
        // MUDANÇA AQUI: Verifica se o ID existe antes de tentar deletar
        if (!repository.existsById(id)) {
            throw new RuntimeException("Não é possível excluir: Cliente não encontrado!");
        }
        repository.deleteById(id);
    }
}