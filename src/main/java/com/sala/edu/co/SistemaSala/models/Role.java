package com.sala.edu.co.SistemaSala.models;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity{

    @Column(name = "nombre")
    @Getter
    @Setter
    private String nombre;

    //Eager hace que traiga todos los contenidos y no solo la referencia
    @OneToMany(cascade = CascadeType.ALL
            , fetch = FetchType.EAGER, mappedBy = "role")
    @Getter
    @Setter
    private Set<Permiso> permisos;

}
