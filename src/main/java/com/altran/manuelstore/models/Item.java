package com.altran.manuelstore.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table (name = "tabelaitems")
@Entity
public class Item {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    @Column (name = "codigo")
    private String codigo;
    @Column (name = "quantidade")
    private Integer quantidade;
    @Column (name = "preco")
    private Double preco;
    @OneToOne
    private Produto produto;
    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Pedido pedido;

}
