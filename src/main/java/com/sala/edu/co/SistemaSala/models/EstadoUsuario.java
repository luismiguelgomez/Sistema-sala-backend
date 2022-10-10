package com.sala.edu.co.SistemaSala.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estadoUsuario")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class EstadoUsuario extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_usuario_id", nullable = false, updatable = false)
    @Getter @Setter
    private Long customerId;

    @Column(name = "estado", nullable = false)
    @Getter
    @Setter
    private String estado;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoUsuario that = (EstadoUsuario) o;
        return Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estado);
    }

    @Override
    public String toString() {
        return "EstadoUsuario{" +
                "estado='" + estado + '\'' +
                '}';
    }
}
