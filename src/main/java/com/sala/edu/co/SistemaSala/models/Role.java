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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", updatable = false, nullable = false)
    @Getter @Setter
    private long id;

    @Column(name = "nombre", unique = true, nullable = false)
    @Getter
    @Setter
    private String nombre;

}
