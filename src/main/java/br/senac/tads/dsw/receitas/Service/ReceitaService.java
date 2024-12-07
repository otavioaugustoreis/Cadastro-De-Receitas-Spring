package br.senac.tads.dsw.receitas.Service;


import br.senac.tads.dsw.receitas.Entities.ReceitaEntity;
import br.senac.tads.dsw.receitas.Repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ReceitaService implements Serializable, IReceitaService {
    private static final long serialVersionUID = 1L;

    @Autowired
    private ReceitaRepository receitaRepository;


    @Override
    public ReceitaEntity insert(ReceitaEntity receita) {
        return receitaRepository.save(receita);
    }

    @Override
    public List<ReceitaEntity> getAll() {
        return receitaRepository.findAll();
    }

}


