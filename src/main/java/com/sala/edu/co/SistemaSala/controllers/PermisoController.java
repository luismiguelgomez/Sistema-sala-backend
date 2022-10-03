package com.sala.edu.co.SistemaSala.controllers;

import com.sala.edu.co.SistemaSala.models.Permiso;
import com.sala.edu.co.SistemaSala.services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permiso")
public class PermisoController {
    @Autowired
    PermisoService permisoService;

    /**
     *
     * @return todos los permisos
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Permiso> getAll() {
        return permisoService.getAll();
    }

    /**
     * Trae un solo permiso
     * @param id es el id del permiso a traer
     * @return un permiso segun su id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Permiso get(@PathVariable long id) {
        return permisoService.get(id);
    }

    /**
     * Pasaremos un permiso como parametro y este
     * sera guardado en base de datos
     * @param
     * tiene el cuerpo de un permiso
     * @return el permiso creado
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Permiso register(@RequestBody Permiso permiso) {
        // TODO: Registrar en la base de datos al permiso
        return permisoService.register(permiso);
    }

    /**
     * Actualizar permiso en base de datos segun parametros enviados
     * @param Permiso permiso a cambiar
     * @return el permiso cambiado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Permiso update(@RequestBody Permiso permiso) {
        // TODO: Actualizar en la base de datos al permiso
        return permisoService.update(permiso);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        // TODO: eliminar en la base de datos al permiso
        permisoService.delete(id);
    }
}
