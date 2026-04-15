package br.com.fernando.api_tuesday.database.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class Bebida {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
}