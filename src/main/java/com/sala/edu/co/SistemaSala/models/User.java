package com.sala.edu.co.SistemaSala.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{


    //JsonProperty sirve para ofrecerle el acceso, en este caso NO se puede escribir
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="role_id")
    @Getter @Setter
    private Role role;

    //Utilizamos la anotacion de JsonProperty para que en este caso solo se pueda escribir y no leer
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    @Getter @Setter
    private String password;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @Column(name = "apellido")
    @Getter @Setter
    private String apellido;

    @Column(name = "email")
    @Getter @Setter
    private String email;

    @Column(name = "telefono")
    @Getter @Setter
    private String telefono;

    @Column(name = "fecha_nac")
    @Getter @Setter
    private Date fechaNac;

}
