package com.sala.edu.co.SistemaSala.controllers;

import com.sala.edu.co.SistemaSala.models.User;
import com.sala.edu.co.SistemaSala.services.UserService;
import com.sala.edu.co.SistemaSala.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     *
     * @return todos los usuarios
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> getAll() {
        return userService.getAll();
    }

    /**
     * Trae un solo usuario
     * @param id es el id del usuario a traer
     * @return un usuario segun su id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User get(@PathVariable long id) {
        return userService.get(id);
    }

    /**
     * Pasaremos un usuario como parametro y este
     * sera guardado en base de datos
     * @param user tiene el cuerpo de un usuario
     * @return el usuario creado
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    void register(@RequestBody User user) {
        // TODO: Registrar en la base de datos al usuario
        userService.register(user);
    }

    /**
     * Actualizar usuario en base de datos segun parametros enviados
     * @param user usuario a cambiar
     * @return el usuario cambiado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    User update(@RequestBody User user) {
        // TODO: Actualizar en la base de datos al usuario
        return userService.update(user);
    }

    /**
     * Eliminar un usuario
     * @param id del usuario a eliminar
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        // TODO: eliminar en la base de datos al usuario
        userService.delete(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Map<String, Object> login(@RequestBody User dtoUser){
        User user = userService.login(dtoUser);

        Map<String, Object> result = new HashMap<>();
        if (user != null) {
            String token = jwtUtil.create(String.valueOf(user.getId()), user.getEmail());
            result.put("token", token);
            result.put("user", user);
        }
        return result;
    }
}
