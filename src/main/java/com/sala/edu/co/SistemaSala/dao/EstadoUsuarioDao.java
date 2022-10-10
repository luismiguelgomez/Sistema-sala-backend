package com.sala.edu.co.SistemaSala.dao;

import com.sala.edu.co.SistemaSala.models.EstadoUsuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EstadoUsuarioDao {
    /**
     * Trae una lista de tipo EstadoUsuario
     * @return todos los usuarios
     */
    List<EstadoUsuario> getAll();

    /**
     * Trae un solo usuario
     * @param id es el id del usuario a traer
     * @return un usuario segun su id
     */
    EstadoUsuario get(@PathVariable long id);


    /**
     * Pasaremos un usuario como parametro y este
     * sera guardado en base de datos
     * @param EstadoUsuario tiene el cuerpo de un usuario
     * @return el usuario creado
     */
    EstadoUsuario register(@RequestBody EstadoUsuario EstadoUsuario);

    /**
     * Actualizar usuario en base de datos segun parametros enviados
     * @param EstadoUsuario usuario a cambiar
     * @return el usuario cambiado
     */
    EstadoUsuario update(@RequestBody EstadoUsuario EstadoUsuario);

    /**
     * Utilizaremos un parametro para eliminar a un usuario por si id
     * @param id sera utilizado para eliminar usuario tipo long
     */
    void delete(@PathVariable long id) ;
}
