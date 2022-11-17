package com.sala.edu.co.SistemaSala.services;

import com.sala.edu.co.SistemaSala.dao.UserDao;
import com.sala.edu.co.SistemaSala.models.EstadoUsuario;
import com.sala.edu.co.SistemaSala.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User findByEmail(@RequestParam String email) throws Exception {
        User user = new User();
        try {
            user = userDao.getUserByEmail(email);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return user;
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User get(@PathVariable long id) {
        return userDao.get(id);
    }

    public void register(User user) throws Exception {
        try {
            String hash = generarHash(user.getPassword());
            user.setPassword(hash);
            userDao.register(user);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public User update(@RequestBody User user) {
        return userDao.update(user);
    }

    public User delete(String emailToDelete, User user) throws Exception {
        User userToDelete = new User();
        //Validation of user what modifity other user
        boolean validacionPerfil = validacionPerfil(user);
        if (validacionPerfil) {
            try {
                userToDelete = userDao.getUserByCC(emailToDelete);
                EstadoUsuario estadoUsuarios = userToDelete.getEstadoUsuarios();
                estadoUsuarios.setEstado(user.getEstadoUsuarios().getEstado());
                userToDelete.setEstadoUsuarios(estadoUsuarios);
                userDao.update(userToDelete);
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            } finally {
                return userToDelete;
            }
        }
       return userToDelete;
    }

    private boolean validacionPerfil(User user) {
        boolean userIsOk = false;
        return userIsOk = user.getRole().getNombre().equals("SuperAdmin") || user.getRole().getNombre().equals("Admin")?true:false;
    }

    private String generarHash(String password) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(4, 1024 * 1024, 8, password);
        return argon2.hash(1, 1024 * 1, 1, password);
    }


    public User login(String cedula, String password) throws Exception {
        User usermodel;
        try {
            usermodel = userDao.getUserByCC(cedula);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        if (usermodel != null){
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
           // String hash = argon2.hash(4, 1024 * 1024, 8, user.getPassword());
            boolean success = argon2.verify(usermodel.getPassword(), password);

            if (success) {
                return userDao.login(usermodel);
            } else {
                usermodel = null;
            }
        } else {
            usermodel = null;
        }
        return usermodel;
    }
}