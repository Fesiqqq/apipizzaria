package br.com.fernando.api_tuesday.controller;

import br.com.fernando.api_tuesday.database.model.Bebida;
import br.com.fernando.api_tuesday.service.BebidaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/bebidas")
@Tag(name = "2. Bebidas", description = "Gestão de Bebidas e Refrescos")
public class BebidaController {

    @Autowired private BebidaService service;

    @Operation(summary = "Listar bebidas", description = "Exibe todas as bebidas do estoque")
    @GetMapping
    public List<Bebida> listar() { return service.listar(); }

    @Operation(summary = "Buscar bebida", description = "Busca uma bebida pelo código ID")
    @GetMapping("/{id}")
    public Bebida buscar(@PathVariable Long id) { return service.buscarPorId(id); }

    @Operation(summary = "Cadastrar bebida", description = "Adiciona uma nova bebida ao sistema")
    @PostMapping
    public Bebida criar(@RequestBody Bebida obj) { return service.salvar(obj); }

    @Operation(summary = "Atualizar estoque", description = "Modifica preço ou nome da bebida")
    @PutMapping("/{id}")
    public Bebida atualizar(@PathVariable Long id, @RequestBody Bebida obj) {
        obj.setId(id);
        return service.salvar(obj);
    }

    @Operation(summary = "Remover bebida", description = "Retira a bebida do catálogo")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { service.excluir(id); }
}