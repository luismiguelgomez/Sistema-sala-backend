package com.sala.edu.co.SistemaSala.dao;

import com.sala.edu.co.SistemaSala.models.Role;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface RoleDao {
    /**
     * Trae una lista de tipo Role
     * @return todos los usuarios
     */
    List<Role> getAll();

    /**
     * Trae un solo usuario
     * @param id es el id del usuario a traer
     * @return un usuario segun su id
     */
    Role get(@PathVariable long id);


    /**
     * Pasaremos un usuario como parametro y este
     * sera guardado en base de datos
     * @param Role tiene el cuerpo de un usuario
     * @return el usuario creado
     */
    Role register(@RequestBody Role Role);

    /**
     * Actualizar usuario en base de datos segun parametros enviados
     * @param Role usuario a cambiar
     * @return el usuario cambiado
     */
    Role update(@RequestBody Role Role);

    /**
     * Utilizaremos un parametro para eliminar a un usuario por si id
     * @param id sera utilizado para eliminar usuario tipo long
     */
    void delete(@PathVariable long id) ;
}
