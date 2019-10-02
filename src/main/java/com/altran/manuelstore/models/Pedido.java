package com.altran.manuelstore.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "tabelapedido")
public class Pedido {
    // se for usado mais vezes deve se por numa class à parte
    enum Estado {
        NOVO, APROVADO, ENTREGUE, CANCELADO
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column (name = "codigo")
    private String codigo;
    @Column (name = "data")
    private Date data;
    @Column (name = "comprado")
    private String comprador;
    @Column (name = "estado")
    private Estado estado;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> items;
}
