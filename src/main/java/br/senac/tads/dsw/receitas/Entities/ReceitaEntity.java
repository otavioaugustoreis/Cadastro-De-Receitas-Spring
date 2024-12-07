package br.senac.tads.dsw.receitas.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/* NÃO ESTÁ FUNCIONANDO
* @Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
* */
@Entity
@Table(name = "tb_receita")
public class ReceitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "O nome não pode ser nulo e nem vazio.")
    private String nome;

    @Column(nullable = false)
    @NotBlank(message = "O modo de preparo não deve estar em branco.")
    private String modoPreparo;

    @Column(nullable = false)
    @NotBlank(message = "Os ingredientes não devem estar em branco.")
    private String ingredientes;

    public ReceitaEntity() {
    }

    public ReceitaEntity(Integer id, String nome, String modoPreparo, String ingredientes) {
        this.id = id;
        this.nome = nome;
        this.modoPreparo = modoPreparo;
        this.ingredientes = ingredientes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
}




