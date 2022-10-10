package com.sala.edu.co.SistemaSala.services;

import com.sala.edu.co.SistemaSala.dao.EstadoUsuarioDao;
import com.sala.edu.co.SistemaSala.models.EstadoUsuario;
import com.sala.edu.co.SistemaSala.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserStateService {
    @Autowired
    EstadoUsuarioDao estadoUsuarioDao;

    public List<EstadoUsuario> getAll() {
        return estadoUsuarioDao.getAll();
    }

    public EstadoUsuario get(@PathVariable long id) {
        return estadoUsuarioDao.get(id);
    }

    public void register(EstadoUsuario user) {
        estadoUsuarioDao.register(user);
    }

    public EstadoUsuario update(@RequestBody EstadoUsuario user) {
        return estadoUsuarioDao.update(user);
    }

    public void delete(@PathVariable long id) {
        estadoUsuarioDao.delete(id);
    }

}
