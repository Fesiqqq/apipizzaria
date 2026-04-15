package br.com.fernando.api_tuesday.controller;

import br.com.fernando.api_tuesday.database.model.Pizza;
import br.com.fernando.api_tuesday.service.PizzaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/pizzas")
@Tag(name = "1. Pizzas", description = "Gerenciamento do Cardápio")
public class PizzaController {

    private final PizzaService service;
    public PizzaController(PizzaService service) { this.service = service; }

    @Operation(summary = "Listar cardápio", description = "Retorna todas as pizzas disponíveis")
    @GetMapping
    public List<Pizza> listar() { return service.listar(); }

    @Operation(summary = "Buscar por ID", description = "Traz detalhes de uma pizza específica")
    @GetMapping("/{id}")
    public Pizza buscarPorId(@PathVariable Long id) { return service.buscarPorId(id); }

    @Operation(summary = "Adicionar Pizza", description = "Cadastra um novo sabor no sistema")
    @PostMapping
    public Pizza criar(@RequestBody Pizza pizza) { return service.salvar(pizza); }

    @Operation(summary = "Atualizar Pizza", description = "Altera dados de uma pizza existente")
    @PutMapping("/{id}")
    public Pizza atualizar(@PathVariable Long id, @RequestBody Pizza pizza) {
        pizza.setId(id);
        return service.salvar(pizza);
    }

    @Operation(summary = "Excluir Pizza", description = "Remove a pizza do cardápio")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { service.excluir(id); }
}