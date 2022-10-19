package com.sala.edu.co.SistemaSala.services;

import com.sala.edu.co.SistemaSala.dao.UserDao;
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

    public void delete(@PathVariable long id) {
        userDao.delete(id);
    }

    private String generarHash(String password) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.hash(1, 1024 * 1, 1, password);
    }

    public User login(User user) throws Exception {
        User usermodel;
        try {
            usermodel = userDao.getUserByCC(user.getCedula());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        if (usermodel != null){
            String hash = generarHash(user.getPassword());
            System.out.println("hash" + hash);
            String userDb = usermodel.getPassword();
            System.out.println("bd" + userDb);
            if (userDb ==hash) {
                return userDao.login(user);
            }
        } else {
            User usuario = new User();
            return usuario;
        }
        return usermodel;
    }
}