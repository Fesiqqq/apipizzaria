package br.com.fernando.api_tuesday.database.repository;

import br.com.fernando.api_tuesday.database.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}