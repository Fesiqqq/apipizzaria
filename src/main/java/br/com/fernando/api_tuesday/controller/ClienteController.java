package br.com.fernando.api_tuesday.controller;

import br.com.fernando.api_tuesday.database.model.Cliente;
import br.com.fernando.api_tuesday.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
@Tag(name = "3. Clientes", description = "Cadastro de Clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Operation(summary = "Listar clientes", description = "Lista todos os clientes cadastrados")
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @Operation(summary = "Dados do cliente", description = "Busca perfil de um cliente pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        Cliente obj = service.buscarPorId(id);
        return ResponseEntity.ok(obj);
    }

    @Operation(summary = "Novo cliente", description = "Registra um novo cliente na base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos enviados")
    })
    @PostMapping
    public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente obj) {
        Cliente salvo = service.salvar(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @Operation(summary = "Editar cliente", description = "Atualiza informações do cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado"),
            @ApiResponse(responseCode = "400", description = "Erro de validação"),
            @ApiResponse(responseCode = "404", description = "Cliente não existe")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente obj) {
        service.buscarPorId(id);
        obj.setId(id);
        Cliente atualizado = service.salvar(obj);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Excluir cadastro", description = "Remove o cliente do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}