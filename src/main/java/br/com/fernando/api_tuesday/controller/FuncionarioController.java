package br.com.fernando.api_tuesday.controller;

import br.com.fernando.api_tuesday.database.model.Funcionario;
import br.com.fernando.api_tuesday.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/funcionarios")
@Tag(name = "4. Funcionários", description = "Gestão de Recursos Humanos")
public class FuncionarioController {

    @Autowired private FuncionarioService service;

    @Operation(summary = "Listar equipe", description = "Exibe todos os colaboradores ativos")
    @GetMapping
    public List<Funcionario> listar() { return service.listar(); }

    @Operation(summary = "Ver funcionário", description = "Traz detalhes de um colaborador específico")
    @GetMapping("/{id}")
    public Funcionario buscar(@PathVariable Long id) { return service.buscarPorId(id); }

    @Operation(summary = "Contratar", description = "Cadastra um novo funcionário")
    @PostMapping
    public Funcionario criar(@RequestBody Funcionario obj) { return service.salvar(obj); }

    @Operation(summary = "Alterar cargo/dados", description = "Atualiza informações do colaborador")
    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody Funcionario obj) {
        obj.setId(id);
        return service.salvar(obj);
    }

    @Operation(summary = "Demitir/Remover", description = "Remove o colaborador do sistema")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { service.excluir(id); }
}