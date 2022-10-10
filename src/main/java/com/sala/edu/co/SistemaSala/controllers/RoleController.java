package com.sala.edu.co.SistemaSala.controllers;

import com.sala.edu.co.SistemaSala.models.Role;
import com.sala.edu.co.SistemaSala.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rol")
public class RoleController {
    @Autowired
    RoleService roleService;

    /**
     *
     * @return todos los roles
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:8080")
    List<Role> getAll() {
        return roleService.getAll();
    }

    /**
     * Trae un solo rol
     * @param id es el id del rol a traer
     * @return un rol segun su id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:8080")
    Role get(@PathVariable long id) {
        return roleService.get(id);
    }

    /**
     * Pasaremos un rol como parametro y este
     * sera guardado en base de datos
     * @param Role tiene el cuerpo de un rol
     * @return el rol creado
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8080")
    Role register(@RequestBody Role role) {
        // TODO: Registrar en la base de datos al usuario
        return roleService.register(role);
    }

    /**
     * Actualizar rol en base de datos segun parametros enviados
     * @param rol usuario a cambiar
     * @return el usuario cambiado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:8080")
    Role update(@RequestBody Role role) {
        // TODO: Actualizar en la base de datos al usuario
        return roleService.update(role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:8080")
    void delete(@PathVariable long id) {
        // TODO: eliminar en la base de datos al usuario
        roleService.delete(id);
    }
}
