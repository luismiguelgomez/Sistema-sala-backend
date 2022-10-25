package com.sala.edu.co.SistemaSala.controllers;

import com.sala.edu.co.SistemaSala.models.User;
import com.sala.edu.co.SistemaSala.services.UserService;
import com.sala.edu.co.SistemaSala.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @CrossOrigin(origins = "http://localhost:8080")
    List<User> getAll() {
        return userService.getAll();
    }

    /**
     * Trae un solo usuario
     * @param id es el id del usuario a traer
     * @return un usuario segun su id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:8080")
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
    @CrossOrigin(origins = "http://localhost:8080")
    ResponseEntity<String> register(@RequestBody User user) {
        // TODO: Registrar en la base de datos al usuario
        try {
            userService.register(user);
        }catch (Exception e) {
            return new ResponseEntity<>("Error al registar el usuario " + e.getMessage() , HttpStatus.PRECONDITION_FAILED);
        }
        return new ResponseEntity<>("Usuario registrado Exitosamente" , HttpStatus.OK);
    }

    /**
     * Actualizar usuario en base de datos segun parametros enviados
     * @param user usuario a cambiar
     * @return el usuario cambiado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:8080")
    User update(@RequestBody User user) {
        // TODO: Actualizar en la base de datos al usuario
        return userService.update(user);
    }

    /**
     * Eliminar un usuario
     * @param email del usuario a eliminar
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:8080")
    ResponseEntity<String> delete(@PathVariable String email, @RequestBody User user) throws Exception {
        // TODO: eliminar en la base de datos al logicamene
        try {
            User usuarioToDelete = userService.delete(email, user);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el usuario " + e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        }
        return new ResponseEntity<>("Usuario eliminado Exitosamente" , HttpStatus.OK);

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8080")
    ResponseEntity<Map<String, Object>> login(@RequestParam String email, @RequestParam String password) throws Exception {
        User user = new User();
        Map<String, Object> result = new HashMap<>();
       try {

           user = userService.findByEmail(email);
           if (user!=null){
               user = userService.login(user.getCedula(), password);
           }


           if (user != null) {
               String token = jwtUtil.create(String.valueOf(user.getId()), user.getEmail());
               result.put("token", token);
               result.put("user", user);
           }
       } catch (Exception e) {
           result.put("token", "");
           result.put("error", "Error al registar el usuario"+e.getMessage());
       } finally {
           return ResponseEntity.ok(result);
       }
    }
}
