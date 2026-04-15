package br.com.fernando.api_tuesday.database.repository;
import br.com.fernando.api_tuesday.database.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> { }