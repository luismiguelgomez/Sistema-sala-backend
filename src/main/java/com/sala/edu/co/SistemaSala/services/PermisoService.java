package com.sala.edu.co.SistemaSala.services;

import com.sala.edu.co.SistemaSala.dao.PermisoDao;
import com.sala.edu.co.SistemaSala.models.Permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class PermisoService {

    @Autowired
    PermisoDao PermisoDao;

    public List<Permiso> getAll() {
        return PermisoDao.getAll();
    }

    public Permiso get(@PathVariable long id) {
        return PermisoDao.get(id);
    }

    public Permiso register(@RequestBody Permiso Permiso) {
        return PermisoDao.register(Permiso);
    }

    public Permiso update(@RequestBody Permiso Permiso) {
        return PermisoDao.update(Permiso);
    }

    public void delete(@PathVariable long id) {
        PermisoDao.delete(id);
    }

}