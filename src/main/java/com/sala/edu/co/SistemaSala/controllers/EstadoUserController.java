package com.sala.edu.co.SistemaSala.controllers;


import com.sala.edu.co.SistemaSala.models.EstadoUsuario;
import com.sala.edu.co.SistemaSala.models.User;
import com.sala.edu.co.SistemaSala.services.UserStateService;
import com.sala.edu.co.SistemaSala.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("estado-user-controller")
public class EstadoUserController {

    @Autowired
    UserStateService UserEstadoService;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     *
     * @return todos los EstadoUsuarios
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:8080")
    List<EstadoUsuario> getAll() {
        return UserEstadoService.getAll();
    }

    /**
     * Trae un solo EstadoUsuario
     * @param id es el id del EstadoUsuario a traer
     * @return un EstadoUsuario segun su id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:8080")
    EstadoUsuario get(@PathVariable long id) {
        return UserEstadoService.get(id);
    }

    /**
     * Pasaremos un EstadoUsuario como parametro y este
     * sera guardado en base de datos
     * @param user tiene el cuerpo de un EstadoUsuario
     * @return el EstadoUsuario creado
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8080")
    void register(@RequestBody EstadoUsuario user) {
        // TODO: Registrar en la base de datos al EstadoUsuario
        UserEstadoService.register(user);
    }

    /**
     * Actualizar EstadoUsuario en base de datos segun parametros enviados
     * @param user EstadoUsuario a cambiar
     * @return el EstadoUsuario cambiado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:8080")
    EstadoUsuario update(@RequestBody EstadoUsuario user) {
        // TODO: Actualizar en la base de datos al EstadoUsuario
        return UserEstadoService.update(user);
    }

    /**
     * Eliminar un EstadoUsuario
     * @param id del EstadoUsuario a eliminar
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:8080")
    void delete(@PathVariable long id) {
        // TODO: eliminar en la base de datos al EstadoUsuario
        UserEstadoService.delete(id);
    }

}
