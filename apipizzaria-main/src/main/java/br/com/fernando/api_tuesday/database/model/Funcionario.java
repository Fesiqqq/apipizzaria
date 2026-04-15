package br.com.fernando.api_tuesday.database.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class Funcionario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cargo;
}