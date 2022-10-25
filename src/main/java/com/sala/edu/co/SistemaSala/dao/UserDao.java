package com.sala.edu.co.SistemaSala.dao;

import com.sala.edu.co.SistemaSala.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserDao {

    User getUserByEmail(@RequestParam String email) throws Exception;

    /**
     * Se buscara por cedula
     * @param cedula String de cedula
     * @return
     */
    User getUserByCC(@RequestBody String cedula) throws Exception;

    /**
     * Trae una lista de tipo User
     * @return todos los usuarios
     */
    List<User> getAll();

    /**
     * Trae un solo usuario
     * @param id es el id del usuario a traer
     * @return un usuario segun su id
     */
    User get(@PathVariable long id);


    /**
     * Pasaremos un usuario como parametro y este
     * sera guardado en base de datos
     * @param user tiene el cuerpo de un usuario
     * @return el usuario creado
     */
    User register(@RequestBody User user);

    /**
     * Actualizar usuario en base de datos segun parametros enviados
     * @param user usuario a cambiar
     * @return el usuario cambiado
     */
    User update(@RequestBody User user);

    User login(User user);

    String perfilAEliminar(String emailToDelete);
}
