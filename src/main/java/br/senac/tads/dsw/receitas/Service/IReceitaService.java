package br.senac.tads.dsw.receitas.Service;

import br.senac.tads.dsw.receitas.Entities.ReceitaEntity;

import java.util.List;

public interface IReceitaService {
    ReceitaEntity insert(ReceitaEntity receita);
    List<ReceitaEntity> getAll();
}
