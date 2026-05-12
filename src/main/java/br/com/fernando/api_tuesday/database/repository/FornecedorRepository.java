package br.com.fernando.api_tuesday.database.repository;
import br.com.fernando.api_tuesday.database.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> { }