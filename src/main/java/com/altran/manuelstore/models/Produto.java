package com.altran.manuelstore.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "tabelaproduto")
public class Produto {

    // geral id sequencial
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @Column (name = "codigo")
    private String codigo;

    @NotNull(message = "{product.name.notnull}")
    @Column (name = "nome")
    private String nome;

    @Column (name = "descricao")
    private String descricao;

    @Column (name = "stock")
    private Integer stock;

    @Column (name = "preco")
    private Float preco;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Atributo> atributos;

}
