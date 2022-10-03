package com.sala.edu.co.SistemaSala.services;

import com.sala.edu.co.SistemaSala.dao.RoleDao;
import com.sala.edu.co.SistemaSala.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDao RoleDao;

    public List<Role> getAll() {
        return RoleDao.getAll();
    }

    public Role get(@PathVariable long id) {
        return RoleDao.get(id);
    }

    public Role register(@RequestBody Role role) {
        return RoleDao.register(role);
    }

    public Role update(@RequestBody Role role) {
        return RoleDao.update(role);
    }

    public void delete(@PathVariable long id) {
        RoleDao.delete(id);
    }

}