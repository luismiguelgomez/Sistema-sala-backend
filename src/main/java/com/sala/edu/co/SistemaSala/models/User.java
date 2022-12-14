package com.sala.edu.co.SistemaSala.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.Size;


@Entity
@Table(name = "user")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    @Getter @Setter
    private long id;

    //JsonProperty sirve para ofrecerle el acceso, en este caso NO se puede escribir
    @ManyToOne
    @JoinColumn(name="role_id", nullable = false)
    @Getter
    @Setter
    private Role role;

    @ManyToOne
    @JoinColumn(name = "estado_usuario_id", nullable = false)
    @Getter
    @Setter
    private EstadoUsuario estadoUsuarios;

    //Utilizamos la anotacion de JsonProperty para que en este caso solo se pueda escribir y no leer
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    @Size(min = 8)
    @Getter @Setter
    private String password;


    @Column(name = "cedula", unique = true, nullable = false, length = 10)
    @Size(min = 9, max = 10)
    @Getter @Setter
    private String cedula;

    @Column(name = "nombre", nullable = false)
    @Getter @Setter
    private String nombre;

    @Column(name = "apellido", nullable = false)
    @Getter @Setter
    private String apellido;

    @Column(name = "email", unique = true)
    @Getter @Setter
    private String email;

    @Column(name = "telefono", unique = true)
    @Size(min = 7, max = 10)
    @Getter @Setter
    private String telefono;

    @Column(name = "fecha_nac")
    @Getter @Setter
    private Date fechaNac;

    @Column(name = "edad")
    @Getter @Setter
    private String edad;

    @Column(name = "sexo")
    @Getter @Setter
    private String sexo;

    @Column(name = "direccion")
    @Getter @Setter
    private String direccion;

}
