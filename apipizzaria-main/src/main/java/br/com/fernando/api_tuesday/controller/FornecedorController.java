package br.com.fernando.api_tuesday.controller;

import br.com.fernando.api_tuesday.database.model.Fornecedor;
import br.com.fernando.api_tuesday.service.FornecedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/fornecedores")
@Tag(name = "5. Fornecedores", description = "Gestão de Parceiros de Insumos")
public class FornecedorController {

    @Autowired private FornecedorService service;

    @Operation(summary = "Ver parceiros", description = "Lista todos os fornecedores de matéria-prima")
    @GetMapping
    public List<Fornecedor> listar() { return service.listar(); }

    @Operation(summary = "Buscar parceiro", description = "Busca detalhes de um fornecedor pelo ID")
    @GetMapping("/{id}")
    public Fornecedor buscar(@PathVariable Long id) { return service.buscarPorId(id); }

    @Operation(summary = "Novo parceiro", description = "Cadastra uma nova empresa fornecedora")
    @PostMapping
    public Fornecedor criar(@RequestBody Fornecedor obj) { return service.salvar(obj); }

    @Operation(summary = "Editar parceiro", description = "Atualiza CNPJ ou Nome do fornecedor")
    @PutMapping("/{id}")
    public Fornecedor atualizar(@PathVariable Long id, @RequestBody Fornecedor obj) {
        obj.setId(id);
        return service.salvar(obj);
    }

    @Operation(summary = "Remover parceiro", description = "Exclui o fornecedor da lista")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { service.excluir(id); }
}