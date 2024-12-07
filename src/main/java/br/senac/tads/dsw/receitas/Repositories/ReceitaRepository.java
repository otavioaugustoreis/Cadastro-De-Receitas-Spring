package br.senac.tads.dsw.receitas.Repositories;

import br.senac.tads.dsw.receitas.Entities.ReceitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<ReceitaEntity, Integer> {
}

