package com.sala.edu.co.SistemaSala.dao;

import com.sala.edu.co.SistemaSala.models.Permiso;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface PermisoDao {
    /**
     * Trae una lista de tipo Permiso
     * @return todos los usuarios
     */
    List<Permiso> getAll();

    /**
     * Trae un solo usuario
     * @param id es el id del usuario a traer
     * @return un usuario segun su id
     */
    Permiso get(@PathVariable long id);


    /**
     * Pasaremos un usuario como parametro y este
     * sera guardado en base de datos
     * @param Permiso tiene el cuerpo de un usuario
     * @return el usuario creado
     */
    Permiso register(@RequestBody Permiso Permiso);

    /**
     * Actualizar usuario en base de datos segun parametros enviados
     * @param Permiso usuario a cambiar
     * @return el usuario cambiado
     */
    Permiso update(@RequestBody Permiso Permiso);

    /**
     * Utilizaremos un parametro para eliminar a un usuario por si id
     * @param id sera utilizado para eliminar usuario tipo long
     */
    void delete(@PathVariable long id) ;
}
