package br.senac.tads.dsw.receitas.Controllers;

import br.senac.tads.dsw.receitas.Entities.ReceitaEntity;
import br.senac.tads.dsw.receitas.Service.IReceitaService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/receita")
public class ReceitaController {

    @Autowired
    private IReceitaService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            List<ReceitaEntity> list = service.getAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar receitas. Tente novamente.");
        }
    }

    @PostMapping
    public ResponseEntity<?> insert(@Valid @RequestBody ReceitaEntity obj) {
        try {
            obj = service.insert(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

            return ResponseEntity.created(uri).body(obj);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro de validação: verifique os campos enviados.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar a receita. Tente novamente.");
        }
    }
}
